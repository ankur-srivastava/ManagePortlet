/**
 * 
 */
package com.ui.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

/**
 * @author ankursrivastava
 *
 */
public class DocumentHelperImpl{
	
	static Log _log = LogFactoryUtil.getLog(DocumentHelperImpl.class);
	
	public static DLFolder getDLFolderForRequest(long userId, long requestId, long groupId, ServiceContext serviceContext, UploadRequest request){
		DLFolder fileFolder=null;
		String folderName = String.valueOf(requestId);
		if(!folderName.equals("")){
			List<DLFolder> dlFolders = getAllDLFolders();
			DLFolder parentFolder=getParentFolder(dlFolders, requestId, groupId, serviceContext, request);
			if(parentFolder != null){
				_log.debug("Got parent folder "+parentFolder.getFolderId());
				fileFolder=getFolder(dlFolders, folderName, parentFolder.getFolderId());
				if(fileFolder == null){
					_log.debug("Sub folder is null. Going to create one.");
					try{
						fileFolder=createNewFolder(userId, groupId, serviceContext, folderName, parentFolder.getFolderId());
						if(fileFolder != null && fileFolder.getName() != null){
							_log.debug("Returning this folder "+fileFolder.getName());
						}
					}catch(Exception e){
						_log.debug("Unable to create sub folder ");
					}
				}
			}
		}
		return fileFolder;
	}
	
	public static List<DLFolder> getAllDLFolders(){
		List<DLFolder> dlFolders = null;
		try {
			dlFolders = DLFolderLocalServiceUtil.getDLFolders(0, DLFolderLocalServiceUtil.getDLFoldersCount());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			_log.debug("No folders exist "+e.getMessage());
		}
		return dlFolders;
	}
	
	public static DLFolder getFolder(List<DLFolder> dlFolders, String folderName, long parentfolderId){
		DLFolder dlFolder = null;
		_log.debug("In getFolder and check for "+folderName);
		if(dlFolders != null && dlFolders.size() > 0){
			for (DLFolder folder : dlFolders) {
				if(folder.getName().equalsIgnoreCase(folderName)){
					_log.debug("In getFolder and following folder is matching "+folder.getName());
					if(parentfolderId != 0){
						if(checkIfParentFolderMatches(folder, parentfolderId)){
							dlFolder=folder;
							break;
						}
					}else{
						dlFolder=folder;
						break;
					}
				}
			}
		}
		
		return dlFolder;
	}
	
	public static DLFolder getFolder(List<DLFolder> dlFolders, String folderName, long parentfolderId, long groupId){
		DLFolder dlFolder = null;
		_log.debug("In overridden getFolder and check for "+folderName);
		if(dlFolders != null && dlFolders.size() > 0){
			for (DLFolder folder : dlFolders) {
				if(folder.getGroupId() == groupId){
					if(folder.getName().equalsIgnoreCase(folderName)){
						_log.debug("In getFolder and following folder is matching "+folder.getName());
						if(parentfolderId != 0){
							if(checkIfParentFolderMatches(folder, parentfolderId)){
								dlFolder=folder;
								break;
							}
						}else{
							dlFolder=folder;
							break;
						}
					}
				}
			}
		}
		
		return dlFolder;
	}
	
	public static boolean checkIfParentFolderMatches(DLFolder folder, long parentfolderId){
		boolean matches=false;
		DLFolder parentFolder=null;
		try {
			_log.debug("Get parent folder for "+folder.getName());
			parentFolder=folder.getParentFolder();
			_log.debug("Got parent folder for "+folder.getName()+" as "+parentFolder.getName());
		} catch (Exception e) {
		}
		if(parentFolder != null && parentFolder.getName() != null && !parentFolder.getName().equals("") && parentfolderId != 0){
			if(parentFolder.getFolderId() == parentfolderId){
				matches=true;
			}
		}
		return matches;
	}
	
	public static DLFolder createNewFolder(long userId, long groupId, ServiceContext serviceContext, String folderName, long parentfolderId){
		_log.debug("Going to create a new folder for "+folderName);
		DLFolder folder = null;
		try {
			folder = DLFolderLocalServiceUtil.addFolder(
					userId, groupId, groupId,
					false, parentfolderId,
					folderName, StringPool.BLANK, false,
					serviceContext);
		} catch (Exception e) {
			_log.debug("Unable to create "+folderName);
		} 
		return folder;
	}
	
	private static DLFolder getParentFolder(List<DLFolder> dlFolders, long userId, long groupId, ServiceContext serviceContext, UploadRequest request){
		_log.debug("Check if "+AlConstants.AL_IMAGE_FOLDER_NAME+" exists from session");
		HttpSession session = request.getSession();
		DLFolder parentFolder=null;
		if(session.getAttribute(AlConstants.AL_IMAGE_FOLDER_NAME) != null){
			_log.debug("Got "+AlConstants.AL_IMAGE_FOLDER_NAME+" folder from session");
			parentFolder=(DLFolder)session.getAttribute(AlConstants.AL_IMAGE_FOLDER_NAME);
		}else{
			parentFolder=getFolder(dlFolders,AlConstants.AL_IMAGE_FOLDER_NAME, 0, groupId);
			if(parentFolder == null){
				_log.debug("Parent folder does not exist. Going to create one.");
				parentFolder=createNewFolder(userId, groupId, serviceContext, AlConstants.AL_IMAGE_FOLDER_NAME, 0);
			}
			_log.debug("Put folder in session");
			if(parentFolder != null){
				session.setAttribute(AlConstants.AL_IMAGE_FOLDER_NAME, parentFolder);
			}
		}
		return parentFolder;
	}
	
