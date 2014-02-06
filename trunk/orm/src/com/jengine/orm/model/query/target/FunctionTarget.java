package com.jengine.orm.model.query.target;


import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.ForeignField;
import com.jengine.orm.model.field.FunctionField;
import com.jengine.orm.model.multi.MultiModelField;
import com.jengine.orm.model.query.ModelQuery;

import java.util.Iterator;
import java.util.LinkedHashMap;

import static com.jengine.utils.CollectionUtil.toList;

public class FunctionTarget extends Target {
    private FunctionField field;
    private LinkedHashMap<String, MultiModelField> attributeFields = new LinkedHashMap<String, MultiModelField>();
    private LinkedHashMap<String, MultiModelField> sqlAttributes = new LinkedHashMap<String, MultiModelField>();

    public FunctionTarget(ModelQuery modelQuery, FunctionField field) {
        this(modelQuery, field.getFieldName(), field);
    }

    public FunctionTarget(ModelQuery modelQuery, String name, FunctionField field) {
        super(modelQuery, name);
        this.field = field;
        for (Object attribute : field.getAttributes()) {
            Field attributeField  =  attribute.getClass().equals(String.class) ?
                    modelQuery.getManager().getField((String) attribute) : (Field) attribute;
            if (attributeField instanceof ForeignField) {
                modelQuery.addPath(((ForeignField) attributeField).getReferencePath());
            }
            MultiModelField multiModelField = modelQuery.getMultiModelField(attributeField);
            attributeFields.put(multiModelField.getName(), multiModelField);
            sqlAttributes.put(multiModelField.getSQLName(), multiModelField);
        }
    }

    public String getSQLName() {
        return field.getFieldName();
    }

    public void setSQL(SQLQuery query) {
        query.addTarget(field.render(toList(sqlAttributes.keySet())), field.getFieldName());
    }

    public Object processResult(Iterator itr) throws DBException {
        return field.cast(super.processResult(itr));
    }

}
