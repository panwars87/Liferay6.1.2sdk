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
 * The utility for the manufacturer local service. This utility wraps {@link com.ys.parts.service.impl.ManufacturerLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author shashantp
 * @see ManufacturerLocalService
 * @see com.ys.parts.service.base.ManufacturerLocalServiceBaseImpl
 * @see com.ys.parts.service.impl.ManufacturerLocalServiceImpl
 * @generated
 */
public class ManufacturerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ys.parts.service.impl.ManufacturerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the manufacturer to the database. Also notifies the appropriate model listeners.
	*
	* @param manufacturer the manufacturer
	* @return the manufacturer that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer addManufacturer(
		com.ys.parts.model.Manufacturer manufacturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addManufacturer(manufacturer);
	}

	/**
	* Creates a new manufacturer with the primary key. Does not add the manufacturer to the database.
	*
	* @param manufId the primary key for the new manufacturer
	* @return the new manufacturer
	*/
	public static com.ys.parts.model.Manufacturer createManufacturer(
		long manufId) {
		return getService().createManufacturer(manufId);
	}

	/**
	* Deletes the manufacturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param manufId the primary key of the manufacturer
	* @return the manufacturer that was removed
	* @throws PortalException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer deleteManufacturer(
		long manufId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteManufacturer(manufId);
	}

	/**
	* Deletes the manufacturer from the database. Also notifies the appropriate model listeners.
	*
	* @param manufacturer the manufacturer
	* @return the manufacturer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer deleteManufacturer(
		com.ys.parts.model.Manufacturer manufacturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteManufacturer(manufacturer);
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

	public static com.ys.parts.model.Manufacturer fetchManufacturer(
		long manufId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchManufacturer(manufId);
	}

	/**
	* Returns the manufacturer with the primary key.
	*
	* @param manufId the primary key of the manufacturer
	* @return the manufacturer
	* @throws PortalException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer getManufacturer(long manufId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getManufacturer(manufId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the manufacturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @return the range of manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Manufacturer> getManufacturers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getManufacturers(start, end);
	}

	/**
	* Returns the number of manufacturers.
	*
	* @return the number of manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public static int getManufacturersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getManufacturersCount();
	}

	/**
	* Updates the manufacturer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param manufacturer the manufacturer
	* @return the manufacturer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer updateManufacturer(
		com.ys.parts.model.Manufacturer manufacturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateManufacturer(manufacturer);
	}

	/**
	* Updates the manufacturer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param manufacturer the manufacturer
	* @param merge whether to merge the manufacturer with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the manufacturer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer updateManufacturer(
		com.ys.parts.model.Manufacturer manufacturer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateManufacturer(manufacturer, merge);
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
	* Gets a list with all the Manufacturers in a group
	*/
	public static java.util.List<com.ys.parts.model.Manufacturer> getManufacturersByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getManufacturersByGroupId(groupId);
	}

	/**
	* Gets a list with a range of Manufacturers from a group
	*/
	public static java.util.List<com.ys.parts.model.Manufacturer> getManufacturersByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getManufacturersByGroupId(groupId, start, end);
	}

	/**
	* Gets the number of Manufacturers in a group
	*/
	public static int getManufacturersCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getManufacturersCountByGroupId(groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ManufacturerLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ManufacturerLocalService.class.getName());

			if (invokableLocalService instanceof ManufacturerLocalService) {
				_service = (ManufacturerLocalService)invokableLocalService;
			}
			else {
				_service = new ManufacturerLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ManufacturerLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ManufacturerLocalService service) {
	}

	private static ManufacturerLocalService _service;
}