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

import com.services.model.AdResponseTracker;

import java.util.List;

/**
 * The persistence utility for the ad response tracker service. This utility wraps {@link AdResponseTrackerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdResponseTrackerPersistence
 * @see AdResponseTrackerPersistenceImpl
 * @generated
 */
public class AdResponseTrackerUtil {
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
	public static void clearCache(AdResponseTracker adResponseTracker) {
		getPersistence().clearCache(adResponseTracker);
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
	public static List<AdResponseTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdResponseTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdResponseTracker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AdResponseTracker update(AdResponseTracker adResponseTracker)
		throws SystemException {
		return getPersistence().update(adResponseTracker);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AdResponseTracker update(
		AdResponseTracker adResponseTracker, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(adResponseTracker, serviceContext);
	}

	/**
	* Returns all the ad response trackers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdResponseTracker> findByUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId);
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
	public static java.util.List<com.services.model.AdResponseTracker> findByUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end);
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
	public static java.util.List<com.services.model.AdResponseTracker> findByUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
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
	public static com.services.model.AdResponseTracker findByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first ad response tracker in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdResponseTracker fetchByUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
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
	public static com.services.model.AdResponseTracker findByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last ad response tracker in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdResponseTracker fetchByUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
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
	public static com.services.model.AdResponseTracker[] findByUser_PrevAndNext(
		long artId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException {
		return getPersistence()
				   .findByUser_PrevAndNext(artId, userId, orderByComparator);
	}

	/**
	* Removes all the ad response trackers where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of ad response trackers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(userId);
	}

	/**
	* Returns all the ad response trackers where adId = &#63;.
	*
	* @param adId the ad ID
	* @return the matching ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdResponseTracker> findByAdId(
		long adId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAdId(adId);
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
	public static java.util.List<com.services.model.AdResponseTracker> findByAdId(
		long adId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAdId(adId, start, end);
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
	public static java.util.List<com.services.model.AdResponseTracker> findByAdId(
		long adId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAdId(adId, start, end, orderByComparator);
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
	public static com.services.model.AdResponseTracker findByAdId_First(
		long adId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException {
		return getPersistence().findByAdId_First(adId, orderByComparator);
	}

	/**
	* Returns the first ad response tracker in the ordered set where adId = &#63;.
	*
	* @param adId the ad ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdResponseTracker fetchByAdId_First(
		long adId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAdId_First(adId, orderByComparator);
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
	public static com.services.model.AdResponseTracker findByAdId_Last(
		long adId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException {
		return getPersistence().findByAdId_Last(adId, orderByComparator);
	}

	/**
	* Returns the last ad response tracker in the ordered set where adId = &#63;.
	*
	* @param adId the ad ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad response tracker, or <code>null</code> if a matching ad response tracker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdResponseTracker fetchByAdId_Last(
		long adId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAdId_Last(adId, orderByComparator);
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
	public static com.services.model.AdResponseTracker[] findByAdId_PrevAndNext(
		long artId, long adId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException {
		return getPersistence()
				   .findByAdId_PrevAndNext(artId, adId, orderByComparator);
	}

	/**
	* Removes all the ad response trackers where adId = &#63; from the database.
	*
	* @param adId the ad ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAdId(long adId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAdId(adId);
	}

	/**
	* Returns the number of ad response trackers where adId = &#63;.
	*
	* @param adId the ad ID
	* @return the number of matching ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAdId(long adId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAdId(adId);
	}

	/**
	* Caches the ad response tracker in the entity cache if it is enabled.
	*
	* @param adResponseTracker the ad response tracker
	*/
	public static void cacheResult(
		com.services.model.AdResponseTracker adResponseTracker) {
		getPersistence().cacheResult(adResponseTracker);
	}

	/**
	* Caches the ad response trackers in the entity cache if it is enabled.
	*
	* @param adResponseTrackers the ad response trackers
	*/
	public static void cacheResult(
		java.util.List<com.services.model.AdResponseTracker> adResponseTrackers) {
		getPersistence().cacheResult(adResponseTrackers);
	}

	/**
	* Creates a new ad response tracker with the primary key. Does not add the ad response tracker to the database.
	*
	* @param artId the primary key for the new ad response tracker
	* @return the new ad response tracker
	*/
	public static com.services.model.AdResponseTracker create(long artId) {
		return getPersistence().create(artId);
	}

	/**
	* Removes the ad response tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param artId the primary key of the ad response tracker
	* @return the ad response tracker that was removed
	* @throws com.services.NoSuchAdResponseTrackerException if a ad response tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdResponseTracker remove(long artId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException {
		return getPersistence().remove(artId);
	}

	public static com.services.model.AdResponseTracker updateImpl(
		com.services.model.AdResponseTracker adResponseTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(adResponseTracker);
	}

	/**
	* Returns the ad response tracker with the primary key or throws a {@link com.services.NoSuchAdResponseTrackerException} if it could not be found.
	*
	* @param artId the primary key of the ad response tracker
	* @return the ad response tracker
	* @throws com.services.NoSuchAdResponseTrackerException if a ad response tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdResponseTracker findByPrimaryKey(
		long artId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdResponseTrackerException {
		return getPersistence().findByPrimaryKey(artId);
	}

	/**
	* Returns the ad response tracker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param artId the primary key of the ad response tracker
	* @return the ad response tracker, or <code>null</code> if a ad response tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdResponseTracker fetchByPrimaryKey(
		long artId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(artId);
	}

	/**
	* Returns all the ad response trackers.
	*
	* @return the ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdResponseTracker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.services.model.AdResponseTracker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.services.model.AdResponseTracker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ad response trackers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ad response trackers.
	*
	* @return the number of ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdResponseTrackerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdResponseTrackerPersistence)PortletBeanLocatorUtil.locate(com.services.service.ClpSerializer.getServletContextName(),
					AdResponseTrackerPersistence.class.getName());

			ReferenceRegistry.registerReference(AdResponseTrackerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AdResponseTrackerPersistence persistence) {
	}

	private static AdResponseTrackerPersistence _persistence;
}