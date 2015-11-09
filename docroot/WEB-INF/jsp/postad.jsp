<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="init.jsp" %>

<c:if test="${signInNeeded == 'yes'}">
	<script>
		window.location.replace("/c/portal/login");
	</script>
</c:if>

<portlet:actionURL name="addAD" var="addADURL" />
<portlet:renderURL var="cancelURL" />

<liferay-ui:message key="post-ad-below" />
<br /><br />

<liferay-ui:error key="adTitle-mandatory" message="adTitle-mandatory" />
<liferay-ui:error key="adDescription-mandatory" message="adDescription-mandatory" />
<liferay-ui:error key="file-invalid" message="file-invalid" />
<liferay-ui:error key="invalid-user" message="invalid-user" />
<liferay-ui:error key="invalid-city" message="invalid-city" />
<liferay-ui:error key="adCategoryId-mandatory" message="adCategoryId-mandatory" />

<aui:form id="postADForm" method="post" action="<%= addADURL %>" enctype="multipart/form-data">
	<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
	/>
	<aui:row>
		<aui:column>
			<c:if test="${not empty categoryList}">
				<aui:select name="adCategoryId" label="Choose the right AD category">
					<aui:option value="0">Select</aui:option>
					<c:forEach items="${categoryList}" var="adCategory">
						<aui:option value="${adCategory.categoryId}">${adCategory.categoryName}</aui:option>
					</c:forEach>
				</aui:select>
			</c:if>
			<aui:input name="adTitle" required="true"/>
			<aui:input name="adDescription" type="textarea" required="true"/>
			<aui:select name="serviceType">
					<aui:option value="">Select the service type</aui:option>
					<aui:option value="Offered">Offered</aui:option>
					<aui:option value="Wanted">Wanted</aui:option>
					<aui:option value="NA">N/A</aui:option>
			</aui:select>
			<c:if test="${not empty countryList}">
				<aui:select name="adCountryId">
					<c:forEach items="${countryList}" var="adCountry">
						<aui:option value="${adCountry.countryId}">${adCountry.countryName}</aui:option>
					</c:forEach>
				</aui:select>
			</c:if>
			<!-- 
			<c:if test="${not empty cityList}">
				<aui:select name="adCityId">
					<c:forEach items="${cityList}" var="adCity">
						<aui:option value="${adCity.cityId}">${adCity.cityName}</aui:option>
					</c:forEach>
				</aui:select>
			</c:if>
			-->
			<liferay-ui:message key="ad-city-id"/>
			<br />
			<input type="text" onkeyup="autoComplete(this,this.form.adCityId,'value',true)" name="input1" placeholder="Type City Name">
			<br /><br />
			<select onchange="this.form.input1.value=this.adCityId[this.selectedIndex].text" name="adCityId">
				<c:forEach items="${cityList}" var="adCity">
					<option value="${adCity.cityId}">${adCity.cityName}</option>
				</c:forEach>
			</select>
			
		</aui:column>
		<aui:column>
			<aui:input type="file" name="documentFile" />
			<aui:input name="userName" value="${user.fullName}"/>
			<aui:input name="userEmail" value="${user.emailAddress }" />
			<aui:input name="userPhone" />
	 		
	 		<liferay-ui:message key="post-ad-tags" />
	 		<liferay-ui:asset-tags-selector
			    className="<%= AdListing.class.getName() %>"
			/>
			<aui:button-row>
				<aui:button type="submit" value="POST" />
			</aui:button-row>
		</aui:column>
	</aui:row>
</aui:form>