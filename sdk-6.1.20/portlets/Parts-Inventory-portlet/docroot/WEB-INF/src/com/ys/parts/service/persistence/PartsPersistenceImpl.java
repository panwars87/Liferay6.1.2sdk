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

import com.ys.parts.NoSuchPartsException;
import com.ys.parts.model.Parts;
import com.ys.parts.model.impl.PartsImpl;
import com.ys.parts.model.impl.PartsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the parts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author shashantp
 * @see PartsPersistence
 * @see PartsUtil
 * @generated
 */
public class PartsPersistenceImpl extends BasePersistenceImpl<Parts>
	implements PartsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PartsUtil} to access the parts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PartsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsModelImpl.FINDER_CACHE_ENABLED, PartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsModelImpl.FINDER_CACHE_ENABLED, PartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			PartsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MANUFACTURER =
		new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsModelImpl.FINDER_CACHE_ENABLED, PartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByManufacturer",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANUFACTURER =
		new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsModelImpl.FINDER_CACHE_ENABLED, PartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByManufacturer",
			new String[] { Long.class.getName(), Long.class.getName() },
			PartsModelImpl.MANUFID_COLUMN_BITMASK |
			PartsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MANUFACTURER = new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByManufacturer",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsModelImpl.FINDER_CACHE_ENABLED, PartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsModelImpl.FINDER_CACHE_ENABLED, PartsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the parts in the entity cache if it is enabled.
	 *
	 * @param parts the parts
	 */
	public void cacheResult(Parts parts) {
		EntityCacheUtil.putResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsImpl.class, parts.getPrimaryKey(), parts);

		parts.resetOriginalValues();
	}

	/**
	 * Caches the partses in the entity cache if it is enabled.
	 *
	 * @param partses the partses
	 */
	public void cacheResult(List<Parts> partses) {
		for (Parts parts : partses) {
			if (EntityCacheUtil.getResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
						PartsImpl.class, parts.getPrimaryKey()) == null) {
				cacheResult(parts);
			}
			else {
				parts.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all partses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PartsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PartsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the parts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Parts parts) {
		EntityCacheUtil.removeResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsImpl.class, parts.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Parts> partses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Parts parts : partses) {
			EntityCacheUtil.removeResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
				PartsImpl.class, parts.getPrimaryKey());
		}
	}

	/**
	 * Creates a new parts with the primary key. Does not add the parts to the database.
	 *
	 * @param partId the primary key for the new parts
	 * @return the new parts
	 */
	public Parts create(long partId) {
		Parts parts = new PartsImpl();

		parts.setNew(true);
		parts.setPrimaryKey(partId);

		return parts;
	}

	/**
	 * Removes the parts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param partId the primary key of the parts
	 * @return the parts that was removed
	 * @throws com.ys.parts.NoSuchPartsException if a parts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parts remove(long partId)
		throws NoSuchPartsException, SystemException {
		return remove(Long.valueOf(partId));
	}

	/**
	 * Removes the parts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the parts
	 * @return the parts that was removed
	 * @throws com.ys.parts.NoSuchPartsException if a parts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Parts remove(Serializable primaryKey)
		throws NoSuchPartsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Parts parts = (Parts)session.get(PartsImpl.class, primaryKey);

			if (parts == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPartsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(parts);
		}
		catch (NoSuchPartsException nsee) {
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
	protected Parts removeImpl(Parts parts) throws SystemException {
		parts = toUnwrappedModel(parts);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, parts);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(parts);

		return parts;
	}

	@Override
	public Parts updateImpl(com.ys.parts.model.Parts parts, boolean merge)
		throws SystemException {
		parts = toUnwrappedModel(parts);

		boolean isNew = parts.isNew();

		PartsModelImpl partsModelImpl = (PartsModelImpl)parts;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, parts, merge);

			parts.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PartsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((partsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(partsModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { Long.valueOf(partsModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((partsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANUFACTURER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(partsModelImpl.getOriginalManufId()),
						Long.valueOf(partsModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MANUFACTURER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANUFACTURER,
					args);

				args = new Object[] {
						Long.valueOf(partsModelImpl.getManufId()),
						Long.valueOf(partsModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MANUFACTURER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANUFACTURER,
					args);
			}
		}

		EntityCacheUtil.putResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
			PartsImpl.class, parts.getPrimaryKey(), parts);

		return parts;
	}

	protected Parts toUnwrappedModel(Parts parts) {
		if (parts instanceof PartsImpl) {
			return parts;
		}

		PartsImpl partsImpl = new PartsImpl();

		partsImpl.setNew(parts.isNew());
		partsImpl.setPrimaryKey(parts.getPrimaryKey());

		partsImpl.setPartId(parts.getPartId());
		partsImpl.setCompanyId(parts.getCompanyId());
		partsImpl.setGroupId(parts.getGroupId());
		partsImpl.setManufId(parts.getManufId());
		partsImpl.setName(parts.getName());
		partsImpl.setPartNumber(parts.getPartNumber());
		partsImpl.setReorderDate(parts.getReorderDate());
		partsImpl.setQuantity(parts.getQuantity());

		return partsImpl;
	}

	/**
	 * Returns the parts with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the parts
	 * @return the parts
	 * @throws com.liferay.portal.NoSuchModelException if a parts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Parts findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the parts with the primary key or throws a {@link com.ys.parts.NoSuchPartsException} if it could not be found.
	 *
	 * @param partId the primary key of the parts
	 * @return the parts
	 * @throws com.ys.parts.NoSuchPartsException if a parts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parts findByPrimaryKey(long partId)
		throws NoSuchPartsException, SystemException {
		Parts parts = fetchByPrimaryKey(partId);

		if (parts == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + partId);
			}

			throw new NoSuchPartsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				partId);
		}

		return parts;
	}

	/**
	 * Returns the parts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parts
	 * @return the parts, or <code>null</code> if a parts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Parts fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the parts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param partId the primary key of the parts
	 * @return the parts, or <code>null</code> if a parts with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parts fetchByPrimaryKey(long partId) throws SystemException {
		Parts parts = (Parts)EntityCacheUtil.getResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
				PartsImpl.class, partId);

		if (parts == _nullParts) {
			return null;
		}

		if (parts == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				parts = (Parts)session.get(PartsImpl.class, Long.valueOf(partId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (parts != null) {
					cacheResult(parts);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PartsModelImpl.ENTITY_CACHE_ENABLED,
						PartsImpl.class, partId, _nullParts);
				}

				closeSession(session);
			}
		}

		return parts;
	}

	/**
	 * Returns all the partses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching partses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Parts> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Parts> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

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
	public List<Parts> findByGroupId(long groupId, int start, int end,
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

		List<Parts> list = (List<Parts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Parts parts : list) {
				if ((groupId != parts.getGroupId())) {
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

			query.append(_SQL_SELECT_PARTS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PartsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Parts>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first parts in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parts
	 * @throws com.ys.parts.NoSuchPartsException if a matching parts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parts findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPartsException, SystemException {
		Parts parts = fetchByGroupId_First(groupId, orderByComparator);

		if (parts != null) {
			return parts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartsException(msg.toString());
	}

	/**
	 * Returns the first parts in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parts, or <code>null</code> if a matching parts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parts fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Parts> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last parts in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parts
	 * @throws com.ys.parts.NoSuchPartsException if a matching parts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parts findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPartsException, SystemException {
		Parts parts = fetchByGroupId_Last(groupId, orderByComparator);

		if (parts != null) {
			return parts;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartsException(msg.toString());
	}

	/**
	 * Returns the last parts in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parts, or <code>null</code> if a matching parts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parts fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<Parts> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Parts[] findByGroupId_PrevAndNext(long partId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPartsException, SystemException {
		Parts parts = findByPrimaryKey(partId);

		Session session = null;

		try {
			session = openSession();

			Parts[] array = new PartsImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, parts, groupId,
					orderByComparator, true);

			array[1] = parts;

			array[2] = getByGroupId_PrevAndNext(session, parts, groupId,
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

	protected Parts getByGroupId_PrevAndNext(Session session, Parts parts,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PARTS_WHERE);

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
			query.append(PartsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(parts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Parts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the partses where manufId = &#63; and groupId = &#63;.
	 *
	 * @param manufId the manuf ID
	 * @param groupId the group ID
	 * @return the matching partses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Parts> findByManufacturer(long manufId, long groupId)
		throws SystemException {
		return findByManufacturer(manufId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<Parts> findByManufacturer(long manufId, long groupId,
		int start, int end) throws SystemException {
		return findByManufacturer(manufId, groupId, start, end, null);
	}

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
	public List<Parts> findByManufacturer(long manufId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANUFACTURER;
			finderArgs = new Object[] { manufId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MANUFACTURER;
			finderArgs = new Object[] {
					manufId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Parts> list = (List<Parts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Parts parts : list) {
				if ((manufId != parts.getManufId()) ||
						(groupId != parts.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PARTS_WHERE);

			query.append(_FINDER_COLUMN_MANUFACTURER_MANUFID_2);

			query.append(_FINDER_COLUMN_MANUFACTURER_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PartsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(manufId);

				qPos.add(groupId);

				list = (List<Parts>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first parts in the ordered set where manufId = &#63; and groupId = &#63;.
	 *
	 * @param manufId the manuf ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parts
	 * @throws com.ys.parts.NoSuchPartsException if a matching parts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parts findByManufacturer_First(long manufId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPartsException, SystemException {
		Parts parts = fetchByManufacturer_First(manufId, groupId,
				orderByComparator);

		if (parts != null) {
			return parts;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("manufId=");
		msg.append(manufId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartsException(msg.toString());
	}

	/**
	 * Returns the first parts in the ordered set where manufId = &#63; and groupId = &#63;.
	 *
	 * @param manufId the manuf ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parts, or <code>null</code> if a matching parts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parts fetchByManufacturer_First(long manufId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Parts> list = findByManufacturer(manufId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Parts findByManufacturer_Last(long manufId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchPartsException, SystemException {
		Parts parts = fetchByManufacturer_Last(manufId, groupId,
				orderByComparator);

		if (parts != null) {
			return parts;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("manufId=");
		msg.append(manufId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPartsException(msg.toString());
	}

	/**
	 * Returns the last parts in the ordered set where manufId = &#63; and groupId = &#63;.
	 *
	 * @param manufId the manuf ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parts, or <code>null</code> if a matching parts could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parts fetchByManufacturer_Last(long manufId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByManufacturer(manufId, groupId);

		List<Parts> list = findByManufacturer(manufId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Parts[] findByManufacturer_PrevAndNext(long partId, long manufId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchPartsException, SystemException {
		Parts parts = findByPrimaryKey(partId);

		Session session = null;

		try {
			session = openSession();

			Parts[] array = new PartsImpl[3];

			array[0] = getByManufacturer_PrevAndNext(session, parts, manufId,
					groupId, orderByComparator, true);

			array[1] = parts;

			array[2] = getByManufacturer_PrevAndNext(session, parts, manufId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Parts getByManufacturer_PrevAndNext(Session session, Parts parts,
		long manufId, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PARTS_WHERE);

		query.append(_FINDER_COLUMN_MANUFACTURER_MANUFID_2);

		query.append(_FINDER_COLUMN_MANUFACTURER_GROUPID_2);

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
			query.append(PartsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(manufId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(parts);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Parts> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the partses.
	 *
	 * @return the partses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Parts> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Parts> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<Parts> findAll(int start, int end,
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

		List<Parts> list = (List<Parts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PARTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PARTS.concat(PartsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Parts>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Parts>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the partses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Parts parts : findByGroupId(groupId)) {
			remove(parts);
		}
	}

	/**
	 * Removes all the partses where manufId = &#63; and groupId = &#63; from the database.
	 *
	 * @param manufId the manuf ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByManufacturer(long manufId, long groupId)
		throws SystemException {
		for (Parts parts : findByManufacturer(manufId, groupId)) {
			remove(parts);
		}
	}

	/**
	 * Removes all the partses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Parts parts : findAll()) {
			remove(parts);
		}
	}

	/**
	 * Returns the number of partses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching partses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PARTS_WHERE);

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
	 * Returns the number of partses where manufId = &#63; and groupId = &#63;.
	 *
	 * @param manufId the manuf ID
	 * @param groupId the group ID
	 * @return the number of matching partses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByManufacturer(long manufId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { manufId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MANUFACTURER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PARTS_WHERE);

			query.append(_FINDER_COLUMN_MANUFACTURER_MANUFID_2);

			query.append(_FINDER_COLUMN_MANUFACTURER_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(manufId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MANUFACTURER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of partses.
	 *
	 * @return the number of partses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PARTS);

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
	 * Initializes the parts persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ys.parts.model.Parts")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Parts>> listenersList = new ArrayList<ModelListener<Parts>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<Parts>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PartsImpl.class.getName());
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
	private static final String _SQL_SELECT_PARTS = "SELECT parts FROM Parts parts";
	private static final String _SQL_SELECT_PARTS_WHERE = "SELECT parts FROM Parts parts WHERE ";
	private static final String _SQL_COUNT_PARTS = "SELECT COUNT(parts) FROM Parts parts";
	private static final String _SQL_COUNT_PARTS_WHERE = "SELECT COUNT(parts) FROM Parts parts WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "parts.groupId = ?";
	private static final String _FINDER_COLUMN_MANUFACTURER_MANUFID_2 = "parts.manufId = ? AND ";
	private static final String _FINDER_COLUMN_MANUFACTURER_GROUPID_2 = "parts.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "parts.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Parts exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Parts exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PartsPersistenceImpl.class);
	private static Parts _nullParts = new PartsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Parts> toCacheModel() {
				return _nullPartsCacheModel;
			}
		};

	private static CacheModel<Parts> _nullPartsCacheModel = new CacheModel<Parts>() {
			public Parts toEntityModel() {
				return _nullParts;
			}
		};
}