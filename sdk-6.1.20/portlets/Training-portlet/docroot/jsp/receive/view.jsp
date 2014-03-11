<%@include file="/jsp/init.jsp" %>
This is the <b>YS Training Recieve</b> portlet.
<br />
<%
	String loggedInUserName = (String)renderRequest.getParameter("param1");
	String userName = (String)renderRequest.getParameter("userName");
	if(userName != null){
		%>
		Received UserName is : <%=userName %> , We are sending your password....
		<%}else{
			%>We're still waiting to get the UserName....<%
	}
%>
<br />
Logged In User name is : <%=loggedInUserName %>

