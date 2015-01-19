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

package com.jengine.orm.db.adapter.jdbc;

import com.jengine.orm.db.DBConnection;
import com.jengine.orm.db.DBException;
import com.jengine.orm.db.DBSavePoint;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.logging.Logger;


public class JDBCConnection extends DBConnection {
    private static Logger logger = Logger.getLogger(JDBCConnection.class.getName());

    public JDBCConnection(Object nativeConnection) throws DBException {
        super(nativeConnection);
        if (isTransactionActive()) {
            startTransaction();
        }
    }

    public void close() throws DBException {
        try {
            getNativeConnection().close();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void startTransaction() throws DBException {
        try {
            getNativeConnection().setAutoCommit(false);
            logger.info("Transaction started!");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void commit() throws DBException {
        try {
            getNativeConnection().commit();
            logger.info("Transaction committed!");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void rollback() throws DBException {
        try {
            getNativeConnection().rollback();
            logger.info("Transaction rollback!");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void finishTransaction() throws DBException {
        try {
            getNativeConnection().setAutoCommit(true);
            logger.info("Transaction finish!");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public DBSavePoint savePoint(String name) throws DBException {
        try {
            logger.info("Save Point '" + name + "' start");
            return new DBSavePoint(getNativeConnection().setSavepoint(name));
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public DBSavePoint savePoint() throws DBException {
        try {
            logger.info("Save Point start");
            return new DBSavePoint(getNativeConnection().setSavepoint());
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void releasePoint(DBSavePoint point) throws DBException {
        try {
            getNativeConnection().releaseSavepoint((Savepoint) point.getNativeObject());
            logger.info("Save Point released");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void rollback(DBSavePoint point) throws DBException {
        try {
            getNativeConnection().rollback((Savepoint) point.getNativeObject());
            logger.info("Save Point rollback");
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public boolean isNestedTransactionSupport() {
        return true;
    }

    public boolean isTransactionActive() throws DBException {
        try {
            return getNativeConnection().getAutoCommit() == false;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public Connection getNativeConnection() {
        return (Connection) super.getNativeConnection();
    }
}
