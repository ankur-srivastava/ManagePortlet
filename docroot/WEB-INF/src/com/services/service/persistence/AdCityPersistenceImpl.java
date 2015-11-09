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

import com.services.NoSuchAdCityException;

import com.services.model.AdCity;
import com.services.model.impl.AdCityImpl;
import com.services.model.impl.AdCityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ad city service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdCityPersistence
 * @see AdCityUtil
 * @generated
 */
public class AdCityPersistenceImpl extends BasePersistenceImpl<AdCity>
	implements AdCityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdCityUtil} to access the ad city persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdCityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, AdCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, AdCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CITYSTATUS =
		new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, AdCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCityStatus",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYSTATUS =
		new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, AdCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCityStatus",
			new String[] { Boolean.class.getName() },
			AdCityModelImpl.CITYSTATUS_COLUMN_BITMASK |
			AdCityModelImpl.CITYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CITYSTATUS = new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCityStatus",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the ad cities where cityStatus = &#63;.
	 *
	 * @param cityStatus the city status
	 * @return the matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findByCityStatus(boolean cityStatus)
		throws SystemException {
		return findByCityStatus(cityStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad cities where cityStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cityStatus the city status
	 * @param start the lower bound of the range of ad cities
	 * @param end the upper bound of the range of ad cities (not inclusive)
	 * @return the range of matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findByCityStatus(boolean cityStatus, int start, int end)
		throws SystemException {
		return findByCityStatus(cityStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad cities where cityStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cityStatus the city status
	 * @param start the lower bound of the range of ad cities
	 * @param end the upper bound of the range of ad cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findByCityStatus(boolean cityStatus, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYSTATUS;
			finderArgs = new Object[] { cityStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CITYSTATUS;
			finderArgs = new Object[] { cityStatus, start, end, orderByComparator };
		}

		List<AdCity> list = (List<AdCity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdCity adCity : list) {
				if ((cityStatus != adCity.getCityStatus())) {
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

			query.append(_SQL_SELECT_ADCITY_WHERE);

			query.append(_FINDER_COLUMN_CITYSTATUS_CITYSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdCityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityStatus);

				if (!pagination) {
					list = (List<AdCity>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCity>(list);
				}
				else {
					list = (List<AdCity>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first ad city in the ordered set where cityStatus = &#63;.
	 *
	 * @param cityStatus the city status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad city
	 * @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity findByCityStatus_First(boolean cityStatus,
		OrderByComparator orderByComparator)
		throws NoSuchAdCityException, SystemException {
		AdCity adCity = fetchByCityStatus_First(cityStatus, orderByComparator);

		if (adCity != null) {
			return adCity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityStatus=");
		msg.append(cityStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCityException(msg.toString());
	}

	/**
	 * Returns the first ad city in the ordered set where cityStatus = &#63;.
	 *
	 * @param cityStatus the city status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad city, or <code>null</code> if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity fetchByCityStatus_First(boolean cityStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdCity> list = findByCityStatus(cityStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad city in the ordered set where cityStatus = &#63;.
	 *
	 * @param cityStatus the city status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad city
	 * @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity findByCityStatus_Last(boolean cityStatus,
		OrderByComparator orderByComparator)
		throws NoSuchAdCityException, SystemException {
		AdCity adCity = fetchByCityStatus_Last(cityStatus, orderByComparator);

		if (adCity != null) {
			return adCity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityStatus=");
		msg.append(cityStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCityException(msg.toString());
	}

	/**
	 * Returns the last ad city in the ordered set where cityStatus = &#63;.
	 *
	 * @param cityStatus the city status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad city, or <code>null</code> if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity fetchByCityStatus_Last(boolean cityStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCityStatus(cityStatus);

		if (count == 0) {
			return null;
		}

		List<AdCity> list = findByCityStatus(cityStatus, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad cities before and after the current ad city in the ordered set where cityStatus = &#63;.
	 *
	 * @param cityId the primary key of the current ad city
	 * @param cityStatus the city status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad city
	 * @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity[] findByCityStatus_PrevAndNext(long cityId,
		boolean cityStatus, OrderByComparator orderByComparator)
		throws NoSuchAdCityException, SystemException {
		AdCity adCity = findByPrimaryKey(cityId);

		Session session = null;

		try {
			session = openSession();

			AdCity[] array = new AdCityImpl[3];

			array[0] = getByCityStatus_PrevAndNext(session, adCity, cityStatus,
					orderByComparator, true);

			array[1] = adCity;

			array[2] = getByCityStatus_PrevAndNext(session, adCity, cityStatus,
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

	protected AdCity getByCityStatus_PrevAndNext(Session session,
		AdCity adCity, boolean cityStatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADCITY_WHERE);

		query.append(_FINDER_COLUMN_CITYSTATUS_CITYSTATUS_2);

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
			query.append(AdCityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cityStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adCity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdCity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad cities where cityStatus = &#63; from the database.
	 *
	 * @param cityStatus the city status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCityStatus(boolean cityStatus)
		throws SystemException {
		for (AdCity adCity : findByCityStatus(cityStatus, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(adCity);
		}
	}

	/**
	 * Returns the number of ad cities where cityStatus = &#63;.
	 *
	 * @param cityStatus the city status
	 * @return the number of matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCityStatus(boolean cityStatus) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CITYSTATUS;

		Object[] finderArgs = new Object[] { cityStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADCITY_WHERE);

			query.append(_FINDER_COLUMN_CITYSTATUS_CITYSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cityStatus);

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

	private static final String _FINDER_COLUMN_CITYSTATUS_CITYSTATUS_2 = "adCity.cityStatus = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CITYNAME = new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, AdCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCityName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYNAME =
		new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, AdCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCityName",
			new String[] { String.class.getName() },
			AdCityModelImpl.CITYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CITYNAME = new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCityName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the ad cities where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @return the matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findByCityName(String cityName)
		throws SystemException {
		return findByCityName(cityName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ad cities where cityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cityName the city name
	 * @param start the lower bound of the range of ad cities
	 * @param end the upper bound of the range of ad cities (not inclusive)
	 * @return the range of matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findByCityName(String cityName, int start, int end)
		throws SystemException {
		return findByCityName(cityName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad cities where cityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cityName the city name
	 * @param start the lower bound of the range of ad cities
	 * @param end the upper bound of the range of ad cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findByCityName(String cityName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYNAME;
			finderArgs = new Object[] { cityName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CITYNAME;
			finderArgs = new Object[] { cityName, start, end, orderByComparator };
		}

		List<AdCity> list = (List<AdCity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdCity adCity : list) {
				if (!Validator.equals(cityName, adCity.getCityName())) {
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

			query.append(_SQL_SELECT_ADCITY_WHERE);

			boolean bindCityName = false;

			if (cityName == null) {
				query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_1);
			}
			else if (cityName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_3);
			}
			else {
				bindCityName = true;

				query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdCityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCityName) {
					qPos.add(cityName);
				}

				if (!pagination) {
					list = (List<AdCity>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCity>(list);
				}
				else {
					list = (List<AdCity>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first ad city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad city
	 * @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity findByCityName_First(String cityName,
		OrderByComparator orderByComparator)
		throws NoSuchAdCityException, SystemException {
		AdCity adCity = fetchByCityName_First(cityName, orderByComparator);

		if (adCity != null) {
			return adCity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityName=");
		msg.append(cityName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCityException(msg.toString());
	}

	/**
	 * Returns the first ad city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad city, or <code>null</code> if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity fetchByCityName_First(String cityName,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdCity> list = findByCityName(cityName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad city
	 * @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity findByCityName_Last(String cityName,
		OrderByComparator orderByComparator)
		throws NoSuchAdCityException, SystemException {
		AdCity adCity = fetchByCityName_Last(cityName, orderByComparator);

		if (adCity != null) {
			return adCity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cityName=");
		msg.append(cityName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCityException(msg.toString());
	}

	/**
	 * Returns the last ad city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad city, or <code>null</code> if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity fetchByCityName_Last(String cityName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCityName(cityName);

		if (count == 0) {
			return null;
		}

		List<AdCity> list = findByCityName(cityName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad cities before and after the current ad city in the ordered set where cityName = &#63;.
	 *
	 * @param cityId the primary key of the current ad city
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad city
	 * @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity[] findByCityName_PrevAndNext(long cityId, String cityName,
		OrderByComparator orderByComparator)
		throws NoSuchAdCityException, SystemException {
		AdCity adCity = findByPrimaryKey(cityId);

		Session session = null;

		try {
			session = openSession();

			AdCity[] array = new AdCityImpl[3];

			array[0] = getByCityName_PrevAndNext(session, adCity, cityName,
					orderByComparator, true);

			array[1] = adCity;

			array[2] = getByCityName_PrevAndNext(session, adCity, cityName,
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

	protected AdCity getByCityName_PrevAndNext(Session session, AdCity adCity,
		String cityName, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADCITY_WHERE);

		boolean bindCityName = false;

		if (cityName == null) {
			query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_1);
		}
		else if (cityName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_3);
		}
		else {
			bindCityName = true;

			query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_2);
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
			query.append(AdCityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCityName) {
			qPos.add(cityName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adCity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdCity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad cities where cityName = &#63; from the database.
	 *
	 * @param cityName the city name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCityName(String cityName) throws SystemException {
		for (AdCity adCity : findByCityName(cityName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(adCity);
		}
	}

	/**
	 * Returns the number of ad cities where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @return the number of matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCityName(String cityName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CITYNAME;

		Object[] finderArgs = new Object[] { cityName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADCITY_WHERE);

			boolean bindCityName = false;

			if (cityName == null) {
				query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_1);
			}
			else if (cityName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_3);
			}
			else {
				bindCityName = true;

				query.append(_FINDER_COLUMN_CITYNAME_CITYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCityName) {
					qPos.add(cityName);
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

	private static final String _FINDER_COLUMN_CITYNAME_CITYNAME_1 = "adCity.cityName IS NULL";
	private static final String _FINDER_COLUMN_CITYNAME_CITYNAME_2 = "adCity.cityName = ?";
	private static final String _FINDER_COLUMN_CITYNAME_CITYNAME_3 = "(adCity.cityName IS NULL OR adCity.cityName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POPULAR = new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, AdCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypopular",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POPULAR =
		new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, AdCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypopular",
			new String[] { Boolean.class.getName() },
			AdCityModelImpl.POPULAR_COLUMN_BITMASK |
			AdCityModelImpl.CITYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POPULAR = new FinderPath(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypopular",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the ad cities where popular = &#63;.
	 *
	 * @param popular the popular
	 * @return the matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findBypopular(boolean popular)
		throws SystemException {
		return findBypopular(popular, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad cities where popular = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param popular the popular
	 * @param start the lower bound of the range of ad cities
	 * @param end the upper bound of the range of ad cities (not inclusive)
	 * @return the range of matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findBypopular(boolean popular, int start, int end)
		throws SystemException {
		return findBypopular(popular, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad cities where popular = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param popular the popular
	 * @param start the lower bound of the range of ad cities
	 * @param end the upper bound of the range of ad cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findBypopular(boolean popular, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POPULAR;
			finderArgs = new Object[] { popular };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POPULAR;
			finderArgs = new Object[] { popular, start, end, orderByComparator };
		}

		List<AdCity> list = (List<AdCity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdCity adCity : list) {
				if ((popular != adCity.getPopular())) {
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

			query.append(_SQL_SELECT_ADCITY_WHERE);

			query.append(_FINDER_COLUMN_POPULAR_POPULAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdCityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(popular);

				if (!pagination) {
					list = (List<AdCity>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCity>(list);
				}
				else {
					list = (List<AdCity>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first ad city in the ordered set where popular = &#63;.
	 *
	 * @param popular the popular
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad city
	 * @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity findBypopular_First(boolean popular,
		OrderByComparator orderByComparator)
		throws NoSuchAdCityException, SystemException {
		AdCity adCity = fetchBypopular_First(popular, orderByComparator);

		if (adCity != null) {
			return adCity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("popular=");
		msg.append(popular);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCityException(msg.toString());
	}

	/**
	 * Returns the first ad city in the ordered set where popular = &#63;.
	 *
	 * @param popular the popular
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad city, or <code>null</code> if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity fetchBypopular_First(boolean popular,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdCity> list = findBypopular(popular, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad city in the ordered set where popular = &#63;.
	 *
	 * @param popular the popular
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad city
	 * @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity findBypopular_Last(boolean popular,
		OrderByComparator orderByComparator)
		throws NoSuchAdCityException, SystemException {
		AdCity adCity = fetchBypopular_Last(popular, orderByComparator);

		if (adCity != null) {
			return adCity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("popular=");
		msg.append(popular);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCityException(msg.toString());
	}

	/**
	 * Returns the last ad city in the ordered set where popular = &#63;.
	 *
	 * @param popular the popular
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad city, or <code>null</code> if a matching ad city could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity fetchBypopular_Last(boolean popular,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBypopular(popular);

		if (count == 0) {
			return null;
		}

		List<AdCity> list = findBypopular(popular, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad cities before and after the current ad city in the ordered set where popular = &#63;.
	 *
	 * @param cityId the primary key of the current ad city
	 * @param popular the popular
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad city
	 * @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity[] findBypopular_PrevAndNext(long cityId, boolean popular,
		OrderByComparator orderByComparator)
		throws NoSuchAdCityException, SystemException {
		AdCity adCity = findByPrimaryKey(cityId);

		Session session = null;

		try {
			session = openSession();

			AdCity[] array = new AdCityImpl[3];

			array[0] = getBypopular_PrevAndNext(session, adCity, popular,
					orderByComparator, true);

			array[1] = adCity;

			array[2] = getBypopular_PrevAndNext(session, adCity, popular,
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

	protected AdCity getBypopular_PrevAndNext(Session session, AdCity adCity,
		boolean popular, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADCITY_WHERE);

		query.append(_FINDER_COLUMN_POPULAR_POPULAR_2);

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
			query.append(AdCityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(popular);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adCity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdCity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad cities where popular = &#63; from the database.
	 *
	 * @param popular the popular
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBypopular(boolean popular) throws SystemException {
		for (AdCity adCity : findBypopular(popular, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(adCity);
		}
	}

	/**
	 * Returns the number of ad cities where popular = &#63;.
	 *
	 * @param popular the popular
	 * @return the number of matching ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypopular(boolean popular) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POPULAR;

		Object[] finderArgs = new Object[] { popular };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADCITY_WHERE);

			query.append(_FINDER_COLUMN_POPULAR_POPULAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(popular);

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

	private static final String _FINDER_COLUMN_POPULAR_POPULAR_2 = "adCity.popular = ?";

	public AdCityPersistenceImpl() {
		setModelClass(AdCity.class);
	}

	/**
	 * Caches the ad city in the entity cache if it is enabled.
	 *
	 * @param adCity the ad city
	 */
	@Override
	public void cacheResult(AdCity adCity) {
		EntityCacheUtil.putResult(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityImpl.class, adCity.getPrimaryKey(), adCity);

		adCity.resetOriginalValues();
	}

	/**
	 * Caches the ad cities in the entity cache if it is enabled.
	 *
	 * @param adCities the ad cities
	 */
	@Override
	public void cacheResult(List<AdCity> adCities) {
		for (AdCity adCity : adCities) {
			if (EntityCacheUtil.getResult(
						AdCityModelImpl.ENTITY_CACHE_ENABLED, AdCityImpl.class,
						adCity.getPrimaryKey()) == null) {
				cacheResult(adCity);
			}
			else {
				adCity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ad cities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdCityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdCityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ad city.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdCity adCity) {
		EntityCacheUtil.removeResult(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityImpl.class, adCity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdCity> adCities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdCity adCity : adCities) {
			EntityCacheUtil.removeResult(AdCityModelImpl.ENTITY_CACHE_ENABLED,
				AdCityImpl.class, adCity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ad city with the primary key. Does not add the ad city to the database.
	 *
	 * @param cityId the primary key for the new ad city
	 * @return the new ad city
	 */
	@Override
	public AdCity create(long cityId) {
		AdCity adCity = new AdCityImpl();

		adCity.setNew(true);
		adCity.setPrimaryKey(cityId);

		return adCity;
	}

	/**
	 * Removes the ad city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityId the primary key of the ad city
	 * @return the ad city that was removed
	 * @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity remove(long cityId)
		throws NoSuchAdCityException, SystemException {
		return remove((Serializable)cityId);
	}

	/**
	 * Removes the ad city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ad city
	 * @return the ad city that was removed
	 * @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity remove(Serializable primaryKey)
		throws NoSuchAdCityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdCity adCity = (AdCity)session.get(AdCityImpl.class, primaryKey);

			if (adCity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdCityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adCity);
		}
		catch (NoSuchAdCityException nsee) {
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
	protected AdCity removeImpl(AdCity adCity) throws SystemException {
		adCity = toUnwrappedModel(adCity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adCity)) {
				adCity = (AdCity)session.get(AdCityImpl.class,
						adCity.getPrimaryKeyObj());
			}

			if (adCity != null) {
				session.delete(adCity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (adCity != null) {
			clearCache(adCity);
		}

		return adCity;
	}

	@Override
	public AdCity updateImpl(com.services.model.AdCity adCity)
		throws SystemException {
		adCity = toUnwrappedModel(adCity);

		boolean isNew = adCity.isNew();

		AdCityModelImpl adCityModelImpl = (AdCityModelImpl)adCity;

		Session session = null;

		try {
			session = openSession();

			if (adCity.isNew()) {
				session.save(adCity);

				adCity.setNew(false);
			}
			else {
				session.merge(adCity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdCityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((adCityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adCityModelImpl.getOriginalCityStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYSTATUS,
					args);

				args = new Object[] { adCityModelImpl.getCityStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYSTATUS,
					args);
			}

			if ((adCityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adCityModelImpl.getOriginalCityName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYNAME,
					args);

				args = new Object[] { adCityModelImpl.getCityName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CITYNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CITYNAME,
					args);
			}

			if ((adCityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POPULAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adCityModelImpl.getOriginalPopular()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POPULAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POPULAR,
					args);

				args = new Object[] { adCityModelImpl.getPopular() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POPULAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POPULAR,
					args);
			}
		}

		EntityCacheUtil.putResult(AdCityModelImpl.ENTITY_CACHE_ENABLED,
			AdCityImpl.class, adCity.getPrimaryKey(), adCity);

		return adCity;
	}

	protected AdCity toUnwrappedModel(AdCity adCity) {
		if (adCity instanceof AdCityImpl) {
			return adCity;
		}

		AdCityImpl adCityImpl = new AdCityImpl();

		adCityImpl.setNew(adCity.isNew());
		adCityImpl.setPrimaryKey(adCity.getPrimaryKey());

		adCityImpl.setCityId(adCity.getCityId());
		adCityImpl.setCityName(adCity.getCityName());
		adCityImpl.setStateName(adCity.getStateName());
		adCityImpl.setCityStatus(adCity.isCityStatus());
		adCityImpl.setPopular(adCity.isPopular());
		adCityImpl.setCreatedDate(adCity.getCreatedDate());

		return adCityImpl;
	}

	/**
	 * Returns the ad city with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad city
	 * @return the ad city
	 * @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdCityException, SystemException {
		AdCity adCity = fetchByPrimaryKey(primaryKey);

		if (adCity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdCityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return adCity;
	}

	/**
	 * Returns the ad city with the primary key or throws a {@link com.services.NoSuchAdCityException} if it could not be found.
	 *
	 * @param cityId the primary key of the ad city
	 * @return the ad city
	 * @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity findByPrimaryKey(long cityId)
		throws NoSuchAdCityException, SystemException {
		return findByPrimaryKey((Serializable)cityId);
	}

	/**
	 * Returns the ad city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad city
	 * @return the ad city, or <code>null</code> if a ad city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AdCity adCity = (AdCity)EntityCacheUtil.getResult(AdCityModelImpl.ENTITY_CACHE_ENABLED,
				AdCityImpl.class, primaryKey);

		if (adCity == _nullAdCity) {
			return null;
		}

		if (adCity == null) {
			Session session = null;

			try {
				session = openSession();

				adCity = (AdCity)session.get(AdCityImpl.class, primaryKey);

				if (adCity != null) {
					cacheResult(adCity);
				}
				else {
					EntityCacheUtil.putResult(AdCityModelImpl.ENTITY_CACHE_ENABLED,
						AdCityImpl.class, primaryKey, _nullAdCity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AdCityModelImpl.ENTITY_CACHE_ENABLED,
					AdCityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return adCity;
	}

	/**
	 * Returns the ad city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cityId the primary key of the ad city
	 * @return the ad city, or <code>null</code> if a ad city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCity fetchByPrimaryKey(long cityId) throws SystemException {
		return fetchByPrimaryKey((Serializable)cityId);
	}

	/**
	 * Returns all the ad cities.
	 *
	 * @return the ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad cities
	 * @param end the upper bound of the range of ad cities (not inclusive)
	 * @return the range of ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad cities
	 * @param end the upper bound of the range of ad cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ad cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCity> findAll(int start, int end,
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

		List<AdCity> list = (List<AdCity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADCITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADCITY;

				if (pagination) {
					sql = sql.concat(AdCityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdCity>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCity>(list);
				}
				else {
					list = (List<AdCity>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the ad cities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AdCity adCity : findAll()) {
			remove(adCity);
		}
	}

	/**
	 * Returns the number of ad cities.
	 *
	 * @return the number of ad cities
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

				Query q = session.createQuery(_SQL_COUNT_ADCITY);

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
	 * Initializes the ad city persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.AdCity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdCity>> listenersList = new ArrayList<ModelListener<AdCity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdCity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdCityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADCITY = "SELECT adCity FROM AdCity adCity";
	private static final String _SQL_SELECT_ADCITY_WHERE = "SELECT adCity FROM AdCity adCity WHERE ";
	private static final String _SQL_COUNT_ADCITY = "SELECT COUNT(adCity) FROM AdCity adCity";
	private static final String _SQL_COUNT_ADCITY_WHERE = "SELECT COUNT(adCity) FROM AdCity adCity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adCity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdCity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdCity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdCityPersistenceImpl.class);
	private static AdCity _nullAdCity = new AdCityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdCity> toCacheModel() {
				return _nullAdCityCacheModel;
			}
		};

	private static CacheModel<AdCity> _nullAdCityCacheModel = new CacheModel<AdCity>() {
			@Override
			public AdCity toEntityModel() {
				return _nullAdCity;
			}
		};
}