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
 * This class is a wrapper for {@link Transaction}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Transaction
 * @generated
 */
public class TransactionWrapper implements Transaction,
	ModelWrapper<Transaction> {
	public TransactionWrapper(Transaction transaction) {
		_transaction = transaction;
	}

	public Class<?> getModelClass() {
		return Transaction.class;
	}

	public String getModelClassName() {
		return Transaction.class.getName();
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
	* Returns the primary key of this transaction.
	*
	* @return the primary key of this transaction
	*/
	public long getPrimaryKey() {
		return _transaction.getPrimaryKey();
	}

	/**
	* Sets the primary key of this transaction.
	*
	* @param primaryKey the primary key of this transaction
	*/
	public void setPrimaryKey(long primaryKey) {
		_transaction.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the transaction ID of this transaction.
	*
	* @return the transaction ID of this transaction
	*/
	public long getTransactionId() {
		return _transaction.getTransactionId();
	}

	/**
	* Sets the transaction ID of this transaction.
	*
	* @param transactionId the transaction ID of this transaction
	*/
	public void setTransactionId(long transactionId) {
		_transaction.setTransactionId(transactionId);
	}

	/**
	* Returns the book ID of this transaction.
	*
	* @return the book ID of this transaction
	*/
	public long getBookId() {
		return _transaction.getBookId();
	}

	/**
	* Sets the book ID of this transaction.
	*
	* @param bookId the book ID of this transaction
	*/
	public void setBookId(long bookId) {
		_transaction.setBookId(bookId);
	}

	/**
	* Returns the member ID of this transaction.
	*
	* @return the member ID of this transaction
	*/
	public long getMemberId() {
		return _transaction.getMemberId();
	}

	/**
	* Sets the member ID of this transaction.
	*
	* @param memberId the member ID of this transaction
	*/
	public void setMemberId(long memberId) {
		_transaction.setMemberId(memberId);
	}

	/**
	* Returns the tdate of this transaction.
	*
	* @return the tdate of this transaction
	*/
	public java.util.Date getTdate() {
		return _transaction.getTdate();
	}

	/**
	* Sets the tdate of this transaction.
	*
	* @param tdate the tdate of this transaction
	*/
	public void setTdate(java.util.Date tdate) {
		_transaction.setTdate(tdate);
	}

	public boolean isNew() {
		return _transaction.isNew();
	}

	public void setNew(boolean n) {
		_transaction.setNew(n);
	}

	public boolean isCachedModel() {
		return _transaction.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_transaction.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _transaction.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _transaction.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_transaction.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _transaction.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_transaction.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TransactionWrapper((Transaction)_transaction.clone());
	}

	public int compareTo(Transaction transaction) {
		return _transaction.compareTo(transaction);
	}

	@Override
	public int hashCode() {
		return _transaction.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Transaction> toCacheModel() {
		return _transaction.toCacheModel();
	}

	public Transaction toEscapedModel() {
		return new TransactionWrapper(_transaction.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _transaction.toString();
	}

	public java.lang.String toXmlString() {
		return _transaction.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_transaction.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Transaction getWrappedTransaction() {
		return _transaction;
	}

	public Transaction getWrappedModel() {
		return _transaction;
	}

	public void resetOriginalValues() {
		_transaction.resetOriginalValues();
	}

	private Transaction _transaction;
}