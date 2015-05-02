package com.cetus.jengine.orm.ext.liferay.testportlet.model.impl;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.STransactionModel;
import com.cetus.jengine.orm.ext.liferay.testportlet.model.STransactionSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the STransaction service. Represents a row in the &quot;SB_STransaction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.cetus.jengine.orm.ext.liferay.testportlet.model.STransactionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link STransactionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see STransactionImpl
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.model.STransactionModel
 * @generated
 */
@JSON(strict = true)
public class STransactionModelImpl extends BaseModelImpl<STransaction>
    implements STransactionModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a s transaction model instance should use the {@link com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction} interface instead.
     */
    public static final String TABLE_NAME = "SB_STransaction";
    public static final Object[][] TABLE_COLUMNS = {
            { "transactionId", Types.BIGINT },
            { "bookId", Types.BIGINT },
            { "memberId", Types.BIGINT },
            { "tdate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table SB_STransaction (transactionId LONG not null primary key,bookId LONG,memberId LONG,tdate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table SB_STransaction";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction"));
    private static ClassLoader _classLoader = STransaction.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            STransaction.class
        };
    private long _transactionId;
    private long _bookId;
    private long _memberId;
    private Date _tdate;
    private STransaction _escapedModelProxy;

    public STransactionModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static STransaction toModel(STransactionSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        STransaction model = new STransactionImpl();

        model.setTransactionId(soapModel.getTransactionId());
        model.setBookId(soapModel.getBookId());
        model.setMemberId(soapModel.getMemberId());
        model.setTdate(soapModel.getTdate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<STransaction> toModels(STransactionSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<STransaction> models = new ArrayList<STransaction>(soapModels.length);

        for (STransactionSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    public long getPrimaryKey() {
        return _transactionId;
    }

    public void setPrimaryKey(long primaryKey) {
        setTransactionId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_transactionId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public Class<?> getModelClass() {
        return STransaction.class;
    }

    public String getModelClassName() {
        return STransaction.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("transactionId", getTransactionId());
        attributes.put("bookId", getBookId());
        attributes.put("memberId", getMemberId());
        attributes.put("tdate", getTdate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long transactionId = (Long) attributes.get("transactionId");

        if (transactionId != null) {
            setTransactionId(transactionId);
        }

        Long bookId = (Long) attributes.get("bookId");

        if (bookId != null) {
            setBookId(bookId);
        }

        Long memberId = (Long) attributes.get("memberId");

        if (memberId != null) {
            setMemberId(memberId);
        }

        Date tdate = (Date) attributes.get("tdate");

        if (tdate != null) {
            setTdate(tdate);
        }
    }

    @JSON
    public long getTransactionId() {
        return _transactionId;
    }

    public void setTransactionId(long transactionId) {
        _transactionId = transactionId;
    }

    @JSON
    public long getBookId() {
        return _bookId;
    }

    public void setBookId(long bookId) {
        _bookId = bookId;
    }

    @JSON
    public long getMemberId() {
        return _memberId;
    }

    public void setMemberId(long memberId) {
        _memberId = memberId;
    }

    @JSON
    public Date getTdate() {
        return _tdate;
    }

    public void setTdate(Date tdate) {
        _tdate = tdate;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            STransaction.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public STransaction toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (STransaction) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        STransactionImpl sTransactionImpl = new STransactionImpl();

        sTransactionImpl.setTransactionId(getTransactionId());
        sTransactionImpl.setBookId(getBookId());
        sTransactionImpl.setMemberId(getMemberId());
        sTransactionImpl.setTdate(getTdate());

        sTransactionImpl.resetOriginalValues();

        return sTransactionImpl;
    }

    public int compareTo(STransaction sTransaction) {
        long primaryKey = sTransaction.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        STransaction sTransaction = null;

        try {
            sTransaction = (STransaction) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = sTransaction.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<STransaction> toCacheModel() {
        STransactionCacheModel sTransactionCacheModel = new STransactionCacheModel();

        sTransactionCacheModel.transactionId = getTransactionId();

        sTransactionCacheModel.bookId = getBookId();

        sTransactionCacheModel.memberId = getMemberId();

        Date tdate = getTdate();

        if (tdate != null) {
            sTransactionCacheModel.tdate = tdate.getTime();
        } else {
            sTransactionCacheModel.tdate = Long.MIN_VALUE;
        }

        return sTransactionCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{transactionId=");
        sb.append(getTransactionId());
        sb.append(", bookId=");
        sb.append(getBookId());
        sb.append(", memberId=");
        sb.append(getMemberId());
        sb.append(", tdate=");
        sb.append(getTdate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.cetus.jengine.orm.ext.liferay.testportlet.model.STransaction");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>transactionId</column-name><column-value><![CDATA[");
        sb.append(getTransactionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bookId</column-name><column-value><![CDATA[");
        sb.append(getBookId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>memberId</column-name><column-value><![CDATA[");
        sb.append(getMemberId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tdate</column-name><column-value><![CDATA[");
        sb.append(getTdate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}