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

import com.services.NoSuchAdCategoryException;

import com.services.model.AdCategory;
import com.services.model.impl.AdCategoryImpl;
import com.services.model.impl.AdCategoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ad category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdCategoryPersistence
 * @see AdCategoryUtil
 * @generated
 */
public class AdCategoryPersistenceImpl extends BasePersistenceImpl<AdCategory>
	implements AdCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdCategoryUtil} to access the ad category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			AdCategoryModelImpl.FINDER_CACHE_ENABLED, AdCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			AdCategoryModelImpl.FINDER_CACHE_ENABLED, AdCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			AdCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYSTATUS =
		new FinderPath(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			AdCategoryModelImpl.FINDER_CACHE_ENABLED, AdCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryStatus",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYSTATUS =
		new FinderPath(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			AdCategoryModelImpl.FINDER_CACHE_ENABLED, AdCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryStatus",
			new String[] { Boolean.class.getName() },
			AdCategoryModelImpl.CATEGORYSTATUS_COLUMN_BITMASK |
			AdCategoryModelImpl.CATEGORYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYSTATUS = new FinderPath(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			AdCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryStatus",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the ad categories where categoryStatus = &#63;.
	 *
	 * @param categoryStatus the category status
	 * @return the matching ad categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCategory> findByCategoryStatus(boolean categoryStatus)
		throws SystemException {
		return findByCategoryStatus(categoryStatus, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad categories where categoryStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryStatus the category status
	 * @param start the lower bound of the range of ad categories
	 * @param end the upper bound of the range of ad categories (not inclusive)
	 * @return the range of matching ad categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCategory> findByCategoryStatus(boolean categoryStatus,
		int start, int end) throws SystemException {
		return findByCategoryStatus(categoryStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad categories where categoryStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryStatus the category status
	 * @param start the lower bound of the range of ad categories
	 * @param end the upper bound of the range of ad categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCategory> findByCategoryStatus(boolean categoryStatus,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYSTATUS;
			finderArgs = new Object[] { categoryStatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYSTATUS;
			finderArgs = new Object[] {
					categoryStatus,
					
					start, end, orderByComparator
				};
		}

		List<AdCategory> list = (List<AdCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdCategory adCategory : list) {
				if ((categoryStatus != adCategory.getCategoryStatus())) {
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

			query.append(_SQL_SELECT_ADCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYSTATUS_CATEGORYSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryStatus);

				if (!pagination) {
					list = (List<AdCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCategory>(list);
				}
				else {
					list = (List<AdCategory>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ad category in the ordered set where categoryStatus = &#63;.
	 *
	 * @param categoryStatus the category status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad category
	 * @throws com.services.NoSuchAdCategoryException if a matching ad category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCategory findByCategoryStatus_First(boolean categoryStatus,
		OrderByComparator orderByComparator)
		throws NoSuchAdCategoryException, SystemException {
		AdCategory adCategory = fetchByCategoryStatus_First(categoryStatus,
				orderByComparator);

		if (adCategory != null) {
			return adCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryStatus=");
		msg.append(categoryStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCategoryException(msg.toString());
	}

	/**
	 * Returns the first ad category in the ordered set where categoryStatus = &#63;.
	 *
	 * @param categoryStatus the category status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad category, or <code>null</code> if a matching ad category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCategory fetchByCategoryStatus_First(boolean categoryStatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdCategory> list = findByCategoryStatus(categoryStatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad category in the ordered set where categoryStatus = &#63;.
	 *
	 * @param categoryStatus the category status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad category
	 * @throws com.services.NoSuchAdCategoryException if a matching ad category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCategory findByCategoryStatus_Last(boolean categoryStatus,
		OrderByComparator orderByComparator)
		throws NoSuchAdCategoryException, SystemException {
		AdCategory adCategory = fetchByCategoryStatus_Last(categoryStatus,
				orderByComparator);

		if (adCategory != null) {
			return adCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryStatus=");
		msg.append(categoryStatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCategoryException(msg.toString());
	}

	/**
	 * Returns the last ad category in the ordered set where categoryStatus = &#63;.
	 *
	 * @param categoryStatus the category status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad category, or <code>null</code> if a matching ad category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCategory fetchByCategoryStatus_Last(boolean categoryStatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryStatus(categoryStatus);

		if (count == 0) {
			return null;
		}

		List<AdCategory> list = findByCategoryStatus(categoryStatus, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad categories before and after the current ad category in the ordered set where categoryStatus = &#63;.
	 *
	 * @param categoryId the primary key of the current ad category
	 * @param categoryStatus the category status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad category
	 * @throws com.services.NoSuchAdCategoryException if a ad category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCategory[] findByCategoryStatus_PrevAndNext(long categoryId,
		boolean categoryStatus, OrderByComparator orderByComparator)
		throws NoSuchAdCategoryException, SystemException {
		AdCategory adCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			AdCategory[] array = new AdCategoryImpl[3];

			array[0] = getByCategoryStatus_PrevAndNext(session, adCategory,
					categoryStatus, orderByComparator, true);

			array[1] = adCategory;

			array[2] = getByCategoryStatus_PrevAndNext(session, adCategory,
					categoryStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdCategory getByCategoryStatus_PrevAndNext(Session session,
		AdCategory adCategory, boolean categoryStatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYSTATUS_CATEGORYSTATUS_2);

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
			query.append(AdCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryStatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad categories where categoryStatus = &#63; from the database.
	 *
	 * @param categoryStatus the category status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryStatus(boolean categoryStatus)
		throws SystemException {
		for (AdCategory adCategory : findByCategoryStatus(categoryStatus,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adCategory);
		}
	}

	/**
	 * Returns the number of ad categories where categoryStatus = &#63;.
	 *
	 * @param categoryStatus the category status
	 * @return the number of matching ad categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryStatus(boolean categoryStatus)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYSTATUS;

		Object[] finderArgs = new Object[] { categoryStatus };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYSTATUS_CATEGORYSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryStatus);

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

	private static final String _FINDER_COLUMN_CATEGORYSTATUS_CATEGORYSTATUS_2 = "adCategory.categoryStatus = ?";

	public AdCategoryPersistenceImpl() {
		setModelClass(AdCategory.class);
	}

	/**
	 * Caches the ad category in the entity cache if it is enabled.
	 *
	 * @param adCategory the ad category
	 */
	@Override
	public void cacheResult(AdCategory adCategory) {
		EntityCacheUtil.putResult(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			AdCategoryImpl.class, adCategory.getPrimaryKey(), adCategory);

		adCategory.resetOriginalValues();
	}

	/**
	 * Caches the ad categories in the entity cache if it is enabled.
	 *
	 * @param adCategories the ad categories
	 */
	@Override
	public void cacheResult(List<AdCategory> adCategories) {
		for (AdCategory adCategory : adCategories) {
			if (EntityCacheUtil.getResult(
						AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
						AdCategoryImpl.class, adCategory.getPrimaryKey()) == null) {
				cacheResult(adCategory);
			}
			else {
				adCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ad categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ad category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdCategory adCategory) {
		EntityCacheUtil.removeResult(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			AdCategoryImpl.class, adCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdCategory> adCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdCategory adCategory : adCategories) {
			EntityCacheUtil.removeResult(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
				AdCategoryImpl.class, adCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ad category with the primary key. Does not add the ad category to the database.
	 *
	 * @param categoryId the primary key for the new ad category
	 * @return the new ad category
	 */
	@Override
	public AdCategory create(long categoryId) {
		AdCategory adCategory = new AdCategoryImpl();

		adCategory.setNew(true);
		adCategory.setPrimaryKey(categoryId);

		return adCategory;
	}

	/**
	 * Removes the ad category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the ad category
	 * @return the ad category that was removed
	 * @throws com.services.NoSuchAdCategoryException if a ad category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCategory remove(long categoryId)
		throws NoSuchAdCategoryException, SystemException {
		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the ad category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ad category
	 * @return the ad category that was removed
	 * @throws com.services.NoSuchAdCategoryException if a ad category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCategory remove(Serializable primaryKey)
		throws NoSuchAdCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdCategory adCategory = (AdCategory)session.get(AdCategoryImpl.class,
					primaryKey);

			if (adCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adCategory);
		}
		catch (NoSuchAdCategoryException nsee) {
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
	protected AdCategory removeImpl(AdCategory adCategory)
		throws SystemException {
		adCategory = toUnwrappedModel(adCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adCategory)) {
				adCategory = (AdCategory)session.get(AdCategoryImpl.class,
						adCategory.getPrimaryKeyObj());
			}

			if (adCategory != null) {
				session.delete(adCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (adCategory != null) {
			clearCache(adCategory);
		}

		return adCategory;
	}

	@Override
	public AdCategory updateImpl(com.services.model.AdCategory adCategory)
		throws SystemException {
		adCategory = toUnwrappedModel(adCategory);

		boolean isNew = adCategory.isNew();

		AdCategoryModelImpl adCategoryModelImpl = (AdCategoryModelImpl)adCategory;

		Session session = null;

		try {
			session = openSession();

			if (adCategory.isNew()) {
				session.save(adCategory);

				adCategory.setNew(false);
			}
			else {
				session.merge(adCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((adCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adCategoryModelImpl.getOriginalCategoryStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYSTATUS,
					args);

				args = new Object[] { adCategoryModelImpl.getCategoryStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
			AdCategoryImpl.class, adCategory.getPrimaryKey(), adCategory);

		return adCategory;
	}

	protected AdCategory toUnwrappedModel(AdCategory adCategory) {
		if (adCategory instanceof AdCategoryImpl) {
			return adCategory;
		}

		AdCategoryImpl adCategoryImpl = new AdCategoryImpl();

		adCategoryImpl.setNew(adCategory.isNew());
		adCategoryImpl.setPrimaryKey(adCategory.getPrimaryKey());

		adCategoryImpl.setCategoryId(adCategory.getCategoryId());
		adCategoryImpl.setCategoryName(adCategory.getCategoryName());
		adCategoryImpl.setCategoryStatus(adCategory.isCategoryStatus());
		adCategoryImpl.setCreatedDate(adCategory.getCreatedDate());

		return adCategoryImpl;
	}

	/**
	 * Returns the ad category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad category
	 * @return the ad category
	 * @throws com.services.NoSuchAdCategoryException if a ad category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdCategoryException, SystemException {
		AdCategory adCategory = fetchByPrimaryKey(primaryKey);

		if (adCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return adCategory;
	}

	/**
	 * Returns the ad category with the primary key or throws a {@link com.services.NoSuchAdCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the ad category
	 * @return the ad category
	 * @throws com.services.NoSuchAdCategoryException if a ad category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCategory findByPrimaryKey(long categoryId)
		throws NoSuchAdCategoryException, SystemException {
		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the ad category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad category
	 * @return the ad category, or <code>null</code> if a ad category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AdCategory adCategory = (AdCategory)EntityCacheUtil.getResult(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
				AdCategoryImpl.class, primaryKey);

		if (adCategory == _nullAdCategory) {
			return null;
		}

		if (adCategory == null) {
			Session session = null;

			try {
				session = openSession();

				adCategory = (AdCategory)session.get(AdCategoryImpl.class,
						primaryKey);

				if (adCategory != null) {
					cacheResult(adCategory);
				}
				else {
					EntityCacheUtil.putResult(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
						AdCategoryImpl.class, primaryKey, _nullAdCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AdCategoryModelImpl.ENTITY_CACHE_ENABLED,
					AdCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return adCategory;
	}

	/**
	 * Returns the ad category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the ad category
	 * @return the ad category, or <code>null</code> if a ad category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCategory fetchByPrimaryKey(long categoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns all the ad categories.
	 *
	 * @return the ad categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad categories
	 * @param end the upper bound of the range of ad categories (not inclusive)
	 * @return the range of ad categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad categories
	 * @param end the upper bound of the range of ad categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ad categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCategory> findAll(int start, int end,
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

		List<AdCategory> list = (List<AdCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADCATEGORY;

				if (pagination) {
					sql = sql.concat(AdCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCategory>(list);
				}
				else {
					list = (List<AdCategory>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ad categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AdCategory adCategory : findAll()) {
			remove(adCategory);
		}
	}

	/**
	 * Returns the number of ad categories.
	 *
	 * @return the number of ad categories
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

				Query q = session.createQuery(_SQL_COUNT_ADCATEGORY);

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
	 * Initializes the ad category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.AdCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdCategory>> listenersList = new ArrayList<ModelListener<AdCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADCATEGORY = "SELECT adCategory FROM AdCategory adCategory";
	private static final String _SQL_SELECT_ADCATEGORY_WHERE = "SELECT adCategory FROM AdCategory adCategory WHERE ";
	private static final String _SQL_COUNT_ADCATEGORY = "SELECT COUNT(adCategory) FROM AdCategory adCategory";
	private static final String _SQL_COUNT_ADCATEGORY_WHERE = "SELECT COUNT(adCategory) FROM AdCategory adCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdCategoryPersistenceImpl.class);
	private static AdCategory _nullAdCategory = new AdCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdCategory> toCacheModel() {
				return _nullAdCategoryCacheModel;
			}
		};

	private static CacheModel<AdCategory> _nullAdCategoryCacheModel = new CacheModel<AdCategory>() {
			@Override
			public AdCategory toEntityModel() {
				return _nullAdCategory;
			}
		};
}