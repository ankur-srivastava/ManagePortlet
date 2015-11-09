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
 * This class is used by SOAP remote services, specifically {@link com.services.service.http.AdListingServiceSoap}.
 *
 * @author Ankur Srivastava
 * @see com.services.service.http.AdListingServiceSoap
 * @generated
 */
public class AdListingSoap implements Serializable {
	public static AdListingSoap toSoapModel(AdListing model) {
		AdListingSoap soapModel = new AdListingSoap();

		soapModel.setAdId(model.getAdId());
		soapModel.setAdTitle(model.getAdTitle());
		soapModel.setAdDescription(model.getAdDescription());
		soapModel.setAdCatId(model.getAdCatId());
		soapModel.setAdServiceType(model.getAdServiceType());
		soapModel.setAdCountryId(model.getAdCountryId());
		soapModel.setAdCityId(model.getAdCityId());
		soapModel.setUserId(model.getUserId());
		soapModel.setAdUserName(model.getAdUserName());
		soapModel.setAdUserEmail(model.getAdUserEmail());
		soapModel.setAdUserPhone(model.getAdUserPhone());
		soapModel.setAdStatus(model.getAdStatus());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static AdListingSoap[] toSoapModels(AdListing[] models) {
		AdListingSoap[] soapModels = new AdListingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdListingSoap[][] toSoapModels(AdListing[][] models) {
		AdListingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdListingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdListingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdListingSoap[] toSoapModels(List<AdListing> models) {
		List<AdListingSoap> soapModels = new ArrayList<AdListingSoap>(models.size());

		for (AdListing model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdListingSoap[soapModels.size()]);
	}

	public AdListingSoap() {
	}

	public long getPrimaryKey() {
		return _adId;
	}

	public void setPrimaryKey(long pk) {
		setAdId(pk);
	}

	public long getAdId() {
		return _adId;
	}

	public void setAdId(long adId) {
		_adId = adId;
	}

	public String getAdTitle() {
		return _adTitle;
	}

	public void setAdTitle(String adTitle) {
		_adTitle = adTitle;
	}

	public String getAdDescription() {
		return _adDescription;
	}

	public void setAdDescription(String adDescription) {
		_adDescription = adDescription;
	}

	public long getAdCatId() {
		return _adCatId;
	}

	public void setAdCatId(long adCatId) {
		_adCatId = adCatId;
	}

	public String getAdServiceType() {
		return _adServiceType;
	}

	public void setAdServiceType(String adServiceType) {
		_adServiceType = adServiceType;
	}

	public long getAdCountryId() {
		return _adCountryId;
	}

	public void setAdCountryId(long adCountryId) {
		_adCountryId = adCountryId;
	}

	public long getAdCityId() {
		return _adCityId;
	}

	public void setAdCityId(long adCityId) {
		_adCityId = adCityId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getAdUserName() {
		return _adUserName;
	}

	public void setAdUserName(String adUserName) {
		_adUserName = adUserName;
	}

	public String getAdUserEmail() {
		return _adUserEmail;
	}

	public void setAdUserEmail(String adUserEmail) {
		_adUserEmail = adUserEmail;
	}

	public String getAdUserPhone() {
		return _adUserPhone;
	}

	public void setAdUserPhone(String adUserPhone) {
		_adUserPhone = adUserPhone;
	}

	public boolean getAdStatus() {
		return _adStatus;
	}

	public boolean isAdStatus() {
		return _adStatus;
	}

	public void setAdStatus(boolean adStatus) {
		_adStatus = adStatus;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _adId;
	private String _adTitle;
	private String _adDescription;
	private long _adCatId;
	private String _adServiceType;
	private long _adCountryId;
	private long _adCityId;
	private long _userId;
	private String _adUserName;
	private String _adUserEmail;
	private String _adUserPhone;
	private boolean _adStatus;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _companyId;
	private long _groupId;
}