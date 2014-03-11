<%@include file="/jsp/init.jsp"%>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row>
	<portlet:renderURL var="addPartURL">
		<portlet:param name="mvcPath" value="/jsp/parts/edit-parts.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button value="add-part" onClick="<%=addPartURL %>"/>
</aui:button-row>


<liferay-ui:search-container
	emptyResultsMessage="part-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= PartsLocalServiceUtil.getPartsByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= PartsLocalServiceUtil.getPartsCountByGroupId(scopeGroupId) %>" />

	<liferay-ui:search-container-row
		className="com.ys.parts.model.Parts" keyProperty="partId"
		modelVar="part" escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text name="name"
			value="<%= part.getName() %>" />
		
		<liferay-ui:search-container-column-text name="part-number"
			property="partNumber" />

		<liferay-ui:search-container-column-text name="quantity"
			property="quantity" />

		<liferay-ui:search-container-column-text name="order-date"
			 value="<%= new SimpleDateFormat(\"MMMM dd, yyyy\").format(part.getReorderDate()) %>" />

		<%
			String manufacturerName = "";

					try {
						manufacturerName = HtmlUtil.escape(ManufacturerLocalServiceUtil
								.getManufacturer(part.getManufId())
								.getName());
					} catch (Exception ex) {
					}
		%>

		<liferay-ui:search-container-column-text name="manufacturer"
			value="<%= manufacturerName %>" />

		<liferay-ui:search-container-column-jsp align="right"
			path="/jsp/parts/part_actions.jsp" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>