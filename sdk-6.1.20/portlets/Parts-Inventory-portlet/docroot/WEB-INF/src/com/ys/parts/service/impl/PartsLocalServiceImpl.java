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

package com.ys.parts.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.ys.parts.model.Parts;
import com.ys.parts.service.base.PartsLocalServiceBaseImpl;

/**
 * The implementation of the parts local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.parts.service.PartsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author shashantp
 * @see com.ys.parts.service.base.PartsLocalServiceBaseImpl
 * @see com.ys.parts.service.PartsLocalServiceUtil
 */
public class PartsLocalServiceImpl extends PartsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ys.parts.service.PartsLocalServiceUtil} to access the parts local service.
	 */
	/**
	 * Adds the Part to the database incrementing the primary key
	 *
	 */
	public Parts addPart(Parts part) throws SystemException {
		long partId = counterLocalService.increment(Parts.class.getName());

		part.setPartId(partId);

		return super.addParts(part);
	}

	/**
	 * Gets a list with all the Parts in a group
	 *
	 */
	public List<Parts> getPartsByGroupId(long groupId) throws SystemException {
		return partsPersistence.findByGroupId(groupId);
	}

	/**
	 * Gets a list with a range of Parts from a group
	 *
	 */
	public List<Parts> getPartsByGroupId(long groupId, int start, int end) throws SystemException {
		return partsPersistence.findByGroupId(groupId, start, end);
	}

	/**
	 * Gets the number of Parts in a group
	 *
	 */
	public int getPartsCountByGroupId(long groupId) throws SystemException {
		return partsPersistence.countByGroupId(groupId);
	}

	/**
	 * Gets a list of Parts from a Manufacturer
	 *
	 */
	public List<Parts> getPartsbyManufacturer(long manufacturerId, long groupId) throws SystemException {
		return partsPersistence.findByManufacturer(manufacturerId, groupId);
	}
}