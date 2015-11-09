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
 * This class is a wrapper for {@link AdResponseTracker}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdResponseTracker
 * @generated
 */
public class AdResponseTrackerWrapper implements AdResponseTracker,
	ModelWrapper<AdResponseTracker> {
	public AdResponseTrackerWrapper(AdResponseTracker adResponseTracker) {
		_adResponseTracker = adResponseTracker;
	}

	@Override
	public Class<?> getModelClass() {
		return AdResponseTracker.class;
	}

	@Override
	public String getModelClassName() {
		return AdResponseTracker.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("artId", getArtId());
		attributes.put("adId", getAdId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("comments", getComments());
		attributes.put("userIP", getUserIP());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long artId = (Long)attributes.get("artId");

		if (artId != null) {
			setArtId(artId);
		}

		Long adId = (Long)attributes.get("adId");

		if (adId != null) {
			setAdId(adId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String userIP = (String)attributes.get("userIP");

		if (userIP != null) {
			setUserIP(userIP);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	/**
	* Returns the primary key of this ad response tracker.
	*
	* @return the primary key of this ad response tracker
	*/
	@Override
	public long getPrimaryKey() {
		return _adResponseTracker.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ad response tracker.
	*
	* @param primaryKey the primary key of this ad response tracker
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_adResponseTracker.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the art ID of this ad response tracker.
	*
	* @return the art ID of this ad response tracker
	*/
	@Override
	public long getArtId() {
		return _adResponseTracker.getArtId();
	}

	/**
	* Sets the art ID of this ad response tracker.
	*
	* @param artId the art ID of this ad response tracker
	*/
	@Override
	public void setArtId(long artId) {
		_adResponseTracker.setArtId(artId);
	}

	/**
	* Returns the ad ID of this ad response tracker.
	*
	* @return the ad ID of this ad response tracker
	*/
	@Override
	public long getAdId() {
		return _adResponseTracker.getAdId();
	}

	/**
	* Sets the ad ID of this ad response tracker.
	*
	* @param adId the ad ID of this ad response tracker
	*/
	@Override
	public void setAdId(long adId) {
		_adResponseTracker.setAdId(adId);
	}

	/**
	* Returns the user ID of this ad response tracker.
	*
	* @return the user ID of this ad response tracker
	*/
	@Override
	public long getUserId() {
		return _adResponseTracker.getUserId();
	}

	/**
	* Sets the user ID of this ad response tracker.
	*
	* @param userId the user ID of this ad response tracker
	*/
	@Override
	public void setUserId(long userId) {
		_adResponseTracker.setUserId(userId);
	}

	/**
	* Returns the user uuid of this ad response tracker.
	*
	* @return the user uuid of this ad response tracker
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adResponseTracker.getUserUuid();
	}

	/**
	* Sets the user uuid of this ad response tracker.
	*
	* @param userUuid the user uuid of this ad response tracker
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_adResponseTracker.setUserUuid(userUuid);
	}

	/**
	* Returns the name of this ad response tracker.
	*
	* @return the name of this ad response tracker
	*/
	@Override
	public java.lang.String getName() {
		return _adResponseTracker.getName();
	}

	/**
	* Sets the name of this ad response tracker.
	*
	* @param name the name of this ad response tracker
	*/
	@Override
	public void setName(java.lang.String name) {
		_adResponseTracker.setName(name);
	}

	/**
	* Returns the email of this ad response tracker.
	*
	* @return the email of this ad response tracker
	*/
	@Override
	public java.lang.String getEmail() {
		return _adResponseTracker.getEmail();
	}

	/**
	* Sets the email of this ad response tracker.
	*
	* @param email the email of this ad response tracker
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_adResponseTracker.setEmail(email);
	}

	/**
	* Returns the phone of this ad response tracker.
	*
	* @return the phone of this ad response tracker
	*/
	@Override
	public java.lang.String getPhone() {
		return _adResponseTracker.getPhone();
	}

	/**
	* Sets the phone of this ad response tracker.
	*
	* @param phone the phone of this ad response tracker
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_adResponseTracker.setPhone(phone);
	}

	/**
	* Returns the comments of this ad response tracker.
	*
	* @return the comments of this ad response tracker
	*/
	@Override
	public java.lang.String getComments() {
		return _adResponseTracker.getComments();
	}

	/**
	* Sets the comments of this ad response tracker.
	*
	* @param comments the comments of this ad response tracker
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_adResponseTracker.setComments(comments);
	}

	/**
	* Returns the user i p of this ad response tracker.
	*
	* @return the user i p of this ad response tracker
	*/
	@Override
	public java.lang.String getUserIP() {
		return _adResponseTracker.getUserIP();
	}

	/**
	* Sets the user i p of this ad response tracker.
	*
	* @param userIP the user i p of this ad response tracker
	*/
	@Override
	public void setUserIP(java.lang.String userIP) {
		_adResponseTracker.setUserIP(userIP);
	}

	/**
	* Returns the created date of this ad response tracker.
	*
	* @return the created date of this ad response tracker
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _adResponseTracker.getCreatedDate();
	}

	/**
	* Sets the created date of this ad response tracker.
	*
	* @param createdDate the created date of this ad response tracker
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_adResponseTracker.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _adResponseTracker.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_adResponseTracker.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _adResponseTracker.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_adResponseTracker.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _adResponseTracker.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _adResponseTracker.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adResponseTracker.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adResponseTracker.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_adResponseTracker.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_adResponseTracker.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adResponseTracker.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdResponseTrackerWrapper((AdResponseTracker)_adResponseTracker.clone());
	}

	@Override
	public int compareTo(com.services.model.AdResponseTracker adResponseTracker) {
		return _adResponseTracker.compareTo(adResponseTracker);
	}

	@Override
	public int hashCode() {
		return _adResponseTracker.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.AdResponseTracker> toCacheModel() {
		return _adResponseTracker.toCacheModel();
	}

	@Override
	public com.services.model.AdResponseTracker toEscapedModel() {
		return new AdResponseTrackerWrapper(_adResponseTracker.toEscapedModel());
	}

	@Override
	public com.services.model.AdResponseTracker toUnescapedModel() {
		return new AdResponseTrackerWrapper(_adResponseTracker.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adResponseTracker.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _adResponseTracker.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adResponseTracker.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdResponseTrackerWrapper)) {
			return false;
		}

		AdResponseTrackerWrapper adResponseTrackerWrapper = (AdResponseTrackerWrapper)obj;

		if (Validator.equals(_adResponseTracker,
					adResponseTrackerWrapper._adResponseTracker)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AdResponseTracker getWrappedAdResponseTracker() {
		return _adResponseTracker;
	}

	@Override
	public AdResponseTracker getWrappedModel() {
		return _adResponseTracker;
	}

	@Override
	public void resetOriginalValues() {
		_adResponseTracker.resetOriginalValues();
	}

	private AdResponseTracker _adResponseTracker;
}