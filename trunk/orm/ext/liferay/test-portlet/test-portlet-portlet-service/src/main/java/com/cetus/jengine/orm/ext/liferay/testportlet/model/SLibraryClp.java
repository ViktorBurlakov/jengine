package com.cetus.jengine.orm.ext.liferay.testportlet.model;

import com.cetus.jengine.orm.ext.liferay.testportlet.service.SLibraryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class SLibraryClp extends BaseModelImpl<SLibrary> implements SLibrary {
    private long _libraryId;
    private String _name;
    private String _address;
    private BaseModel<?> _sLibraryRemoteModel;

    public SLibraryClp() {
    }

    public Class<?> getModelClass() {
        return SLibrary.class;
    }

    public String getModelClassName() {
        return SLibrary.class.getName();
    }

    public long getPrimaryKey() {
        return _libraryId;
    }

    public void setPrimaryKey(long primaryKey) {
        setLibraryId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_libraryId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("libraryId", getLibraryId());
        attributes.put("name", getName());
        attributes.put("address", getAddress());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long libraryId = (Long) attributes.get("libraryId");

        if (libraryId != null) {
            setLibraryId(libraryId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String address = (String) attributes.get("address");

        if (address != null) {
            setAddress(address);
        }
    }

    public long getLibraryId() {
        return _libraryId;
    }

    public void setLibraryId(long libraryId) {
        _libraryId = libraryId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public BaseModel<?> getSLibraryRemoteModel() {
        return _sLibraryRemoteModel;
    }

    public void setSLibraryRemoteModel(BaseModel<?> sLibraryRemoteModel) {
        _sLibraryRemoteModel = sLibraryRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            SLibraryLocalServiceUtil.addSLibrary(this);
        } else {
            SLibraryLocalServiceUtil.updateSLibrary(this);
        }
    }

    @Override
    public SLibrary toEscapedModel() {
        return (SLibrary) Proxy.newProxyInstance(SLibrary.class.getClassLoader(),
            new Class[] { SLibrary.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SLibraryClp clone = new SLibraryClp();

        clone.setLibraryId(getLibraryId());
        clone.setName(getName());
        clone.setAddress(getAddress());

        return clone;
    }

    public int compareTo(SLibrary sLibrary) {
        long primaryKey = sLibrary.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        SLibraryClp sLibrary = null;

        try {
            sLibrary = (SLibraryClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = sLibrary.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{libraryId=");
        sb.append(getLibraryId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", address=");
        sb.append(getAddress());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append(
            "com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>libraryId</column-name><column-value><![CDATA[");
        sb.append(getLibraryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>address</column-name><column-value><![CDATA[");
        sb.append(getAddress());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
