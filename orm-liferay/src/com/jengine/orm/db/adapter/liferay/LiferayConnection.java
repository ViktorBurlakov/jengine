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


public class LiferayConnection extends DBConnection {

    public LiferayConnection(Object nativeConnection) throws DBException {
        super(nativeConnection);
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
//            getNativeConnection().setAutoCommit(false);
//            System.out.println("Transaction started!");
//        } catch (ORMException e) {
//            throw new DBException(e);
//        }
    }

    public void commit() throws DBException {
//        try {
//            getNativeConnection().commit();
//            System.out.println("Transaction committed!");
//        } catch (ORMException e) {
//            throw new DBException(e);
//        }
    }

    public void rollback() throws DBException {
//        try {
//            getNativeConnection().rollback();
//            System.out.println("Transaction rollback!");
//        } catch (SQLException e) {
//            throw new DBException(e);
//        }
    }

    public void finishTransaction() throws DBException {
//        try {
//            getNativeConnection().setAutoCommit(true);
//            System.out.println("Transaction finish!");
//        } catch (SQLException e) {
//            throw new DBException(e);
//        }
    }

    public DBSavePoint savePoint(String name) throws DBException {
        System.out.println("Save Point '" + name + "' start");
        return new DBSavePoint(null);
    }

    public DBSavePoint savePoint() throws DBException {
        System.out.println("Save Point start");
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
        return false;
    }

    public Session getNativeConnection() {
        return (Session) super.getNativeConnection();
    }
}
