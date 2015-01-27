package com.cetus.jengine.orm.ext.liferay.testportlet.model.impl;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing STransaction in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see STransaction
 * @generated
 */
public class STransactionCacheModel implements CacheModel<STransaction>,
    Serializable {
    public long transactionId;
    public long bookId;
    public long memberId;
    public long tdate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{transactionId=");
        sb.append(transactionId);
        sb.append(", bookId=");
        sb.append(bookId);
        sb.append(", memberId=");
        sb.append(memberId);
        sb.append(", tdate=");
        sb.append(tdate);
        sb.append("}");

        return sb.toString();
    }

    public STransaction toEntityModel() {
        STransactionImpl sTransactionImpl = new STransactionImpl();

        sTransactionImpl.setTransactionId(transactionId);
        sTransactionImpl.setBookId(bookId);
        sTransactionImpl.setMemberId(memberId);

        if (tdate == Long.MIN_VALUE) {
            sTransactionImpl.setTdate(null);
        } else {
            sTransactionImpl.setTdate(new Date(tdate));
        }

        sTransactionImpl.resetOriginalValues();

        return sTransactionImpl;
    }
}
