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

import com.services.service.AdCountryLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class AdCountryClp extends BaseModelImpl<AdCountry> implements AdCountry {
	public AdCountryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AdCountry.class;
	}

	@Override
	public String getModelClassName() {
		return AdCountry.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _countryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCountryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _countryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("countryId", getCountryId());
		attributes.put("countryName", getCountryName());
		attributes.put("countryStatus", getCountryStatus());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		Boolean countryStatus = (Boolean)attributes.get("countryStatus");

		if (countryStatus != null) {
			setCountryStatus(countryStatus);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;

		if (_adCountryRemoteModel != null) {
			try {
				Class<?> clazz = _adCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_adCountryRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryName() {
		return _countryName;
	}

	@Override
	public void setCountryName(String countryName) {
		_countryName = countryName;

		if (_adCountryRemoteModel != null) {
			try {
				Class<?> clazz = _adCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryName", String.class);

				method.invoke(_adCountryRemoteModel, countryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCountryStatus() {
		return _countryStatus;
	}

	@Override
	public boolean isCountryStatus() {
		return _countryStatus;
	}

	@Override
	public void setCountryStatus(boolean countryStatus) {
		_countryStatus = countryStatus;

		if (_adCountryRemoteModel != null) {
			try {
				Class<?> clazz = _adCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryStatus",
						boolean.class);

				method.invoke(_adCountryRemoteModel, countryStatus);
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

		if (_adCountryRemoteModel != null) {
			try {
				Class<?> clazz = _adCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_adCountryRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAdCountryRemoteModel() {
		return _adCountryRemoteModel;
	}

	public void setAdCountryRemoteModel(BaseModel<?> adCountryRemoteModel) {
		_adCountryRemoteModel = adCountryRemoteModel;
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

		Class<?> remoteModelClass = _adCountryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_adCountryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdCountryLocalServiceUtil.addAdCountry(this);
		}
		else {
			AdCountryLocalServiceUtil.updateAdCountry(this);
		}
	}

	@Override
	public AdCountry toEscapedModel() {
		return (AdCountry)ProxyUtil.newProxyInstance(AdCountry.class.getClassLoader(),
			new Class[] { AdCountry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdCountryClp clone = new AdCountryClp();

		clone.setCountryId(getCountryId());
		clone.setCountryName(getCountryName());
		clone.setCountryStatus(getCountryStatus());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
	public int compareTo(AdCountry adCountry) {
		int value = 0;

		value = getCountryName().compareTo(adCountry.getCountryName());

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

		if (!(obj instanceof AdCountryClp)) {
			return false;
		}

		AdCountryClp adCountry = (AdCountryClp)obj;

		long primaryKey = adCountry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{countryId=");
		sb.append(getCountryId());
		sb.append(", countryName=");
		sb.append(getCountryName());
		sb.append(", countryStatus=");
		sb.append(getCountryStatus());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.services.model.AdCountry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryName</column-name><column-value><![CDATA[");
		sb.append(getCountryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryStatus</column-name><column-value><![CDATA[");
		sb.append(getCountryStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _countryId;
	private String _countryName;
	private boolean _countryStatus;
	private Date _createdDate;
	private BaseModel<?> _adCountryRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}