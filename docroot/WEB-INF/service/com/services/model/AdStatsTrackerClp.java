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

import com.services.service.AdStatsTrackerLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class AdStatsTrackerClp extends BaseModelImpl<AdStatsTracker>
	implements AdStatsTracker {
	public AdStatsTrackerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AdStatsTracker.class;
	}

	@Override
	public String getModelClassName() {
		return AdStatsTracker.class.getName();
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
		attributes.put("adCount", getAdCount());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("lastAccessedDate", getLastAccessedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long adId = (Long)attributes.get("adId");

		if (adId != null) {
			setAdId(adId);
		}

		Long adCount = (Long)attributes.get("adCount");

		if (adCount != null) {
			setAdCount(adCount);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date lastAccessedDate = (Date)attributes.get("lastAccessedDate");

		if (lastAccessedDate != null) {
			setLastAccessedDate(lastAccessedDate);
		}
	}

	@Override
	public long getAdId() {
		return _adId;
	}

	@Override
	public void setAdId(long adId) {
		_adId = adId;

		if (_adStatsTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adStatsTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setAdId", long.class);

				method.invoke(_adStatsTrackerRemoteModel, adId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAdCount() {
		return _adCount;
	}

	@Override
	public void setAdCount(long adCount) {
		_adCount = adCount;

		if (_adStatsTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adStatsTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setAdCount", long.class);

				method.invoke(_adStatsTrackerRemoteModel, adCount);
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

		if (_adStatsTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adStatsTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_adStatsTrackerRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastAccessedDate() {
		return _lastAccessedDate;
	}

	@Override
	public void setLastAccessedDate(Date lastAccessedDate) {
		_lastAccessedDate = lastAccessedDate;

		if (_adStatsTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adStatsTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setLastAccessedDate",
						Date.class);

				method.invoke(_adStatsTrackerRemoteModel, lastAccessedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAdStatsTrackerRemoteModel() {
		return _adStatsTrackerRemoteModel;
	}

	public void setAdStatsTrackerRemoteModel(
		BaseModel<?> adStatsTrackerRemoteModel) {
		_adStatsTrackerRemoteModel = adStatsTrackerRemoteModel;
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

		Class<?> remoteModelClass = _adStatsTrackerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_adStatsTrackerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdStatsTrackerLocalServiceUtil.addAdStatsTracker(this);
		}
		else {
			AdStatsTrackerLocalServiceUtil.updateAdStatsTracker(this);
		}
	}

	@Override
	public AdStatsTracker toEscapedModel() {
		return (AdStatsTracker)ProxyUtil.newProxyInstance(AdStatsTracker.class.getClassLoader(),
			new Class[] { AdStatsTracker.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdStatsTrackerClp clone = new AdStatsTrackerClp();

		clone.setAdId(getAdId());
		clone.setAdCount(getAdCount());
		clone.setCreatedDate(getCreatedDate());
		clone.setLastAccessedDate(getLastAccessedDate());

		return clone;
	}

	@Override
	public int compareTo(AdStatsTracker adStatsTracker) {
		long primaryKey = adStatsTracker.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdStatsTrackerClp)) {
			return false;
		}

		AdStatsTrackerClp adStatsTracker = (AdStatsTrackerClp)obj;

		long primaryKey = adStatsTracker.getPrimaryKey();

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

		sb.append("{adId=");
		sb.append(getAdId());
		sb.append(", adCount=");
		sb.append(getAdCount());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", lastAccessedDate=");
		sb.append(getLastAccessedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.services.model.AdStatsTracker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>adId</column-name><column-value><![CDATA[");
		sb.append(getAdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adCount</column-name><column-value><![CDATA[");
		sb.append(getAdCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastAccessedDate</column-name><column-value><![CDATA[");
		sb.append(getLastAccessedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _adId;
	private long _adCount;
	private Date _createdDate;
	private Date _lastAccessedDate;
	private BaseModel<?> _adStatsTrackerRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}