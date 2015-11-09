<%@ include file="init.jsp" %>

<portlet:actionURL name="addAD" var="addADURL" />
<portlet:renderURL var="cancelURL" />

<liferay-ui:error key="adTitle-mandatory" message="adTitle-mandatory" />
<liferay-ui:error key="adDescription-mandatory" message="adDescription-mandatory" />

<aui:form id="updateADForm" method="post" action="<%= addADURL %>" enctype="multipart/form-data">
	<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
	/>
	<aui:row>
		<aui:column>
			<aui:input name="adTitle" value="${adListingObj.adTitle}" required="true"/>
			<aui:input name="adDescription" value="${adListingObj.adDescription}" type="textarea" required="true"/>
			<c:if test="${not empty categoryList}">
				<aui:select name="adCategoryId">
					<c:forEach items="${categoryList}" var="adCategory">
						<c:choose>
							<c:when test="${ adCategory.categoryId == adListingObj.adCatId }">
								<aui:option value="${adCategory.categoryId}" selected="true">${adCategory.categoryName}</aui:option>
							</c:when>
							<c:otherwise>
								<aui:option value="${adCategory.categoryId}">${adCategory.categoryName}</aui:option>						
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</aui:select>
			</c:if>
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
			
			<c:if test="${not empty cityList}">
				<liferay-ui:message key="ad-city-id"/>
				<br />
				<input type="text" onkeyup="autoComplete(this,this.form.adCityId,'value',true)" name="input1" placeholder="Type City Name">
				<br /><br />
				<select onchange="this.form.input1.value=this.adCityId[this.selectedIndex].text" name="adCityId">
					<c:forEach items="${cityList}" var="adCity">
						<c:choose>
							<c:when test="${ adCity.cityId == adListingObj.adCityId }">
								<option value="${adCity.cityId}" selected="selected">${adCity.cityName}</option>
							</c:when>
							<c:otherwise>
								<option value="${adCity.cityId}">${adCity.cityName}</option>						
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</c:if>
			
		</aui:column>
		<aui:column>
			<aui:input type="file" name="documentFile" />
			<aui:input name="userName" value="${adListingObj.adUserName}"/>
			<aui:input name="userEmail" value="${adListingObj.adUserEmail }" />
			<aui:input name="userPhone" value="${adListingObj.adUserPhone}" />
			<aui:input type="hidden" name="editAdId" value="${ adListingObj.adId }" />
			<liferay-ui:asset-categories-selector 
	 			className="<%= AdListing.class.getName() %>"
	 			classPK="${ adListingObj.adId }"
	 		/>
	 		<br /><br />
	 		<liferay-ui:message key="post-ad-tags" />
	 		<liferay-ui:asset-tags-selector
			    className="<%= AdListing.class.getName() %>"
			    classPK="${ adListingObj.adId }"
			/>
			<br /><br />
			<aui:button-row>
						<aui:button type="submit" name="Submit"/>
			</aui:button-row>
		</aui:column>
	</aui:row>
</aui:form>