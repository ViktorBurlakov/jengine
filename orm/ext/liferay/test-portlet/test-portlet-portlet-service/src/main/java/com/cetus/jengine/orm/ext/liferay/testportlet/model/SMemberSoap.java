package com.cetus.jengine.orm.ext.liferay.testportlet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.cetus.jengine.orm.ext.liferay.testportlet.service.http.SMemberServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.cetus.jengine.orm.ext.liferay.testportlet.service.http.SMemberServiceSoap
 * @generated
 */
public class SMemberSoap implements Serializable {
    private long _memberId;
    private long _libraryId;
    private String _firstName;
    private String _lastName;

    public SMemberSoap() {
    }

    public static SMemberSoap toSoapModel(SMember model) {
        SMemberSoap soapModel = new SMemberSoap();

        soapModel.setMemberId(model.getMemberId());
        soapModel.setLibraryId(model.getLibraryId());
        soapModel.setFirstName(model.getFirstName());
        soapModel.setLastName(model.getLastName());

        return soapModel;
    }

    public static SMemberSoap[] toSoapModels(SMember[] models) {
        SMemberSoap[] soapModels = new SMemberSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SMemberSoap[][] toSoapModels(SMember[][] models) {
        SMemberSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SMemberSoap[models.length][models[0].length];
        } else {
            soapModels = new SMemberSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SMemberSoap[] toSoapModels(List<SMember> models) {
        List<SMemberSoap> soapModels = new ArrayList<SMemberSoap>(models.size());

        for (SMember model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SMemberSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _memberId;
    }

    public void setPrimaryKey(long pk) {
        setMemberId(pk);
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
}
