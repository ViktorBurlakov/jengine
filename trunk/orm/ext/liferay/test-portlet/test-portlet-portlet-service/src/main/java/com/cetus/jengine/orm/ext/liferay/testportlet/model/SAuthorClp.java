package com.cetus.jengine.orm.ext.liferay.testportlet.model;

import com.cetus.jengine.orm.ext.liferay.testportlet.service.SAuthorLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class SAuthorClp extends BaseModelImpl<SAuthor> implements SAuthor {
    private long _authorId;
    private String _firstName;
    private String _lastName;
    private BaseModel<?> _sAuthorRemoteModel;

    public SAuthorClp() {
    }

    public Class<?> getModelClass() {
        return SAuthor.class;
    }

    public String getModelClassName() {
        return SAuthor.class.getName();
    }

    public long getPrimaryKey() {
        return _authorId;
    }

    public void setPrimaryKey(long primaryKey) {
        setAuthorId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_authorId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("authorId", getAuthorId());
        attributes.put("firstName", getFirstName());
        attributes.put("lastName", getLastName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long authorId = (Long) attributes.get("authorId");

        if (authorId != null) {
            setAuthorId(authorId);
        }

        String firstName = (String) attributes.get("firstName");

        if (firstName != null) {
            setFirstName(firstName);
        }

        String lastName = (String) attributes.get("lastName");

        if (lastName != null) {
            setLastName(lastName);
        }
    }

    public long getAuthorId() {
        return _authorId;
    }

    public void setAuthorId(long authorId) {
        _authorId = authorId;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public BaseModel<?> getSAuthorRemoteModel() {
        return _sAuthorRemoteModel;
    }

    public void setSAuthorRemoteModel(BaseModel<?> sAuthorRemoteModel) {
        _sAuthorRemoteModel = sAuthorRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            SAuthorLocalServiceUtil.addSAuthor(this);
        } else {
            SAuthorLocalServiceUtil.updateSAuthor(this);
        }
    }

    @Override
    public SAuthor toEscapedModel() {
        return (SAuthor) Proxy.newProxyInstance(SAuthor.class.getClassLoader(),
            new Class[] { SAuthor.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SAuthorClp clone = new SAuthorClp();

        clone.setAuthorId(getAuthorId());
        clone.setFirstName(getFirstName());
        clone.setLastName(getLastName());

        return clone;
    }

    public int compareTo(SAuthor sAuthor) {
        long primaryKey = sAuthor.getPrimaryKey();

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

        SAuthorClp sAuthor = null;

        try {
            sAuthor = (SAuthorClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = sAuthor.getPrimaryKey();

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

        sb.append("{authorId=");
        sb.append(getAuthorId());
        sb.append(", firstName=");
        sb.append(getFirstName());
        sb.append(", lastName=");
        sb.append(getLastName());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>authorId</column-name><column-value><![CDATA[");
        sb.append(getAuthorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>firstName</column-name><column-value><![CDATA[");
        sb.append(getFirstName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastName</column-name><column-value><![CDATA[");
        sb.append(getLastName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
