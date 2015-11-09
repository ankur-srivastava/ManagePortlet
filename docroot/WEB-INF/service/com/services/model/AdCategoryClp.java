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

import com.services.service.AdCategoryLocalServiceUtil;
import com.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ankur Srivastava
 */
public class AdCategoryClp extends BaseModelImpl<AdCategory>
	implements AdCategory {
	public AdCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AdCategory.class;
	}

	@Override
	public String getModelClassName() {
		return AdCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _categoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _categoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryStatus", getCategoryStatus());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		Boolean categoryStatus = (Boolean)attributes.get("categoryStatus");

		if (categoryStatus != null) {
			setCategoryStatus(categoryStatus);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_adCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _adCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_adCategoryRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategoryName() {
		return _categoryName;
	}

	@Override
	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;

		if (_adCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _adCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryName", String.class);

				method.invoke(_adCategoryRemoteModel, categoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCategoryStatus() {
		return _categoryStatus;
	}

	@Override
	public boolean isCategoryStatus() {
		return _categoryStatus;
	}

	@Override
	public void setCategoryStatus(boolean categoryStatus) {
		_categoryStatus = categoryStatus;

		if (_adCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _adCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryStatus",
						boolean.class);

				method.invoke(_adCategoryRemoteModel, categoryStatus);
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

		if (_adCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _adCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_adCategoryRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAdCategoryRemoteModel() {
		return _adCategoryRemoteModel;
	}

	public void setAdCategoryRemoteModel(BaseModel<?> adCategoryRemoteModel) {
		_adCategoryRemoteModel = adCategoryRemoteModel;
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

		Class<?> remoteModelClass = _adCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_adCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdCategoryLocalServiceUtil.addAdCategory(this);
		}
		else {
			AdCategoryLocalServiceUtil.updateAdCategory(this);
		}
	}

	@Override
	public AdCategory toEscapedModel() {
		return (AdCategory)ProxyUtil.newProxyInstance(AdCategory.class.getClassLoader(),
			new Class[] { AdCategory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdCategoryClp clone = new AdCategoryClp();

		clone.setCategoryId(getCategoryId());
		clone.setCategoryName(getCategoryName());
		clone.setCategoryStatus(getCategoryStatus());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
	public int compareTo(AdCategory adCategory) {
		int value = 0;

		value = getCategoryName().compareTo(adCategory.getCategoryName());

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

		if (!(obj instanceof AdCategoryClp)) {
			return false;
		}

		AdCategoryClp adCategory = (AdCategoryClp)obj;

		long primaryKey = adCategory.getPrimaryKey();

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

		sb.append("{categoryId=");
		sb.append(getCategoryId());
		sb.append(", categoryName=");
		sb.append(getCategoryName());
		sb.append(", categoryStatus=");
		sb.append(getCategoryStatus());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.services.model.AdCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryName</column-name><column-value><![CDATA[");
		sb.append(getCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryStatus</column-name><column-value><![CDATA[");
		sb.append(getCategoryStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _categoryId;
	private String _categoryName;
	private boolean _categoryStatus;
	private Date _createdDate;
	private BaseModel<?> _adCategoryRemoteModel;
	private Class<?> _clpSerializerClass = com.services.service.ClpSerializer.class;
}