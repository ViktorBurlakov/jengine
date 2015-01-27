package com.cetus.jengine.orm.ext.liferay.testportlet.model.impl;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.SBook;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing SBook in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SBook
 * @generated
 */
public class SBookCacheModel implements CacheModel<SBook>, Serializable {
    public long bookId;
    public long libraryId;
    public String title;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{bookId=");
        sb.append(bookId);
        sb.append(", libraryId=");
        sb.append(libraryId);
        sb.append(", title=");
        sb.append(title);
        sb.append("}");

        return sb.toString();
    }

    public SBook toEntityModel() {
        SBookImpl sBookImpl = new SBookImpl();

        sBookImpl.setBookId(bookId);
        sBookImpl.setLibraryId(libraryId);

        if (title == null) {
            sBookImpl.setTitle(StringPool.BLANK);
        } else {
            sBookImpl.setTitle(title);
        }

        sBookImpl.resetOriginalValues();

        return sBookImpl;
    }
}
