/**
 * 
 */
package com.ui.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.lia.ui.helper.LIAUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.models.AdListingCustomModel;
import com.services.model.AdCategory;
import com.services.model.AdCity;
import com.services.model.AdCountry;
import com.services.model.AdListing;
import com.services.model.AdStatsTracker;
import com.services.model.impl.AdCategoryImpl;
import com.services.model.impl.AdCityImpl;
import com.services.model.impl.AdCountryImpl;
import com.services.service.AdCategoryLocalServiceUtil;
import com.services.service.AdCityLocalServiceUtil;
import com.services.service.AdCountryLocalServiceUtil;
import com.services.service.AdListingLocalServiceUtil;
import com.services.service.AdStatsTrackerLocalServiceUtil;
import com.ui.helper.ActionUtil;
import com.ui.helper.AdCategoryHelper;

/**
 * @author ankursrivastava
 *
 */
public class MainController extends MVCPortlet{
	
	String VIEW_JSP;
	String POST_JSP;
	String ADD_CATEGORY_JSP;
	String ADD_CITY_JSP;
	String ADD_COUNTRY_JSP;
	String LISTING_DETAIL_JSP;
	String EDIT_AD_JSP;
	String SEARCH_AD_JSP;
	String MAKE_CITY_POPULAR_JSP;
	
	//long folderId = AlConstants.AL_IMAGE_FOLDERID;
	
	public static Log _log = LogFactoryUtil.getLog(AdListing.class);
	
	List<AdCategory> categoryList = null;
	List<AdCity> cityList = null;
	List<AdCity> popularCityList = null;
	List<AdCountry> countryList = null;
	
