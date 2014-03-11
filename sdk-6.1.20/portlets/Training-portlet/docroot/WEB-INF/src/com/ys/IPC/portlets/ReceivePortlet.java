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

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author shashantp
 *
 */
public class ReceivePortlet extends MVCPortlet{

	/*public void sendPublicParam2(ActionRequest request,ActionResponse response) 
			throws IOException{
		System.out.println("Inside receive Action");
		String password = (String)request.getParameter("password");
		System.out.println("Generated password is : "+password);
		QName qname=new QName("http://liferay.com/events","password");
		response.setEvent(qname, password);
		super.sendRedirect(request, response);
	}*/
	
	@ProcessEvent(qname="{http://liferay.com/events}userName")
	public void processReceiveEvent(EventRequest request,EventResponse response){
		System.out.println("Inside Receive Processing Event");
		String userName=(String)request.getEvent().getValue();
		
		QName qname=new QName("http://liferay.com/events","password");
		response.setEvent(qname, "nishu@007");
		response.setRenderParameter("userName", userName);
	}
}
