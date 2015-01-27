package com.cetus.jengine.orm.ext.liferay.testportlet.model.impl;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.SAuthor;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing SAuthor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SAuthor
 * @generated
 */
public class SAuthorCacheModel implements CacheModel<SAuthor>, Serializable {
    public long authorId;
    public String firstName;
    public String lastName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{authorId=");
        sb.append(authorId);
        sb.append(", firstName=");
        sb.append(firstName);
        sb.append(", lastName=");
        sb.append(lastName);
        sb.append("}");

        return sb.toString();
    }

    public SAuthor toEntityModel() {
        SAuthorImpl sAuthorImpl = new SAuthorImpl();

        sAuthorImpl.setAuthorId(authorId);

        if (firstName == null) {
            sAuthorImpl.setFirstName(StringPool.BLANK);
        } else {
            sAuthorImpl.setFirstName(firstName);
        }

        if (lastName == null) {
            sAuthorImpl.setLastName(StringPool.BLANK);
        } else {
            sAuthorImpl.setLastName(lastName);
        }

        sAuthorImpl.resetOriginalValues();

        return sAuthorImpl;
    }
}
