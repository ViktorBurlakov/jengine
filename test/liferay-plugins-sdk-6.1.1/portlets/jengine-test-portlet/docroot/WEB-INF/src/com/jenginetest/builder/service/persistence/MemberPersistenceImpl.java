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

package com.jenginetest.builder.service.persistence;

import com.jenginetest.builder.NoSuchMemberException;
import com.jenginetest.builder.model.Member;
import com.jenginetest.builder.model.impl.MemberImpl;
import com.jenginetest.builder.model.impl.MemberModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberPersistence
 * @see MemberUtil
 * @generated
 */
public class MemberPersistenceImpl extends BasePersistenceImpl<Member>
	implements MemberPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MemberUtil} to access the member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MemberImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, MemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, MemberImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the member in the entity cache if it is enabled.
	 *
	 * @param member the member
	 */
	public void cacheResult(Member member) {
		EntityCacheUtil.putResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberImpl.class, member.getPrimaryKey(), member);

		member.resetOriginalValues();
	}

	/**
	 * Caches the members in the entity cache if it is enabled.
	 *
	 * @param members the members
	 */
	public void cacheResult(List<Member> members) {
		for (Member member : members) {
			if (EntityCacheUtil.getResult(
						MemberModelImpl.ENTITY_CACHE_ENABLED, MemberImpl.class,
						member.getPrimaryKey()) == null) {
				cacheResult(member);
			}
			else {
				member.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all members.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MemberImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MemberImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the member.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Member member) {
		EntityCacheUtil.removeResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberImpl.class, member.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Member> members) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Member member : members) {
			EntityCacheUtil.removeResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
				MemberImpl.class, member.getPrimaryKey());
		}
	}

	/**
	 * Creates a new member with the primary key. Does not add the member to the database.
	 *
	 * @param memberId the primary key for the new member
	 * @return the new member
	 */
	public Member create(long memberId) {
		Member member = new MemberImpl();

		member.setNew(true);
		member.setPrimaryKey(memberId);

		return member;
	}

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the member
	 * @return the member that was removed
	 * @throws com.jenginetest.builder.NoSuchMemberException if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Member remove(long memberId)
		throws NoSuchMemberException, SystemException {
		return remove(Long.valueOf(memberId));
	}

	/**
	 * Removes the member with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the member
	 * @return the member that was removed
	 * @throws com.jenginetest.builder.NoSuchMemberException if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member remove(Serializable primaryKey)
		throws NoSuchMemberException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Member member = (Member)session.get(MemberImpl.class, primaryKey);

			if (member == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMemberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(member);
		}
		catch (NoSuchMemberException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Member removeImpl(Member member) throws SystemException {
		member = toUnwrappedModel(member);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, member);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(member);

		return member;
	}

	@Override
	public Member updateImpl(com.jenginetest.builder.model.Member member,
		boolean merge) throws SystemException {
		member = toUnwrappedModel(member);

		boolean isNew = member.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, member, merge);

			member.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
			MemberImpl.class, member.getPrimaryKey(), member);

		return member;
	}

	protected Member toUnwrappedModel(Member member) {
		if (member instanceof MemberImpl) {
			return member;
		}

		MemberImpl memberImpl = new MemberImpl();

		memberImpl.setNew(member.isNew());
		memberImpl.setPrimaryKey(member.getPrimaryKey());

		memberImpl.setMemberId(member.getMemberId());
		memberImpl.setLibraryId(member.getLibraryId());
		memberImpl.setFirstName(member.getFirstName());
		memberImpl.setLastName(member.getLastName());

		return memberImpl;
	}

	/**
	 * Returns the member with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the member
	 * @return the member
	 * @throws com.liferay.portal.NoSuchModelException if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the member with the primary key or throws a {@link com.jenginetest.builder.NoSuchMemberException} if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member
	 * @throws com.jenginetest.builder.NoSuchMemberException if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Member findByPrimaryKey(long memberId)
		throws NoSuchMemberException, SystemException {
		Member member = fetchByPrimaryKey(memberId);

		if (member == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + memberId);
			}

			throw new NoSuchMemberException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				memberId);
		}

		return member;
	}

	/**
	 * Returns the member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the member
	 * @return the member, or <code>null</code> if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Member fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the member with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the member
	 * @return the member, or <code>null</code> if a member with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Member fetchByPrimaryKey(long memberId) throws SystemException {
		Member member = (Member)EntityCacheUtil.getResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
				MemberImpl.class, memberId);

		if (member == _nullMember) {
			return null;
		}

		if (member == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				member = (Member)session.get(MemberImpl.class,
						Long.valueOf(memberId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (member != null) {
					cacheResult(member);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(MemberModelImpl.ENTITY_CACHE_ENABLED,
						MemberImpl.class, memberId, _nullMember);
				}

				closeSession(session);
			}
		}

		return member;
	}

	/**
	 * Returns all the members.
	 *
	 * @return the members
	 * @throws SystemException if a system exception occurred
	 */
	public List<Member> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @return the range of members
	 * @throws SystemException if a system exception occurred
	 */
	public List<Member> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the members.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of members
	 * @param end the upper bound of the range of members (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of members
	 * @throws SystemException if a system exception occurred
	 */
	public List<Member> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Member> list = (List<Member>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MEMBER_);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MEMBER_;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Member>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Member>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the members from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Member member : findAll()) {
			remove(member);
		}
	}

	/**
	 * Returns the number of members.
	 *
	 * @return the number of members
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MEMBER_);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the member persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jenginetest.builder.model.Member")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Member>> listenersList = new ArrayList<ModelListener<Member>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Member>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(MemberImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AuthorPersistence.class)
	protected AuthorPersistence authorPersistence;
	@BeanReference(type = BookPersistence.class)
	protected BookPersistence bookPersistence;
	@BeanReference(type = LibraryPersistence.class)
	protected LibraryPersistence libraryPersistence;
	@BeanReference(type = MemberPersistence.class)
	protected MemberPersistence memberPersistence;
	@BeanReference(type = TransactionPersistence.class)
	protected TransactionPersistence transactionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_MEMBER_ = "SELECT member_ FROM Member member_";
	private static final String _SQL_COUNT_MEMBER_ = "SELECT COUNT(member_) FROM Member member_";
	private static final String _ORDER_BY_ENTITY_ALIAS = "member_.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Member exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MemberPersistenceImpl.class);
	private static Member _nullMember = new MemberImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Member> toCacheModel() {
				return _nullMemberCacheModel;
			}
		};

	private static CacheModel<Member> _nullMemberCacheModel = new CacheModel<Member>() {
			public Member toEntityModel() {
				return _nullMember;
			}
		};
}