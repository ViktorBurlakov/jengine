package com.jengine.orm.model.multi;


import com.jengine.orm.DB;
import com.jengine.orm.DBFactory;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.ModelClassBase;
import com.jengine.orm.model.field.reference.ReferenceField;
import com.jengine.orm.model.multi.parser.ExprLexer;
import com.jengine.orm.model.multi.parser.ExprParser;
import com.jengine.utils.expression.ExpressionData;
import com.jengine.utils.expression.ExpressionNode;
import com.jengine.utils.expression.ExpressionOperation;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.util.*;

import static com.jengine.utils.CollectionUtil.list;
import static com.jengine.utils.CollectionUtil.toList;

public class MultiModel {
    protected LinkedHashMap<String, MultiModelItem> items = new LinkedHashMap<String, MultiModelItem>();
    protected LinkedHashMap<String, MultiModelField> fields = new LinkedHashMap<String, MultiModelField>();
    protected ExpressionNode expression;
    protected Map<String, Integer> _modelCounters = new HashMap<String, Integer>();
    protected DB db;

    public MultiModel(String expr) throws RecognitionException {
        db = DBFactory.get();
        expression = parse(expr);
    }

    public MultiModel(DB db, String expr) throws RecognitionException {
        this.expression = parse(expr);
        this.db = db;
    }

    public MultiModel(ModelClassBase model) {
        MultiModelItem item = add(new MultiModelItem(this, model, model.getName()));
        expression =  new MultiModelNode(item);
        db = model.getDb();
    }

    public MultiModel(ModelClassBase model, String name) {
        add(new MultiModelItem(this, model, name));
        db = model.getDb();
    }

    public DB getDB() {
        return db;
    }

    public MultiModel alias(String itemName, String alias) {
        MultiModelItem item = items.get(itemName);
        items.put(alias, item);
        for (MultiModelField field : item.getFields().values()) {
            fields.put(alias + "." + field.getModelField().getFieldName(), field);
        }
        return this;
    }

    /* model operations */

    public MultiModel join(ModelClassBase model, String reference, String key) {
        return join(model, makeItemName(model), reference, key);
    }

