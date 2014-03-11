<%@include file="/jsp/init.jsp" %>

This is the <b>Multiple Actions</b> portlet in View mode.

<portlet:actionURL var="actionCommandURL">
	<portlet:param name="<%=ActionRequest.ACTION_NAME %>" value="Testing"/>
</portlet:actionURL>
<!-- 
<aui:form action="" method="post" name="fmAc1">
   <aui:button name="actionCommandButton" value="actionCommand" onClick="<%= actionCommandURL %>"></aui:button>
</aui:form>
 -->
<form action="<%=actionCommandURL %>"  method="post" name='<portlet:namespace/>fmAc1'>
	<input type="submit" value="Submit" />
</form>
