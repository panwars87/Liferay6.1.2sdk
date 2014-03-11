<%@page import="javax.portlet.ActionRequest"%>
<%@include file="/jsp/init.jsp" %>

This is the <b>YS Training Sender</b> portlet.

<portlet:actionURL name="sendPublicParam1" var="sendPublicParam1URL"/>
<br />
<%
	String password = (String)renderRequest.getParameter("password");
	if(password != null){
		%>
		Received Password is : <%=password %>
		<%}else{
			%>We're still waiting to get the Password....<%
	}
%>
<br />
<br />
<aui:form action="${sendPublicParam1URL}">
	<aui:input name="userName" type="text"></aui:input>
	<aui:button-row>
		<aui:button value="Submit" type="submit"></aui:button>	
	</aui:button-row>
</aui:form>