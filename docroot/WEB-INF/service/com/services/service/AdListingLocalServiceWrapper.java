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
 * Provides a wrapper for {@link AdListingLocalService}.
 *
 * @author Ankur Srivastava
 * @see AdListingLocalService
 * @generated
 */
public class AdListingLocalServiceWrapper implements AdListingLocalService,
	ServiceWrapper<AdListingLocalService> {
	public AdListingLocalServiceWrapper(
		AdListingLocalService adListingLocalService) {
		_adListingLocalService = adListingLocalService;
	}

	/**
	* Adds the ad listing to the database. Also notifies the appropriate model listeners.
	*
	* @param adListing the ad listing
	* @return the ad listing that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdListing addAdListing(
		com.services.model.AdListing adListing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.addAdListing(adListing);
	}

	/**
	* Creates a new ad listing with the primary key. Does not add the ad listing to the database.
	*
	* @param adId the primary key for the new ad listing
	* @return the new ad listing
	*/
	@Override
	public com.services.model.AdListing createAdListing(long adId) {
		return _adListingLocalService.createAdListing(adId);
	}

	/**
	* Deletes the ad listing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adId the primary key of the ad listing
	* @return the ad listing that was removed
	* @throws PortalException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdListing deleteAdListing(long adId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.deleteAdListing(adId);
	}

	/**
	* Deletes the ad listing from the database. Also notifies the appropriate model listeners.
	*
	* @param adListing the ad listing
	* @return the ad listing that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdListing deleteAdListing(
		com.services.model.AdListing adListing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.deleteAdListing(adListing);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _adListingLocalService.dynamicQuery();
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
		return _adListingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _adListingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _adListingLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _adListingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _adListingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.services.model.AdListing fetchAdListing(long adId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.fetchAdListing(adId);
	}

	/**
	* Returns the ad listing with the primary key.
	*
	* @param adId the primary key of the ad listing
	* @return the ad listing
	* @throws PortalException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdListing getAdListing(long adId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getAdListing(adId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ad listings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @return the range of ad listings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.services.model.AdListing> getAdListings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getAdListings(start, end);
	}

	/**
	* Returns the number of ad listings.
	*
	* @return the number of ad listings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAdListingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getAdListingsCount();
	}

	/**
	* Updates the ad listing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adListing the ad listing
	* @return the ad listing that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.services.model.AdListing updateAdListing(
		com.services.model.AdListing adListing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.updateAdListing(adListing);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _adListingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_adListingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _adListingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.services.model.AdListing postAd(
		com.services.model.AdListing adListingObj, long userId,
		java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, java.io.InputStream>> inputStreamOVPs,
		long folderId, com.liferay.portal.service.ServiceContext serviceContext) {
		return _adListingLocalService.postAd(adListingObj, userId,
			inputStreamOVPs, folderId, serviceContext);
	}

	@Override
	public com.services.model.AdListing updateAd(
		com.services.model.AdListing adListingObj,
		java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, java.io.InputStream>> inputStreamOVPs,
		long folderId, com.liferay.portal.service.ServiceContext serviceContext) {
		return _adListingLocalService.updateAd(adListingObj, inputStreamOVPs,
			folderId, serviceContext);
	}

	@Override
	public void deleteAd(com.services.model.AdListing ad, long folderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_adListingLocalService.deleteAd(ad, folderId);
	}

	@Override
	public java.util.List<com.services.model.AdListing> getByC_C_S(
		long category, long city, java.lang.String serviceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getByC_C_S(category, city, serviceType);
	}

	@Override
	public java.util.List<com.services.model.AdListing> getAllAds()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getAllAds();
	}

	@Override
	public java.util.List<com.services.model.AdListing> getAds(int count)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getAds(count);
	}

	@Override
	public java.util.List<com.services.model.AdListing> getByC_C(
		long category, long city)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getByC_C(category, city);
	}

	@Override
	public java.util.List<com.services.model.AdListing> getByUserId(
		long userId, long companyId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getByUserId(userId, companyId, groupId);
	}

	@Override
	public java.util.List<com.services.model.AdListing> getByCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getByCategory(categoryId);
	}

	@Override
	public java.util.List<com.services.model.AdListing> getByCity(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getByCity(cityId);
	}

	@Override
	public com.liferay.portlet.documentlibrary.model.DLFileEntry getAdFile(
		long adId, long groupId, long folderId) {
		return _adListingLocalService.getAdFile(adId, groupId, folderId);
	}

	@Override
	public java.util.List<com.liferay.portlet.documentlibrary.model.DLFileEntry> getUploadedFiles(
		long groupId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListingLocalService.getUploadedFiles(groupId, folderId);
	}

	@Override
	public java.util.List<com.liferay.portlet.documentlibrary.model.DLFileEntry> getDLFilesForAdListing(
		java.util.List<com.liferay.portlet.documentlibrary.model.DLFileEntry> dlFiles) {
		return _adListingLocalService.getDLFilesForAdListing(dlFiles);
	}

	@Override
	public java.util.List<com.services.model.AdListing> getLimitedAdsByCategory(
		long categoryId) {
		return _adListingLocalService.getLimitedAdsByCategory(categoryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AdListingLocalService getWrappedAdListingLocalService() {
		return _adListingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAdListingLocalService(
		AdListingLocalService adListingLocalService) {
		_adListingLocalService = adListingLocalService;
	}

	@Override
	public AdListingLocalService getWrappedService() {
		return _adListingLocalService;
	}

	@Override
	public void setWrappedService(AdListingLocalService adListingLocalService) {
		_adListingLocalService = adListingLocalService;
	}

	private AdListingLocalService _adListingLocalService;
}