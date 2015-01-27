package com.cetus.jengine.orm.ext.liferay.testportlet.model;

import com.cetus.jengine.orm.ext.liferay.testportlet.service.SMemberLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class SMemberClp extends BaseModelImpl<SMember> implements SMember {
    private long _memberId;
    private long _libraryId;
    private String _firstName;
    private String _lastName;
    private BaseModel<?> _sMemberRemoteModel;

    public SMemberClp() {
    }

    public Class<?> getModelClass() {
        return SMember.class;
    }

    public String getModelClassName() {
        return SMember.class.getName();
    }

    public long getPrimaryKey() {
        return _memberId;
    }

    public void setPrimaryKey(long primaryKey) {
        setMemberId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_memberId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("memberId", getMemberId());
        attributes.put("libraryId", getLibraryId());
        attributes.put("firstName", getFirstName());
        attributes.put("lastName", getLastName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long memberId = (Long) attributes.get("memberId");

        if (memberId != null) {
            setMemberId(memberId);
        }

        Long libraryId = (Long) attributes.get("libraryId");

        if (libraryId != null) {
            setLibraryId(libraryId);
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

    public long getMemberId() {
        return _memberId;
    }

    public void setMemberId(long memberId) {
        _memberId = memberId;
    }

    public long getLibraryId() {
        return _libraryId;
    }

    public void setLibraryId(long libraryId) {
        _libraryId = libraryId;
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

    public BaseModel<?> getSMemberRemoteModel() {
        return _sMemberRemoteModel;
    }

    public void setSMemberRemoteModel(BaseModel<?> sMemberRemoteModel) {
        _sMemberRemoteModel = sMemberRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            SMemberLocalServiceUtil.addSMember(this);
        } else {
            SMemberLocalServiceUtil.updateSMember(this);
        }
    }

    @Override
    public SMember toEscapedModel() {
        return (SMember) Proxy.newProxyInstance(SMember.class.getClassLoader(),
            new Class[] { SMember.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SMemberClp clone = new SMemberClp();

        clone.setMemberId(getMemberId());
        clone.setLibraryId(getLibraryId());
        clone.setFirstName(getFirstName());
        clone.setLastName(getLastName());

        return clone;
    }

    public int compareTo(SMember sMember) {
        long primaryKey = sMember.getPrimaryKey();

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

        SMemberClp sMember = null;

        try {
            sMember = (SMemberClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = sMember.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{memberId=");
        sb.append(getMemberId());
        sb.append(", libraryId=");
        sb.append(getLibraryId());
        sb.append(", firstName=");
        sb.append(getFirstName());
        sb.append(", lastName=");
        sb.append(getLastName());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>memberId</column-name><column-value><![CDATA[");
        sb.append(getMemberId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>libraryId</column-name><column-value><![CDATA[");
        sb.append(getLibraryId());
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
