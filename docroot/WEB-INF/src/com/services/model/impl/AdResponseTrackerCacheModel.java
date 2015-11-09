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

import com.services.model.AdResponseTracker;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AdResponseTracker in entity cache.
 *
 * @author Ankur Srivastava
 * @see AdResponseTracker
 * @generated
 */
public class AdResponseTrackerCacheModel implements CacheModel<AdResponseTracker>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{artId=");
		sb.append(artId);
		sb.append(", adId=");
		sb.append(adId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", userIP=");
		sb.append(userIP);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdResponseTracker toEntityModel() {
		AdResponseTrackerImpl adResponseTrackerImpl = new AdResponseTrackerImpl();

		adResponseTrackerImpl.setArtId(artId);
		adResponseTrackerImpl.setAdId(adId);
		adResponseTrackerImpl.setUserId(userId);

		if (name == null) {
			adResponseTrackerImpl.setName(StringPool.BLANK);
		}
		else {
			adResponseTrackerImpl.setName(name);
		}

		if (email == null) {
			adResponseTrackerImpl.setEmail(StringPool.BLANK);
		}
		else {
			adResponseTrackerImpl.setEmail(email);
		}

		if (phone == null) {
			adResponseTrackerImpl.setPhone(StringPool.BLANK);
		}
		else {
			adResponseTrackerImpl.setPhone(phone);
		}

		if (comments == null) {
			adResponseTrackerImpl.setComments(StringPool.BLANK);
		}
		else {
			adResponseTrackerImpl.setComments(comments);
		}

		if (userIP == null) {
			adResponseTrackerImpl.setUserIP(StringPool.BLANK);
		}
		else {
			adResponseTrackerImpl.setUserIP(userIP);
		}

		if (createdDate == Long.MIN_VALUE) {
			adResponseTrackerImpl.setCreatedDate(null);
		}
		else {
			adResponseTrackerImpl.setCreatedDate(new Date(createdDate));
		}

		adResponseTrackerImpl.resetOriginalValues();

		return adResponseTrackerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		artId = objectInput.readLong();
		adId = objectInput.readLong();
		userId = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		phone = objectInput.readUTF();
		comments = objectInput.readUTF();
		userIP = objectInput.readUTF();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(artId);
		objectOutput.writeLong(adId);
		objectOutput.writeLong(userId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (userIP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userIP);
		}

		objectOutput.writeLong(createdDate);
	}

	public long artId;
	public long adId;
	public long userId;
	public String name;
	public String email;
	public String phone;
	public String comments;
	public String userIP;
	public long createdDate;
}