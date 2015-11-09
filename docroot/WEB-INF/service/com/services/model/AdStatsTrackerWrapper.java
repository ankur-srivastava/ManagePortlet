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
 * This class is a wrapper for {@link AdStatsTracker}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdStatsTracker
 * @generated
 */
public class AdStatsTrackerWrapper implements AdStatsTracker,
	ModelWrapper<AdStatsTracker> {
	public AdStatsTrackerWrapper(AdStatsTracker adStatsTracker) {
		_adStatsTracker = adStatsTracker;
	}

	@Override
	public Class<?> getModelClass() {
		return AdStatsTracker.class;
	}

	@Override
	public String getModelClassName() {
		return AdStatsTracker.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("adId", getAdId());
		attributes.put("adCount", getAdCount());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("lastAccessedDate", getLastAccessedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long adId = (Long)attributes.get("adId");

		if (adId != null) {
			setAdId(adId);
		}

		Long adCount = (Long)attributes.get("adCount");

		if (adCount != null) {
			setAdCount(adCount);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date lastAccessedDate = (Date)attributes.get("lastAccessedDate");

		if (lastAccessedDate != null) {
			setLastAccessedDate(lastAccessedDate);
		}
	}

	/**
	* Returns the primary key of this ad stats tracker.
	*
	* @return the primary key of this ad stats tracker
	*/
	@Override
	public long getPrimaryKey() {
		return _adStatsTracker.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ad stats tracker.
	*
	* @param primaryKey the primary key of this ad stats tracker
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_adStatsTracker.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ad ID of this ad stats tracker.
	*
	* @return the ad ID of this ad stats tracker
	*/
	@Override
	public long getAdId() {
		return _adStatsTracker.getAdId();
	}

	/**
	* Sets the ad ID of this ad stats tracker.
	*
	* @param adId the ad ID of this ad stats tracker
	*/
	@Override
	public void setAdId(long adId) {
		_adStatsTracker.setAdId(adId);
	}

	/**
	* Returns the ad count of this ad stats tracker.
	*
	* @return the ad count of this ad stats tracker
	*/
	@Override
	public long getAdCount() {
		return _adStatsTracker.getAdCount();
	}

	/**
	* Sets the ad count of this ad stats tracker.
	*
	* @param adCount the ad count of this ad stats tracker
	*/
	@Override
	public void setAdCount(long adCount) {
		_adStatsTracker.setAdCount(adCount);
	}

	/**
	* Returns the created date of this ad stats tracker.
	*
	* @return the created date of this ad stats tracker
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _adStatsTracker.getCreatedDate();
	}

	/**
	* Sets the created date of this ad stats tracker.
	*
	* @param createdDate the created date of this ad stats tracker
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_adStatsTracker.setCreatedDate(createdDate);
	}

	/**
	* Returns the last accessed date of this ad stats tracker.
	*
	* @return the last accessed date of this ad stats tracker
	*/
	@Override
	public java.util.Date getLastAccessedDate() {
		return _adStatsTracker.getLastAccessedDate();
	}

	/**
	* Sets the last accessed date of this ad stats tracker.
	*
	* @param lastAccessedDate the last accessed date of this ad stats tracker
	*/
	@Override
	public void setLastAccessedDate(java.util.Date lastAccessedDate) {
		_adStatsTracker.setLastAccessedDate(lastAccessedDate);
	}

	@Override
	public boolean isNew() {
		return _adStatsTracker.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_adStatsTracker.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _adStatsTracker.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_adStatsTracker.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _adStatsTracker.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _adStatsTracker.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adStatsTracker.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adStatsTracker.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_adStatsTracker.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_adStatsTracker.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adStatsTracker.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdStatsTrackerWrapper((AdStatsTracker)_adStatsTracker.clone());
	}

	@Override
	public int compareTo(com.services.model.AdStatsTracker adStatsTracker) {
		return _adStatsTracker.compareTo(adStatsTracker);
	}

	@Override
	public int hashCode() {
		return _adStatsTracker.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.AdStatsTracker> toCacheModel() {
		return _adStatsTracker.toCacheModel();
	}

	@Override
	public com.services.model.AdStatsTracker toEscapedModel() {
		return new AdStatsTrackerWrapper(_adStatsTracker.toEscapedModel());
	}

	@Override
	public com.services.model.AdStatsTracker toUnescapedModel() {
		return new AdStatsTrackerWrapper(_adStatsTracker.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adStatsTracker.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _adStatsTracker.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adStatsTracker.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdStatsTrackerWrapper)) {
			return false;
		}

		AdStatsTrackerWrapper adStatsTrackerWrapper = (AdStatsTrackerWrapper)obj;

		if (Validator.equals(_adStatsTracker,
					adStatsTrackerWrapper._adStatsTracker)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AdStatsTracker getWrappedAdStatsTracker() {
		return _adStatsTracker;
	}

	@Override
	public AdStatsTracker getWrappedModel() {
		return _adStatsTracker;
	}

	@Override
	public void resetOriginalValues() {
		_adStatsTracker.resetOriginalValues();
	}

	private AdStatsTracker _adStatsTracker;
}