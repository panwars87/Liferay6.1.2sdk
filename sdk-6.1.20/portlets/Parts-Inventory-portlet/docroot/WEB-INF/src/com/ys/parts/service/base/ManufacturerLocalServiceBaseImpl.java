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

package com.ys.parts.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.ys.parts.model.Manufacturer;
import com.ys.parts.service.ManufacturerLocalService;
import com.ys.parts.service.PartsLocalService;
import com.ys.parts.service.persistence.ManufacturerPersistence;
import com.ys.parts.service.persistence.PartsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the manufacturer local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ys.parts.service.impl.ManufacturerLocalServiceImpl}.
 * </p>
 *
 * @author shashantp
 * @see com.ys.parts.service.impl.ManufacturerLocalServiceImpl
 * @see com.ys.parts.service.ManufacturerLocalServiceUtil
 * @generated
 */
public abstract class ManufacturerLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ManufacturerLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.ys.parts.service.ManufacturerLocalServiceUtil} to access the manufacturer local service.
	 */

	/**
	 * Adds the manufacturer to the database. Also notifies the appropriate model listeners.
	 *
	 * @param manufacturer the manufacturer
	 * @return the manufacturer that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Manufacturer addManufacturer(Manufacturer manufacturer)
		throws SystemException {
		manufacturer.setNew(true);

		return manufacturerPersistence.update(manufacturer, false);
	}

	/**
	 * Creates a new manufacturer with the primary key. Does not add the manufacturer to the database.
	 *
	 * @param manufId the primary key for the new manufacturer
	 * @return the new manufacturer
	 */
	public Manufacturer createManufacturer(long manufId) {
		return manufacturerPersistence.create(manufId);
	}

	/**
	 * Deletes the manufacturer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param manufId the primary key of the manufacturer
	 * @return the manufacturer that was removed
	 * @throws PortalException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Manufacturer deleteManufacturer(long manufId)
		throws PortalException, SystemException {
		return manufacturerPersistence.remove(manufId);
	}

	/**
	 * Deletes the manufacturer from the database. Also notifies the appropriate model listeners.
	 *
	 * @param manufacturer the manufacturer
	 * @return the manufacturer that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Manufacturer deleteManufacturer(Manufacturer manufacturer)
		throws SystemException {
		return manufacturerPersistence.remove(manufacturer);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Manufacturer.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return manufacturerPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return manufacturerPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return manufacturerPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return manufacturerPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Manufacturer fetchManufacturer(long manufId)
		throws SystemException {
		return manufacturerPersistence.fetchByPrimaryKey(manufId);
	}

	/**
	 * Returns the manufacturer with the primary key.
	 *
	 * @param manufId the primary key of the manufacturer
	 * @return the manufacturer
	 * @throws PortalException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Manufacturer getManufacturer(long manufId)
		throws PortalException, SystemException {
		return manufacturerPersistence.findByPrimaryKey(manufId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return manufacturerPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Manufacturer> getManufacturers(int start, int end)
		throws SystemException {
		return manufacturerPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of manufacturers.
	 *
	 * @return the number of manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	public int getManufacturersCount() throws SystemException {
		return manufacturerPersistence.countAll();
	}

	/**
	 * Updates the manufacturer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param manufacturer the manufacturer
	 * @return the manufacturer that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Manufacturer updateManufacturer(Manufacturer manufacturer)
		throws SystemException {
		return updateManufacturer(manufacturer, true);
	}

	/**
	 * Updates the manufacturer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param manufacturer the manufacturer
	 * @param merge whether to merge the manufacturer with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the manufacturer that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Manufacturer updateManufacturer(Manufacturer manufacturer,
		boolean merge) throws SystemException {
		manufacturer.setNew(false);

		return manufacturerPersistence.update(manufacturer, merge);
	}

	/**
	 * Returns the manufacturer local service.
	 *
	 * @return the manufacturer local service
	 */
	public ManufacturerLocalService getManufacturerLocalService() {
		return manufacturerLocalService;
	}

	/**
	 * Sets the manufacturer local service.
	 *
	 * @param manufacturerLocalService the manufacturer local service
	 */
	public void setManufacturerLocalService(
		ManufacturerLocalService manufacturerLocalService) {
		this.manufacturerLocalService = manufacturerLocalService;
	}

	/**
	 * Returns the manufacturer persistence.
	 *
	 * @return the manufacturer persistence
	 */
	public ManufacturerPersistence getManufacturerPersistence() {
		return manufacturerPersistence;
	}

	/**
	 * Sets the manufacturer persistence.
	 *
	 * @param manufacturerPersistence the manufacturer persistence
	 */
	public void setManufacturerPersistence(
		ManufacturerPersistence manufacturerPersistence) {
		this.manufacturerPersistence = manufacturerPersistence;
	}

	/**
	 * Returns the parts local service.
	 *
	 * @return the parts local service
	 */
	public PartsLocalService getPartsLocalService() {
		return partsLocalService;
	}

	/**
	 * Sets the parts local service.
	 *
	 * @param partsLocalService the parts local service
	 */
	public void setPartsLocalService(PartsLocalService partsLocalService) {
		this.partsLocalService = partsLocalService;
	}

	/**
	 * Returns the parts persistence.
	 *
	 * @return the parts persistence
	 */
	public PartsPersistence getPartsPersistence() {
		return partsPersistence;
	}

	/**
	 * Sets the parts persistence.
	 *
	 * @param partsPersistence the parts persistence
	 */
	public void setPartsPersistence(PartsPersistence partsPersistence) {
		this.partsPersistence = partsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.ys.parts.model.Manufacturer",
			manufacturerLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.ys.parts.model.Manufacturer");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Manufacturer.class;
	}

	protected String getModelClassName() {
		return Manufacturer.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = manufacturerPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ManufacturerLocalService.class)
	protected ManufacturerLocalService manufacturerLocalService;
	@BeanReference(type = ManufacturerPersistence.class)
	protected ManufacturerPersistence manufacturerPersistence;
	@BeanReference(type = PartsLocalService.class)
	protected PartsLocalService partsLocalService;
	@BeanReference(type = PartsPersistence.class)
	protected PartsPersistence partsPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ManufacturerLocalServiceClpInvoker _clpInvoker = new ManufacturerLocalServiceClpInvoker();
}