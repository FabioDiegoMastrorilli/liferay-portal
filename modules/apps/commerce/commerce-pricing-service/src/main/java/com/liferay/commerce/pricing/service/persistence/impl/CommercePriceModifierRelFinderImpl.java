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

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.commerce.price.list.model.CommercePriceList;
import com.liferay.commerce.pricing.model.CommercePriceModifierRel;
import com.liferay.commerce.pricing.model.CommercePricingClass;
import com.liferay.commerce.pricing.model.impl.CommercePriceModifierRelImpl;
import com.liferay.commerce.pricing.service.persistence.CommercePriceModifierRelFinder;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.Iterator;
import java.util.List;

/**
 * @author Riccardo Alberti
 */
public class CommercePriceModifierRelFinderImpl
	extends CommercePriceModifierRelFinderBaseImpl
	implements CommercePriceModifierRelFinder {

	public static final String COUNT_CATEGORIES_BY_COMMERCE_PRICE_MODIFIER_ID =
		CommercePriceModifierRelFinder.class.getName() +
			".countCategoriesByCommercePriceModifierId";

	public static final String
		COUNT_CP_DEFINITIONS_BY_COMMERCE_PRICE_MODIFIER_ID =
			CommercePriceModifierRelFinder.class.getName() +
				".countCPDefinitionsByCommercePriceModifierId";

	public static final String
		COUNT_PRICING_CLASSES_BY_COMMERCE_PRICE_MODIFIER_ID =
			CommercePriceModifierRelFinder.class.getName() +
				".countPricingClassesByCommercePriceModifierId";

	public static final String FIND_CATEGORIES_BY_COMMERCE_PRICE_MODIFIER_ID =
		CommercePriceModifierRelFinder.class.getName() +
			".findCategoriesByCommercePriceModifierId";

	public static final String
		FIND_CP_DEFINITIONS_BY_COMMERCE_PRICE_MODIFIER_ID =
			CommercePriceModifierRelFinder.class.getName() +
				".findCPDefinitionsByCommercePriceModifierId";

	public static final String
		FIND_PRICING_CLASSES_BY_COMMERCE_PRICE_MODIFIER_ID =
			CommercePriceModifierRelFinder.class.getName() +
				".findPricingClassesByCommercePriceModifierId";

	@Override
	public int countCategoriesByCommercePriceModifierId(
		long commercePriceModifierId, String name) {

		return countCategoriesByCommercePriceModifierId(
			commercePriceModifierId, name, false);
	}

	@Override
	public int countCategoriesByCommercePriceModifierId(
		long commercePriceModifierId, String name, boolean inlineSQLHelper) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(
				getClass(), COUNT_CATEGORIES_BY_COMMERCE_PRICE_MODIFIER_ID);

			if (inlineSQLHelper) {
				sql = InlineSQLHelperUtil.replacePermissionCheck(
					sql, CommercePriceList.class.getName(),
					"CommercePriceModifier.commercePriceListId", null, null,
					new long[] {0}, null);
			}

			String[] keywords = _customSQL.keywords(name, true);

			if (Validator.isNotNull(name)) {
				sql = _customSQL.replaceKeywords(
					sql, "(LOWER(AssetCategory.name)", StringPool.LIKE, true,
					keywords);
				sql = _customSQL.replaceAndOperator(sql, false);
			}
			else {
				sql = StringUtil.removeSubstring(
					sql,
					" AND (LOWER(AssetCategory.name) LIKE ? " +
						"[$AND_OR_NULL_CHECK$])");
			}

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(_COUNT_VALUE, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(commercePriceModifierId);
			qPos.add(PortalUtil.getClassNameId(AssetCategory.class.getName()));

			if (Validator.isNotNull(name)) {
				qPos.add(keywords, 2);
			}

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public int countCPDefinitionsByCommercePriceModifierId(
		long commercePriceModifierId, String name, String languageId) {

		return countCPDefinitionsByCommercePriceModifierId(
			commercePriceModifierId, name, languageId, false);
	}

	@Override
	public int countCPDefinitionsByCommercePriceModifierId(
		long commercePriceModifierId, String name, String languageId,
		boolean inlineSQLHelper) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(
				getClass(), COUNT_CP_DEFINITIONS_BY_COMMERCE_PRICE_MODIFIER_ID);

			if (inlineSQLHelper) {
				sql = InlineSQLHelperUtil.replacePermissionCheck(
					sql, CommercePriceList.class.getName(),
					"CommercePriceModifier.commercePriceListId", null, null,
					new long[] {0}, null);
			}

			String[] keywords = _customSQL.keywords(name, true);

			if (Validator.isNotNull(name)) {
				sql = _customSQL.replaceKeywords(
					sql, "(LOWER(CPDefinitionLocalization.name)",
					StringPool.LIKE, true, keywords);
				sql = _customSQL.replaceAndOperator(sql, false);
			}
			else {
				sql = StringUtil.removeSubstring(
					sql,
					" AND (LOWER(CPDefinitionLocalization.name) LIKE ? " +
						"[$AND_OR_NULL_CHECK$])");
			}

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(_COUNT_VALUE, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(languageId);
			qPos.add(commercePriceModifierId);
			qPos.add(PortalUtil.getClassNameId(CPDefinition.class.getName()));

			if (Validator.isNotNull(name)) {
				qPos.add(keywords, 2);
			}

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public int countPricingClassesByCommercePriceModifierId(
		long commercePriceModifierId, String title) {

		return countPricingClassesByCommercePriceModifierId(
			commercePriceModifierId, title, false);
	}

	@Override
	public int countPricingClassesByCommercePriceModifierId(
		long commercePriceModifierId, String title, boolean inlineSQLHelper) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(
				getClass(),
				COUNT_PRICING_CLASSES_BY_COMMERCE_PRICE_MODIFIER_ID);

			if (inlineSQLHelper) {
				sql = InlineSQLHelperUtil.replacePermissionCheck(
					sql, CommercePriceList.class.getName(),
					"CommercePriceModifier.commercePriceListId", null, null,
					new long[] {0}, null);
			}

			String[] keywords = _customSQL.keywords(title, true);

			if (Validator.isNotNull(title)) {
				sql = _customSQL.replaceKeywords(
					sql, "(LOWER(CommercePricingClass.title)", StringPool.LIKE,
					true, keywords);
				sql = _customSQL.replaceAndOperator(sql, false);
			}
			else {
				sql = StringUtil.removeSubstring(
					sql,
					" AND (LOWER(CommercePricingClass.title) LIKE ? " +
						"[$AND_OR_NULL_CHECK$])");
			}

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(_COUNT_VALUE, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(commercePriceModifierId);
			qPos.add(
				PortalUtil.getClassNameId(
					CommercePricingClass.class.getName()));

			if (Validator.isNotNull(title)) {
				qPos.add(keywords, 2);
			}

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public List<CommercePriceModifierRel>
		findCategoriesByCommercePriceModifierId(
			long commercePriceModifierId, String name, int start, int end) {

		return findCategoriesByCommercePriceModifierId(
			commercePriceModifierId, name, start, end, false);
	}

	@Override
	public List<CommercePriceModifierRel>
		findCategoriesByCommercePriceModifierId(
			long commercePriceModifierId, String name, int start, int end,
			boolean inlineSQLHelper) {

		Session session = null;

		try {
			session = openSession();

			String[] keywords = _customSQL.keywords(name, true);

			String sql = _customSQL.get(
				getClass(), FIND_CATEGORIES_BY_COMMERCE_PRICE_MODIFIER_ID);

			if (inlineSQLHelper) {
				sql = InlineSQLHelperUtil.replacePermissionCheck(
					sql, CommercePriceList.class.getName(),
					"CommercePriceModifier.commercePriceListId", null, null,
					new long[] {0}, null);
			}

			if (Validator.isNotNull(name)) {
				sql = _customSQL.replaceKeywords(
					sql, "(LOWER(AssetCategory.name)", StringPool.LIKE, true,
					keywords);
				sql = _customSQL.replaceAndOperator(sql, false);
			}
			else {
				sql = StringUtil.removeSubstring(
					sql,
					" AND (LOWER(AssetCategory.name) LIKE ? " +
						"[$AND_OR_NULL_CHECK$])");
			}

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addEntity(
				CommercePriceModifierRelImpl.TABLE_NAME,
				CommercePriceModifierRelImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(commercePriceModifierId);
			qPos.add(PortalUtil.getClassNameId(AssetCategory.class.getName()));

			if (Validator.isNotNull(name)) {
				qPos.add(keywords, 2);
			}

			return (List<CommercePriceModifierRel>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public List<CommercePriceModifierRel>
		findCPDefinitionsByCommercePriceModifierId(
			long commercePriceModifierId, String name, String languageId,
			int start, int end) {

		return findCPDefinitionsByCommercePriceModifierId(
			commercePriceModifierId, name, languageId, start, end, false);
	}

	@Override
	public List<CommercePriceModifierRel>
		findCPDefinitionsByCommercePriceModifierId(
			long commercePriceModifierId, String name, String languageId,
			int start, int end, boolean inlineSQLHelper) {

		Session session = null;

		try {
			session = openSession();

			String[] keywords = _customSQL.keywords(name, true);

			String sql = _customSQL.get(
				getClass(), FIND_CP_DEFINITIONS_BY_COMMERCE_PRICE_MODIFIER_ID);

			if (inlineSQLHelper) {
				sql = InlineSQLHelperUtil.replacePermissionCheck(
					sql, CommercePriceList.class.getName(),
					"CommercePriceModifier.commercePriceListId", null, null,
					new long[] {0}, null);
			}

			if (Validator.isNotNull(name)) {
				sql = _customSQL.replaceKeywords(
					sql, "(LOWER(CPDefinitionLocalization.name)",
					StringPool.LIKE, true, keywords);
				sql = _customSQL.replaceAndOperator(sql, false);
			}
			else {
				sql = StringUtil.removeSubstring(
					sql,
					" AND (LOWER(CPDefinitionLocalization.name) LIKE ? " +
						"[$AND_OR_NULL_CHECK$])");
			}

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addEntity(
				CommercePriceModifierRelImpl.TABLE_NAME,
				CommercePriceModifierRelImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(languageId);
			qPos.add(commercePriceModifierId);
			qPos.add(PortalUtil.getClassNameId(CPDefinition.class.getName()));

			if (Validator.isNotNull(name)) {
				qPos.add(keywords, 2);
			}

			return (List<CommercePriceModifierRel>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public List<CommercePriceModifierRel>
		findPricingClassesByCommercePriceModifierId(
			long commercePriceModifierId, String title, int start, int end) {

		return findPricingClassesByCommercePriceModifierId(
			commercePriceModifierId, title, start, end, false);
	}

	@Override
	public List<CommercePriceModifierRel>
		findPricingClassesByCommercePriceModifierId(
			long commercePriceModifierId, String title, int start, int end,
			boolean inlineSQLHelper) {

		Session session = null;

		try {
			session = openSession();

			String[] keywords = _customSQL.keywords(title, true);

			String sql = _customSQL.get(
				getClass(), FIND_PRICING_CLASSES_BY_COMMERCE_PRICE_MODIFIER_ID);

			if (inlineSQLHelper) {
				sql = InlineSQLHelperUtil.replacePermissionCheck(
					sql, CommercePriceList.class.getName(),
					"CommercePriceModifier.commercePriceListId", null, null,
					new long[] {0}, null);
			}

			if (Validator.isNotNull(title)) {
				sql = _customSQL.replaceKeywords(
					sql, "(LOWER(CommercePricingClass.title)", StringPool.LIKE,
					true, keywords);
				sql = _customSQL.replaceAndOperator(sql, false);
			}
			else {
				sql = StringUtil.removeSubstring(
					sql,
					" AND (LOWER(CommercePricingClass.title) LIKE ? " +
						"[$AND_OR_NULL_CHECK$])");
			}

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addEntity(
				CommercePriceModifierRelImpl.TABLE_NAME,
				CommercePriceModifierRelImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(commercePriceModifierId);
			qPos.add(
				PortalUtil.getClassNameId(
					CommercePricingClass.class.getName()));

			if (Validator.isNotNull(title)) {
				qPos.add(keywords, 2);
			}

			return (List<CommercePriceModifierRel>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _COUNT_VALUE = "COUNT_VALUE";

	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;

}