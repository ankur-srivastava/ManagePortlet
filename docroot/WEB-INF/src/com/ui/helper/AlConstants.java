/**
 * 
 */
package com.ui.helper;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * @author ankursrivastava
 *
 */
public class AlConstants {
	private static final String AL_IMAGE_FOLDERID_STR = "al.image.folder.id";
	public static final long AL_IMAGE_FOLDERID = GetterUtil.getLong(PropsUtil.get(AL_IMAGE_FOLDERID_STR));
	
	public static final String AL_IMAGE_FOLDER_NAME = "adlistings";
	
	private static final String AL_RESPONSE_EMAIL_TEMPLATE_ARTICLE_ID_STR = "al.response.email.template.articleid";
	public static final String AL_RESPONSE_EMAIL_TEMPLATE_ARTICLE_ID = PropsUtil.get(AL_RESPONSE_EMAIL_TEMPLATE_ARTICLE_ID_STR);
	
	public static final String VIEW_ALL_URL = "viewall";
	
	public static final int ADS_LIMIT = 3;
	
	public static final int NUMBER__OF_ADS_TO_BE_FETCHED = 100;
}
