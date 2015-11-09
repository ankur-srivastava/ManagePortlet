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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.services.service.AdListingLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class AdListingClp extends BaseModelImpl<AdListing> implements AdListing {
	public AdListingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AdListing.class;
	}

	@Override
	public String getModelClassName() {
		return AdListing.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _adId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAdId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _adId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("adId", getAdId());
		attributes.put("adTitle", getAdTitle());
		attributes.put("adDescription", getAdDescription());
		attributes.put("adCatId", getAdCatId());
		attributes.put("adServiceType", getAdServiceType());
		attributes.put("adCountryId", getAdCountryId());
		attributes.put("adCityId", getAdCityId());
		attributes.put("userId", getUserId());
		attributes.put("adUserName", getAdUserName());
		attributes.put("adUserEmail", getAdUserEmail());
		attributes.put("adUserPhone", getAdUserPhone());
		attributes.put("adStatus", getAdStatus());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long adId = (Long)attributes.get("adId");

		if (adId != null) {
			setAdId(adId);
		}

		String adTitle = (String)attributes.get("adTitle");

		if (adTitle != null) {
			setAdTitle(adTitle);
		}

		String adDescription = (String)attributes.get("adDescription");

		if (adDescription != null) {
			setAdDescription(adDescription);
		}

		Long adCatId = (Long)attributes.get("adCatId");

		if (adCatId != null) {
			setAdCatId(adCatId);
		}

		String adServiceType = (String)attributes.get("adServiceType");

		if (adServiceType != null) {
			setAdServiceType(adServiceType);
		}

		Long adCountryId = (Long)attributes.get("adCountryId");

		if (adCountryId != null) {
			setAdCountryId(adCountryId);
		}

		Long adCityId = (Long)attributes.get("adCityId");

		if (adCityId != null) {
			setAdCityId(adCityId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String adUserName = (String)attributes.get("adUserName");

		if (adUserName != null) {
			setAdUserName(adUserName);
		}

		String adUserEmail = (String)attributes.get("adUserEmail");

		if (adUserEmail != null) {
			setAdUserEmail(adUserEmail);
		}

		String adUserPhone = (String)attributes.get("adUserPhone");

		if (adUserPhone != null) {
			setAdUserPhone(adUserPhone);
		}

		Boolean adStatus = (Boolean)attributes.get("adStatus");

		if (adStatus != null) {
			setAdStatus(adStatus);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public long getAdId() {
		return _adId;
	}

	@Override
	public void setAdId(long adId) {
		_adId = adId;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdId", long.class);

				method.invoke(_adListingRemoteModel, adId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdTitle() {
		return _adTitle;
	}

	@Override
	public void setAdTitle(String adTitle) {
		_adTitle = adTitle;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdTitle", String.class);

				method.invoke(_adListingRemoteModel, adTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdDescription() {
		return _adDescription;
	}

	@Override
	public void setAdDescription(String adDescription) {
		_adDescription = adDescription;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdDescription", String.class);

				method.invoke(_adListingRemoteModel, adDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAdCatId() {
		return _adCatId;
	}

	@Override
	public void setAdCatId(long adCatId) {
		_adCatId = adCatId;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdCatId", long.class);

				method.invoke(_adListingRemoteModel, adCatId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdServiceType() {
		return _adServiceType;
	}

	@Override
	public void setAdServiceType(String adServiceType) {
		_adServiceType = adServiceType;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdServiceType", String.class);

				method.invoke(_adListingRemoteModel, adServiceType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAdCountryId() {
		return _adCountryId;
	}

	@Override
	public void setAdCountryId(long adCountryId) {
		_adCountryId = adCountryId;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdCountryId", long.class);

				method.invoke(_adListingRemoteModel, adCountryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAdCityId() {
		return _adCityId;
	}

	@Override
	public void setAdCityId(long adCityId) {
		_adCityId = adCityId;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdCityId", long.class);

				method.invoke(_adListingRemoteModel, adCityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_adListingRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getAdUserName() {
		return _adUserName;
	}

	@Override
	public void setAdUserName(String adUserName) {
		_adUserName = adUserName;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdUserName", String.class);

				method.invoke(_adListingRemoteModel, adUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdUserEmail() {
		return _adUserEmail;
	}

	@Override
	public void setAdUserEmail(String adUserEmail) {
		_adUserEmail = adUserEmail;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdUserEmail", String.class);

				method.invoke(_adListingRemoteModel, adUserEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdUserPhone() {
		return _adUserPhone;
	}

	@Override
	public void setAdUserPhone(String adUserPhone) {
		_adUserPhone = adUserPhone;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdUserPhone", String.class);

				method.invoke(_adListingRemoteModel, adUserPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAdStatus() {
		return _adStatus;
	}

	@Override
	public boolean isAdStatus() {
		return _adStatus;
	}

	@Override
	public void setAdStatus(boolean adStatus) {
		_adStatus = adStatus;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setAdStatus", boolean.class);

				method.invoke(_adListingRemoteModel, adStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_adListingRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_adListingRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_adListingRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_adListingRemoteModel != null) {
			try {
				Class<?> clazz = _adListingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_adListingRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAdListingRemoteModel() {
		return _adListingRemoteModel;
	}

	public void setAdListingRemoteModel(BaseModel<?> adListingRemoteModel) {
		_adListingRemoteModel = adListingRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _adListingRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_adListingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdListingLocalServiceUtil.addAdListing(this);
		}
		else {
			AdListingLocalServiceUtil.updateAdListing(this);
		}
	}

	@Override
	public AdListing toEscapedModel() {
		return (AdListing)ProxyUtil.newProxyInstance(AdListing.class.getClassLoader(),
			new Class[] { AdListing.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdListingClp clone = new AdListingClp();

		clone.setAdId(getAdId());
		clone.setAdTitle(getAdTitle());
		clone.setAdDescription(getAdDescription());
		clone.setAdCatId(getAdCatId());
		clone.setAdServiceType(getAdServiceType());
		clone.setAdCountryId(getAdCountryId());
		clone.setAdCityId(getAdCityId());
		clone.setUserId(getUserId());
		clone.setAdUserName(getAdUserName());
		clone.setAdUserEmail(getAdUserEmail());
		clone.setAdUserPhone(getAdUserPhone());
		clone.setAdStatus(getAdStatus());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(AdListing adListing) {
		int value = 0;

		if (getAdId() < adListing.getAdId()) {
			value = -1;
		}
		else if (getAdId() > adListing.getAdId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdListingClp)) {
			return false;
		}

		AdListingClp adListing = (AdListingClp)obj;

		long primaryKey = adListing.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{adId=");
		sb.append(getAdId());
		sb.append(", adTitle=");
		sb.append(getAdTitle());
		sb.append(", adDescription=");
		sb.append(getAdDescription());
		sb.append(", adCatId=");
		sb.append(getAdCatId());
		sb.append(", adServiceType=");
		sb.append(getAdServiceType());
		sb.append(", adCountryId=");
		sb.append(getAdCountryId());
		sb.append(", adCityId=");
		sb.append(getAdCityId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", adUserName=");
		sb.append(getAdUserName());
		sb.append(", adUserEmail=");
		sb.append(getAdUserEmail());
		sb.append(", adUserPhone=");
		sb.append(getAdUserPhone());
		sb.append(", adStatus=");
		sb.append(getAdStatus());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.services.model.AdListing");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>adId</column-name><column-value><![CDATA[");
		sb.append(getAdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adTitle</column-name><column-value><![CDATA[");
		sb.append(getAdTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adDescription</column-name><column-value><![CDATA[");
		sb.append(getAdDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adCatId</column-name><column-value><![CDATA[");
		sb.append(getAdCatId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adServiceType</column-name><column-value><![CDATA[");
		sb.append(getAdServiceType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adCountryId</column-name><column-value><![CDATA[");
		sb.append(getAdCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adCityId</column-name><column-value><![CDATA[");
		sb.append(getAdCityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adUserName</column-name><column-value><![CDATA[");
		sb.append(getAdUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adUserEmail</column-name><column-value><![CDATA[");
		sb.append(getAdUserEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adUserPhone</column-name><column-value><![CDATA[");
		sb.append(getAdUserPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adStatus</column-name><column-value><![CDATA[");
		sb.append(getAdStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _adId;
	private String _adTitle;
	private String _adDescription;
	private long _adCatId;
	private String _adServiceType;
	private long _adCountryId;
	private long _adCityId;
	private long _userId;
	private String _userUuid;
	private String _adUserName;
	private String _adUserEmail;
	private String _adUserPhone;
	private boolean _adStatus;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _companyId;
	private long _groupId;
	private BaseModel<?> _adListingRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}