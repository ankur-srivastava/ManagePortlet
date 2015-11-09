/**
 * 
 */
package com.ui.helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import com.lia.ui.helper.DateUtility;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.ContentUtil;
import com.models.AdListingCustomModel;
import com.services.model.AdCategory;
import com.services.model.AdCity;
import com.services.model.AdListing;
import com.services.model.AdResponseTracker;
import com.services.model.impl.AdListingImpl;
import com.services.model.impl.AdResponseTrackerImpl;
import com.services.service.AdCategoryLocalServiceUtil;
import com.services.service.AdCityLocalServiceUtil;
import com.services.service.AdListingLocalServiceUtil;
import com.services.service.AdResponseTrackerLocalServiceUtil;

/**
 * @author ankursrivastava
 *
 */
public class ActionUtil {
	
	static Log _log = LogFactoryUtil.getLog(ActionUtil.class);
	
	//public static long folderId = AlConstants.AL_IMAGE_FOLDERID;
	
	public static AdListing getAdListingObject(ActionRequest request, UploadPortletRequest uploadRequest){
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); 
		AdListing adListing = new AdListingImpl();
		
		if(Validator.isNotNull(ParamUtil.getString(uploadRequest, "adTitle"))){
			adListing.setAdTitle(ParamUtil.getString(uploadRequest, "adTitle"));
		}else{
			SessionErrors.add(request, "adTitle-mandatory");
		}
		if(Validator.isNotNull(ParamUtil.getString(uploadRequest, "adDescription"))){
			adListing.setAdDescription(ParamUtil.getString(uploadRequest, "adDescription"));
		}else{
			SessionErrors.add(request, "adDescription-mandatory");
		}
		if(ParamUtil.getInteger(uploadRequest, "adCityId") == 0){
			SessionErrors.add(request, "invalid-city");
		}
		if(Validator.isNotNull(ParamUtil.getInteger(uploadRequest, "adCategoryId")) && ParamUtil.getInteger(uploadRequest, "adCategoryId") != 0){
			adListing.setAdCatId(ParamUtil.getInteger(uploadRequest, "adCategoryId"));
		}else{
			SessionErrors.add(request, "adCategoryId-mandatory");
		}
		
		adListing.setAdServiceType(ParamUtil.getString(uploadRequest, "serviceType"));
		adListing.setAdCountryId(ParamUtil.getInteger(uploadRequest, "adCountryId"));
		adListing.setAdCityId(ParamUtil.getInteger(uploadRequest, "adCityId"));
		_log.debug("City Id - "+adListing.getAdCityId());
		if(themeDisplay.isSignedIn()){
			adListing.setUserId(themeDisplay.getUserId());
		}
		adListing.setAdUserName(ParamUtil.getString(uploadRequest, "userName"));
		if(Validator.isEmailAddress(ParamUtil.getString(uploadRequest, "userEmail"))){
			adListing.setAdUserEmail(ParamUtil.getString(uploadRequest, "userEmail"));
		}else{
			adListing.setAdUserEmail(themeDisplay.getUser().getEmailAddress());
		}
		//adListing.setAdUserPwd(ParamUtil.getString(request, "userPassword"));
		adListing.setAdUserPhone(ParamUtil.getString(uploadRequest, "userPhone"));
		adListing.setAdStatus(true);
		if(uploadRequest.getParameter("editAdId") != null){
			adListing.setModifiedDate(new Date());
		}else{
			adListing.setCreatedDate(new Date());
		}
		adListing.setGroupId(themeDisplay.getScopeGroupId());
		adListing.setCompanyId(themeDisplay.getCompanyId());
		
