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

package com.ys.parts.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    shashantp
 * @generated
 */
public class PartsSoap implements Serializable {
	public static PartsSoap toSoapModel(Parts model) {
		PartsSoap soapModel = new PartsSoap();

		soapModel.setPartId(model.getPartId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setManufId(model.getManufId());
		soapModel.setName(model.getName());
		soapModel.setPartNumber(model.getPartNumber());
		soapModel.setReorderDate(model.getReorderDate());
		soapModel.setQuantity(model.getQuantity());

		return soapModel;
	}

	public static PartsSoap[] toSoapModels(Parts[] models) {
		PartsSoap[] soapModels = new PartsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PartsSoap[][] toSoapModels(Parts[][] models) {
		PartsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PartsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PartsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PartsSoap[] toSoapModels(List<Parts> models) {
		List<PartsSoap> soapModels = new ArrayList<PartsSoap>(models.size());

		for (Parts model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PartsSoap[soapModels.size()]);
	}

	public PartsSoap() {
	}

	public long getPrimaryKey() {
		return _partId;
	}

	public void setPrimaryKey(long pk) {
		setPartId(pk);
	}

	public long getPartId() {
		return _partId;
	}

	public void setPartId(long partId) {
		_partId = partId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getManufId() {
		return _manufId;
	}

	public void setManufId(long manufId) {
		_manufId = manufId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getPartNumber() {
		return _partNumber;
	}

	public void setPartNumber(String partNumber) {
		_partNumber = partNumber;
	}

	public Date getReorderDate() {
		return _reorderDate;
	}

	public void setReorderDate(Date reorderDate) {
		_reorderDate = reorderDate;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	private long _partId;
	private long _companyId;
	private long _groupId;
	private long _manufId;
	private String _name;
	private String _partNumber;
	private Date _reorderDate;
	private int _quantity;
}