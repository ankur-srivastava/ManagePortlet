/**
 * 
 */
package com.ui.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.lia.ui.helper.LIAJavaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.services.model.AdListing;
import com.services.service.AdListingLocalServiceUtil;
import com.ui.helper.ActionUtil;

/**
 * @author ankursrivastava - referred to SCIndexer
 */
public class AdSearch extends BaseIndexer {

	public static final String[] CLASS_NAMES = { AdListing.class.getName() };

	public static final String PORTLET_ID = AdListingKeys.AD_LISTING_PORTLET_ID;
	
	public static Log _log = LogFactoryUtil.getLog(AdSearch.class);

	@Override
	public String[] getClassNames() {
		// TODO Auto-generated method stub
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		return PORTLET_ID;
	}
	
	@Override
	public void postProcessSearchQuery(
            BooleanQuery searchQuery, SearchContext searchContext)
      throws Exception {
      /*Change search query*/
      String query = searchQuery.toString();
      List<String> tokens = LIAJavaUtil.getTokens(query, " ");
      for(String token : tokens){
    	  if(!token.contains("*")){
    		  List<String> tokenmap = LIAJavaUtil.getTokens(token, ":");
    		  String value= tokenmap.get(1)+"*";
    		  searchQuery.addTerm(tokenmap.get(0), value);
    	  }
      }
	}
	
	@Override
	public void postProcessContextQuery(
			BooleanQuery contextQuery, SearchContext searchContext)
		throws Exception {
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		// TODO Auto-generated method stub
		AdListing adListing = (AdListing) obj;
		deleteDocument(adListing.getCompanyId(), adListing.getAdId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		// TODO Auto-generated method stub
		AdListing adListing = (AdListing) obj;
		
		_log.debug("In doGetDocument for "+adListing.getAdId());
		
		long companyId = adListing.getCompanyId();
		long scopeGroupId = adListing.getGroupId();
		long userId = adListing.getUserId();
		long resourcePrimKey = adListing.getPrimaryKey();
		
		String title = adListing.getAdTitle();
		String description = HtmlUtil.extractText(adListing.getAdDescription());
		String adCategoryName = "";
		String[] assetTagNames = null;
		
		if(adListing != null){
			adCategoryName = ActionUtil.getCategoryName(adListing.getAdCatId());
		}

		Document document = getBaseModelDocument(PORTLET_ID, adListing);

		document.addUID(PORTLET_ID, resourcePrimKey);
		document.addKeyword(Field.COMPANY_ID, companyId);
		document.addKeyword(Field.PORTLET_ID, PORTLET_ID);
		document.addKeyword(Field.GROUP_ID, scopeGroupId);
		document.addKeyword(Field.SCOPE_GROUP_ID, scopeGroupId);
		document.addKeyword(Field.USER_ID, userId);
		document.addKeyword(Field.ENTRY_CLASS_PK, resourcePrimKey);
		
		if(!adCategoryName.equals("")){
			title = adCategoryName+" "+title;
			//document.addKeyword(Field.KEYWORD_SEARCH, adCategoryName);
		}
		/*The tags are not helping so I am adding that to the title*/
		try{
			_log.debug("Trying to get asset tag for adListing.getAdId() = "+adListing.getAdId()+" and resourcePrimKey = "+resourcePrimKey);
			assetTagNames = AssetTagLocalServiceUtil.getTagNames(AdListing.class.getName(), adListing.getAdId());
			String tags=getTags(assetTagNames);
			_log.debug("Adding asset tags for "+tags);
			//document.addKeyword(Field.ASSET_TAG_NAMES, assetTagNames);
			title=title+" "+tags;
		}catch(Exception e){ }
		
		document.addText(Field.TITLE, title);
		document.addText(Field.CONTENT, description);
		document.addText(Field.DESCRIPTION, description);
		
		return document;
	}
	
	private String getTags(String[] tags){
		StringBuilder sb = new StringBuilder();
		_log.debug("Print tags ");
		for(String s:tags){
			_log.debug(s);
			sb.append(s);
		}
		_log.debug("Returning "+sb.toString());
		return sb.toString();
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,String snippet, PortletURL portletURL) throws Exception {
		String title = document.get(Field.TITLE);
		String content = snippet;
		if (Validator.isNull(snippet)) {
			content = document.get(Field.DESCRIPTION);
			if (Validator.isNull(content)) {
				content = StringUtil.shorten(document.get(Field.CONTENT), 200);
			}
		}
		String resourcePrimKey = document.get(Field.ENTRY_CLASS_PK);
		_log.debug("In doGetSummary for "+resourcePrimKey);
		portletURL.setParameter("pageAction", "LISTING_DETAIL_JSP");
		portletURL.setParameter("searchAdId", resourcePrimKey);

		return new Summary(title, content, portletURL);
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		// TODO Auto-generated method stub
		AdListing adListing = (AdListing) obj;
		Document document = getDocument(adListing);

		SearchEngineUtil.updateDocument(getSearchEngineId(),
				adListing.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		// TODO Auto-generated method stub
		AdListing adListing = AdListingLocalServiceUtil.getAdListing(classPK);
		doReindex(adListing);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		long companyId = GetterUtil.getLong(ids[0]);
		reindexAdListingEntries(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		// TODO Auto-generated method stub
		return PORTLET_ID;
	}

	protected void reindexAdListingEntries(long companyId) throws Exception {

		int count = AdListingLocalServiceUtil.getAdListingsCount();
		int pages = count / Indexer.DEFAULT_INTERVAL;
		for (int i = 0; i <= pages; i++) {
			int start = (i * Indexer.DEFAULT_INTERVAL);
			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexAdListings(companyId, start, end);
		}
	}

	protected void reindexAdListings(long companyId, int start, int end)
			throws Exception {

		List<AdListing> listings = AdListingLocalServiceUtil.getAdListings(
				start, end);

		if (listings.isEmpty()) {
			return;
		}

		Collection<Document> documents = new ArrayList<Document>();

		for (AdListing listing : listings) {
			Document document = getDocument(listing);
			documents.add(document);
		}
		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId,
				documents);
	}

}
