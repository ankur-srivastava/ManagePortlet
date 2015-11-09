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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.services.model.AdStatsTracker;

import java.util.List;

/**
 * The persistence utility for the ad stats tracker service. This utility wraps {@link AdStatsTrackerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdStatsTrackerPersistence
 * @see AdStatsTrackerPersistenceImpl
 * @generated
 */
public class AdStatsTrackerUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AdStatsTracker adStatsTracker) {
		getPersistence().clearCache(adStatsTracker);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AdStatsTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdStatsTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdStatsTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AdStatsTracker update(AdStatsTracker adStatsTracker)
		throws SystemException {
		return getPersistence().update(adStatsTracker);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AdStatsTracker update(AdStatsTracker adStatsTracker,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(adStatsTracker, serviceContext);
	}

	/**
	* Caches the ad stats tracker in the entity cache if it is enabled.
	*
	* @param adStatsTracker the ad stats tracker
	*/
	public static void cacheResult(
		com.services.model.AdStatsTracker adStatsTracker) {
		getPersistence().cacheResult(adStatsTracker);
	}

	/**
	* Caches the ad stats trackers in the entity cache if it is enabled.
	*
	* @param adStatsTrackers the ad stats trackers
	*/
	public static void cacheResult(
		java.util.List<com.services.model.AdStatsTracker> adStatsTrackers) {
		getPersistence().cacheResult(adStatsTrackers);
	}

	/**
	* Creates a new ad stats tracker with the primary key. Does not add the ad stats tracker to the database.
	*
	* @param adId the primary key for the new ad stats tracker
	* @return the new ad stats tracker
	*/
	public static com.services.model.AdStatsTracker create(long adId) {
		return getPersistence().create(adId);
	}

	/**
	* Removes the ad stats tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adId the primary key of the ad stats tracker
	* @return the ad stats tracker that was removed
	* @throws com.services.NoSuchAdStatsTrackerException if a ad stats tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdStatsTracker remove(long adId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdStatsTrackerException {
		return getPersistence().remove(adId);
	}

	public static com.services.model.AdStatsTracker updateImpl(
		com.services.model.AdStatsTracker adStatsTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(adStatsTracker);
	}

	/**
	* Returns the ad stats tracker with the primary key or throws a {@link com.services.NoSuchAdStatsTrackerException} if it could not be found.
	*
	* @param adId the primary key of the ad stats tracker
	* @return the ad stats tracker
	* @throws com.services.NoSuchAdStatsTrackerException if a ad stats tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdStatsTracker findByPrimaryKey(long adId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdStatsTrackerException {
		return getPersistence().findByPrimaryKey(adId);
	}

	/**
	* Returns the ad stats tracker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param adId the primary key of the ad stats tracker
	* @return the ad stats tracker, or <code>null</code> if a ad stats tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdStatsTracker fetchByPrimaryKey(long adId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(adId);
	}

	/**
	* Returns all the ad stats trackers.
	*
	* @return the ad stats trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdStatsTracker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.services.model.AdStatsTracker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.services.model.AdStatsTracker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ad stats trackers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ad stats trackers.
	*
	* @return the number of ad stats trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdStatsTrackerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdStatsTrackerPersistence)PortletBeanLocatorUtil.locate(com.services.service.ClpSerializer.getServletContextName(),
					AdStatsTrackerPersistence.class.getName());

			ReferenceRegistry.registerReference(AdStatsTrackerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AdStatsTrackerPersistence persistence) {
	}

	private static AdStatsTrackerPersistence _persistence;
}