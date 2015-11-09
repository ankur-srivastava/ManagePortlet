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

package com.services.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.services.model.AdCountry;

import com.services.service.AdCountryLocalService;
import com.services.service.persistence.AdCategoryPersistence;
import com.services.service.persistence.AdCityPersistence;
import com.services.service.persistence.AdCountryPersistence;
import com.services.service.persistence.AdListingPersistence;
import com.services.service.persistence.AdResponseTrackerPersistence;
import com.services.service.persistence.AdStatsTrackerPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the ad country local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.services.service.impl.AdCountryLocalServiceImpl}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see com.services.service.impl.AdCountryLocalServiceImpl
 * @see com.services.service.AdCountryLocalServiceUtil
 * @generated
 */
public abstract class AdCountryLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements AdCountryLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.services.service.AdCountryLocalServiceUtil} to access the ad country local service.
	 */

	/**
	 * Adds the ad country to the database. Also notifies the appropriate model listeners.
	 *
	 * @param adCountry the ad country
	 * @return the ad country that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AdCountry addAdCountry(AdCountry adCountry)
		throws SystemException {
		adCountry.setNew(true);

		return adCountryPersistence.update(adCountry);
	}

	/**
	 * Creates a new ad country with the primary key. Does not add the ad country to the database.
	 *
	 * @param countryId the primary key for the new ad country
	 * @return the new ad country
	 */
	@Override
	public AdCountry createAdCountry(long countryId) {
		return adCountryPersistence.create(countryId);
	}

	/**
	 * Deletes the ad country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param countryId the primary key of the ad country
	 * @return the ad country that was removed
	 * @throws PortalException if a ad country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AdCountry deleteAdCountry(long countryId)
		throws PortalException, SystemException {
		return adCountryPersistence.remove(countryId);
	}

	/**
	 * Deletes the ad country from the database. Also notifies the appropriate model listeners.
	 *
	 * @param adCountry the ad country
	 * @return the ad country that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AdCountry deleteAdCountry(AdCountry adCountry)
		throws SystemException {
		return adCountryPersistence.remove(adCountry);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AdCountry.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return adCountryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return adCountryPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.services.model.impl.AdCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return adCountryPersistence.findWithDynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return adCountryPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return adCountryPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public AdCountry fetchAdCountry(long countryId) throws SystemException {
		return adCountryPersistence.fetchByPrimaryKey(countryId);
	}

	/**
	 * Returns the ad country with the primary key.
	 *
	 * @param countryId the primary key of the ad country
	 * @return the ad country
	 * @throws PortalException if a ad country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCountry getAdCountry(long countryId)
		throws PortalException, SystemException {
		return adCountryPersistence.findByPrimaryKey(countryId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return adCountryPersistence.findByPrimaryKey(primaryKeyObj);
	}

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
	@Override
	public List<AdCountry> getAdCountries(int start, int end)
		throws SystemException {
		return adCountryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ad countries.
	 *
	 * @return the number of ad countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getAdCountriesCount() throws SystemException {
		return adCountryPersistence.countAll();
	}

	/**
	 * Updates the ad country in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param adCountry the ad country
	 * @return the ad country that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AdCountry updateAdCountry(AdCountry adCountry)
		throws SystemException {
		return adCountryPersistence.update(adCountry);
	}

	/**
	 * Returns the ad category local service.
	 *
	 * @return the ad category local service
	 */
	public com.services.service.AdCategoryLocalService getAdCategoryLocalService() {
		return adCategoryLocalService;
	}

	/**
	 * Sets the ad category local service.
	 *
	 * @param adCategoryLocalService the ad category local service
	 */
	public void setAdCategoryLocalService(
		com.services.service.AdCategoryLocalService adCategoryLocalService) {
		this.adCategoryLocalService = adCategoryLocalService;
	}

	/**
	 * Returns the ad category remote service.
	 *
	 * @return the ad category remote service
	 */
	public com.services.service.AdCategoryService getAdCategoryService() {
		return adCategoryService;
	}

	/**
	 * Sets the ad category remote service.
	 *
	 * @param adCategoryService the ad category remote service
	 */
	public void setAdCategoryService(
		com.services.service.AdCategoryService adCategoryService) {
		this.adCategoryService = adCategoryService;
	}

	/**
	 * Returns the ad category persistence.
	 *
	 * @return the ad category persistence
	 */
	public AdCategoryPersistence getAdCategoryPersistence() {
		return adCategoryPersistence;
	}

	/**
	 * Sets the ad category persistence.
	 *
	 * @param adCategoryPersistence the ad category persistence
	 */
	public void setAdCategoryPersistence(
		AdCategoryPersistence adCategoryPersistence) {
		this.adCategoryPersistence = adCategoryPersistence;
	}

	/**
	 * Returns the ad city local service.
	 *
	 * @return the ad city local service
	 */
	public com.services.service.AdCityLocalService getAdCityLocalService() {
		return adCityLocalService;
	}

	/**
	 * Sets the ad city local service.
	 *
	 * @param adCityLocalService the ad city local service
	 */
	public void setAdCityLocalService(
		com.services.service.AdCityLocalService adCityLocalService) {
		this.adCityLocalService = adCityLocalService;
	}

	/**
	 * Returns the ad city persistence.
	 *
	 * @return the ad city persistence
	 */
	public AdCityPersistence getAdCityPersistence() {
		return adCityPersistence;
	}

	/**
	 * Sets the ad city persistence.
	 *
	 * @param adCityPersistence the ad city persistence
	 */
	public void setAdCityPersistence(AdCityPersistence adCityPersistence) {
		this.adCityPersistence = adCityPersistence;
	}

	/**
	 * Returns the ad country local service.
	 *
	 * @return the ad country local service
	 */
	public com.services.service.AdCountryLocalService getAdCountryLocalService() {
		return adCountryLocalService;
	}

	/**
	 * Sets the ad country local service.
	 *
	 * @param adCountryLocalService the ad country local service
	 */
	public void setAdCountryLocalService(
		com.services.service.AdCountryLocalService adCountryLocalService) {
		this.adCountryLocalService = adCountryLocalService;
	}

	/**
	 * Returns the ad country persistence.
	 *
	 * @return the ad country persistence
	 */
	public AdCountryPersistence getAdCountryPersistence() {
		return adCountryPersistence;
	}

	/**
	 * Sets the ad country persistence.
	 *
	 * @param adCountryPersistence the ad country persistence
	 */
	public void setAdCountryPersistence(
		AdCountryPersistence adCountryPersistence) {
		this.adCountryPersistence = adCountryPersistence;
	}

	/**
	 * Returns the ad listing local service.
	 *
	 * @return the ad listing local service
	 */
	public com.services.service.AdListingLocalService getAdListingLocalService() {
		return adListingLocalService;
	}

	/**
	 * Sets the ad listing local service.
	 *
	 * @param adListingLocalService the ad listing local service
	 */
	public void setAdListingLocalService(
		com.services.service.AdListingLocalService adListingLocalService) {
		this.adListingLocalService = adListingLocalService;
	}

	/**
	 * Returns the ad listing remote service.
	 *
	 * @return the ad listing remote service
	 */
	public com.services.service.AdListingService getAdListingService() {
		return adListingService;
	}

	/**
	 * Sets the ad listing remote service.
	 *
	 * @param adListingService the ad listing remote service
	 */
	public void setAdListingService(
		com.services.service.AdListingService adListingService) {
		this.adListingService = adListingService;
	}

	/**
	 * Returns the ad listing persistence.
	 *
	 * @return the ad listing persistence
	 */
	public AdListingPersistence getAdListingPersistence() {
		return adListingPersistence;
	}

	/**
	 * Sets the ad listing persistence.
	 *
	 * @param adListingPersistence the ad listing persistence
	 */
	public void setAdListingPersistence(
		AdListingPersistence adListingPersistence) {
		this.adListingPersistence = adListingPersistence;
	}

	/**
	 * Returns the ad response tracker local service.
	 *
	 * @return the ad response tracker local service
	 */
	public com.services.service.AdResponseTrackerLocalService getAdResponseTrackerLocalService() {
		return adResponseTrackerLocalService;
	}

	/**
	 * Sets the ad response tracker local service.
	 *
	 * @param adResponseTrackerLocalService the ad response tracker local service
	 */
	public void setAdResponseTrackerLocalService(
		com.services.service.AdResponseTrackerLocalService adResponseTrackerLocalService) {
		this.adResponseTrackerLocalService = adResponseTrackerLocalService;
	}

	/**
	 * Returns the ad response tracker persistence.
	 *
	 * @return the ad response tracker persistence
	 */
	public AdResponseTrackerPersistence getAdResponseTrackerPersistence() {
		return adResponseTrackerPersistence;
	}

	/**
	 * Sets the ad response tracker persistence.
	 *
	 * @param adResponseTrackerPersistence the ad response tracker persistence
	 */
	public void setAdResponseTrackerPersistence(
		AdResponseTrackerPersistence adResponseTrackerPersistence) {
		this.adResponseTrackerPersistence = adResponseTrackerPersistence;
	}

	/**
	 * Returns the ad stats tracker local service.
	 *
	 * @return the ad stats tracker local service
	 */
	public com.services.service.AdStatsTrackerLocalService getAdStatsTrackerLocalService() {
		return adStatsTrackerLocalService;
	}

	/**
	 * Sets the ad stats tracker local service.
	 *
	 * @param adStatsTrackerLocalService the ad stats tracker local service
	 */
	public void setAdStatsTrackerLocalService(
		com.services.service.AdStatsTrackerLocalService adStatsTrackerLocalService) {
		this.adStatsTrackerLocalService = adStatsTrackerLocalService;
	}

	/**
	 * Returns the ad stats tracker persistence.
	 *
	 * @return the ad stats tracker persistence
	 */
	public AdStatsTrackerPersistence getAdStatsTrackerPersistence() {
		return adStatsTrackerPersistence;
	}

	/**
	 * Sets the ad stats tracker persistence.
	 *
	 * @param adStatsTrackerPersistence the ad stats tracker persistence
	 */
	public void setAdStatsTrackerPersistence(
		AdStatsTrackerPersistence adStatsTrackerPersistence) {
		this.adStatsTrackerPersistence = adStatsTrackerPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.services.model.AdCountry",
			adCountryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.services.model.AdCountry");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return AdCountry.class;
	}

	protected String getModelClassName() {
		return AdCountry.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = adCountryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.services.service.AdCategoryLocalService.class)
	protected com.services.service.AdCategoryLocalService adCategoryLocalService;
	@BeanReference(type = com.services.service.AdCategoryService.class)
	protected com.services.service.AdCategoryService adCategoryService;
	@BeanReference(type = AdCategoryPersistence.class)
	protected AdCategoryPersistence adCategoryPersistence;
	@BeanReference(type = com.services.service.AdCityLocalService.class)
	protected com.services.service.AdCityLocalService adCityLocalService;
	@BeanReference(type = AdCityPersistence.class)
	protected AdCityPersistence adCityPersistence;
	@BeanReference(type = com.services.service.AdCountryLocalService.class)
	protected com.services.service.AdCountryLocalService adCountryLocalService;
	@BeanReference(type = AdCountryPersistence.class)
	protected AdCountryPersistence adCountryPersistence;
	@BeanReference(type = com.services.service.AdListingLocalService.class)
	protected com.services.service.AdListingLocalService adListingLocalService;
	@BeanReference(type = com.services.service.AdListingService.class)
	protected com.services.service.AdListingService adListingService;
	@BeanReference(type = AdListingPersistence.class)
	protected AdListingPersistence adListingPersistence;
	@BeanReference(type = com.services.service.AdResponseTrackerLocalService.class)
	protected com.services.service.AdResponseTrackerLocalService adResponseTrackerLocalService;
	@BeanReference(type = AdResponseTrackerPersistence.class)
	protected AdResponseTrackerPersistence adResponseTrackerPersistence;
	@BeanReference(type = com.services.service.AdStatsTrackerLocalService.class)
	protected com.services.service.AdStatsTrackerLocalService adStatsTrackerLocalService;
	@BeanReference(type = AdStatsTrackerPersistence.class)
	protected AdStatsTrackerPersistence adStatsTrackerPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private AdCountryLocalServiceClpInvoker _clpInvoker = new AdCountryLocalServiceClpInvoker();
}