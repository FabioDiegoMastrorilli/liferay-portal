/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.commerce.pricing.service.persistence.impl;

import com.liferay.commerce.pricing.exception.NoSuchPricingClassCPDefinitionRelException;
import com.liferay.commerce.pricing.model.CommercePricingClassCPDefinitionRel;
import com.liferay.commerce.pricing.model.CommercePricingClassCPDefinitionRelTable;
import com.liferay.commerce.pricing.model.impl.CommercePricingClassCPDefinitionRelImpl;
import com.liferay.commerce.pricing.model.impl.CommercePricingClassCPDefinitionRelModelImpl;
import com.liferay.commerce.pricing.service.persistence.CommercePricingClassCPDefinitionRelPersistence;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the commerce pricing class cp definition rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Riccardo Alberti
 * @generated
 */
public class CommercePricingClassCPDefinitionRelPersistenceImpl
	extends BasePersistenceImpl<CommercePricingClassCPDefinitionRel>
	implements CommercePricingClassCPDefinitionRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommercePricingClassCPDefinitionRelUtil</code> to access the commerce pricing class cp definition rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommercePricingClassCPDefinitionRelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCommercePricingClassId;
	private FinderPath _finderPathWithoutPaginationFindByCommercePricingClassId;
	private FinderPath _finderPathCountByCommercePricingClassId;

	/**
	 * Returns all the commerce pricing class cp definition rels where commercePricingClassId = &#63;.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @return the matching commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel>
		findByCommercePricingClassId(long commercePricingClassId) {

		return findByCommercePricingClassId(
			commercePricingClassId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce pricing class cp definition rels where commercePricingClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param start the lower bound of the range of commerce pricing class cp definition rels
	 * @param end the upper bound of the range of commerce pricing class cp definition rels (not inclusive)
	 * @return the range of matching commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel>
		findByCommercePricingClassId(
			long commercePricingClassId, int start, int end) {

		return findByCommercePricingClassId(
			commercePricingClassId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce pricing class cp definition rels where commercePricingClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param start the lower bound of the range of commerce pricing class cp definition rels
	 * @param end the upper bound of the range of commerce pricing class cp definition rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel>
		findByCommercePricingClassId(
			long commercePricingClassId, int start, int end,
			OrderByComparator<CommercePricingClassCPDefinitionRel>
				orderByComparator) {

		return findByCommercePricingClassId(
			commercePricingClassId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce pricing class cp definition rels where commercePricingClassId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param start the lower bound of the range of commerce pricing class cp definition rels
	 * @param end the upper bound of the range of commerce pricing class cp definition rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel>
		findByCommercePricingClassId(
			long commercePricingClassId, int start, int end,
			OrderByComparator<CommercePricingClassCPDefinitionRel>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCommercePricingClassId;
				finderArgs = new Object[] {commercePricingClassId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCommercePricingClassId;
			finderArgs = new Object[] {
				commercePricingClassId, start, end, orderByComparator
			};
		}

		List<CommercePricingClassCPDefinitionRel> list = null;

		if (useFinderCache) {
			list =
				(List<CommercePricingClassCPDefinitionRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePricingClassCPDefinitionRel
						commercePricingClassCPDefinitionRel : list) {

					if (commercePricingClassId !=
							commercePricingClassCPDefinitionRel.
								getCommercePricingClassId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_COMMERCEPRICINGCLASSCPDEFINITIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_COMMERCEPRICINGCLASSID_COMMERCEPRICINGCLASSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					CommercePricingClassCPDefinitionRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercePricingClassId);

				list =
					(List<CommercePricingClassCPDefinitionRel>)QueryUtil.list(
						query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first commerce pricing class cp definition rel in the ordered set where commercePricingClassId = &#63;.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce pricing class cp definition rel
	 * @throws NoSuchPricingClassCPDefinitionRelException if a matching commerce pricing class cp definition rel could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel
			findByCommercePricingClassId_First(
				long commercePricingClassId,
				OrderByComparator<CommercePricingClassCPDefinitionRel>
					orderByComparator)
		throws NoSuchPricingClassCPDefinitionRelException {

		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel =
				fetchByCommercePricingClassId_First(
					commercePricingClassId, orderByComparator);

		if (commercePricingClassCPDefinitionRel != null) {
			return commercePricingClassCPDefinitionRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercePricingClassId=");
		sb.append(commercePricingClassId);

		sb.append("}");

		throw new NoSuchPricingClassCPDefinitionRelException(sb.toString());
	}

	/**
	 * Returns the first commerce pricing class cp definition rel in the ordered set where commercePricingClassId = &#63;.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce pricing class cp definition rel, or <code>null</code> if a matching commerce pricing class cp definition rel could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel
		fetchByCommercePricingClassId_First(
			long commercePricingClassId,
			OrderByComparator<CommercePricingClassCPDefinitionRel>
				orderByComparator) {

		List<CommercePricingClassCPDefinitionRel> list =
			findByCommercePricingClassId(
				commercePricingClassId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce pricing class cp definition rel in the ordered set where commercePricingClassId = &#63;.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce pricing class cp definition rel
	 * @throws NoSuchPricingClassCPDefinitionRelException if a matching commerce pricing class cp definition rel could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel
			findByCommercePricingClassId_Last(
				long commercePricingClassId,
				OrderByComparator<CommercePricingClassCPDefinitionRel>
					orderByComparator)
		throws NoSuchPricingClassCPDefinitionRelException {

		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel =
				fetchByCommercePricingClassId_Last(
					commercePricingClassId, orderByComparator);

		if (commercePricingClassCPDefinitionRel != null) {
			return commercePricingClassCPDefinitionRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercePricingClassId=");
		sb.append(commercePricingClassId);

		sb.append("}");

		throw new NoSuchPricingClassCPDefinitionRelException(sb.toString());
	}

	/**
	 * Returns the last commerce pricing class cp definition rel in the ordered set where commercePricingClassId = &#63;.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce pricing class cp definition rel, or <code>null</code> if a matching commerce pricing class cp definition rel could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel
		fetchByCommercePricingClassId_Last(
			long commercePricingClassId,
			OrderByComparator<CommercePricingClassCPDefinitionRel>
				orderByComparator) {

		int count = countByCommercePricingClassId(commercePricingClassId);

		if (count == 0) {
			return null;
		}

		List<CommercePricingClassCPDefinitionRel> list =
			findByCommercePricingClassId(
				commercePricingClassId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce pricing class cp definition rels before and after the current commerce pricing class cp definition rel in the ordered set where commercePricingClassId = &#63;.
	 *
	 * @param CommercePricingClassCPDefinitionRelId the primary key of the current commerce pricing class cp definition rel
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce pricing class cp definition rel
	 * @throws NoSuchPricingClassCPDefinitionRelException if a commerce pricing class cp definition rel with the primary key could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel[]
			findByCommercePricingClassId_PrevAndNext(
				long CommercePricingClassCPDefinitionRelId,
				long commercePricingClassId,
				OrderByComparator<CommercePricingClassCPDefinitionRel>
					orderByComparator)
		throws NoSuchPricingClassCPDefinitionRelException {

		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel = findByPrimaryKey(
				CommercePricingClassCPDefinitionRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePricingClassCPDefinitionRel[] array =
				new CommercePricingClassCPDefinitionRelImpl[3];

			array[0] = getByCommercePricingClassId_PrevAndNext(
				session, commercePricingClassCPDefinitionRel,
				commercePricingClassId, orderByComparator, true);

			array[1] = commercePricingClassCPDefinitionRel;

			array[2] = getByCommercePricingClassId_PrevAndNext(
				session, commercePricingClassCPDefinitionRel,
				commercePricingClassId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommercePricingClassCPDefinitionRel
		getByCommercePricingClassId_PrevAndNext(
			Session session,
			CommercePricingClassCPDefinitionRel
				commercePricingClassCPDefinitionRel,
			long commercePricingClassId,
			OrderByComparator<CommercePricingClassCPDefinitionRel>
				orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMERCEPRICINGCLASSCPDEFINITIONREL_WHERE);

		sb.append(
			_FINDER_COLUMN_COMMERCEPRICINGCLASSID_COMMERCEPRICINGCLASSID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(
				CommercePricingClassCPDefinitionRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(commercePricingClassId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePricingClassCPDefinitionRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommercePricingClassCPDefinitionRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce pricing class cp definition rels where commercePricingClassId = &#63; from the database.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 */
	@Override
	public void removeByCommercePricingClassId(long commercePricingClassId) {
		for (CommercePricingClassCPDefinitionRel
				commercePricingClassCPDefinitionRel :
					findByCommercePricingClassId(
						commercePricingClassId, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null)) {

			remove(commercePricingClassCPDefinitionRel);
		}
	}

	/**
	 * Returns the number of commerce pricing class cp definition rels where commercePricingClassId = &#63;.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @return the number of matching commerce pricing class cp definition rels
	 */
	@Override
	public int countByCommercePricingClassId(long commercePricingClassId) {
		FinderPath finderPath = _finderPathCountByCommercePricingClassId;

		Object[] finderArgs = new Object[] {commercePricingClassId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMERCEPRICINGCLASSCPDEFINITIONREL_WHERE);

			sb.append(
				_FINDER_COLUMN_COMMERCEPRICINGCLASSID_COMMERCEPRICINGCLASSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercePricingClassId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_COMMERCEPRICINGCLASSID_COMMERCEPRICINGCLASSID_2 =
			"commercePricingClassCPDefinitionRel.commercePricingClassId = ?";

	private FinderPath _finderPathWithPaginationFindByCPDefinitionId;
	private FinderPath _finderPathWithoutPaginationFindByCPDefinitionId;
	private FinderPath _finderPathCountByCPDefinitionId;

	/**
	 * Returns all the commerce pricing class cp definition rels where CPDefinitionId = &#63;.
	 *
	 * @param CPDefinitionId the cp definition ID
	 * @return the matching commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel> findByCPDefinitionId(
		long CPDefinitionId) {

		return findByCPDefinitionId(
			CPDefinitionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce pricing class cp definition rels where CPDefinitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param CPDefinitionId the cp definition ID
	 * @param start the lower bound of the range of commerce pricing class cp definition rels
	 * @param end the upper bound of the range of commerce pricing class cp definition rels (not inclusive)
	 * @return the range of matching commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel> findByCPDefinitionId(
		long CPDefinitionId, int start, int end) {

		return findByCPDefinitionId(CPDefinitionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce pricing class cp definition rels where CPDefinitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param CPDefinitionId the cp definition ID
	 * @param start the lower bound of the range of commerce pricing class cp definition rels
	 * @param end the upper bound of the range of commerce pricing class cp definition rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel> findByCPDefinitionId(
		long CPDefinitionId, int start, int end,
		OrderByComparator<CommercePricingClassCPDefinitionRel>
			orderByComparator) {

		return findByCPDefinitionId(
			CPDefinitionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce pricing class cp definition rels where CPDefinitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param CPDefinitionId the cp definition ID
	 * @param start the lower bound of the range of commerce pricing class cp definition rels
	 * @param end the upper bound of the range of commerce pricing class cp definition rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel> findByCPDefinitionId(
		long CPDefinitionId, int start, int end,
		OrderByComparator<CommercePricingClassCPDefinitionRel>
			orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCPDefinitionId;
				finderArgs = new Object[] {CPDefinitionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCPDefinitionId;
			finderArgs = new Object[] {
				CPDefinitionId, start, end, orderByComparator
			};
		}

		List<CommercePricingClassCPDefinitionRel> list = null;

		if (useFinderCache) {
			list =
				(List<CommercePricingClassCPDefinitionRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommercePricingClassCPDefinitionRel
						commercePricingClassCPDefinitionRel : list) {

					if (CPDefinitionId !=
							commercePricingClassCPDefinitionRel.
								getCPDefinitionId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_COMMERCEPRICINGCLASSCPDEFINITIONREL_WHERE);

			sb.append(_FINDER_COLUMN_CPDEFINITIONID_CPDEFINITIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					CommercePricingClassCPDefinitionRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CPDefinitionId);

				list =
					(List<CommercePricingClassCPDefinitionRel>)QueryUtil.list(
						query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first commerce pricing class cp definition rel in the ordered set where CPDefinitionId = &#63;.
	 *
	 * @param CPDefinitionId the cp definition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce pricing class cp definition rel
	 * @throws NoSuchPricingClassCPDefinitionRelException if a matching commerce pricing class cp definition rel could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel findByCPDefinitionId_First(
			long CPDefinitionId,
			OrderByComparator<CommercePricingClassCPDefinitionRel>
				orderByComparator)
		throws NoSuchPricingClassCPDefinitionRelException {

		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel = fetchByCPDefinitionId_First(
				CPDefinitionId, orderByComparator);

		if (commercePricingClassCPDefinitionRel != null) {
			return commercePricingClassCPDefinitionRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CPDefinitionId=");
		sb.append(CPDefinitionId);

		sb.append("}");

		throw new NoSuchPricingClassCPDefinitionRelException(sb.toString());
	}

	/**
	 * Returns the first commerce pricing class cp definition rel in the ordered set where CPDefinitionId = &#63;.
	 *
	 * @param CPDefinitionId the cp definition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commerce pricing class cp definition rel, or <code>null</code> if a matching commerce pricing class cp definition rel could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel fetchByCPDefinitionId_First(
		long CPDefinitionId,
		OrderByComparator<CommercePricingClassCPDefinitionRel>
			orderByComparator) {

		List<CommercePricingClassCPDefinitionRel> list = findByCPDefinitionId(
			CPDefinitionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commerce pricing class cp definition rel in the ordered set where CPDefinitionId = &#63;.
	 *
	 * @param CPDefinitionId the cp definition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce pricing class cp definition rel
	 * @throws NoSuchPricingClassCPDefinitionRelException if a matching commerce pricing class cp definition rel could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel findByCPDefinitionId_Last(
			long CPDefinitionId,
			OrderByComparator<CommercePricingClassCPDefinitionRel>
				orderByComparator)
		throws NoSuchPricingClassCPDefinitionRelException {

		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel = fetchByCPDefinitionId_Last(
				CPDefinitionId, orderByComparator);

		if (commercePricingClassCPDefinitionRel != null) {
			return commercePricingClassCPDefinitionRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("CPDefinitionId=");
		sb.append(CPDefinitionId);

		sb.append("}");

		throw new NoSuchPricingClassCPDefinitionRelException(sb.toString());
	}

	/**
	 * Returns the last commerce pricing class cp definition rel in the ordered set where CPDefinitionId = &#63;.
	 *
	 * @param CPDefinitionId the cp definition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commerce pricing class cp definition rel, or <code>null</code> if a matching commerce pricing class cp definition rel could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel fetchByCPDefinitionId_Last(
		long CPDefinitionId,
		OrderByComparator<CommercePricingClassCPDefinitionRel>
			orderByComparator) {

		int count = countByCPDefinitionId(CPDefinitionId);

		if (count == 0) {
			return null;
		}

		List<CommercePricingClassCPDefinitionRel> list = findByCPDefinitionId(
			CPDefinitionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commerce pricing class cp definition rels before and after the current commerce pricing class cp definition rel in the ordered set where CPDefinitionId = &#63;.
	 *
	 * @param CommercePricingClassCPDefinitionRelId the primary key of the current commerce pricing class cp definition rel
	 * @param CPDefinitionId the cp definition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commerce pricing class cp definition rel
	 * @throws NoSuchPricingClassCPDefinitionRelException if a commerce pricing class cp definition rel with the primary key could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel[]
			findByCPDefinitionId_PrevAndNext(
				long CommercePricingClassCPDefinitionRelId, long CPDefinitionId,
				OrderByComparator<CommercePricingClassCPDefinitionRel>
					orderByComparator)
		throws NoSuchPricingClassCPDefinitionRelException {

		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel = findByPrimaryKey(
				CommercePricingClassCPDefinitionRelId);

		Session session = null;

		try {
			session = openSession();

			CommercePricingClassCPDefinitionRel[] array =
				new CommercePricingClassCPDefinitionRelImpl[3];

			array[0] = getByCPDefinitionId_PrevAndNext(
				session, commercePricingClassCPDefinitionRel, CPDefinitionId,
				orderByComparator, true);

			array[1] = commercePricingClassCPDefinitionRel;

			array[2] = getByCPDefinitionId_PrevAndNext(
				session, commercePricingClassCPDefinitionRel, CPDefinitionId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommercePricingClassCPDefinitionRel
		getByCPDefinitionId_PrevAndNext(
			Session session,
			CommercePricingClassCPDefinitionRel
				commercePricingClassCPDefinitionRel,
			long CPDefinitionId,
			OrderByComparator<CommercePricingClassCPDefinitionRel>
				orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMERCEPRICINGCLASSCPDEFINITIONREL_WHERE);

		sb.append(_FINDER_COLUMN_CPDEFINITIONID_CPDEFINITIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(
				CommercePricingClassCPDefinitionRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(CPDefinitionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						commercePricingClassCPDefinitionRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CommercePricingClassCPDefinitionRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commerce pricing class cp definition rels where CPDefinitionId = &#63; from the database.
	 *
	 * @param CPDefinitionId the cp definition ID
	 */
	@Override
	public void removeByCPDefinitionId(long CPDefinitionId) {
		for (CommercePricingClassCPDefinitionRel
				commercePricingClassCPDefinitionRel :
					findByCPDefinitionId(
						CPDefinitionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(commercePricingClassCPDefinitionRel);
		}
	}

	/**
	 * Returns the number of commerce pricing class cp definition rels where CPDefinitionId = &#63;.
	 *
	 * @param CPDefinitionId the cp definition ID
	 * @return the number of matching commerce pricing class cp definition rels
	 */
	@Override
	public int countByCPDefinitionId(long CPDefinitionId) {
		FinderPath finderPath = _finderPathCountByCPDefinitionId;

		Object[] finderArgs = new Object[] {CPDefinitionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMERCEPRICINGCLASSCPDEFINITIONREL_WHERE);

			sb.append(_FINDER_COLUMN_CPDEFINITIONID_CPDEFINITIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(CPDefinitionId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CPDEFINITIONID_CPDEFINITIONID_2 =
		"commercePricingClassCPDefinitionRel.CPDefinitionId = ?";

	private FinderPath _finderPathFetchByC_C;
	private FinderPath _finderPathCountByC_C;

	/**
	 * Returns the commerce pricing class cp definition rel where commercePricingClassId = &#63; and CPDefinitionId = &#63; or throws a <code>NoSuchPricingClassCPDefinitionRelException</code> if it could not be found.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param CPDefinitionId the cp definition ID
	 * @return the matching commerce pricing class cp definition rel
	 * @throws NoSuchPricingClassCPDefinitionRelException if a matching commerce pricing class cp definition rel could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel findByC_C(
			long commercePricingClassId, long CPDefinitionId)
		throws NoSuchPricingClassCPDefinitionRelException {

		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel = fetchByC_C(
				commercePricingClassId, CPDefinitionId);

		if (commercePricingClassCPDefinitionRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("commercePricingClassId=");
			sb.append(commercePricingClassId);

			sb.append(", CPDefinitionId=");
			sb.append(CPDefinitionId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPricingClassCPDefinitionRelException(sb.toString());
		}

		return commercePricingClassCPDefinitionRel;
	}

	/**
	 * Returns the commerce pricing class cp definition rel where commercePricingClassId = &#63; and CPDefinitionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param CPDefinitionId the cp definition ID
	 * @return the matching commerce pricing class cp definition rel, or <code>null</code> if a matching commerce pricing class cp definition rel could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel fetchByC_C(
		long commercePricingClassId, long CPDefinitionId) {

		return fetchByC_C(commercePricingClassId, CPDefinitionId, true);
	}

	/**
	 * Returns the commerce pricing class cp definition rel where commercePricingClassId = &#63; and CPDefinitionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param CPDefinitionId the cp definition ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commerce pricing class cp definition rel, or <code>null</code> if a matching commerce pricing class cp definition rel could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel fetchByC_C(
		long commercePricingClassId, long CPDefinitionId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {commercePricingClassId, CPDefinitionId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_C, finderArgs, this);
		}

		if (result instanceof CommercePricingClassCPDefinitionRel) {
			CommercePricingClassCPDefinitionRel
				commercePricingClassCPDefinitionRel =
					(CommercePricingClassCPDefinitionRel)result;

			if ((commercePricingClassId !=
					commercePricingClassCPDefinitionRel.
						getCommercePricingClassId()) ||
				(CPDefinitionId !=
					commercePricingClassCPDefinitionRel.getCPDefinitionId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COMMERCEPRICINGCLASSCPDEFINITIONREL_WHERE);

			sb.append(_FINDER_COLUMN_C_C_COMMERCEPRICINGCLASSID_2);

			sb.append(_FINDER_COLUMN_C_C_CPDEFINITIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercePricingClassId);

				queryPos.add(CPDefinitionId);

				List<CommercePricingClassCPDefinitionRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_C, finderArgs, list);
					}
				}
				else {
					CommercePricingClassCPDefinitionRel
						commercePricingClassCPDefinitionRel = list.get(0);

					result = commercePricingClassCPDefinitionRel;

					cacheResult(commercePricingClassCPDefinitionRel);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CommercePricingClassCPDefinitionRel)result;
		}
	}

	/**
	 * Removes the commerce pricing class cp definition rel where commercePricingClassId = &#63; and CPDefinitionId = &#63; from the database.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param CPDefinitionId the cp definition ID
	 * @return the commerce pricing class cp definition rel that was removed
	 */
	@Override
	public CommercePricingClassCPDefinitionRel removeByC_C(
			long commercePricingClassId, long CPDefinitionId)
		throws NoSuchPricingClassCPDefinitionRelException {

		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel = findByC_C(
				commercePricingClassId, CPDefinitionId);

		return remove(commercePricingClassCPDefinitionRel);
	}

	/**
	 * Returns the number of commerce pricing class cp definition rels where commercePricingClassId = &#63; and CPDefinitionId = &#63;.
	 *
	 * @param commercePricingClassId the commerce pricing class ID
	 * @param CPDefinitionId the cp definition ID
	 * @return the number of matching commerce pricing class cp definition rels
	 */
	@Override
	public int countByC_C(long commercePricingClassId, long CPDefinitionId) {
		FinderPath finderPath = _finderPathCountByC_C;

		Object[] finderArgs = new Object[] {
			commercePricingClassId, CPDefinitionId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMMERCEPRICINGCLASSCPDEFINITIONREL_WHERE);

			sb.append(_FINDER_COLUMN_C_C_COMMERCEPRICINGCLASSID_2);

			sb.append(_FINDER_COLUMN_C_C_CPDEFINITIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercePricingClassId);

				queryPos.add(CPDefinitionId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_C_COMMERCEPRICINGCLASSID_2 =
		"commercePricingClassCPDefinitionRel.commercePricingClassId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_CPDEFINITIONID_2 =
		"commercePricingClassCPDefinitionRel.CPDefinitionId = ?";

	public CommercePricingClassCPDefinitionRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put(
			"CommercePricingClassCPDefinitionRelId",
			"CPricingClassCPDefinitionRelId");

		setDBColumnNames(dbColumnNames);

		setModelClass(CommercePricingClassCPDefinitionRel.class);

		setModelImplClass(CommercePricingClassCPDefinitionRelImpl.class);
		setModelPKClass(long.class);

		setTable(CommercePricingClassCPDefinitionRelTable.INSTANCE);
	}

	/**
	 * Caches the commerce pricing class cp definition rel in the entity cache if it is enabled.
	 *
	 * @param commercePricingClassCPDefinitionRel the commerce pricing class cp definition rel
	 */
	@Override
	public void cacheResult(
		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel) {

		entityCache.putResult(
			CommercePricingClassCPDefinitionRelImpl.class,
			commercePricingClassCPDefinitionRel.getPrimaryKey(),
			commercePricingClassCPDefinitionRel);

		finderCache.putResult(
			_finderPathFetchByC_C,
			new Object[] {
				commercePricingClassCPDefinitionRel.getCommercePricingClassId(),
				commercePricingClassCPDefinitionRel.getCPDefinitionId()
			},
			commercePricingClassCPDefinitionRel);
	}

	/**
	 * Caches the commerce pricing class cp definition rels in the entity cache if it is enabled.
	 *
	 * @param commercePricingClassCPDefinitionRels the commerce pricing class cp definition rels
	 */
	@Override
	public void cacheResult(
		List<CommercePricingClassCPDefinitionRel>
			commercePricingClassCPDefinitionRels) {

		for (CommercePricingClassCPDefinitionRel
				commercePricingClassCPDefinitionRel :
					commercePricingClassCPDefinitionRels) {

			if (entityCache.getResult(
					CommercePricingClassCPDefinitionRelImpl.class,
					commercePricingClassCPDefinitionRel.getPrimaryKey()) ==
						null) {

				cacheResult(commercePricingClassCPDefinitionRel);
			}
		}
	}

	/**
	 * Clears the cache for all commerce pricing class cp definition rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommercePricingClassCPDefinitionRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the commerce pricing class cp definition rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel) {

		entityCache.removeResult(
			CommercePricingClassCPDefinitionRelImpl.class,
			commercePricingClassCPDefinitionRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(CommercePricingClassCPDefinitionRelModelImpl)
				commercePricingClassCPDefinitionRel,
			true);
	}

	@Override
	public void clearCache(
		List<CommercePricingClassCPDefinitionRel>
			commercePricingClassCPDefinitionRels) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommercePricingClassCPDefinitionRel
				commercePricingClassCPDefinitionRel :
					commercePricingClassCPDefinitionRels) {

			entityCache.removeResult(
				CommercePricingClassCPDefinitionRelImpl.class,
				commercePricingClassCPDefinitionRel.getPrimaryKey());

			clearUniqueFindersCache(
				(CommercePricingClassCPDefinitionRelModelImpl)
					commercePricingClassCPDefinitionRel,
				true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				CommercePricingClassCPDefinitionRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CommercePricingClassCPDefinitionRelModelImpl
			commercePricingClassCPDefinitionRelModelImpl) {

		Object[] args = new Object[] {
			commercePricingClassCPDefinitionRelModelImpl.
				getCommercePricingClassId(),
			commercePricingClassCPDefinitionRelModelImpl.getCPDefinitionId()
		};

		finderCache.putResult(
			_finderPathCountByC_C, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_C, args,
			commercePricingClassCPDefinitionRelModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CommercePricingClassCPDefinitionRelModelImpl
			commercePricingClassCPDefinitionRelModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				commercePricingClassCPDefinitionRelModelImpl.
					getCommercePricingClassId(),
				commercePricingClassCPDefinitionRelModelImpl.getCPDefinitionId()
			};

			finderCache.removeResult(_finderPathCountByC_C, args);
			finderCache.removeResult(_finderPathFetchByC_C, args);
		}

		if ((commercePricingClassCPDefinitionRelModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_C.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				commercePricingClassCPDefinitionRelModelImpl.
					getColumnOriginalValue("commercePricingClassId"),
				commercePricingClassCPDefinitionRelModelImpl.
					getColumnOriginalValue("CPDefinitionId")
			};

			finderCache.removeResult(_finderPathCountByC_C, args);
			finderCache.removeResult(_finderPathFetchByC_C, args);
		}
	}

	/**
	 * Creates a new commerce pricing class cp definition rel with the primary key. Does not add the commerce pricing class cp definition rel to the database.
	 *
	 * @param CommercePricingClassCPDefinitionRelId the primary key for the new commerce pricing class cp definition rel
	 * @return the new commerce pricing class cp definition rel
	 */
	@Override
	public CommercePricingClassCPDefinitionRel create(
		long CommercePricingClassCPDefinitionRelId) {

		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel =
				new CommercePricingClassCPDefinitionRelImpl();

		commercePricingClassCPDefinitionRel.setNew(true);
		commercePricingClassCPDefinitionRel.setPrimaryKey(
			CommercePricingClassCPDefinitionRelId);

		commercePricingClassCPDefinitionRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return commercePricingClassCPDefinitionRel;
	}

	/**
	 * Removes the commerce pricing class cp definition rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param CommercePricingClassCPDefinitionRelId the primary key of the commerce pricing class cp definition rel
	 * @return the commerce pricing class cp definition rel that was removed
	 * @throws NoSuchPricingClassCPDefinitionRelException if a commerce pricing class cp definition rel with the primary key could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel remove(
			long CommercePricingClassCPDefinitionRelId)
		throws NoSuchPricingClassCPDefinitionRelException {

		return remove((Serializable)CommercePricingClassCPDefinitionRelId);
	}

	/**
	 * Removes the commerce pricing class cp definition rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the commerce pricing class cp definition rel
	 * @return the commerce pricing class cp definition rel that was removed
	 * @throws NoSuchPricingClassCPDefinitionRelException if a commerce pricing class cp definition rel with the primary key could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel remove(Serializable primaryKey)
		throws NoSuchPricingClassCPDefinitionRelException {

		Session session = null;

		try {
			session = openSession();

			CommercePricingClassCPDefinitionRel
				commercePricingClassCPDefinitionRel =
					(CommercePricingClassCPDefinitionRel)session.get(
						CommercePricingClassCPDefinitionRelImpl.class,
						primaryKey);

			if (commercePricingClassCPDefinitionRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPricingClassCPDefinitionRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(commercePricingClassCPDefinitionRel);
		}
		catch (NoSuchPricingClassCPDefinitionRelException
					noSuchEntityException) {

			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CommercePricingClassCPDefinitionRel removeImpl(
		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commercePricingClassCPDefinitionRel)) {
				commercePricingClassCPDefinitionRel =
					(CommercePricingClassCPDefinitionRel)session.get(
						CommercePricingClassCPDefinitionRelImpl.class,
						commercePricingClassCPDefinitionRel.getPrimaryKeyObj());
			}

			if (commercePricingClassCPDefinitionRel != null) {
				session.delete(commercePricingClassCPDefinitionRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (commercePricingClassCPDefinitionRel != null) {
			clearCache(commercePricingClassCPDefinitionRel);
		}

		return commercePricingClassCPDefinitionRel;
	}

	@Override
	public CommercePricingClassCPDefinitionRel updateImpl(
		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel) {

		boolean isNew = commercePricingClassCPDefinitionRel.isNew();

		if (!(commercePricingClassCPDefinitionRel instanceof
				CommercePricingClassCPDefinitionRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					commercePricingClassCPDefinitionRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					commercePricingClassCPDefinitionRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commercePricingClassCPDefinitionRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CommercePricingClassCPDefinitionRel implementation " +
					commercePricingClassCPDefinitionRel.getClass());
		}

		CommercePricingClassCPDefinitionRelModelImpl
			commercePricingClassCPDefinitionRelModelImpl =
				(CommercePricingClassCPDefinitionRelModelImpl)
					commercePricingClassCPDefinitionRel;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew &&
			(commercePricingClassCPDefinitionRel.getCreateDate() == null)) {

			if (serviceContext == null) {
				commercePricingClassCPDefinitionRel.setCreateDate(now);
			}
			else {
				commercePricingClassCPDefinitionRel.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!commercePricingClassCPDefinitionRelModelImpl.
				hasSetModifiedDate()) {

			if (serviceContext == null) {
				commercePricingClassCPDefinitionRel.setModifiedDate(now);
			}
			else {
				commercePricingClassCPDefinitionRel.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (commercePricingClassCPDefinitionRel.isNew()) {
				session.save(commercePricingClassCPDefinitionRel);

				commercePricingClassCPDefinitionRel.setNew(false);
			}
			else {
				commercePricingClassCPDefinitionRel =
					(CommercePricingClassCPDefinitionRel)session.merge(
						commercePricingClassCPDefinitionRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			Object[] args = new Object[] {
				commercePricingClassCPDefinitionRelModelImpl.
					getCommercePricingClassId()
			};

			finderCache.removeResult(
				_finderPathCountByCommercePricingClassId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCommercePricingClassId, args);

			args = new Object[] {
				commercePricingClassCPDefinitionRelModelImpl.getCPDefinitionId()
			};

			finderCache.removeResult(_finderPathCountByCPDefinitionId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCPDefinitionId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((commercePricingClassCPDefinitionRelModelImpl.
					getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCommercePricingClassId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					commercePricingClassCPDefinitionRelModelImpl.
						getColumnOriginalValue("commercePricingClassId")
				};

				finderCache.removeResult(
					_finderPathCountByCommercePricingClassId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCommercePricingClassId,
					args);

				args = new Object[] {
					commercePricingClassCPDefinitionRelModelImpl.
						getCommercePricingClassId()
				};

				finderCache.removeResult(
					_finderPathCountByCommercePricingClassId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCommercePricingClassId,
					args);
			}

			if ((commercePricingClassCPDefinitionRelModelImpl.
					getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCPDefinitionId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					commercePricingClassCPDefinitionRelModelImpl.
						getColumnOriginalValue("CPDefinitionId")
				};

				finderCache.removeResult(
					_finderPathCountByCPDefinitionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCPDefinitionId, args);

				args = new Object[] {
					commercePricingClassCPDefinitionRelModelImpl.
						getCPDefinitionId()
				};

				finderCache.removeResult(
					_finderPathCountByCPDefinitionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCPDefinitionId, args);
			}
		}

		entityCache.putResult(
			CommercePricingClassCPDefinitionRelImpl.class,
			commercePricingClassCPDefinitionRel.getPrimaryKey(),
			commercePricingClassCPDefinitionRel, false);

		clearUniqueFindersCache(
			commercePricingClassCPDefinitionRelModelImpl, false);
		cacheUniqueFindersCache(commercePricingClassCPDefinitionRelModelImpl);

		commercePricingClassCPDefinitionRel.resetOriginalValues();

		return commercePricingClassCPDefinitionRel;
	}

	/**
	 * Returns the commerce pricing class cp definition rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commerce pricing class cp definition rel
	 * @return the commerce pricing class cp definition rel
	 * @throws NoSuchPricingClassCPDefinitionRelException if a commerce pricing class cp definition rel with the primary key could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchPricingClassCPDefinitionRelException {

		CommercePricingClassCPDefinitionRel
			commercePricingClassCPDefinitionRel = fetchByPrimaryKey(primaryKey);

		if (commercePricingClassCPDefinitionRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPricingClassCPDefinitionRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return commercePricingClassCPDefinitionRel;
	}

	/**
	 * Returns the commerce pricing class cp definition rel with the primary key or throws a <code>NoSuchPricingClassCPDefinitionRelException</code> if it could not be found.
	 *
	 * @param CommercePricingClassCPDefinitionRelId the primary key of the commerce pricing class cp definition rel
	 * @return the commerce pricing class cp definition rel
	 * @throws NoSuchPricingClassCPDefinitionRelException if a commerce pricing class cp definition rel with the primary key could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel findByPrimaryKey(
			long CommercePricingClassCPDefinitionRelId)
		throws NoSuchPricingClassCPDefinitionRelException {

		return findByPrimaryKey(
			(Serializable)CommercePricingClassCPDefinitionRelId);
	}

	/**
	 * Returns the commerce pricing class cp definition rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param CommercePricingClassCPDefinitionRelId the primary key of the commerce pricing class cp definition rel
	 * @return the commerce pricing class cp definition rel, or <code>null</code> if a commerce pricing class cp definition rel with the primary key could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel fetchByPrimaryKey(
		long CommercePricingClassCPDefinitionRelId) {

		return fetchByPrimaryKey(
			(Serializable)CommercePricingClassCPDefinitionRelId);
	}

	/**
	 * Returns all the commerce pricing class cp definition rels.
	 *
	 * @return the commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commerce pricing class cp definition rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce pricing class cp definition rels
	 * @param end the upper bound of the range of commerce pricing class cp definition rels (not inclusive)
	 * @return the range of commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel> findAll(
		int start, int end) {

		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the commerce pricing class cp definition rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce pricing class cp definition rels
	 * @param end the upper bound of the range of commerce pricing class cp definition rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel> findAll(
		int start, int end,
		OrderByComparator<CommercePricingClassCPDefinitionRel>
			orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commerce pricing class cp definition rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce pricing class cp definition rels
	 * @param end the upper bound of the range of commerce pricing class cp definition rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel> findAll(
		int start, int end,
		OrderByComparator<CommercePricingClassCPDefinitionRel>
			orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CommercePricingClassCPDefinitionRel> list = null;

		if (useFinderCache) {
			list =
				(List<CommercePricingClassCPDefinitionRel>)
					finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMMERCEPRICINGCLASSCPDEFINITIONREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMMERCEPRICINGCLASSCPDEFINITIONREL;

				sql = sql.concat(
					CommercePricingClassCPDefinitionRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list =
					(List<CommercePricingClassCPDefinitionRel>)QueryUtil.list(
						query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the commerce pricing class cp definition rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CommercePricingClassCPDefinitionRel
				commercePricingClassCPDefinitionRel : findAll()) {

			remove(commercePricingClassCPDefinitionRel);
		}
	}

	/**
	 * Returns the number of commerce pricing class cp definition rels.
	 *
	 * @return the number of commerce pricing class cp definition rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_COMMERCEPRICINGCLASSCPDEFINITIONREL);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "CPricingClassCPDefinitionRelId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMMERCEPRICINGCLASSCPDEFINITIONREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CommercePricingClassCPDefinitionRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the commerce pricing class cp definition rel persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CommercePricingClassCPDefinitionRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CommercePricingClassCPDefinitionRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByCommercePricingClassId = new FinderPath(
			CommercePricingClassCPDefinitionRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCommercePricingClassId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCommercePricingClassId =
			new FinderPath(
				CommercePricingClassCPDefinitionRelImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCommercePricingClassId",
				new String[] {Long.class.getName()},
				CommercePricingClassCPDefinitionRelModelImpl.getColumnBitmask(
					"commercePricingClassId") |
				CommercePricingClassCPDefinitionRelModelImpl.getColumnBitmask(
					"createDate"));

		_finderPathCountByCommercePricingClassId = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCommercePricingClassId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCPDefinitionId = new FinderPath(
			CommercePricingClassCPDefinitionRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCPDefinitionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCPDefinitionId = new FinderPath(
			CommercePricingClassCPDefinitionRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCPDefinitionId",
			new String[] {Long.class.getName()},
			CommercePricingClassCPDefinitionRelModelImpl.getColumnBitmask(
				"CPDefinitionId") |
			CommercePricingClassCPDefinitionRelModelImpl.getColumnBitmask(
				"createDate"));

		_finderPathCountByCPDefinitionId = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCPDefinitionId", new String[] {Long.class.getName()});

		_finderPathFetchByC_C = new FinderPath(
			CommercePricingClassCPDefinitionRelImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			CommercePricingClassCPDefinitionRelModelImpl.getColumnBitmask(
				"commercePricingClassId") |
			CommercePricingClassCPDefinitionRelModelImpl.getColumnBitmask(
				"CPDefinitionId"));

		_finderPathCountByC_C = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(
			CommercePricingClassCPDefinitionRelImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String
		_SQL_SELECT_COMMERCEPRICINGCLASSCPDEFINITIONREL =
			"SELECT commercePricingClassCPDefinitionRel FROM CommercePricingClassCPDefinitionRel commercePricingClassCPDefinitionRel";

	private static final String
		_SQL_SELECT_COMMERCEPRICINGCLASSCPDEFINITIONREL_WHERE =
			"SELECT commercePricingClassCPDefinitionRel FROM CommercePricingClassCPDefinitionRel commercePricingClassCPDefinitionRel WHERE ";

	private static final String _SQL_COUNT_COMMERCEPRICINGCLASSCPDEFINITIONREL =
		"SELECT COUNT(commercePricingClassCPDefinitionRel) FROM CommercePricingClassCPDefinitionRel commercePricingClassCPDefinitionRel";

	private static final String
		_SQL_COUNT_COMMERCEPRICINGCLASSCPDEFINITIONREL_WHERE =
			"SELECT COUNT(commercePricingClassCPDefinitionRel) FROM CommercePricingClassCPDefinitionRel commercePricingClassCPDefinitionRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"commercePricingClassCPDefinitionRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CommercePricingClassCPDefinitionRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CommercePricingClassCPDefinitionRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommercePricingClassCPDefinitionRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"CommercePricingClassCPDefinitionRelId"});

}