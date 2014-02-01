package com.jengine.orm.query.target;


import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.field.Field;
import com.jengine.orm.field.ForeignField;
import com.jengine.orm.field.FunctionField;
import com.jengine.orm.multi.MultiModelField;
import com.jengine.orm.query.ModelQuery;

import java.util.Iterator;
import java.util.LinkedHashMap;

import static com.jengine.utils.CollectionUtil.toList;

public class FunctionTarget extends Target {
    private FunctionField field;
    private LinkedHashMap<String, MultiModelField> attributeFields = new LinkedHashMap<String, MultiModelField>();
    private LinkedHashMap<String, MultiModelField> sqlAttributes = new LinkedHashMap<String, MultiModelField>();

    public FunctionTarget(ModelQuery modelQuery, FunctionField field) {
        super(modelQuery);
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

    public void setSQL(SQLQuery query) {
        query.addTarget(field.render(toList(sqlAttributes.keySet())), field.getFieldName());
    }

    public Object processResult(Iterator itr) throws DBException {
        return field.cast(super.processResult(itr));
    }

}
