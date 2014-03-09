package com.jengine.orm.model.multi;


import com.jengine.orm.DB;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.field.reference.ReferenceField;
import com.jengine.utils.expression.ExpressionData;
import com.jengine.utils.expression.ExpressionNode;
import com.jengine.utils.expression.ExpressionOperation;

import java.util.*;

import static com.jengine.utils.CollectionUtil.toList;

public class MultiModel {
    protected LinkedHashMap<String, MultiModelItem> items = new LinkedHashMap<String, MultiModelItem>();
    protected LinkedHashMap<String, MultiModelField> fields = new LinkedHashMap<String, MultiModelField>();
    protected ExpressionNode expression;
    protected Map<String, Integer> _modelCounters = new HashMap<String, Integer>();

    public MultiModel(ModelClassBase model) {
        MultiModelItem item = add(new MultiModelItem(this, model, model.getName()));
        expression =  new MultiModelNode(item);
    }

    public MultiModel(ModelClassBase model, String name) {
        add(new MultiModelItem(this, model, name));
    }

    public DB getDB() {
        return getItemList().get(0).getModelClass().getDb();
    }

    /* model operations */

    public MultiModel join(ModelClassBase model) {
        MultiModelField field = findReferenceField(model.getName());
        if (field != null) {
            join(model, model.getName() + "." + ((ReferenceField)field.getModelField()).getReferenceModelKey().getFieldName(), field.getName());
        }
        return this;
    }

    public MultiModel join(ModelClassBase model, String reference, String key) {
        return join(model, makeItemName(model.getName()), reference, key);
    }

    public MultiModel join(ModelClassBase model, String name, String reference, String key) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        expression = new Join(expression, new MultiModelNode(item), fields.get(reference), fields.get(key));
        return this;
    }

    /* left join operations */
    public MultiModel ljoin(ModelClassBase model) {
        MultiModelField field = findReferenceField(model.getName());
        if (field != null) {
            ljoin(model, model.getName() + "." + ((ReferenceField)field.getModelField()).getReferenceModelKey().getFieldName(), field.getName());
        }
        return this;
    }

    public MultiModel ljoin(ModelClassBase model, String reference, String key) {
        return ljoin(model, makeItemName(model.getName()), reference, key);
    }

    public MultiModel ljoin(ModelClassBase model, String name, String reference, String key) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        expression = new LeftJoin(expression, new MultiModelNode(item), fields.get(reference), fields.get(key));
        return this;
    }

    /* right join operations */
    public MultiModel rjoin(ModelClassBase model) {
        MultiModelField field = findReferenceField(model.getName());
        if (field != null) {
            rjoin(model, model.getName() + "." + ((ReferenceField)field.getModelField()).getReferenceModelKey().getFieldName(), field.getName());
        }
        return this;
    }

    public MultiModel rjoin(ModelClassBase model, String reference, String key) {
        return rjoin(model, makeItemName(model.getName()), reference, key);
    }

    public MultiModel rjoin(ModelClassBase model, String name, String reference, String key) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        expression = new RightJoin(expression, new MultiModelNode(item), fields.get(reference), fields.get(key));
        return this;
    }

    public MultiModel and(ModelClassBase model) {
        return and(model, makeItemName(model.getName()));
    }

    public MultiModel and(ModelClassBase model, String name) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        expression = new And(expression, new MultiModelNode(item));
        return this;
    }

    protected MultiModelItem add(MultiModelItem item) {
        items.put(item.getName(), item);
        fields.putAll(item.getFields());
        return item;
    }

    public SQLQuery.Table getMultiTable() {
        List<SQLQuery.TableItem> tableItems = getTableItems();
        ExpressionNode expressionNode  = makeSQLExpression();
        return new SQLQuery.Table(tableItems, expressionNode);
    }

    protected ExpressionNode makeSQLExpression() {
        return expression instanceof MultiModelNode ?
                ((MultiModelNode) expression).toSQL() :
                ((ModelOperation) expression).toSQL();
    }

    protected List<SQLQuery.TableItem> getTableItems() {
        List<SQLQuery.TableItem> items = new ArrayList<SQLQuery.TableItem>();

        for (MultiModelItem modelItem : this.items.values()) {
            items.add(modelItem.getTableItem());
        }

        return items;
    }

    protected String makeItemName(String modelName) {
        String name = modelName;

        if (items.containsKey(modelName)) {
            Integer modelCounter = _modelCounters.get(name) + 1;
            name = String.format("%s%s", modelName, modelCounter);
            _modelCounters.put(name, modelCounter);
        }

        return name;
    }

    protected MultiModelField findReferenceField(String modelName) {
        for (MultiModelField field : fields.values()) {
            if (field.getModelField() instanceof ReferenceField) {
                ReferenceField reference = (ReferenceField) field.getModelField();
                if (reference.getReferenceModelName().equals(modelName)) {
                    return field;
                }
            }
        }
        return null;
    }
