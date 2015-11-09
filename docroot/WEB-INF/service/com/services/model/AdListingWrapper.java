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
 * This class is a wrapper for {@link AdListing}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdListing
 * @generated
 */
public class AdListingWrapper implements AdListing, ModelWrapper<AdListing> {
	public AdListingWrapper(AdListing adListing) {
		_adListing = adListing;
	}

	@Override
	public Class<?> getModelClass() {
		return AdListing.class;
	}

	@Override
	public String getModelClassName() {
		return AdListing.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("adId", getAdId());
		attributes.put("adTitle", getAdTitle());
		attributes.put("adDescription", getAdDescription());
		attributes.put("adCatId", getAdCatId());
		attributes.put("adServiceType", getAdServiceType());
		attributes.put("adCountryId", getAdCountryId());
		attributes.put("adCityId", getAdCityId());
		attributes.put("userId", getUserId());
		attributes.put("adUserName", getAdUserName());
		attributes.put("adUserEmail", getAdUserEmail());
		attributes.put("adUserPhone", getAdUserPhone());
		attributes.put("adStatus", getAdStatus());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long adId = (Long)attributes.get("adId");

		if (adId != null) {
			setAdId(adId);
		}

		String adTitle = (String)attributes.get("adTitle");

		if (adTitle != null) {
			setAdTitle(adTitle);
		}

		String adDescription = (String)attributes.get("adDescription");

		if (adDescription != null) {
			setAdDescription(adDescription);
		}

		Long adCatId = (Long)attributes.get("adCatId");

		if (adCatId != null) {
			setAdCatId(adCatId);
		}

		String adServiceType = (String)attributes.get("adServiceType");

		if (adServiceType != null) {
			setAdServiceType(adServiceType);
		}

		Long adCountryId = (Long)attributes.get("adCountryId");

		if (adCountryId != null) {
			setAdCountryId(adCountryId);
		}

		Long adCityId = (Long)attributes.get("adCityId");

		if (adCityId != null) {
			setAdCityId(adCityId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String adUserName = (String)attributes.get("adUserName");

		if (adUserName != null) {
			setAdUserName(adUserName);
		}

		String adUserEmail = (String)attributes.get("adUserEmail");

		if (adUserEmail != null) {
			setAdUserEmail(adUserEmail);
		}

		String adUserPhone = (String)attributes.get("adUserPhone");

		if (adUserPhone != null) {
			setAdUserPhone(adUserPhone);
		}

		Boolean adStatus = (Boolean)attributes.get("adStatus");

		if (adStatus != null) {
			setAdStatus(adStatus);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this ad listing.
	*
	* @return the primary key of this ad listing
	*/
	@Override
	public long getPrimaryKey() {
		return _adListing.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ad listing.
	*
	* @param primaryKey the primary key of this ad listing
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_adListing.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ad ID of this ad listing.
	*
	* @return the ad ID of this ad listing
	*/
	@Override
	public long getAdId() {
		return _adListing.getAdId();
	}

	/**
	* Sets the ad ID of this ad listing.
	*
	* @param adId the ad ID of this ad listing
	*/
	@Override
	public void setAdId(long adId) {
		_adListing.setAdId(adId);
	}

	/**
	* Returns the ad title of this ad listing.
	*
	* @return the ad title of this ad listing
	*/
	@Override
	public java.lang.String getAdTitle() {
		return _adListing.getAdTitle();
	}

	/**
	* Sets the ad title of this ad listing.
	*
	* @param adTitle the ad title of this ad listing
	*/
	@Override
	public void setAdTitle(java.lang.String adTitle) {
		_adListing.setAdTitle(adTitle);
	}

	/**
	* Returns the ad description of this ad listing.
	*
	* @return the ad description of this ad listing
	*/
	@Override
	public java.lang.String getAdDescription() {
		return _adListing.getAdDescription();
	}

	/**
	* Sets the ad description of this ad listing.
	*
	* @param adDescription the ad description of this ad listing
	*/
	@Override
	public void setAdDescription(java.lang.String adDescription) {
		_adListing.setAdDescription(adDescription);
	}

	/**
	* Returns the ad cat ID of this ad listing.
	*
	* @return the ad cat ID of this ad listing
	*/
	@Override
	public long getAdCatId() {
		return _adListing.getAdCatId();
	}

	/**
	* Sets the ad cat ID of this ad listing.
	*
	* @param adCatId the ad cat ID of this ad listing
	*/
	@Override
	public void setAdCatId(long adCatId) {
		_adListing.setAdCatId(adCatId);
	}

	/**
	* Returns the ad service type of this ad listing.
	*
	* @return the ad service type of this ad listing
	*/
	@Override
	public java.lang.String getAdServiceType() {
		return _adListing.getAdServiceType();
	}

	/**
	* Sets the ad service type of this ad listing.
	*
	* @param adServiceType the ad service type of this ad listing
	*/
	@Override
	public void setAdServiceType(java.lang.String adServiceType) {
		_adListing.setAdServiceType(adServiceType);
	}

	/**
	* Returns the ad country ID of this ad listing.
	*
	* @return the ad country ID of this ad listing
	*/
	@Override
	public long getAdCountryId() {
		return _adListing.getAdCountryId();
	}

	/**
	* Sets the ad country ID of this ad listing.
	*
	* @param adCountryId the ad country ID of this ad listing
	*/
	@Override
	public void setAdCountryId(long adCountryId) {
		_adListing.setAdCountryId(adCountryId);
	}

	/**
	* Returns the ad city ID of this ad listing.
	*
	* @return the ad city ID of this ad listing
	*/
	@Override
	public long getAdCityId() {
		return _adListing.getAdCityId();
	}

	/**
	* Sets the ad city ID of this ad listing.
	*
	* @param adCityId the ad city ID of this ad listing
	*/
	@Override
	public void setAdCityId(long adCityId) {
		_adListing.setAdCityId(adCityId);
	}

	/**
	* Returns the user ID of this ad listing.
	*
	* @return the user ID of this ad listing
	*/
	@Override
	public long getUserId() {
		return _adListing.getUserId();
	}

	/**
	* Sets the user ID of this ad listing.
	*
	* @param userId the user ID of this ad listing
	*/
	@Override
	public void setUserId(long userId) {
		_adListing.setUserId(userId);
	}

	/**
	* Returns the user uuid of this ad listing.
	*
	* @return the user uuid of this ad listing
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adListing.getUserUuid();
	}

	/**
	* Sets the user uuid of this ad listing.
	*
	* @param userUuid the user uuid of this ad listing
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_adListing.setUserUuid(userUuid);
	}

	/**
	* Returns the ad user name of this ad listing.
	*
	* @return the ad user name of this ad listing
	*/
	@Override
	public java.lang.String getAdUserName() {
		return _adListing.getAdUserName();
	}

	/**
	* Sets the ad user name of this ad listing.
	*
	* @param adUserName the ad user name of this ad listing
	*/
	@Override
	public void setAdUserName(java.lang.String adUserName) {
		_adListing.setAdUserName(adUserName);
	}

	/**
	* Returns the ad user email of this ad listing.
	*
	* @return the ad user email of this ad listing
	*/
	@Override
	public java.lang.String getAdUserEmail() {
		return _adListing.getAdUserEmail();
	}

	/**
	* Sets the ad user email of this ad listing.
	*
	* @param adUserEmail the ad user email of this ad listing
	*/
	@Override
	public void setAdUserEmail(java.lang.String adUserEmail) {
		_adListing.setAdUserEmail(adUserEmail);
	}

	/**
	* Returns the ad user phone of this ad listing.
	*
	* @return the ad user phone of this ad listing
	*/
	@Override
	public java.lang.String getAdUserPhone() {
		return _adListing.getAdUserPhone();
	}

	/**
	* Sets the ad user phone of this ad listing.
	*
	* @param adUserPhone the ad user phone of this ad listing
	*/
	@Override
	public void setAdUserPhone(java.lang.String adUserPhone) {
		_adListing.setAdUserPhone(adUserPhone);
	}

	/**
	* Returns the ad status of this ad listing.
	*
	* @return the ad status of this ad listing
	*/
	@Override
	public boolean getAdStatus() {
		return _adListing.getAdStatus();
	}

	/**
	* Returns <code>true</code> if this ad listing is ad status.
	*
	* @return <code>true</code> if this ad listing is ad status; <code>false</code> otherwise
	*/
	@Override
	public boolean isAdStatus() {
		return _adListing.isAdStatus();
	}

	/**
	* Sets whether this ad listing is ad status.
	*
	* @param adStatus the ad status of this ad listing
	*/
	@Override
	public void setAdStatus(boolean adStatus) {
		_adListing.setAdStatus(adStatus);
	}

	/**
	* Returns the created date of this ad listing.
	*
	* @return the created date of this ad listing
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _adListing.getCreatedDate();
	}

	/**
	* Sets the created date of this ad listing.
	*
	* @param createdDate the created date of this ad listing
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_adListing.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this ad listing.
	*
	* @return the modified date of this ad listing
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _adListing.getModifiedDate();
	}

	/**
	* Sets the modified date of this ad listing.
	*
	* @param modifiedDate the modified date of this ad listing
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_adListing.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the company ID of this ad listing.
	*
	* @return the company ID of this ad listing
	*/
	@Override
	public long getCompanyId() {
		return _adListing.getCompanyId();
	}

	/**
	* Sets the company ID of this ad listing.
	*
	* @param companyId the company ID of this ad listing
	*/
	@Override
	public void setCompanyId(long companyId) {
		_adListing.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this ad listing.
	*
	* @return the group ID of this ad listing
	*/
	@Override
	public long getGroupId() {
		return _adListing.getGroupId();
	}

	/**
	* Sets the group ID of this ad listing.
	*
	* @param groupId the group ID of this ad listing
	*/
	@Override
	public void setGroupId(long groupId) {
		_adListing.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _adListing.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_adListing.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _adListing.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_adListing.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _adListing.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _adListing.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adListing.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adListing.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_adListing.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_adListing.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adListing.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdListingWrapper((AdListing)_adListing.clone());
	}

	@Override
	public int compareTo(com.services.model.AdListing adListing) {
		return _adListing.compareTo(adListing);
	}

	@Override
	public int hashCode() {
		return _adListing.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.AdListing> toCacheModel() {
		return _adListing.toCacheModel();
	}

	@Override
	public com.services.model.AdListing toEscapedModel() {
		return new AdListingWrapper(_adListing.toEscapedModel());
	}

	@Override
	public com.services.model.AdListing toUnescapedModel() {
		return new AdListingWrapper(_adListing.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adListing.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _adListing.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adListing.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdListingWrapper)) {
			return false;
		}

		AdListingWrapper adListingWrapper = (AdListingWrapper)obj;

		if (Validator.equals(_adListing, adListingWrapper._adListing)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AdListing getWrappedAdListing() {
		return _adListing;
	}

	@Override
	public AdListing getWrappedModel() {
		return _adListing;
	}

	@Override
	public void resetOriginalValues() {
		_adListing.resetOriginalValues();
	}

	private AdListing _adListing;
}