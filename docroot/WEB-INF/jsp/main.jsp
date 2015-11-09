<%@page import="com.models.AdListingCustomModel"%>
<%@ include file="init.jsp" %>

<portlet:renderURL var="postAdPageURL">
	<portlet:param name="pageAction" value="POST_JSP" />
	<portlet:param name="postAdAction" value="yes" />
</portlet:renderURL>
<portlet:renderURL var="addCategoryURL">
	<portlet:param name="pageAction" value="ADD_CATEGORY_JSP" />
</portlet:renderURL>
<portlet:renderURL var="addCityURL">
	<portlet:param name="pageAction" value="ADD_CITY_JSP" />
</portlet:renderURL>
<portlet:renderURL var="addCountryURL">
	<portlet:param name="pageAction" value="ADD_COUNTRY_JSP" />
</portlet:renderURL>
<portlet:actionURL name="createUserAccount" var="createUserAccountURL"/>
<portlet:actionURL name="filterResults" var="filterResultsURL"/>
<portlet:actionURL var="manageMyAdsURL" name="manageMyAds" />
<portlet:renderURL var="refreshURL" />

<liferay-ui:success key="ad-posted" message="ad-posted" />
<liferay-ui:success key="ad-edited" message="ad-edited" />
<liferay-ui:error key="some-problem" message="some-problem" />

<a href="<%= postAdPageURL %>">Post an AD</a>
<c:if test="<%= themeDisplay.isSignedIn() %>">
	<br /><br />
	<a href="<%= manageMyAdsURL %>">Manage my ads</a>
</c:if>
<c:if test="${showCreateNewAccount == 'Y'}">
	<br /><br />
	<liferay-ui:message key="do-you-want-to-create-an-account" />
	<br /><br />
	<a href="<%= PortalUtil.getCreateAccountURL(request, themeDisplay) %>"><liferay-ui:message key="create-new-account" /></a>
</c:if>
<br /><br />
<c:if test="<%= themeDisplay.isSignedIn() && (permissionChecker.isOmniadmin() || permissionChecker.isCompanyAdmin()) %>">
	<a href="<%= addCategoryURL %>">Add a new Category</a>
	<br /><br />
	<a href="<%= addCityURL %>">Add a new City</a>
	<br /><br />
	<a href="<%= addCountryURL %>">Add a new Country</a>
	<br /><br />
	<liferay-ui:success key="category-added" message="category-added" />
	<liferay-ui:success key="city-added" message="city-added" />
	<liferay-ui:success key="country-added" message="country-added" />
</c:if>
<liferay-ui:message key="list-of-ads" /><span class="control-label">.&nbsp;<liferay-ui:message key="filter-ads" /></span>
<br /><br />
<aui:form name="filterResults" method="post" action="<%= filterResultsURL %>">
	<c:if test="${not empty categoryList}">
			<aui:select name="adCategoryId" inlineField="true" inlineLabel="true">
				<c:forEach items="${categoryList}" var="adCategory">
					<c:choose>
						<c:when test="${ adCategory.categoryId == catIdFromFilter }">
							<aui:option value="${adCategory.categoryId}" selected="true">${adCategory.categoryName}</aui:option>
						</c:when>
						<c:otherwise>
							<aui:option value="${adCategory.categoryId}">${adCategory.categoryName}</aui:option>						
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</aui:select>
	</c:if> 
	<c:if test="${not empty cityList}">
			<aui:select name="adCityId" inlineField="true" inlineLabel="true">
				<c:forEach items="${cityList}" var="adCity">
					<c:choose>
						<c:when test="${ adCity.cityId == cityIdFromFilter }">
							<aui:option value="${adCity.cityId}" selected="true">${adCity.cityName}</aui:option>
						</c:when>
						<c:otherwise>
							<aui:option value="${adCity.cityId}">${adCity.cityName}</aui:option>						
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</aui:select>
	</c:if>
	<aui:select name="serviceType" inlineField="true" inlineLabel="true">
				<aui:option value="">Select</aui:option>
				<aui:option value="Offered">Offered</aui:option>
				<aui:option value="Wanted">Wanted</aui:option>
				<aui:option value="NA">N/A</aui:option>
	</aui:select>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<aui:button type="submit" value="Apply"/><aui:button type="button" value="Clear" cssClass="btn btn-primary" onClick="<%= refreshURL %>"/>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-ads" delta="10">
	<liferay-ui:search-container-results>
		<% 
			//List<AdListing> adList = (List<AdListing>)request.getAttribute("adList");
			List<AdListingCustomModel> adList = (List<AdListingCustomModel>)request.getAttribute("adList");
			//results = AdListingLocalServiceUtil.getAdListings(searchContainer.getStart(), searchContainer.getEnd());
			//total = AdListingLocalServiceUtil.getAdListingsCount();
			if(adList != null){
				results = ListUtil.subList(adList, searchContainer.getStart(), searchContainer.getEnd());
				total = adList.size();
			}else{
				results = Collections.EMPTY_LIST;
				total = 0;
			}
			pageContext.setAttribute("results", results);
			pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.models.AdListingCustomModel" keyProperty="adId" modelVar="adObject" bold="true">
		<portlet:renderURL var="listingDetailURL">
			<portlet:param name="pageAction" value="LISTING_DETAIL_JSP" />
			<portlet:param name="adDetailId" value="<%= String.valueOf(adObject.getAdId()) %>" />
		</portlet:renderURL>
		
		<liferay-ui:search-container-column-text name="ad-title" property="adTitle" href="<%= listingDetailURL %>"/>
		<liferay-ui:search-container-column-text name="ad-category-id" property="adCatName" />
		<liferay-ui:search-container-column-text name="service-type" property="serviceType" />
		<liferay-ui:search-container-column-text name="ad-city-id" property="adCityName" />
		<liferay-ui:search-container-column-text name="ad-created-date" property="createdDate" />
		<c:if test="${ userAdsListSize > 0 }">
			<liferay-ui:search-container-column-jsp name="manage-ads" path="/WEB-INF/jsp/admin_actions.jsp" align="right"/>
		</c:if>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<style type="text/css">
	#<portlet:namespace />adCategoryId{
		width:120px;
	}
	#<portlet:namespace />adCityId{
		width:120px;
	}
	#<portlet:namespace />serviceType{
		width:120px;
	}
</style>
