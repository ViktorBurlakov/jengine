package com.jengine.orm.query.target;

import com.jengine.orm.db.DBException;
import com.jengine.orm.db.query.SQLQuery;
import com.jengine.orm.field.ForeignField;
import com.jengine.orm.field.reference.ReferenceField;
import com.jengine.orm.model.multi.MultiModelItem;
import com.jengine.orm.query.ModelQuery;

import java.util.Iterator;

public class ForeignTarget extends Target {
    private Target target;

    public ForeignTarget(ModelQuery modelQuery, ForeignField field) {
        super(modelQuery);
        modelQuery.addPath(field.getReferencePath());
        MultiModelItem item = modelQuery.getMultiModel().getItems().get(field.getFieldName());
        this.target = (field.getActualField() instanceof ReferenceField) ?
                new ModelTarget(modelQuery, item):
                new FieldTarget(modelQuery, modelQuery.getMultiModelField(field));
    }

    public Object processResult(Iterator itr) throws DBException {
        return target.processResult(itr);
    }

    public void setSQL(SQLQuery query) {
        target.setSQL(query);
    }
}
