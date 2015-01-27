package com.cetus.jengine.orm.ext.liferay.testportlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.http.SBookServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.cetus.jengine.orm.ext.liferay.testportlet.service.http.SBookServiceSoap
 * @generated
 */
public class SBookSoap implements Serializable {
    private long _bookId;
    private long _libraryId;
    private String _title;

    public SBookSoap() {
    }

    public static SBookSoap toSoapModel(SBook model) {
        SBookSoap soapModel = new SBookSoap();

        soapModel.setBookId(model.getBookId());
        soapModel.setLibraryId(model.getLibraryId());
        soapModel.setTitle(model.getTitle());

        return soapModel;
    }

    public static SBookSoap[] toSoapModels(SBook[] models) {
        SBookSoap[] soapModels = new SBookSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SBookSoap[][] toSoapModels(SBook[][] models) {
        SBookSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SBookSoap[models.length][models[0].length];
        } else {
            soapModels = new SBookSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SBookSoap[] toSoapModels(List<SBook> models) {
        List<SBookSoap> soapModels = new ArrayList<SBookSoap>(models.size());

        for (SBook model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SBookSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _bookId;
    }

    public void setPrimaryKey(long pk) {
        setBookId(pk);
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
}
