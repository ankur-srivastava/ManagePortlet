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
<portlet:renderURL var="makeCityPopular">
	<portlet:param name="pageAction" value="MAKE_CITY_POPULAR_JSP" />
</portlet:renderURL>
<portlet:actionURL name="createUserAccount" var="createUserAccountURL"/>
<portlet:actionURL name="filterResults" var="filterResultsURL"/>
<portlet:actionURL var="manageMyAdsURL" name="manageMyAds" />
<portlet:renderURL var="refreshURL" />
<portlet:actionURL var="searchAdsURL" name="searchAds" />
<portlet:actionURL name="refineResultsByCategory" var="refineResultsByCategory"/>
<portlet:actionURL name="refineResultsByCity" var="refineResultsByCity"/>

<% 
	List<AdCity> popularCityList = null;
	List<AdCategory> categoryList = null;
	
	if(request.getAttribute("popularCityList") != null){
		popularCityList = (List<AdCity>)request.getAttribute("popularCityList");
	}
	if(request.getAttribute("categoryList") != null){
		categoryList = (List<AdCategory>)request.getAttribute("categoryList");
	}
%>

<aui:form id="postADForm" method="post" action="<%= searchAdsURL %>">
	<aui:input name="groupId"
	    type="hidden"
	    value="<%= themeDisplay.getScopeGroupId() %>" />
	<!--  
	<aui:input inlineField="<%= true %>" id="keywords"
		      label=""
		      name="keywords"
		      title="search-entries"
		      type="text" placeholder="Search for Apartment, Car, Phone, Job !!" />
	-->	          
	<input type="text" name="keywords" size="30px" placeholder="Search for anything !!" style="margin:5px;"/>  
	<aui:button type="submit" value="search" />    
</aui:form>

<div align="center"><b><font size="4px"><a href="<%= postAdPageURL %>">Post a new AD</a></font></b></div>

<!-- Popular City -->
<c:if test="${ !cityPageClick }">
	<c:if test="${ not empty popularCityList }">
		<br /><br />
		Popular Cities &nbsp;&nbsp;
		<% 
			if(popularCityList != null && popularCityList.size() > 0){
				for(AdCity city : popularCityList){
		%>
					<a href="<%= city.getCityName().toLowerCase() %>"><%= city.getCityName() %></a> &nbsp;&nbsp;
		<%			
				}
			}
		%>
	</c:if>
</c:if>
<!-- Ends -->

<!-- Show City Filter -->
<c:if test="${ categoryPageClick }">
	<liferay-ui:error key="select-a-filter" message="select-a-filter" />
	<liferay-ui:success key="city-updated" message="city-updated" />
	<aui:form name="refineResults" method="post" action="<%= refineResultsByCity %>">
		<c:if test="${not empty cityList}">
				<br /><br />
				<aui:select name="adCityId" label="Filter by City" inlineField="true" inlineLabel="true">
					<aui:option value="0">Select City</aui:option>
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
				<aui:input type="hidden" name="selectedCategoryId" value="${ selectedCategoryId }"/>
				<aui:button type="submit" value="Apply"/><aui:button type="button" value="Reset" cssClass="btn btn-primary" onClick="<%= refreshURL %>"/>
		</c:if>
	</aui:form>
</c:if>			
<!-- Ends -->

<liferay-ui:success key="ad-posted" message="ad-posted" />
<liferay-ui:success key="ad-edited" message="ad-edited" />
<liferay-ui:error key="some-problem" message="some-problem" />

<c:if test="<%= themeDisplay.isSignedIn() %>">
	<br /><br />
	<a href="<%= manageMyAdsURL %>"><liferay-ui:message key="manage-my-ads" /></a>
	<br /><br />
</c:if>
<c:if test="<%= themeDisplay.isSignedIn() && permissionChecker.isOmniadmin() ||  permissionChecker.isCompanyAdmin() %>">
	<a href="<%= addCategoryURL %>">Add a new Category</a>
	<br /><br />
	<a href="<%= addCityURL %>">Add a new City</a>
	<br /><br />
	<a href="<%= addCountryURL %>">Add a new Country</a>
	<br /><br />
	<a href="<%= makeCityPopular %>">Make a city Popular</a>
	<br /><br />
	<liferay-ui:success key="category-added" message="category-added" />
	<liferay-ui:success key="city-added" message="city-added" />
	<liferay-ui:success key="country-added" message="country-added" />
</c:if>
<% 
	int userAdsListSize = 0;	
	if(request.getAttribute("userAdsListSize") != null){
		userAdsListSize = (Integer)request.getAttribute("userAdsListSize");
	}
