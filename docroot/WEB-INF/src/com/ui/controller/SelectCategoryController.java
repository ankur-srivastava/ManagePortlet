/**
 * 
 */
package com.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lia.ui.helper.LIAUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.services.model.AdCategory;
import com.services.model.AdCity;
import com.services.model.AdListing;
import com.services.service.AdCategoryLocalServiceUtil;
import com.services.service.AdCityLocalServiceUtil;
import com.ui.helper.AdCategoryHelper;

/**
 * @author ankursrivastava
 *
 */
public class SelectCategoryController extends MVCPortlet{
	
	String VIEW_JSP;
	
	Log _log = LogFactory.getLog(AdListing.class);
	
	public void init(){
		VIEW_JSP = getInitParameter("sc-view-jsp");
	}
	
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException{
		String jspPath = VIEW_JSP;
		List<AdCategory> categoryList = null;
		List<AdCity> cityList = null;
		
		/*Get the list of categories*/
		try {
			categoryList = AdCategoryLocalServiceUtil.getActiveAdCategories();
			cityList = AdCityLocalServiceUtil.getActiveAdCityList();
		} catch (SystemException e) {
			_log.debug("Error while getting category and city list "+e.getMessage());
		}
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("cityList", cityList);
		/*Ends*/
		LIAUtil.redirect(jspPath, getPortletContext(), request, response);
	}
	
	public void postEvent(ActionRequest request, ActionResponse response){
		long categoryId = ParamUtil.getLong(request, "categoryId");
		QName qName = new QName("http://liferay.com/events", "category");
		response.setEvent(qName, categoryId);
	}
	
	public void refineResults(ActionRequest request, ActionResponse response){
		long catId = ParamUtil.getLong(request, "adCategoryId");
		long cityId = ParamUtil.getLong(request, "adCityId");
		String serviceType = ParamUtil.getString(request, "serviceType");
		
		if(catId == 0 && cityId == 0){
			SessionErrors.add(request, "select-a-filter");
		}
		
		if(SessionErrors.isEmpty(request)){
			AdCategoryHelper adCategoryObj = new AdCategoryHelper();
			adCategoryObj.setCatId(catId);
			adCategoryObj.setCityId(cityId);
			adCategoryObj.setServiceType(serviceType);
			
			request.setAttribute("catIdFromFilter", catId);
			request.setAttribute("cityIdFromFilter", cityId);
			
			QName qName = new QName("http://liferay.com/events", "filterResults");
			response.setEvent(qName, adCategoryObj);
		}
	}
}
