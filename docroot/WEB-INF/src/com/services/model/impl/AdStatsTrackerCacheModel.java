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
import com.liferay.portal.model.CacheModel;

import com.services.model.AdStatsTracker;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AdStatsTracker in entity cache.
 *
 * @author Ankur Srivastava
 * @see AdStatsTracker
 * @generated
 */
public class AdStatsTrackerCacheModel implements CacheModel<AdStatsTracker>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{adId=");
		sb.append(adId);
		sb.append(", adCount=");
		sb.append(adCount);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", lastAccessedDate=");
		sb.append(lastAccessedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdStatsTracker toEntityModel() {
		AdStatsTrackerImpl adStatsTrackerImpl = new AdStatsTrackerImpl();

		adStatsTrackerImpl.setAdId(adId);
		adStatsTrackerImpl.setAdCount(adCount);

		if (createdDate == Long.MIN_VALUE) {
			adStatsTrackerImpl.setCreatedDate(null);
		}
		else {
			adStatsTrackerImpl.setCreatedDate(new Date(createdDate));
		}

		if (lastAccessedDate == Long.MIN_VALUE) {
			adStatsTrackerImpl.setLastAccessedDate(null);
		}
		else {
			adStatsTrackerImpl.setLastAccessedDate(new Date(lastAccessedDate));
		}

		adStatsTrackerImpl.resetOriginalValues();

		return adStatsTrackerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		adId = objectInput.readLong();
		adCount = objectInput.readLong();
		createdDate = objectInput.readLong();
		lastAccessedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(adId);
		objectOutput.writeLong(adCount);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(lastAccessedDate);
	}

	public long adId;
	public long adCount;
	public long createdDate;
	public long lastAccessedDate;
}