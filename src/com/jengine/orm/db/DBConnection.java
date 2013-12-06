package com.jengine.orm.db;


import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private Object nativeConnection;
    private List generatedKeys = new ArrayList();

    public DBConnection(Object nativeConnection) {
        this.nativeConnection = nativeConnection;
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
