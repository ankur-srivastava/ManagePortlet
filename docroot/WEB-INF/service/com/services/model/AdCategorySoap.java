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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.services.service.http.AdCategoryServiceSoap}.
 *
 * @author Ankur Srivastava
 * @see com.services.service.http.AdCategoryServiceSoap
 * @generated
 */
public class AdCategorySoap implements Serializable {
	public static AdCategorySoap toSoapModel(AdCategory model) {
		AdCategorySoap soapModel = new AdCategorySoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setCategoryStatus(model.getCategoryStatus());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static AdCategorySoap[] toSoapModels(AdCategory[] models) {
		AdCategorySoap[] soapModels = new AdCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdCategorySoap[][] toSoapModels(AdCategory[][] models) {
		AdCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdCategorySoap[] toSoapModels(List<AdCategory> models) {
		List<AdCategorySoap> soapModels = new ArrayList<AdCategorySoap>(models.size());

		for (AdCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdCategorySoap[soapModels.size()]);
	}

	public AdCategorySoap() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryId(pk);
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getCategoryName() {
		return _categoryName;
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
	}

	public boolean getCategoryStatus() {
		return _categoryStatus;
	}

	public boolean isCategoryStatus() {
		return _categoryStatus;
	}

	public void setCategoryStatus(boolean categoryStatus) {
		_categoryStatus = categoryStatus;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _categoryId;
	private String _categoryName;
	private boolean _categoryStatus;
	private Date _createdDate;
}