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
 * This class is a wrapper for {@link AdCategory}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdCategory
 * @generated
 */
public class AdCategoryWrapper implements AdCategory, ModelWrapper<AdCategory> {
	public AdCategoryWrapper(AdCategory adCategory) {
		_adCategory = adCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return AdCategory.class;
	}

	@Override
	public String getModelClassName() {
		return AdCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryStatus", getCategoryStatus());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		Boolean categoryStatus = (Boolean)attributes.get("categoryStatus");

		if (categoryStatus != null) {
			setCategoryStatus(categoryStatus);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	/**
	* Returns the primary key of this ad category.
	*
	* @return the primary key of this ad category
	*/
	@Override
	public long getPrimaryKey() {
		return _adCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ad category.
	*
	* @param primaryKey the primary key of this ad category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_adCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this ad category.
	*
	* @return the category ID of this ad category
	*/
	@Override
	public long getCategoryId() {
		return _adCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this ad category.
	*
	* @param categoryId the category ID of this ad category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_adCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the category name of this ad category.
	*
	* @return the category name of this ad category
	*/
	@Override
	public java.lang.String getCategoryName() {
		return _adCategory.getCategoryName();
	}

	/**
	* Sets the category name of this ad category.
	*
	* @param categoryName the category name of this ad category
	*/
	@Override
	public void setCategoryName(java.lang.String categoryName) {
		_adCategory.setCategoryName(categoryName);
	}

	/**
	* Returns the category status of this ad category.
	*
	* @return the category status of this ad category
	*/
	@Override
	public boolean getCategoryStatus() {
		return _adCategory.getCategoryStatus();
	}

	/**
	* Returns <code>true</code> if this ad category is category status.
	*
	* @return <code>true</code> if this ad category is category status; <code>false</code> otherwise
	*/
	@Override
	public boolean isCategoryStatus() {
		return _adCategory.isCategoryStatus();
	}

	/**
	* Sets whether this ad category is category status.
	*
	* @param categoryStatus the category status of this ad category
	*/
	@Override
	public void setCategoryStatus(boolean categoryStatus) {
		_adCategory.setCategoryStatus(categoryStatus);
	}

	/**
	* Returns the created date of this ad category.
	*
	* @return the created date of this ad category
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _adCategory.getCreatedDate();
	}

	/**
	* Sets the created date of this ad category.
	*
	* @param createdDate the created date of this ad category
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_adCategory.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _adCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_adCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _adCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_adCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _adCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _adCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_adCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_adCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdCategoryWrapper((AdCategory)_adCategory.clone());
	}

	@Override
	public int compareTo(com.services.model.AdCategory adCategory) {
		return _adCategory.compareTo(adCategory);
	}

	@Override
	public int hashCode() {
		return _adCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.services.model.AdCategory> toCacheModel() {
		return _adCategory.toCacheModel();
	}

	@Override
	public com.services.model.AdCategory toEscapedModel() {
		return new AdCategoryWrapper(_adCategory.toEscapedModel());
	}

	@Override
	public com.services.model.AdCategory toUnescapedModel() {
		return new AdCategoryWrapper(_adCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _adCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdCategoryWrapper)) {
			return false;
		}

		AdCategoryWrapper adCategoryWrapper = (AdCategoryWrapper)obj;

		if (Validator.equals(_adCategory, adCategoryWrapper._adCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AdCategory getWrappedAdCategory() {
		return _adCategory;
	}

	@Override
	public AdCategory getWrappedModel() {
		return _adCategory;
	}

	@Override
	public void resetOriginalValues() {
		_adCategory.resetOriginalValues();
	}

	private AdCategory _adCategory;
}