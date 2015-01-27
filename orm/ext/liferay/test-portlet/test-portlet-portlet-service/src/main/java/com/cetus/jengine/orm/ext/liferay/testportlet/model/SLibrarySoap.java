package com.cetus.jengine.orm.ext.liferay.testportlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.http.SLibraryServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.cetus.jengine.orm.ext.liferay.testportlet.service.http.SLibraryServiceSoap
 * @generated
 */
public class SLibrarySoap implements Serializable {
    private long _libraryId;
    private String _name;
    private String _address;

    public SLibrarySoap() {
    }

    public static SLibrarySoap toSoapModel(SLibrary model) {
        SLibrarySoap soapModel = new SLibrarySoap();

        soapModel.setLibraryId(model.getLibraryId());
        soapModel.setName(model.getName());
        soapModel.setAddress(model.getAddress());

        return soapModel;
    }

    public static SLibrarySoap[] toSoapModels(SLibrary[] models) {
        SLibrarySoap[] soapModels = new SLibrarySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SLibrarySoap[][] toSoapModels(SLibrary[][] models) {
        SLibrarySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SLibrarySoap[models.length][models[0].length];
        } else {
            soapModels = new SLibrarySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SLibrarySoap[] toSoapModels(List<SLibrary> models) {
        List<SLibrarySoap> soapModels = new ArrayList<SLibrarySoap>(models.size());

        for (SLibrary model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SLibrarySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _libraryId;
    }

    public void setPrimaryKey(long pk) {
        setLibraryId(pk);
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
}
