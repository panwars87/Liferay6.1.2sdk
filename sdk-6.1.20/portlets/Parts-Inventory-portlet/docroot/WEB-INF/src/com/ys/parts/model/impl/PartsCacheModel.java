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

package com.ys.parts.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.ys.parts.model.Parts;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Parts in entity cache.
 *
 * @author shashantp
 * @see Parts
 * @generated
 */
public class PartsCacheModel implements CacheModel<Parts>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{partId=");
		sb.append(partId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", manufId=");
		sb.append(manufId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", partNumber=");
		sb.append(partNumber);
		sb.append(", reorderDate=");
		sb.append(reorderDate);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append("}");

		return sb.toString();
	}

	public Parts toEntityModel() {
		PartsImpl partsImpl = new PartsImpl();

		partsImpl.setPartId(partId);
		partsImpl.setCompanyId(companyId);
		partsImpl.setGroupId(groupId);
		partsImpl.setManufId(manufId);

		if (name == null) {
			partsImpl.setName(StringPool.BLANK);
		}
		else {
			partsImpl.setName(name);
		}

		if (partNumber == null) {
			partsImpl.setPartNumber(StringPool.BLANK);
		}
		else {
			partsImpl.setPartNumber(partNumber);
		}

		if (reorderDate == Long.MIN_VALUE) {
			partsImpl.setReorderDate(null);
		}
		else {
			partsImpl.setReorderDate(new Date(reorderDate));
		}

		partsImpl.setQuantity(quantity);

		partsImpl.resetOriginalValues();

		return partsImpl;
	}

	public long partId;
	public long companyId;
	public long groupId;
	public long manufId;
	public String name;
	public String partNumber;
	public long reorderDate;
	public int quantity;
}