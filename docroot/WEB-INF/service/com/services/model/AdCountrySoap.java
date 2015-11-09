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
public class AdCountrySoap implements Serializable {
	public static AdCountrySoap toSoapModel(AdCountry model) {
		AdCountrySoap soapModel = new AdCountrySoap();

		soapModel.setCountryId(model.getCountryId());
		soapModel.setCountryName(model.getCountryName());
		soapModel.setCountryStatus(model.getCountryStatus());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static AdCountrySoap[] toSoapModels(AdCountry[] models) {
		AdCountrySoap[] soapModels = new AdCountrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdCountrySoap[][] toSoapModels(AdCountry[][] models) {
		AdCountrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdCountrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdCountrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdCountrySoap[] toSoapModels(List<AdCountry> models) {
		List<AdCountrySoap> soapModels = new ArrayList<AdCountrySoap>(models.size());

		for (AdCountry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdCountrySoap[soapModels.size()]);
	}

	public AdCountrySoap() {
	}

	public long getPrimaryKey() {
		return _countryId;
	}

	public void setPrimaryKey(long pk) {
		setCountryId(pk);
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public String getCountryName() {
		return _countryName;
	}

	public void setCountryName(String countryName) {
		_countryName = countryName;
	}

	public boolean getCountryStatus() {
		return _countryStatus;
	}

	public boolean isCountryStatus() {
		return _countryStatus;
	}

	public void setCountryStatus(boolean countryStatus) {
		_countryStatus = countryStatus;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _countryId;
	private String _countryName;
	private boolean _countryStatus;
	private Date _createdDate;
}