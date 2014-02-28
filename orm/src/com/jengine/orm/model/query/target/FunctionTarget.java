package com.jengine.orm.model.query.target;


import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.field.Field;
import com.jengine.orm.model.field.FunctionField;
import com.jengine.orm.model.multi.MultiModelField;
import com.jengine.orm.model.query.ModelQuery;

import java.util.Iterator;
import java.util.LinkedHashMap;

import static com.jengine.utils.CollectionUtil.toList;

public class FunctionTarget extends Target {
    private FunctionField field;
    private MultiModelField multiModelField;
    private LinkedHashMap<String, MultiModelField> attributeFields = new LinkedHashMap<String, MultiModelField>();
    private LinkedHashMap<String, MultiModelField> sqlAttributes = new LinkedHashMap<String, MultiModelField>();

    public FunctionTarget(FunctionField field) {
        this(field.getFieldName(), field);
    }

    public FunctionTarget(String name, FunctionField field) {
        super(name);
        this.field = field;
    }

    public void config(ModelQuery modelQuery) {
        super.config(modelQuery);
        this.multiModelField = modelQuery._registerField(name, field);
        for (Object attribute : field.getAttributes()) {
            MultiModelField multiModelField = attribute instanceof  String ?
                    modelQuery._registerField((String) attribute) : modelQuery._registerField((Field) attribute);
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
