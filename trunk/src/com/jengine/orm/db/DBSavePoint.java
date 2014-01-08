package com.jengine.orm.db;

public class DBSavePoint {
    private Object nativeObject;

    public DBSavePoint(Object nativeObject) {
        this.nativeObject = nativeObject;
    }

    public Object getNativeObject() {
        return nativeObject;
    }

    public void setNativeObject(Object nativeObject) {
        this.nativeObject = nativeObject;
    }
}
