package com.jengine.orm.db.adapter.liferay;


import com.jengine.orm.db.DBException;
import com.jengine.orm.model.Model;
import com.liferay.portal.model.BaseModel;

public class LiferayModel<EntityClass extends BaseModel> extends Model {

    public LiferayModel() throws DBException {
        super();
    }

    public EntityClass toEntityObject() throws DBException {
        return (EntityClass) ((LiferayModelClass) cls).toEntityObject(this);
    }

}
