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

import com.services.NoSuchAdCountryException;

import com.services.model.AdCountry;
import com.services.model.impl.AdCountryImpl;
import com.services.model.impl.AdCountryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ad country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdCountryPersistence
 * @see AdCountryUtil
 * @generated
 */
public class AdCountryPersistenceImpl extends BasePersistenceImpl<AdCountry>
	implements AdCountryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdCountryUtil} to access the ad country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdCountryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
			AdCountryModelImpl.FINDER_CACHE_ENABLED, AdCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
			AdCountryModelImpl.FINDER_CACHE_ENABLED, AdCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
			AdCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYSTATUS =
		new FinderPath(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
			AdCountryModelImpl.FINDER_CACHE_ENABLED, AdCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCountryStatus",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYSTATUS =
		new FinderPath(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
			AdCountryModelImpl.FINDER_CACHE_ENABLED, AdCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCountryStatus",
			new String[] { Boolean.class.getName() },
			AdCountryModelImpl.COUNTRYSTATUS_COLUMN_BITMASK |
			AdCountryModelImpl.COUNTRYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYSTATUS = new FinderPath(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
			AdCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountryStatus",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the ad countries where countryStatus = &#63;.
	 *
	 * @param countryStatus the country status
	 * @return the matching ad countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCountry> findByCountryStatus(boolean countryStatus)
		throws SystemException {
		return findByCountryStatus(countryStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad countries where countryStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryStatus the country status
	 * @param start the lower bound of the range of ad countries
	 * @param end the upper bound of the range of ad countries (not inclusive)
	 * @return the range of matching ad countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCountry> findByCountryStatus(boolean countryStatus,
		int start, int end) throws SystemException {
		return findByCountryStatus(countryStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad countries where countryStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param countryStatus the country status
	 * @param start the lower bound of the range of ad countries
	 * @param end the upper bound of the range of ad countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCountry> findByCountryStatus(boolean countryStatus,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYSTATUS;
			finderArgs = new Object[] { countryStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COUNTRYSTATUS;
			finderArgs = new Object[] {
					countryStatus,
					
					start, end, orderByComparator
				};
		}

		List<AdCountry> list = (List<AdCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdCountry adCountry : list) {
				if ((countryStatus != adCountry.getCountryStatus())) {
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

			query.append(_SQL_SELECT_ADCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYSTATUS_COUNTRYSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryStatus);

				if (!pagination) {
					list = (List<AdCountry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCountry>(list);
				}
				else {
					list = (List<AdCountry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ad country in the ordered set where countryStatus = &#63;.
	 *
	 * @param countryStatus the country status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad country
	 * @throws com.services.NoSuchAdCountryException if a matching ad country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry findByCountryStatus_First(boolean countryStatus,
		OrderByComparator orderByComparator)
		throws NoSuchAdCountryException, SystemException {
		AdCountry adCountry = fetchByCountryStatus_First(countryStatus,
				orderByComparator);

		if (adCountry != null) {
			return adCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryStatus=");
		msg.append(countryStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCountryException(msg.toString());
	}

	/**
	 * Returns the first ad country in the ordered set where countryStatus = &#63;.
	 *
	 * @param countryStatus the country status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad country, or <code>null</code> if a matching ad country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry fetchByCountryStatus_First(boolean countryStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdCountry> list = findByCountryStatus(countryStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad country in the ordered set where countryStatus = &#63;.
	 *
	 * @param countryStatus the country status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad country
	 * @throws com.services.NoSuchAdCountryException if a matching ad country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry findByCountryStatus_Last(boolean countryStatus,
		OrderByComparator orderByComparator)
		throws NoSuchAdCountryException, SystemException {
		AdCountry adCountry = fetchByCountryStatus_Last(countryStatus,
				orderByComparator);

		if (adCountry != null) {
			return adCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("countryStatus=");
		msg.append(countryStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCountryException(msg.toString());
	}

	/**
	 * Returns the last ad country in the ordered set where countryStatus = &#63;.
	 *
	 * @param countryStatus the country status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad country, or <code>null</code> if a matching ad country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry fetchByCountryStatus_Last(boolean countryStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCountryStatus(countryStatus);

		if (count == 0) {
			return null;
		}

		List<AdCountry> list = findByCountryStatus(countryStatus, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad countries before and after the current ad country in the ordered set where countryStatus = &#63;.
	 *
	 * @param countryId the primary key of the current ad country
	 * @param countryStatus the country status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad country
	 * @throws com.services.NoSuchAdCountryException if a ad country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry[] findByCountryStatus_PrevAndNext(long countryId,
		boolean countryStatus, OrderByComparator orderByComparator)
		throws NoSuchAdCountryException, SystemException {
		AdCountry adCountry = findByPrimaryKey(countryId);

		Session session = null;

		try {
			session = openSession();

			AdCountry[] array = new AdCountryImpl[3];

			array[0] = getByCountryStatus_PrevAndNext(session, adCountry,
					countryStatus, orderByComparator, true);

			array[1] = adCountry;

			array[2] = getByCountryStatus_PrevAndNext(session, adCountry,
					countryStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdCountry getByCountryStatus_PrevAndNext(Session session,
		AdCountry adCountry, boolean countryStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADCOUNTRY_WHERE);

		query.append(_FINDER_COLUMN_COUNTRYSTATUS_COUNTRYSTATUS_2);

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
			query.append(AdCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(countryStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adCountry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad countries where countryStatus = &#63; from the database.
	 *
	 * @param countryStatus the country status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCountryStatus(boolean countryStatus)
		throws SystemException {
		for (AdCountry adCountry : findByCountryStatus(countryStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adCountry);
		}
	}

	/**
	 * Returns the number of ad countries where countryStatus = &#63;.
	 *
	 * @param countryStatus the country status
	 * @return the number of matching ad countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCountryStatus(boolean countryStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYSTATUS;

		Object[] finderArgs = new Object[] { countryStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYSTATUS_COUNTRYSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryStatus);

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

	private static final String _FINDER_COLUMN_COUNTRYSTATUS_COUNTRYSTATUS_2 = "adCountry.countryStatus = ?";

	public AdCountryPersistenceImpl() {
		setModelClass(AdCountry.class);
	}

	/**
	 * Caches the ad country in the entity cache if it is enabled.
	 *
	 * @param adCountry the ad country
	 */
	@Override
	public void cacheResult(AdCountry adCountry) {
		EntityCacheUtil.putResult(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
			AdCountryImpl.class, adCountry.getPrimaryKey(), adCountry);

		adCountry.resetOriginalValues();
	}

	/**
	 * Caches the ad countries in the entity cache if it is enabled.
	 *
	 * @param adCountries the ad countries
	 */
	@Override
	public void cacheResult(List<AdCountry> adCountries) {
		for (AdCountry adCountry : adCountries) {
			if (EntityCacheUtil.getResult(
						AdCountryModelImpl.ENTITY_CACHE_ENABLED,
						AdCountryImpl.class, adCountry.getPrimaryKey()) == null) {
				cacheResult(adCountry);
			}
			else {
				adCountry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ad countries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdCountryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdCountryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ad country.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdCountry adCountry) {
		EntityCacheUtil.removeResult(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
			AdCountryImpl.class, adCountry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdCountry> adCountries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdCountry adCountry : adCountries) {
			EntityCacheUtil.removeResult(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
				AdCountryImpl.class, adCountry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ad country with the primary key. Does not add the ad country to the database.
	 *
	 * @param countryId the primary key for the new ad country
	 * @return the new ad country
	 */
	@Override
	public AdCountry create(long countryId) {
		AdCountry adCountry = new AdCountryImpl();

		adCountry.setNew(true);
		adCountry.setPrimaryKey(countryId);

		return adCountry;
	}

	/**
	 * Removes the ad country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param countryId the primary key of the ad country
	 * @return the ad country that was removed
	 * @throws com.services.NoSuchAdCountryException if a ad country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry remove(long countryId)
		throws NoSuchAdCountryException, SystemException {
		return remove((Serializable)countryId);
	}

	/**
	 * Removes the ad country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ad country
	 * @return the ad country that was removed
	 * @throws com.services.NoSuchAdCountryException if a ad country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry remove(Serializable primaryKey)
		throws NoSuchAdCountryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdCountry adCountry = (AdCountry)session.get(AdCountryImpl.class,
					primaryKey);

			if (adCountry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adCountry);
		}
		catch (NoSuchAdCountryException nsee) {
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
	protected AdCountry removeImpl(AdCountry adCountry)
		throws SystemException {
		adCountry = toUnwrappedModel(adCountry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adCountry)) {
				adCountry = (AdCountry)session.get(AdCountryImpl.class,
						adCountry.getPrimaryKeyObj());
			}

			if (adCountry != null) {
				session.delete(adCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (adCountry != null) {
			clearCache(adCountry);
		}

		return adCountry;
	}

	@Override
	public AdCountry updateImpl(com.services.model.AdCountry adCountry)
		throws SystemException {
		adCountry = toUnwrappedModel(adCountry);

		boolean isNew = adCountry.isNew();

		AdCountryModelImpl adCountryModelImpl = (AdCountryModelImpl)adCountry;

		Session session = null;

		try {
			session = openSession();

			if (adCountry.isNew()) {
				session.save(adCountry);

				adCountry.setNew(false);
			}
			else {
				session.merge(adCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdCountryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((adCountryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adCountryModelImpl.getOriginalCountryStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYSTATUS,
					args);

				args = new Object[] { adCountryModelImpl.getCountryStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COUNTRYSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COUNTRYSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
			AdCountryImpl.class, adCountry.getPrimaryKey(), adCountry);

		return adCountry;
	}

	protected AdCountry toUnwrappedModel(AdCountry adCountry) {
		if (adCountry instanceof AdCountryImpl) {
			return adCountry;
		}

		AdCountryImpl adCountryImpl = new AdCountryImpl();

		adCountryImpl.setNew(adCountry.isNew());
		adCountryImpl.setPrimaryKey(adCountry.getPrimaryKey());

		adCountryImpl.setCountryId(adCountry.getCountryId());
		adCountryImpl.setCountryName(adCountry.getCountryName());
		adCountryImpl.setCountryStatus(adCountry.isCountryStatus());
		adCountryImpl.setCreatedDate(adCountry.getCreatedDate());

		return adCountryImpl;
	}

	/**
	 * Returns the ad country with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad country
	 * @return the ad country
	 * @throws com.services.NoSuchAdCountryException if a ad country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdCountryException, SystemException {
		AdCountry adCountry = fetchByPrimaryKey(primaryKey);

		if (adCountry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return adCountry;
	}

	/**
	 * Returns the ad country with the primary key or throws a {@link com.services.NoSuchAdCountryException} if it could not be found.
	 *
	 * @param countryId the primary key of the ad country
	 * @return the ad country
	 * @throws com.services.NoSuchAdCountryException if a ad country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry findByPrimaryKey(long countryId)
		throws NoSuchAdCountryException, SystemException {
		return findByPrimaryKey((Serializable)countryId);
	}

	/**
	 * Returns the ad country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad country
	 * @return the ad country, or <code>null</code> if a ad country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AdCountry adCountry = (AdCountry)EntityCacheUtil.getResult(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
				AdCountryImpl.class, primaryKey);

		if (adCountry == _nullAdCountry) {
			return null;
		}

		if (adCountry == null) {
			Session session = null;

			try {
				session = openSession();

				adCountry = (AdCountry)session.get(AdCountryImpl.class,
						primaryKey);

				if (adCountry != null) {
					cacheResult(adCountry);
				}
				else {
					EntityCacheUtil.putResult(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
						AdCountryImpl.class, primaryKey, _nullAdCountry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AdCountryModelImpl.ENTITY_CACHE_ENABLED,
					AdCountryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return adCountry;
	}

	/**
	 * Returns the ad country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param countryId the primary key of the ad country
	 * @return the ad country, or <code>null</code> if a ad country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry fetchByPrimaryKey(long countryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)countryId);
	}

	/**
	 * Returns all the ad countries.
	 *
	 * @return the ad countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCountry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad countries
	 * @param end the upper bound of the range of ad countries (not inclusive)
	 * @return the range of ad countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCountry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad countries
	 * @param end the upper bound of the range of ad countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ad countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCountry> findAll(int start, int end,
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

		List<AdCountry> list = (List<AdCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADCOUNTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADCOUNTRY;

				if (pagination) {
					sql = sql.concat(AdCountryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdCountry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCountry>(list);
				}
				else {
					list = (List<AdCountry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ad countries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AdCountry adCountry : findAll()) {
			remove(adCountry);
		}
	}

	/**
	 * Returns the number of ad countries.
	 *
	 * @return the number of ad countries
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

				Query q = session.createQuery(_SQL_COUNT_ADCOUNTRY);

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
	 * Initializes the ad country persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.AdCountry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdCountry>> listenersList = new ArrayList<ModelListener<AdCountry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdCountry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdCountryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADCOUNTRY = "SELECT adCountry FROM AdCountry adCountry";
	private static final String _SQL_SELECT_ADCOUNTRY_WHERE = "SELECT adCountry FROM AdCountry adCountry WHERE ";
	private static final String _SQL_COUNT_ADCOUNTRY = "SELECT COUNT(adCountry) FROM AdCountry adCountry";
	private static final String _SQL_COUNT_ADCOUNTRY_WHERE = "SELECT COUNT(adCountry) FROM AdCountry adCountry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adCountry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdCountry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdCountry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdCountryPersistenceImpl.class);
	private static AdCountry _nullAdCountry = new AdCountryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdCountry> toCacheModel() {
				return _nullAdCountryCacheModel;
			}
		};

	private static CacheModel<AdCountry> _nullAdCountryCacheModel = new CacheModel<AdCountry>() {
			@Override
			public AdCountry toEntityModel() {
				return _nullAdCountry;
			}
		};
}