	public static FileEntry uploadDocument(ThemeDisplay themeDisplay, UploadPortletRequest uploadRequest, ServiceContext serviceContext, long requestId) throws DuplicateFileException{
		FileEntry fileEntry=null;
		DLFolder requestFolder = getDLFolderForRequest(themeDisplay.getUserId(), requestId, themeDisplay.getScopeGroupId(), serviceContext, uploadRequest);
		if(requestFolder != null){
			File document = uploadRequest.getFile("requestFile");
			String fileName=uploadRequest.getFileName("requestFile");
			_log.debug("File name "+fileName);
			try {
				fileEntry=uploadToDocumentLibrary(requestId, themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), document, requestFolder, serviceContext, fileName);
			} catch (DuplicateFileException e) {
				_log.debug("A file already exists "+e.getMessage());
				throw new DuplicateFileException();
			}
		}
		return fileEntry;
	}
	
	public static FileEntry uploadToDocumentLibrary(long userId, long groupId, long companyId, File document, DLFolder fileFolder, ServiceContext serviceContext, String fileName) throws DuplicateFileException{
		FileEntry fileEntry=null;
		if(document != null){
			_log.debug("Going to add file "+fileName);
				if(serviceContext != null){
					try {
						fileEntry=DLAppServiceUtil.addFileEntry(groupId, fileFolder.getFolderId(), fileName, MimeTypesUtil.getContentType(document), fileName, fileName, "", document, serviceContext);
					}catch(DuplicateFileException e){
						throw new DuplicateFileException();
					}catch (PortalException e) {
						_log.debug("Following error occured while uploading the file "+e.getMessage());
					} catch (SystemException e) {
						_log.debug("Following error occured while uploading the file "+e.getMessage());
					}
					addPermissions(fileEntry);
				}else{
					_log.debug("Service Context is null");
				}
				//setDocumentRoles(companyId, fileEntry, roleId);
		}
		return fileEntry;
	}
	
	public static DLFileEntry getRequestFile(long requestId){
		DLFileEntry file = null;
		if(requestId != 0){
			try {
				file = DLFileEntryLocalServiceUtil.getDLFileEntry(requestId);
			} catch (Exception e) {
				_log.debug("Error while getting file for "+requestId);
			}
		}
		return file;
	}
	
	public static List<String> getTokens(String input, String delimiter){
		List<String> tokens = null;
		if(input != null && !input.equals("")){
			tokens = new ArrayList<String>();
			StringTokenizer parser = new StringTokenizer(input, delimiter);
			while(parser.hasMoreElements()){
				tokens.add(parser.nextToken());
			}
		}
		return tokens;
	}

	public static String getFileURL(ThemeDisplay themeDisplay, DLFileEntry file){
		String fileURL= "";
		fileURL = themeDisplay.getPortalURL()+themeDisplay.getPathContext()+"/documents/"+themeDisplay.getScopeGroupId() + "/"+file.getFolderId()+"/"+HttpUtil.encodeURL(HtmlUtil.unescape(file.getTitle()));
		return fileURL;
	}
	
	public static void addPermissions(FileEntry file){
		/*Add Permissions*/
		if(file != null){
			/*
			ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId, DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
	                String.valueOf(fileEntry.getFileEntryId()),
	                roleId,
	                new String[] {ActionKeys.VIEW});
	         */
		}
		
		/*Ends*/
	}
	
	public static DLFolder getApnaareaFolder(long userId, long groupId, ServiceContext serviceContext, PortletRequest request){
		_log.debug("Check if "+AlConstants.AL_IMAGE_FOLDER_NAME+" exists from session");
		PortletSession session = request.getPortletSession();
		DLFolder folder=null;
		List<DLFolder> dlFolders = getAllDLFolders();
		if(session.getAttribute(AlConstants.AL_IMAGE_FOLDER_NAME) != null){
			_log.debug("Got "+AlConstants.AL_IMAGE_FOLDER_NAME+" folder from session");
			folder=(DLFolder)session.getAttribute(AlConstants.AL_IMAGE_FOLDER_NAME);
		}else{
			folder=getFolder(dlFolders,AlConstants.AL_IMAGE_FOLDER_NAME, 0, groupId);
			if(folder == null){
				_log.debug("Folder does not exist. Going to create one.");
				folder=createNewFolder(userId, groupId, serviceContext, AlConstants.AL_IMAGE_FOLDER_NAME, 0);
			}
			_log.debug("Put folder in session");
			if(folder != null){
				session.setAttribute(AlConstants.AL_IMAGE_FOLDER_NAME, folder);
			}
		}
		return folder;
	}
}
