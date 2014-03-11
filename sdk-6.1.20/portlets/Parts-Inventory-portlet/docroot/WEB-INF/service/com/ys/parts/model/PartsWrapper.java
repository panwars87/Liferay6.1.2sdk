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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Parts}.
 * </p>
 *
 * @author    shashantp
 * @see       Parts
 * @generated
 */
public class PartsWrapper implements Parts, ModelWrapper<Parts> {
	public PartsWrapper(Parts parts) {
		_parts = parts;
	}

	public Class<?> getModelClass() {
		return Parts.class;
	}

	public String getModelClassName() {
		return Parts.class.getName();
	}

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

	/**
	* Returns the primary key of this parts.
	*
	* @return the primary key of this parts
	*/
	public long getPrimaryKey() {
		return _parts.getPrimaryKey();
	}

	/**
	* Sets the primary key of this parts.
	*
	* @param primaryKey the primary key of this parts
	*/
	public void setPrimaryKey(long primaryKey) {
		_parts.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the part ID of this parts.
	*
	* @return the part ID of this parts
	*/
	public long getPartId() {
		return _parts.getPartId();
	}

	/**
	* Sets the part ID of this parts.
	*
	* @param partId the part ID of this parts
	*/
	public void setPartId(long partId) {
		_parts.setPartId(partId);
	}

	/**
	* Returns the company ID of this parts.
	*
	* @return the company ID of this parts
	*/
	public long getCompanyId() {
		return _parts.getCompanyId();
	}

	/**
	* Sets the company ID of this parts.
	*
	* @param companyId the company ID of this parts
	*/
	public void setCompanyId(long companyId) {
		_parts.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this parts.
	*
	* @return the group ID of this parts
	*/
	public long getGroupId() {
		return _parts.getGroupId();
	}

	/**
	* Sets the group ID of this parts.
	*
	* @param groupId the group ID of this parts
	*/
	public void setGroupId(long groupId) {
		_parts.setGroupId(groupId);
	}

	/**
	* Returns the manuf ID of this parts.
	*
	* @return the manuf ID of this parts
	*/
	public long getManufId() {
		return _parts.getManufId();
	}

	/**
	* Sets the manuf ID of this parts.
	*
	* @param manufId the manuf ID of this parts
	*/
	public void setManufId(long manufId) {
		_parts.setManufId(manufId);
	}

	/**
	* Returns the name of this parts.
	*
	* @return the name of this parts
	*/
	public java.lang.String getName() {
		return _parts.getName();
	}

	/**
	* Returns the localized name of this parts in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this parts
	*/
	public java.lang.String getName(java.util.Locale locale) {
		return _parts.getName(locale);
	}

	/**
	* Returns the localized name of this parts in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this parts. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _parts.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this parts in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this parts
	*/
	public java.lang.String getName(java.lang.String languageId) {
		return _parts.getName(languageId);
	}

	/**
	* Returns the localized name of this parts in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this parts
	*/
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _parts.getName(languageId, useDefault);
	}

	public java.lang.String getNameCurrentLanguageId() {
		return _parts.getNameCurrentLanguageId();
	}

	public java.lang.String getNameCurrentValue() {
		return _parts.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this parts.
	*
	* @return the locales and localized names of this parts
	*/
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _parts.getNameMap();
	}

	/**
	* Sets the name of this parts.
	*
	* @param name the name of this parts
	*/
	public void setName(java.lang.String name) {
		_parts.setName(name);
	}

	/**
	* Sets the localized name of this parts in the language.
	*
	* @param name the localized name of this parts
	* @param locale the locale of the language
	*/
	public void setName(java.lang.String name, java.util.Locale locale) {
		_parts.setName(name, locale);
	}

	/**
	* Sets the localized name of this parts in the language, and sets the default locale.
	*
	* @param name the localized name of this parts
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_parts.setName(name, locale, defaultLocale);
	}

	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_parts.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this parts from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this parts
	*/
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_parts.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this parts from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this parts
	* @param defaultLocale the default locale
	*/
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_parts.setNameMap(nameMap, defaultLocale);
	}

	/**
	* Returns the part number of this parts.
	*
	* @return the part number of this parts
	*/
	public java.lang.String getPartNumber() {
		return _parts.getPartNumber();
	}

	/**
	* Sets the part number of this parts.
	*
	* @param partNumber the part number of this parts
	*/
	public void setPartNumber(java.lang.String partNumber) {
		_parts.setPartNumber(partNumber);
	}

	/**
	* Returns the reorder date of this parts.
	*
	* @return the reorder date of this parts
	*/
	public java.util.Date getReorderDate() {
		return _parts.getReorderDate();
	}

	/**
	* Sets the reorder date of this parts.
	*
	* @param reorderDate the reorder date of this parts
	*/
	public void setReorderDate(java.util.Date reorderDate) {
		_parts.setReorderDate(reorderDate);
	}

	/**
	* Returns the quantity of this parts.
	*
	* @return the quantity of this parts
	*/
	public int getQuantity() {
		return _parts.getQuantity();
	}

	/**
	* Sets the quantity of this parts.
	*
	* @param quantity the quantity of this parts
	*/
	public void setQuantity(int quantity) {
		_parts.setQuantity(quantity);
	}

	public boolean isNew() {
		return _parts.isNew();
	}

	public void setNew(boolean n) {
		_parts.setNew(n);
	}

	public boolean isCachedModel() {
		return _parts.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_parts.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _parts.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _parts.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_parts.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _parts.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_parts.setExpandoBridgeAttributes(serviceContext);
	}

	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_parts.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new PartsWrapper((Parts)_parts.clone());
	}

	public int compareTo(com.ys.parts.model.Parts parts) {
		return _parts.compareTo(parts);
	}

	@Override
	public int hashCode() {
		return _parts.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ys.parts.model.Parts> toCacheModel() {
		return _parts.toCacheModel();
	}

	public com.ys.parts.model.Parts toEscapedModel() {
		return new PartsWrapper(_parts.toEscapedModel());
	}

	public com.ys.parts.model.Parts toUnescapedModel() {
		return new PartsWrapper(_parts.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _parts.toString();
	}

	public java.lang.String toXmlString() {
		return _parts.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_parts.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PartsWrapper)) {
			return false;
		}

		PartsWrapper partsWrapper = (PartsWrapper)obj;

		if (Validator.equals(_parts, partsWrapper._parts)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Parts getWrappedParts() {
		return _parts;
	}

	public Parts getWrappedModel() {
		return _parts;
	}

	public void resetOriginalValues() {
		_parts.resetOriginalValues();
	}

	private Parts _parts;
}