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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.services.model.AdListing;
import com.services.model.AdResponseTracker;
import com.services.model.AdStatsTracker;
import com.services.model.impl.AdStatsTrackerImpl;
import com.services.service.AdResponseTrackerLocalServiceUtil;
import com.services.service.AdStatsTrackerLocalServiceUtil;
import com.services.service.base.AdListingLocalServiceBaseImpl;
import com.ui.helper.ActionUtil;
import com.ui.helper.AlConstants;

/**
 * The implementation of the ad listing local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.services.service.AdListingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ankur Srivastava
 * @see com.services.service.base.AdListingLocalServiceBaseImpl
 * @see com.services.service.AdListingLocalServiceUtil
 */
public class AdListingLocalServiceImpl extends AdListingLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.services.service.AdListingLocalServiceUtil} to access the ad listing local service.
	 */
	static Log _log = LogFactoryUtil.getLog(AdListingLocalServiceImpl.class);
	
	public AdListing postAd(AdListing adListingObj, long userId, List<ObjectValuePair<String, InputStream>> inputStreamOVPs, long folderId, ServiceContext serviceContext) {
		long startTime = System.currentTimeMillis();
		AdListing newAdObj = null;
		AdListing tempAdObj = null;
		
		try {
			tempAdObj = adListingPersistence.create(counterLocalService.increment(AdListing.class.getName()));
		} catch (SystemException e) {
			_log.debug("Error occured while Posting the AD "+e.getMessage());
		}
		
		//adObjTemp = ActionUtil.copyAdObject(adListingObj, adObjTemp);
		
		if(tempAdObj != null){
			adListingObj.setPrimaryKey(tempAdObj.getPrimaryKey());
			try {
				newAdObj=adListingPersistence.update(adListingObj);
				_log.debug("Ad listing updated for "+newAdObj.getAdId());
			}catch(Exception e){
				_log.debug("Error occured while adding the AD");
			}
		}
		
		//Move all the code below to use Liferay message bus in async fashion
		
		if(newAdObj != null){
			//Use Message Bus to handle all other actions
			//ActionUtil.sendAdMessage(serviceContext, newAdObj);
			
			/*
			try{
				resourceLocalService.addResources(newAdObj.getCompanyId(), newAdObj.getGroupId(), userId, AdListing.class.getName(), newAdObj.getPrimaryKey(), false, true, true);
			}catch(Exception e){
				_log.debug("Error occured while adding the Permissions");
			}
			*/
			/*Add Image*/
			if(inputStreamOVPs != null && inputStreamOVPs.size() > 0){
				try{
				PortletFileRepositoryUtil.addPortletFileEntries(
						newAdObj.getGroupId(), newAdObj.getUserId(), AdListing.class.getName(),
						newAdObj.getAdId(), "AdListing",
						folderId, inputStreamOVPs);
				}catch(Exception e){
					_log.debug("Error occured while adding the File");
				}
			}
			
			/*Add tracker*/
			
			AdStatsTracker adStatsTracker = new AdStatsTrackerImpl();
			adStatsTracker.setAdId(newAdObj.getPrimaryKey());
			adStatsTracker.setAdCount(0);
			adStatsTracker.setCreatedDate(new Date());
			
			try{
				AdStatsTrackerLocalServiceUtil.updateAdStatsTracker(adStatsTracker);
			}catch(Exception e){
				_log.debug("Error occured while adding the AdStatsTracker");
			}
			
			/*Take care of Assets - Categories and Tags*/
			try{
			_log.debug("Now going to update assets for "+newAdObj.getAdId());
			String summary = HtmlUtil.extractText(StringUtil.shorten(newAdObj.getAdTitle(), 500));
			AssetEntry assetEntry = assetEntryLocalService.updateEntry(
					newAdObj.getUserId(), newAdObj.getGroupId(), newAdObj.getCreatedDate(),
					newAdObj.getCreatedDate(), AdListing.class.getName(),
					newAdObj.getPrimaryKey(), serviceContext.getUuid(), 0, serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames(), true, null, null, null, ContentTypes.TEXT_HTML,
					newAdObj.getAdTitle(), summary, summary, null, null, 0, 0,
					null, false);
			_log.debug("Added asset "+assetEntry.getPrimaryKey()+" for "+newAdObj.getAdId());
			}catch(Exception e){
				_log.debug("Error occured while adding the Asset");
			}
			/*Ends*/
			/*Search Index*/
			try{
				_log.debug("Going to index");
				ActionUtil.indexAdListing(newAdObj);
			}catch(Exception e){
				_log.debug("Error occured while re-indexing");
			}
			/*Ends*/
		}
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime-startTime;
	    
	    _log.debug("Posting the AD took - "+elapsedTime+"ms");
	    
		return newAdObj;
	}
	
	public AdListing updateAd(AdListing adListingObj, List<ObjectValuePair<String, InputStream>> inputStreamOVPs, long folderId,ServiceContext serviceContext){
		AdListing adListingObject=null; 
		_log.debug("Going to update the listing");
		try {
			adListingObject=adListingPersistence.update(adListingObj);
			if(inputStreamOVPs != null && inputStreamOVPs.size() > 0){
				DLFileEntryLocalServiceUtil.deleteDLFileEntry(getAdFile(adListingObj.getAdId(), adListingObj.getGroupId(), folderId));
				_log.debug("AD file deleted "+adListingObj.getAdId());
				PortletFileRepositoryUtil.addPortletFileEntries(
						adListingObj.getGroupId(), adListingObj.getUserId(), AdListing.class.getName(),
						adListingObj.getAdId(), "AdListing",
						folderId, inputStreamOVPs);
			}
			/*Take care of Assets - Categories and Tags*/
			assetEntryLocalService.updateEntry(adListingObj.getUserId(), adListingObj.getGroupId(), AdListing.class.getName(), adListingObj.getPrimaryKey(), serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames());
			String summary = HtmlUtil.extractText(
					StringUtil.shorten(adListingObj.getAdTitle(), 500));
			AssetEntry assetEntry = assetEntryLocalService.updateEntry(
					adListingObj.getUserId(), adListingObj.getGroupId(), adListingObj.getCreatedDate(),
					adListingObj.getCreatedDate(), BlogsEntry.class.getName(),
					adListingObj.getPrimaryKey(), serviceContext.getUuid(), 0, serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames(), true, null, null, null, ContentTypes.TEXT_HTML,
					adListingObj.getAdTitle(), adListingObj.getAdDescription(), summary, null, null, 0, 0,
					null, false);
			_log.debug("Asset updated "+assetEntry.getPrimaryKey());
			/*Ends*/
			/*Search Index*/
			ActionUtil.indexAdListing(adListingObj);
			/*Ends*/
		} catch (SystemException e) {
			_log.debug("Problem while updating the AD ");
		} catch (PortalException e) {
			_log.debug("Problem while updating the AD ");
		}
		return adListingObject;
	}
	
	public void deleteAd(AdListing ad, long folderId) throws PortalException, SystemException{
		_log.debug("Delete "+ad.getAdId());
		try{
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(getAdFile(ad.getAdId(), ad.getGroupId(), folderId));
		}catch(Exception e){
			_log.debug("File not found for AD "+ad.getAdTitle());
		}
		AdStatsTracker trackerObj = AdStatsTrackerLocalServiceUtil.fetchAdStatsTracker(ad.getAdId());
		AdResponseTracker adResponseTrackerObj = AdResponseTrackerLocalServiceUtil.fetchAdResponseTracker(ad.getAdId());
		if(trackerObj != null){
			AdStatsTrackerLocalServiceUtil.deleteAdStatsTracker(trackerObj);
		}
		if(adResponseTrackerObj != null){
			AdResponseTrackerLocalServiceUtil.deleteAdResponseTracker(adResponseTrackerObj);
		}
		/*
		resourceLocalService.deleteResource(
				ad.getCompanyId(), AdListing.class.getName(),
	            ResourceConstants.SCOPE_INDIVIDUAL, ad.getPrimaryKey());
		*/
		try{
			assetEntryLocalService.deleteEntry(
		            AdListing.class.getName(), ad.getPrimaryKey());
		}catch(Exception e){
			_log.debug("Error while removing asset for "+ad.getPrimaryKey());
		}
		adListingPersistence.remove(ad);
		_log.debug("Deleted");
		/*Delete Index*/
		ActionUtil.deleteAdListingIndex(ad);
		/*Done*/
	}
	
	public List<AdListing> getByC_C_S(long category, long city, String serviceType) throws SystemException{
		return adListingPersistence.findByCat_City_Service(category, city, serviceType);
	}
	
	public List<AdListing> getAllAds() throws SystemException{
		return adListingPersistence.findAll();
	}
	
	public List<AdListing> getAds(int count) throws SystemException{
		return adListingPersistence.findAll(0, count);
	}
	
	public List<AdListing> getByC_C(long category, long city) throws SystemException{
		return adListingPersistence.findByCat_City(category, city);
	}
	public List<AdListing> getByUserId(long userId, long companyId, long groupId) throws SystemException{
		return adListingPersistence.findByUGC(userId, groupId, companyId);
	}
	public List<AdListing> getByCategory(long categoryId) throws SystemException{
		return adListingPersistence.findByCatId(categoryId);
	}
	public List<AdListing> getByCity(long cityId) throws SystemException{
		return adListingPersistence.findByCityId(cityId);
	}
	public DLFileEntry getAdFile(long adId, long groupId, long folderId){
		List<DLFileEntry> dlFiles = null;
		try {
			dlFiles = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folderId);
		} catch (SystemException e) {
			_log.debug("Error finding dlFiles");
		}
		if(dlFiles != null && dlFiles.size() > 0){
			for(DLFileEntry file : dlFiles){
				if(file.getClassPK() == adId){
					return file;
				}
			}
		}
		return null;
	}
	
	public List<DLFileEntry> getUploadedFiles(long groupId, long folderId) throws SystemException{
		List<DLFileEntry> dlFiles = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folderId);
		dlFiles = getDLFilesForAdListing(dlFiles);
		return dlFiles;
	}
	
	public List<DLFileEntry> getDLFilesForAdListing(List<DLFileEntry> dlFiles){
		List<DLFileEntry> newDlFiles = null;
		long classNamePKValue = ClassNameLocalServiceUtil.getClassNameId(AdListing.class);
		if(dlFiles != null && dlFiles.size() > 0){
			newDlFiles = new ArrayList<DLFileEntry>();
			for(DLFileEntry file : dlFiles){
				if(file.getClassNameId() == classNamePKValue){
					newDlFiles.add(file);
				}
			}
		}
		return newDlFiles;
	}
	
	public List<AdListing> getLimitedAdsByCategory(long categoryId){
		List<AdListing> adList = null;
		try {
			adList = adListingPersistence.findByCatId(categoryId, 0, AlConstants.ADS_LIMIT);
		} catch (SystemException e) {
			
		}
		return adList;
	}
}