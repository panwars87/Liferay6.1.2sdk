/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ys.parts.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the parts local service. This utility wraps {@link com.ys.parts.service.impl.PartsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author shashantp
 * @see PartsLocalService
 * @see com.ys.parts.service.base.PartsLocalServiceBaseImpl
 * @see com.ys.parts.service.impl.PartsLocalServiceImpl
 * @generated
 */
public class PartsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ys.parts.service.impl.PartsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the parts to the database. Also notifies the appropriate model listeners.
	*
	* @param parts the parts
	* @return the parts that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts addParts(
		com.ys.parts.model.Parts parts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addParts(parts);
	}

	/**
	* Creates a new parts with the primary key. Does not add the parts to the database.
	*
	* @param partId the primary key for the new parts
	* @return the new parts
	*/
	public static com.ys.parts.model.Parts createParts(long partId) {
		return getService().createParts(partId);
	}

	/**
	* Deletes the parts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param partId the primary key of the parts
	* @return the parts that was removed
	* @throws PortalException if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts deleteParts(long partId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteParts(partId);
	}

	/**
	* Deletes the parts from the database. Also notifies the appropriate model listeners.
	*
	* @param parts the parts
	* @return the parts that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts deleteParts(
		com.ys.parts.model.Parts parts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteParts(parts);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.ys.parts.model.Parts fetchParts(long partId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchParts(partId);
	}

	/**
	* Returns the parts with the primary key.
	*
	* @param partId the primary key of the parts
	* @return the parts
	* @throws PortalException if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts getParts(long partId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getParts(partId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the partses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of partses
	* @param end the upper bound of the range of partses (not inclusive)
	* @return the range of partses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Parts> getPartses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartses(start, end);
	}

	/**
	* Returns the number of partses.
	*
	* @return the number of partses
	* @throws SystemException if a system exception occurred
	*/
	public static int getPartsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartsesCount();
	}

	/**
	* Updates the parts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param parts the parts
	* @return the parts that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts updateParts(
		com.ys.parts.model.Parts parts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateParts(parts);
	}

	/**
	* Updates the parts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param parts the parts
	* @param merge whether to merge the parts with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the parts that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts updateParts(
		com.ys.parts.model.Parts parts, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateParts(parts, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Adds the Part to the database incrementing the primary key
	*/
	public static com.ys.parts.model.Parts addPart(
		com.ys.parts.model.Parts part)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPart(part);
	}

	/**
	* Gets a list with all the Parts in a group
	*/
	public static java.util.List<com.ys.parts.model.Parts> getPartsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartsByGroupId(groupId);
	}

	/**
	* Gets a list with a range of Parts from a group
	*/
	public static java.util.List<com.ys.parts.model.Parts> getPartsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartsByGroupId(groupId, start, end);
	}

	/**
	* Gets the number of Parts in a group
	*/
	public static int getPartsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartsCountByGroupId(groupId);
	}

	/**
	* Gets a list of Parts from a Manufacturer
	*/
	public static java.util.List<com.ys.parts.model.Parts> getPartsbyManufacturer(
		long manufacturerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPartsbyManufacturer(manufacturerId, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PartsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PartsLocalService.class.getName());

			if (invokableLocalService instanceof PartsLocalService) {
				_service = (PartsLocalService)invokableLocalService;
			}
			else {
				_service = new PartsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PartsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(PartsLocalService service) {
	}

	private static PartsLocalService _service;
}