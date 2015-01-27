package com.cetus.jengine.orm.ext.liferay.testportlet.model;

import com.cetus.jengine.orm.ext.liferay.testportlet.service.SBookLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class SBookClp extends BaseModelImpl<SBook> implements SBook {
    private long _bookId;
    private long _libraryId;
    private String _title;
    private BaseModel<?> _sBookRemoteModel;

    public SBookClp() {
    }

    public Class<?> getModelClass() {
        return SBook.class;
    }

    public String getModelClassName() {
        return SBook.class.getName();
    }

    public long getPrimaryKey() {
        return _bookId;
    }

    public void setPrimaryKey(long primaryKey) {
        setBookId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_bookId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("bookId", getBookId());
        attributes.put("libraryId", getLibraryId());
        attributes.put("title", getTitle());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long bookId = (Long) attributes.get("bookId");

        if (bookId != null) {
            setBookId(bookId);
        }

        Long libraryId = (Long) attributes.get("libraryId");

        if (libraryId != null) {
            setLibraryId(libraryId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }
    }

    public long getBookId() {
        return _bookId;
    }

    public void setBookId(long bookId) {
        _bookId = bookId;
    }

    public long getLibraryId() {
        return _libraryId;
    }

    public void setLibraryId(long libraryId) {
        _libraryId = libraryId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public BaseModel<?> getSBookRemoteModel() {
        return _sBookRemoteModel;
    }

    public void setSBookRemoteModel(BaseModel<?> sBookRemoteModel) {
        _sBookRemoteModel = sBookRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            SBookLocalServiceUtil.addSBook(this);
        } else {
            SBookLocalServiceUtil.updateSBook(this);
        }
    }

    @Override
    public SBook toEscapedModel() {
        return (SBook) Proxy.newProxyInstance(SBook.class.getClassLoader(),
            new Class[] { SBook.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SBookClp clone = new SBookClp();

        clone.setBookId(getBookId());
        clone.setLibraryId(getLibraryId());
        clone.setTitle(getTitle());

        return clone;
    }

    public int compareTo(SBook sBook) {
        long primaryKey = sBook.getPrimaryKey();

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

        SBookClp sBook = null;

        try {
            sBook = (SBookClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = sBook.getPrimaryKey();

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

        sb.append("{bookId=");
        sb.append(getBookId());
        sb.append(", libraryId=");
        sb.append(getLibraryId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>bookId</column-name><column-value><![CDATA[");
        sb.append(getBookId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>libraryId</column-name><column-value><![CDATA[");
        sb.append(getLibraryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
