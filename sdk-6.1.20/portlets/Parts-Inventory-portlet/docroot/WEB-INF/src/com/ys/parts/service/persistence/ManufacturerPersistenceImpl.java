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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.ys.parts.NoSuchManufacturerException;
import com.ys.parts.model.Manufacturer;
import com.ys.parts.model.impl.ManufacturerImpl;
import com.ys.parts.model.impl.ManufacturerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the manufacturer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author shashantp
 * @see ManufacturerPersistence
 * @see ManufacturerUtil
 * @generated
 */
public class ManufacturerPersistenceImpl extends BasePersistenceImpl<Manufacturer>
	implements ManufacturerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ManufacturerUtil} to access the manufacturer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ManufacturerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, ManufacturerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, ManufacturerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ManufacturerModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, ManufacturerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, ManufacturerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the manufacturer in the entity cache if it is enabled.
	 *
	 * @param manufacturer the manufacturer
	 */
	public void cacheResult(Manufacturer manufacturer) {
		EntityCacheUtil.putResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerImpl.class, manufacturer.getPrimaryKey(), manufacturer);

		manufacturer.resetOriginalValues();
	}

	/**
	 * Caches the manufacturers in the entity cache if it is enabled.
	 *
	 * @param manufacturers the manufacturers
	 */
	public void cacheResult(List<Manufacturer> manufacturers) {
		for (Manufacturer manufacturer : manufacturers) {
			if (EntityCacheUtil.getResult(
						ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
						ManufacturerImpl.class, manufacturer.getPrimaryKey()) == null) {
				cacheResult(manufacturer);
			}
			else {
				manufacturer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all manufacturers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ManufacturerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ManufacturerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the manufacturer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Manufacturer manufacturer) {
		EntityCacheUtil.removeResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerImpl.class, manufacturer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Manufacturer> manufacturers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Manufacturer manufacturer : manufacturers) {
			EntityCacheUtil.removeResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
				ManufacturerImpl.class, manufacturer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new manufacturer with the primary key. Does not add the manufacturer to the database.
	 *
	 * @param manufId the primary key for the new manufacturer
	 * @return the new manufacturer
	 */
	public Manufacturer create(long manufId) {
		Manufacturer manufacturer = new ManufacturerImpl();

		manufacturer.setNew(true);
		manufacturer.setPrimaryKey(manufId);

		return manufacturer;
	}

	/**
	 * Removes the manufacturer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param manufId the primary key of the manufacturer
	 * @return the manufacturer that was removed
	 * @throws com.ys.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Manufacturer remove(long manufId)
		throws NoSuchManufacturerException, SystemException {
		return remove(Long.valueOf(manufId));
	}

	/**
	 * Removes the manufacturer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the manufacturer
	 * @return the manufacturer that was removed
	 * @throws com.ys.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer remove(Serializable primaryKey)
		throws NoSuchManufacturerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Manufacturer manufacturer = (Manufacturer)session.get(ManufacturerImpl.class,
					primaryKey);

			if (manufacturer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchManufacturerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(manufacturer);
		}
		catch (NoSuchManufacturerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Manufacturer removeImpl(Manufacturer manufacturer)
		throws SystemException {
		manufacturer = toUnwrappedModel(manufacturer);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, manufacturer);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(manufacturer);

		return manufacturer;
	}

	@Override
	public Manufacturer updateImpl(
		com.ys.parts.model.Manufacturer manufacturer, boolean merge)
		throws SystemException {
		manufacturer = toUnwrappedModel(manufacturer);

		boolean isNew = manufacturer.isNew();

		ManufacturerModelImpl manufacturerModelImpl = (ManufacturerModelImpl)manufacturer;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, manufacturer, merge);

			manufacturer.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ManufacturerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((manufacturerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(manufacturerModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(manufacturerModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
			ManufacturerImpl.class, manufacturer.getPrimaryKey(), manufacturer);

		return manufacturer;
	}

	protected Manufacturer toUnwrappedModel(Manufacturer manufacturer) {
		if (manufacturer instanceof ManufacturerImpl) {
			return manufacturer;
		}

		ManufacturerImpl manufacturerImpl = new ManufacturerImpl();

		manufacturerImpl.setNew(manufacturer.isNew());
		manufacturerImpl.setPrimaryKey(manufacturer.getPrimaryKey());

		manufacturerImpl.setManufId(manufacturer.getManufId());
		manufacturerImpl.setCompanyId(manufacturer.getCompanyId());
		manufacturerImpl.setGroupId(manufacturer.getGroupId());
		manufacturerImpl.setName(manufacturer.getName());
		manufacturerImpl.setEmailAddress(manufacturer.getEmailAddress());
		manufacturerImpl.setWebsite(manufacturer.getWebsite());
		manufacturerImpl.setPhoneNumber(manufacturer.getPhoneNumber());

		return manufacturerImpl;
	}

	/**
	 * Returns the manufacturer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the manufacturer
	 * @return the manufacturer
	 * @throws com.liferay.portal.NoSuchModelException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the manufacturer with the primary key or throws a {@link com.ys.parts.NoSuchManufacturerException} if it could not be found.
	 *
	 * @param manufId the primary key of the manufacturer
	 * @return the manufacturer
	 * @throws com.ys.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Manufacturer findByPrimaryKey(long manufId)
		throws NoSuchManufacturerException, SystemException {
		Manufacturer manufacturer = fetchByPrimaryKey(manufId);

		if (manufacturer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + manufId);
			}

			throw new NoSuchManufacturerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				manufId);
		}

		return manufacturer;
	}

	/**
	 * Returns the manufacturer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the manufacturer
	 * @return the manufacturer, or <code>null</code> if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Manufacturer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the manufacturer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param manufId the primary key of the manufacturer
	 * @return the manufacturer, or <code>null</code> if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Manufacturer fetchByPrimaryKey(long manufId)
		throws SystemException {
		Manufacturer manufacturer = (Manufacturer)EntityCacheUtil.getResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
				ManufacturerImpl.class, manufId);

		if (manufacturer == _nullManufacturer) {
			return null;
		}

		if (manufacturer == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				manufacturer = (Manufacturer)session.get(ManufacturerImpl.class,
						Long.valueOf(manufId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (manufacturer != null) {
					cacheResult(manufacturer);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ManufacturerModelImpl.ENTITY_CACHE_ENABLED,
						ManufacturerImpl.class, manufId, _nullManufacturer);
				}

				closeSession(session);
			}
		}

		return manufacturer;
	}

	/**
	 * Returns all the manufacturers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Manufacturer> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manufacturers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manufacturers
	 * @param end the upper bound of the range of manufacturers (not inclusive)
	 * @return the range of matching manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Manufacturer> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the manufacturers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manufacturers
	 * @param end the upper bound of the range of manufacturers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Manufacturer> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Manufacturer> list = (List<Manufacturer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Manufacturer manufacturer : list) {
				if ((groupId != manufacturer.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MANUFACTURER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ManufacturerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Manufacturer>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first manufacturer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manufacturer
	 * @throws com.ys.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Manufacturer findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchManufacturerException, SystemException {
		Manufacturer manufacturer = fetchByGroupId_First(groupId,
				orderByComparator);

		if (manufacturer != null) {
			return manufacturer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManufacturerException(msg.toString());
	}

	/**
	 * Returns the first manufacturer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Manufacturer fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Manufacturer> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last manufacturer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manufacturer
	 * @throws com.ys.parts.NoSuchManufacturerException if a matching manufacturer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Manufacturer findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchManufacturerException, SystemException {
		Manufacturer manufacturer = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (manufacturer != null) {
			return manufacturer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManufacturerException(msg.toString());
	}

	/**
	 * Returns the last manufacturer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manufacturer, or <code>null</code> if a matching manufacturer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Manufacturer fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<Manufacturer> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the manufacturers before and after the current manufacturer in the ordered set where groupId = &#63;.
	 *
	 * @param manufId the primary key of the current manufacturer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manufacturer
	 * @throws com.ys.parts.NoSuchManufacturerException if a manufacturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Manufacturer[] findByGroupId_PrevAndNext(long manufId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchManufacturerException, SystemException {
		Manufacturer manufacturer = findByPrimaryKey(manufId);

		Session session = null;

		try {
			session = openSession();

			Manufacturer[] array = new ManufacturerImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, manufacturer, groupId,
					orderByComparator, true);

			array[1] = manufacturer;

			array[2] = getByGroupId_PrevAndNext(session, manufacturer, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Manufacturer getByGroupId_PrevAndNext(Session session,
		Manufacturer manufacturer, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MANUFACTURER_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ManufacturerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(manufacturer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Manufacturer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the manufacturers.
	 *
	 * @return the manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Manufacturer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Manufacturer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the manufacturers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of manufacturers
	 * @param end the upper bound of the range of manufacturers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	public List<Manufacturer> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Manufacturer> list = (List<Manufacturer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MANUFACTURER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MANUFACTURER.concat(ManufacturerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Manufacturer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Manufacturer>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the manufacturers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Manufacturer manufacturer : findByGroupId(groupId)) {
			remove(manufacturer);
		}
	}

	/**
	 * Removes all the manufacturers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Manufacturer manufacturer : findAll()) {
			remove(manufacturer);
		}
	}

	/**
	 * Returns the number of manufacturers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MANUFACTURER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of manufacturers.
	 *
	 * @return the number of manufacturers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MANUFACTURER);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the manufacturer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ys.parts.model.Manufacturer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Manufacturer>> listenersList = new ArrayList<ModelListener<Manufacturer>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<Manufacturer>)InstanceFactory.newInstance(
							clazz.getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ManufacturerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = ManufacturerPersistence.class)
	protected ManufacturerPersistence manufacturerPersistence;
	@BeanReference(type = PartsPersistence.class)
	protected PartsPersistence partsPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_MANUFACTURER = "SELECT manufacturer FROM Manufacturer manufacturer";
	private static final String _SQL_SELECT_MANUFACTURER_WHERE = "SELECT manufacturer FROM Manufacturer manufacturer WHERE ";
	private static final String _SQL_COUNT_MANUFACTURER = "SELECT COUNT(manufacturer) FROM Manufacturer manufacturer";
	private static final String _SQL_COUNT_MANUFACTURER_WHERE = "SELECT COUNT(manufacturer) FROM Manufacturer manufacturer WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "manufacturer.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "manufacturer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Manufacturer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Manufacturer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ManufacturerPersistenceImpl.class);
	private static Manufacturer _nullManufacturer = new ManufacturerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Manufacturer> toCacheModel() {
				return _nullManufacturerCacheModel;
			}
		};

	private static CacheModel<Manufacturer> _nullManufacturerCacheModel = new CacheModel<Manufacturer>() {
			public Manufacturer toEntityModel() {
				return _nullManufacturer;
			}
		};
}