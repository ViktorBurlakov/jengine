package com.cetus.jengine.orm.ext.liferay.testportlet.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SAuthor}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SAuthor
 * @generated
 */
public class SAuthorWrapper implements SAuthor, ModelWrapper<SAuthor> {
    private SAuthor _sAuthor;

    public SAuthorWrapper(SAuthor sAuthor) {
        _sAuthor = sAuthor;
    }

    public Class<?> getModelClass() {
        return SAuthor.class;
    }

    public String getModelClassName() {
        return SAuthor.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("authorId", getAuthorId());
        attributes.put("firstName", getFirstName());
        attributes.put("lastName", getLastName());

        return attributes;
    }

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

    /**
    * Returns the primary key of this s author.
    *
    * @return the primary key of this s author
    */
    public long getPrimaryKey() {
        return _sAuthor.getPrimaryKey();
    }

    /**
    * Sets the primary key of this s author.
    *
    * @param primaryKey the primary key of this s author
    */
    public void setPrimaryKey(long primaryKey) {
        _sAuthor.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the author ID of this s author.
    *
    * @return the author ID of this s author
    */
    public long getAuthorId() {
        return _sAuthor.getAuthorId();
    }

    /**
    * Sets the author ID of this s author.
    *
    * @param authorId the author ID of this s author
    */
    public void setAuthorId(long authorId) {
        _sAuthor.setAuthorId(authorId);
    }

    /**
    * Returns the first name of this s author.
    *
    * @return the first name of this s author
    */
    public java.lang.String getFirstName() {
        return _sAuthor.getFirstName();
    }

    /**
    * Sets the first name of this s author.
    *
    * @param firstName the first name of this s author
    */
    public void setFirstName(java.lang.String firstName) {
        _sAuthor.setFirstName(firstName);
    }

    /**
    * Returns the last name of this s author.
    *
    * @return the last name of this s author
    */
    public java.lang.String getLastName() {
        return _sAuthor.getLastName();
    }

    /**
    * Sets the last name of this s author.
    *
    * @param lastName the last name of this s author
    */
    public void setLastName(java.lang.String lastName) {
        _sAuthor.setLastName(lastName);
    }

    public boolean isNew() {
        return _sAuthor.isNew();
    }

    public void setNew(boolean n) {
        _sAuthor.setNew(n);
    }

    public boolean isCachedModel() {
        return _sAuthor.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _sAuthor.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _sAuthor.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _sAuthor.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _sAuthor.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _sAuthor.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _sAuthor.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SAuthorWrapper((SAuthor) _sAuthor.clone());
    }

    public int compareTo(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor sAuthor) {
        return _sAuthor.compareTo(sAuthor);
    }

    @Override
    public int hashCode() {
        return _sAuthor.hashCode();
    }

    public com.liferay.portal.model.CacheModel<com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor> toCacheModel() {
        return _sAuthor.toCacheModel();
    }

    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor toEscapedModel() {
        return new SAuthorWrapper(_sAuthor.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _sAuthor.toString();
    }

    public java.lang.String toXmlString() {
        return _sAuthor.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _sAuthor.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public SAuthor getWrappedSAuthor() {
        return _sAuthor;
    }

    public SAuthor getWrappedModel() {
        return _sAuthor;
    }

    public void resetOriginalValues() {
        _sAuthor.resetOriginalValues();
    }
}
