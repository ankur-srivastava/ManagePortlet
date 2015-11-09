<%@ include file="init.jsp" %>
<portlet:actionURL name="migrateNewFiles" var="migrateNewFiles" />
<b><liferay-ui:message key="document-migration" /></b>
<br /><br />
<liferay-ui:error key="file-invalid" message="file-invalid" />
<liferay-ui:error key="problem-while-deleting-docs" message="problem-while-deleting-docs" />
<liferay-ui:success key="documents-migrated-success" message="documents-migrated-success" />
<liferay-ui:success key="documents-deleted-success" message="documents-deleted-success" />

<aui:form id="migrateForm" method="post" action="<%= migrateNewFiles %>" enctype="multipart/form-data">
	<aui:input type="file" name="metaDocumentFile" required="true" />
	<aui:button-row>
		<aui:button type="submit" value="run-utility" />
	</aui:button-row>
</aui:form>