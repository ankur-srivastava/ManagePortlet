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

import com.services.model.AdListing;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AdListing in entity cache.
 *
 * @author Ankur Srivastava
 * @see AdListing
 * @generated
 */
public class AdListingCacheModel implements CacheModel<AdListing>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{adId=");
		sb.append(adId);
		sb.append(", adTitle=");
		sb.append(adTitle);
		sb.append(", adDescription=");
		sb.append(adDescription);
		sb.append(", adCatId=");
		sb.append(adCatId);
		sb.append(", adServiceType=");
		sb.append(adServiceType);
		sb.append(", adCountryId=");
		sb.append(adCountryId);
		sb.append(", adCityId=");
		sb.append(adCityId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", adUserName=");
		sb.append(adUserName);
		sb.append(", adUserEmail=");
		sb.append(adUserEmail);
		sb.append(", adUserPhone=");
		sb.append(adUserPhone);
		sb.append(", adStatus=");
		sb.append(adStatus);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdListing toEntityModel() {
		AdListingImpl adListingImpl = new AdListingImpl();

		adListingImpl.setAdId(adId);

		if (adTitle == null) {
			adListingImpl.setAdTitle(StringPool.BLANK);
		}
		else {
			adListingImpl.setAdTitle(adTitle);
		}

		if (adDescription == null) {
			adListingImpl.setAdDescription(StringPool.BLANK);
		}
		else {
			adListingImpl.setAdDescription(adDescription);
		}

		adListingImpl.setAdCatId(adCatId);

		if (adServiceType == null) {
			adListingImpl.setAdServiceType(StringPool.BLANK);
		}
		else {
			adListingImpl.setAdServiceType(adServiceType);
		}

		adListingImpl.setAdCountryId(adCountryId);
		adListingImpl.setAdCityId(adCityId);
		adListingImpl.setUserId(userId);

		if (adUserName == null) {
			adListingImpl.setAdUserName(StringPool.BLANK);
		}
		else {
			adListingImpl.setAdUserName(adUserName);
		}

		if (adUserEmail == null) {
			adListingImpl.setAdUserEmail(StringPool.BLANK);
		}
		else {
			adListingImpl.setAdUserEmail(adUserEmail);
		}

		if (adUserPhone == null) {
			adListingImpl.setAdUserPhone(StringPool.BLANK);
		}
		else {
			adListingImpl.setAdUserPhone(adUserPhone);
		}

		adListingImpl.setAdStatus(adStatus);

		if (createdDate == Long.MIN_VALUE) {
			adListingImpl.setCreatedDate(null);
		}
		else {
			adListingImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			adListingImpl.setModifiedDate(null);
		}
		else {
			adListingImpl.setModifiedDate(new Date(modifiedDate));
		}

		adListingImpl.setCompanyId(companyId);
		adListingImpl.setGroupId(groupId);

		adListingImpl.resetOriginalValues();

		return adListingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		adId = objectInput.readLong();
		adTitle = objectInput.readUTF();
		adDescription = objectInput.readUTF();
		adCatId = objectInput.readLong();
		adServiceType = objectInput.readUTF();
		adCountryId = objectInput.readLong();
		adCityId = objectInput.readLong();
		userId = objectInput.readLong();
		adUserName = objectInput.readUTF();
		adUserEmail = objectInput.readUTF();
		adUserPhone = objectInput.readUTF();
		adStatus = objectInput.readBoolean();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(adId);

		if (adTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adTitle);
		}

		if (adDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adDescription);
		}

		objectOutput.writeLong(adCatId);

		if (adServiceType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adServiceType);
		}

		objectOutput.writeLong(adCountryId);
		objectOutput.writeLong(adCityId);
		objectOutput.writeLong(userId);

		if (adUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adUserName);
		}

		if (adUserEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adUserEmail);
		}

		if (adUserPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adUserPhone);
		}

		objectOutput.writeBoolean(adStatus);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
	}

	public long adId;
	public String adTitle;
	public String adDescription;
	public long adCatId;
	public String adServiceType;
	public long adCountryId;
	public long adCityId;
	public long userId;
	public String adUserName;
	public String adUserEmail;
	public String adUserPhone;
	public boolean adStatus;
	public long createdDate;
	public long modifiedDate;
	public long companyId;
	public long groupId;
}