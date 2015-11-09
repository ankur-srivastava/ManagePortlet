/**
 * 
 */
package com.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lia.ui.helper.LIAUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.models.AdListingCustomModel;
import com.services.model.AdListing;
import com.services.model.AdResponseTracker;
import com.services.model.AdStatsTracker;
import com.services.service.AdListingLocalServiceUtil;
import com.services.service.AdResponseTrackerLocalServiceUtil;
import com.services.service.AdStatsTrackerLocalServiceUtil;
import com.ui.helper.ActionUtil;

/**
 * @author ankursrivastava
 *
 */
public class AdResponseController extends MVCPortlet{
	
	String VIEW_JSP;
	String LISTING_DETAIL_JSP;
	
	Log _log = LogFactory.getLog(AdResponseController.class);
	
	public void init(){
		VIEW_JSP = getInitParameter("adResponse-view-jsp");
		LISTING_DETAIL_JSP = getInitParameter("listingDetail-jsp");
	}
	
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException{
		String jspPath = VIEW_JSP;
		String imageURL = "";
		
		long adId = 0;
		
		List<AdResponseTracker> adResponseTrackerList = null;
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			adResponseTrackerList = AdResponseTrackerLocalServiceUtil.getAdResponseTrackerList(themeDisplay.getUserId());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(request.getParameter("adDetailId") != null){
			long folderId = ActionUtil.getFolderId(request);
			AdListingCustomModel adDetailCustomObj = new AdListingCustomModel();
			adId = ParamUtil.getLong(request, "adDetailId");
			AdListing adListingObj = null;
			AdStatsTracker adStatsTracker = null;
			long totalViews = 0;
			try {
				adListingObj = AdListingLocalServiceUtil.getAdListing(adId);
				adStatsTracker = AdStatsTrackerLocalServiceUtil.fetchAdStatsTracker(adId);
				totalViews = adStatsTracker.getAdCount(); 
				imageURL = ActionUtil.getImageURL(adId, themeDisplay, folderId);
			} catch (Exception e) { 
				e.printStackTrace();
			}
			adDetailCustomObj = ActionUtil.populateAdListingCustomModel(adDetailCustomObj, adListingObj, themeDisplay, folderId);
			request.setAttribute("adListingObj", adDetailCustomObj);
			request.setAttribute("totalViews", (totalViews+1));
			request.setAttribute("imageURL", imageURL);
		}
		if(request.getParameter("pageAction") != null){
			jspPath = getJSPPath(ParamUtil.getString(request, "pageAction"));
		}
		
		request.setAttribute("adResponseTrackerList", adResponseTrackerList);
		LIAUtil.redirect(jspPath, getPortletContext(), request, response);
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
	
	public void contactUser(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		/*Send email to the user*/
		String userName = ParamUtil.getString(request, "userName");
		String userEmail = ParamUtil.getString(request, "userEmail");
		String userPhone = ParamUtil.getString(request, "userPhone");
		String comments = ParamUtil.getString(request, "comments");
		String userIP = "";
		
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
		
		userIP = httpRequest.getHeader("X-FORWARDED-FOR");  
		if (userIP == null) {  
			userIP = httpRequest.getRemoteAddr();  
		}
		long adDetailId = ParamUtil.getLong(request, "adDetailId");
		
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
				ActionUtil.addAdResponseTracker(adListingObj.getAdId(), adListingObj.getUserId(), userName, userEmail, userPhone, comments, userIP);
			} catch (Exception e) {
				e.printStackTrace();
			}
			SessionMessages.add(request, "response-sent-successfully");
		}
		response.setRenderParameter("adDetailId", String.valueOf(adDetailId));
		response.setRenderParameter("pageAction", LISTING_DETAIL_JSP);
	}
	
	private String getJSPPath(String jspPath){
		if(jspPath.equals("LISTING_DETAIL_JSP")){
			jspPath = LISTING_DETAIL_JSP;
		}
		return jspPath;
	}
}
