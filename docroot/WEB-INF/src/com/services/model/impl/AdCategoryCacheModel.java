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

import com.services.model.AdCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AdCategory in entity cache.
 *
 * @author Ankur Srivastava
 * @see AdCategory
 * @generated
 */
public class AdCategoryCacheModel implements CacheModel<AdCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", categoryStatus=");
		sb.append(categoryStatus);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdCategory toEntityModel() {
		AdCategoryImpl adCategoryImpl = new AdCategoryImpl();

		adCategoryImpl.setCategoryId(categoryId);

		if (categoryName == null) {
			adCategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			adCategoryImpl.setCategoryName(categoryName);
		}

		adCategoryImpl.setCategoryStatus(categoryStatus);

		if (createdDate == Long.MIN_VALUE) {
			adCategoryImpl.setCreatedDate(null);
		}
		else {
			adCategoryImpl.setCreatedDate(new Date(createdDate));
		}

		adCategoryImpl.resetOriginalValues();

		return adCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		categoryId = objectInput.readLong();
		categoryName = objectInput.readUTF();
		categoryStatus = objectInput.readBoolean();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(categoryId);

		if (categoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categoryName);
		}

		objectOutput.writeBoolean(categoryStatus);
		objectOutput.writeLong(createdDate);
	}

	public long categoryId;
	public String categoryName;
	public boolean categoryStatus;
	public long createdDate;
}