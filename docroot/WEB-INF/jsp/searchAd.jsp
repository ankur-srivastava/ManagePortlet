<%@page import="com.ui.helper.ActionUtil"%>
<%@page import="com.lia.ui.helper.LIAJavaUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="init.jsp" %>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
  <portlet:param name="pageAction" value="SEARCH_AD_JSP" />
</liferay-portlet:renderURL>

<portlet:renderURL var="cancelURL" />

<aui:form action="<%= searchURL %>" method="get" name="fm"> <liferay-portlet:renderURLParams varImpl="searchURL" />
	<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
	/>
	<% 
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setParameter("pageAction", "SEARCH_AD_JSP"); 
		portletURL.setParameter("redirect", redirect); 
		portletURL.setParameter("keywords", keywords);
		List<String> headerNames = new ArrayList<String>();
		//headerNames.add("");
		headerNames.add("Title");
		headerNames.add("Posted on");
		headerNames.add("City");
		headerNames.add("Posted by");
		
		SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames,
			    LanguageUtil.format(pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>"));
		try{
			Indexer indexer = IndexerRegistryUtil.getIndexer(AdListing.class);
			SearchContext searchContext =
			        SearchContextFactory.getInstance(request);
			searchContext.setEnd(searchContainer.getEnd());
		    searchContext.setKeywords(keywords);
		    searchContext.setStart(searchContainer.getStart());
		    
		    Hits results = indexer.search(searchContext);
		    
		    int total = results.getLength();
		    searchContainer.setTotal(total);
		    
		    List resultRows = searchContainer.getResultRows();
		    
		    //for (int i = 0; i < results.getDocs().length; i++) {
		    for (int i = (results.getDocs().length-1); i >= 0; i--) {
		        Document doc = results.doc(i);
		        ResultRow row = new ResultRow(doc, i, i);
		    	//row.addText("" + StringPool.PERIOD);
		    	long adId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
		    	AdListing adListingObj = null;
		    	AdListingCustomModel customAdListingObj = new AdListingCustomModel();
			    try {
			    	adListingObj = AdListingLocalServiceUtil.getAdListing(adId);
			    	customAdListingObj = ActionUtil.populateAdListingCustomModel(customAdListingObj, adListingObj, themeDisplay, ActionUtil.getFolderId(renderRequest));
			    	adListingObj = adListingObj.toEscapedModel();
			    }
			    catch (Exception e) { 
			    	continue; 
			    }
		    
			   PortletURL rowURL = renderResponse.createRenderURL();
	           rowURL.setParameter("pageAction", "LISTING_DETAIL_JSP");
	           rowURL.setParameter("adDetailId",String.valueOf(adId));
	           
	           row.addText(customAdListingObj.getAdTitle(), rowURL);
	           row.addText(customAdListingObj.getCreatedDate(), rowURL);
	           row.addText(customAdListingObj.getAdCityName(), rowURL);
	           row.addText(customAdListingObj.getUserName(), rowURL);
	           resultRows.add(row);
	      }
	%>
			  <input type="text" name="keywords" size="30px" />
			  <aui:button type="submit" value="search" />
			  <br /><br />
			  <liferay-ui:search-iterator
			      searchContainer="<%= searchContainer %>" />
			  <%
			  	}catch (Exception e) { }
			  %>
</aui:form>
<%
	if(Validator.isNotNull(keywords)){
		PortalUtil.addPortletBreadcrumbEntry(
			       request, LanguageUtil.get(pageContext, "search")+": " + keywords, "");
	}
%>