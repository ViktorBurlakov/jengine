package com.jengine.orm.model.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.model.field.ForeignField;
import com.jengine.orm.model.field.reference.ReferenceField;
import com.jengine.orm.model.multi.MultiModelItem;
import com.jengine.orm.model.query.ModelQuery;

import java.util.Iterator;

public class ForeignTarget extends Target {
    private Target target;

    public ForeignTarget(ModelQuery modelQuery, ForeignField field) {
        this(modelQuery, field.getFieldName(), field);
    }

    public ForeignTarget(ModelQuery modelQuery, String name, ForeignField field) {
        super(modelQuery);
        modelQuery.addPath(field.getReferencePath());
        MultiModelItem item = modelQuery.getMultiModel().getItems().get(field.getFieldName());
        this.target = (field.getActualField() instanceof ReferenceField) ?
                new ModelTarget(modelQuery, name, item):
                new FieldTarget(modelQuery, name, modelQuery.getMultiModelField(field));
        this.name = target.getName();
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