		return adListing;
	}
	
	public static boolean isImage(File f){
        return new AdFileFilter().accept(f);
	}
	
	public static AdListing copyAdObject(AdListing adListingObj, AdListing adObj){
		
		adObj.setAdCatId(adListingObj.getAdCatId());
		adObj.setAdCityId(adListingObj.getAdCityId());
		adObj.setAdCountryId(adListingObj.getAdCountryId());
		adObj.setAdDescription(adListingObj.getAdDescription());
		adObj.setAdServiceType(adListingObj.getAdServiceType());
		adObj.setAdStatus(adListingObj.getAdStatus());
		adObj.setAdTitle(adListingObj.getAdTitle());
		adObj.setAdUserEmail(adListingObj.getAdUserEmail());
		adObj.setAdUserName(adListingObj.getAdUserName());
		adObj.setAdUserPhone(adListingObj.getAdUserPhone());
		adObj.setCompanyId(adListingObj.getCompanyId());
		adObj.setCreatedDate(adListingObj.getCreatedDate());
		adObj.setGroupId(adListingObj.getGroupId());
		adObj.setUserId(adListingObj.getUserId());
		
		return adObj;
	}
	
	public static void invokeEmailApi(ActionRequest actionRequest,
			   ActionResponse actionResponse, String toEmailAddress,
			   String adTitle, String fullName, String email, String phone, String comments, String toName) throws IOException, PortalException, SystemException{
			  _log.debug("Locale "+actionRequest.getLocale()+" and string "+actionRequest.getLocale().toString());
			  String fromName = "";
			  String body = "";
			  String fromEmailAddress = LanguageUtil.get(actionRequest.getLocale(), "ad.response.email.fromEmailAddress");
			  //String subject = LanguageUtil.get(actionRequest.getLocale(), "ad.response.email.subject");
			  String subject = "Response to your ad";
			  //String articleId = AlConstants.AL_RESPONSE_EMAIL_TEMPLATE_ARTICLE_ID;
			  
			  //ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY); 
			  long companyId = PortalUtil.getCompanyId(actionRequest);

			  //ContentArticleUtil is a helper class which gets content using JournalArticleLocalServiceUtil
			  //body = JournalArticleLocalServiceUtil.getArticleContent(themeDisplay.getCompanyGroupId(),articleId, "", actionRequest.getLocale().toString(), themeDisplay);
			  body = ContentUtil.get("/templates/adresponse.tmpl", true);
			  String[] contextAttributes = {
				"[$AD_TITLE$]",adTitle,
			    "[$FULL_NAME$]", fullName,
			    "[$EMAIL$]", email,
			    "[$PHONE$]", phone,
			    "[$COMMENTS$]", comments
			    };
			  
			  body = StringUtil.replace(body, new String[]{"[$AD_TITLE$]","[$FULL_NAME$]","[$EMAIL$]",
					  "[$PHONE$]","[$COMMENTS$]"}, new String[]{adTitle, fullName, email, phone, comments});
			  
			  _log.debug("Sending email to "+toName+" with email "+toEmailAddress);
			  
			  sendEmailApproachTwo(companyId, 0, fromEmailAddress, toEmailAddress, fromName, toName, subject, body, contextAttributes);
	}
	
	public static void addAdResponseTracker(long adId, long userId, String fullName, String email, String phone, String comments, String userIP) throws SystemException{
		  AdResponseTracker adResponseTracker = new AdResponseTrackerImpl();
		  adResponseTracker.setAdId(adId);
		  adResponseTracker.setUserId(userId);
		  adResponseTracker.setComments(comments);
		  adResponseTracker.setCreatedDate(new Date());
		  adResponseTracker.setEmail(email);
		  adResponseTracker.setPhone(phone);
		  adResponseTracker.setName(fullName);
		  adResponseTracker.setUserIP(userIP);
		  
		  AdResponseTrackerLocalServiceUtil.adResponse(adResponseTracker);
	}

	
	public static void sendEmail(long companyId, long userId, String fromEmailAddress,
            String toEmailAddress, String fromName, String toName, String subject,
            String body, Object[] contextAttributes) throws IOException {
		
			ServiceContext serviceContext = new ServiceContext();
			InternetAddress to = new InternetAddress(toEmailAddress, toName);
			
			SubscriptionSender subscriptionSender = new SubscriptionSender();
			subscriptionSender.setBody(body);
			subscriptionSender.setCompanyId(companyId);
			subscriptionSender.setUserId(userId);
			subscriptionSender.setContextAttributes(contextAttributes);
			subscriptionSender.setFrom(fromEmailAddress, fromName);
			subscriptionSender.setHtmlFormat(true);
			subscriptionSender.setMailId("email_body", to);
			subscriptionSender.setServiceContext(serviceContext);
			subscriptionSender.setSubject(subject);
			subscriptionSender.addRuntimeSubscribers(toEmailAddress, toName);
			
			subscriptionSender.flushNotificationsAsync();
	}
	
	public static void sendEmailApproachTwo(long companyId, long userId, String fromEmailAddress,
            String toEmailAddress, String fromName, String toName, String subject,
            String body, Object[] contextAttributes) throws IOException {
		
			InternetAddress to = new InternetAddress(toEmailAddress, toName);
			InternetAddress from = new InternetAddress(fromEmailAddress, fromName);
			
			MailMessage mailMessage = new MailMessage();
	        mailMessage.setTo(to);
	        mailMessage.setFrom(from);
	        mailMessage.setSubject(subject);
	        mailMessage.setBody(body);
	        mailMessage.setHTMLFormat(true);
	        
	        try{
	        	MailServiceUtil.sendEmail(mailMessage);
	        }catch(Exception e){
	        	_log.debug("Error while sending response email "+e.getMessage());
	        }
	}
	
	public static String getCaptchaValueFromSession(PortletSession session) {
        Enumeration<String> atNames = session.getAttributeNames();
        while (atNames.hasMoreElements()) {
            String name = atNames.nextElement();
            if (name.contains("CAPTCHA_TEXT")) {
                return (String) session.getAttribute(name);
            }
        }
        return null;
    }
	
	public static AdListingCustomModel populateAdListingCustomModel(AdListingCustomModel customModelObj, AdListing adListObj, ThemeDisplay themeDisplay, long folderId){
		customModelObj.setAdId(adListObj.getAdId());
		customModelObj.setAdDescription(adListObj.getAdDescription());
		customModelObj.setAdTitle(adListObj.getAdTitle());
		customModelObj.setServiceType(adListObj.getAdServiceType());
		try {
			if(adListObj.getAdCityId() != 0){
				customModelObj.setAdCityName(AdCityLocalServiceUtil.getAdCity(adListObj.getAdCityId()).getCityName());
			}else{
				customModelObj.setAdCityName("");
			}
		} catch (Exception e) {
			_log.debug("Unable to get city for "+adListObj.getAdCityId());
		}
		/*Not required when displaying all ADS - 7/30/2015*/
		/*
		try {
			if(adListObj.getAdCatId() != 0){
				customModelObj.setAdCatName(AdCategoryLocalServiceUtil.getAdCategory(adListObj.getAdCatId()).getCategoryName());
			}else{
				customModelObj.setAdCatName("");
			}
			
		}catch (Exception e) {
			_log.debug("Unable to get Category for "+adListObj.getAdCatId());
		}
		*/
		/*Ends*/
		
		if(adListObj.getCreatedDate() != null){
			//customModelObj.setCreatedDate(LIAJavaUtil.getDateInMMDDYYYY(adListObj.getCreatedDate()));
			customModelObj.setCreatedDate(DateUtility.getDateInIndianFormat(adListObj.getCreatedDate()));
		}
		customModelObj.setUserName(adListObj.getAdUserName());
		customModelObj.setUserPhone(adListObj.getAdUserPhone());
		customModelObj.setUserEmail(adListObj.getAdUserEmail());
		
		customModelObj=setImageAttributes(customModelObj, adListObj, themeDisplay, folderId);
		
		return customModelObj;
	}
	
	public static AdListingCustomModel setImageAttributes(AdListingCustomModel customModelObj, AdListing adListObj, ThemeDisplay themeDisplay, long folderId){
		FileEntry file=getFile(adListObj.getAdId(), themeDisplay, folderId);
		String thumbnailImageURL = getImageFileURL(file, themeDisplay);
		String title="";
		if(thumbnailImageURL.equals("")){
			thumbnailImageURL = getNoImageURL(themeDisplay, folderId);
		}
		customModelObj.setThumbnailImageURL(thumbnailImageURL);
		if(file != null && file.getTitle() != null){
			/*Get title : like if document is abc.jpeg then get abc */
			_log.debug("Title "+file.getTitle());
			title=getDocumentTitle(file);
			customModelObj.setImageTitle(title);
		}else{
			customModelObj.setImageTitle("no preview");
		}
		return customModelObj;
	}
	
	public static String getDocumentTitle(FileEntry file){
		int dotIndex=0;
		String title="";
		title=HtmlUtil.extractText(file.getTitle());
		if(title != null && !title.equals("")){
			if(title.contains(".")){
				dotIndex=title.indexOf(".");
				if(dotIndex != 0){
					title=title.substring(0, dotIndex);
					_log.debug("New Title is "+title);
				}
			}
		}
		return title;
	}
	
	public static String getImageURL(long adId, ThemeDisplay themeDisplay, long folderId) throws PortalException, SystemException{
		DLFileEntry imageFile = null;
		String imageURL = "";
		imageFile = AdListingLocalServiceUtil.getAdFile(adId, themeDisplay.getScopeGroupId(), folderId);
		if(imageFile != null){
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, imageFile.getTitle());
			if(fileEntry != null){
				imageURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, null);
				//thumbnailImage = DLUtil.getThumbnailSrc(fileEntry, fileEntry.getFileVersion(), null, themeDisplay);
			}
		}
		return imageURL;
	}
	
	public static FileEntry getFile(long adId, ThemeDisplay themeDisplay, long folderId){
		DLFileEntry imageFile = null;
		FileEntry fileEntry = null;
		
		imageFile = AdListingLocalServiceUtil.getAdFile(adId, themeDisplay.getScopeGroupId(), folderId);
		
		if(imageFile != null){
			try{
				fileEntry = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, imageFile.getTitle());
			}catch(Exception e){
				_log.debug("Unable to get file ");
			}
		}
		return fileEntry;
	}
	
	public static String getImageFileURL(FileEntry fileEntry, ThemeDisplay themeDisplay){
		String thumbnailImage = "";
		if(fileEntry != null){
			try {
				thumbnailImage = DLUtil.getThumbnailSrc(fileEntry, fileEntry.getFileVersion(), null, themeDisplay);
			} catch (Exception e) {
				_log.debug("Unable to get thumbnail image");
			}
		}
		return thumbnailImage;
	}
	public static String getNoImageURL(ThemeDisplay themeDisplay, long folderId) {
		String thumbnailImage = "";
		try{
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, "nopreview");
			if(fileEntry != null){
				thumbnailImage = DLUtil.getThumbnailSrc(fileEntry, fileEntry.getFileVersion(), null, themeDisplay);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return thumbnailImage;
	}
	
	public static String getCategoryName(long categoryId){
		String categoryName = "";
		AdCategory category = null;
		try {
			category = AdCategoryLocalServiceUtil.getAdCategory(categoryId);
			if(category != null){
				categoryName = category.getCategoryName();
			}
		} catch (Exception e) {
			_log.debug("Error occured while getting Category for "+categoryId);
		}
		return categoryName;
	}
	
	/*Run Index*/
	public static void indexAdListing(AdListing adListingObject){
		_log.debug("Going to index this AD now "+adListingObject.getAdId());
		try {
			getIndexer().reindex(adListingObject);
			_log.debug("Indexing done for "+adListingObject.getAdId());
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			_log.debug("Following error occured while indexing "+e.getMessage());
		}
	}
	
	/*Delete Index*/
	public static void deleteAdListingIndex(AdListing adListingObject){
		_log.debug("Going to delete index for this AD now "+adListingObject.getAdId());
		try {
			getIndexer().delete(adListingObject);
			_log.debug("Done");
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			_log.debug("Following error occured while deleting index "+e.getMessage());
		}
	}
	
	public static Indexer getIndexer(){
		Indexer indexer = IndexerRegistryUtil.getIndexer(AdListing.class);
		return indexer;
	}
	
	public static long getFolderId(PortletRequest request){
		PortletSession session = request.getPortletSession();
		long folderId = 0;
		
		if(session.getAttribute("FOLDER_ID") != null){
			folderId =  (Long)session.getAttribute("FOLDER_ID");
			_log.debug("Got folderId from session "+folderId);
		}else{
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext = null;
			DLFolder folder = null;
			try {
				serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			} catch (Exception e) {
				_log.debug("Error getting ServiceContext ");
			}
			
			folder = DocumentHelperImpl.getApnaareaFolder(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), serviceContext, request);
			
			if(folder != null){
				folderId = folder.getFolderId();
			}
			_log.debug("folderId is "+folderId);
			session.setAttribute("FOLDER_ID", folderId);
		}
		return folderId;
	}
	
	public static boolean isViewAllInCurrentURL(ThemeDisplay themeDisplay){
		boolean viewAllInCurrentURL = false;
		String currentURL=themeDisplay.getURLCurrent();
		if(currentURL.contains(AlConstants.VIEW_ALL_URL)){
			viewAllInCurrentURL = true;
		}
		
		return viewAllInCurrentURL;
	}
	
	public static List<AdListing> getAdListingListFromCurrentURL(PortletRequest request, ThemeDisplay themeDisplay, List<AdCategory> categoryList, boolean viewall, List<AdCity> cityList){
		List<AdListing> adListing = null;
		String currentURL="";
		try {
			currentURL = PortalUtil.getLayoutURL(themeDisplay.getLayout(), themeDisplay);
		} catch (Exception e1) {
			
		}
		_log.debug("URL is "+currentURL);
		
		boolean categoryPageClick = false;
		boolean cityPageClick = false;
		boolean loadDefaultAdList = true;
		
		long selectedCityId = 0;
		long selectedCategoryId = 0;
		
		if(request.getAttribute("loadDefaultAdList") != null){
			loadDefaultAdList = (Boolean)request.getAttribute("loadDefaultAdList");
		}
		_log.debug("loadDefaultAdList "+loadDefaultAdList);		
		for(AdCategory category : categoryList){
			if(currentURL.contains(category.getCategoryName().toLowerCase())){
				categoryPageClick = true;
				selectedCategoryId = category.getCategoryId();
				if(request.getAttribute("adList") != null){
					adListing = (List<AdListing>)request.getAttribute("adList");
				}else if(loadDefaultAdList){
					try {
						adListing = AdListingLocalServiceUtil.getByCategory(category.getCategoryId());
					} catch (SystemException e) {
						_log.debug("Error while getting adListing based on category");
					}
				}
				break;
			}
		}
		if(!categoryPageClick && (adListing == null || adListing.size() == 0)){
			//Check for city in URL
			
			for(AdCity city : cityList){
				if(currentURL.contains(city.getCityName().toLowerCase())){
					cityPageClick = true;
					selectedCityId = city.getCityId();
					if(request.getAttribute("adList") != null){
						adListing = (List<AdListing>)request.getAttribute("adList");
					}else if(loadDefaultAdList){
						try {
							adListing = AdListingLocalServiceUtil.getByCity(city.getCityId());
						} catch (SystemException e) {
							_log.debug("Error while getting adListing based on city");
						}
					}
					break;
				}
			}
			
			if(!cityPageClick && (adListing == null || adListing.size() == 0)){
				try {
					adListing = AdListingLocalServiceUtil.getAdListings(0, 10);
					viewall=true;
				} catch (SystemException e) {
					_log.debug("Unable to fetch any ADS");
				}
			}
		}
		request.setAttribute("viewall", viewall);
		request.setAttribute("cityPageClick", cityPageClick);
		request.setAttribute("selectedCityId", selectedCityId);
		request.setAttribute("selectedCategoryId", selectedCategoryId);
		request.setAttribute("categoryPageClick", categoryPageClick);
		
		return adListing;
	}
	
	public static List<AdListing> getAllAds(){
		List<AdListing> adList = null;
		try {
			//adList = AdListingLocalServiceUtil.getAdListings(0, AdListingLocalServiceUtil.getAdListingsCount());
			//adList = AdListingLocalServiceUtil.getAllAds();
			adList = AdListingLocalServiceUtil.getAds(AlConstants.NUMBER__OF_ADS_TO_BE_FETCHED);
			if(adList != null){
				_log.debug("AdList count is "+adList.size());
			}
		} catch (SystemException e) {
			_log.debug("Unable to fetch any ADS");
		}
		return adList;
	}
	
	public static List<AdListing> getAds(int count){
		List<AdListing> adList = null;
		try {
			//adList = AdListingLocalServiceUtil.getAdListings(0, AdListingLocalServiceUtil.getAdListingsCount());
			adList = AdListingLocalServiceUtil.getAds(AlConstants.NUMBER__OF_ADS_TO_BE_FETCHED);
			if(adList != null){
				_log.debug("AdList count is "+adList.size());
			}
		} catch (SystemException e) {
			_log.debug("Unable to fetch any ADS");
		}
		return adList;
	}
	
	public static List<AdListingCustomModel> getLimitedAdsByCategory(long categoryId, ThemeDisplay themeDisplay, PortletRequest request){
		List<AdListing> adList = null;
		List<AdListingCustomModel> customAdList = null;
		try {
			adList = AdListingLocalServiceUtil.getLimitedAdsByCategory(categoryId);
		} catch (Exception e) {
			
		}
		
		/*Populate customAdList*/
		if(adList != null){
			customAdList = new ArrayList<AdListingCustomModel>();
			for(AdListing adListObj : adList){
				AdListingCustomModel customModelObj = new AdListingCustomModel();
				customModelObj = ActionUtil.populateAdListingCustomModel(customModelObj, adListObj, themeDisplay, ActionUtil.getFolderId(request));
				customAdList.add(customModelObj);
			}
		}
		/*Ends*/
		return customAdList;
	}
	
	public static void sendAdMessage(ServiceContext  context, AdListing adListing){
		Message message = new Message();
		message.put("adListing", adListing);
		MessageBusUtil.sendMessage("post/data", message);
	}
}