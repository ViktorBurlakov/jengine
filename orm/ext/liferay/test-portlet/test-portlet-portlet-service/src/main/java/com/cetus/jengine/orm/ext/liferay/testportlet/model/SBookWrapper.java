package com.cetus.jengine.orm.ext.liferay.testportlet.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SBook}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SBook
 * @generated
 */
public class SBookWrapper implements SBook, ModelWrapper<SBook> {
    private SBook _sBook;

    public SBookWrapper(SBook sBook) {
        _sBook = sBook;
    }

    public Class<?> getModelClass() {
        return SBook.class;
    }

    public String getModelClassName() {
        return SBook.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("bookId", getBookId());
        attributes.put("libraryId", getLibraryId());
        attributes.put("title", getTitle());

        return attributes;
    }

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

    /**
    * Returns the primary key of this s book.
    *
    * @return the primary key of this s book
    */
    public long getPrimaryKey() {
        return _sBook.getPrimaryKey();
    }

    /**
    * Sets the primary key of this s book.
    *
    * @param primaryKey the primary key of this s book
    */
    public void setPrimaryKey(long primaryKey) {
        _sBook.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the book ID of this s book.
    *
    * @return the book ID of this s book
    */
    public long getBookId() {
        return _sBook.getBookId();
    }

    /**
    * Sets the book ID of this s book.
    *
    * @param bookId the book ID of this s book
    */
    public void setBookId(long bookId) {
        _sBook.setBookId(bookId);
    }

    /**
    * Returns the library ID of this s book.
    *
    * @return the library ID of this s book
    */
    public long getLibraryId() {
        return _sBook.getLibraryId();
    }

    /**
    * Sets the library ID of this s book.
    *
    * @param libraryId the library ID of this s book
    */
    public void setLibraryId(long libraryId) {
        _sBook.setLibraryId(libraryId);
    }

    /**
    * Returns the title of this s book.
    *
    * @return the title of this s book
    */
    public java.lang.String getTitle() {
        return _sBook.getTitle();
    }

    /**
    * Sets the title of this s book.
    *
    * @param title the title of this s book
    */
    public void setTitle(java.lang.String title) {
        _sBook.setTitle(title);
    }

    public boolean isNew() {
        return _sBook.isNew();
    }

    public void setNew(boolean n) {
        _sBook.setNew(n);
    }

    public boolean isCachedModel() {
        return _sBook.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _sBook.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _sBook.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _sBook.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _sBook.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _sBook.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _sBook.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SBookWrapper((SBook) _sBook.clone());
    }

    public int compareTo(
        com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook sBook) {
        return _sBook.compareTo(sBook);
    }

    @Override
    public int hashCode() {
        return _sBook.hashCode();
    }

    public com.liferay.portal.model.CacheModel<com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook> toCacheModel() {
        return _sBook.toCacheModel();
    }

    public com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook toEscapedModel() {
        return new SBookWrapper(_sBook.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _sBook.toString();
    }

    public java.lang.String toXmlString() {
        return _sBook.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _sBook.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public SBook getWrappedSBook() {
        return _sBook;
    }

    public SBook getWrappedModel() {
        return _sBook;
    }

    public void resetOriginalValues() {
        _sBook.resetOriginalValues();
    }
}
