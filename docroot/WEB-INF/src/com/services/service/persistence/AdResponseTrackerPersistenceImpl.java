/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.services.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.services.NoSuchAdResponseTrackerException;

import com.services.model.AdResponseTracker;
import com.services.model.impl.AdResponseTrackerImpl;
import com.services.model.impl.AdResponseTrackerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ad response tracker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdResponseTrackerPersistence
 * @see AdResponseTrackerUtil
 * @generated
 */
public class AdResponseTrackerPersistenceImpl extends BasePersistenceImpl<AdResponseTracker>
	implements AdResponseTrackerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdResponseTrackerUtil} to access the ad response tracker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdResponseTrackerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerModelImpl.FINDER_CACHE_ENABLED,
			AdResponseTrackerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerModelImpl.FINDER_CACHE_ENABLED,
			AdResponseTrackerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerModelImpl.FINDER_CACHE_ENABLED,
			AdResponseTrackerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerModelImpl.FINDER_CACHE_ENABLED,
			AdResponseTrackerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			AdResponseTrackerModelImpl.USERID_COLUMN_BITMASK |
			AdResponseTrackerModelImpl.CREATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ad response trackers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdResponseTracker> findByUser(long userId)
		throws SystemException {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad response trackers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdResponseTrackerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ad response trackers
	 * @param end the upper bound of the range of ad response trackers (not inclusive)
	 * @return the range of matching ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdResponseTracker> findByUser(long userId, int start, int end)
		throws SystemException {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad response trackers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdResponseTrackerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ad response trackers
	 * @param end the upper bound of the range of ad response trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdResponseTracker> findByUser(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<AdResponseTracker> list = (List<AdResponseTracker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdResponseTracker adResponseTracker : list) {
				if ((userId != adResponseTracker.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ADRESPONSETRACKER_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdResponseTrackerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<AdResponseTracker>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdResponseTracker>(list);
				}
				else {
					list = (List<AdResponseTracker>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ad response tracker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad response tracker
	 * @throws com.services.NoSuchAdResponseTrackerException if a matching ad response tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker findByUser_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAdResponseTrackerException, SystemException {
		AdResponseTracker adResponseTracker = fetchByUser_First(userId,
				orderByComparator);

		if (adResponseTracker != null) {
			return adResponseTracker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdResponseTrackerException(msg.toString());
	}

	/**
	 * Returns the first ad response tracker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker fetchByUser_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdResponseTracker> list = findByUser(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad response tracker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad response tracker
	 * @throws com.services.NoSuchAdResponseTrackerException if a matching ad response tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker findByUser_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAdResponseTrackerException, SystemException {
		AdResponseTracker adResponseTracker = fetchByUser_Last(userId,
				orderByComparator);

		if (adResponseTracker != null) {
			return adResponseTracker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdResponseTrackerException(msg.toString());
	}

	/**
	 * Returns the last ad response tracker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker fetchByUser_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<AdResponseTracker> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad response trackers before and after the current ad response tracker in the ordered set where userId = &#63;.
	 *
	 * @param artId the primary key of the current ad response tracker
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad response tracker
	 * @throws com.services.NoSuchAdResponseTrackerException if a ad response tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker[] findByUser_PrevAndNext(long artId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAdResponseTrackerException, SystemException {
		AdResponseTracker adResponseTracker = findByPrimaryKey(artId);

		Session session = null;

		try {
			session = openSession();

			AdResponseTracker[] array = new AdResponseTrackerImpl[3];

			array[0] = getByUser_PrevAndNext(session, adResponseTracker,
					userId, orderByComparator, true);

			array[1] = adResponseTracker;

			array[2] = getByUser_PrevAndNext(session, adResponseTracker,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdResponseTracker getByUser_PrevAndNext(Session session,
		AdResponseTracker adResponseTracker, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADRESPONSETRACKER_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AdResponseTrackerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adResponseTracker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdResponseTracker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad response trackers where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUser(long userId) throws SystemException {
		for (AdResponseTracker adResponseTracker : findByUser(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adResponseTracker);
		}
	}

	/**
	 * Returns the number of ad response trackers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUser(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADRESPONSETRACKER_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USER_USERID_2 = "adResponseTracker.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ADID = new FinderPath(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerModelImpl.FINDER_CACHE_ENABLED,
			AdResponseTrackerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADID = new FinderPath(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerModelImpl.FINDER_CACHE_ENABLED,
			AdResponseTrackerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAdId",
			new String[] { Long.class.getName() },
			AdResponseTrackerModelImpl.ADID_COLUMN_BITMASK |
			AdResponseTrackerModelImpl.CREATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ADID = new FinderPath(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ad response trackers where adId = &#63;.
	 *
	 * @param adId the ad ID
	 * @return the matching ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdResponseTracker> findByAdId(long adId)
		throws SystemException {
		return findByAdId(adId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad response trackers where adId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdResponseTrackerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adId the ad ID
	 * @param start the lower bound of the range of ad response trackers
	 * @param end the upper bound of the range of ad response trackers (not inclusive)
	 * @return the range of matching ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdResponseTracker> findByAdId(long adId, int start, int end)
		throws SystemException {
		return findByAdId(adId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad response trackers where adId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdResponseTrackerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adId the ad ID
	 * @param start the lower bound of the range of ad response trackers
	 * @param end the upper bound of the range of ad response trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdResponseTracker> findByAdId(long adId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADID;
			finderArgs = new Object[] { adId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ADID;
			finderArgs = new Object[] { adId, start, end, orderByComparator };
		}

		List<AdResponseTracker> list = (List<AdResponseTracker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdResponseTracker adResponseTracker : list) {
				if ((adId != adResponseTracker.getAdId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ADRESPONSETRACKER_WHERE);

			query.append(_FINDER_COLUMN_ADID_ADID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdResponseTrackerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(adId);

				if (!pagination) {
					list = (List<AdResponseTracker>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdResponseTracker>(list);
				}
				else {
					list = (List<AdResponseTracker>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ad response tracker in the ordered set where adId = &#63;.
	 *
	 * @param adId the ad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad response tracker
	 * @throws com.services.NoSuchAdResponseTrackerException if a matching ad response tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker findByAdId_First(long adId,
		OrderByComparator orderByComparator)
		throws NoSuchAdResponseTrackerException, SystemException {
		AdResponseTracker adResponseTracker = fetchByAdId_First(adId,
				orderByComparator);

		if (adResponseTracker != null) {
			return adResponseTracker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adId=");
		msg.append(adId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdResponseTrackerException(msg.toString());
	}

	/**
	 * Returns the first ad response tracker in the ordered set where adId = &#63;.
	 *
	 * @param adId the ad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker fetchByAdId_First(long adId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdResponseTracker> list = findByAdId(adId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad response tracker in the ordered set where adId = &#63;.
	 *
	 * @param adId the ad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad response tracker
	 * @throws com.services.NoSuchAdResponseTrackerException if a matching ad response tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker findByAdId_Last(long adId,
		OrderByComparator orderByComparator)
		throws NoSuchAdResponseTrackerException, SystemException {
		AdResponseTracker adResponseTracker = fetchByAdId_Last(adId,
				orderByComparator);

		if (adResponseTracker != null) {
			return adResponseTracker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adId=");
		msg.append(adId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdResponseTrackerException(msg.toString());
	}

	/**
	 * Returns the last ad response tracker in the ordered set where adId = &#63;.
	 *
	 * @param adId the ad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker fetchByAdId_Last(long adId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAdId(adId);

		if (count == 0) {
			return null;
		}

		List<AdResponseTracker> list = findByAdId(adId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad response trackers before and after the current ad response tracker in the ordered set where adId = &#63;.
	 *
	 * @param artId the primary key of the current ad response tracker
	 * @param adId the ad ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad response tracker
	 * @throws com.services.NoSuchAdResponseTrackerException if a ad response tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker[] findByAdId_PrevAndNext(long artId, long adId,
		OrderByComparator orderByComparator)
		throws NoSuchAdResponseTrackerException, SystemException {
		AdResponseTracker adResponseTracker = findByPrimaryKey(artId);

		Session session = null;

		try {
			session = openSession();

			AdResponseTracker[] array = new AdResponseTrackerImpl[3];

			array[0] = getByAdId_PrevAndNext(session, adResponseTracker, adId,
					orderByComparator, true);

			array[1] = adResponseTracker;

			array[2] = getByAdId_PrevAndNext(session, adResponseTracker, adId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdResponseTracker getByAdId_PrevAndNext(Session session,
		AdResponseTracker adResponseTracker, long adId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADRESPONSETRACKER_WHERE);

		query.append(_FINDER_COLUMN_ADID_ADID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AdResponseTrackerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(adId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adResponseTracker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdResponseTracker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad response trackers where adId = &#63; from the database.
	 *
	 * @param adId the ad ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAdId(long adId) throws SystemException {
		for (AdResponseTracker adResponseTracker : findByAdId(adId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adResponseTracker);
		}
	}

	/**
	 * Returns the number of ad response trackers where adId = &#63;.
	 *
	 * @param adId the ad ID
	 * @return the number of matching ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAdId(long adId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ADID;

		Object[] finderArgs = new Object[] { adId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADRESPONSETRACKER_WHERE);

			query.append(_FINDER_COLUMN_ADID_ADID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(adId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ADID_ADID_2 = "adResponseTracker.adId = ?";

	public AdResponseTrackerPersistenceImpl() {
		setModelClass(AdResponseTracker.class);
	}

	/**
	 * Caches the ad response tracker in the entity cache if it is enabled.
	 *
	 * @param adResponseTracker the ad response tracker
	 */
	@Override
	public void cacheResult(AdResponseTracker adResponseTracker) {
		EntityCacheUtil.putResult(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerImpl.class, adResponseTracker.getPrimaryKey(),
			adResponseTracker);

		adResponseTracker.resetOriginalValues();
	}

	/**
	 * Caches the ad response trackers in the entity cache if it is enabled.
	 *
	 * @param adResponseTrackers the ad response trackers
	 */
	@Override
	public void cacheResult(List<AdResponseTracker> adResponseTrackers) {
		for (AdResponseTracker adResponseTracker : adResponseTrackers) {
			if (EntityCacheUtil.getResult(
						AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
						AdResponseTrackerImpl.class,
						adResponseTracker.getPrimaryKey()) == null) {
				cacheResult(adResponseTracker);
			}
			else {
				adResponseTracker.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ad response trackers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdResponseTrackerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdResponseTrackerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ad response tracker.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdResponseTracker adResponseTracker) {
		EntityCacheUtil.removeResult(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerImpl.class, adResponseTracker.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdResponseTracker> adResponseTrackers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdResponseTracker adResponseTracker : adResponseTrackers) {
			EntityCacheUtil.removeResult(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
				AdResponseTrackerImpl.class, adResponseTracker.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ad response tracker with the primary key. Does not add the ad response tracker to the database.
	 *
	 * @param artId the primary key for the new ad response tracker
	 * @return the new ad response tracker
	 */
	@Override
	public AdResponseTracker create(long artId) {
		AdResponseTracker adResponseTracker = new AdResponseTrackerImpl();

		adResponseTracker.setNew(true);
		adResponseTracker.setPrimaryKey(artId);

		return adResponseTracker;
	}

	/**
	 * Removes the ad response tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param artId the primary key of the ad response tracker
	 * @return the ad response tracker that was removed
	 * @throws com.services.NoSuchAdResponseTrackerException if a ad response tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker remove(long artId)
		throws NoSuchAdResponseTrackerException, SystemException {
		return remove((Serializable)artId);
	}

	/**
	 * Removes the ad response tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ad response tracker
	 * @return the ad response tracker that was removed
	 * @throws com.services.NoSuchAdResponseTrackerException if a ad response tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker remove(Serializable primaryKey)
		throws NoSuchAdResponseTrackerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdResponseTracker adResponseTracker = (AdResponseTracker)session.get(AdResponseTrackerImpl.class,
					primaryKey);

			if (adResponseTracker == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdResponseTrackerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adResponseTracker);
		}
		catch (NoSuchAdResponseTrackerException nsee) {
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
	protected AdResponseTracker removeImpl(AdResponseTracker adResponseTracker)
		throws SystemException {
		adResponseTracker = toUnwrappedModel(adResponseTracker);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adResponseTracker)) {
				adResponseTracker = (AdResponseTracker)session.get(AdResponseTrackerImpl.class,
						adResponseTracker.getPrimaryKeyObj());
			}

			if (adResponseTracker != null) {
				session.delete(adResponseTracker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (adResponseTracker != null) {
			clearCache(adResponseTracker);
		}

		return adResponseTracker;
	}

	@Override
	public AdResponseTracker updateImpl(
		com.services.model.AdResponseTracker adResponseTracker)
		throws SystemException {
		adResponseTracker = toUnwrappedModel(adResponseTracker);

		boolean isNew = adResponseTracker.isNew();

		AdResponseTrackerModelImpl adResponseTrackerModelImpl = (AdResponseTrackerModelImpl)adResponseTracker;

		Session session = null;

		try {
			session = openSession();

			if (adResponseTracker.isNew()) {
				session.save(adResponseTracker);

				adResponseTracker.setNew(false);
			}
			else {
				session.merge(adResponseTracker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdResponseTrackerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((adResponseTrackerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adResponseTrackerModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { adResponseTrackerModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((adResponseTrackerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adResponseTrackerModelImpl.getOriginalAdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADID,
					args);

				args = new Object[] { adResponseTrackerModelImpl.getAdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ADID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ADID,
					args);
			}
		}

		EntityCacheUtil.putResult(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdResponseTrackerImpl.class, adResponseTracker.getPrimaryKey(),
			adResponseTracker);

		return adResponseTracker;
	}

	protected AdResponseTracker toUnwrappedModel(
		AdResponseTracker adResponseTracker) {
		if (adResponseTracker instanceof AdResponseTrackerImpl) {
			return adResponseTracker;
		}

		AdResponseTrackerImpl adResponseTrackerImpl = new AdResponseTrackerImpl();

		adResponseTrackerImpl.setNew(adResponseTracker.isNew());
		adResponseTrackerImpl.setPrimaryKey(adResponseTracker.getPrimaryKey());

		adResponseTrackerImpl.setArtId(adResponseTracker.getArtId());
		adResponseTrackerImpl.setAdId(adResponseTracker.getAdId());
		adResponseTrackerImpl.setUserId(adResponseTracker.getUserId());
		adResponseTrackerImpl.setName(adResponseTracker.getName());
		adResponseTrackerImpl.setEmail(adResponseTracker.getEmail());
		adResponseTrackerImpl.setPhone(adResponseTracker.getPhone());
		adResponseTrackerImpl.setComments(adResponseTracker.getComments());
		adResponseTrackerImpl.setUserIP(adResponseTracker.getUserIP());
		adResponseTrackerImpl.setCreatedDate(adResponseTracker.getCreatedDate());

		return adResponseTrackerImpl;
	}

	/**
	 * Returns the ad response tracker with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad response tracker
	 * @return the ad response tracker
	 * @throws com.services.NoSuchAdResponseTrackerException if a ad response tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdResponseTrackerException, SystemException {
		AdResponseTracker adResponseTracker = fetchByPrimaryKey(primaryKey);

		if (adResponseTracker == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdResponseTrackerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return adResponseTracker;
	}

	/**
	 * Returns the ad response tracker with the primary key or throws a {@link com.services.NoSuchAdResponseTrackerException} if it could not be found.
	 *
	 * @param artId the primary key of the ad response tracker
	 * @return the ad response tracker
	 * @throws com.services.NoSuchAdResponseTrackerException if a ad response tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker findByPrimaryKey(long artId)
		throws NoSuchAdResponseTrackerException, SystemException {
		return findByPrimaryKey((Serializable)artId);
	}

	/**
	 * Returns the ad response tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad response tracker
	 * @return the ad response tracker, or <code>null</code> if a ad response tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AdResponseTracker adResponseTracker = (AdResponseTracker)EntityCacheUtil.getResult(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
				AdResponseTrackerImpl.class, primaryKey);

		if (adResponseTracker == _nullAdResponseTracker) {
			return null;
		}

		if (adResponseTracker == null) {
			Session session = null;

			try {
				session = openSession();

				adResponseTracker = (AdResponseTracker)session.get(AdResponseTrackerImpl.class,
						primaryKey);

				if (adResponseTracker != null) {
					cacheResult(adResponseTracker);
				}
				else {
					EntityCacheUtil.putResult(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
						AdResponseTrackerImpl.class, primaryKey,
						_nullAdResponseTracker);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AdResponseTrackerModelImpl.ENTITY_CACHE_ENABLED,
					AdResponseTrackerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return adResponseTracker;
	}

	/**
	 * Returns the ad response tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param artId the primary key of the ad response tracker
	 * @return the ad response tracker, or <code>null</code> if a ad response tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdResponseTracker fetchByPrimaryKey(long artId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)artId);
	}

	/**
	 * Returns all the ad response trackers.
	 *
	 * @return the ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdResponseTracker> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad response trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdResponseTrackerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad response trackers
	 * @param end the upper bound of the range of ad response trackers (not inclusive)
	 * @return the range of ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdResponseTracker> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad response trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdResponseTrackerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad response trackers
	 * @param end the upper bound of the range of ad response trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdResponseTracker> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<AdResponseTracker> list = (List<AdResponseTracker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADRESPONSETRACKER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADRESPONSETRACKER;

				if (pagination) {
					sql = sql.concat(AdResponseTrackerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdResponseTracker>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdResponseTracker>(list);
				}
				else {
					list = (List<AdResponseTracker>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ad response trackers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AdResponseTracker adResponseTracker : findAll()) {
			remove(adResponseTracker);
		}
	}

	/**
	 * Returns the number of ad response trackers.
	 *
	 * @return the number of ad response trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ADRESPONSETRACKER);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the ad response tracker persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.AdResponseTracker")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdResponseTracker>> listenersList = new ArrayList<ModelListener<AdResponseTracker>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdResponseTracker>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(AdResponseTrackerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADRESPONSETRACKER = "SELECT adResponseTracker FROM AdResponseTracker adResponseTracker";
	private static final String _SQL_SELECT_ADRESPONSETRACKER_WHERE = "SELECT adResponseTracker FROM AdResponseTracker adResponseTracker WHERE ";
	private static final String _SQL_COUNT_ADRESPONSETRACKER = "SELECT COUNT(adResponseTracker) FROM AdResponseTracker adResponseTracker";
	private static final String _SQL_COUNT_ADRESPONSETRACKER_WHERE = "SELECT COUNT(adResponseTracker) FROM AdResponseTracker adResponseTracker WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adResponseTracker.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdResponseTracker exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdResponseTracker exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdResponseTrackerPersistenceImpl.class);
	private static AdResponseTracker _nullAdResponseTracker = new AdResponseTrackerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdResponseTracker> toCacheModel() {
				return _nullAdResponseTrackerCacheModel;
			}
		};

	private static CacheModel<AdResponseTracker> _nullAdResponseTrackerCacheModel =
		new CacheModel<AdResponseTracker>() {
			@Override
			public AdResponseTracker toEntityModel() {
				return _nullAdResponseTracker;
			}
		};
}