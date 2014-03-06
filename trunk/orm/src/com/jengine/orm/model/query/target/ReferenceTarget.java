package com.jengine.orm.model.query.target;


import com.jengine.orm.model.field.reference.BaseReference;
import com.jengine.orm.model.query.BaseQuery;
import com.jengine.orm.model.query.ModelQuery;

import static com.jengine.utils.CollectionUtil.list;

public class ReferenceTarget extends ModelTarget {
    private BaseReference reference;

    public ReferenceTarget(BaseReference field) {
        this(field.getFieldName(), field);
    }

    public ReferenceTarget(String name, BaseReference field) {
        super(name);
        this.reference = field;
    }

    public void config(BaseQuery modelQuery) {
        super.config(modelQuery);
        ((ModelQuery)modelQuery)._addPath(list(reference.getFieldName()));
        this.item = modelQuery.getMultiModel().getItems().get(reference.getFieldName());
    }
}
