<%@page import="com.lia.ui.helper.LIAJavaUtil"%>
<%@page import="com.services.model.AdResponseTracker"%>
<%@ include file="init.jsp"%>


<c:choose>
	<c:when test="<%=!themeDisplay.isSignedIn()%>">
		<liferay-ui:message key="sign-in-ad-response" />
	</c:when>
	<c:otherwise>
		<c:if test="${ not empty adResponseTrackerList}">
			<liferay-ui:message key="list-of-ad-responses" />
		</c:if>
		<liferay-ui:search-container emptyResultsMessage="no-ad-responses" delta="10">
			<liferay-ui:search-container-results>
				<%
					//List<AdListing> adList = (List<AdListing>)request.getAttribute("adList");
									List<AdResponseTracker> adResponseTrackerList = (List<AdResponseTracker>) request
											.getAttribute("adResponseTrackerList");
									//results = AdListingLocalServiceUtil.getAdListings(searchContainer.getStart(), searchContainer.getEnd());
									//total = AdListingLocalServiceUtil.getAdListingsCount();
									if (adResponseTrackerList != null) {
										results = ListUtil.subList(
												adResponseTrackerList,
												searchContainer.getStart(),
												searchContainer.getEnd());
										total = adResponseTrackerList.size();
									} else {
										results = Collections.EMPTY_LIST;
										total = 0;
									}
									pageContext.setAttribute("results", results);
									pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row
				className="com.services.model.AdResponseTracker" keyProperty="artId"
				modelVar="artObject" bold="true">
				<portlet:renderURL var="listingDetailURL">
					<portlet:param name="pageAction" value="LISTING_DETAIL_JSP" />
					<portlet:param name="adDetailId"
						value="<%=String.valueOf(artObject.getAdId())%>" />
				</portlet:renderURL>
				<liferay-ui:search-container-column-text name="response-for"
					href="<%=listingDetailURL%>">
					<%
						AdListing adListing = null; 
						try{
							adListing = AdListingLocalServiceUtil.getAdListing(artObject.getAdId());
						}catch(Exception e){ }
						if(adListing != null){
							out.print(adListing.getAdTitle());
						}
					%>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="response-user-name"
					property="name" />
				<liferay-ui:search-container-column-text name="response-user-email"
					property="email" />
				<liferay-ui:search-container-column-text name="response-user-phone"
					property="phone" />
				<liferay-ui:search-container-column-text name="response-date">
					<%=LIAJavaUtil
										.getDateInMMDDYYYY(artObject
												.getCreatedDate())%>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="response-comments"
					property="comments" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</c:otherwise>
</c:choose>