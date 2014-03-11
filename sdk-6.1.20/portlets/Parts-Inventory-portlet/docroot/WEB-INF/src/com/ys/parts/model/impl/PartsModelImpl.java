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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.ys.parts.model.Parts;
import com.ys.parts.model.PartsModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * The base model implementation for the Parts service. Represents a row in the &quot;Inventory_Parts&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ys.parts.model.PartsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PartsImpl}.
 * </p>
 *
 * @author shashantp
 * @see PartsImpl
 * @see com.ys.parts.model.Parts
 * @see com.ys.parts.model.PartsModel
 * @generated
 */
public class PartsModelImpl extends BaseModelImpl<Parts> implements PartsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a parts model instance should use the {@link com.ys.parts.model.Parts} interface instead.
	 */
	public static final String TABLE_NAME = "Inventory_Parts";
	public static final Object[][] TABLE_COLUMNS = {
			{ "partId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "manufId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "partNumber", Types.VARCHAR },
			{ "reorderDate", Types.TIMESTAMP },
			{ "quantity", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table Inventory_Parts (partId LONG not null primary key,companyId LONG,groupId LONG,manufId LONG,name STRING null,partNumber VARCHAR(75) null,reorderDate DATE null,quantity INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table Inventory_Parts";
	public static final String ORDER_BY_JPQL = " ORDER BY parts.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Inventory_Parts.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ys.parts.model.Parts"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ys.parts.model.Parts"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ys.parts.model.Parts"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long MANUFID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ys.parts.model.Parts"));

	public PartsModelImpl() {
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

	public Class<?> getModelClass() {
		return Parts.class;
	}

	public String getModelClassName() {
		return Parts.class.getName();
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
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getManufId() {
		return _manufId;
	}

	public void setManufId(long manufId) {
		_columnBitmask |= MANUFID_COLUMN_BITMASK;

		if (!_setOriginalManufId) {
			_setOriginalManufId = true;

			_originalManufId = _manufId;
		}

		_manufId = manufId;
	}

	public long getOriginalManufId() {
		return _originalManufId;
	}

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
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

	@JSON
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
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

		Locale[] locales = LanguageUtil.getAvailableLocales();

		for (Locale locale : locales) {
			String name = nameMap.get(locale);

			setName(name, locale, defaultLocale);
		}
	}

	public String getPartNumber() {
		if (_partNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _partNumber;
		}
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Parts.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		setName(getName(defaultImportLocale), defaultImportLocale,
			defaultImportLocale);
	}

	@Override
	public Parts toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Parts)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	public Parts toUnescapedModel() {
		return (Parts)this;
	}

	@Override
	public Object clone() {
		PartsImpl partsImpl = new PartsImpl();

		partsImpl.setPartId(getPartId());
		partsImpl.setCompanyId(getCompanyId());
		partsImpl.setGroupId(getGroupId());
		partsImpl.setManufId(getManufId());
		partsImpl.setName(getName());
		partsImpl.setPartNumber(getPartNumber());
		partsImpl.setReorderDate(getReorderDate());
		partsImpl.setQuantity(getQuantity());

		partsImpl.resetOriginalValues();

		return partsImpl;
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

		if (!(obj instanceof Parts)) {
			return false;
		}

		Parts parts = (Parts)obj;

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
	public void resetOriginalValues() {
		PartsModelImpl partsModelImpl = this;

		partsModelImpl._originalGroupId = partsModelImpl._groupId;

		partsModelImpl._setOriginalGroupId = false;

		partsModelImpl._originalManufId = partsModelImpl._manufId;

		partsModelImpl._setOriginalManufId = false;

		partsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Parts> toCacheModel() {
		PartsCacheModel partsCacheModel = new PartsCacheModel();

		partsCacheModel.partId = getPartId();

		partsCacheModel.companyId = getCompanyId();

		partsCacheModel.groupId = getGroupId();

		partsCacheModel.manufId = getManufId();

		partsCacheModel.name = getName();

		String name = partsCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			partsCacheModel.name = null;
		}

		partsCacheModel.partNumber = getPartNumber();

		String partNumber = partsCacheModel.partNumber;

		if ((partNumber != null) && (partNumber.length() == 0)) {
			partsCacheModel.partNumber = null;
		}

		Date reorderDate = getReorderDate();

		if (reorderDate != null) {
			partsCacheModel.reorderDate = reorderDate.getTime();
		}
		else {
			partsCacheModel.reorderDate = Long.MIN_VALUE;
		}

		partsCacheModel.quantity = getQuantity();

		return partsCacheModel;
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

	private static ClassLoader _classLoader = Parts.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Parts.class };
	private long _partId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _manufId;
	private long _originalManufId;
	private boolean _setOriginalManufId;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _partNumber;
	private Date _reorderDate;
	private int _quantity;
	private long _columnBitmask;
	private Parts _escapedModel;
}