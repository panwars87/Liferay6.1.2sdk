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
import com.ys.parts.model.Manufacturer;
import com.ys.parts.service.base.ManufacturerLocalServiceBaseImpl;

/**
 * The implementation of the manufacturer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ys.parts.service.ManufacturerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author shashantp
 * @see com.ys.parts.service.base.ManufacturerLocalServiceBaseImpl
 * @see com.ys.parts.service.ManufacturerLocalServiceUtil
 */
public class ManufacturerLocalServiceImpl
	extends ManufacturerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ys.parts.service.ManufacturerLocalServiceUtil} to access the manufacturer local service.
	 */
	
	/**
	 * Adds the Manufacturer to the database incrementing the primary key
	 *
	 */
	public Manufacturer addManufacturer(Manufacturer manufacturer) throws SystemException {
		long manufacturerId = counterLocalService.increment(Manufacturer.class.getName());

		manufacturer.setManufId(manufacturerId);
		
		return super.addManufacturer(manufacturer);
	}
	
	/**
	 * Gets a list with all the Manufacturers in a group
	 *
	 */
	public List<Manufacturer> getManufacturersByGroupId(long groupId) throws SystemException {
		return manufacturerPersistence.findByGroupId(groupId);
	}

	/**
	 * Gets a list with a range of Manufacturers from a group
	 *
	 */
	public List<Manufacturer> getManufacturersByGroupId(long groupId, int start, int end) throws SystemException {
		return manufacturerPersistence.findByGroupId(groupId, start, end);
	}
	
	/**
	 * Gets the number of Manufacturers in a group
	 *
	 */
	public int getManufacturersCountByGroupId(long groupId) throws SystemException {
		return manufacturerPersistence.countByGroupId(groupId);
	}
	
}