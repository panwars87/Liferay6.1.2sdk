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

package com.ys.parts.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.ys.parts.model.Manufacturer;

import java.util.List;

/**
 * The persistence utility for the manufacturer service. This utility wraps {@link ManufacturerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author shashantp
 * @see ManufacturerPersistence
 * @see ManufacturerPersistenceImpl
 * @generated
 */
public class ManufacturerUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Manufacturer manufacturer) {
		getPersistence().clearCache(manufacturer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Manufacturer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Manufacturer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Manufacturer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Manufacturer update(Manufacturer manufacturer, boolean merge)
		throws SystemException {
		return getPersistence().update(manufacturer, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Manufacturer update(Manufacturer manufacturer, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(manufacturer, merge, serviceContext);
	}

	/**
	* Caches the manufacturer in the entity cache if it is enabled.
	*
	* @param manufacturer the manufacturer
	*/
	public static void cacheResult(com.ys.parts.model.Manufacturer manufacturer) {
		getPersistence().cacheResult(manufacturer);
	}

	/**
	* Caches the manufacturers in the entity cache if it is enabled.
	*
	* @param manufacturers the manufacturers
	*/
	public static void cacheResult(
		java.util.List<com.ys.parts.model.Manufacturer> manufacturers) {
		getPersistence().cacheResult(manufacturers);
	}

	/**
	* Creates a new manufacturer with the primary key. Does not add the manufacturer to the database.
	*
	* @param manufId the primary key for the new manufacturer
	* @return the new manufacturer
	*/
	public static com.ys.parts.model.Manufacturer create(long manufId) {
		return getPersistence().create(manufId);
	}

	/**
	* Removes the manufacturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param manufId the primary key of the manufacturer
	* @return the manufacturer that was removed
	* @throws com.ys.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer remove(long manufId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchManufacturerException {
		return getPersistence().remove(manufId);
	}

	public static com.ys.parts.model.Manufacturer updateImpl(
		com.ys.parts.model.Manufacturer manufacturer, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(manufacturer, merge);
	}

	/**
	* Returns the manufacturer with the primary key or throws a {@link com.ys.parts.NoSuchManufacturerException} if it could not be found.
	*
	* @param manufId the primary key of the manufacturer
	* @return the manufacturer
	* @throws com.ys.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer findByPrimaryKey(long manufId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchManufacturerException {
		return getPersistence().findByPrimaryKey(manufId);
	}

	/**
	* Returns the manufacturer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param manufId the primary key of the manufacturer
	* @return the manufacturer, or <code>null</code> if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer fetchByPrimaryKey(
		long manufId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(manufId);
	}

	/**
	* Returns all the manufacturers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Manufacturer> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the manufacturers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @return the range of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Manufacturer> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the manufacturers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Manufacturer> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first manufacturer in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manufacturer
	* @throws com.ys.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchManufacturerException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first manufacturer in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last manufacturer in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manufacturer
	* @throws com.ys.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchManufacturerException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last manufacturer in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the manufacturers before and after the current manufacturer in the ordered set where groupId = &#63;.
	*
	* @param manufId the primary key of the current manufacturer
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next manufacturer
	* @throws com.ys.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Manufacturer[] findByGroupId_PrevAndNext(
		long manufId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchManufacturerException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(manufId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the manufacturers.
	*
	* @return the manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Manufacturer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ys.parts.model.Manufacturer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the manufacturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of manufacturers
	* @param end the upper bound of the range of manufacturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Manufacturer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the manufacturers where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the manufacturers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of manufacturers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of manufacturers.
	*
	* @return the number of manufacturers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ManufacturerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ManufacturerPersistence)PortletBeanLocatorUtil.locate(com.ys.parts.service.ClpSerializer.getServletContextName(),
					ManufacturerPersistence.class.getName());

			ReferenceRegistry.registerReference(ManufacturerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ManufacturerPersistence persistence) {
	}

	private static ManufacturerPersistence _persistence;
}