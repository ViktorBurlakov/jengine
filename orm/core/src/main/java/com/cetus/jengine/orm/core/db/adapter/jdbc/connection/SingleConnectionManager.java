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

package com.cetus.jengine.orm.core.db.adapter.jdbc.connection;


import com.cetus.jengine.orm.core.db.DBConnection;
import com.cetus.jengine.orm.core.db.DBException;
import com.cetus.jengine.orm.core.db.adapter.ConnectionManager;
import com.cetus.jengine.orm.core.db.adapter.jdbc.JDBCConnection;

import java.sql.DriverManager;

public class SingleConnectionManager extends ConnectionManager{
    private String driver;
    private String connection;
    private String user;
    private String password;

    public SingleConnectionManager(String driver, String connection, String user, String password) throws DBException {
        super();
        this.driver = driver;
        this.connection = connection;
        this.user = user;
        this.password = password;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DBException(e);
        }
    }

    public DBConnection getConnection() throws DBException {
        try {
            return new JDBCConnection(DriverManager.getConnection(this.connection, this.user, this.password));
        } catch (Exception e) {
            e.printStackTrace();
            throw new DBException(e);
        }
    }
}
