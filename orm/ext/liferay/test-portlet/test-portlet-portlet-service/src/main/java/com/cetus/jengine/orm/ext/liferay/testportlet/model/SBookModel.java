package com.cetus.jengine.orm.ext.liferay.testportlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SBook service. Represents a row in the &quot;SB_SBook&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SBookModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SBookImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SBook
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SBookImpl
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SBookModelImpl
 * @generated
 */
public interface SBookModel extends BaseModel<SBook> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a s book model instance should use the {@link SBook} interface instead.
     */

    /**
     * Returns the primary key of this s book.
     *
     * @return the primary key of this s book
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this s book.
     *
     * @param primaryKey the primary key of this s book
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the book ID of this s book.
     *
     * @return the book ID of this s book
     */
    public long getBookId();

    /**
     * Sets the book ID of this s book.
     *
     * @param bookId the book ID of this s book
     */
    public void setBookId(long bookId);

    /**
     * Returns the library ID of this s book.
     *
     * @return the library ID of this s book
     */
    public long getLibraryId();

    /**
     * Sets the library ID of this s book.
     *
     * @param libraryId the library ID of this s book
     */
    public void setLibraryId(long libraryId);

    /**
     * Returns the title of this s book.
     *
     * @return the title of this s book
     */
    @AutoEscape
    public String getTitle();

    /**
     * Sets the title of this s book.
     *
     * @param title the title of this s book
     */
    public void setTitle(String title);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(SBook sBook);

    public int hashCode();

    public CacheModel<SBook> toCacheModel();

    public SBook toEscapedModel();

    public String toString();

    public String toXmlString();
}
