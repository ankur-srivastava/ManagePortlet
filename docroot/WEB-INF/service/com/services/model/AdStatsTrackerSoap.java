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
public class AdStatsTrackerSoap implements Serializable {
	public static AdStatsTrackerSoap toSoapModel(AdStatsTracker model) {
		AdStatsTrackerSoap soapModel = new AdStatsTrackerSoap();

		soapModel.setAdId(model.getAdId());
		soapModel.setAdCount(model.getAdCount());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setLastAccessedDate(model.getLastAccessedDate());

		return soapModel;
	}

	public static AdStatsTrackerSoap[] toSoapModels(AdStatsTracker[] models) {
		AdStatsTrackerSoap[] soapModels = new AdStatsTrackerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdStatsTrackerSoap[][] toSoapModels(AdStatsTracker[][] models) {
		AdStatsTrackerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdStatsTrackerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdStatsTrackerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdStatsTrackerSoap[] toSoapModels(List<AdStatsTracker> models) {
		List<AdStatsTrackerSoap> soapModels = new ArrayList<AdStatsTrackerSoap>(models.size());

		for (AdStatsTracker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdStatsTrackerSoap[soapModels.size()]);
	}

	public AdStatsTrackerSoap() {
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

	public long getAdCount() {
		return _adCount;
	}

	public void setAdCount(long adCount) {
		_adCount = adCount;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getLastAccessedDate() {
		return _lastAccessedDate;
	}

	public void setLastAccessedDate(Date lastAccessedDate) {
		_lastAccessedDate = lastAccessedDate;
	}

	private long _adId;
	private long _adCount;
	private Date _createdDate;
	private Date _lastAccessedDate;
}