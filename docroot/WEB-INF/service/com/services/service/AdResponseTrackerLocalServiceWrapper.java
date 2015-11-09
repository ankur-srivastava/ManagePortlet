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

package com.services.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AdResponseTrackerLocalService}.
 *
 * @author Ankur Srivastava
 * @see AdResponseTrackerLocalService
 * @generated
 */
public class AdResponseTrackerLocalServiceWrapper
	implements AdResponseTrackerLocalService,
		ServiceWrapper<AdResponseTrackerLocalService> {
	public AdResponseTrackerLocalServiceWrapper(
		AdResponseTrackerLocalService adResponseTrackerLocalService) {
		_adResponseTrackerLocalService = adResponseTrackerLocalService;
	}

	/**
	* Adds the ad response tracker to the database. Also notifies the appropriate model listeners.
	*
	* @param adResponseTracker the ad response tracker
	* @return the ad response tracker that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdResponseTracker addAdResponseTracker(
		com.services.model.AdResponseTracker adResponseTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.addAdResponseTracker(adResponseTracker);
	}

	/**
	* Creates a new ad response tracker with the primary key. Does not add the ad response tracker to the database.
	*
	* @param artId the primary key for the new ad response tracker
	* @return the new ad response tracker
	*/
	@Override
	public com.services.model.AdResponseTracker createAdResponseTracker(
		long artId) {
		return _adResponseTrackerLocalService.createAdResponseTracker(artId);
	}

	/**
	* Deletes the ad response tracker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param artId the primary key of the ad response tracker
	* @return the ad response tracker that was removed
	* @throws PortalException if a ad response tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdResponseTracker deleteAdResponseTracker(
		long artId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.deleteAdResponseTracker(artId);
	}

	/**
	* Deletes the ad response tracker from the database. Also notifies the appropriate model listeners.
	*
	* @param adResponseTracker the ad response tracker
	* @return the ad response tracker that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdResponseTracker deleteAdResponseTracker(
		com.services.model.AdResponseTracker adResponseTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.deleteAdResponseTracker(adResponseTracker);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _adResponseTrackerLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdResponseTrackerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdResponseTrackerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.services.model.AdResponseTracker fetchAdResponseTracker(
		long artId) throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.fetchAdResponseTracker(artId);
	}

	/**
	* Returns the ad response tracker with the primary key.
	*
	* @param artId the primary key of the ad response tracker
	* @return the ad response tracker
	* @throws PortalException if a ad response tracker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdResponseTracker getAdResponseTracker(long artId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.getAdResponseTracker(artId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.services.model.AdResponseTracker> getAdResponseTrackers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.getAdResponseTrackers(start, end);
	}

	/**
	* Returns the number of ad response trackers.
	*
	* @return the number of ad response trackers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAdResponseTrackersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.getAdResponseTrackersCount();
	}

	/**
	* Updates the ad response tracker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adResponseTracker the ad response tracker
	* @return the ad response tracker that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdResponseTracker updateAdResponseTracker(
		com.services.model.AdResponseTracker adResponseTracker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.updateAdResponseTracker(adResponseTracker);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _adResponseTrackerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_adResponseTrackerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _adResponseTrackerLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void adResponse(com.services.model.AdResponseTracker trackerObj)
		throws com.liferay.portal.kernel.exception.SystemException {
		_adResponseTrackerLocalService.adResponse(trackerObj);
	}

	@Override
	public java.util.List<com.services.model.AdResponseTracker> getAdResponseTrackerList(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTrackerLocalService.getAdResponseTrackerList(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AdResponseTrackerLocalService getWrappedAdResponseTrackerLocalService() {
		return _adResponseTrackerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAdResponseTrackerLocalService(
		AdResponseTrackerLocalService adResponseTrackerLocalService) {
		_adResponseTrackerLocalService = adResponseTrackerLocalService;
	}

	@Override
	public AdResponseTrackerLocalService getWrappedService() {
		return _adResponseTrackerLocalService;
	}

	@Override
	public void setWrappedService(
		AdResponseTrackerLocalService adResponseTrackerLocalService) {
		_adResponseTrackerLocalService = adResponseTrackerLocalService;
	}

	private AdResponseTrackerLocalService _adResponseTrackerLocalService;
}