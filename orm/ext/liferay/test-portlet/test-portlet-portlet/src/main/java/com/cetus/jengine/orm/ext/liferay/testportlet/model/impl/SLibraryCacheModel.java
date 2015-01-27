package com.cetus.jengine.orm.ext.liferay.testportlet.model.impl;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing SLibrary in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SLibrary
 * @generated
 */
public class SLibraryCacheModel implements CacheModel<SLibrary>, Serializable {
    public long libraryId;
    public String name;
    public String address;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{libraryId=");
        sb.append(libraryId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", address=");
        sb.append(address);
        sb.append("}");

        return sb.toString();
    }

    public SLibrary toEntityModel() {
        SLibraryImpl sLibraryImpl = new SLibraryImpl();

        sLibraryImpl.setLibraryId(libraryId);

        if (name == null) {
            sLibraryImpl.setName(StringPool.BLANK);
        } else {
            sLibraryImpl.setName(name);
        }

        if (address == null) {
            sLibraryImpl.setAddress(StringPool.BLANK);
        } else {
            sLibraryImpl.setAddress(address);
        }

        sLibraryImpl.resetOriginalValues();

        return sLibraryImpl;
    }
}
