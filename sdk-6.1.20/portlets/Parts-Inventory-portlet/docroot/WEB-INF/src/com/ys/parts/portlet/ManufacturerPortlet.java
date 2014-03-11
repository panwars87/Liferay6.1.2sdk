package com.ys.parts.portlet;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.ys.parts.model.Manufacturer;
import com.ys.parts.model.impl.ManufacturerImpl;
import com.ys.parts.service.ManufacturerLocalServiceUtil;
import com.ys.parts.util.ManufacturerValidator;

/**
 * Portlet implementation class ManufacturerPortlet
 */
public class ManufacturerPortlet extends MVCPortlet {
 
	/**
	 * Adds a new manufacturer to the database
	 * 
	 */
	public void addManufacturer(ActionRequest request, ActionResponse response)
		throws Exception {

		Manufacturer manufacturer = manufacturerFromRequest(request);
		ArrayList<String> errors = new ArrayList<String>();
		if (ManufacturerValidator.validateManufacturer(manufacturer, errors)) {
			ManufacturerLocalServiceUtil.addManufacturer(manufacturer);
			SessionMessages.add(request, "manufacturer-added");
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/jsp/manufacturer/edit-manufacturer.jsp");
		}
	}
	
	/**
	 * Convenience method to create a Manufacturer object out of the request. Used
	 * by the Add / Edit methods.
	 *
	 */
	private Manufacturer manufacturerFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		ManufacturerImpl manufacturer = new ManufacturerImpl();

		manufacturer.setManufId(ParamUtil.getLong(request, "manufacturerId"));
		manufacturer.setName(ParamUtil.getString(request, "name"));
		manufacturer.setEmailAddress(ParamUtil.getString(request, "emailAddress"));
		manufacturer.setWebsite(ParamUtil.getString(request, "website"));
		manufacturer.setPhoneNumber(ParamUtil.getString(request, "phoneNumber"));
		manufacturer.setCompanyId(themeDisplay.getCompanyId());
		manufacturer.setGroupId(themeDisplay.getScopeGroupId());

		return manufacturer;
	}
	
	/**
	 * Updates the database record of an existing manufacturer.
	 *
	 */
	public void updateManufacturer(ActionRequest request, ActionResponse response)
		throws Exception {
		Manufacturer manufacturer = manufacturerFromRequest(request);
		ArrayList<String> errors = new ArrayList<String>();
		if (ManufacturerValidator.validateManufacturer(manufacturer, errors)) {
			ManufacturerLocalServiceUtil.updateManufacturer(manufacturer);
			SessionMessages.add(request, "manufacturer-updated");
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/jsp/manufacturer/edit-manufacturer.jsp");
		}
	}

	/**
	 * Deletes a manufacturer from the database.
	 * 
	 */
	public void deleteManufacturer(ActionRequest request,
			ActionResponse response) throws Exception {
		long manufacturerId = ParamUtil.getLong(request, "manufacturerId");
			if (Validator.isNotNull(manufacturerId)) {
				ManufacturerLocalServiceUtil.deleteManufacturer(manufacturerId);
				SessionMessages.add(request, "manufacturer-deleted");
				sendRedirect(request, response);
			}
		 else {
			SessionErrors.add(request, "null-manufacturer-error");
			sendRedirect(request, response);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(ManufacturerPortlet.class);
	
}
