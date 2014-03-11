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

import com.ys.parts.model.Parts;

import java.util.List;

/**
 * The persistence utility for the parts service. This utility wraps {@link PartsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author shashantp
 * @see PartsPersistence
 * @see PartsPersistenceImpl
 * @generated
 */
public class PartsUtil {
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
	public static void clearCache(Parts parts) {
		getPersistence().clearCache(parts);
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
	public static List<Parts> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Parts> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Parts> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Parts update(Parts parts, boolean merge)
		throws SystemException {
		return getPersistence().update(parts, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Parts update(Parts parts, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(parts, merge, serviceContext);
	}

	/**
	* Caches the parts in the entity cache if it is enabled.
	*
	* @param parts the parts
	*/
	public static void cacheResult(com.ys.parts.model.Parts parts) {
		getPersistence().cacheResult(parts);
	}

	/**
	* Caches the partses in the entity cache if it is enabled.
	*
	* @param partses the partses
	*/
	public static void cacheResult(
		java.util.List<com.ys.parts.model.Parts> partses) {
		getPersistence().cacheResult(partses);
	}

	/**
	* Creates a new parts with the primary key. Does not add the parts to the database.
	*
	* @param partId the primary key for the new parts
	* @return the new parts
	*/
	public static com.ys.parts.model.Parts create(long partId) {
		return getPersistence().create(partId);
	}

	/**
	* Removes the parts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param partId the primary key of the parts
	* @return the parts that was removed
	* @throws com.ys.parts.NoSuchPartsException if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts remove(long partId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException {
		return getPersistence().remove(partId);
	}

	public static com.ys.parts.model.Parts updateImpl(
		com.ys.parts.model.Parts parts, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(parts, merge);
	}

	/**
	* Returns the parts with the primary key or throws a {@link com.ys.parts.NoSuchPartsException} if it could not be found.
	*
	* @param partId the primary key of the parts
	* @return the parts
	* @throws com.ys.parts.NoSuchPartsException if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts findByPrimaryKey(long partId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException {
		return getPersistence().findByPrimaryKey(partId);
	}

	/**
	* Returns the parts with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param partId the primary key of the parts
	* @return the parts, or <code>null</code> if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts fetchByPrimaryKey(long partId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(partId);
	}

	/**
	* Returns all the partses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching partses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Parts> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the partses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of partses
	* @param end the upper bound of the range of partses (not inclusive)
	* @return the range of matching partses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Parts> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the partses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of partses
	* @param end the upper bound of the range of partses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching partses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Parts> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first parts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching parts
	* @throws com.ys.parts.NoSuchPartsException if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first parts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching parts, or <code>null</code> if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last parts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching parts
	* @throws com.ys.parts.NoSuchPartsException if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last parts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching parts, or <code>null</code> if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the partses before and after the current parts in the ordered set where groupId = &#63;.
	*
	* @param partId the primary key of the current parts
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next parts
	* @throws com.ys.parts.NoSuchPartsException if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts[] findByGroupId_PrevAndNext(
		long partId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(partId, groupId, orderByComparator);
	}

	/**
	* Returns all the partses where manufId = &#63; and groupId = &#63;.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @return the matching partses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Parts> findByManufacturer(
		long manufId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByManufacturer(manufId, groupId);
	}

	/**
	* Returns a range of all the partses where manufId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @param start the lower bound of the range of partses
	* @param end the upper bound of the range of partses (not inclusive)
	* @return the range of matching partses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Parts> findByManufacturer(
		long manufId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByManufacturer(manufId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the partses where manufId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @param start the lower bound of the range of partses
	* @param end the upper bound of the range of partses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching partses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Parts> findByManufacturer(
		long manufId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByManufacturer(manufId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first parts in the ordered set where manufId = &#63; and groupId = &#63;.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching parts
	* @throws com.ys.parts.NoSuchPartsException if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts findByManufacturer_First(
		long manufId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException {
		return getPersistence()
				   .findByManufacturer_First(manufId, groupId, orderByComparator);
	}

	/**
	* Returns the first parts in the ordered set where manufId = &#63; and groupId = &#63;.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching parts, or <code>null</code> if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts fetchByManufacturer_First(
		long manufId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByManufacturer_First(manufId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last parts in the ordered set where manufId = &#63; and groupId = &#63;.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching parts
	* @throws com.ys.parts.NoSuchPartsException if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts findByManufacturer_Last(
		long manufId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException {
		return getPersistence()
				   .findByManufacturer_Last(manufId, groupId, orderByComparator);
	}

	/**
	* Returns the last parts in the ordered set where manufId = &#63; and groupId = &#63;.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching parts, or <code>null</code> if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts fetchByManufacturer_Last(
		long manufId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByManufacturer_Last(manufId, groupId, orderByComparator);
	}

	/**
	* Returns the partses before and after the current parts in the ordered set where manufId = &#63; and groupId = &#63;.
	*
	* @param partId the primary key of the current parts
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next parts
	* @throws com.ys.parts.NoSuchPartsException if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ys.parts.model.Parts[] findByManufacturer_PrevAndNext(
		long partId, long manufId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException {
		return getPersistence()
				   .findByManufacturer_PrevAndNext(partId, manufId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the partses.
	*
	* @return the partses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Parts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ys.parts.model.Parts> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the partses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of partses
	* @param end the upper bound of the range of partses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of partses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ys.parts.model.Parts> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the partses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the partses where manufId = &#63; and groupId = &#63; from the database.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByManufacturer(long manufId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByManufacturer(manufId, groupId);
	}

	/**
	* Removes all the partses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of partses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching partses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of partses where manufId = &#63; and groupId = &#63;.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @return the number of matching partses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByManufacturer(long manufId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByManufacturer(manufId, groupId);
	}

	/**
	* Returns the number of partses.
	*
	* @return the number of partses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PartsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PartsPersistence)PortletBeanLocatorUtil.locate(com.ys.parts.service.ClpSerializer.getServletContextName(),
					PartsPersistence.class.getName());

			ReferenceRegistry.registerReference(PartsUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PartsPersistence persistence) {
	}

	private static PartsPersistence _persistence;
}