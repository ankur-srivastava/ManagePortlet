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

import com.services.model.AdListing;

import java.util.List;

/**
 * The persistence utility for the ad listing service. This utility wraps {@link AdListingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdListingPersistence
 * @see AdListingPersistenceImpl
 * @generated
 */
public class AdListingUtil {
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
	public static void clearCache(AdListing adListing) {
		getPersistence().clearCache(adListing);
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
	public static List<AdListing> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdListing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdListing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AdListing update(AdListing adListing)
		throws SystemException {
		return getPersistence().update(adListing);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AdListing update(AdListing adListing,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(adListing, serviceContext);
	}

	/**
	* Returns all the ad listings where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdListing> findByCatId(
		long adCatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCatId(adCatId);
	}

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
	public static java.util.List<com.services.model.AdListing> findByCatId(
		long adCatId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCatId(adCatId, start, end);
	}

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
	public static java.util.List<com.services.model.AdListing> findByCatId(
		long adCatId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCatId(adCatId, start, end, orderByComparator);
	}

	/**
	* Returns the first ad listing in the ordered set where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing findByCatId_First(long adCatId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence().findByCatId_First(adCatId, orderByComparator);
	}

	/**
	* Returns the first ad listing in the ordered set where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing fetchByCatId_First(
		long adCatId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCatId_First(adCatId, orderByComparator);
	}

	/**
	* Returns the last ad listing in the ordered set where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing findByCatId_Last(long adCatId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence().findByCatId_Last(adCatId, orderByComparator);
	}

	/**
	* Returns the last ad listing in the ordered set where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing fetchByCatId_Last(long adCatId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCatId_Last(adCatId, orderByComparator);
	}

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
	public static com.services.model.AdListing[] findByCatId_PrevAndNext(
		long adId, long adCatId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByCatId_PrevAndNext(adId, adCatId, orderByComparator);
	}

	/**
	* Removes all the ad listings where adCatId = &#63; from the database.
	*
	* @param adCatId the ad cat ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCatId(long adCatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCatId(adCatId);
	}

	/**
	* Returns the number of ad listings where adCatId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCatId(long adCatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCatId(adCatId);
	}

	/**
	* Returns all the ad listings where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdListing> findByCityId(
		long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCityId(adCityId);
	}

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
	public static java.util.List<com.services.model.AdListing> findByCityId(
		long adCityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCityId(adCityId, start, end);
	}

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
	public static java.util.List<com.services.model.AdListing> findByCityId(
		long adCityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCityId(adCityId, start, end, orderByComparator);
	}

	/**
	* Returns the first ad listing in the ordered set where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing findByCityId_First(
		long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence().findByCityId_First(adCityId, orderByComparator);
	}

	/**
	* Returns the first ad listing in the ordered set where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing fetchByCityId_First(
		long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCityId_First(adCityId, orderByComparator);
	}

	/**
	* Returns the last ad listing in the ordered set where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing findByCityId_Last(
		long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence().findByCityId_Last(adCityId, orderByComparator);
	}

	/**
	* Returns the last ad listing in the ordered set where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing fetchByCityId_Last(
		long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCityId_Last(adCityId, orderByComparator);
	}

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
	public static com.services.model.AdListing[] findByCityId_PrevAndNext(
		long adId, long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByCityId_PrevAndNext(adId, adCityId, orderByComparator);
	}

	/**
	* Removes all the ad listings where adCityId = &#63; from the database.
	*
	* @param adCityId the ad city ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCityId(long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCityId(adCityId);
	}

	/**
	* Returns the number of ad listings where adCityId = &#63;.
	*
	* @param adCityId the ad city ID
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCityId(long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCityId(adCityId);
	}

	/**
	* Returns all the ad listings where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdListing> findByServiceType(
		java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceType(adServiceType);
	}

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
	public static java.util.List<com.services.model.AdListing> findByServiceType(
		java.lang.String adServiceType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByServiceType(adServiceType, start, end);
	}

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
	public static java.util.List<com.services.model.AdListing> findByServiceType(
		java.lang.String adServiceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByServiceType(adServiceType, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ad listing in the ordered set where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing findByServiceType_First(
		java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByServiceType_First(adServiceType, orderByComparator);
	}

	/**
	* Returns the first ad listing in the ordered set where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing fetchByServiceType_First(
		java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceType_First(adServiceType, orderByComparator);
	}

	/**
	* Returns the last ad listing in the ordered set where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing findByServiceType_Last(
		java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByServiceType_Last(adServiceType, orderByComparator);
	}

	/**
	* Returns the last ad listing in the ordered set where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing fetchByServiceType_Last(
		java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByServiceType_Last(adServiceType, orderByComparator);
	}

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
	public static com.services.model.AdListing[] findByServiceType_PrevAndNext(
		long adId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByServiceType_PrevAndNext(adId, adServiceType,
			orderByComparator);
	}

	/**
	* Removes all the ad listings where adServiceType = &#63; from the database.
	*
	* @param adServiceType the ad service type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByServiceType(java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByServiceType(adServiceType);
	}

	/**
	* Returns the number of ad listings where adServiceType = &#63;.
	*
	* @param adServiceType the ad service type
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByServiceType(java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByServiceType(adServiceType);
	}

	/**
	* Returns all the ad listings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdListing> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

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
	public static java.util.List<com.services.model.AdListing> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static java.util.List<com.services.model.AdListing> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first ad listing in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first ad listing in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last ad listing in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing
	* @throws com.services.NoSuchAdListingException if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last ad listing in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

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
	public static com.services.model.AdListing[] findByUserId_PrevAndNext(
		long adId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByUserId_PrevAndNext(adId, userId, orderByComparator);
	}

	/**
	* Removes all the ad listings where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of ad listings where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdListing> findByCat_City_Service(
		long adCatId, long adCityId, java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCat_City_Service(adCatId, adCityId, adServiceType);
	}

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
	public static java.util.List<com.services.model.AdListing> findByCat_City_Service(
		long adCatId, long adCityId, java.lang.String adServiceType, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCat_City_Service(adCatId, adCityId, adServiceType,
			start, end);
	}

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
	public static java.util.List<com.services.model.AdListing> findByCat_City_Service(
		long adCatId, long adCityId, java.lang.String adServiceType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCat_City_Service(adCatId, adCityId, adServiceType,
			start, end, orderByComparator);
	}

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
	public static com.services.model.AdListing findByCat_City_Service_First(
		long adCatId, long adCityId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByCat_City_Service_First(adCatId, adCityId,
			adServiceType, orderByComparator);
	}

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
	public static com.services.model.AdListing fetchByCat_City_Service_First(
		long adCatId, long adCityId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCat_City_Service_First(adCatId, adCityId,
			adServiceType, orderByComparator);
	}

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
	public static com.services.model.AdListing findByCat_City_Service_Last(
		long adCatId, long adCityId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByCat_City_Service_Last(adCatId, adCityId,
			adServiceType, orderByComparator);
	}

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
	public static com.services.model.AdListing fetchByCat_City_Service_Last(
		long adCatId, long adCityId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCat_City_Service_Last(adCatId, adCityId,
			adServiceType, orderByComparator);
	}

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
	public static com.services.model.AdListing[] findByCat_City_Service_PrevAndNext(
		long adId, long adCatId, long adCityId, java.lang.String adServiceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByCat_City_Service_PrevAndNext(adId, adCatId, adCityId,
			adServiceType, orderByComparator);
	}

	/**
	* Removes all the ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63; from the database.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCat_City_Service(long adCatId, long adCityId,
		java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCat_City_Service(adCatId, adCityId, adServiceType);
	}

	/**
	* Returns the number of ad listings where adCatId = &#63; and adCityId = &#63; and adServiceType = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param adServiceType the ad service type
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCat_City_Service(long adCatId, long adCityId,
		java.lang.String adServiceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCat_City_Service(adCatId, adCityId, adServiceType);
	}

	/**
	* Returns all the ad listings where adCatId = &#63; and adCityId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdListing> findByCat_City(
		long adCatId, long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCat_City(adCatId, adCityId);
	}

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
	public static java.util.List<com.services.model.AdListing> findByCat_City(
		long adCatId, long adCityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCat_City(adCatId, adCityId, start, end);
	}

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
	public static java.util.List<com.services.model.AdListing> findByCat_City(
		long adCatId, long adCityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCat_City(adCatId, adCityId, start, end,
			orderByComparator);
	}

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
	public static com.services.model.AdListing findByCat_City_First(
		long adCatId, long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByCat_City_First(adCatId, adCityId, orderByComparator);
	}

	/**
	* Returns the first ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing fetchByCat_City_First(
		long adCatId, long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCat_City_First(adCatId, adCityId, orderByComparator);
	}

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
	public static com.services.model.AdListing findByCat_City_Last(
		long adCatId, long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByCat_City_Last(adCatId, adCityId, orderByComparator);
	}

	/**
	* Returns the last ad listing in the ordered set where adCatId = &#63; and adCityId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad listing, or <code>null</code> if a matching ad listing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing fetchByCat_City_Last(
		long adCatId, long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCat_City_Last(adCatId, adCityId, orderByComparator);
	}

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
	public static com.services.model.AdListing[] findByCat_City_PrevAndNext(
		long adId, long adCatId, long adCityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByCat_City_PrevAndNext(adId, adCatId, adCityId,
			orderByComparator);
	}

	/**
	* Removes all the ad listings where adCatId = &#63; and adCityId = &#63; from the database.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCat_City(long adCatId, long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCat_City(adCatId, adCityId);
	}

	/**
	* Returns the number of ad listings where adCatId = &#63; and adCityId = &#63;.
	*
	* @param adCatId the ad cat ID
	* @param adCityId the ad city ID
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCat_City(long adCatId, long adCityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCat_City(adCatId, adCityId);
	}

	/**
	* Returns all the ad listings where userId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdListing> findByUGC(
		long userId, long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUGC(userId, groupId, companyId);
	}

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
	public static java.util.List<com.services.model.AdListing> findByUGC(
		long userId, long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUGC(userId, groupId, companyId, start, end);
	}

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
	public static java.util.List<com.services.model.AdListing> findByUGC(
		long userId, long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUGC(userId, groupId, companyId, start, end,
			orderByComparator);
	}

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
	public static com.services.model.AdListing findByUGC_First(long userId,
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByUGC_First(userId, groupId, companyId,
			orderByComparator);
	}

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
	public static com.services.model.AdListing fetchByUGC_First(long userId,
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUGC_First(userId, groupId, companyId,
			orderByComparator);
	}

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
	public static com.services.model.AdListing findByUGC_Last(long userId,
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByUGC_Last(userId, groupId, companyId, orderByComparator);
	}

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
	public static com.services.model.AdListing fetchByUGC_Last(long userId,
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUGC_Last(userId, groupId, companyId,
			orderByComparator);
	}

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
	public static com.services.model.AdListing[] findByUGC_PrevAndNext(
		long adId, long userId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence()
				   .findByUGC_PrevAndNext(adId, userId, groupId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the ad listings where userId = &#63; and groupId = &#63; and companyId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUGC(long userId, long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUGC(userId, groupId, companyId);
	}

	/**
	* Returns the number of ad listings where userId = &#63; and groupId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUGC(long userId, long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUGC(userId, groupId, companyId);
	}

	/**
	* Caches the ad listing in the entity cache if it is enabled.
	*
	* @param adListing the ad listing
	*/
	public static void cacheResult(com.services.model.AdListing adListing) {
		getPersistence().cacheResult(adListing);
	}

	/**
	* Caches the ad listings in the entity cache if it is enabled.
	*
	* @param adListings the ad listings
	*/
	public static void cacheResult(
		java.util.List<com.services.model.AdListing> adListings) {
		getPersistence().cacheResult(adListings);
	}

	/**
	* Creates a new ad listing with the primary key. Does not add the ad listing to the database.
	*
	* @param adId the primary key for the new ad listing
	* @return the new ad listing
	*/
	public static com.services.model.AdListing create(long adId) {
		return getPersistence().create(adId);
	}

	/**
	* Removes the ad listing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param adId the primary key of the ad listing
	* @return the ad listing that was removed
	* @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing remove(long adId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence().remove(adId);
	}

	public static com.services.model.AdListing updateImpl(
		com.services.model.AdListing adListing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(adListing);
	}

	/**
	* Returns the ad listing with the primary key or throws a {@link com.services.NoSuchAdListingException} if it could not be found.
	*
	* @param adId the primary key of the ad listing
	* @return the ad listing
	* @throws com.services.NoSuchAdListingException if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing findByPrimaryKey(long adId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdListingException {
		return getPersistence().findByPrimaryKey(adId);
	}

	/**
	* Returns the ad listing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param adId the primary key of the ad listing
	* @return the ad listing, or <code>null</code> if a ad listing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdListing fetchByPrimaryKey(long adId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(adId);
	}

	/**
	* Returns all the ad listings.
	*
	* @return the ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdListing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.services.model.AdListing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.services.model.AdListing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ad listings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ad listings.
	*
	* @return the number of ad listings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdListingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdListingPersistence)PortletBeanLocatorUtil.locate(com.services.service.ClpSerializer.getServletContextName(),
					AdListingPersistence.class.getName());

			ReferenceRegistry.registerReference(AdListingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AdListingPersistence persistence) {
	}

	private static AdListingPersistence _persistence;
}