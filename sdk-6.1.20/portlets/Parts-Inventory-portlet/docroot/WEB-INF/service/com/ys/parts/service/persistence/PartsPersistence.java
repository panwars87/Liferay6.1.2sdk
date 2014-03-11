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

import com.liferay.portal.service.persistence.BasePersistence;

import com.ys.parts.model.Parts;

/**
 * The persistence interface for the parts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author shashantp
 * @see PartsPersistenceImpl
 * @see PartsUtil
 * @generated
 */
public interface PartsPersistence extends BasePersistence<Parts> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PartsUtil} to access the parts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the parts in the entity cache if it is enabled.
	*
	* @param parts the parts
	*/
	public void cacheResult(com.ys.parts.model.Parts parts);

	/**
	* Caches the partses in the entity cache if it is enabled.
	*
	* @param partses the partses
	*/
	public void cacheResult(java.util.List<com.ys.parts.model.Parts> partses);

	/**
	* Creates a new parts with the primary key. Does not add the parts to the database.
	*
	* @param partId the primary key for the new parts
	* @return the new parts
	*/
	public com.ys.parts.model.Parts create(long partId);

	/**
	* Removes the parts with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param partId the primary key of the parts
	* @return the parts that was removed
	* @throws com.ys.parts.NoSuchPartsException if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts remove(long partId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException;

	public com.ys.parts.model.Parts updateImpl(com.ys.parts.model.Parts parts,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parts with the primary key or throws a {@link com.ys.parts.NoSuchPartsException} if it could not be found.
	*
	* @param partId the primary key of the parts
	* @return the parts
	* @throws com.ys.parts.NoSuchPartsException if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts findByPrimaryKey(long partId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException;

	/**
	* Returns the parts with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param partId the primary key of the parts
	* @return the parts, or <code>null</code> if a parts with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts fetchByPrimaryKey(long partId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the partses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching partses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ys.parts.model.Parts> findByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ys.parts.model.Parts> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ys.parts.model.Parts> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first parts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching parts
	* @throws com.ys.parts.NoSuchPartsException if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException;

	/**
	* Returns the first parts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching parts, or <code>null</code> if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last parts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching parts
	* @throws com.ys.parts.NoSuchPartsException if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException;

	/**
	* Returns the last parts in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching parts, or <code>null</code> if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ys.parts.model.Parts[] findByGroupId_PrevAndNext(long partId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException;

	/**
	* Returns all the partses where manufId = &#63; and groupId = &#63;.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @return the matching partses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ys.parts.model.Parts> findByManufacturer(
		long manufId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ys.parts.model.Parts> findByManufacturer(
		long manufId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ys.parts.model.Parts> findByManufacturer(
		long manufId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ys.parts.model.Parts findByManufacturer_First(long manufId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException;

	/**
	* Returns the first parts in the ordered set where manufId = &#63; and groupId = &#63;.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching parts, or <code>null</code> if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts fetchByManufacturer_First(long manufId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ys.parts.model.Parts findByManufacturer_Last(long manufId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException;

	/**
	* Returns the last parts in the ordered set where manufId = &#63; and groupId = &#63;.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching parts, or <code>null</code> if a matching parts could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ys.parts.model.Parts fetchByManufacturer_Last(long manufId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ys.parts.model.Parts[] findByManufacturer_PrevAndNext(
		long partId, long manufId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ys.parts.NoSuchPartsException;

	/**
	* Returns all the partses.
	*
	* @return the partses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ys.parts.model.Parts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ys.parts.model.Parts> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ys.parts.model.Parts> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the partses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the partses where manufId = &#63; and groupId = &#63; from the database.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByManufacturer(long manufId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the partses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of partses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching partses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of partses where manufId = &#63; and groupId = &#63;.
	*
	* @param manufId the manuf ID
	* @param groupId the group ID
	* @return the number of matching partses
	* @throws SystemException if a system exception occurred
	*/
	public int countByManufacturer(long manufId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of partses.
	*
	* @return the number of partses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}