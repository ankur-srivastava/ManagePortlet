<%@ include file="init.jsp" %>

<portlet:actionURL name="addCountry" var="addCountryURL" />

<portlet:renderURL var="cancelURL" />

<liferay-ui:message key="add-country" />
<br /><br />
<liferay-ui:error key="country-name-mandatory" message="country-name-mandatory" />

<aui:form id="addCountryForm" method="post" action="<%= addCountryURL %>">
	<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
	/>
	
	<aui:input name="countryName" />
	<aui:button-row>
				<aui:button type="submit" name="Submit"/>
	</aui:button-row>
</aui:form>