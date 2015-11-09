<%@ include file="init.jsp" %>

<portlet:actionURL name="addCity" var="addCityURL" />

<portlet:renderURL var="cancelURL" />

<liferay-ui:message key="add-city" />
<br /><br />
<liferay-ui:error key="city-name-mandatory" message="city-name-mandatory" />

<aui:form id="addCityForm" method="post" action="<%= addCityURL %>">
	<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
	/>
	
	<aui:input name="cityName" />
	<aui:button-row>
				<aui:button type="submit" name="Submit"/>
	</aui:button-row>
</aui:form>