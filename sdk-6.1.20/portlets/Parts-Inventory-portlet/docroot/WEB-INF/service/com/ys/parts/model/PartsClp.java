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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.ys.parts.service.ClpSerializer;
import com.ys.parts.service.PartsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author shashantp
 */
public class PartsClp extends BaseModelImpl<Parts> implements Parts {
	public PartsClp() {
	}

	public Class<?> getModelClass() {
		return Parts.class;
	}

	public String getModelClassName() {
		return Parts.class.getName();
	}

	public long getPrimaryKey() {
		return _partId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPartId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_partId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("partId", getPartId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("manufId", getManufId());
		attributes.put("name", getName());
		attributes.put("partNumber", getPartNumber());
		attributes.put("reorderDate", getReorderDate());
		attributes.put("quantity", getQuantity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long partId = (Long)attributes.get("partId");

		if (partId != null) {
			setPartId(partId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long manufId = (Long)attributes.get("manufId");

		if (manufId != null) {
			setManufId(manufId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String partNumber = (String)attributes.get("partNumber");

		if (partNumber != null) {
			setPartNumber(partNumber);
		}

		Date reorderDate = (Date)attributes.get("reorderDate");

		if (reorderDate != null) {
			setReorderDate(reorderDate);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}
	}

	public long getPartId() {
		return _partId;
	}

	public void setPartId(long partId) {
		_partId = partId;

		if (_partsRemoteModel != null) {
			try {
				Class<?> clazz = _partsRemoteModel.getClass();

				Method method = clazz.getMethod("setPartId", long.class);

				method.invoke(_partsRemoteModel, partId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_partsRemoteModel != null) {
			try {
				Class<?> clazz = _partsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_partsRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_partsRemoteModel != null) {
			try {
				Class<?> clazz = _partsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_partsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getManufId() {
		return _manufId;
	}

	public void setManufId(long manufId) {
		_manufId = manufId;

		if (_partsRemoteModel != null) {
			try {
				Class<?> clazz = _partsRemoteModel.getClass();

				Method method = clazz.getMethod("setManufId", long.class);

				method.invoke(_partsRemoteModel, manufId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getName() {
		return _name;
	}

	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getName(), languageId,
			useDefault);
	}

	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	public void setName(String name) {
		_name = name;

		if (_partsRemoteModel != null) {
			try {
				Class<?> clazz = _partsRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_partsRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name",
					name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name",
					languageId));
		}
	}

	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			Locale[] locales = LanguageUtil.getAvailableLocales();

			for (Locale locale : locales) {
				String name = nameMap.get(locale);

				setName(name, locale, defaultLocale);
			}
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public String getPartNumber() {
		return _partNumber;
	}

	public void setPartNumber(String partNumber) {
		_partNumber = partNumber;

		if (_partsRemoteModel != null) {
			try {
				Class<?> clazz = _partsRemoteModel.getClass();

				Method method = clazz.getMethod("setPartNumber", String.class);

				method.invoke(_partsRemoteModel, partNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getReorderDate() {
		return _reorderDate;
	}

	public void setReorderDate(Date reorderDate) {
		_reorderDate = reorderDate;

		if (_partsRemoteModel != null) {
			try {
				Class<?> clazz = _partsRemoteModel.getClass();

				Method method = clazz.getMethod("setReorderDate", Date.class);

				method.invoke(_partsRemoteModel, reorderDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;

		if (_partsRemoteModel != null) {
			try {
				Class<?> clazz = _partsRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantity", int.class);

				method.invoke(_partsRemoteModel, quantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPartsRemoteModel() {
		return _partsRemoteModel;
	}

	public void setPartsRemoteModel(BaseModel<?> partsRemoteModel) {
		_partsRemoteModel = partsRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _partsRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_partsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PartsLocalServiceUtil.addParts(this);
		}
		else {
			PartsLocalServiceUtil.updateParts(this);
		}
	}

	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		setName(getName(defaultImportLocale), defaultImportLocale,
			defaultImportLocale);
	}

	@Override
	public Parts toEscapedModel() {
		return (Parts)ProxyUtil.newProxyInstance(Parts.class.getClassLoader(),
			new Class[] { Parts.class }, new AutoEscapeBeanHandler(this));
	}

	public Parts toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		PartsClp clone = new PartsClp();

		clone.setPartId(getPartId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setManufId(getManufId());
		clone.setName(getName());
		clone.setPartNumber(getPartNumber());
		clone.setReorderDate(getReorderDate());
		clone.setQuantity(getQuantity());

		return clone;
	}

	public int compareTo(Parts parts) {
		int value = 0;

		value = getName().compareTo(parts.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PartsClp)) {
			return false;
		}

		PartsClp parts = (PartsClp)obj;

		long primaryKey = parts.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{partId=");
		sb.append(getPartId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", manufId=");
		sb.append(getManufId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", partNumber=");
		sb.append(getPartNumber());
		sb.append(", reorderDate=");
		sb.append(getReorderDate());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ys.parts.model.Parts");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>partId</column-name><column-value><![CDATA[");
		sb.append(getPartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>manufId</column-name><column-value><![CDATA[");
		sb.append(getManufId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partNumber</column-name><column-value><![CDATA[");
		sb.append(getPartNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reorderDate</column-name><column-value><![CDATA[");
		sb.append(getReorderDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _partId;
	private long _companyId;
	private long _groupId;
	private long _manufId;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _partNumber;
	private Date _reorderDate;
	private int _quantity;
	private BaseModel<?> _partsRemoteModel;
}