	public void init(){
		VIEW_JSP = getInitParameter("view-jsp");
		POST_JSP = getInitParameter("post-jsp");
		ADD_CATEGORY_JSP = getInitParameter("addCategory-jsp");
		ADD_CITY_JSP = getInitParameter("addCity-jsp");
		ADD_COUNTRY_JSP = getInitParameter("addCountry-jsp");
		LISTING_DETAIL_JSP = getInitParameter("listingDetail-jsp");
		EDIT_AD_JSP = getInitParameter("editAd-jsp");
		SEARCH_AD_JSP = getInitParameter("searchAd-jsp");
		MAKE_CITY_POPULAR_JSP = getInitParameter("makeCityPopular-jsp");
		
		/*Get the list of categories and cities*/
		try {
			categoryList = AdCategoryLocalServiceUtil.getActiveAdCategories();
		} catch (SystemException e) {
			
		}
		try {
			cityList = AdCityLocalServiceUtil.getActiveAdCityList();
		} catch (Exception e) {
			
		}
		try {
			countryList = AdCountryLocalServiceUtil.getActiveAdCountryList();
		} catch (SystemException e) {
			
		}
		try {
			popularCityList = AdCityLocalServiceUtil.getPopularCityList();
			if(popularCityList != null && popularCityList.size() > 0){
				_log.debug("popularCityList "+popularCityList.size());
			}
		} catch (Exception e) {
			
		}
	}
	
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException{
		String jspPath = VIEW_JSP;
		String imageURL = "";
		
		List<AdListing> adList = null;
		List<AdListingCustomModel> customAdList = null;
		
		boolean viewall = false;
		boolean showLimitedAds = false;
		
		int userAdsListSize = 0;
		long adId = 0;
		long folderId = ActionUtil.getFolderId(request);
		
		boolean loadDefaultAdList = true;
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		if(themeDisplay != null && themeDisplay.isSignedIn()){
			User user = themeDisplay.getUser();
			request.setAttribute("user", user);
		}
		
		if(request.getParameter("adDetailId") != null){
			AdListingCustomModel adDetailCustomObj = new AdListingCustomModel();
			adId = ParamUtil.getLong(request, "adDetailId");
			AdListing adListingObj = null;
			AdStatsTracker adStatsTracker = null;
			long totalViews = 0;
			if(adId != 0){
				try {
					adListingObj = AdListingLocalServiceUtil.getAdListing(adId);
				} catch (Exception e) { 
					_log.debug("Error while getting adListingObj");
				}
				try {
					adStatsTracker = AdStatsTrackerLocalServiceUtil.fetchAdStatsTracker(adId);
				} catch (Exception e) { 
					_log.debug("Error while getting adListingObj");
				}
				
				if(adStatsTracker != null){
					totalViews = adStatsTracker.getAdCount(); 
					try {
						imageURL = ActionUtil.getImageURL(adId, themeDisplay, folderId);
					} catch (Exception e) {
						_log.debug("Error while getting imageURL");
					} 
				}
				if(adListingObj != null){
					adDetailCustomObj = ActionUtil.populateAdListingCustomModel(adDetailCustomObj, adListingObj, themeDisplay, folderId);	
				}
			}
			
			request.setAttribute("adListingObj", adDetailCustomObj);
			request.setAttribute("totalViews", (totalViews+1));
			request.setAttribute("imageURL", imageURL);
		}
		if(request.getParameter("pageAction") != null){
			jspPath = getJSPPath(ParamUtil.getString(request, "pageAction"));
		}
		if(request.getParameter("postAdAction") != null && request.getParameter("postAdAction").equals("yes")){
			if(!themeDisplay.isSignedIn()){
				request.setAttribute("signInNeeded", "yes");
				LIAUtil.redirect(jspPath, getPortletContext(), request, response);
			}
			if(themeDisplay.getUser() == null || themeDisplay.getUser().getUserId() == 0){
				request.setAttribute("signInNeeded", "yes");
				LIAUtil.redirect(jspPath, getPortletContext(), request, response);
			}
		}
		if(request.getParameter("showCreateNewAccount") != null){
			request.setAttribute("showCreateNewAccount", request.getParameter("showCreateNewAccount"));
		}
		
		/*Get AD's list*/
		if(request.getAttribute("loadDefaultAdList") != null){
			loadDefaultAdList = (Boolean)request.getAttribute("loadDefaultAdList");
		}
		_log.debug("loadDefaultAdList "+loadDefaultAdList);
		if(request.getAttribute("adList") != null && loadDefaultAdList){
			adList = (List<AdListing>)request.getAttribute("adList");
		}else if(ActionUtil.isViewAllInCurrentURL(themeDisplay)){
			adList = ActionUtil.getAllAds();
			_log.debug("Got all ADs list");
		}else{
			adList = ActionUtil.getAdListingListFromCurrentURL(request, themeDisplay, categoryList, viewall, cityList);
		}
		/*Ends*/
		/*Populate customAdList*/
		if(adList != null){
			_log.debug("Got AD list "+adList.size());
			customAdList = new ArrayList<AdListingCustomModel>();
			for(AdListing adListObj : adList){
				AdListingCustomModel customModelObj = new AdListingCustomModel();
				customModelObj = ActionUtil.populateAdListingCustomModel(customModelObj, adListObj, themeDisplay, folderId);
				customAdList.add(customModelObj);
			}
		}
		/*Ends*/
		/*Get user ads list size*/
		if(request.getAttribute("userAdsListSize") != null){
			userAdsListSize = (Integer)request.getAttribute("userAdsListSize");
		}else{
			try {
				userAdsListSize = getUserAdsListSize(request);
			} catch (SystemException e) {
				_log.debug("Unable to get userAdsListSize");
			} 
		}
		
		if(jspPath.equals(VIEW_JSP)){
			showLimitedAds = true;
		}
		
		//request.setAttribute("adList", adList);
		request.setAttribute("adList", customAdList);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("cityList", cityList);
		request.setAttribute("popularCityList", popularCityList);
		request.setAttribute("countryList", countryList);
		request.setAttribute("userAdsListSize", userAdsListSize);
		request.setAttribute("showLimitedAds", showLimitedAds);
		
		/*Ends*/
		LIAUtil.redirect(jspPath, getPortletContext(), request, response);
	}
	