%>
<!-- Show Category Filter -->
<c:if test="${ cityPageClick }">
	<liferay-ui:error key="select-a-filter" message="select-a-filter" />
	<aui:form name="refineResults" method="post" action="<%= refineResultsByCategory %>">
		<c:if test="${not empty categoryList}">
				<br /><br />
				<aui:select name="adCategoryId" label="Filter by Category" inlineField="true" inlineLabel="true">
					<aui:option value="0">Select Category</aui:option>
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
				<aui:input type="hidden" name="selectedCityId" value="${ selectedCityId }"/>
				<aui:button type="submit" value="Apply"/><aui:button type="button" value="Reset" cssClass="btn btn-primary" onClick="<%= refreshURL %>"/>
		</c:if>
	</aui:form>
</c:if>			
<!-- Ends -->
<c:choose>
	<c:when test="${ viewall }">
		<c:if test="${not empty categoryList}">
			<% 
				if(categoryList != null && categoryList.size() > 0){
					for(AdCategory category : categoryList){
			%>
					<br /><br />
					<div class="categoryBlock">
					<div class="categoryName">
					
			<%			
						out.print(category.getCategoryName());
			%>
					
					</div>
				
			<%
						List<AdListingCustomModel> customAdListForCategory = ActionUtil.getLimitedAdsByCategory(category.getCategoryId(), themeDisplay, renderRequest);
						if(customAdListForCategory != null && customAdListForCategory.size() > 0){
							for(AdListingCustomModel adForCategory : customAdListForCategory){
			%>
								<portlet:renderURL var="listingDetailURL">
									<portlet:param name="pageAction" value="LISTING_DETAIL_JSP" />
									<portlet:param name="adDetailId" value="<%= String.valueOf(adForCategory.getAdId()) %>" />
								</portlet:renderURL>
								<div class='adSection'>
										<span class="adImage">	
											<c:choose>
												<c:when test="<%= Validator.isNotNull(adForCategory.getThumbnailImageURL()) %>">
															<liferay-ui:icon id="adThumbImageStyle" src="<%= adForCategory.getThumbnailImageURL() %>" 
																cssClass="adThumbImageStyle" alt="<%= adForCategory.getImageTitle() %>" srcHover="<%= adForCategory.getImageTitle() %>" />
												</c:when>
											</c:choose>
										</span>
										<span class="adText">										
											<a href="<%= listingDetailURL %>">
													<%= adForCategory.getAdTitle() %> 
													<br />
													&nbsp;&nbsp;in&nbsp;<b><%= adForCategory.getAdCityName() %></b>&nbsp;from&nbsp;<b><%= adForCategory.getCreatedDate() %></b>
											</a>
										</span>
								</div>	
			<%					
							}
						}
			%>
					<div class="viewMore">
						<a href="<%= "/"+category.getCategoryName().toLowerCase() %>">View More in &nbsp;<%= category.getCategoryName() %></a>
					</div>
					</div>
			<%			
					}
				}
			%>
		</c:if>
	</c:when>
	<c:otherwise>
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
			<liferay-ui:search-container-column-text href="<%= listingDetailURL %>">
					<div class='adSection'>
						<span class="adImage">	
							<c:choose>
								<c:when test="<%= Validator.isNotNull(adObject.getThumbnailImageURL()) %>">
											<liferay-ui:icon id="adThumbImageStyle" src="<%= adObject.getThumbnailImageURL() %>" cssClass="adThumbImageStyle" alt="<%= adObject.getImageTitle() %>" srcHover="<%= adObject.getImageTitle() %>" />
								</c:when>
							</c:choose>
						</span>
						<span class="adText">
								<%= adObject.getAdTitle() %> <br />
								in&nbsp;<b><%= adObject.getAdCityName() %></b>&nbsp;from&nbsp;<b><%= adObject.getCreatedDate() %></b>
						</span>
					</div>		 
			</liferay-ui:search-container-column-text>
			<c:if test="<%= permissionChecker.isOmniadmin() ||  permissionChecker.isCompanyAdmin() || (userAdsListSize > 0) %>">
				<liferay-ui:search-container-column-jsp name="manage-ads" path="/WEB-INF/jsp/admin_actions.jsp" align="right"/>
			</c:if>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>		
	</c:otherwise>
</c:choose>

<c:if test="${ viewall }">
	<div align="center"><b><font size="4px"><a href="<%= AlConstants.VIEW_ALL_URL %>">View All</a></font></b></div>
</c:if>
<style>
	.categoryBlock{
		border:1px solid #FAFAFA;
		padding:20px;
	}
	.iconDetails {
		margin-left:2%;
		float:left; 
		padding-right: 2%;
	} 
		
	.container2 {
	    width:100%;
	    height:auto;
	    padding:2px;
	    margin:2px;
	}
	.adSection{
		margin-top:60px;
		margin-bottom:10px;
		border:0px dotted #CD5C5C;
		padding:5px;
		background:#FAFAFA;
	}
	.adImage{
		margin-right:5px;
		position:relative;
		float:left;
	}
	.adText{
		line-height:2.5;
		margin-left:5px;
		padding:5px;
	}
	.categoryName{
		font-weight: bold;
		font-size:1.3em;
		margin-bottom:10px;
	}
	.viewMore{
		margin-top: 0px;
	}
</style>