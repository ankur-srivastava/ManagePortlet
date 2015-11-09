/**
 * 
 */
package com.ui.helper.migration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mobile.device.Device;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

/**
 * @author ankursrivastava
 *
 */
public class PortletHelper {
	
	private static final Log _log = LogFactoryUtil.getLog(PortletHelper.class);
	
	public static void redirect(String path, PortletContext context, RenderRequest req, RenderResponse res) throws PortletException, IOException{
		if(context == null){
			_log.debug("Null Context");
		}
		PortletRequestDispatcher dispatcher = context.getRequestDispatcher(path);
		if(dispatcher == null){
			_log.debug("Not a valid path");
		}else{
			dispatcher.include(req, res);
		}
	}
	
	public static String fileToString(File metaDocumentFile) throws IOException{
		StringBuilder sb = new StringBuilder();
		if(metaDocumentFile != null){
			String line = "";
			FileReader reader = new FileReader(metaDocumentFile);
			BufferedReader bufreader = new BufferedReader(reader);
			while((line = bufreader.readLine()) != null){
				sb.append(line+";");
			}
			bufreader.close();
		}
		return sb.toString();
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

	/* 
	 * This method will parse a the meta file entry and get a list of attributes.*/
	public static String[] getFileAttributes(String input, String delimiter){
		String[] tokens = null;
		tokens=input.split(delimiter);
		for(String token:tokens){
			System.out.print(token+" and ");
		}
		return tokens;
	}
	
	public static DLFolder createNewFolder(long userId, Group group, ServiceContext serviceContext, String folderName, long parentfolderId){
		_log.debug("Going to create a new folder for "+folderName);
		DLFolder folder = null;
		try {
			folder = DLFolderLocalServiceUtil.addFolder(
					userId, group.getGroupId(), group.getGroupId(),
					false, parentfolderId,
					folderName, StringPool.BLANK, false,
					serviceContext);
		} catch (Exception e) {
		} 
		return folder;
	}
	
	public static List<DLFolder> getAllDLFolders(){
		List<DLFolder> dlFolders = null;
		try {
			dlFolders = DLFolderLocalServiceUtil.getDLFolders(0, DLFolderLocalServiceUtil.getDLFoldersCount());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			_log.error("No folders exist "+e.getMessage());
		}
		return dlFolders;
	}
	
	public static long getVocabularyId(long groupId){
		long vocabularyId=0;
		AssetVocabulary vocabulary=null;
		try {
			vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(groupId, CPHelperConstants.VOCABULARY_NAME);
			_log.debug("Vocabulary "+vocabulary.getName());
		} catch (Exception e){
			_log.error("Error occured while getting vocabulary for "+CPHelperConstants.VOCABULARY_NAME);
		} //pass name of Vocabulary
		if(vocabulary != null){
			vocabularyId = vocabulary.getVocabularyId();
		}
		return vocabularyId;
	}
	
	public static AssetCategory getCategories(String categoryName, long parentCategoryId, long groupId, long vocabularyId, long userId, ServiceContext serviceContext) {
        AssetCategory assetCategory=null;
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(AssetCategory.class);
		query.add(PropertyFactoryUtil.forName("name").eq(categoryName));
		if(vocabularyId != 0 && parentCategoryId != 0){
			query.add(PropertyFactoryUtil.forName("name").eq(categoryName));
			query.add(PropertyFactoryUtil.forName("vocabularyId").eq(vocabularyId));
			query.add(PropertyFactoryUtil.forName("parentCategoryId").eq(parentCategoryId));
		}
		assetCategory=getCategoryFromList(query);
		if(assetCategory == null){
	        	/*Create a new Category - This was added to help generate Categories*/
				_log.debug("Going to add a new category "+categoryName+" with parent id "+parentCategoryId);
				assetCategory=addNewCategory(userId, parentCategoryId, vocabularyId, serviceContext, categoryName);
				_log.info("New category "+categoryName+" added");
		}
        return assetCategory;
    }
	
	public static AssetCategory getCategoryFromList(DynamicQuery query){
		AssetCategory assetCategory=null;
		List<AssetCategory> categories=null;
        try {
            categories = AssetCategoryLocalServiceUtil.dynamicQuery(query, 0, 1);
        } catch (SystemException e) {
                   _log.error("Error occured while fetching category");
        }
        if(categories != null && categories.size() > 0){
        	assetCategory=categories.get(0);
        }
        return assetCategory;
	}
	
	public static AssetCategory addNewCategory(long userId, long parentCategoryId, long vocabularyId, ServiceContext serviceContext, String categoryName){
		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(serviceContext.getLocale(), categoryName);

		String[] categoryProperties = new String[1];
		AssetCategory assetCategory=null;
		
		try {
			serviceContext.setAddGuestPermissions(true);
			assetCategory = AssetCategoryLocalServiceUtil.addCategory(userId, parentCategoryId, titleMap, titleMap, vocabularyId, categoryProperties, serviceContext);
		} catch (PortalException e) {
			_log.error("Error while adding a new category "+e.getMessage());
		} catch (SystemException e) {
			_log.error("Error while adding a new category "+e.getMessage());
			e.printStackTrace();
		}
		return assetCategory;
	}
	
	
	public static String[] getStringArrayFromObject(Object[] objectArray){
		String[] strArray=null;
		if(objectArray != null && objectArray.length > 0){
			strArray=new String[objectArray.length];
			if(objectArray != null && objectArray.length > 0){
				for(int i=0;i<objectArray.length; i++){
					strArray[i] = (String)objectArray[i];
				}
			}
		}
		return strArray;
	}
	
	public static long[] getLongArrayFromList(List<Long> list){
		long[] primitiveArray=null;
		if(list != null && list.size() > 0){
			primitiveArray=new long[list.size()];
			for(int i=0;i<list.size();i++){
				primitiveArray[i]=list.get(i);
			}
		}
		return primitiveArray;
	}
	
	public static void setDocumentRoles(long companyId, FileEntry fileEntry, long roleId){
		ResourcePermission resourcePermission = null;
		/*
		try{
		   resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(companyId,DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(fileEntry.getPrimaryKey()), roleId);
		   if (Validator.isNotNull(resourcePermission)){
		      resourcePermission.setActionIds(actionIds);
		      ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
		   }
		}catch (NoSuchResourcePermissionException e){
            resourcePermission = ResourcePermissionLocalServiceUtil.createResourcePermission(CounterLocalServiceUtil.increment());
            resourcePermission.setCompanyId(companyId);
            resourcePermission.setName(DLFileEntry.class.getName());
            resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
            resourcePermission.setPrimKey(String.valueOf(fileEntry.getPrimaryKey()));
            resourcePermission.setRoleId(roleId);
            resourcePermission.setActionIds(1);// (ActionKeys.VIEW);
            ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
		}
		*/
		try{
			_log.debug("Going to add roles to the document");
			resourcePermission = ResourcePermissionLocalServiceUtil.createResourcePermission(CounterLocalServiceUtil.increment());
            resourcePermission.setCompanyId(companyId);
            resourcePermission.setName(DLFileEntry.class.getName());
            resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
            resourcePermission.setPrimKey(String.valueOf(fileEntry.getPrimaryKey()));
            resourcePermission.setRoleId(roleId);
            resourcePermission.setActionIds(1);// (ActionKeys.VIEW);
            ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
            _log.debug("Role added successfully for "+fileEntry.getFileEntryId());
		}catch(Exception e){
			_log.error("Error while adding role "+e.getMessage());
		}
	}
	
	public static void printTokens(List<String> tokens){
		for(String token:tokens){
			_log.debug(token);
		}
	}
	
	public static boolean deviceCheck(ThemeDisplay themeDisplay){
		Device device=themeDisplay.getDevice();
		_log.debug("Checking browser "+device.getBrowser());
		_log.debug("Checking is_smartphone "+device.getCapability("is_smartphone"));
		_log.debug("Checking is_wireless_device "+device.getCapability("is_wireless_device"));
		_log.debug("Checking is_mobile "+device.getCapability("is_mobile"));
		_log.debug("Checking is_android "+device.getCapability("is_android"));
		_log.debug("Checking is_tablet "+device.getCapability("is_tablet"));
		if(device.getCapability("is_wireless_device") != null || device.getCapability("is_smartphone") != null || device.getCapability("is_mobile") != null){
			return true;
		}
		return false;
	}
}
