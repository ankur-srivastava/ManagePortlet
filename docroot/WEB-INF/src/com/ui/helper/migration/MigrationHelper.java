/**
 * 
 */
package com.ui.helper.migration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.services.model.AdCity;
import com.services.model.impl.AdCityImpl;
import com.services.service.AdCityLocalServiceUtil;

/**
 * @author ankursrivastava
 *
 */
public class MigrationHelper {
	
	private static final Log _log = LogFactoryUtil.getLog(MigrationHelper.class);
	
	private String metaFileName = "";
	
	public static boolean isValidFile(File f){
        return new CPFileFilter().accept(f);
	}
	/*Perform field Validation*/
	public static void doValidation(UploadPortletRequest uploadRequest, ActionRequest request){
		_log.info("In Validation");
		File metaDocumentFile = uploadRequest.getFile("metaDocumentFile");
		if(uploadRequest.getSize("metaDocumentFile") != 0){
			if(!MigrationHelper.isValidFile(metaDocumentFile)){
				SessionErrors.add(request, "file-invalid");
			}
		}else{
			SessionErrors.add(request, "file-invalid");
		}
	}
	
	public void migrate(UploadPortletRequest uploadRequest) throws PortalException, SystemException{
		String metaDocumentFileContent = "";
		
		ThemeDisplay themeDisplay=(ThemeDisplay) uploadRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), uploadRequest);
		
		File metaDocumentFile = uploadRequest.getFile("metaDocumentFile");
		
		setMetaFileName(metaDocumentFile.getName());
		
		try {
			metaDocumentFileContent = PortletHelper.fileToString(metaDocumentFile);
			//_log.info("File content "+metaDocumentFileContent);
		} catch (IOException e) {
			_log.error("Error occured while converting file to string "+e.getMessage());
		}
		/*Read the meta file and get individual Files */
		if(!metaDocumentFileContent.equals("")){
			parseFileContent(metaDocumentFileContent, themeDisplay.getUserId(), themeDisplay.getScopeGroup(), serviceContext);
		}
	}
	
	public void parseFileContent(String metaDocumentFileContent, long userId, Group group, ServiceContext serviceContext){
		List<String> fileEntries = PortletHelper.getTokens(metaDocumentFileContent, CPHelperConstants.FILES_DELIMITER);
		if(fileEntries != null && fileEntries.size() > 0){
			for(String fileEntry : fileEntries){
				prepareFiles(fileEntry,userId, group, serviceContext);
			}
		}
	}
	
	public void prepareFiles(String fileEntry, long userId, Group group, ServiceContext serviceContext){
		//List<String> fileAttributes =  CPHelper.getTokens(fileEntry, CPHelperConstants.FILE_ATTRIBUTE_DELIMITER);
		String[] fileAttributes=PortletHelper.getFileAttributes(fileEntry, CPHelperConstants.FILE_ATTRIBUTE_DELIMITER);
		if(fileAttributes != null && fileAttributes.length > 0){
			String cityName="";
			String stateName="";
			if(fileAttributes[1] != null){
				cityName = fileAttributes[1];
			}
			if(fileAttributes[1] != null){
				stateName = fileAttributes[2];
			}
			_log.info("City "+cityName+" State "+stateName);
			
			if(Validator.isNotNull(cityName)){
				/*Check if City exists. If not add*/
				AdCity adCity=getAdCity(cityName);
				if(adCity != null){
					_log.info("Following city exists "+cityName);
					if(adCity.getStateName() == null || adCity.getStateName().equals("")){
						_log.info("Updating State for this city ");
						if(Validator.isNotNull(stateName) && stateName.equals("unknown")){
							adCity.setStateName("");
						}else if(stateName != null && !stateName.equals("") && !stateName.equals("unknown")){
							adCity.setStateName(stateName);
						}
						_log.info("State set to "+adCity.getStateName());
						try {
							adCity=AdCityLocalServiceUtil.updateCity(adCity);
							_log.info("City was updated");
						} catch (SystemException e) {
							_log.error("Error while updating the City");
						}
					}
				}else{
					_log.info("Adding a new city for "+cityName);
					AdCity cityObj = new AdCityImpl();
					cityObj.setCityName(cityName);
					cityObj.setCityStatus(true);
					
					if(Validator.isNotNull(stateName) && stateName.equals("unknown")){
						cityObj.setStateName("");
					}else if(stateName != null && !stateName.equals("") && !stateName.equals("unknown")){
						cityObj.setStateName(stateName);
					}
					_log.info("State set to "+cityObj.getStateName());
					try {
						cityObj=AdCityLocalServiceUtil.addNewCity(cityObj);
						_log.info("New City was added");
					} catch (SystemException e) {
						_log.error("Error while adding new city "+e.getMessage());
					}
				}
			}
		}
	}
	
	public AdCity getAdCity(String cityName){
		List<AdCity> adCityList = null;
		AdCity adCity = null;
		try {
			adCityList = AdCityLocalServiceUtil.getAdCityByName(cityName);
		} catch (SystemException e) {
			_log.error("City does not exist "+e.getMessage());
		}
		if(adCityList != null && adCityList.size() > 0){
			if(adCityList.size() > 1){
				_log.info("There are more than one cities for "+cityName);
			}
			adCity = adCityList.get(0);
		}
		return adCity;
	}
	
	public void manageRoles(String roles, long companyId, FileEntry uploadedFile){
		List<String> roleNames=null;
		if(!roles.equals("")){
			if(roles.contains(CPHelperConstants.FOLDER_DELIMITER)){
				roleNames = PortletHelper.getTokens(roles, CPHelperConstants.FOLDER_DELIMITER);
				_log.info("Roles");
				PortletHelper.printTokens(roleNames);
				_log.info("Done");
			}else{
				roleNames=new ArrayList<String>();
				roleNames.add(roles);
			}
			if(roleNames != null && roleNames.size() > 0){
				for(String roleName:roleNames){
					/*Get the roleId for the role-name*/
					long roleId=0;
					roleId=getRoleId(roleName, companyId);
					if(roleId != 0){
						PortletHelper.setDocumentRoles(companyId, uploadedFile, roleId);
					}
				}
			}
		}
	}
	
	public long getRoleId(String roleName, long companyId){
		Role role=null;
		long roleId=0;
		if(!roleName.equals("") && !roleName.equals(" ")){
			/*Check if role name is a State like MI,NY*/
			if(roleName.length() == 2){
				_log.info("Role Name - "+roleName);
				roleName = CPHelperConstants.AGENT_PORTAL_STATE_NAME_CONVENTION+roleName;
				_log.info("Role Name now - "+roleName);
			}
			/*Check if it exists in DB*/
			_log.info("Check if "+roleName+" exists in DB");
			try{
				role = RoleLocalServiceUtil.getRole(companyId, roleName);
				roleId=role.getRoleId();
				_log.info("Found an existing role for "+roleName);
			}catch(Exception e){
				_log.error("Role not found for "+roleName+" error is "+e.getMessage());
			}
		}
		return roleId; 
	}
	
	public DLFolder cpFileFolder(String folderName, long userId, Group group, ServiceContext serviceContext){
		DLFolder fileFolder=null;
		
		List<DLFolder> dlFolders = PortletHelper.getAllDLFolders();
		
		if(!folderName.equals("")){
			_log.info("Folder string is "+folderName);
			/*Get a list of all folders*/
			List<String> folderNames = new ArrayList<String>();
			/*
			 * Assuming folder hierarchy is FolderA#FolderB#FolderC
			 * This method will check to see if the hierarchy exists else it will create this.
			 * */
			/*Check if there is a hierarchy - then parse*/
			if(folderName.contains(CPHelperConstants.FOLDER_DELIMITER)){
				folderNames = PortletHelper.getTokens(folderName, CPHelperConstants.FOLDER_DELIMITER);
			}else{
				folderNames.add(folderName);
			}
			if(folderNames != null && folderNames.size() > 0){
				/*
				 * Check if folder name exists
				 * If not create one
				 * */
				long parentfolderId=0;
				DLFolder newFolder=null;
				for(String tempFolderName : folderNames){
					_log.info("Now working on "+tempFolderName+" with parent "+parentfolderId);
					DLFolder matchingfolder = null;
					if(!checkIfFolderExists(dlFolders, tempFolderName, matchingfolder, parentfolderId)){
						_log.info("Folder does not exist");
						/*Create a new folder*/
						newFolder=PortletHelper.createNewFolder(userId, group, serviceContext, tempFolderName, parentfolderId);
						parentfolderId=newFolder.getFolderId();
						fileFolder=newFolder;
						_log.info("New folder created "+newFolder.getName());
					}else{
						matchingfolder = getDLFolder(dlFolders, tempFolderName, parentfolderId);
						if(matchingfolder != null){
								_log.info("Folder exists "+matchingfolder.getName());
								fileFolder=matchingfolder;
								parentfolderId=matchingfolder.getFolderId();
						}
					}
					_log.info("Parent folder id "+parentfolderId);	
				}
			}
			
		}else{
			/*
			 * Upload the document in a default folder AGP
			 * If the folder does not exist then create the default folder
			 * */
			_log.info("The document needs to be uploaded to a default folder");
			DLFolder dlFolder = getDLFolder(dlFolders, CPHelperConstants.DEFAULT_FOLDER_NAME, 0);
			if(dlFolder != null){
				fileFolder=dlFolder;
			}else{
				fileFolder=PortletHelper.createNewFolder(userId, group, serviceContext, CPHelperConstants.DEFAULT_FOLDER_NAME, 0);
			}
			
		}
		if(fileFolder != null){
			_log.info("Returning the following folder "+fileFolder.getName());
		}else{
			_log.info("Returning no folder ");
		}
		return fileFolder;
	}
	
	
	public String[] getTagNamesArray(String fileTags){
		String[] tagNamesArray=null;
		List<String> tagNames = new ArrayList<String>();
		
		if(!fileTags.equals("") && fileTags.contains(CPHelperConstants.FOLDER_DELIMITER)){
			tagNames = PortletHelper.getTokens(fileTags, CPHelperConstants.FOLDER_DELIMITER);
		}else if(!fileTags.equals("")){
			tagNames.add(fileTags);
		}
		PortletHelper.printTokens(tagNames);
		if(tagNames != null && tagNames.size() > 0){
			tagNamesArray=PortletHelper.getStringArrayFromObject(tagNames.toArray());
			_log.info("Got a String Array for Tags");
		}
		return tagNamesArray;
	}
	
	public List<Long> getAssetCategoryIds(String fileCategories, long groupId, long userId, ServiceContext serviceContext){
		List<Long> assetCategoryIds=new ArrayList<Long>();
		List<String> categoryNames = new ArrayList<String>();
		
		if(!fileCategories.equals("") && fileCategories.contains(CPHelperConstants.FOLDER_DELIMITER)){
			categoryNames = PortletHelper.getTokens(fileCategories, CPHelperConstants.FOLDER_DELIMITER);
		}else if(!fileCategories.equals("")){
			categoryNames.add(fileCategories);
		}
		
		if(categoryNames != null && categoryNames.size() > 0){
			long vocabularyId=PortletHelper.getVocabularyId(groupId);
			for(String categoryName:categoryNames){
				/*
				 * For each category name parse using > sign to get the hierarchy and get the right category ids
				 * Product>Auto>Gen1>IA#Product>Auto>Gen1>IN#Product>Auto>Gen1>IL#Product>Auto>Gen2>IL
				 * */
				List<String> categoryTreeElements = new ArrayList<String>();
				long parentId=0;
				long assetCategoryId=0;
				boolean ignoreThisCategory=false;
				
				if(categoryName.contains(CPHelperConstants.CATEGORY_HIERARCHY_DELIMITER)){
					/*Traverse the tree and then pick the right category id*/
					categoryTreeElements = PortletHelper.getTokens(categoryName, CPHelperConstants.CATEGORY_HIERARCHY_DELIMITER);
				}else if(!categoryName.equals("")){
					categoryTreeElements.add(categoryName);
				}
				/*Now add the last cat id in this traversal. Take two markers parent and current*/
				for(String treeElementName:categoryTreeElements){
					try {
						AssetCategory assetCategory = PortletHelper.getCategories(treeElementName, parentId, groupId, vocabularyId, userId, serviceContext); 
						if(assetCategory != null && assetCategory.getCategoryId() != 0){
							_log.info("Got the category id "+assetCategory.getCategoryId());
							parentId=assetCategory.getCategoryId();
							assetCategoryId=assetCategory.getCategoryId();
							_log.info("Parent Id "+parentId);
						}else{
							ignoreThisCategory=true;
							break;
						}
					} catch (Exception e) {
						_log.error("Error occured while getting Category for "+categoryName+" "+e.getMessage());
					}
				}
				if(assetCategoryId != 0 && !assetCategoryIds.contains(assetCategoryId) && !ignoreThisCategory){
					assetCategoryIds.add(assetCategoryId);
				}
				
			}
		}
		return assetCategoryIds;
	}
	
	public static DLFolder getDLFolder(List<DLFolder> dlFolders, String folderName, long parentfolderId){
		DLFolder dlFolder = null;
		if(dlFolders != null && dlFolders.size() > 0){
			for (DLFolder folder : dlFolders) {
				if(folder.getName().equalsIgnoreCase(folderName)){
					/*Check if this is having same parent folder id*/
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
	
	public boolean checkIfFolderExists(List<DLFolder> dlFolders, String folderName, DLFolder matchingfolder, long parentfolderId){
		
		boolean folderExists=false;
		boolean parentFolderExists=false;
		boolean matchingFolderExists=false;
		boolean result=false;
		
		matchingfolder=getDLFolder(dlFolders, folderName, parentfolderId);
		
		if(matchingfolder != null){
			_log.info("Folder Exists "+matchingfolder.getName());
			folderExists=true;
		}
		_log.info("Check parent folder val "+parentfolderId);
		if(folderExists && parentfolderId != 0){
			parentFolderExists=true;
			if(checkIfParentFolderMatches(matchingfolder, parentfolderId)){
				matchingFolderExists=true;
			}
		}else if(folderExists){
			result=true;
		}
		if(parentFolderExists && matchingFolderExists){
			result=true;
		}
		return result;
	}
	
	public static boolean checkIfParentFolderMatches(DLFolder folder, long parentfolderId){
		boolean matches=false;
		DLFolder parentFolder=null;
		try {
			_log.info("Get parent folder for "+folder.getName());
			parentFolder=folder.getParentFolder();
			_log.info("Got parent folder for "+folder.getName()+" as "+parentFolder.getName());
		} catch (Exception e) {
		}
		if(parentFolder != null && parentFolder.getName() != null && !parentFolder.getName().equals("") && parentfolderId != 0){
			if(parentFolder.getFolderId() == parentfolderId){
				matches=true;
			}
		}
		return matches;
	}
	
	public List<String> checkFileAttributes(List<String> fileAttributes){
		_log.info("In checkFileAttributes");
		List<String> newFileAttributes = new ArrayList<String>();
		for(String attribute : fileAttributes){
			if(attribute == null){
				newFileAttributes.add("");
			}else{
				newFileAttributes.add(attribute);
			}
		}
		_log.info("newFileAttributes "+newFileAttributes);
		return newFileAttributes;
	}
	
	public static void deleteFolder(ActionRequest request){
		List<DLFolder> dlFolders = PortletHelper.getAllDLFolders();
		DLFolder dlFolder = getDLFolder(dlFolders, CPHelperConstants.DEFAULT_FOLDER_NAME, 0); 
		try {
			//DLFolderLocalServiceUtil.deleteDLFolder(dlFolder);
			DLAppLocalServiceUtil.deleteFolder(dlFolder.getFolderId());
			_log.info("Documents deleted");
			SessionMessages.add(request, "documents-deleted-success");
		} catch (SystemException e) {
			_log.error("Error while deleting "+CPHelperConstants.DEFAULT_FOLDER_NAME);
			SessionMessages.add(request, "problem-while-deleting-docs");
		}catch(PortalException e){
			_log.error("Error while deleting "+CPHelperConstants.DEFAULT_FOLDER_NAME);
			SessionMessages.add(request, "problem-while-deleting-docs");
		}
		//DMFileDetailLocalServiceUtil.deleteAllCPFileDetailEntries();
		//_log.info("CPFileDetail entries deleted");
		//DMDocumentsLocalServiceUtil.deleteAllCPDocumentEntries();
		//_log.info("CPDocuments entries deleted");
	}
	
	public String getMetaFileName() {
		return metaFileName;
	}

	public void setMetaFileName(String metaFileName) {
		this.metaFileName = metaFileName;
	}
}
