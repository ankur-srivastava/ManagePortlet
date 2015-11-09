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

import com.services.model.AdCity;

/**
 * The persistence interface for the ad city service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdCityPersistenceImpl
 * @see AdCityUtil
 * @generated
 */
public interface AdCityPersistence extends BasePersistence<AdCity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdCityUtil} to access the ad city persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ad cities where cityStatus = &#63;.
	*
	* @param cityStatus the city status
	* @return the matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCity> findByCityStatus(
		boolean cityStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad cities where cityStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cityStatus the city status
	* @param start the lower bound of the range of ad cities
	* @param end the upper bound of the range of ad cities (not inclusive)
	* @return the range of matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCity> findByCityStatus(
		boolean cityStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad cities where cityStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cityStatus the city status
	* @param start the lower bound of the range of ad cities
	* @param end the upper bound of the range of ad cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCity> findByCityStatus(
		boolean cityStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad city in the ordered set where cityStatus = &#63;.
	*
	* @param cityStatus the city status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad city
	* @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity findByCityStatus_First(
		boolean cityStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCityException;

	/**
	* Returns the first ad city in the ordered set where cityStatus = &#63;.
	*
	* @param cityStatus the city status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad city, or <code>null</code> if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity fetchByCityStatus_First(
		boolean cityStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad city in the ordered set where cityStatus = &#63;.
	*
	* @param cityStatus the city status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad city
	* @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity findByCityStatus_Last(boolean cityStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCityException;

	/**
	* Returns the last ad city in the ordered set where cityStatus = &#63;.
	*
	* @param cityStatus the city status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad city, or <code>null</code> if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity fetchByCityStatus_Last(
		boolean cityStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad cities before and after the current ad city in the ordered set where cityStatus = &#63;.
	*
	* @param cityId the primary key of the current ad city
	* @param cityStatus the city status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad city
	* @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity[] findByCityStatus_PrevAndNext(
		long cityId, boolean cityStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCityException;

	/**
	* Removes all the ad cities where cityStatus = &#63; from the database.
	*
	* @param cityStatus the city status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCityStatus(boolean cityStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad cities where cityStatus = &#63;.
	*
	* @param cityStatus the city status
	* @return the number of matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public int countByCityStatus(boolean cityStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad cities where cityName = &#63;.
	*
	* @param cityName the city name
	* @return the matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCity> findByCityName(
		java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad cities where cityName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cityName the city name
	* @param start the lower bound of the range of ad cities
	* @param end the upper bound of the range of ad cities (not inclusive)
	* @return the range of matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCity> findByCityName(
		java.lang.String cityName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad cities where cityName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cityName the city name
	* @param start the lower bound of the range of ad cities
	* @param end the upper bound of the range of ad cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCity> findByCityName(
		java.lang.String cityName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad city in the ordered set where cityName = &#63;.
	*
	* @param cityName the city name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad city
	* @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity findByCityName_First(
		java.lang.String cityName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCityException;

	/**
	* Returns the first ad city in the ordered set where cityName = &#63;.
	*
	* @param cityName the city name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad city, or <code>null</code> if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity fetchByCityName_First(
		java.lang.String cityName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad city in the ordered set where cityName = &#63;.
	*
	* @param cityName the city name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad city
	* @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity findByCityName_Last(
		java.lang.String cityName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCityException;

	/**
	* Returns the last ad city in the ordered set where cityName = &#63;.
	*
	* @param cityName the city name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad city, or <code>null</code> if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity fetchByCityName_Last(
		java.lang.String cityName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad cities before and after the current ad city in the ordered set where cityName = &#63;.
	*
	* @param cityId the primary key of the current ad city
	* @param cityName the city name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad city
	* @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity[] findByCityName_PrevAndNext(long cityId,
		java.lang.String cityName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCityException;

	/**
	* Removes all the ad cities where cityName = &#63; from the database.
	*
	* @param cityName the city name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCityName(java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad cities where cityName = &#63;.
	*
	* @param cityName the city name
	* @return the number of matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public int countByCityName(java.lang.String cityName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad cities where popular = &#63;.
	*
	* @param popular the popular
	* @return the matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCity> findBypopular(
		boolean popular)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad cities where popular = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param popular the popular
	* @param start the lower bound of the range of ad cities
	* @param end the upper bound of the range of ad cities (not inclusive)
	* @return the range of matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCity> findBypopular(
		boolean popular, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad cities where popular = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param popular the popular
	* @param start the lower bound of the range of ad cities
	* @param end the upper bound of the range of ad cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCity> findBypopular(
		boolean popular, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad city in the ordered set where popular = &#63;.
	*
	* @param popular the popular
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad city
	* @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity findBypopular_First(boolean popular,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCityException;

	/**
	* Returns the first ad city in the ordered set where popular = &#63;.
	*
	* @param popular the popular
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad city, or <code>null</code> if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity fetchBypopular_First(boolean popular,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad city in the ordered set where popular = &#63;.
	*
	* @param popular the popular
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad city
	* @throws com.services.NoSuchAdCityException if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity findBypopular_Last(boolean popular,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCityException;

	/**
	* Returns the last ad city in the ordered set where popular = &#63;.
	*
	* @param popular the popular
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad city, or <code>null</code> if a matching ad city could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity fetchBypopular_Last(boolean popular,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad cities before and after the current ad city in the ordered set where popular = &#63;.
	*
	* @param cityId the primary key of the current ad city
	* @param popular the popular
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad city
	* @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity[] findBypopular_PrevAndNext(long cityId,
		boolean popular,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCityException;

	/**
	* Removes all the ad cities where popular = &#63; from the database.
	*
	* @param popular the popular
	* @throws SystemException if a system exception occurred
	*/
	public void removeBypopular(boolean popular)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad cities where popular = &#63;.
	*
	* @param popular the popular
	* @return the number of matching ad cities
	* @throws SystemException if a system exception occurred
	*/
	public int countBypopular(boolean popular)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the ad city in the entity cache if it is enabled.
	*
	* @param adCity the ad city
	*/
	public void cacheResult(com.services.model.AdCity adCity);

	/**
	* Caches the ad cities in the entity cache if it is enabled.
	*
	* @param adCities the ad cities
	*/
	public void cacheResult(java.util.List<com.services.model.AdCity> adCities);

	/**
	* Creates a new ad city with the primary key. Does not add the ad city to the database.
	*
	* @param cityId the primary key for the new ad city
	* @return the new ad city
	*/
	public com.services.model.AdCity create(long cityId);

	/**
	* Removes the ad city with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cityId the primary key of the ad city
	* @return the ad city that was removed
	* @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity remove(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCityException;

	public com.services.model.AdCity updateImpl(
		com.services.model.AdCity adCity)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad city with the primary key or throws a {@link com.services.NoSuchAdCityException} if it could not be found.
	*
	* @param cityId the primary key of the ad city
	* @return the ad city
	* @throws com.services.NoSuchAdCityException if a ad city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity findByPrimaryKey(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCityException;

	/**
	* Returns the ad city with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cityId the primary key of the ad city
	* @return the ad city, or <code>null</code> if a ad city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCity fetchByPrimaryKey(long cityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad cities.
	*
	* @return the ad cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.services.model.AdCity> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad cities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ad cities
	* @param end the upper bound of the range of ad cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ad cities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCity> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ad cities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad cities.
	*
	* @return the number of ad cities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}