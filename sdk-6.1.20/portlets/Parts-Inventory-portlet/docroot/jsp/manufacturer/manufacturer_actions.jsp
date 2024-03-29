<%@ include file="/jsp/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Manufacturer manufacturer = (Manufacturer)row.getObject();

long groupId = manufacturer.getGroupId();
String name = Manufacturer.class.getName();
long manufacturerId = manufacturer.getManufId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/jsp/manufacturer/edit-manufacturer.jsp" />
		<portlet:param name="manufacturerId" value="<%= String.valueOf(manufacturerId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deleteManufacturer" var="deleteURL">
		<portlet:param name="manufacturerId" value="<%= String.valueOf(manufacturerId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</liferay-ui:icon-menu>