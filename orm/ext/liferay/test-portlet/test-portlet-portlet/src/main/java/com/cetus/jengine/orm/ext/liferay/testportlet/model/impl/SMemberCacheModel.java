package com.cetus.jengine.orm.ext.liferay.testportlet.model.impl;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.SMember;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing SMember in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SMember
 * @generated
 */
public class SMemberCacheModel implements CacheModel<SMember>, Serializable {
    public long memberId;
    public long libraryId;
    public String firstName;
    public String lastName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{memberId=");
        sb.append(memberId);
        sb.append(", libraryId=");
        sb.append(libraryId);
        sb.append(", firstName=");
        sb.append(firstName);
        sb.append(", lastName=");
        sb.append(lastName);
        sb.append("}");

        return sb.toString();
    }

    public SMember toEntityModel() {
        SMemberImpl sMemberImpl = new SMemberImpl();

        sMemberImpl.setMemberId(memberId);
        sMemberImpl.setLibraryId(libraryId);

        if (firstName == null) {
            sMemberImpl.setFirstName(StringPool.BLANK);
        } else {
            sMemberImpl.setFirstName(firstName);
        }

        if (lastName == null) {
            sMemberImpl.setLastName(StringPool.BLANK);
        } else {
            sMemberImpl.setLastName(lastName);
        }

        sMemberImpl.resetOriginalValues();

        return sMemberImpl;
    }
}
