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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.services.NoSuchAdListingException;

import com.services.model.AdListing;
import com.services.model.impl.AdListingImpl;
import com.services.model.impl.AdListingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ad listing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdListingPersistence
 * @see AdListingUtil
 * @generated
 */
public class AdListingPersistenceImpl extends BasePersistenceImpl<AdListing>
	implements AdListingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdListingUtil} to access the ad listing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdListingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATID = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCatId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATID = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCatId",
			new String[] { Long.class.getName() },
			AdListingModelImpl.ADCATID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATID = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCatId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ad listings where adCatId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @return the matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCatId(long adCatId) throws SystemException {
		return findByCatId(adCatId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad listings where adCatId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adCatId the ad cat ID
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @return the range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCatId(long adCatId, int start, int end)
		throws SystemException {
		return findByCatId(adCatId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad listings where adCatId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adCatId the ad cat ID
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCatId(long adCatId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATID;
			finderArgs = new Object[] { adCatId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATID;
			finderArgs = new Object[] { adCatId, start, end, orderByComparator };
		}

		List<AdListing> list = (List<AdListing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdListing adListing : list) {
				if ((adCatId != adListing.getAdCatId())) {
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

			query.append(_SQL_SELECT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_CATID_ADCATID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdListingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(adCatId);

				if (!pagination) {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdListing>(list);
				}
				else {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first ad listing in the ordered set where adCatId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByCatId_First(long adCatId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByCatId_First(adCatId, orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adCatId=");
		msg.append(adCatId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the first ad listing in the ordered set where adCatId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByCatId_First(long adCatId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdListing> list = findByCatId(adCatId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad listing in the ordered set where adCatId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByCatId_Last(long adCatId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByCatId_Last(adCatId, orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adCatId=");
		msg.append(adCatId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the last ad listing in the ordered set where adCatId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByCatId_Last(long adCatId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCatId(adCatId);

		if (count == 0) {
			return null;
		}

		List<AdListing> list = findByCatId(adCatId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad listings before and after the current ad listing in the ordered set where adCatId = &#63;.
	 *
	 * @param adId the primary key of the current ad listing
	 * @param adCatId the ad cat ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad listing
	 * @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing[] findByCatId_PrevAndNext(long adId, long adCatId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = findByPrimaryKey(adId);

		Session session = null;

		try {
			session = openSession();

			AdListing[] array = new AdListingImpl[3];

			array[0] = getByCatId_PrevAndNext(session, adListing, adCatId,
					orderByComparator, true);

			array[1] = adListing;

			array[2] = getByCatId_PrevAndNext(session, adListing, adCatId,
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

	protected AdListing getByCatId_PrevAndNext(Session session,
		AdListing adListing, long adCatId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADLISTING_WHERE);

		query.append(_FINDER_COLUMN_CATID_ADCATID_2);

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
			query.append(AdListingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(adCatId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adListing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdListing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad listings where adCatId = &#63; from the database.
	 *
	 * @param adCatId the ad cat ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCatId(long adCatId) throws SystemException {
		for (AdListing adListing : findByCatId(adCatId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(adListing);
		}
	}

	/**
	 * Returns the number of ad listings where adCatId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @return the number of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCatId(long adCatId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATID;

		Object[] finderArgs = new Object[] { adCatId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_CATID_ADCATID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(adCatId);

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

	private static final String _FINDER_COLUMN_CATID_ADCATID_2 = "adListing.adCatId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CITYID = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCityId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID =
		new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCityId",
			new String[] { Long.class.getName() },
			AdListingModelImpl.ADCITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CITYID = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCityId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ad listings where adCityId = &#63;.
	 *
	 * @param adCityId the ad city ID
	 * @return the matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCityId(long adCityId)
		throws SystemException {
		return findByCityId(adCityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad listings where adCityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adCityId the ad city ID
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @return the range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCityId(long adCityId, int start, int end)
		throws SystemException {
		return findByCityId(adCityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad listings where adCityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adCityId the ad city ID
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCityId(long adCityId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID;
			finderArgs = new Object[] { adCityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CITYID;
			finderArgs = new Object[] { adCityId, start, end, orderByComparator };
		}

		List<AdListing> list = (List<AdListing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdListing adListing : list) {
				if ((adCityId != adListing.getAdCityId())) {
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

			query.append(_SQL_SELECT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_CITYID_ADCITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdListingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(adCityId);

				if (!pagination) {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdListing>(list);
				}
				else {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first ad listing in the ordered set where adCityId = &#63;.
	 *
	 * @param adCityId the ad city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByCityId_First(long adCityId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByCityId_First(adCityId, orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adCityId=");
		msg.append(adCityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the first ad listing in the ordered set where adCityId = &#63;.
	 *
	 * @param adCityId the ad city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByCityId_First(long adCityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdListing> list = findByCityId(adCityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad listing in the ordered set where adCityId = &#63;.
	 *
	 * @param adCityId the ad city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByCityId_Last(long adCityId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByCityId_Last(adCityId, orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adCityId=");
		msg.append(adCityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the last ad listing in the ordered set where adCityId = &#63;.
	 *
	 * @param adCityId the ad city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByCityId_Last(long adCityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCityId(adCityId);

		if (count == 0) {
			return null;
		}

		List<AdListing> list = findByCityId(adCityId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad listings before and after the current ad listing in the ordered set where adCityId = &#63;.
	 *
	 * @param adId the primary key of the current ad listing
	 * @param adCityId the ad city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad listing
	 * @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing[] findByCityId_PrevAndNext(long adId, long adCityId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = findByPrimaryKey(adId);

		Session session = null;

		try {
			session = openSession();

			AdListing[] array = new AdListingImpl[3];

			array[0] = getByCityId_PrevAndNext(session, adListing, adCityId,
					orderByComparator, true);

			array[1] = adListing;

			array[2] = getByCityId_PrevAndNext(session, adListing, adCityId,
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

	protected AdListing getByCityId_PrevAndNext(Session session,
		AdListing adListing, long adCityId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADLISTING_WHERE);

		query.append(_FINDER_COLUMN_CITYID_ADCITYID_2);

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
			query.append(AdListingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(adCityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adListing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdListing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad listings where adCityId = &#63; from the database.
	 *
	 * @param adCityId the ad city ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCityId(long adCityId) throws SystemException {
		for (AdListing adListing : findByCityId(adCityId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(adListing);
		}
	}

	/**
	 * Returns the number of ad listings where adCityId = &#63;.
	 *
	 * @param adCityId the ad city ID
	 * @return the number of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCityId(long adCityId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CITYID;

		Object[] finderArgs = new Object[] { adCityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_CITYID_ADCITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(adCityId);

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

	private static final String _FINDER_COLUMN_CITYID_ADCITYID_2 = "adListing.adCityId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICETYPE =
		new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICETYPE =
		new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServiceType",
			new String[] { String.class.getName() },
			AdListingModelImpl.ADSERVICETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICETYPE = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByServiceType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the ad listings where adServiceType = &#63;.
	 *
	 * @param adServiceType the ad service type
	 * @return the matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByServiceType(String adServiceType)
		throws SystemException {
		return findByServiceType(adServiceType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad listings where adServiceType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adServiceType the ad service type
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @return the range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByServiceType(String adServiceType, int start,
		int end) throws SystemException {
		return findByServiceType(adServiceType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad listings where adServiceType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adServiceType the ad service type
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByServiceType(String adServiceType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICETYPE;
			finderArgs = new Object[] { adServiceType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICETYPE;
			finderArgs = new Object[] {
					adServiceType,
					
					start, end, orderByComparator
				};
		}

		List<AdListing> list = (List<AdListing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdListing adListing : list) {
				if (!Validator.equals(adServiceType,
							adListing.getAdServiceType())) {
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

			query.append(_SQL_SELECT_ADLISTING_WHERE);

			boolean bindAdServiceType = false;

			if (adServiceType == null) {
				query.append(_FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_1);
			}
			else if (adServiceType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_3);
			}
			else {
				bindAdServiceType = true;

				query.append(_FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdListingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAdServiceType) {
					qPos.add(adServiceType);
				}

				if (!pagination) {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdListing>(list);
				}
				else {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first ad listing in the ordered set where adServiceType = &#63;.
	 *
	 * @param adServiceType the ad service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByServiceType_First(String adServiceType,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByServiceType_First(adServiceType,
				orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adServiceType=");
		msg.append(adServiceType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the first ad listing in the ordered set where adServiceType = &#63;.
	 *
	 * @param adServiceType the ad service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByServiceType_First(String adServiceType,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdListing> list = findByServiceType(adServiceType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad listing in the ordered set where adServiceType = &#63;.
	 *
	 * @param adServiceType the ad service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByServiceType_Last(String adServiceType,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByServiceType_Last(adServiceType,
				orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adServiceType=");
		msg.append(adServiceType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the last ad listing in the ordered set where adServiceType = &#63;.
	 *
	 * @param adServiceType the ad service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByServiceType_Last(String adServiceType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByServiceType(adServiceType);

		if (count == 0) {
			return null;
		}

		List<AdListing> list = findByServiceType(adServiceType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad listings before and after the current ad listing in the ordered set where adServiceType = &#63;.
	 *
	 * @param adId the primary key of the current ad listing
	 * @param adServiceType the ad service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad listing
	 * @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing[] findByServiceType_PrevAndNext(long adId,
		String adServiceType, OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = findByPrimaryKey(adId);

		Session session = null;

		try {
			session = openSession();

			AdListing[] array = new AdListingImpl[3];

			array[0] = getByServiceType_PrevAndNext(session, adListing,
					adServiceType, orderByComparator, true);

			array[1] = adListing;

			array[2] = getByServiceType_PrevAndNext(session, adListing,
					adServiceType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdListing getByServiceType_PrevAndNext(Session session,
		AdListing adListing, String adServiceType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADLISTING_WHERE);

		boolean bindAdServiceType = false;

		if (adServiceType == null) {
			query.append(_FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_1);
		}
		else if (adServiceType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_3);
		}
		else {
			bindAdServiceType = true;

			query.append(_FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_2);
		}

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
			query.append(AdListingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAdServiceType) {
			qPos.add(adServiceType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adListing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdListing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad listings where adServiceType = &#63; from the database.
	 *
	 * @param adServiceType the ad service type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByServiceType(String adServiceType)
		throws SystemException {
		for (AdListing adListing : findByServiceType(adServiceType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adListing);
		}
	}

	/**
	 * Returns the number of ad listings where adServiceType = &#63;.
	 *
	 * @param adServiceType the ad service type
	 * @return the number of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByServiceType(String adServiceType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SERVICETYPE;

		Object[] finderArgs = new Object[] { adServiceType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADLISTING_WHERE);

			boolean bindAdServiceType = false;

			if (adServiceType == null) {
				query.append(_FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_1);
			}
			else if (adServiceType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_3);
			}
			else {
				bindAdServiceType = true;

				query.append(_FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAdServiceType) {
					qPos.add(adServiceType);
				}

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

	private static final String _FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_1 = "adListing.adServiceType IS NULL";
	private static final String _FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_2 = "adListing.adServiceType = ?";
	private static final String _FINDER_COLUMN_SERVICETYPE_ADSERVICETYPE_3 = "(adListing.adServiceType IS NULL OR adListing.adServiceType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			AdListingModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ad listings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad listings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @return the range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad listings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<AdListing> list = (List<AdListing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdListing adListing : list) {
				if ((userId != adListing.getUserId())) {
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

			query.append(_SQL_SELECT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdListingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdListing>(list);
				}
				else {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first ad listing in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByUserId_First(userId, orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the first ad listing in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdListing> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad listing in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByUserId_Last(userId, orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the last ad listing in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<AdListing> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad listings before and after the current ad listing in the ordered set where userId = &#63;.
	 *
	 * @param adId the primary key of the current ad listing
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad listing
	 * @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing[] findByUserId_PrevAndNext(long adId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = findByPrimaryKey(adId);

		Session session = null;

		try {
			session = openSession();

			AdListing[] array = new AdListingImpl[3];

			array[0] = getByUserId_PrevAndNext(session, adListing, userId,
					orderByComparator, true);

			array[1] = adListing;

			array[2] = getByUserId_PrevAndNext(session, adListing, userId,
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

	protected AdListing getByUserId_PrevAndNext(Session session,
		AdListing adListing, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADLISTING_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(AdListingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adListing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdListing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad listings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (AdListing adListing : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(adListing);
		}
	}

	/**
	 * Returns the number of ad listings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "adListing.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAT_CITY_SERVICE =
		new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCat_City_Service",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT_CITY_SERVICE =
		new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCat_City_Service",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			AdListingModelImpl.ADCATID_COLUMN_BITMASK |
			AdListingModelImpl.ADCITYID_COLUMN_BITMASK |
			AdListingModelImpl.ADSERVICETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAT_CITY_SERVICE = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCat_City_Service",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param adServiceType the ad service type
	 * @return the matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCat_City_Service(long adCatId, long adCityId,
		String adServiceType) throws SystemException {
		return findByCat_City_Service(adCatId, adCityId, adServiceType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param adServiceType the ad service type
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @return the range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCat_City_Service(long adCatId, long adCityId,
		String adServiceType, int start, int end) throws SystemException {
		return findByCat_City_Service(adCatId, adCityId, adServiceType, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param adServiceType the ad service type
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCat_City_Service(long adCatId, long adCityId,
		String adServiceType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT_CITY_SERVICE;
			finderArgs = new Object[] { adCatId, adCityId, adServiceType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAT_CITY_SERVICE;
			finderArgs = new Object[] {
					adCatId, adCityId, adServiceType,
					
					start, end, orderByComparator
				};
		}

		List<AdListing> list = (List<AdListing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdListing adListing : list) {
				if ((adCatId != adListing.getAdCatId()) ||
						(adCityId != adListing.getAdCityId()) ||
						!Validator.equals(adServiceType,
							adListing.getAdServiceType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADCATID_2);

			query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADCITYID_2);

			boolean bindAdServiceType = false;

			if (adServiceType == null) {
				query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_1);
			}
			else if (adServiceType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_3);
			}
			else {
				bindAdServiceType = true;

				query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdListingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(adCatId);

				qPos.add(adCityId);

				if (bindAdServiceType) {
					qPos.add(adServiceType);
				}

				if (!pagination) {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdListing>(list);
				}
				else {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first ad listing in the ordered set where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param adServiceType the ad service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByCat_City_Service_First(long adCatId, long adCityId,
		String adServiceType, OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByCat_City_Service_First(adCatId, adCityId,
				adServiceType, orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adCatId=");
		msg.append(adCatId);

		msg.append(", adCityId=");
		msg.append(adCityId);

		msg.append(", adServiceType=");
		msg.append(adServiceType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the first ad listing in the ordered set where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param adServiceType the ad service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByCat_City_Service_First(long adCatId, long adCityId,
		String adServiceType, OrderByComparator orderByComparator)
		throws SystemException {
		List<AdListing> list = findByCat_City_Service(adCatId, adCityId,
				adServiceType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad listing in the ordered set where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param adServiceType the ad service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByCat_City_Service_Last(long adCatId, long adCityId,
		String adServiceType, OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByCat_City_Service_Last(adCatId, adCityId,
				adServiceType, orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adCatId=");
		msg.append(adCatId);

		msg.append(", adCityId=");
		msg.append(adCityId);

		msg.append(", adServiceType=");
		msg.append(adServiceType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the last ad listing in the ordered set where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param adServiceType the ad service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByCat_City_Service_Last(long adCatId, long adCityId,
		String adServiceType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCat_City_Service(adCatId, adCityId, adServiceType);

		if (count == 0) {
			return null;
		}

		List<AdListing> list = findByCat_City_Service(adCatId, adCityId,
				adServiceType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad listings before and after the current ad listing in the ordered set where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	 *
	 * @param adId the primary key of the current ad listing
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param adServiceType the ad service type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad listing
	 * @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing[] findByCat_City_Service_PrevAndNext(long adId,
		long adCatId, long adCityId, String adServiceType,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = findByPrimaryKey(adId);

		Session session = null;

		try {
			session = openSession();

			AdListing[] array = new AdListingImpl[3];

			array[0] = getByCat_City_Service_PrevAndNext(session, adListing,
					adCatId, adCityId, adServiceType, orderByComparator, true);

			array[1] = adListing;

			array[2] = getByCat_City_Service_PrevAndNext(session, adListing,
					adCatId, adCityId, adServiceType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdListing getByCat_City_Service_PrevAndNext(Session session,
		AdListing adListing, long adCatId, long adCityId, String adServiceType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADLISTING_WHERE);

		query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADCATID_2);

		query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADCITYID_2);

		boolean bindAdServiceType = false;

		if (adServiceType == null) {
			query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_1);
		}
		else if (adServiceType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_3);
		}
		else {
			bindAdServiceType = true;

			query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_2);
		}

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
			query.append(AdListingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(adCatId);

		qPos.add(adCityId);

		if (bindAdServiceType) {
			qPos.add(adServiceType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adListing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdListing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63; from the database.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param adServiceType the ad service type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCat_City_Service(long adCatId, long adCityId,
		String adServiceType) throws SystemException {
		for (AdListing adListing : findByCat_City_Service(adCatId, adCityId,
				adServiceType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adListing);
		}
	}

	/**
	 * Returns the number of ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param adServiceType the ad service type
	 * @return the number of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCat_City_Service(long adCatId, long adCityId,
		String adServiceType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAT_CITY_SERVICE;

		Object[] finderArgs = new Object[] { adCatId, adCityId, adServiceType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADCATID_2);

			query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADCITYID_2);

			boolean bindAdServiceType = false;

			if (adServiceType == null) {
				query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_1);
			}
			else if (adServiceType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_3);
			}
			else {
				bindAdServiceType = true;

				query.append(_FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(adCatId);

				qPos.add(adCityId);

				if (bindAdServiceType) {
					qPos.add(adServiceType);
				}

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

	private static final String _FINDER_COLUMN_CAT_CITY_SERVICE_ADCATID_2 = "adListing.adCatId = ? AND ";
	private static final String _FINDER_COLUMN_CAT_CITY_SERVICE_ADCITYID_2 = "adListing.adCityId = ? AND ";
	private static final String _FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_1 = "adListing.adServiceType IS NULL";
	private static final String _FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_2 = "adListing.adServiceType = ?";
	private static final String _FINDER_COLUMN_CAT_CITY_SERVICE_ADSERVICETYPE_3 = "(adListing.adServiceType IS NULL OR adListing.adServiceType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAT_CITY = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCat_City",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT_CITY =
		new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCat_City",
			new String[] { Long.class.getName(), Long.class.getName() },
			AdListingModelImpl.ADCATID_COLUMN_BITMASK |
			AdListingModelImpl.ADCITYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAT_CITY = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCat_City",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the ad listings where adCatId = &#63; and adCityId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @return the matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCat_City(long adCatId, long adCityId)
		throws SystemException {
		return findByCat_City(adCatId, adCityId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad listings where adCatId = &#63; and adCityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @return the range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCat_City(long adCatId, long adCityId,
		int start, int end) throws SystemException {
		return findByCat_City(adCatId, adCityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad listings where adCatId = &#63; and adCityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByCat_City(long adCatId, long adCityId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT_CITY;
			finderArgs = new Object[] { adCatId, adCityId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAT_CITY;
			finderArgs = new Object[] {
					adCatId, adCityId,
					
					start, end, orderByComparator
				};
		}

		List<AdListing> list = (List<AdListing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdListing adListing : list) {
				if ((adCatId != adListing.getAdCatId()) ||
						(adCityId != adListing.getAdCityId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_CAT_CITY_ADCATID_2);

			query.append(_FINDER_COLUMN_CAT_CITY_ADCITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdListingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(adCatId);

				qPos.add(adCityId);

				if (!pagination) {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdListing>(list);
				}
				else {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByCat_City_First(long adCatId, long adCityId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByCat_City_First(adCatId, adCityId,
				orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adCatId=");
		msg.append(adCatId);

		msg.append(", adCityId=");
		msg.append(adCityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the first ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByCat_City_First(long adCatId, long adCityId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdListing> list = findByCat_City(adCatId, adCityId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByCat_City_Last(long adCatId, long adCityId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByCat_City_Last(adCatId, adCityId,
				orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("adCatId=");
		msg.append(adCatId);

		msg.append(", adCityId=");
		msg.append(adCityId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the last ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByCat_City_Last(long adCatId, long adCityId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCat_City(adCatId, adCityId);

		if (count == 0) {
			return null;
		}

		List<AdListing> list = findByCat_City(adCatId, adCityId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad listings before and after the current ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	 *
	 * @param adId the primary key of the current ad listing
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad listing
	 * @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing[] findByCat_City_PrevAndNext(long adId, long adCatId,
		long adCityId, OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = findByPrimaryKey(adId);

		Session session = null;

		try {
			session = openSession();

			AdListing[] array = new AdListingImpl[3];

			array[0] = getByCat_City_PrevAndNext(session, adListing, adCatId,
					adCityId, orderByComparator, true);

			array[1] = adListing;

			array[2] = getByCat_City_PrevAndNext(session, adListing, adCatId,
					adCityId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdListing getByCat_City_PrevAndNext(Session session,
		AdListing adListing, long adCatId, long adCityId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADLISTING_WHERE);

		query.append(_FINDER_COLUMN_CAT_CITY_ADCATID_2);

		query.append(_FINDER_COLUMN_CAT_CITY_ADCITYID_2);

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
			query.append(AdListingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(adCatId);

		qPos.add(adCityId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adListing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdListing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad listings where adCatId = &#63; and adCityId = &#63; from the database.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCat_City(long adCatId, long adCityId)
		throws SystemException {
		for (AdListing adListing : findByCat_City(adCatId, adCityId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adListing);
		}
	}

	/**
	 * Returns the number of ad listings where adCatId = &#63; and adCityId = &#63;.
	 *
	 * @param adCatId the ad cat ID
	 * @param adCityId the ad city ID
	 * @return the number of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCat_City(long adCatId, long adCityId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAT_CITY;

		Object[] finderArgs = new Object[] { adCatId, adCityId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_CAT_CITY_ADCATID_2);

			query.append(_FINDER_COLUMN_CAT_CITY_ADCITYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(adCatId);

				qPos.add(adCityId);

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

	private static final String _FINDER_COLUMN_CAT_CITY_ADCATID_2 = "adListing.adCatId = ? AND ";
	private static final String _FINDER_COLUMN_CAT_CITY_ADCITYID_2 = "adListing.adCityId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UGC = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUGC",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UGC = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, AdListingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUGC",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			AdListingModelImpl.USERID_COLUMN_BITMASK |
			AdListingModelImpl.GROUPID_COLUMN_BITMASK |
			AdListingModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UGC = new FinderPath(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUGC",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the ad listings where userId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByUGC(long userId, long groupId, long companyId)
		throws SystemException {
		return findByUGC(userId, groupId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad listings where userId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @return the range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByUGC(long userId, long groupId, long companyId,
		int start, int end) throws SystemException {
		return findByUGC(userId, groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad listings where userId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findByUGC(long userId, long groupId, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UGC;
			finderArgs = new Object[] { userId, groupId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UGC;
			finderArgs = new Object[] {
					userId, groupId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<AdListing> list = (List<AdListing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdListing adListing : list) {
				if ((userId != adListing.getUserId()) ||
						(groupId != adListing.getGroupId()) ||
						(companyId != adListing.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_UGC_USERID_2);

			query.append(_FINDER_COLUMN_UGC_GROUPID_2);

			query.append(_FINDER_COLUMN_UGC_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdListingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdListing>(list);
				}
				else {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first ad listing in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByUGC_First(long userId, long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByUGC_First(userId, groupId, companyId,
				orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the first ad listing in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByUGC_First(long userId, long groupId,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<AdListing> list = findByUGC(userId, groupId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad listing in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing
	 * @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByUGC_Last(long userId, long groupId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByUGC_Last(userId, groupId, companyId,
				orderByComparator);

		if (adListing != null) {
			return adListing;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdListingException(msg.toString());
	}

	/**
	 * Returns the last ad listing in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByUGC_Last(long userId, long groupId, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUGC(userId, groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<AdListing> list = findByUGC(userId, groupId, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad listings before and after the current ad listing in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param adId the primary key of the current ad listing
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad listing
	 * @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing[] findByUGC_PrevAndNext(long adId, long userId,
		long groupId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = findByPrimaryKey(adId);

		Session session = null;

		try {
			session = openSession();

			AdListing[] array = new AdListingImpl[3];

			array[0] = getByUGC_PrevAndNext(session, adListing, userId,
					groupId, companyId, orderByComparator, true);

			array[1] = adListing;

			array[2] = getByUGC_PrevAndNext(session, adListing, userId,
					groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdListing getByUGC_PrevAndNext(Session session,
		AdListing adListing, long userId, long groupId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADLISTING_WHERE);

		query.append(_FINDER_COLUMN_UGC_USERID_2);

		query.append(_FINDER_COLUMN_UGC_GROUPID_2);

		query.append(_FINDER_COLUMN_UGC_COMPANYID_2);

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
			query.append(AdListingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adListing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdListing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad listings where userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUGC(long userId, long groupId, long companyId)
		throws SystemException {
		for (AdListing adListing : findByUGC(userId, groupId, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adListing);
		}
	}

	/**
	 * Returns the number of ad listings where userId = &#63; and groupId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUGC(long userId, long groupId, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UGC;

		Object[] finderArgs = new Object[] { userId, groupId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ADLISTING_WHERE);

			query.append(_FINDER_COLUMN_UGC_USERID_2);

			query.append(_FINDER_COLUMN_UGC_GROUPID_2);

			query.append(_FINDER_COLUMN_UGC_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UGC_USERID_2 = "adListing.userId = ? AND ";
	private static final String _FINDER_COLUMN_UGC_GROUPID_2 = "adListing.groupId = ? AND ";
	private static final String _FINDER_COLUMN_UGC_COMPANYID_2 = "adListing.companyId = ?";

	public AdListingPersistenceImpl() {
		setModelClass(AdListing.class);
	}

	/**
	 * Caches the ad listing in the entity cache if it is enabled.
	 *
	 * @param adListing the ad listing
	 */
	@Override
	public void cacheResult(AdListing adListing) {
		EntityCacheUtil.putResult(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingImpl.class, adListing.getPrimaryKey(), adListing);

		adListing.resetOriginalValues();
	}

	/**
	 * Caches the ad listings in the entity cache if it is enabled.
	 *
	 * @param adListings the ad listings
	 */
	@Override
	public void cacheResult(List<AdListing> adListings) {
		for (AdListing adListing : adListings) {
			if (EntityCacheUtil.getResult(
						AdListingModelImpl.ENTITY_CACHE_ENABLED,
						AdListingImpl.class, adListing.getPrimaryKey()) == null) {
				cacheResult(adListing);
			}
			else {
				adListing.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ad listings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdListingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdListingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ad listing.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdListing adListing) {
		EntityCacheUtil.removeResult(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingImpl.class, adListing.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdListing> adListings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdListing adListing : adListings) {
			EntityCacheUtil.removeResult(AdListingModelImpl.ENTITY_CACHE_ENABLED,
				AdListingImpl.class, adListing.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ad listing with the primary key. Does not add the ad listing to the database.
	 *
	 * @param adId the primary key for the new ad listing
	 * @return the new ad listing
	 */
	@Override
	public AdListing create(long adId) {
		AdListing adListing = new AdListingImpl();

		adListing.setNew(true);
		adListing.setPrimaryKey(adId);

		return adListing;
	}

	/**
	 * Removes the ad listing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param adId the primary key of the ad listing
	 * @return the ad listing that was removed
	 * @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing remove(long adId)
		throws NoSuchAdListingException, SystemException {
		return remove((Serializable)adId);
	}

	/**
	 * Removes the ad listing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ad listing
	 * @return the ad listing that was removed
	 * @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing remove(Serializable primaryKey)
		throws NoSuchAdListingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdListing adListing = (AdListing)session.get(AdListingImpl.class,
					primaryKey);

			if (adListing == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdListingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adListing);
		}
		catch (NoSuchAdListingException nsee) {
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
	protected AdListing removeImpl(AdListing adListing)
		throws SystemException {
		adListing = toUnwrappedModel(adListing);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adListing)) {
				adListing = (AdListing)session.get(AdListingImpl.class,
						adListing.getPrimaryKeyObj());
			}

			if (adListing != null) {
				session.delete(adListing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (adListing != null) {
			clearCache(adListing);
		}

		return adListing;
	}

	@Override
	public AdListing updateImpl(com.services.model.AdListing adListing)
		throws SystemException {
		adListing = toUnwrappedModel(adListing);

		boolean isNew = adListing.isNew();

		AdListingModelImpl adListingModelImpl = (AdListingModelImpl)adListing;

		Session session = null;

		try {
			session = openSession();

			if (adListing.isNew()) {
				session.save(adListing);

				adListing.setNew(false);
			}
			else {
				session.merge(adListing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdListingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((adListingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adListingModelImpl.getOriginalAdCatId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATID,
					args);

				args = new Object[] { adListingModelImpl.getAdCatId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATID,
					args);
			}

			if ((adListingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adListingModelImpl.getOriginalAdCityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID,
					args);

				args = new Object[] { adListingModelImpl.getAdCityId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYID,
					args);
			}

			if ((adListingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adListingModelImpl.getOriginalAdServiceType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICETYPE,
					args);

				args = new Object[] { adListingModelImpl.getAdServiceType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICETYPE,
					args);
			}

			if ((adListingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adListingModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { adListingModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((adListingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT_CITY_SERVICE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adListingModelImpl.getOriginalAdCatId(),
						adListingModelImpl.getOriginalAdCityId(),
						adListingModelImpl.getOriginalAdServiceType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAT_CITY_SERVICE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT_CITY_SERVICE,
					args);

				args = new Object[] {
						adListingModelImpl.getAdCatId(),
						adListingModelImpl.getAdCityId(),
						adListingModelImpl.getAdServiceType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAT_CITY_SERVICE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT_CITY_SERVICE,
					args);
			}

			if ((adListingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT_CITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adListingModelImpl.getOriginalAdCatId(),
						adListingModelImpl.getOriginalAdCityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAT_CITY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT_CITY,
					args);

				args = new Object[] {
						adListingModelImpl.getAdCatId(),
						adListingModelImpl.getAdCityId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAT_CITY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAT_CITY,
					args);
			}

			if ((adListingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UGC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adListingModelImpl.getOriginalUserId(),
						adListingModelImpl.getOriginalGroupId(),
						adListingModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UGC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UGC,
					args);

				args = new Object[] {
						adListingModelImpl.getUserId(),
						adListingModelImpl.getGroupId(),
						adListingModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UGC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UGC,
					args);
			}
		}

		EntityCacheUtil.putResult(AdListingModelImpl.ENTITY_CACHE_ENABLED,
			AdListingImpl.class, adListing.getPrimaryKey(), adListing);

		return adListing;
	}

	protected AdListing toUnwrappedModel(AdListing adListing) {
		if (adListing instanceof AdListingImpl) {
			return adListing;
		}

		AdListingImpl adListingImpl = new AdListingImpl();

		adListingImpl.setNew(adListing.isNew());
		adListingImpl.setPrimaryKey(adListing.getPrimaryKey());

		adListingImpl.setAdId(adListing.getAdId());
		adListingImpl.setAdTitle(adListing.getAdTitle());
		adListingImpl.setAdDescription(adListing.getAdDescription());
		adListingImpl.setAdCatId(adListing.getAdCatId());
		adListingImpl.setAdServiceType(adListing.getAdServiceType());
		adListingImpl.setAdCountryId(adListing.getAdCountryId());
		adListingImpl.setAdCityId(adListing.getAdCityId());
		adListingImpl.setUserId(adListing.getUserId());
		adListingImpl.setAdUserName(adListing.getAdUserName());
		adListingImpl.setAdUserEmail(adListing.getAdUserEmail());
		adListingImpl.setAdUserPhone(adListing.getAdUserPhone());
		adListingImpl.setAdStatus(adListing.isAdStatus());
		adListingImpl.setCreatedDate(adListing.getCreatedDate());
		adListingImpl.setModifiedDate(adListing.getModifiedDate());
		adListingImpl.setCompanyId(adListing.getCompanyId());
		adListingImpl.setGroupId(adListing.getGroupId());

		return adListingImpl;
	}

	/**
	 * Returns the ad listing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad listing
	 * @return the ad listing
	 * @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdListingException, SystemException {
		AdListing adListing = fetchByPrimaryKey(primaryKey);

		if (adListing == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdListingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return adListing;
	}

	/**
	 * Returns the ad listing with the primary key or throws a {@link com.services.NoSuchAdListingException} if it could not be found.
	 *
	 * @param adId the primary key of the ad listing
	 * @return the ad listing
	 * @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing findByPrimaryKey(long adId)
		throws NoSuchAdListingException, SystemException {
		return findByPrimaryKey((Serializable)adId);
	}

	/**
	 * Returns the ad listing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad listing
	 * @return the ad listing, or <code>null</code> if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AdListing adListing = (AdListing)EntityCacheUtil.getResult(AdListingModelImpl.ENTITY_CACHE_ENABLED,
				AdListingImpl.class, primaryKey);

		if (adListing == _nullAdListing) {
			return null;
		}

		if (adListing == null) {
			Session session = null;

			try {
				session = openSession();

				adListing = (AdListing)session.get(AdListingImpl.class,
						primaryKey);

				if (adListing != null) {
					cacheResult(adListing);
				}
				else {
					EntityCacheUtil.putResult(AdListingModelImpl.ENTITY_CACHE_ENABLED,
						AdListingImpl.class, primaryKey, _nullAdListing);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AdListingModelImpl.ENTITY_CACHE_ENABLED,
					AdListingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return adListing;
	}

	/**
	 * Returns the ad listing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param adId the primary key of the ad listing
	 * @return the ad listing, or <code>null</code> if a ad listing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdListing fetchByPrimaryKey(long adId) throws SystemException {
		return fetchByPrimaryKey((Serializable)adId);
	}

	/**
	 * Returns all the ad listings.
	 *
	 * @return the ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad listings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @return the range of ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad listings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad listings
	 * @param end the upper bound of the range of ad listings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ad listings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdListing> findAll(int start, int end,
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

		List<AdListing> list = (List<AdListing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADLISTING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADLISTING;

				if (pagination) {
					sql = sql.concat(AdListingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdListing>(list);
				}
				else {
					list = (List<AdListing>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the ad listings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AdListing adListing : findAll()) {
			remove(adListing);
		}
	}

	/**
	 * Returns the number of ad listings.
	 *
	 * @return the number of ad listings
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

				Query q = session.createQuery(_SQL_COUNT_ADLISTING);

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
	 * Initializes the ad listing persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.AdListing")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdListing>> listenersList = new ArrayList<ModelListener<AdListing>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdListing>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdListingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADLISTING = "SELECT adListing FROM AdListing adListing";
	private static final String _SQL_SELECT_ADLISTING_WHERE = "SELECT adListing FROM AdListing adListing WHERE ";
	private static final String _SQL_COUNT_ADLISTING = "SELECT COUNT(adListing) FROM AdListing adListing";
	private static final String _SQL_COUNT_ADLISTING_WHERE = "SELECT COUNT(adListing) FROM AdListing adListing WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adListing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdListing exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdListing exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdListingPersistenceImpl.class);
	private static AdListing _nullAdListing = new AdListingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdListing> toCacheModel() {
				return _nullAdListingCacheModel;
			}
		};

	private static CacheModel<AdListing> _nullAdListingCacheModel = new CacheModel<AdListing>() {
			@Override
			public AdListing toEntityModel() {
				return _nullAdListing;
			}
		};
}