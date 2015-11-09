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

import com.services.model.AdCategory;

import java.util.List;

/**
 * The persistence utility for the ad category service. This utility wraps {@link AdCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdCategoryPersistence
 * @see AdCategoryPersistenceImpl
 * @generated
 */
public class AdCategoryUtil {
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
	public static void clearCache(AdCategory adCategory) {
		getPersistence().clearCache(adCategory);
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
	public static List<AdCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AdCategory update(AdCategory adCategory)
		throws SystemException {
		return getPersistence().update(adCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AdCategory update(AdCategory adCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(adCategory, serviceContext);
	}

	/**
	* Returns all the ad categories where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @return the matching ad categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdCategory> findByCategoryStatus(
		boolean categoryStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryStatus(categoryStatus);
	}

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
	public static java.util.List<com.services.model.AdCategory> findByCategoryStatus(
		boolean categoryStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryStatus(categoryStatus, start, end);
	}

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
	public static java.util.List<com.services.model.AdCategory> findByCategoryStatus(
		boolean categoryStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryStatus(categoryStatus, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ad category in the ordered set where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad category
	* @throws com.services.NoSuchAdCategoryException if a matching ad category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdCategory findByCategoryStatus_First(
		boolean categoryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCategoryException {
		return getPersistence()
				   .findByCategoryStatus_First(categoryStatus, orderByComparator);
	}

	/**
	* Returns the first ad category in the ordered set where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad category, or <code>null</code> if a matching ad category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdCategory fetchByCategoryStatus_First(
		boolean categoryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryStatus_First(categoryStatus,
			orderByComparator);
	}

	/**
	* Returns the last ad category in the ordered set where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad category
	* @throws com.services.NoSuchAdCategoryException if a matching ad category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdCategory findByCategoryStatus_Last(
		boolean categoryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCategoryException {
		return getPersistence()
				   .findByCategoryStatus_Last(categoryStatus, orderByComparator);
	}

	/**
	* Returns the last ad category in the ordered set where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad category, or <code>null</code> if a matching ad category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdCategory fetchByCategoryStatus_Last(
		boolean categoryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryStatus_Last(categoryStatus, orderByComparator);
	}

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
	public static com.services.model.AdCategory[] findByCategoryStatus_PrevAndNext(
		long categoryId, boolean categoryStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCategoryException {
		return getPersistence()
				   .findByCategoryStatus_PrevAndNext(categoryId,
			categoryStatus, orderByComparator);
	}

	/**
	* Removes all the ad categories where categoryStatus = &#63; from the database.
	*
	* @param categoryStatus the category status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryStatus(boolean categoryStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryStatus(categoryStatus);
	}

	/**
	* Returns the number of ad categories where categoryStatus = &#63;.
	*
	* @param categoryStatus the category status
	* @return the number of matching ad categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryStatus(boolean categoryStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryStatus(categoryStatus);
	}

	/**
	* Caches the ad category in the entity cache if it is enabled.
	*
	* @param adCategory the ad category
	*/
	public static void cacheResult(com.services.model.AdCategory adCategory) {
		getPersistence().cacheResult(adCategory);
	}

	/**
	* Caches the ad categories in the entity cache if it is enabled.
	*
	* @param adCategories the ad categories
	*/
	public static void cacheResult(
		java.util.List<com.services.model.AdCategory> adCategories) {
		getPersistence().cacheResult(adCategories);
	}

	/**
	* Creates a new ad category with the primary key. Does not add the ad category to the database.
	*
	* @param categoryId the primary key for the new ad category
	* @return the new ad category
	*/
	public static com.services.model.AdCategory create(long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the ad category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the ad category
	* @return the ad category that was removed
	* @throws com.services.NoSuchAdCategoryException if a ad category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdCategory remove(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.services.model.AdCategory updateImpl(
		com.services.model.AdCategory adCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(adCategory);
	}

	/**
	* Returns the ad category with the primary key or throws a {@link com.services.NoSuchAdCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the ad category
	* @return the ad category
	* @throws com.services.NoSuchAdCategoryException if a ad category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.services.NoSuchAdCategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the ad category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the ad category
	* @return the ad category, or <code>null</code> if a ad category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.services.model.AdCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the ad categories.
	*
	* @return the ad categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.services.model.AdCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.services.model.AdCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.services.model.AdCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ad categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ad categories.
	*
	* @return the number of ad categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdCategoryPersistence)PortletBeanLocatorUtil.locate(com.services.service.ClpSerializer.getServletContextName(),
					AdCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(AdCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AdCategoryPersistence persistence) {
	}

	private static AdCategoryPersistence _persistence;
}