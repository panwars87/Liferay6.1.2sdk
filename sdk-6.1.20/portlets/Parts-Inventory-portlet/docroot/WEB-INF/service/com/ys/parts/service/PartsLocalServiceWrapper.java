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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PartsLocalService}.
 * </p>
 *
 * @author    shashantp
 * @see       PartsLocalService
 * @generated
 */
public class PartsLocalServiceWrapper implements PartsLocalService,
	ServiceWrapper<PartsLocalService> {
	public PartsLocalServiceWrapper(PartsLocalService partsLocalService) {
		_partsLocalService = partsLocalService;
	}

	/**
	* Adds the parts to the database. Also notifies the appropriate model listeners.
	*
	* @param parts the parts
	* @return the parts that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts addParts(com.ys.parts.model.Parts parts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.addParts(parts);
	}

	/**
	* Creates a new parts with the primary key. Does not add the parts to the database.
	*
	* @param partId the primary key for the new parts
	* @return the new parts
	*/
	public com.ys.parts.model.Parts createParts(long partId) {
		return _partsLocalService.createParts(partId);
	}

	/**
	* Deletes the parts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param partId the primary key of the parts
	* @return the parts that was removed
	* @throws PortalException if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts deleteParts(long partId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.deleteParts(partId);
	}

	/**
	* Deletes the parts from the database. Also notifies the appropriate model listeners.
	*
	* @param parts the parts
	* @return the parts that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts deleteParts(com.ys.parts.model.Parts parts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.deleteParts(parts);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _partsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ys.parts.model.Parts fetchParts(long partId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.fetchParts(partId);
	}

	/**
	* Returns the parts with the primary key.
	*
	* @param partId the primary key of the parts
	* @return the parts
	* @throws PortalException if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts getParts(long partId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.getParts(partId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.ys.parts.model.Parts> getPartses(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.getPartses(start, end);
	}

	/**
	* Returns the number of partses.
	*
	* @return the number of partses
	* @throws SystemException if a system exception occurred
	*/
	public int getPartsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.getPartsesCount();
	}

	/**
	* Updates the parts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param parts the parts
	* @return the parts that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts updateParts(com.ys.parts.model.Parts parts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.updateParts(parts);
	}

	/**
	* Updates the parts in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param parts the parts
	* @param merge whether to merge the parts with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the parts that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts updateParts(
		com.ys.parts.model.Parts parts, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.updateParts(parts, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _partsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_partsLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _partsLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Adds the Part to the database incrementing the primary key
	*/
	public com.ys.parts.model.Parts addPart(com.ys.parts.model.Parts part)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.addPart(part);
	}

	/**
	* Gets a list with all the Parts in a group
	*/
	public java.util.List<com.ys.parts.model.Parts> getPartsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.getPartsByGroupId(groupId);
	}

	/**
	* Gets a list with a range of Parts from a group
	*/
	public java.util.List<com.ys.parts.model.Parts> getPartsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.getPartsByGroupId(groupId, start, end);
	}

	/**
	* Gets the number of Parts in a group
	*/
	public int getPartsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.getPartsCountByGroupId(groupId);
	}

	/**
	* Gets a list of Parts from a Manufacturer
	*/
	public java.util.List<com.ys.parts.model.Parts> getPartsbyManufacturer(
		long manufacturerId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _partsLocalService.getPartsbyManufacturer(manufacturerId, groupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PartsLocalService getWrappedPartsLocalService() {
		return _partsLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPartsLocalService(PartsLocalService partsLocalService) {
		_partsLocalService = partsLocalService;
	}

	public PartsLocalService getWrappedService() {
		return _partsLocalService;
	}

	public void setWrappedService(PartsLocalService partsLocalService) {
		_partsLocalService = partsLocalService;
	}

	private PartsLocalService _partsLocalService;
}