/**
 * 
 */
package com.ys.IPC.portlets;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.ProcessEvent;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author shashantp
 *
 */
public class SenderPortlet extends MVCPortlet{

	public void sendPublicParam1(ActionRequest request,ActionResponse response) 
			throws IOException{
		System.out.println("Inside sender Action");
		String userName = (String)request.getParameter("userName");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String loggedInUser = themeDisplay.getUser().getFullName();
		QName qname = new QName("http://liferay.com/events","userName");
		response.setEvent(qname,userName);
		response.setRenderParameter("param1", loggedInUser);
		
		super.sendRedirect(request, response);
	}
	
	@ProcessEvent(qname="{http://liferay.com/events}password")
	public void processReceiveEvent(EventRequest request,EventResponse response){
		System.out.println("Inside Sender Processing Event");
		String password=(String)request.getEvent().getValue();
		response.setRenderParameter("password", password);
	}
	
}
