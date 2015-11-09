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
 * This class is a wrapper for {@link AdCountry}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdCountry
 * @generated
 */
public class AdCountryWrapper implements AdCountry, ModelWrapper<AdCountry> {
	public AdCountryWrapper(AdCountry adCountry) {
		_adCountry = adCountry;
	}

	@Override
	public Class<?> getModelClass() {
		return AdCountry.class;
	}

	@Override
	public String getModelClassName() {
		return AdCountry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("countryId", getCountryId());
		attributes.put("countryName", getCountryName());
		attributes.put("countryStatus", getCountryStatus());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		Boolean countryStatus = (Boolean)attributes.get("countryStatus");

		if (countryStatus != null) {
			setCountryStatus(countryStatus);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	/**
	* Returns the primary key of this ad country.
	*
	* @return the primary key of this ad country
	*/
	@Override
	public long getPrimaryKey() {
		return _adCountry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ad country.
	*
	* @param primaryKey the primary key of this ad country
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_adCountry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the country ID of this ad country.
	*
	* @return the country ID of this ad country
	*/
	@Override
	public long getCountryId() {
		return _adCountry.getCountryId();
	}

	/**
	* Sets the country ID of this ad country.
	*
	* @param countryId the country ID of this ad country
	*/
	@Override
	public void setCountryId(long countryId) {
		_adCountry.setCountryId(countryId);
	}

	/**
	* Returns the country name of this ad country.
	*
	* @return the country name of this ad country
	*/
	@Override
	public java.lang.String getCountryName() {
		return _adCountry.getCountryName();
	}

	/**
	* Sets the country name of this ad country.
	*
	* @param countryName the country name of this ad country
	*/
	@Override
	public void setCountryName(java.lang.String countryName) {
		_adCountry.setCountryName(countryName);
	}

	/**
	* Returns the country status of this ad country.
	*
	* @return the country status of this ad country
	*/
	@Override
	public boolean getCountryStatus() {
		return _adCountry.getCountryStatus();
	}

	/**
	* Returns <code>true</code> if this ad country is country status.
	*
	* @return <code>true</code> if this ad country is country status; <code>false</code> otherwise
	*/
	@Override
	public boolean isCountryStatus() {
		return _adCountry.isCountryStatus();
	}

	/**
	* Sets whether this ad country is country status.
	*
	* @param countryStatus the country status of this ad country
	*/
	@Override
	public void setCountryStatus(boolean countryStatus) {
		_adCountry.setCountryStatus(countryStatus);
	}

	/**
	* Returns the created date of this ad country.
	*
	* @return the created date of this ad country
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _adCountry.getCreatedDate();
	}

	/**
	* Sets the created date of this ad country.
	*
	* @param createdDate the created date of this ad country
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_adCountry.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _adCountry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_adCountry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _adCountry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_adCountry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _adCountry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _adCountry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adCountry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adCountry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_adCountry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_adCountry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adCountry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdCountryWrapper((AdCountry)_adCountry.clone());
	}

	@Override
	public int compareTo(com.services.model.AdCountry adCountry) {
		return _adCountry.compareTo(adCountry);
	}

	@Override
	public int hashCode() {
		return _adCountry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.AdCountry> toCacheModel() {
		return _adCountry.toCacheModel();
	}

	@Override
	public com.services.model.AdCountry toEscapedModel() {
		return new AdCountryWrapper(_adCountry.toEscapedModel());
	}

	@Override
	public com.services.model.AdCountry toUnescapedModel() {
		return new AdCountryWrapper(_adCountry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adCountry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _adCountry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adCountry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdCountryWrapper)) {
			return false;
		}

		AdCountryWrapper adCountryWrapper = (AdCountryWrapper)obj;

		if (Validator.equals(_adCountry, adCountryWrapper._adCountry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AdCountry getWrappedAdCountry() {
		return _adCountry;
	}

	@Override
	public AdCountry getWrappedModel() {
		return _adCountry;
	}

	@Override
	public void resetOriginalValues() {
		_adCountry.resetOriginalValues();
	}

	private AdCountry _adCountry;
}