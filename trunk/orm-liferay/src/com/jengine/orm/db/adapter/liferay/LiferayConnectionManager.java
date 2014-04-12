package com.jengine.orm.db.adapter.liferay;


import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.adapter.ConnectionManager;
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