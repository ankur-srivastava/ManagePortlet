<%@ include file="init.jsp" %>

<portlet:actionURL name="makeCityPopular" var="makeCityPopular" />

<portlet:renderURL var="cancelURL" />

<liferay-ui:error key="city-name-mandatory" message="city-name-mandatory" />

<aui:form id="addCityForm" method="post" action="<%= makeCityPopular %>">
	<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
	/>
	
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
				
				<aui:select name="popularOptionId" label="Choose an option" inlineField="true" inlineLabel="true">
					<aui:option value="0">Select</aui:option>
					<aui:option value="1">Popular</aui:option>
					<aui:option value="2">Not Popular</aui:option>
				</aui:select>
				
				<aui:button-row>
							<aui:button type="submit" name="Submit"/>
				</aui:button-row>				
		</c:if>
</aui:form>