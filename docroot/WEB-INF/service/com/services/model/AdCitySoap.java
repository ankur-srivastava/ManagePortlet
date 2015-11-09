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
 * This class is used by SOAP remote services.
 *
 * @author Ankur Srivastava
 * @generated
 */
public class AdCitySoap implements Serializable {
	public static AdCitySoap toSoapModel(AdCity model) {
		AdCitySoap soapModel = new AdCitySoap();

		soapModel.setCityId(model.getCityId());
		soapModel.setCityName(model.getCityName());
		soapModel.setStateName(model.getStateName());
		soapModel.setCityStatus(model.getCityStatus());
		soapModel.setPopular(model.getPopular());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static AdCitySoap[] toSoapModels(AdCity[] models) {
		AdCitySoap[] soapModels = new AdCitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdCitySoap[][] toSoapModels(AdCity[][] models) {
		AdCitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdCitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdCitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdCitySoap[] toSoapModels(List<AdCity> models) {
		List<AdCitySoap> soapModels = new ArrayList<AdCitySoap>(models.size());

		for (AdCity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdCitySoap[soapModels.size()]);
	}

	public AdCitySoap() {
	}

	public long getPrimaryKey() {
		return _cityId;
	}

	public void setPrimaryKey(long pk) {
		setCityId(pk);
	}

	public long getCityId() {
		return _cityId;
	}

	public void setCityId(long cityId) {
		_cityId = cityId;
	}

	public String getCityName() {
		return _cityName;
	}

	public void setCityName(String cityName) {
		_cityName = cityName;
	}

	public String getStateName() {
		return _stateName;
	}

	public void setStateName(String stateName) {
		_stateName = stateName;
	}

	public boolean getCityStatus() {
		return _cityStatus;
	}

	public boolean isCityStatus() {
		return _cityStatus;
	}

	public void setCityStatus(boolean cityStatus) {
		_cityStatus = cityStatus;
	}

	public boolean getPopular() {
		return _popular;
	}

	public boolean isPopular() {
		return _popular;
	}

	public void setPopular(boolean popular) {
		_popular = popular;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _cityId;
	private String _cityName;
	private String _stateName;
	private boolean _cityStatus;
	private boolean _popular;
	private Date _createdDate;
}