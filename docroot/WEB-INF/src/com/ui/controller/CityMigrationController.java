/**
 * 
 */
package com.ui.controller;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.ui.helper.migration.MigrationHelper;
import com.ui.helper.migration.PortletHelper;

/**
 * @author ankursrivastava
 *
 */
public class CityMigrationController extends MVCPortlet{
	
	String VIEW_JSP;
	
	static final Log _log = LogFactoryUtil.getLog(MainController.class);
	
	public void init(){
		VIEW_JSP = getInitParameter("view-jsp");
	}
	
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException{
		/*Get a list of all the items from the CPM_CPDocuments and CPM_CPFileDetail table. This does not filter based on groupId*/
		/*
		List<DMDocuments> cpDocumentsList = MigrationHelper.getCPDocumentsList();
		List<DMFileDetail> cpFileDetailList=MigrationHelper.getCPFileDetailList();
		
		request.setAttribute("cpDocumentsList", cpDocumentsList);
		request.setAttribute("cpFileDetailList", cpFileDetailList);
		*/
		PortletHelper.redirect(VIEW_JSP, getPortletContext(), request, response);
	}

	public void migrateNewFiles(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		MigrationHelper cpHelper = new MigrationHelper();
		MigrationHelper.doValidation(uploadRequest, request);
		if(SessionErrors.isEmpty(request)){
			_log.info("Start Migration");
			cpHelper.migrate(uploadRequest);
			SessionMessages.add(request, "documents-migrated-success");
		}
	}
	
	public void deleteFiles(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		MigrationHelper.deleteFolder(request);
	}
}
