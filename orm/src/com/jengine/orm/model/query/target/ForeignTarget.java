package com.jengine.orm.model.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.field.ForeignField;
import com.jengine.orm.model.field.reference.ReferenceField;
import com.jengine.orm.model.multi.MultiModelField;
import com.jengine.orm.model.query.ModelQuery;

import java.util.Iterator;

public class ForeignTarget extends Target {
    private Target target;
    private ForeignField field;

    public ForeignTarget(ForeignField field) {
        this(field.getFieldName(), field);
    }

    public ForeignTarget(String name, ForeignField field) {
        super(name);
        this.field = field;
    }

    public void config(ModelQuery modelQuery) {
        super.config(modelQuery);
        MultiModelField multiModelField = modelQuery._registerField(field);
        this.target = (field.getActualField() instanceof ReferenceField) ?
                new ModelTarget(name, modelQuery.getMultiModel().getItems().get(field.getFieldName())):
                new FieldTarget(name, multiModelField);
        this.target.config(modelQuery);
    }

    public Object processResult(Iterator itr) throws DBException {
        return target.processResult(itr);
    }

    public String getSQLName() {
        return target.getSQLName();
    }

    public void setSQL(SQLQuery query) {
        target.setSQL(query);
    }
}