    public MultiModel join(ModelClassBase model, String name, String reference, String key) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        expression = new InnerJoin(expression, new MultiModelNode(item), fields.get(reference), fields.get(key));
        return this;
    }

    public MultiModel join(ModelClassBase model) {
        MultiModelItem item = add(new MultiModelItem(this, model, makeItemName(model)));
        String[] keys = calcRestrictionKeys(toList(items.values()), item);
        expression = new InnerJoin(expression, new MultiModelNode(item), fields.get(keys[0]), fields.get(keys[1]));
        return this;
    }

    /* left join operations */

    public MultiModel ljoin(ModelClassBase model, String reference, String key) {
        return ljoin(model, makeItemName(model), reference, key);
    }

    public MultiModel ljoin(ModelClassBase model, String name, String reference, String key) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        expression = new LeftJoin(expression, new MultiModelNode(item), fields.get(reference), fields.get(key));
        return this;
    }

    public MultiModel ljoin(ModelClassBase model) {
        MultiModelItem item = add(new MultiModelItem(this, model, makeItemName(model)));
        String[] keys = calcRestrictionKeys(toList(items.values()), item);
        expression = new LeftJoin(expression, new MultiModelNode(item), fields.get(keys[0]), fields.get(keys[1]));
        return this;
    }

    /* right join operations */

    public MultiModel rjoin(ModelClassBase model, String reference, String key) {
        return rjoin(model, makeItemName(model), reference, key);
    }

    public MultiModel rjoin(ModelClassBase model, String name, String reference, String key) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        expression = new RightJoin(expression, new MultiModelNode(item), fields.get(reference), fields.get(key));
        return this;
    }

    public MultiModel rjoin(ModelClassBase model) {
        MultiModelItem item = add(new MultiModelItem(this, model, makeItemName(model)));
        String[] keys = calcRestrictionKeys(toList(items.values()), item);
        expression = new RightJoin(expression, new MultiModelNode(item), fields.get(keys[0]), fields.get(keys[1]));
        return this;
    }

    /* full join operations */

    public MultiModel fjoin(ModelClassBase model, String reference, String key) {
        return rjoin(model, makeItemName(model), reference, key);
    }

    public MultiModel fjoin(ModelClassBase model, String name, String reference, String key) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        expression = new FullJoin(expression, new MultiModelNode(item), fields.get(reference), fields.get(key));
        return this;
    }

    public MultiModel fjoin(ModelClassBase model) {
        MultiModelItem item = add(new MultiModelItem(this, model, makeItemName(model)));
        String[] keys = calcRestrictionKeys(toList(items.values()), item);
        expression = new FullJoin(expression, new MultiModelNode(item), fields.get(keys[0]), fields.get(keys[1]));
        return this;
    }

    /* cross join operations */

    public MultiModel and(ModelClassBase model) {
        return and(model, makeItemName(model));
    }

    public MultiModel and(ModelClassBase model, String name) {
        MultiModelItem item = add(new MultiModelItem(this, model, name));
        expression = new And(expression, new MultiModelNode(item));
        return this;
    }

    protected String[] calcRestrictionKeys(List<MultiModelItem> items, List<MultiModelItem> joinItems) {
        for (MultiModelItem joinItem : joinItems) {
            String[] result = calcRestrictionKeys(items, joinItem);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    protected String[] calcRestrictionKeys(List<MultiModelItem> items, MultiModelItem joinItem) {
        String[] result = new String[2];

        for (MultiModelItem item : items) {
            if (item.getName().equals(joinItem.getName())) {
                continue;
            }
            ModelClassBase modelClass = item.getModelClass();
            HashMap<String, ReferenceField> referenceModels = modelClass.getManager().getReferenceModels();
            if (referenceModels.containsKey(joinItem.getModelClass().getName())) {
                ReferenceField referenceField = referenceModels.get(joinItem.getModelClass().getName());
                result[0] = joinItem.getMultiModelField(referenceField.getReferenceModelKey()).getName();
                result[1] = item.getMultiModelField(referenceField).getName();
                return result;
            }
        }

        return null;
    }

    protected MultiModelItem add(MultiModelItem item) {
        items.put(item.getName(), item);
        fields.putAll(item.getFields());
        _modelCounters.put(item.getModelClass().getName(), 0);
        return item;
    }

    /* SQL methods*/

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

    protected String makeItemName(ModelClassBase modelClass) {
        String name = modelClass.getName();

        if (items.containsKey(name)) {
            Integer modelCounter = _modelCounters.get(name) + 1;
            name = String.format("%s%s", name, modelCounter);
            _modelCounters.put(name, modelCounter);
        }

        return name;
    }

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

    public ExpressionNode getExpression() {
        return expression;
    }

    /* parsing methods */
    public ExpressionNode parse(String modelExpression) throws RecognitionException {
        ANTLRStringStream in = new ANTLRStringStream(modelExpression);
        ExprLexer lexer = new ExprLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        CommonTree tree = (CommonTree) parser.model_expression().getTree();
        return visit(tree);
    }

    protected ExpressionNode visit(Tree tree) {
        if (tree.getType() == ExprParser.GROUP) {
            return new Group(visit(tree.getChild(0)));
        } else if (tree.getType() == ExprParser.MODEL_NAME) {
            String modelClassName = tree.getChild(0).getText();
            ModelClassBase modelClass = getDB().getModelClass(modelClassName);
            MultiModelItem item = add(new MultiModelItem(this, modelClass, makeItemName(modelClass)));
            return new MultiModelNode(item);
        } else if (tree.getType() == ExprParser.RIGHT_JOIN) {
            ExpressionNode operand1 = visit(tree.getChild(0));
            ExpressionNode operand2 = visit(tree.getChild(1));
            String[] keys = calcRestrictionKeys(getMultiModelItems(operand2), getMultiModelItems(operand1));
            keys = keys != null ?  keys : calcRestrictionKeys(getMultiModelItems(operand1), getMultiModelItems(operand2));
            return new RightJoin(operand1, operand2, fields.get(keys[0]), fields.get(keys[1]));
        } else if (tree.getType() == ExprParser.LEFT_JOIN) {
            ExpressionNode operand1 = visit(tree.getChild(0));
            ExpressionNode operand2 = visit(tree.getChild(1));
            String[] keys = calcRestrictionKeys(getMultiModelItems(operand1), getMultiModelItems(operand2));
            keys = keys != null ?  keys : calcRestrictionKeys(getMultiModelItems(operand2), getMultiModelItems(operand1));
            return new LeftJoin(operand1, operand2, fields.get(keys[0]), fields.get(keys[1]));
        } else if (tree.getType() == ExprParser.FULL_JOIN) {
            ExpressionNode operand1 = visit(tree.getChild(0));
            ExpressionNode operand2 = visit(tree.getChild(1));
            String[] keys = calcRestrictionKeys(getMultiModelItems(operand1), getMultiModelItems(operand2));
            keys = keys != null ?  keys : calcRestrictionKeys(getMultiModelItems(operand2), getMultiModelItems(operand1));
            return new FullJoin(operand1, operand2, fields.get(keys[0]), fields.get(keys[1]));
        } else if (tree.getType() == ExprParser.INNER_JOIN) {
            ExpressionNode operand1 = visit(tree.getChild(0));
            ExpressionNode operand2 = visit(tree.getChild(1));
            String[] keys = calcRestrictionKeys(getMultiModelItems(operand1), getMultiModelItems(operand2));
            keys = keys != null ?  keys : calcRestrictionKeys(getMultiModelItems(operand2), getMultiModelItems(operand1));
            return new InnerJoin(operand1, operand2, fields.get(keys[0]), fields.get(keys[1]));
        } else if (tree.getType() == ExprParser.AND) {
            ExpressionNode operand1 = visit(tree.getChild(0));
            ExpressionNode operand2 = visit(tree.getChild(1));
            return new And(operand1, operand2);
        }
        return null;
    }

    protected List<MultiModelItem> getMultiModelItems(ExpressionNode node) {
        return node instanceof MultiModelNode ?
                list(((MultiModelNode) node).getData()) :
                ((ModelOperation) node).getMultiModelItems();
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

        protected List<MultiModelItem> getMultiModelItems() {
            List<MultiModelItem> items = new ArrayList<MultiModelItem>();

            for (ExpressionNode node : nodes) {
                if (node instanceof MultiModelNode) {
                    items.add(((MultiModelNode) node).getData());
                } else {
                    items.addAll(((ModelOperation) node).getMultiModelItems());
                }
            }

            return items;
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

    public static abstract class Join extends ModelOperation {
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

        abstract public ExpressionOperation toSQL();

        protected String makeSQLRestriction() {
            return String.format("%s = %s", reference.getSQLName(), key.getSQLName());
        }
    }

    public static class InnerJoin extends Join {

        public InnerJoin(ExpressionNode operand1, ExpressionNode operand2, MultiModelField reference, MultiModelField key) {
            super(operand1, operand2, reference, key);
        }

        public ExpressionOperation toSQL() {
            return new SQLQuery.Join(toSQL(getLeftNode()), toSQL(getJoinNode()), makeSQLRestriction());
        }

    }

    public static class FullJoin extends Join {

        public FullJoin(ExpressionNode operand1, ExpressionNode operand2, MultiModelField reference, MultiModelField key) {
            super(operand1, operand2, reference, key);
        }

        public ExpressionOperation toSQL() {
            return new SQLQuery.FullJoin(toSQL(getLeftNode()), toSQL(getJoinNode()), makeSQLRestriction());
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
