<%@page import="com.lia.ui.helper.LIAJavaUtil"%>
<%@page import="com.services.service.AdStatsTrackerLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<portlet:actionURL name="contactUser" var="contactUserURL"/>
<portlet:renderURL var="cancelURL" />
<portlet:resourceURL var="captchaURL"/>

<liferay-ui:success key="response-sent-successfully" message="response-sent-successfully" />
<liferay-ui:error key="user-name-required" message="user-name-required" />
<liferay-ui:error key="user-email-or-phone-required" message="user-email-or-phone-required" />
<liferay-ui:error key="captcha-mandatory" message="captcha-mandatory" />
<liferay-ui:error key="invalid-captha" message="invalid-captha" />
<liferay-ui:error key="user-email-invalid" message="user-email-invalid" />

<% 
	//Increment
	AdListingCustomModel adListing=null;
	try{
		adListing = (AdListingCustomModel)request.getAttribute("adListingObj");
		AdStatsTrackerLocalServiceUtil.updateAdCount(adListing.getAdId());
	}catch(Exception e){
		e.printStackTrace();
	}
%>

<aui:form id="contactUserForm" method="post" action="<%= contactUserURL %>">
	<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
	/>
	<div align="center"><liferay-ui:message key="ad-views"/> ${totalViews} times</div>
	<br />
	<div align="center"><b>${ adListingObj.adTitle }</b></div>
	<br />
	<b><liferay-ui:message key="more-deatils"/></b><br />
	<%= LIAJavaUtil.getNewLineFormatting(adListing.getAdDescription()) %>
	<c:if test="${not empty imageURL}">
		<br /><br />
		<!--  
			<div align="center"><img src="${imageURL}" width="400px" height="400px" /></div>
			<br /><br />
		-->
		<div align="center"><liferay-ui:icon id="adImageStyle" src="${imageURL}" cssClass="adImageStyle" alt="${imageTitle}" srcHover="${imageTitle}"/></div>
	</c:if>
	<br /><br />
	<b><liferay-ui:message key="ad-category"/></b> &nbsp; : &nbsp; ${ adListingObj.adCatName }
	<br /><br />
	<b><liferay-ui:message key="service-type"/></b>&nbsp; : &nbsp;${ adListingObj.serviceType }
	<br /><br />
	<b><liferay-ui:message key="posted-on"/></b>&nbsp; : &nbsp;${ adListingObj.createdDate }
	<br /><br />
	<b><liferay-ui:message key="ad-keywords"/></b>&nbsp; : &nbsp;<liferay-ui:asset-tags-summary className="<%= AdListing.class.getName() %>" classPK="${adListingObj.adId}"  />
	<br /><br />
	<b><liferay-ui:message key="contact-user-name"/></b>&nbsp; : &nbsp;${ adListingObj.userName }
	<br /><br />
	<b><liferay-ui:message key="contact-user-phone"/></b>&nbsp; : &nbsp;${ adListingObj.userPhone }
	<br /><br />
	<b><liferay-ui:message key="contact-user-email"/></b>&nbsp; : &nbsp;${ adListingObj.userEmail }
	<br /><br />
	<b><liferay-ui:message key="contact-this-user"/></b>
	<br /><br />
	<aui:row>
		<aui:column>
			<aui:input name="userName" value="${ user.fullName }"/>
			<c:choose>
				<c:when test="<%= themeDisplay.isSignedIn() %>">
					<aui:input name="userEmail" value="${ user.emailAddress }" required="true" />
				</c:when>
				<c:otherwise>
					<aui:input name="userEmail" required="true" />
				</c:otherwise>
			</c:choose>
			<aui:input name="userPhone" />
		</aui:column>
		<aui:column>
			<aui:input name="comments" type="textarea"/>
			
			<liferay-ui:captcha url="<%= captchaURL %>"/>
			<aui:input type="hidden" name="adDetailId" value="${ adListingObj.adId }" />
		</aui:column>
	</aui:row>
	<aui:button-row>
				<aui:button type="submit" value="Send Response"/>
	</aui:button-row>
</aui:form>