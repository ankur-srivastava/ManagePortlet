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

import com.liferay.portal.service.persistence.BasePersistence;

import com.services.model.AdStatsTracker;

/**
 * The persistence interface for the ad stats tracker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdStatsTrackerPersistenceImpl
 * @see AdStatsTrackerUtil
 * @generated
 */
public interface AdStatsTrackerPersistence extends BasePersistence<AdStatsTracker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdStatsTrackerUtil} to access the ad stats tracker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ad stats tracker in the entity cache if it is enabled.
	*
	* @param adStatsTracker the ad stats tracker
	*/
	public void cacheResult(com.services.model.AdStatsTracker adStatsTracker);

	/**
	* Caches the ad stats trackers in the entity cache if it is enabled.
	*
	* @param adStatsTrackers the ad stats trackers
	*/
	public void cacheResult(
		java.util.List<com.services.model.AdStatsTracker> adStatsTrackers);

	/**
	* Creates a new ad stats tracker with the primary key. Does not add the ad stats tracker to the database.
	*
	* @param adId the primary key for the new ad stats tracker
	* @return the new ad stats tracker
	*/
	public com.services.model.AdStatsTracker create(long adId);

	/**
	* Removes the ad stats tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adId the primary key of the ad stats tracker
	* @return the ad stats tracker that was removed
	* @throws com.services.NoSuchAdStatsTrackerException if a ad stats tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdStatsTracker remove(long adId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdStatsTrackerException;

	public com.services.model.AdStatsTracker updateImpl(
		com.services.model.AdStatsTracker adStatsTracker)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad stats tracker with the primary key or throws a {@link com.services.NoSuchAdStatsTrackerException} if it could not be found.
	*
	* @param adId the primary key of the ad stats tracker
	* @return the ad stats tracker
	* @throws com.services.NoSuchAdStatsTrackerException if a ad stats tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdStatsTracker findByPrimaryKey(long adId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdStatsTrackerException;

	/**
	* Returns the ad stats tracker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param adId the primary key of the ad stats tracker
	* @return the ad stats tracker, or <code>null</code> if a ad stats tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdStatsTracker fetchByPrimaryKey(long adId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad stats trackers.
	*
	* @return the ad stats trackers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdStatsTracker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.AdStatsTracker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.AdStatsTracker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ad stats trackers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad stats trackers.
	*
	* @return the number of ad stats trackers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}