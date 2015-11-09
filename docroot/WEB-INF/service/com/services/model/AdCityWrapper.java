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

package com.services.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AdCity}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdCity
 * @generated
 */
public class AdCityWrapper implements AdCity, ModelWrapper<AdCity> {
	public AdCityWrapper(AdCity adCity) {
		_adCity = adCity;
	}

	@Override
	public Class<?> getModelClass() {
		return AdCity.class;
	}

	@Override
	public String getModelClassName() {
		return AdCity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cityId", getCityId());
		attributes.put("cityName", getCityName());
		attributes.put("stateName", getStateName());
		attributes.put("cityStatus", getCityStatus());
		attributes.put("popular", getPopular());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}

		String cityName = (String)attributes.get("cityName");

		if (cityName != null) {
			setCityName(cityName);
		}

		String stateName = (String)attributes.get("stateName");

		if (stateName != null) {
			setStateName(stateName);
		}

		Boolean cityStatus = (Boolean)attributes.get("cityStatus");

		if (cityStatus != null) {
			setCityStatus(cityStatus);
		}

		Boolean popular = (Boolean)attributes.get("popular");

		if (popular != null) {
			setPopular(popular);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	/**
	* Returns the primary key of this ad city.
	*
	* @return the primary key of this ad city
	*/
	@Override
	public long getPrimaryKey() {
		return _adCity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ad city.
	*
	* @param primaryKey the primary key of this ad city
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_adCity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the city ID of this ad city.
	*
	* @return the city ID of this ad city
	*/
	@Override
	public long getCityId() {
		return _adCity.getCityId();
	}

	/**
	* Sets the city ID of this ad city.
	*
	* @param cityId the city ID of this ad city
	*/
	@Override
	public void setCityId(long cityId) {
		_adCity.setCityId(cityId);
	}

	/**
	* Returns the city name of this ad city.
	*
	* @return the city name of this ad city
	*/
	@Override
	public java.lang.String getCityName() {
		return _adCity.getCityName();
	}

	/**
	* Sets the city name of this ad city.
	*
	* @param cityName the city name of this ad city
	*/
	@Override
	public void setCityName(java.lang.String cityName) {
		_adCity.setCityName(cityName);
	}

	/**
	* Returns the state name of this ad city.
	*
	* @return the state name of this ad city
	*/
	@Override
	public java.lang.String getStateName() {
		return _adCity.getStateName();
	}

	/**
	* Sets the state name of this ad city.
	*
	* @param stateName the state name of this ad city
	*/
	@Override
	public void setStateName(java.lang.String stateName) {
		_adCity.setStateName(stateName);
	}

	/**
	* Returns the city status of this ad city.
	*
	* @return the city status of this ad city
	*/
	@Override
	public boolean getCityStatus() {
		return _adCity.getCityStatus();
	}

	/**
	* Returns <code>true</code> if this ad city is city status.
	*
	* @return <code>true</code> if this ad city is city status; <code>false</code> otherwise
	*/
	@Override
	public boolean isCityStatus() {
		return _adCity.isCityStatus();
	}

	/**
	* Sets whether this ad city is city status.
	*
	* @param cityStatus the city status of this ad city
	*/
	@Override
	public void setCityStatus(boolean cityStatus) {
		_adCity.setCityStatus(cityStatus);
	}

	/**
	* Returns the popular of this ad city.
	*
	* @return the popular of this ad city
	*/
	@Override
	public boolean getPopular() {
		return _adCity.getPopular();
	}

	/**
	* Returns <code>true</code> if this ad city is popular.
	*
	* @return <code>true</code> if this ad city is popular; <code>false</code> otherwise
	*/
	@Override
	public boolean isPopular() {
		return _adCity.isPopular();
	}

	/**
	* Sets whether this ad city is popular.
	*
	* @param popular the popular of this ad city
	*/
	@Override
	public void setPopular(boolean popular) {
		_adCity.setPopular(popular);
	}

	/**
	* Returns the created date of this ad city.
	*
	* @return the created date of this ad city
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _adCity.getCreatedDate();
	}

	/**
	* Sets the created date of this ad city.
	*
	* @param createdDate the created date of this ad city
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_adCity.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _adCity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_adCity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _adCity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_adCity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _adCity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _adCity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adCity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adCity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_adCity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_adCity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adCity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdCityWrapper((AdCity)_adCity.clone());
	}

	@Override
	public int compareTo(com.services.model.AdCity adCity) {
		return _adCity.compareTo(adCity);
	}

	@Override
	public int hashCode() {
		return _adCity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.AdCity> toCacheModel() {
		return _adCity.toCacheModel();
	}

	@Override
	public com.services.model.AdCity toEscapedModel() {
		return new AdCityWrapper(_adCity.toEscapedModel());
	}

	@Override
	public com.services.model.AdCity toUnescapedModel() {
		return new AdCityWrapper(_adCity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adCity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _adCity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adCity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdCityWrapper)) {
			return false;
		}

		AdCityWrapper adCityWrapper = (AdCityWrapper)obj;

		if (Validator.equals(_adCity, adCityWrapper._adCity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AdCity getWrappedAdCity() {
		return _adCity;
	}

	@Override
	public AdCity getWrappedModel() {
		return _adCity;
	}

	@Override
	public void resetOriginalValues() {
		_adCity.resetOriginalValues();
	}

	private AdCity _adCity;
}