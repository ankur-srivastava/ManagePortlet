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

package com.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.services.model.AdCity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AdCity in entity cache.
 *
 * @author Ankur Srivastava
 * @see AdCity
 * @generated
 */
public class AdCityCacheModel implements CacheModel<AdCity>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{cityId=");
		sb.append(cityId);
		sb.append(", cityName=");
		sb.append(cityName);
		sb.append(", stateName=");
		sb.append(stateName);
		sb.append(", cityStatus=");
		sb.append(cityStatus);
		sb.append(", popular=");
		sb.append(popular);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdCity toEntityModel() {
		AdCityImpl adCityImpl = new AdCityImpl();

		adCityImpl.setCityId(cityId);

		if (cityName == null) {
			adCityImpl.setCityName(StringPool.BLANK);
		}
		else {
			adCityImpl.setCityName(cityName);
		}

		if (stateName == null) {
			adCityImpl.setStateName(StringPool.BLANK);
		}
		else {
			adCityImpl.setStateName(stateName);
		}

		adCityImpl.setCityStatus(cityStatus);
		adCityImpl.setPopular(popular);

		if (createdDate == Long.MIN_VALUE) {
			adCityImpl.setCreatedDate(null);
		}
		else {
			adCityImpl.setCreatedDate(new Date(createdDate));
		}

		adCityImpl.resetOriginalValues();

		return adCityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cityId = objectInput.readLong();
		cityName = objectInput.readUTF();
		stateName = objectInput.readUTF();
		cityStatus = objectInput.readBoolean();
		popular = objectInput.readBoolean();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cityId);

		if (cityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cityName);
		}

		if (stateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stateName);
		}

		objectOutput.writeBoolean(cityStatus);
		objectOutput.writeBoolean(popular);
		objectOutput.writeLong(createdDate);
	}

	public long cityId;
	public String cityName;
	public String stateName;
	public boolean cityStatus;
	public boolean popular;
	public long createdDate;
}