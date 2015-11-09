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

import com.services.model.AdCountry;

/**
 * The persistence interface for the ad country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdCountryPersistenceImpl
 * @see AdCountryUtil
 * @generated
 */
public interface AdCountryPersistence extends BasePersistence<AdCountry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdCountryUtil} to access the ad country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ad countries where countryStatus = &#63;.
	*
	* @param countryStatus the country status
	* @return the matching ad countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCountry> findByCountryStatus(
		boolean countryStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad countries where countryStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryStatus the country status
	* @param start the lower bound of the range of ad countries
	* @param end the upper bound of the range of ad countries (not inclusive)
	* @return the range of matching ad countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCountry> findByCountryStatus(
		boolean countryStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad countries where countryStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryStatus the country status
	* @param start the lower bound of the range of ad countries
	* @param end the upper bound of the range of ad countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCountry> findByCountryStatus(
		boolean countryStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad country in the ordered set where countryStatus = &#63;.
	*
	* @param countryStatus the country status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad country
	* @throws com.services.NoSuchAdCountryException if a matching ad country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCountry findByCountryStatus_First(
		boolean countryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCountryException;

	/**
	* Returns the first ad country in the ordered set where countryStatus = &#63;.
	*
	* @param countryStatus the country status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad country, or <code>null</code> if a matching ad country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCountry fetchByCountryStatus_First(
		boolean countryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad country in the ordered set where countryStatus = &#63;.
	*
	* @param countryStatus the country status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad country
	* @throws com.services.NoSuchAdCountryException if a matching ad country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCountry findByCountryStatus_Last(
		boolean countryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCountryException;

	/**
	* Returns the last ad country in the ordered set where countryStatus = &#63;.
	*
	* @param countryStatus the country status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad country, or <code>null</code> if a matching ad country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCountry fetchByCountryStatus_Last(
		boolean countryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad countries before and after the current ad country in the ordered set where countryStatus = &#63;.
	*
	* @param countryId the primary key of the current ad country
	* @param countryStatus the country status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad country
	* @throws com.services.NoSuchAdCountryException if a ad country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCountry[] findByCountryStatus_PrevAndNext(
		long countryId, boolean countryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCountryException;

	/**
	* Removes all the ad countries where countryStatus = &#63; from the database.
	*
	* @param countryStatus the country status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCountryStatus(boolean countryStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad countries where countryStatus = &#63;.
	*
	* @param countryStatus the country status
	* @return the number of matching ad countries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountryStatus(boolean countryStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the ad country in the entity cache if it is enabled.
	*
	* @param adCountry the ad country
	*/
	public void cacheResult(com.services.model.AdCountry adCountry);

	/**
	* Caches the ad countries in the entity cache if it is enabled.
	*
	* @param adCountries the ad countries
	*/
	public void cacheResult(
		java.util.List<com.services.model.AdCountry> adCountries);

	/**
	* Creates a new ad country with the primary key. Does not add the ad country to the database.
	*
	* @param countryId the primary key for the new ad country
	* @return the new ad country
	*/
	public com.services.model.AdCountry create(long countryId);

	/**
	* Removes the ad country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param countryId the primary key of the ad country
	* @return the ad country that was removed
	* @throws com.services.NoSuchAdCountryException if a ad country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCountry remove(long countryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCountryException;

	public com.services.model.AdCountry updateImpl(
		com.services.model.AdCountry adCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad country with the primary key or throws a {@link com.services.NoSuchAdCountryException} if it could not be found.
	*
	* @param countryId the primary key of the ad country
	* @return the ad country
	* @throws com.services.NoSuchAdCountryException if a ad country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCountry findByPrimaryKey(long countryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCountryException;

	/**
	* Returns the ad country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param countryId the primary key of the ad country
	* @return the ad country, or <code>null</code> if a ad country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCountry fetchByPrimaryKey(long countryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad countries.
	*
	* @return the ad countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCountry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ad countries
	* @param end the upper bound of the range of ad countries (not inclusive)
	* @return the range of ad countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCountry> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ad countries
	* @param end the upper bound of the range of ad countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ad countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCountry> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ad countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad countries.
	*
	* @return the number of ad countries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}