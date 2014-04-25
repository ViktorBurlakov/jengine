/*
 *  This file is part of JEngine.
 *  *
 *  * Copyright (C) 2013-2014 Cetus (http://cs1.com.ua/). All rights reserved.
 *  *
 *  * JEngine is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * JEngine is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * along with JEngine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jengine.orm.db.adapter.liferay;

import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.DBSavePoint;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class LiferayConnection extends DBConnection {
    private static Log log = LogFactoryUtil.getLog(LiferayConnection.class);

    public Class transactionalPortalCacheHelper;

    public LiferayConnection(Object nativeConnection) throws DBException {
        super(nativeConnection);
//        try {
//            transactionalPortalCacheHelper = PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portal.cache.transactional.TransactionalPortalCacheHelper");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        if (isTransactionActive()) {
            startTransaction();
        }
    }

    public void close() throws DBException {
        try {
            getNativeConnection().close();
        } catch (ORMException e) {
            throw new DBException(e);
        }
    }

    public void startTransaction() throws DBException {
//        try {
//            transactionalPortalCacheHelper.getMethod("begin").invoke(transactionalPortalCacheHelper);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }

    public void commit() throws DBException {
//        try {
//            transactionalPortalCacheHelper.getMethod("commit").invoke(transactionalPortalCacheHelper);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }

    public void rollback() throws DBException {
//        try {
//            transactionalPortalCacheHelper.getMethod("rollback").invoke(transactionalPortalCacheHelper);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }

    public void finishTransaction() throws DBException {
        //TransactionalPortalCacheHelper.();
    }

    public DBSavePoint savePoint(String name) throws DBException {
        log.debug("Save Point '" + name + "' start");
        return new DBSavePoint(null);
    }

    public DBSavePoint savePoint() throws DBException {
        log.debug("Save Point start");
        return new DBSavePoint(null);
    }

    public void releasePoint(DBSavePoint point) throws DBException {
//        try {
//            getNativeConnection().releaseSavepoint((Savepoint) point.getNativeObject());
//            System.out.println("Save Point released");
//        } catch (SQLException e) {
//            throw new DBException(e);
//        }
    }

    public void rollback(DBSavePoint point) throws DBException {
//        try {
//            getNativeConnection().rollback((Savepoint) point.getNativeObject());
//            System.out.println("Save Point rollback");
//        } catch (SQLException e) {
//            throw new DBException(e);
//        }
    }

    public boolean isNestedTransactionSupport() {
        return false;
    }

    public boolean isTransactionActive() throws DBException {
//        try {
//            return getNativeConnection().getAutoCommit() == false;
//        } catch (SQLException e) {
//            throw new DBException(e);
//        }
        return true;
    }

    public Session getNativeConnection() {
        return (Session) super.getNativeConnection();
    }
}
