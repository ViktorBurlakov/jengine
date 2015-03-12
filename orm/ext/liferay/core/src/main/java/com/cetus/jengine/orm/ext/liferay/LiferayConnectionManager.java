package com.cetus.jengine.orm.ext.liferay;


import com.cetus.jengine.orm.core.db.DBConnection;
import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.db.adapter.ConnectionManager;
import com.cetus.jengine.orm.ext.liferay.LiferayConnection;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;

public class LiferayConnectionManager extends ConnectionManager {

    public DBConnection getConnection() throws DBException {
        try {
            return new LiferayConnection(getSessionFactory().openSession());
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    public void closeConnection(DBConnection connection) throws DBException {
        getSessionFactory().closeSession((Session) connection.getNativeConnection());
    }

    protected SessionFactory getSessionFactory() {
        return (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");
    }

}