//    protected MultiModelItem getItemByModel(String modelName) {
//        for (MultiModelItem item : items.values()) {
//            if (item.getModelClass().getName().equals(modelName)) {
//                return item;
//            }
//        }
//
//        return null;
//    }

    /* getters and setters */

    public List<MultiModelItem> getItemList() {
        return toList(items.values());
    }

    public LinkedHashMap<String, MultiModelItem> getItems() {
        return items;
    }

    public LinkedHashMap<String, MultiModelField> getFields() {
        return fields;
    }

    public List<MultiModelField> getFieldList() {
        return toList(fields.values());
    }

    /* inner classes */

    public static class MultiModelNode extends ExpressionData<MultiModelItem> {

        public MultiModelNode(MultiModelItem data) {
            super(data);
        }

        public SQLQuery.TableItem getTableItem() {
            return getData().getTableItem();
        }

        public ExpressionData<SQLQuery.TableItem> toSQL() {
            return new ExpressionData<SQLQuery.TableItem>(getTableItem());
        }
    }

    public static class ModelOperation extends ExpressionOperation {
        public ModelOperation(List<ExpressionNode> nodes) {
            super(nodes);
        }

        public ModelOperation(ExpressionNode... nodes) {
            super(nodes);
        }

        public ExpressionOperation toSQL() {
            return null;
        }

        protected ExpressionNode toSQL(ExpressionNode node) {
            return node instanceof MultiModelNode ? ((MultiModelNode) node).toSQL() : ((ModelOperation) node).toSQL();
        }
    }

    public static class Group extends ModelOperation {

        public Group(ExpressionNode expressionNode) {
            super(expressionNode);
        }

        public ExpressionNode getChild() {
            return nodes.get(0);
        }

        public ExpressionOperation toSQL() {
            return new SQLQuery.Group(toSQL(getChild()));
        }
    }

    public static class Join extends ModelOperation {
        private MultiModelField reference;
        private MultiModelField key;

        public Join(ExpressionNode operand1, ExpressionNode operand2, MultiModelField reference, MultiModelField key) {
            super(operand1, operand2);
            this.reference = reference;
            this.key = key;
        }

        public ExpressionNode getLeftNode() {
            return nodes.get(0);
        }

        public ExpressionNode getJoinNode() {
            return nodes.get(1);
        }

        public ExpressionOperation toSQL() {
            return new SQLQuery.Join(toSQL(getLeftNode()), toSQL(getJoinNode()), makeSQLRestriction());
        }

        protected String makeSQLRestriction() {
            return String.format("%s = %s", reference.getSQLName(), key.getSQLName());
        }
    }

    public static class LeftJoin extends Join {
        public LeftJoin(ExpressionNode operand1, ExpressionNode operand2, MultiModelField reference, MultiModelField key) {
            super(operand1, operand2, reference, key);
        }

        public ExpressionOperation toSQL() {
            return new SQLQuery.LeftJoin(toSQL(getLeftNode()), toSQL(getJoinNode()), makeSQLRestriction());
        }
    }

    public static class RightJoin extends Join {
        public RightJoin(ExpressionNode operand1, ExpressionNode operand2, MultiModelField reference, MultiModelField key) {
            super(operand1, operand2, reference, key);
        }

        public ExpressionOperation toSQL() {
            return new SQLQuery.RightJoin(toSQL(getLeftNode()), toSQL(getJoinNode()), makeSQLRestriction());
        }
    }

    public static class And extends ModelOperation {
        public And(ExpressionNode operand1, ExpressionNode operand2) {
            super(operand1, operand2);
        }

        public ExpressionOperation toSQL() {
            return new SQLQuery.And(toSQL(getNodes().get(0)), toSQL(getNodes().get(1)));
        }
    }
}
