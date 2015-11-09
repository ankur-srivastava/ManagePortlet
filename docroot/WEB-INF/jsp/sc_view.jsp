<%@page import="com.services.model.AdCategory"%>
<%@ include file="init.jsp" %>

<portlet:actionURL name="refineResults" var="refineResultsURL"/>
<portlet:renderURL var="refreshURL" />

<% 
	List<AdCategory> categoryList = null;
	long catIdFromFilter = 0;
	if(request.getAttribute("categoryList") != null){
		categoryList=(List<AdCategory>)request.getAttribute("categoryList");
	}
	if(request.getAttribute("catIdFromFilter") != null){
		catIdFromFilter=(Long)request.getAttribute("catIdFromFilter");
	}
%>

<liferay-ui:error key="select-a-filter" message="select-a-filter" />
<aui:row>
		<aui:column>
			<div class="filterFont" align="left"><b>Category</b></div>
			<br />
			<aui:form name="filterResults" method="post">
				<!--
				<c:if test="${not empty categoryList}">
							<c:forEach items="${categoryList}" var="adCategory">
								<portlet:actionURL name="postEvent" var="postEventURL">
									<portlet:param name="categoryId" value="${adCategory.categoryId}"/>
								</portlet:actionURL>
								<c:choose>
									<c:when test="${ adCategory.categoryId == catIdFromFilter }">
										<a href="">${adCategory.categoryName}</a>
									</c:when>
									<c:otherwise>
										<a href="/${adCategory.categoryName}">${adCategory.categoryName}</a>						
									</c:otherwise>
								</c:choose>
								<br /><br />
							</c:forEach>
				</c:if> 
				-->
				<% 
					if(categoryList != null && categoryList.size() > 0){
						for(AdCategory category : categoryList){
				%>
							<a href="<%= (category.getCategoryId() != catIdFromFilter) ? ("/"+category.getCategoryName().toLowerCase()) : ""%>"><%= category.getCategoryName() %></a>
							<br /><br />
				<%										
						}
					}	
				%>
			</aui:form>
		</aui:column>
		<aui:column>
			&nbsp;
		</aui:column>	
		<aui:column>
			<div class="filterFont" align="center"><b>Apply Filter</b></div>
			<br />
			<aui:form name="refineResults" method="post" action="<%= refineResultsURL %>">
				<c:if test="${not empty categoryList}">
						<aui:select name="adCategoryId" label="">
							<aui:option value="0">Select Category</aui:option>
							<c:forEach items="${categoryList}" var="adCategory">
								<c:choose>
									<c:when test="${ adCategory.categoryId == catIdFromFilter }">
										<aui:option value="${adCategory.categoryId}" selected="true">${adCategory.categoryName}</aui:option>
									</c:when>
									<c:otherwise>
										<aui:option value="${adCategory.categoryId}">${adCategory.categoryName}</aui:option>						
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</aui:select>
				</c:if>
				<c:if test="${not empty cityList}">
						<aui:select name="adCityId" label="">
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
				</c:if>
				<aui:select name="serviceType" label="">
							<aui:option value="Offered">Offered</aui:option>
							<aui:option value="Wanted">Wanted</aui:option>
				</aui:select>
				<aui:button type="submit" value="Apply"/><aui:button type="button" value="Reset" cssClass="btn btn-primary" onClick="<%= refreshURL %>"/>
			</aui:form>
		</aui:column>
</aui:row>
<style>
	.aui .control-group {
	    margin-bottom: 0px;
	}
	.aui select {
	    width: 130px;
	}
	.filterFont {
	    font-family: "Trocchi,sans-serif";
	    font-size: 14px;
	}
</style>