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

import com.services.model.AdCategory;

/**
 * The persistence interface for the ad category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdCategoryPersistenceImpl
 * @see AdCategoryUtil
 * @generated
 */
public interface AdCategoryPersistence extends BasePersistence<AdCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdCategoryUtil} to access the ad category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ad categories where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @return the matching ad categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCategory> findByCategoryStatus(
		boolean categoryStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad categories where categoryStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryStatus the category status
	* @param start the lower bound of the range of ad categories
	* @param end the upper bound of the range of ad categories (not inclusive)
	* @return the range of matching ad categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCategory> findByCategoryStatus(
		boolean categoryStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad categories where categoryStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryStatus the category status
	* @param start the lower bound of the range of ad categories
	* @param end the upper bound of the range of ad categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCategory> findByCategoryStatus(
		boolean categoryStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad category in the ordered set where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad category
	* @throws com.services.NoSuchAdCategoryException if a matching ad category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCategory findByCategoryStatus_First(
		boolean categoryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCategoryException;

	/**
	* Returns the first ad category in the ordered set where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad category, or <code>null</code> if a matching ad category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCategory fetchByCategoryStatus_First(
		boolean categoryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad category in the ordered set where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad category
	* @throws com.services.NoSuchAdCategoryException if a matching ad category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCategory findByCategoryStatus_Last(
		boolean categoryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCategoryException;

	/**
	* Returns the last ad category in the ordered set where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad category, or <code>null</code> if a matching ad category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCategory fetchByCategoryStatus_Last(
		boolean categoryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad categories before and after the current ad category in the ordered set where categoryStatus = &#63;.
	*
	* @param categoryId the primary key of the current ad category
	* @param categoryStatus the category status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad category
	* @throws com.services.NoSuchAdCategoryException if a ad category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCategory[] findByCategoryStatus_PrevAndNext(
		long categoryId, boolean categoryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCategoryException;

	/**
	* Removes all the ad categories where categoryStatus = &#63; from the database.
	*
	* @param categoryStatus the category status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryStatus(boolean categoryStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad categories where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @return the number of matching ad categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryStatus(boolean categoryStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the ad category in the entity cache if it is enabled.
	*
	* @param adCategory the ad category
	*/
	public void cacheResult(com.services.model.AdCategory adCategory);

	/**
	* Caches the ad categories in the entity cache if it is enabled.
	*
	* @param adCategories the ad categories
	*/
	public void cacheResult(
		java.util.List<com.services.model.AdCategory> adCategories);

	/**
	* Creates a new ad category with the primary key. Does not add the ad category to the database.
	*
	* @param categoryId the primary key for the new ad category
	* @return the new ad category
	*/
	public com.services.model.AdCategory create(long categoryId);

	/**
	* Removes the ad category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the ad category
	* @return the ad category that was removed
	* @throws com.services.NoSuchAdCategoryException if a ad category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCategory remove(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCategoryException;

	public com.services.model.AdCategory updateImpl(
		com.services.model.AdCategory adCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad category with the primary key or throws a {@link com.services.NoSuchAdCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the ad category
	* @return the ad category
	* @throws com.services.NoSuchAdCategoryException if a ad category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCategory findByPrimaryKey(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCategoryException;

	/**
	* Returns the ad category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the ad category
	* @return the ad category, or <code>null</code> if a ad category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.services.model.AdCategory fetchByPrimaryKey(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad categories.
	*
	* @return the ad categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ad categories
	* @param end the upper bound of the range of ad categories (not inclusive)
	* @return the range of ad categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCategory> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ad categories
	* @param end the upper bound of the range of ad categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ad categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.services.model.AdCategory> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ad categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad categories.
	*
	* @return the number of ad categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}