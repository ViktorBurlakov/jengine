package com.jengine.orm.model.query.target;


import com.jengine.orm.model.field.reference.BaseReference;
import com.jengine.orm.model.query.ModelQuery;

import static com.jengine.utils.CollectionUtil.list;

public class ReferenceTarget extends ModelTarget {

    public ReferenceTarget(ModelQuery modelQuery, BaseReference field) {
        super(modelQuery);
        modelQuery.addPath(list(field.getFieldName()));
        this.item = modelQuery.getMultiModel().getItems().get(field.getFieldName());
    }
}
