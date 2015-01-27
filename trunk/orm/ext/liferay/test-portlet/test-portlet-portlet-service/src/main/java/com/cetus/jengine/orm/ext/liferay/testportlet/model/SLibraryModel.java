package com.cetus.jengine.orm.ext.liferay.testportlet.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SLibrary service. Represents a row in the &quot;SB_SLibrary&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SLibraryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SLibraryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SLibrary
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SLibraryImpl
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.model.impl.SLibraryModelImpl
 * @generated
 */
public interface SLibraryModel extends BaseModel<SLibrary> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a s library model instance should use the {@link SLibrary} interface instead.
     */

    /**
     * Returns the primary key of this s library.
     *
     * @return the primary key of this s library
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this s library.
     *
     * @param primaryKey the primary key of this s library
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the library ID of this s library.
     *
     * @return the library ID of this s library
     */
    public long getLibraryId();

    /**
     * Sets the library ID of this s library.
     *
     * @param libraryId the library ID of this s library
     */
    public void setLibraryId(long libraryId);

    /**
     * Returns the name of this s library.
     *
     * @return the name of this s library
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this s library.
     *
     * @param name the name of this s library
     */
    public void setName(String name);

    /**
     * Returns the address of this s library.
     *
     * @return the address of this s library
     */
    @AutoEscape
    public String getAddress();

    /**
     * Sets the address of this s library.
     *
     * @param address the address of this s library
     */
    public void setAddress(String address);

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

    public int compareTo(SLibrary sLibrary);

    public int hashCode();

    public CacheModel<SLibrary> toCacheModel();

    public SLibrary toEscapedModel();

    public String toString();

    public String toXmlString();
}
