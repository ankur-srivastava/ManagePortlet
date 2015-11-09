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
public class AdResponseTrackerSoap implements Serializable {
	public static AdResponseTrackerSoap toSoapModel(AdResponseTracker model) {
		AdResponseTrackerSoap soapModel = new AdResponseTrackerSoap();

		soapModel.setArtId(model.getArtId());
		soapModel.setAdId(model.getAdId());
		soapModel.setUserId(model.getUserId());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setPhone(model.getPhone());
		soapModel.setComments(model.getComments());
		soapModel.setUserIP(model.getUserIP());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static AdResponseTrackerSoap[] toSoapModels(
		AdResponseTracker[] models) {
		AdResponseTrackerSoap[] soapModels = new AdResponseTrackerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdResponseTrackerSoap[][] toSoapModels(
		AdResponseTracker[][] models) {
		AdResponseTrackerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdResponseTrackerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdResponseTrackerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdResponseTrackerSoap[] toSoapModels(
		List<AdResponseTracker> models) {
		List<AdResponseTrackerSoap> soapModels = new ArrayList<AdResponseTrackerSoap>(models.size());

		for (AdResponseTracker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdResponseTrackerSoap[soapModels.size()]);
	}

	public AdResponseTrackerSoap() {
	}

	public long getPrimaryKey() {
		return _artId;
	}

	public void setPrimaryKey(long pk) {
		setArtId(pk);
	}

	public long getArtId() {
		return _artId;
	}

	public void setArtId(long artId) {
		_artId = artId;
	}

	public long getAdId() {
		return _adId;
	}

	public void setAdId(long adId) {
		_adId = adId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getUserIP() {
		return _userIP;
	}

	public void setUserIP(String userIP) {
		_userIP = userIP;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _artId;
	private long _adId;
	private long _userId;
	private String _name;
	private String _email;
	private String _phone;
	private String _comments;
	private String _userIP;
	private Date _createdDate;
}