/**
 * 
 */
package com.ys.training.Action;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.liferay.util.bridges.mvc.ActionCommand;

/**
 * @author shashantp
 *
 */
public class TestingActionCommand implements ActionCommand{
	
	@Override
	public boolean processCommand(PortletRequest portletRequest,
			PortletResponse portletResponse) throws PortletException {
		// TODO Auto-generated method stub
		System.out.println("Inside multiple action tesk....");
		return true;
	}
}
