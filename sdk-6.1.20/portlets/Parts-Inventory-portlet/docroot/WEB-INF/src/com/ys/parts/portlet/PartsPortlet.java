package com.ys.parts.portlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.ys.parts.model.Parts;
import com.ys.parts.model.impl.PartsImpl;
import com.ys.parts.service.PartsLocalServiceUtil;
import com.ys.parts.util.PartValidator;

/**
 * Portlet implementation class PartsPortlet
 */
public class PartsPortlet extends MVCPortlet {

	/**
	 * Convenience method to create a Part object out of the request. Used
	 * by the Add / Edit methods.
	 *
	 */
	private Parts partFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		int orderDateMonth = ParamUtil.getInteger(request, "reorderDateMonth");
		int orderDateDay = ParamUtil.getInteger(request, "reorderDateDay");
		int orderDateYear = ParamUtil.getInteger(request, "reorderDateYear");

		Date orderDate = PortalUtil.getDate(orderDateMonth, orderDateDay, orderDateYear);
		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(request, "name");

		Parts part = new PartsImpl();
		
		part.setPartId(ParamUtil.getLong(request, "partId"));
		part.setNameMap(nameMap);
		part.setPartNumber(ParamUtil.getString(request, "partNumber"));
		part.setQuantity(ParamUtil.getInteger(request, "quantity"));
		part.setReorderDate(orderDate);
		part.setManufId(ParamUtil.getLong(request, "manufId"));
		part.setCompanyId(themeDisplay.getCompanyId());
		part.setGroupId(themeDisplay.getScopeGroupId());
		//part.set(themeDisplay.getUserId());

		return part;
	}
	
	/**
	 * Adds a new part to the database.
	 * 
	 */
	public void addPart(ActionRequest request, ActionResponse response)
		throws Exception {

		ArrayList<String> errors = new ArrayList<String>();

		Parts part = partFromRequest(request);

		if (PartValidator.validatePart(part, errors)) {
			PartsLocalServiceUtil.addPart(part);

			SessionMessages.add(request, "part-added");

			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("mvcPath", "/jsp/parts/edit-parts.jsp");
		}
	}

	/**
	 * Deletes a part from the database.
	 * 
	 */
	public void deletePart(ActionRequest request, ActionResponse response)
		throws Exception {

		long partId = ParamUtil.getLong(request, "partId");

		if (Validator.isNotNull(partId)) {
			PartsLocalServiceUtil.deleteParts(partId);

			SessionMessages.add(request, "part-deleted");

			sendRedirect(request, response);
		}
		else {
			SessionErrors.add(request, "error-deleting");
		}
	}

	/**
	 * Updates the database record of an existing part.
	 *
	 */
	public void updatePart(ActionRequest request, ActionResponse response)
		throws Exception {

		Parts part = partFromRequest(request);
		ArrayList<String> errors = new ArrayList<String>();
		if (PartValidator.validatePart(part, errors)) {
			PartsLocalServiceUtil.updateParts(part);
			SessionMessages.add(request, "part-updated");
			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/jsp/parts/edit-parts.jsp");			
		}
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(PartsPortlet.class);
	
}
