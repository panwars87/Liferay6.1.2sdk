<%@include file="/jsp/init.jsp"%>

<%
Parts part = null;
long partId = ParamUtil.getLong(request, "partId");
if (partId > 0) {
	part = PartsLocalServiceUtil.getParts(partId);
}
List<Manufacturer> manufacturers = ManufacturerLocalServiceUtil.getManufacturersByGroupId(scopeGroupId);
String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= part %>" model="<%= Parts.class %>" />
<portlet:renderURL var="viewPartURL" />
<portlet:actionURL name='<%= part == null ? "addPart" : "updatePart" %>' var="editPartURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewPartURL %>"
	title='<%= (part != null) ? part.getName(locale) : "New-Part" %>'
/>

<aui:form action="<%= editPartURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="partId" value='<%= part == null ? "" : part.getPartId() %>'/>
		<liferay-ui:error key="partname-required" message="partname-required"/>
		<aui:input name="name" />
		<liferay-ui:error key="partnumber-required" message="partnumber-required"/>
		<aui:input name="partNumber" />
		<liferay-ui:error key="orderdate-required" message="orderdate-required"/>
		<aui:input name="reorderDate" />
		<liferay-ui:error key="quantity-required" message="quantity-required"/>
		<aui:input name="quantity"/>
		<liferay-ui:error key="manufacturer-required" message="manufacturer-required"/>
		<aui:select name="manufId" showEmptyOption="<%= true %>" label="Manufacturer">
	 		<%
				for(Manufacturer manufacturer: manufacturers){
			%>
			<aui:option value="<%= manufacturer.getManufId() %>" selected="<%= part != null && manufacturer.getManufId() == part.getManufId() %>"><%= HtmlUtil.escape(manufacturer.getName())%></aui:option>
			<%
				}
			%>
		</aui:select>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewPartURL %>" />
	</aui:button-row>
</aui:form>