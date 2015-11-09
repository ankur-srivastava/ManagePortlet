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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.services.service.AdResponseTrackerLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class AdResponseTrackerClp extends BaseModelImpl<AdResponseTracker>
	implements AdResponseTracker {
	public AdResponseTrackerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AdResponseTracker.class;
	}

	@Override
	public String getModelClassName() {
		return AdResponseTracker.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _artId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setArtId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _artId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("artId", getArtId());
		attributes.put("adId", getAdId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("phone", getPhone());
		attributes.put("comments", getComments());
		attributes.put("userIP", getUserIP());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long artId = (Long)attributes.get("artId");

		if (artId != null) {
			setArtId(artId);
		}

		Long adId = (Long)attributes.get("adId");

		if (adId != null) {
			setAdId(adId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String userIP = (String)attributes.get("userIP");

		if (userIP != null) {
			setUserIP(userIP);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public long getArtId() {
		return _artId;
	}

	@Override
	public void setArtId(long artId) {
		_artId = artId;

		if (_adResponseTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adResponseTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setArtId", long.class);

				method.invoke(_adResponseTrackerRemoteModel, artId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAdId() {
		return _adId;
	}

	@Override
	public void setAdId(long adId) {
		_adId = adId;

		if (_adResponseTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adResponseTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setAdId", long.class);

				method.invoke(_adResponseTrackerRemoteModel, adId);
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

		if (_adResponseTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adResponseTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_adResponseTrackerRemoteModel, userId);
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
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_adResponseTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adResponseTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_adResponseTrackerRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_adResponseTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adResponseTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_adResponseTrackerRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhone() {
		return _phone;
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;

		if (_adResponseTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adResponseTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setPhone", String.class);

				method.invoke(_adResponseTrackerRemoteModel, phone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComments() {
		return _comments;
	}

	@Override
	public void setComments(String comments) {
		_comments = comments;

		if (_adResponseTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adResponseTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setComments", String.class);

				method.invoke(_adResponseTrackerRemoteModel, comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserIP() {
		return _userIP;
	}

	@Override
	public void setUserIP(String userIP) {
		_userIP = userIP;

		if (_adResponseTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adResponseTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIP", String.class);

				method.invoke(_adResponseTrackerRemoteModel, userIP);
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

		if (_adResponseTrackerRemoteModel != null) {
			try {
				Class<?> clazz = _adResponseTrackerRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_adResponseTrackerRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAdResponseTrackerRemoteModel() {
		return _adResponseTrackerRemoteModel;
	}

	public void setAdResponseTrackerRemoteModel(
		BaseModel<?> adResponseTrackerRemoteModel) {
		_adResponseTrackerRemoteModel = adResponseTrackerRemoteModel;
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

		Class<?> remoteModelClass = _adResponseTrackerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_adResponseTrackerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdResponseTrackerLocalServiceUtil.addAdResponseTracker(this);
		}
		else {
			AdResponseTrackerLocalServiceUtil.updateAdResponseTracker(this);
		}
	}

	@Override
	public AdResponseTracker toEscapedModel() {
		return (AdResponseTracker)ProxyUtil.newProxyInstance(AdResponseTracker.class.getClassLoader(),
			new Class[] { AdResponseTracker.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdResponseTrackerClp clone = new AdResponseTrackerClp();

		clone.setArtId(getArtId());
		clone.setAdId(getAdId());
		clone.setUserId(getUserId());
		clone.setName(getName());
		clone.setEmail(getEmail());
		clone.setPhone(getPhone());
		clone.setComments(getComments());
		clone.setUserIP(getUserIP());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
	public int compareTo(AdResponseTracker adResponseTracker) {
		int value = 0;

		value = DateUtil.compareTo(getCreatedDate(),
				adResponseTracker.getCreatedDate());

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

		if (!(obj instanceof AdResponseTrackerClp)) {
			return false;
		}

		AdResponseTrackerClp adResponseTracker = (AdResponseTrackerClp)obj;

		long primaryKey = adResponseTracker.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{artId=");
		sb.append(getArtId());
		sb.append(", adId=");
		sb.append(getAdId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", userIP=");
		sb.append(getUserIP());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.services.model.AdResponseTracker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>artId</column-name><column-value><![CDATA[");
		sb.append(getArtId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adId</column-name><column-value><![CDATA[");
		sb.append(getAdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIP</column-name><column-value><![CDATA[");
		sb.append(getUserIP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _artId;
	private long _adId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _email;
	private String _phone;
	private String _comments;
	private String _userIP;
	private Date _createdDate;
	private BaseModel<?> _adResponseTrackerRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}