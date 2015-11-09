<%@ include file="init.jsp" %>

<portlet:actionURL name="addCategory" var="addCategoryURL" />

<portlet:renderURL var="cancelURL" />

<liferay-ui:message key="add-category" />
<br /><br />
<liferay-ui:error key="category-name-mandatory" message="category-name-mandatory" />

<aui:form id="addCategoryForm" method="post" action="<%= addCategoryURL %>">
	<liferay-ui:header
      backURL="<%= cancelURL %>"
      title="back-to-main"
	/>
	
	<aui:input name="categoryName" />
	<aui:button-row>
				<aui:button type="submit" name="Submit"/>
	</aui:button-row>
</aui:form>