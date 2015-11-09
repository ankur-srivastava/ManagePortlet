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

import com.services.model.AdResponseTracker;

/**
 * The persistence interface for the ad response tracker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdResponseTrackerPersistenceImpl
 * @see AdResponseTrackerUtil
 * @generated
 */
public interface AdResponseTrackerPersistence extends BasePersistence<AdResponseTracker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdResponseTrackerUtil} to access the ad response tracker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ad response trackers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdResponseTracker> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.AdResponseTracker> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.AdResponseTracker> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad response tracker in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad response tracker
	* @throws com.services.NoSuchAdResponseTrackerException if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdResponseTracker findByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException;

	/**
	* Returns the first ad response tracker in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdResponseTracker fetchByUser_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad response tracker in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad response tracker
	* @throws com.services.NoSuchAdResponseTrackerException if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdResponseTracker findByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException;

	/**
	* Returns the last ad response tracker in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdResponseTracker fetchByUser_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.AdResponseTracker[] findByUser_PrevAndNext(
		long artId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException;

	/**
	* Removes all the ad response trackers where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad response trackers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad response trackers where adId = &#63;.
	*
	* @param adId the ad ID
	* @return the matching ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdResponseTracker> findByAdId(
		long adId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.AdResponseTracker> findByAdId(
		long adId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.AdResponseTracker> findByAdId(
		long adId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad response tracker in the ordered set where adId = &#63;.
	*
	* @param adId the ad ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad response tracker
	* @throws com.services.NoSuchAdResponseTrackerException if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdResponseTracker findByAdId_First(long adId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException;

	/**
	* Returns the first ad response tracker in the ordered set where adId = &#63;.
	*
	* @param adId the ad ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdResponseTracker fetchByAdId_First(long adId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad response tracker in the ordered set where adId = &#63;.
	*
	* @param adId the ad ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad response tracker
	* @throws com.services.NoSuchAdResponseTrackerException if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdResponseTracker findByAdId_Last(long adId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException;

	/**
	* Returns the last ad response tracker in the ordered set where adId = &#63;.
	*
	* @param adId the ad ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdResponseTracker fetchByAdId_Last(long adId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.services.model.AdResponseTracker[] findByAdId_PrevAndNext(
		long artId, long adId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException;

	/**
	* Removes all the ad response trackers where adId = &#63; from the database.
	*
	* @param adId the ad ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAdId(long adId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad response trackers where adId = &#63;.
	*
	* @param adId the ad ID
	* @return the number of matching ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public int countByAdId(long adId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the ad response tracker in the entity cache if it is enabled.
	*
	* @param adResponseTracker the ad response tracker
	*/
	public void cacheResult(
		com.services.model.AdResponseTracker adResponseTracker);

	/**
	* Caches the ad response trackers in the entity cache if it is enabled.
	*
	* @param adResponseTrackers the ad response trackers
	*/
	public void cacheResult(
		java.util.List<com.services.model.AdResponseTracker> adResponseTrackers);

	/**
	* Creates a new ad response tracker with the primary key. Does not add the ad response tracker to the database.
	*
	* @param artId the primary key for the new ad response tracker
	* @return the new ad response tracker
	*/
	public com.services.model.AdResponseTracker create(long artId);

	/**
	* Removes the ad response tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param artId the primary key of the ad response tracker
	* @return the ad response tracker that was removed
	* @throws com.services.NoSuchAdResponseTrackerException if a ad response tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdResponseTracker remove(long artId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException;

	public com.services.model.AdResponseTracker updateImpl(
		com.services.model.AdResponseTracker adResponseTracker)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad response tracker with the primary key or throws a {@link com.services.NoSuchAdResponseTrackerException} if it could not be found.
	*
	* @param artId the primary key of the ad response tracker
	* @return the ad response tracker
	* @throws com.services.NoSuchAdResponseTrackerException if a ad response tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdResponseTracker findByPrimaryKey(long artId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException;

	/**
	* Returns the ad response tracker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param artId the primary key of the ad response tracker
	* @return the ad response tracker, or <code>null</code> if a ad response tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdResponseTracker fetchByPrimaryKey(long artId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad response trackers.
	*
	* @return the ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdResponseTracker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.AdResponseTracker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.AdResponseTracker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ad response trackers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad response trackers.
	*
	* @return the number of ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}