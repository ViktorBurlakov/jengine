/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jenginetest.builder.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link STransaction}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       STransaction
 * @generated
 */
public class STransactionWrapper implements STransaction,
	ModelWrapper<STransaction> {
	public STransactionWrapper(STransaction sTransaction) {
		_sTransaction = sTransaction;
	}

	public Class<?> getModelClass() {
		return STransaction.class;
	}

	public String getModelClassName() {
		return STransaction.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("transactionId", getTransactionId());
		attributes.put("bookId", getBookId());
		attributes.put("memberId", getMemberId());
		attributes.put("tdate", getTdate());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long transactionId = (Long)attributes.get("transactionId");

		if (transactionId != null) {
			setTransactionId(transactionId);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		Date tdate = (Date)attributes.get("tdate");

		if (tdate != null) {
			setTdate(tdate);
		}
	}

	/**
	* Returns the primary key of this s transaction.
	*
	* @return the primary key of this s transaction
	*/
	public long getPrimaryKey() {
		return _sTransaction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s transaction.
	*
	* @param primaryKey the primary key of this s transaction
	*/
	public void setPrimaryKey(long primaryKey) {
		_sTransaction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the transaction ID of this s transaction.
	*
	* @return the transaction ID of this s transaction
	*/
	public long getTransactionId() {
		return _sTransaction.getTransactionId();
	}

	/**
	* Sets the transaction ID of this s transaction.
	*
	* @param transactionId the transaction ID of this s transaction
	*/
	public void setTransactionId(long transactionId) {
		_sTransaction.setTransactionId(transactionId);
	}

	/**
	* Returns the book ID of this s transaction.
	*
	* @return the book ID of this s transaction
	*/
	public long getBookId() {
		return _sTransaction.getBookId();
	}

	/**
	* Sets the book ID of this s transaction.
	*
	* @param bookId the book ID of this s transaction
	*/
	public void setBookId(long bookId) {
		_sTransaction.setBookId(bookId);
	}

	/**
	* Returns the member ID of this s transaction.
	*
	* @return the member ID of this s transaction
	*/
	public long getMemberId() {
		return _sTransaction.getMemberId();
	}

	/**
	* Sets the member ID of this s transaction.
	*
	* @param memberId the member ID of this s transaction
	*/
	public void setMemberId(long memberId) {
		_sTransaction.setMemberId(memberId);
	}

	/**
	* Returns the tdate of this s transaction.
	*
	* @return the tdate of this s transaction
	*/
	public java.util.Date getTdate() {
		return _sTransaction.getTdate();
	}

	/**
	* Sets the tdate of this s transaction.
	*
	* @param tdate the tdate of this s transaction
	*/
	public void setTdate(java.util.Date tdate) {
		_sTransaction.setTdate(tdate);
	}

	public boolean isNew() {
		return _sTransaction.isNew();
	}

	public void setNew(boolean n) {
		_sTransaction.setNew(n);
	}

	public boolean isCachedModel() {
		return _sTransaction.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_sTransaction.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _sTransaction.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _sTransaction.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sTransaction.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sTransaction.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sTransaction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new STransactionWrapper((STransaction)_sTransaction.clone());
	}

	public int compareTo(
		com.jenginetest.builder.model.STransaction sTransaction) {
		return _sTransaction.compareTo(sTransaction);
	}

	@Override
	public int hashCode() {
		return _sTransaction.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.jenginetest.builder.model.STransaction> toCacheModel() {
		return _sTransaction.toCacheModel();
	}

	public com.jenginetest.builder.model.STransaction toEscapedModel() {
		return new STransactionWrapper(_sTransaction.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sTransaction.toString();
	}

	public java.lang.String toXmlString() {
		return _sTransaction.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sTransaction.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public STransaction getWrappedSTransaction() {
		return _sTransaction;
	}

	public STransaction getWrappedModel() {
		return _sTransaction;
	}

	public void resetOriginalValues() {
		_sTransaction.resetOriginalValues();
	}

	private STransaction _sTransaction;
}