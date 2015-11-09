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

package com.services.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.services.model.AdCity;
import com.services.service.base.AdCityLocalServiceBaseImpl;

/**
 * The implementation of the ad city local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.services.service.AdCityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ankur Srivastava
 * @see com.services.service.base.AdCityLocalServiceBaseImpl
 * @see com.services.service.AdCityLocalServiceUtil
 */
public class AdCityLocalServiceImpl extends AdCityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.services.service.AdCityLocalServiceUtil} to access the ad city local service.
	 */
	
	public AdCity addNewCity(AdCity cityObj) throws SystemException{
		
		AdCity city = adCityPersistence.create(counterLocalService.increment(AdCity.class.getName()));
		city.setCityName(cityObj.getCityName());
		city.setCityStatus(cityObj.getCityStatus());
		city.setCreatedDate(cityObj.getCreatedDate());
		
		return adCityPersistence.update(city);
	}
	
	public AdCity updateCity(AdCity city) throws SystemException{
		return adCityPersistence.update(city);
	}
	
	public List<AdCity> getActiveAdCityList(){
		List<AdCity> adCityList=null;
		try {
			adCityList = adCityPersistence.findAll();
		} catch (SystemException e) { }
		return adCityList;
	}
	
	public List<AdCity> getPopularCityList(){
		List<AdCity> adCityList=null;
		try {
			adCityList = adCityPersistence.findBypopular(true);
		} catch (SystemException e) { }
		return adCityList;
	}
	
	public List<AdCity> getAdCityByName(String cityName) throws SystemException{
		return adCityPersistence.findByCityName(cityName);
	}
	
	public void deleteCity(AdCity city) throws SystemException{
		adCityPersistence.remove(city);
	}
}