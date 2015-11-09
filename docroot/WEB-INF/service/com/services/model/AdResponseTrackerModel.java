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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AdResponseTracker service. Represents a row in the &quot;AL_AdResponseTracker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.services.model.impl.AdResponseTrackerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.services.model.impl.AdResponseTrackerImpl}.
 * </p>
 *
 * @author Ankur Srivastava
 * @see AdResponseTracker
 * @see com.services.model.impl.AdResponseTrackerImpl
 * @see com.services.model.impl.AdResponseTrackerModelImpl
 * @generated
 */
public interface AdResponseTrackerModel extends BaseModel<AdResponseTracker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ad response tracker model instance should use the {@link AdResponseTracker} interface instead.
	 */

	/**
	 * Returns the primary key of this ad response tracker.
	 *
	 * @return the primary key of this ad response tracker
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ad response tracker.
	 *
	 * @param primaryKey the primary key of this ad response tracker
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the art ID of this ad response tracker.
	 *
	 * @return the art ID of this ad response tracker
	 */
	public long getArtId();

	/**
	 * Sets the art ID of this ad response tracker.
	 *
	 * @param artId the art ID of this ad response tracker
	 */
	public void setArtId(long artId);

	/**
	 * Returns the ad ID of this ad response tracker.
	 *
	 * @return the ad ID of this ad response tracker
	 */
	public long getAdId();

	/**
	 * Sets the ad ID of this ad response tracker.
	 *
	 * @param adId the ad ID of this ad response tracker
	 */
	public void setAdId(long adId);

	/**
	 * Returns the user ID of this ad response tracker.
	 *
	 * @return the user ID of this ad response tracker
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this ad response tracker.
	 *
	 * @param userId the user ID of this ad response tracker
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ad response tracker.
	 *
	 * @return the user uuid of this ad response tracker
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this ad response tracker.
	 *
	 * @param userUuid the user uuid of this ad response tracker
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the name of this ad response tracker.
	 *
	 * @return the name of this ad response tracker
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this ad response tracker.
	 *
	 * @param name the name of this ad response tracker
	 */
	public void setName(String name);

	/**
	 * Returns the email of this ad response tracker.
	 *
	 * @return the email of this ad response tracker
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this ad response tracker.
	 *
	 * @param email the email of this ad response tracker
	 */
	public void setEmail(String email);

	/**
	 * Returns the phone of this ad response tracker.
	 *
	 * @return the phone of this ad response tracker
	 */
	@AutoEscape
	public String getPhone();

	/**
	 * Sets the phone of this ad response tracker.
	 *
	 * @param phone the phone of this ad response tracker
	 */
	public void setPhone(String phone);

	/**
	 * Returns the comments of this ad response tracker.
	 *
	 * @return the comments of this ad response tracker
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this ad response tracker.
	 *
	 * @param comments the comments of this ad response tracker
	 */
	public void setComments(String comments);

	/**
	 * Returns the user i p of this ad response tracker.
	 *
	 * @return the user i p of this ad response tracker
	 */
	@AutoEscape
	public String getUserIP();

	/**
	 * Sets the user i p of this ad response tracker.
	 *
	 * @param userIP the user i p of this ad response tracker
	 */
	public void setUserIP(String userIP);

	/**
	 * Returns the created date of this ad response tracker.
	 *
	 * @return the created date of this ad response tracker
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this ad response tracker.
	 *
	 * @param createdDate the created date of this ad response tracker
	 */
	public void setCreatedDate(Date createdDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.services.model.AdResponseTracker adResponseTracker);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.services.model.AdResponseTracker> toCacheModel();

	@Override
	public com.services.model.AdResponseTracker toEscapedModel();

	@Override
	public com.services.model.AdResponseTracker toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}