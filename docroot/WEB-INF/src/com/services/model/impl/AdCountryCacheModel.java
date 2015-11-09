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

import com.services.model.AdCountry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AdCountry in entity cache.
 *
 * @author Ankur Srivastava
 * @see AdCountry
 * @generated
 */
public class AdCountryCacheModel implements CacheModel<AdCountry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{countryId=");
		sb.append(countryId);
		sb.append(", countryName=");
		sb.append(countryName);
		sb.append(", countryStatus=");
		sb.append(countryStatus);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdCountry toEntityModel() {
		AdCountryImpl adCountryImpl = new AdCountryImpl();

		adCountryImpl.setCountryId(countryId);

		if (countryName == null) {
			adCountryImpl.setCountryName(StringPool.BLANK);
		}
		else {
			adCountryImpl.setCountryName(countryName);
		}

		adCountryImpl.setCountryStatus(countryStatus);

		if (createdDate == Long.MIN_VALUE) {
			adCountryImpl.setCreatedDate(null);
		}
		else {
			adCountryImpl.setCreatedDate(new Date(createdDate));
		}

		adCountryImpl.resetOriginalValues();

		return adCountryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		countryId = objectInput.readLong();
		countryName = objectInput.readUTF();
		countryStatus = objectInput.readBoolean();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(countryId);

		if (countryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryName);
		}

		objectOutput.writeBoolean(countryStatus);
		objectOutput.writeLong(createdDate);
	}

	public long countryId;
	public String countryName;
	public boolean countryStatus;
	public long createdDate;
}