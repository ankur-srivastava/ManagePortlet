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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.services.model.AdCategory;
import com.services.service.base.AdCategoryLocalServiceBaseImpl;

/**
 * The implementation of the ad category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.services.service.AdCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ankur Srivastava
 * @see com.services.service.base.AdCategoryLocalServiceBaseImpl
 * @see com.services.service.AdCategoryLocalServiceUtil
 */
public class AdCategoryLocalServiceImpl extends AdCategoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.services.service.AdCategoryLocalServiceUtil} to access the ad category local service.
	 */
	
	public void addNewCategory(AdCategory adCategoryObj) throws SystemException, PortalException{
		// TODO Auto-generated method stub
		AdCategory adCategory = adCategoryPersistence.create(counterLocalService.increment(AdCategory.class.getName()));
		adCategory.setCategoryName(adCategoryObj.getCategoryName());
		adCategory.setCreatedDate(new Date());
		adCategory.setCategoryStatus(adCategoryObj.getCategoryStatus());
		
		adCategoryPersistence.update(adCategory);
	}
	
	public List<AdCategory> getActiveAdCategories() throws SystemException{
		return adCategoryPersistence.findByCategoryStatus(true);
	}
	
	public void deleteCategory(AdCategory category) throws SystemException{
		adCategoryPersistence.remove(category);
	}
}