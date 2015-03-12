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

package com.cetus.jengine.orm.core.db;


import java.util.ArrayList;
import java.util.List;

public abstract class DBConnection {
    private Object nativeConnection;
    private List generatedKeys = new ArrayList();

    public DBConnection(Object nativeConnection) {
        this.nativeConnection = nativeConnection;
    }

    abstract public void close() throws DBException;

    abstract public void startTransaction() throws DBException ;

    abstract public void commit() throws DBException;

    abstract public void rollback() throws DBException;

    abstract public void finishTransaction() throws DBException;

    public DBSavePoint savePoint(String name) throws DBException {
        return null;
    }

    public DBSavePoint savePoint() throws DBException {
        return null;
    }

    public void releasePoint(DBSavePoint point) throws DBException {
    }

    public void rollback(DBSavePoint point) throws DBException {

    }

    public boolean isTransactionActive() throws DBException {
        return false;
    }

    public boolean isSavePointSupport() {
        return false;
    }

    public Object getNativeConnection() {
        return nativeConnection;
    }

    public void setGeneratedKeys(List generatedKeys) {
        this.generatedKeys = generatedKeys;
    }

    public List getGeneratedKeys() {
        return generatedKeys;
    }

}