	public void addAD(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay.getUser() == null || themeDisplay.getUser().getUserId() == 0){
			SessionErrors.add(request, "invalid-user");
		}
		long adId = 0;
		long folderId = ActionUtil.getFolderId(request);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		AdListing adListing = ActionUtil.getAdListingObject(request, uploadRequest);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(AdListing.class.getName(), uploadRequest);
		if(uploadRequest.getParameter("editAdId") != null){
			adId = ParamUtil.getLong(uploadRequest, "editAdId");
			AdListing tempObj = AdListingLocalServiceUtil.getAdListing(adId);
			adListing.setCreatedDate(tempObj.getCreatedDate());
		}
		adListing.setAdId(adId);
		/*For Image*/
		File imageFile = uploadRequest.getFile("documentFile");
		List<ObjectValuePair<String, InputStream>> inputStreamOVPs = null;
		if(uploadRequest.getSize("documentFile") != 0){
			if(!ActionUtil.isImage(imageFile)){
				SessionErrors.add(request, "file-invalid");
			}else{
				String fileName=uploadRequest.getFileName("documentFile");
				//String fileName = imageFile.getName();
				InputStream inputStream = uploadRequest.getFileAsStream("documentFile");
				inputStreamOVPs = new ArrayList<ObjectValuePair<String, InputStream>>(1);
				ObjectValuePair<String, InputStream> inputStreamOVP = new ObjectValuePair<String, InputStream>(fileName, inputStream);
				inputStreamOVPs.add(inputStreamOVP);
			}
		}
		/*Ends*/
		if(SessionErrors.isEmpty(request)){
			AdListing updatedAdListingObject = null;
			try {
				if(adId != 0){
					updatedAdListingObject=AdListingLocalServiceUtil.updateAd(adListing, inputStreamOVPs, folderId, serviceContext);
					if(updatedAdListingObject != null){
						SessionMessages.add(request, "ad-edited");
					}else{
						SessionErrors.add(request, "some-problem");
					}
				}else{
					updatedAdListingObject=AdListingLocalServiceUtil.postAd(adListing, themeDisplay.getUserId(), inputStreamOVPs, folderId, serviceContext);
					if(updatedAdListingObject != null){
						SessionMessages.add(request, "ad-posted");
						request.setAttribute("adList", ActionUtil.getAllAds());
					}else{
						SessionErrors.add(request, "some-problem");
					}
				}
			} catch (Exception e) {
				SessionErrors.add(request, "some-problem");
			}
		}else{
			request.setAttribute("adListingObj", adListing);
			if(request.getParameter("editAdId") != null){
				response.setRenderParameter("pageAction", EDIT_AD_JSP);
			}else{
				response.setRenderParameter("pageAction", POST_JSP);
			}
		}
	}
	
	public void addCategory(ActionRequest request, ActionResponse response){
		String categoryName=ParamUtil.getString(request, "categoryName");
		if(Validator.isNotNull(categoryName)){
			AdCategory categoryObj = new AdCategoryImpl();
			categoryObj.setCategoryName(categoryName);
			categoryObj.setCategoryStatus(true);
			try {
				AdCategoryLocalServiceUtil.addNewCategory(categoryObj);
				SessionMessages.add(request, "category-added");
			} catch (Exception e) {
				
			} 
		}else{
			SessionErrors.add(request, "category-name-mandatory");
			response.setRenderParameter("pageAction", ADD_CATEGORY_JSP);
		}
	}
	
	public void addCity(ActionRequest request, ActionResponse response){
		ThemeDisplay themeDisplay=(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY); 
		String cityName=ParamUtil.getString(request, "cityName");
		if(Validator.isNotNull(cityName)){
			AdCity cityObj = new AdCityImpl();
			cityObj.setCityName(cityName);
			cityObj.setCityStatus(true);
			try {
				AdCityLocalServiceUtil.addNewCity(cityObj);
				SessionMessages.add(request, "city-added");
			} catch (SystemException e) {
				_log.error("Following city could not be added "+cityName);
				if(themeDisplay != null && themeDisplay.getUser() != null){
					_log.debug("Following user tried to add this city "+themeDisplay.getUser().getUserId());
				}else{
					_log.debug("An invalid user tried to add this city ");
				}
			}
		}else{
			SessionErrors.add(request, "city-name-mandatory");
			response.setRenderParameter("pageAction", ADD_CITY_JSP);
		}
	}
	
	public void addCountry(ActionRequest request, ActionResponse response){
		ThemeDisplay themeDisplay=(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY); 
		String countryName=ParamUtil.getString(request, "countryName");
		if(Validator.isNotNull(countryName)){
			AdCountry countryObj = new AdCountryImpl();
			countryObj.setCountryName(countryName);
			countryObj.setCountryStatus(true);
			try {
				AdCountryLocalServiceUtil.addNewCountry(countryObj);
				SessionMessages.add(request, "country-added");
			} catch (SystemException e) {
				_log.error("Following country could not be added "+countryName);
				if(themeDisplay != null && themeDisplay.getUser() != null){
					_log.debug("Following user tried to add this country "+themeDisplay.getUser().getUserId());
				}else{
					_log.debug("An invalid user tried to add this country ");
				}
			}
		}else{
			SessionErrors.add(request, "country-name-mandatory");
			response.setRenderParameter("pageAction", ADD_COUNTRY_JSP);
		}
	}
	
	public void editAd(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		long adId = ParamUtil.getLong(request, "resourcePrimKey");
		if(Validator.isNotNull(adId)){
			AdListing adListingObj = AdListingLocalServiceUtil.getAdListing(adId);
			request.setAttribute("adListingObj", adListingObj);
			response.setRenderParameter("pageAction", EDIT_AD_JSP);
		}
	}
	
	public void deleteAd(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		long adId = ParamUtil.getLong(request, "resourcePrimKey");
		long folderId = ActionUtil.getFolderId(request);
		if(Validator.isNotNull(adId)){
			AdListing adListingObj = AdListingLocalServiceUtil.getAdListing(adId);
			AdListingLocalServiceUtil.deleteAd(adListingObj, folderId);
		}
	}
	
	public void filterResults(ActionRequest request, ActionResponse response) throws SystemException{
		long catId = ParamUtil.getLong(request, "adCategoryId");
		long cityId = ParamUtil.getLong(request, "adCityId");
		String serviceType = ParamUtil.getString(request, "serviceType");
		List<AdListing> adList = null;
		if(serviceType.equals("")){
			adList = AdListingLocalServiceUtil.getByC_C(catId, cityId);
		}else{
			adList = AdListingLocalServiceUtil.getByC_C_S(catId, cityId, serviceType);
		}
		request.setAttribute("adList", adList);
		request.setAttribute("catIdFromFilter", catId);
		request.setAttribute("cityIdFromFilter", cityId);
	}
	
	public void manageMyAds(ActionRequest request, ActionResponse response) throws SystemException{
		int userAdsListSize = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		List<AdListing> adList = null;
		adList = AdListingLocalServiceUtil.getByUserId(themeDisplay.getUserId(), themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		if(adList != null){
			userAdsListSize = adList.size();
		}
		request.setAttribute("adList", adList);
		request.setAttribute("userAdsListSize", userAdsListSize);
	}
	
	public void contactUser(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		/*Send email to the user*/
		String userName = ParamUtil.getString(request, "userName");
		String userEmail = ParamUtil.getString(request, "userEmail");
		String userPhone = ParamUtil.getString(request, "userPhone");
		String comments = ParamUtil.getString(request, "comments");
		String userIP = "";
		/*
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
		userIP = httpRequest.getHeader("X-FORWARDED-FOR");  
		if (userIP == null) {  
			userIP = httpRequest.getRemoteAddr();  
		}
		*/
		long adDetailId = ParamUtil.getLong(request, "adDetailId");
		_log.debug("Contact for ad "+adDetailId);
		String enteredCaptchaText = ParamUtil.getString(request, "captchaText");

        PortletSession session = request.getPortletSession();
        String captchaText = ActionUtil.getCaptchaValueFromSession(session);
		
        if (Validator.isNull(captchaText)) {
            SessionErrors.add(request, "captcha-mandatory");
        }
        if (!captchaText.equals(enteredCaptchaText)) {
        	SessionErrors.add(request, "invalid-captha");
        }
		if(Validator.isNull(userName)){
			SessionErrors.add(request, "user-name-required");
		}
		if(Validator.isNull(userEmail) && Validator.isNull(userPhone)){
			SessionErrors.add(request, "user-email-or-phone-required");
		}
		if(!Validator.isEmailAddress(userEmail)){
			SessionErrors.add(request, "user-email-invalid");
		}
		
		if(SessionErrors.isEmpty(request)){
			AdListing adListingObj = AdListingLocalServiceUtil.getAdListing(adDetailId);
			try {
				ActionUtil.invokeEmailApi(request, response, adListingObj.getAdUserEmail(), adListingObj.getAdTitle(), userName, userEmail, userPhone, comments, adListingObj.getAdUserName());
				_log.debug("Email sent");
				ActionUtil.addAdResponseTracker(adListingObj.getAdId(), adListingObj.getUserId(), userName, userEmail, userPhone, comments, userIP);
			} catch (Exception e) {
				_log.debug("Unable to addAdResponseTracker");
			}
			SessionMessages.add(request, "response-sent-successfully");
		}
		response.setRenderParameter("adDetailId", String.valueOf(adDetailId));
		response.setRenderParameter("pageAction", LISTING_DETAIL_JSP);
	}
	
	@Override
    public void serveResource(ResourceRequest resourceRequest,
                             ResourceResponse resourceResponse) throws IOException, PortletException {
		try {
            com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(resourceRequest, resourceResponse);
        } catch (Exception e) {
            _log.error(e);
        }
    }
	
	@ProcessEvent(qname="{http://liferay.com/events}category")
	public void categoryEvent(EventRequest request, EventResponse response){
		Event event = request.getEvent();
		long categoryId = (Long) event.getValue();
		if(categoryId != 0){
			request.setAttribute("catIdFromFilter", categoryId);
			List<AdListing> adList = null;
			try {
				adList = AdListingLocalServiceUtil.getByCategory(categoryId);
			} catch (SystemException e) {
				_log.debug("Unable to get list based on cat id");
			}
			if(adList != null){
				request.setAttribute("adList", adList);
			}
		}
	}
	
	@ProcessEvent(qname="{http://liferay.com/events}filterResults")
	public void filterEvent(EventRequest request, EventResponse response){
		Event event = request.getEvent();
		AdCategoryHelper adCategoryHelper = (AdCategoryHelper)event.getValue();
		
		try {
			filterResultsByC_C_S(adCategoryHelper.getCatId(), adCategoryHelper.getCityId(), adCategoryHelper.getServiceType(), request);
		} catch (SystemException e) {
			_log.debug("Error during filter ");
		}
	}
	
	public void searchAds(ActionRequest request, ActionResponse response){
		//response.setRenderParameter("keywords", ParamUtil.getString(request, "keywords"));
		String keywords="";
		if(request.getParameter("keywords") != null){
			keywords=request.getParameter("keywords");
		}
		response.setRenderParameter("keywords", keywords);
		response.setRenderParameter("pageAction", SEARCH_AD_JSP);
	}
	
	private String getJSPPath(String jspPath){
		if(jspPath.equals("POST_JSP")){
			jspPath = POST_JSP;
		}else if(jspPath.equals("ADD_CATEGORY_JSP")){
			jspPath = ADD_CATEGORY_JSP;
		}else if(jspPath.equals("ADD_CITY_JSP")){
			jspPath = ADD_CITY_JSP;
		}else if(jspPath.equals("ADD_COUNTRY_JSP")){
			jspPath = ADD_COUNTRY_JSP;
		}else if(jspPath.equals("LISTING_DETAIL_JSP")){
			jspPath = LISTING_DETAIL_JSP;
		}else if(jspPath.equals("EDIT_AD_JSP")){
			jspPath = EDIT_AD_JSP;
		}else if(jspPath.equals("SEARCH_AD_JSP")){
			jspPath = SEARCH_AD_JSP;
		}else if(jspPath.equals("MAKE_CITY_POPULAR_JSP")){
			jspPath = MAKE_CITY_POPULAR_JSP;
		}
		return jspPath;
	}
	
	private int getUserAdsListSize(RenderRequest request) throws SystemException{
		int userAdSize = 0;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		List<AdListing> userAdList = null;
		userAdList = AdListingLocalServiceUtil.getByUserId(themeDisplay.getUserId(), themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		if(userAdList != null){
			userAdSize = userAdList.size();
		}
		return userAdSize;
	}
	
	private void filterResultsByC_C_S(long catId, long cityId, String serviceType, PortletRequest request) throws SystemException{
		List<AdListing> adList = null;
		if(catId == 0){
			adList = AdListingLocalServiceUtil.getByCity(cityId);
		}else if(cityId == 0){
			adList = AdListingLocalServiceUtil.getByCategory(catId);
		}else{
			adList = AdListingLocalServiceUtil.getByC_C_S(catId, cityId, serviceType);
		}
		/*
		if(serviceType.equals("")){
			adList = AdListingLocalServiceUtil.getByC_C(catId, cityId);
		}else{
			adList = AdListingLocalServiceUtil.getByC_C_S(catId, cityId, serviceType);
		}
		*/
		request.setAttribute("adList", adList);
		request.setAttribute("catIdFromFilter", catId);
		request.setAttribute("cityIdFromFilter", cityId);
	}
	
	public void refineResultsByCategory(ActionRequest request, ActionResponse response){
		long catId = ParamUtil.getLong(request, "adCategoryId");
		long cityId = ParamUtil.getLong(request, "selectedCityId");
		boolean loadDefaultAdList = false;
		if(catId == 0){
			SessionErrors.add(request, "select-a-filter");
		}
		
		if(SessionErrors.isEmpty(request)){
			_log.debug("catId "+catId+" and cityId "+cityId);
			List<AdListing> adList = null;
				try {
					adList = AdListingLocalServiceUtil.getByC_C(catId, cityId);
					if(adList != null && adList.size() > 0){
						_log.debug("Got adlist with size "+adList.size());
					}
				} catch (SystemException e) {
					
				}
			request.setAttribute("adList", adList);
			request.setAttribute("catIdFromFilter", catId);
			request.setAttribute("loadDefaultAdList", loadDefaultAdList);
		}
	}
	
	public void refineResultsByCity(ActionRequest request, ActionResponse response){
		long catId = ParamUtil.getLong(request, "selectedCategoryId");
		long cityId = ParamUtil.getLong(request, "adCityId");
		boolean loadDefaultAdList = false;
		if(catId == 0){
			SessionErrors.add(request, "select-a-filter");
		}
		
		if(SessionErrors.isEmpty(request)){
			_log.debug("catId "+catId+" and cityId "+cityId);
			List<AdListing> adList = null;
				try {
					adList = AdListingLocalServiceUtil.getByC_C(catId, cityId);
					if(adList != null && adList.size() > 0){
						_log.debug("Got adlist with size "+adList.size());
					}
				} catch (SystemException e) {
					
				}
			request.setAttribute("adList", adList);
			request.setAttribute("cityIdFromFilter", cityId);
			request.setAttribute("loadDefaultAdList", loadDefaultAdList);
		}
	}
	
	public void makeCityPopular(ActionRequest request, ActionResponse response){
		long cityId = ParamUtil.getLong(request, "adCityId");
		long popularOptionId = ParamUtil.getLong(request, "popularOptionId");
		if(cityId != 0){
			AdCity city = null;
			try {
				city = AdCityLocalServiceUtil.getAdCity(cityId);
			} catch (Exception e) {
				
			}
			if(city != null){
				if(popularOptionId == 1){
					city.setPopular(true);
				}else if(popularOptionId == 2){
					city.setPopular(false);
				}
				try {
					AdCityLocalServiceUtil.updateAdCity(city);
					_log.debug("City updated "+city.getCityName()+" and is now popular ? "+city.getPopular());
					SessionMessages.add(request, "city-updated");
				} catch (SystemException e) {
					
				}
			}
		}
		response.setRenderParameter("pageAction", MAKE_CITY_POPULAR_JSP);
	}
}
