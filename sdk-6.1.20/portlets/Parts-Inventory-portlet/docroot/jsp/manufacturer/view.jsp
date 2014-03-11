<%@include file="/jsp/init.jsp"%>

<liferay-ui:success key="manufacturer-added" message="manufacturer-added-successfully" />
<liferay-ui:success key="manufacturer-updated" message="manufacturer-updated-successfully" />
<liferay-ui:success key="manufacturer-deleted" message="manufacturer-deleted-successfully" />

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);	
%>
 
<aui:button-row>
	<portlet:renderURL var="addManufacturerURL">
		<portlet:param name="mvcPath" value="/jsp/manufacturer/edit-manufacturer.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button value="add-manufacturer" onClick="<%= addManufacturerURL.toString() %>"/>
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="manufacturer-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= ManufacturerLocalServiceUtil.getManufacturersByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ManufacturerLocalServiceUtil.getManufacturersCountByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row
		className="com.ys.parts.model.Manufacturer"
		keyProperty="manufId"
		modelVar="manufacturer" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= manufacturer.getName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="email-address"
			property="emailAddress"
		/>

		<liferay-ui:search-container-column-text
			name="phone-number"
			property="phoneNumber"
		/>

		<liferay-ui:search-container-column-text
			name="website"
			property="website"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/jsp/manufacturer/manufacturer_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>