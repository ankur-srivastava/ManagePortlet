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
 * Provides a wrapper for {@link AdCityLocalService}.
 *
 * @author Ankur Srivastava
 * @see AdCityLocalService
 * @generated
 */
public class AdCityLocalServiceWrapper implements AdCityLocalService,
	ServiceWrapper<AdCityLocalService> {
	public AdCityLocalServiceWrapper(AdCityLocalService adCityLocalService) {
		_adCityLocalService = adCityLocalService;
	}

	/**
	* Adds the ad city to the database. Also notifies the appropriate model listeners.
	*
	* @param adCity the ad city
	* @return the ad city that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdCity addAdCity(com.services.model.AdCity adCity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.addAdCity(adCity);
	}

	/**
	* Creates a new ad city with the primary key. Does not add the ad city to the database.
	*
	* @param cityId the primary key for the new ad city
	* @return the new ad city
	*/
	@Override
	public com.services.model.AdCity createAdCity(long cityId) {
		return _adCityLocalService.createAdCity(cityId);
	}

	/**
	* Deletes the ad city with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cityId the primary key of the ad city
	* @return the ad city that was removed
	* @throws PortalException if a ad city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdCity deleteAdCity(long cityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.deleteAdCity(cityId);
	}

	/**
	* Deletes the ad city from the database. Also notifies the appropriate model listeners.
	*
	* @param adCity the ad city
	* @return the ad city that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdCity deleteAdCity(
		com.services.model.AdCity adCity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.deleteAdCity(adCity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _adCityLocalService.dynamicQuery();
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
		return _adCityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _adCityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _adCityLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _adCityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _adCityLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.services.model.AdCity fetchAdCity(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.fetchAdCity(cityId);
	}

	/**
	* Returns the ad city with the primary key.
	*
	* @param cityId the primary key of the ad city
	* @return the ad city
	* @throws PortalException if a ad city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdCity getAdCity(long cityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.getAdCity(cityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.services.model.AdCity> getAdCities(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.getAdCities(start, end);
	}

	/**
	* Returns the number of ad cities.
	*
	* @return the number of ad cities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAdCitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.getAdCitiesCount();
	}

	/**
	* Updates the ad city in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adCity the ad city
	* @return the ad city that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdCity updateAdCity(
		com.services.model.AdCity adCity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.updateAdCity(adCity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _adCityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_adCityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _adCityLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.services.model.AdCity addNewCity(
		com.services.model.AdCity cityObj)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.addNewCity(cityObj);
	}

	@Override
	public com.services.model.AdCity updateCity(com.services.model.AdCity city)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.updateCity(city);
	}

	@Override
	public java.util.List<com.services.model.AdCity> getActiveAdCityList() {
		return _adCityLocalService.getActiveAdCityList();
	}

	@Override
	public java.util.List<com.services.model.AdCity> getPopularCityList() {
		return _adCityLocalService.getPopularCityList();
	}

	@Override
	public java.util.List<com.services.model.AdCity> getAdCityByName(
		java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adCityLocalService.getAdCityByName(cityName);
	}

	@Override
	public void deleteCity(com.services.model.AdCity city)
		throws com.liferay.portal.kernel.exception.SystemException {
		_adCityLocalService.deleteCity(city);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AdCityLocalService getWrappedAdCityLocalService() {
		return _adCityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAdCityLocalService(
		AdCityLocalService adCityLocalService) {
		_adCityLocalService = adCityLocalService;
	}

	@Override
	public AdCityLocalService getWrappedService() {
		return _adCityLocalService;
	}

	@Override
	public void setWrappedService(AdCityLocalService adCityLocalService) {
		_adCityLocalService = adCityLocalService;
	}

	private AdCityLocalService _adCityLocalService;
}