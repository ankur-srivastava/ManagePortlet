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
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.services.NoSuchAdStatsTrackerException;

import com.services.model.AdStatsTracker;
import com.services.model.impl.AdStatsTrackerImpl;
import com.services.model.impl.AdStatsTrackerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ad stats tracker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdStatsTrackerPersistence
 * @see AdStatsTrackerUtil
 * @generated
 */
public class AdStatsTrackerPersistenceImpl extends BasePersistenceImpl<AdStatsTracker>
	implements AdStatsTrackerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdStatsTrackerUtil} to access the ad stats tracker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdStatsTrackerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdStatsTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdStatsTrackerModelImpl.FINDER_CACHE_ENABLED,
			AdStatsTrackerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdStatsTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdStatsTrackerModelImpl.FINDER_CACHE_ENABLED,
			AdStatsTrackerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdStatsTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdStatsTrackerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AdStatsTrackerPersistenceImpl() {
		setModelClass(AdStatsTracker.class);
	}

	/**
	 * Caches the ad stats tracker in the entity cache if it is enabled.
	 *
	 * @param adStatsTracker the ad stats tracker
	 */
	@Override
	public void cacheResult(AdStatsTracker adStatsTracker) {
		EntityCacheUtil.putResult(AdStatsTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdStatsTrackerImpl.class, adStatsTracker.getPrimaryKey(),
			adStatsTracker);

		adStatsTracker.resetOriginalValues();
	}

	/**
	 * Caches the ad stats trackers in the entity cache if it is enabled.
	 *
	 * @param adStatsTrackers the ad stats trackers
	 */
	@Override
	public void cacheResult(List<AdStatsTracker> adStatsTrackers) {
		for (AdStatsTracker adStatsTracker : adStatsTrackers) {
			if (EntityCacheUtil.getResult(
						AdStatsTrackerModelImpl.ENTITY_CACHE_ENABLED,
						AdStatsTrackerImpl.class, adStatsTracker.getPrimaryKey()) == null) {
				cacheResult(adStatsTracker);
			}
			else {
				adStatsTracker.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ad stats trackers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdStatsTrackerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdStatsTrackerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ad stats tracker.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdStatsTracker adStatsTracker) {
		EntityCacheUtil.removeResult(AdStatsTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdStatsTrackerImpl.class, adStatsTracker.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdStatsTracker> adStatsTrackers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdStatsTracker adStatsTracker : adStatsTrackers) {
			EntityCacheUtil.removeResult(AdStatsTrackerModelImpl.ENTITY_CACHE_ENABLED,
				AdStatsTrackerImpl.class, adStatsTracker.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ad stats tracker with the primary key. Does not add the ad stats tracker to the database.
	 *
	 * @param adId the primary key for the new ad stats tracker
	 * @return the new ad stats tracker
	 */
	@Override
	public AdStatsTracker create(long adId) {
		AdStatsTracker adStatsTracker = new AdStatsTrackerImpl();

		adStatsTracker.setNew(true);
		adStatsTracker.setPrimaryKey(adId);

		return adStatsTracker;
	}

	/**
	 * Removes the ad stats tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param adId the primary key of the ad stats tracker
	 * @return the ad stats tracker that was removed
	 * @throws com.services.NoSuchAdStatsTrackerException if a ad stats tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdStatsTracker remove(long adId)
		throws NoSuchAdStatsTrackerException, SystemException {
		return remove((Serializable)adId);
	}

	/**
	 * Removes the ad stats tracker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ad stats tracker
	 * @return the ad stats tracker that was removed
	 * @throws com.services.NoSuchAdStatsTrackerException if a ad stats tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdStatsTracker remove(Serializable primaryKey)
		throws NoSuchAdStatsTrackerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdStatsTracker adStatsTracker = (AdStatsTracker)session.get(AdStatsTrackerImpl.class,
					primaryKey);

			if (adStatsTracker == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdStatsTrackerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adStatsTracker);
		}
		catch (NoSuchAdStatsTrackerException nsee) {
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
	protected AdStatsTracker removeImpl(AdStatsTracker adStatsTracker)
		throws SystemException {
		adStatsTracker = toUnwrappedModel(adStatsTracker);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adStatsTracker)) {
				adStatsTracker = (AdStatsTracker)session.get(AdStatsTrackerImpl.class,
						adStatsTracker.getPrimaryKeyObj());
			}

			if (adStatsTracker != null) {
				session.delete(adStatsTracker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (adStatsTracker != null) {
			clearCache(adStatsTracker);
		}

		return adStatsTracker;
	}

	@Override
	public AdStatsTracker updateImpl(
		com.services.model.AdStatsTracker adStatsTracker)
		throws SystemException {
		adStatsTracker = toUnwrappedModel(adStatsTracker);

		boolean isNew = adStatsTracker.isNew();

		Session session = null;

		try {
			session = openSession();

			if (adStatsTracker.isNew()) {
				session.save(adStatsTracker);

				adStatsTracker.setNew(false);
			}
			else {
				session.merge(adStatsTracker);
			}
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

		EntityCacheUtil.putResult(AdStatsTrackerModelImpl.ENTITY_CACHE_ENABLED,
			AdStatsTrackerImpl.class, adStatsTracker.getPrimaryKey(),
			adStatsTracker);

		return adStatsTracker;
	}

	protected AdStatsTracker toUnwrappedModel(AdStatsTracker adStatsTracker) {
		if (adStatsTracker instanceof AdStatsTrackerImpl) {
			return adStatsTracker;
		}

		AdStatsTrackerImpl adStatsTrackerImpl = new AdStatsTrackerImpl();

		adStatsTrackerImpl.setNew(adStatsTracker.isNew());
		adStatsTrackerImpl.setPrimaryKey(adStatsTracker.getPrimaryKey());

		adStatsTrackerImpl.setAdId(adStatsTracker.getAdId());
		adStatsTrackerImpl.setAdCount(adStatsTracker.getAdCount());
		adStatsTrackerImpl.setCreatedDate(adStatsTracker.getCreatedDate());
		adStatsTrackerImpl.setLastAccessedDate(adStatsTracker.getLastAccessedDate());

		return adStatsTrackerImpl;
	}

	/**
	 * Returns the ad stats tracker with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad stats tracker
	 * @return the ad stats tracker
	 * @throws com.services.NoSuchAdStatsTrackerException if a ad stats tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdStatsTracker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdStatsTrackerException, SystemException {
		AdStatsTracker adStatsTracker = fetchByPrimaryKey(primaryKey);

		if (adStatsTracker == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdStatsTrackerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return adStatsTracker;
	}

	/**
	 * Returns the ad stats tracker with the primary key or throws a {@link com.services.NoSuchAdStatsTrackerException} if it could not be found.
	 *
	 * @param adId the primary key of the ad stats tracker
	 * @return the ad stats tracker
	 * @throws com.services.NoSuchAdStatsTrackerException if a ad stats tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdStatsTracker findByPrimaryKey(long adId)
		throws NoSuchAdStatsTrackerException, SystemException {
		return findByPrimaryKey((Serializable)adId);
	}

	/**
	 * Returns the ad stats tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad stats tracker
	 * @return the ad stats tracker, or <code>null</code> if a ad stats tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdStatsTracker fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AdStatsTracker adStatsTracker = (AdStatsTracker)EntityCacheUtil.getResult(AdStatsTrackerModelImpl.ENTITY_CACHE_ENABLED,
				AdStatsTrackerImpl.class, primaryKey);

		if (adStatsTracker == _nullAdStatsTracker) {
			return null;
		}

		if (adStatsTracker == null) {
			Session session = null;

			try {
				session = openSession();

				adStatsTracker = (AdStatsTracker)session.get(AdStatsTrackerImpl.class,
						primaryKey);

				if (adStatsTracker != null) {
					cacheResult(adStatsTracker);
				}
				else {
					EntityCacheUtil.putResult(AdStatsTrackerModelImpl.ENTITY_CACHE_ENABLED,
						AdStatsTrackerImpl.class, primaryKey,
						_nullAdStatsTracker);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AdStatsTrackerModelImpl.ENTITY_CACHE_ENABLED,
					AdStatsTrackerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return adStatsTracker;
	}

	/**
	 * Returns the ad stats tracker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param adId the primary key of the ad stats tracker
	 * @return the ad stats tracker, or <code>null</code> if a ad stats tracker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdStatsTracker fetchByPrimaryKey(long adId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)adId);
	}

	/**
	 * Returns all the ad stats trackers.
	 *
	 * @return the ad stats trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdStatsTracker> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad stats trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdStatsTrackerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad stats trackers
	 * @param end the upper bound of the range of ad stats trackers (not inclusive)
	 * @return the range of ad stats trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdStatsTracker> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad stats trackers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdStatsTrackerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad stats trackers
	 * @param end the upper bound of the range of ad stats trackers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ad stats trackers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdStatsTracker> findAll(int start, int end,
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

		List<AdStatsTracker> list = (List<AdStatsTracker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADSTATSTRACKER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADSTATSTRACKER;

				if (pagination) {
					sql = sql.concat(AdStatsTrackerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdStatsTracker>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdStatsTracker>(list);
				}
				else {
					list = (List<AdStatsTracker>)QueryUtil.list(q,
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
	 * Removes all the ad stats trackers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AdStatsTracker adStatsTracker : findAll()) {
			remove(adStatsTracker);
		}
	}

	/**
	 * Returns the number of ad stats trackers.
	 *
	 * @return the number of ad stats trackers
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

				Query q = session.createQuery(_SQL_COUNT_ADSTATSTRACKER);

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
	 * Initializes the ad stats tracker persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.services.model.AdStatsTracker")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdStatsTracker>> listenersList = new ArrayList<ModelListener<AdStatsTracker>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdStatsTracker>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdStatsTrackerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADSTATSTRACKER = "SELECT adStatsTracker FROM AdStatsTracker adStatsTracker";
	private static final String _SQL_COUNT_ADSTATSTRACKER = "SELECT COUNT(adStatsTracker) FROM AdStatsTracker adStatsTracker";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adStatsTracker.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdStatsTracker exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdStatsTrackerPersistenceImpl.class);
	private static AdStatsTracker _nullAdStatsTracker = new AdStatsTrackerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdStatsTracker> toCacheModel() {
				return _nullAdStatsTrackerCacheModel;
			}
		};

	private static CacheModel<AdStatsTracker> _nullAdStatsTrackerCacheModel = new CacheModel<AdStatsTracker>() {
			@Override
			public AdStatsTracker toEntityModel() {
				return _nullAdStatsTracker;
			}
		};
}