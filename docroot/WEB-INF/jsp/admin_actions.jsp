<%@page import="com.models.AdListingCustomModel"%>
<%@page import="com.services.model.AdListing"%>
<%@ include file="init.jsp" %>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	//AdListing adListing = (AdListing)row.getObject();
	AdListingCustomModel adListingCustomModel = (AdListingCustomModel)row.getObject();
	AdListing adListing = AdListingLocalServiceUtil.getAdListing(adListingCustomModel.getAdId());
	long groupId = themeDisplay.getLayout().getGroupId();
	String name = AdListing.class.getName();
	String primKey = String.valueOf(adListing.getPrimaryKey());
%>
<liferay-ui:icon-menu>
	<c:if test="<%= permissionChecker.isOmniadmin() || permissionChecker.isCompanyAdmin() || adListing.getUserId() == themeDisplay.getUserId() %>">
			<portlet:actionURL name="editAd" var="editURL">
				<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
			</portlet:actionURL>
			<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>" />
	</c:if>
	<c:if test="<%= permissionChecker.isOmniadmin() || permissionChecker.isCompanyAdmin() ||  adListing.getUserId() == themeDisplay.getUserId() %>">
			<portlet:actionURL name="deleteAd" var="deleteURL">
				<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
			</portlet:actionURL>
		`	<liferay-ui:icon image="delete" message="Delete" url="<%= deleteURL.toString() %>" />
	</c:if>
	<c:if test="<%= permissionChecker.isOmniadmin() || permissionChecker.isCompanyAdmin()  %>">
			<liferay-security:permissionsURL 
				 modelResource="<%= AdListing.class.getName() %>"
				 modelResourceDescription="<%= adListing.getAdTitle() %>"
				 resourcePrimKey= "<%= primKey %>"
				 var="permissionsURL"
			/>
		`	<liferay-ui:icon image="permissions" url="<%= permissionsURL.toString() %>" />
	</c:if>
</liferay-ui:icon-menu>