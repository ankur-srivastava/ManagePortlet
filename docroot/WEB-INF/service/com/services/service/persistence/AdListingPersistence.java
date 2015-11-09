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

import com.services.model.AdListing;

/**
 * The persistence interface for the ad listing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdListingPersistenceImpl
 * @see AdListingUtil
 * @generated
 */
public interface AdListingPersistence extends BasePersistence<AdListing> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdListingUtil} to access the ad listing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ad listings where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCatId(
		long adCatId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad listings where adCatId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param adCatId the ad cat ID
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @return the range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCatId(
		long adCatId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad listings where adCatId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param adCatId the ad cat ID
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCatId(
		long adCatId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad listing in the ordered set where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByCatId_First(long adCatId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the first ad listing in the ordered set where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByCatId_First(long adCatId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad listing in the ordered set where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByCatId_Last(long adCatId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the last ad listing in the ordered set where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByCatId_Last(long adCatId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad listings before and after the current ad listing in the ordered set where adCatId = &#63;.
	*
	* @param adId the primary key of the current ad listing
	* @param adCatId the ad cat ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad listing
	* @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing[] findByCatId_PrevAndNext(long adId,
		long adCatId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Removes all the ad listings where adCatId = &#63; from the database.
	*
	* @param adCatId the ad cat ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCatId(long adCatId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad listings where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public int countByCatId(long adCatId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad listings where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCityId(
		long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad listings where adCityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param adCityId the ad city ID
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @return the range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCityId(
		long adCityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad listings where adCityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param adCityId the ad city ID
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCityId(
		long adCityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad listing in the ordered set where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByCityId_First(long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the first ad listing in the ordered set where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByCityId_First(long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad listing in the ordered set where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByCityId_Last(long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the last ad listing in the ordered set where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByCityId_Last(long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad listings before and after the current ad listing in the ordered set where adCityId = &#63;.
	*
	* @param adId the primary key of the current ad listing
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad listing
	* @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing[] findByCityId_PrevAndNext(long adId,
		long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Removes all the ad listings where adCityId = &#63; from the database.
	*
	* @param adCityId the ad city ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCityId(long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad listings where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public int countByCityId(long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad listings where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByServiceType(
		java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad listings where adServiceType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param adServiceType the ad service type
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @return the range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByServiceType(
		java.lang.String adServiceType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad listings where adServiceType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param adServiceType the ad service type
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByServiceType(
		java.lang.String adServiceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad listing in the ordered set where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByServiceType_First(
		java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the first ad listing in the ordered set where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByServiceType_First(
		java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad listing in the ordered set where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByServiceType_Last(
		java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the last ad listing in the ordered set where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByServiceType_Last(
		java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad listings before and after the current ad listing in the ordered set where adServiceType = &#63;.
	*
	* @param adId the primary key of the current ad listing
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad listing
	* @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing[] findByServiceType_PrevAndNext(
		long adId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Removes all the ad listings where adServiceType = &#63; from the database.
	*
	* @param adServiceType the ad service type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByServiceType(java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad listings where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public int countByServiceType(java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad listings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad listings where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @return the range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad listings where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad listing in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the first ad listing in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad listing in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the last ad listing in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad listings before and after the current ad listing in the ordered set where userId = &#63;.
	*
	* @param adId the primary key of the current ad listing
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad listing
	* @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing[] findByUserId_PrevAndNext(long adId,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Removes all the ad listings where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad listings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCat_City_Service(
		long adCatId, long adCityId, java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @return the range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCat_City_Service(
		long adCatId, long adCityId, java.lang.String adServiceType, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCat_City_Service(
		long adCatId, long adCityId, java.lang.String adServiceType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad listing in the ordered set where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByCat_City_Service_First(
		long adCatId, long adCityId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the first ad listing in the ordered set where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByCat_City_Service_First(
		long adCatId, long adCityId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad listing in the ordered set where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByCat_City_Service_Last(
		long adCatId, long adCityId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the last ad listing in the ordered set where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByCat_City_Service_Last(
		long adCatId, long adCityId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad listings before and after the current ad listing in the ordered set where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	*
	* @param adId the primary key of the current ad listing
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad listing
	* @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing[] findByCat_City_Service_PrevAndNext(
		long adId, long adCatId, long adCityId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Removes all the ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63; from the database.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCat_City_Service(long adCatId, long adCityId,
		java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public int countByCat_City_Service(long adCatId, long adCityId,
		java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad listings where adCatId = &#63; and adCityId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCat_City(
		long adCatId, long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad listings where adCatId = &#63; and adCityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @return the range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCat_City(
		long adCatId, long adCityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad listings where adCatId = &#63; and adCityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByCat_City(
		long adCatId, long adCityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByCat_City_First(long adCatId,
		long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the first ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByCat_City_First(long adCatId,
		long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByCat_City_Last(long adCatId,
		long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the last ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByCat_City_Last(long adCatId,
		long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad listings before and after the current ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	*
	* @param adId the primary key of the current ad listing
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad listing
	* @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing[] findByCat_City_PrevAndNext(
		long adId, long adCatId, long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Removes all the ad listings where adCatId = &#63; and adCityId = &#63; from the database.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCat_City(long adCatId, long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad listings where adCatId = &#63; and adCityId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public int countByCat_City(long adCatId, long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad listings where userId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByUGC(long userId,
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad listings where userId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @return the range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByUGC(long userId,
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad listings where userId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findByUGC(long userId,
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad listing in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByUGC_First(long userId,
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the first ad listing in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByUGC_First(long userId,
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad listing in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByUGC_Last(long userId,
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the last ad listing in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByUGC_Last(long userId,
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad listings before and after the current ad listing in the ordered set where userId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param adId the primary key of the current ad listing
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad listing
	* @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing[] findByUGC_PrevAndNext(long adId,
		long userId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Removes all the ad listings where userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUGC(long userId, long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad listings where userId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public int countByUGC(long userId, long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the ad listing in the entity cache if it is enabled.
	*
	* @param adListing the ad listing
	*/
	public void cacheResult(com.services.model.AdListing adListing);

	/**
	* Caches the ad listings in the entity cache if it is enabled.
	*
	* @param adListings the ad listings
	*/
	public void cacheResult(
		java.util.List<com.services.model.AdListing> adListings);

	/**
	* Creates a new ad listing with the primary key. Does not add the ad listing to the database.
	*
	* @param adId the primary key for the new ad listing
	* @return the new ad listing
	*/
	public com.services.model.AdListing create(long adId);

	/**
	* Removes the ad listing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adId the primary key of the ad listing
	* @return the ad listing that was removed
	* @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing remove(long adId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	public com.services.model.AdListing updateImpl(
		com.services.model.AdListing adListing)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad listing with the primary key or throws a {@link com.services.NoSuchAdListingException} if it could not be found.
	*
	* @param adId the primary key of the ad listing
	* @return the ad listing
	* @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing findByPrimaryKey(long adId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException;

	/**
	* Returns the ad listing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param adId the primary key of the ad listing
	* @return the ad listing, or <code>null</code> if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdListing fetchByPrimaryKey(long adId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad listings.
	*
	* @return the ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.AdListing> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad listings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdListingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ad listings
	* @param end the upper bound of the range of ad listings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ad listings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdListing> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ad listings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad listings.
	*
	* @return the number of ad listings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}