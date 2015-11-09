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

import com.services.service.AdCityLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class AdCityClp extends BaseModelImpl<AdCity> implements AdCity {
	public AdCityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AdCity.class;
	}

	@Override
	public String getModelClassName() {
		return AdCity.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _cityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cityId", getCityId());
		attributes.put("cityName", getCityName());
		attributes.put("stateName", getStateName());
		attributes.put("cityStatus", getCityStatus());
		attributes.put("popular", getPopular());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}

		String cityName = (String)attributes.get("cityName");

		if (cityName != null) {
			setCityName(cityName);
		}

		String stateName = (String)attributes.get("stateName");

		if (stateName != null) {
			setStateName(stateName);
		}

		Boolean cityStatus = (Boolean)attributes.get("cityStatus");

		if (cityStatus != null) {
			setCityStatus(cityStatus);
		}

		Boolean popular = (Boolean)attributes.get("popular");

		if (popular != null) {
			setPopular(popular);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public long getCityId() {
		return _cityId;
	}

	@Override
	public void setCityId(long cityId) {
		_cityId = cityId;

		if (_adCityRemoteModel != null) {
			try {
				Class<?> clazz = _adCityRemoteModel.getClass();

				Method method = clazz.getMethod("setCityId", long.class);

				method.invoke(_adCityRemoteModel, cityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCityName() {
		return _cityName;
	}

	@Override
	public void setCityName(String cityName) {
		_cityName = cityName;

		if (_adCityRemoteModel != null) {
			try {
				Class<?> clazz = _adCityRemoteModel.getClass();

				Method method = clazz.getMethod("setCityName", String.class);

				method.invoke(_adCityRemoteModel, cityName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStateName() {
		return _stateName;
	}

	@Override
	public void setStateName(String stateName) {
		_stateName = stateName;

		if (_adCityRemoteModel != null) {
			try {
				Class<?> clazz = _adCityRemoteModel.getClass();

				Method method = clazz.getMethod("setStateName", String.class);

				method.invoke(_adCityRemoteModel, stateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCityStatus() {
		return _cityStatus;
	}

	@Override
	public boolean isCityStatus() {
		return _cityStatus;
	}

	@Override
	public void setCityStatus(boolean cityStatus) {
		_cityStatus = cityStatus;

		if (_adCityRemoteModel != null) {
			try {
				Class<?> clazz = _adCityRemoteModel.getClass();

				Method method = clazz.getMethod("setCityStatus", boolean.class);

				method.invoke(_adCityRemoteModel, cityStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPopular() {
		return _popular;
	}

	@Override
	public boolean isPopular() {
		return _popular;
	}

	@Override
	public void setPopular(boolean popular) {
		_popular = popular;

		if (_adCityRemoteModel != null) {
			try {
				Class<?> clazz = _adCityRemoteModel.getClass();

				Method method = clazz.getMethod("setPopular", boolean.class);

				method.invoke(_adCityRemoteModel, popular);
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

		if (_adCityRemoteModel != null) {
			try {
				Class<?> clazz = _adCityRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_adCityRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAdCityRemoteModel() {
		return _adCityRemoteModel;
	}

	public void setAdCityRemoteModel(BaseModel<?> adCityRemoteModel) {
		_adCityRemoteModel = adCityRemoteModel;
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

		Class<?> remoteModelClass = _adCityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_adCityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdCityLocalServiceUtil.addAdCity(this);
		}
		else {
			AdCityLocalServiceUtil.updateAdCity(this);
		}
	}

	@Override
	public AdCity toEscapedModel() {
		return (AdCity)ProxyUtil.newProxyInstance(AdCity.class.getClassLoader(),
			new Class[] { AdCity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdCityClp clone = new AdCityClp();

		clone.setCityId(getCityId());
		clone.setCityName(getCityName());
		clone.setStateName(getStateName());
		clone.setCityStatus(getCityStatus());
		clone.setPopular(getPopular());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
	public int compareTo(AdCity adCity) {
		int value = 0;

		value = getCityName().compareTo(adCity.getCityName());

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

		if (!(obj instanceof AdCityClp)) {
			return false;
		}

		AdCityClp adCity = (AdCityClp)obj;

		long primaryKey = adCity.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{cityId=");
		sb.append(getCityId());
		sb.append(", cityName=");
		sb.append(getCityName());
		sb.append(", stateName=");
		sb.append(getStateName());
		sb.append(", cityStatus=");
		sb.append(getCityStatus());
		sb.append(", popular=");
		sb.append(getPopular());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.services.model.AdCity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cityId</column-name><column-value><![CDATA[");
		sb.append(getCityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cityName</column-name><column-value><![CDATA[");
		sb.append(getCityName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateName</column-name><column-value><![CDATA[");
		sb.append(getStateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cityStatus</column-name><column-value><![CDATA[");
		sb.append(getCityStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>popular</column-name><column-value><![CDATA[");
		sb.append(getPopular());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _cityId;
	private String _cityName;
	private String _stateName;
	private boolean _cityStatus;
	private boolean _popular;
	private Date _createdDate;
	private BaseModel<?> _adCityRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}