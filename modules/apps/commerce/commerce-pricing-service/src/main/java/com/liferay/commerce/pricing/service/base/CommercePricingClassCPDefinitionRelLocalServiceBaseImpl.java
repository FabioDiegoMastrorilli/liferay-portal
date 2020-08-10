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

package com.liferay.commerce.pricing.service.base;

import com.liferay.commerce.pricing.model.CommercePricingClassCPDefinitionRel;
import com.liferay.commerce.pricing.service.CommercePricingClassCPDefinitionRelLocalService;
import com.liferay.commerce.pricing.service.persistence.CommercePriceModifierFinder;
import com.liferay.commerce.pricing.service.persistence.CommercePriceModifierPersistence;
import com.liferay.commerce.pricing.service.persistence.CommercePriceModifierRelFinder;
import com.liferay.commerce.pricing.service.persistence.CommercePriceModifierRelPersistence;
import com.liferay.commerce.pricing.service.persistence.CommercePricingClassCPDefinitionRelFinder;
import com.liferay.commerce.pricing.service.persistence.CommercePricingClassCPDefinitionRelPersistence;
import com.liferay.commerce.pricing.service.persistence.CommercePricingClassFinder;
import com.liferay.commerce.pricing.service.persistence.CommercePricingClassPersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce pricing class cp definition rel local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.pricing.service.impl.CommercePricingClassCPDefinitionRelLocalServiceImpl}.
 * </p>
 *
 * @author Riccardo Alberti
 * @see com.liferay.commerce.pricing.service.impl.CommercePricingClassCPDefinitionRelLocalServiceImpl
 * @generated
 */
public abstract class CommercePricingClassCPDefinitionRelLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements CommercePricingClassCPDefinitionRelLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CommercePricingClassCPDefinitionRelLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.commerce.pricing.service.CommercePricingClassCPDefinitionRelLocalServiceUtil</code>.
	 */

	/**
	 * Adds the commerce pricing class cp definition rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommercePricingClassCPDefinitionRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commercePricingClassCPDefinitionRel the commerce pricing class cp definition rel
	 * @return the commerce pricing class cp definition rel that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePricingClassCPDefinitionRel
		addCommercePricingClassCPDefinitionRel(
			CommercePricingClassCPDefinitionRel
				commercePricingClassCPDefinitionRel) {

		commercePricingClassCPDefinitionRel.setNew(true);

		return commercePricingClassCPDefinitionRelPersistence.update(
			commercePricingClassCPDefinitionRel);
	}

	/**
	 * Creates a new commerce pricing class cp definition rel with the primary key. Does not add the commerce pricing class cp definition rel to the database.
	 *
	 * @param CommercePricingClassCPDefinitionRelId the primary key for the new commerce pricing class cp definition rel
	 * @return the new commerce pricing class cp definition rel
	 */
	@Override
	@Transactional(enabled = false)
	public CommercePricingClassCPDefinitionRel
		createCommercePricingClassCPDefinitionRel(
			long CommercePricingClassCPDefinitionRelId) {

		return commercePricingClassCPDefinitionRelPersistence.create(
			CommercePricingClassCPDefinitionRelId);
	}

	/**
	 * Deletes the commerce pricing class cp definition rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommercePricingClassCPDefinitionRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param CommercePricingClassCPDefinitionRelId the primary key of the commerce pricing class cp definition rel
	 * @return the commerce pricing class cp definition rel that was removed
	 * @throws PortalException if a commerce pricing class cp definition rel with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommercePricingClassCPDefinitionRel
			deleteCommercePricingClassCPDefinitionRel(
				long CommercePricingClassCPDefinitionRelId)
		throws PortalException {

		return commercePricingClassCPDefinitionRelPersistence.remove(
			CommercePricingClassCPDefinitionRelId);
	}

	/**
	 * Deletes the commerce pricing class cp definition rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommercePricingClassCPDefinitionRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commercePricingClassCPDefinitionRel the commerce pricing class cp definition rel
	 * @return the commerce pricing class cp definition rel that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommercePricingClassCPDefinitionRel
			deleteCommercePricingClassCPDefinitionRel(
				CommercePricingClassCPDefinitionRel
					commercePricingClassCPDefinitionRel)
		throws PortalException {

		return commercePricingClassCPDefinitionRelPersistence.remove(
			commercePricingClassCPDefinitionRel);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CommercePricingClassCPDefinitionRel.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return commercePricingClassCPDefinitionRelPersistence.
			findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.pricing.model.impl.CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return commercePricingClassCPDefinitionRelPersistence.
			findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.pricing.model.impl.CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return commercePricingClassCPDefinitionRelPersistence.
			findWithDynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return commercePricingClassCPDefinitionRelPersistence.
			countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return commercePricingClassCPDefinitionRelPersistence.
			countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public CommercePricingClassCPDefinitionRel
		fetchCommercePricingClassCPDefinitionRel(
			long CommercePricingClassCPDefinitionRelId) {

		return commercePricingClassCPDefinitionRelPersistence.fetchByPrimaryKey(
			CommercePricingClassCPDefinitionRelId);
	}

	/**
	 * Returns the commerce pricing class cp definition rel with the primary key.
	 *
	 * @param CommercePricingClassCPDefinitionRelId the primary key of the commerce pricing class cp definition rel
	 * @return the commerce pricing class cp definition rel
	 * @throws PortalException if a commerce pricing class cp definition rel with the primary key could not be found
	 */
	@Override
	public CommercePricingClassCPDefinitionRel
			getCommercePricingClassCPDefinitionRel(
				long CommercePricingClassCPDefinitionRelId)
		throws PortalException {

		return commercePricingClassCPDefinitionRelPersistence.findByPrimaryKey(
			CommercePricingClassCPDefinitionRelId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			commercePricingClassCPDefinitionRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			CommercePricingClassCPDefinitionRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"CommercePricingClassCPDefinitionRelId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			commercePricingClassCPDefinitionRelLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			CommercePricingClassCPDefinitionRel.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"CommercePricingClassCPDefinitionRelId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			commercePricingClassCPDefinitionRelLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(
			CommercePricingClassCPDefinitionRel.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"CommercePricingClassCPDefinitionRelId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return commercePricingClassCPDefinitionRelLocalService.
			deleteCommercePricingClassCPDefinitionRel(
				(CommercePricingClassCPDefinitionRel)persistedModel);
	}

	public BasePersistence<CommercePricingClassCPDefinitionRel>
		getBasePersistence() {

		return commercePricingClassCPDefinitionRelPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return commercePricingClassCPDefinitionRelPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the commerce pricing class cp definition rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.pricing.model.impl.CommercePricingClassCPDefinitionRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commerce pricing class cp definition rels
	 * @param end the upper bound of the range of commerce pricing class cp definition rels (not inclusive)
	 * @return the range of commerce pricing class cp definition rels
	 */
	@Override
	public List<CommercePricingClassCPDefinitionRel>
		getCommercePricingClassCPDefinitionRels(int start, int end) {

		return commercePricingClassCPDefinitionRelPersistence.findAll(
			start, end);
	}

	/**
	 * Returns the number of commerce pricing class cp definition rels.
	 *
	 * @return the number of commerce pricing class cp definition rels
	 */
	@Override
	public int getCommercePricingClassCPDefinitionRelsCount() {
		return commercePricingClassCPDefinitionRelPersistence.countAll();
	}

	/**
	 * Updates the commerce pricing class cp definition rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommercePricingClassCPDefinitionRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commercePricingClassCPDefinitionRel the commerce pricing class cp definition rel
	 * @return the commerce pricing class cp definition rel that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommercePricingClassCPDefinitionRel
		updateCommercePricingClassCPDefinitionRel(
			CommercePricingClassCPDefinitionRel
				commercePricingClassCPDefinitionRel) {

		return commercePricingClassCPDefinitionRelPersistence.update(
			commercePricingClassCPDefinitionRel);
	}

	/**
	 * Returns the commerce price modifier local service.
	 *
	 * @return the commerce price modifier local service
	 */
	public
		com.liferay.commerce.pricing.service.CommercePriceModifierLocalService
			getCommercePriceModifierLocalService() {

		return commercePriceModifierLocalService;
	}

	/**
	 * Sets the commerce price modifier local service.
	 *
	 * @param commercePriceModifierLocalService the commerce price modifier local service
	 */
	public void setCommercePriceModifierLocalService(
		com.liferay.commerce.pricing.service.CommercePriceModifierLocalService
			commercePriceModifierLocalService) {

		this.commercePriceModifierLocalService =
			commercePriceModifierLocalService;
	}

	/**
	 * Returns the commerce price modifier persistence.
	 *
	 * @return the commerce price modifier persistence
	 */
	public CommercePriceModifierPersistence
		getCommercePriceModifierPersistence() {

		return commercePriceModifierPersistence;
	}

	/**
	 * Sets the commerce price modifier persistence.
	 *
	 * @param commercePriceModifierPersistence the commerce price modifier persistence
	 */
	public void setCommercePriceModifierPersistence(
		CommercePriceModifierPersistence commercePriceModifierPersistence) {

		this.commercePriceModifierPersistence =
			commercePriceModifierPersistence;
	}

	/**
	 * Returns the commerce price modifier finder.
	 *
	 * @return the commerce price modifier finder
	 */
	public CommercePriceModifierFinder getCommercePriceModifierFinder() {
		return commercePriceModifierFinder;
	}

	/**
	 * Sets the commerce price modifier finder.
	 *
	 * @param commercePriceModifierFinder the commerce price modifier finder
	 */
	public void setCommercePriceModifierFinder(
		CommercePriceModifierFinder commercePriceModifierFinder) {

		this.commercePriceModifierFinder = commercePriceModifierFinder;
	}

	/**
	 * Returns the commerce price modifier rel local service.
	 *
	 * @return the commerce price modifier rel local service
	 */
	public
		com.liferay.commerce.pricing.service.
			CommercePriceModifierRelLocalService
				getCommercePriceModifierRelLocalService() {

		return commercePriceModifierRelLocalService;
	}

	/**
	 * Sets the commerce price modifier rel local service.
	 *
	 * @param commercePriceModifierRelLocalService the commerce price modifier rel local service
	 */
	public void setCommercePriceModifierRelLocalService(
		com.liferay.commerce.pricing.service.
			CommercePriceModifierRelLocalService
				commercePriceModifierRelLocalService) {

		this.commercePriceModifierRelLocalService =
			commercePriceModifierRelLocalService;
	}

	/**
	 * Returns the commerce price modifier rel persistence.
	 *
	 * @return the commerce price modifier rel persistence
	 */
	public CommercePriceModifierRelPersistence
		getCommercePriceModifierRelPersistence() {

		return commercePriceModifierRelPersistence;
	}

	/**
	 * Sets the commerce price modifier rel persistence.
	 *
	 * @param commercePriceModifierRelPersistence the commerce price modifier rel persistence
	 */
	public void setCommercePriceModifierRelPersistence(
		CommercePriceModifierRelPersistence
			commercePriceModifierRelPersistence) {

		this.commercePriceModifierRelPersistence =
			commercePriceModifierRelPersistence;
	}

	/**
	 * Returns the commerce price modifier rel finder.
	 *
	 * @return the commerce price modifier rel finder
	 */
	public CommercePriceModifierRelFinder getCommercePriceModifierRelFinder() {
		return commercePriceModifierRelFinder;
	}

	/**
	 * Sets the commerce price modifier rel finder.
	 *
	 * @param commercePriceModifierRelFinder the commerce price modifier rel finder
	 */
	public void setCommercePriceModifierRelFinder(
		CommercePriceModifierRelFinder commercePriceModifierRelFinder) {

		this.commercePriceModifierRelFinder = commercePriceModifierRelFinder;
	}

	/**
	 * Returns the commerce pricing class local service.
	 *
	 * @return the commerce pricing class local service
	 */
	public com.liferay.commerce.pricing.service.CommercePricingClassLocalService
		getCommercePricingClassLocalService() {

		return commercePricingClassLocalService;
	}

	/**
	 * Sets the commerce pricing class local service.
	 *
	 * @param commercePricingClassLocalService the commerce pricing class local service
	 */
	public void setCommercePricingClassLocalService(
		com.liferay.commerce.pricing.service.CommercePricingClassLocalService
			commercePricingClassLocalService) {

		this.commercePricingClassLocalService =
			commercePricingClassLocalService;
	}

	/**
	 * Returns the commerce pricing class persistence.
	 *
	 * @return the commerce pricing class persistence
	 */
	public CommercePricingClassPersistence
		getCommercePricingClassPersistence() {

		return commercePricingClassPersistence;
	}

	/**
	 * Sets the commerce pricing class persistence.
	 *
	 * @param commercePricingClassPersistence the commerce pricing class persistence
	 */
	public void setCommercePricingClassPersistence(
		CommercePricingClassPersistence commercePricingClassPersistence) {

		this.commercePricingClassPersistence = commercePricingClassPersistence;
	}

	/**
	 * Returns the commerce pricing class finder.
	 *
	 * @return the commerce pricing class finder
	 */
	public CommercePricingClassFinder getCommercePricingClassFinder() {
		return commercePricingClassFinder;
	}

	/**
	 * Sets the commerce pricing class finder.
	 *
	 * @param commercePricingClassFinder the commerce pricing class finder
	 */
	public void setCommercePricingClassFinder(
		CommercePricingClassFinder commercePricingClassFinder) {

		this.commercePricingClassFinder = commercePricingClassFinder;
	}

	/**
	 * Returns the commerce pricing class cp definition rel local service.
	 *
	 * @return the commerce pricing class cp definition rel local service
	 */
	public CommercePricingClassCPDefinitionRelLocalService
		getCommercePricingClassCPDefinitionRelLocalService() {

		return commercePricingClassCPDefinitionRelLocalService;
	}

	/**
	 * Sets the commerce pricing class cp definition rel local service.
	 *
	 * @param commercePricingClassCPDefinitionRelLocalService the commerce pricing class cp definition rel local service
	 */
	public void setCommercePricingClassCPDefinitionRelLocalService(
		CommercePricingClassCPDefinitionRelLocalService
			commercePricingClassCPDefinitionRelLocalService) {

		this.commercePricingClassCPDefinitionRelLocalService =
			commercePricingClassCPDefinitionRelLocalService;
	}

	/**
	 * Returns the commerce pricing class cp definition rel persistence.
	 *
	 * @return the commerce pricing class cp definition rel persistence
	 */
	public CommercePricingClassCPDefinitionRelPersistence
		getCommercePricingClassCPDefinitionRelPersistence() {

		return commercePricingClassCPDefinitionRelPersistence;
	}

	/**
	 * Sets the commerce pricing class cp definition rel persistence.
	 *
	 * @param commercePricingClassCPDefinitionRelPersistence the commerce pricing class cp definition rel persistence
	 */
	public void setCommercePricingClassCPDefinitionRelPersistence(
		CommercePricingClassCPDefinitionRelPersistence
			commercePricingClassCPDefinitionRelPersistence) {

		this.commercePricingClassCPDefinitionRelPersistence =
			commercePricingClassCPDefinitionRelPersistence;
	}

	/**
	 * Returns the commerce pricing class cp definition rel finder.
	 *
	 * @return the commerce pricing class cp definition rel finder
	 */
	public CommercePricingClassCPDefinitionRelFinder
		getCommercePricingClassCPDefinitionRelFinder() {

		return commercePricingClassCPDefinitionRelFinder;
	}

	/**
	 * Sets the commerce pricing class cp definition rel finder.
	 *
	 * @param commercePricingClassCPDefinitionRelFinder the commerce pricing class cp definition rel finder
	 */
	public void setCommercePricingClassCPDefinitionRelFinder(
		CommercePricingClassCPDefinitionRelFinder
			commercePricingClassCPDefinitionRelFinder) {

		this.commercePricingClassCPDefinitionRelFinder =
			commercePricingClassCPDefinitionRelFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
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
		persistedModelLocalServiceRegistry.register(
			"com.liferay.commerce.pricing.model.CommercePricingClassCPDefinitionRel",
			commercePricingClassCPDefinitionRelLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.commerce.pricing.model.CommercePricingClassCPDefinitionRel");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommercePricingClassCPDefinitionRelLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommercePricingClassCPDefinitionRel.class;
	}

	protected String getModelClassName() {
		return CommercePricingClassCPDefinitionRel.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				commercePricingClassCPDefinitionRelPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@BeanReference(
		type = com.liferay.commerce.pricing.service.CommercePriceModifierLocalService.class
	)
	protected
		com.liferay.commerce.pricing.service.CommercePriceModifierLocalService
			commercePriceModifierLocalService;

	@BeanReference(type = CommercePriceModifierPersistence.class)
	protected CommercePriceModifierPersistence commercePriceModifierPersistence;

	@BeanReference(type = CommercePriceModifierFinder.class)
	protected CommercePriceModifierFinder commercePriceModifierFinder;

	@BeanReference(
		type = com.liferay.commerce.pricing.service.CommercePriceModifierRelLocalService.class
	)
	protected
		com.liferay.commerce.pricing.service.
			CommercePriceModifierRelLocalService
				commercePriceModifierRelLocalService;

	@BeanReference(type = CommercePriceModifierRelPersistence.class)
	protected CommercePriceModifierRelPersistence
		commercePriceModifierRelPersistence;

	@BeanReference(type = CommercePriceModifierRelFinder.class)
	protected CommercePriceModifierRelFinder commercePriceModifierRelFinder;

	@BeanReference(
		type = com.liferay.commerce.pricing.service.CommercePricingClassLocalService.class
	)
	protected
		com.liferay.commerce.pricing.service.CommercePricingClassLocalService
			commercePricingClassLocalService;

	@BeanReference(type = CommercePricingClassPersistence.class)
	protected CommercePricingClassPersistence commercePricingClassPersistence;

	@BeanReference(type = CommercePricingClassFinder.class)
	protected CommercePricingClassFinder commercePricingClassFinder;

	@BeanReference(type = CommercePricingClassCPDefinitionRelLocalService.class)
	protected CommercePricingClassCPDefinitionRelLocalService
		commercePricingClassCPDefinitionRelLocalService;

	@BeanReference(type = CommercePricingClassCPDefinitionRelPersistence.class)
	protected CommercePricingClassCPDefinitionRelPersistence
		commercePricingClassCPDefinitionRelPersistence;

	@BeanReference(type = CommercePricingClassCPDefinitionRelFinder.class)
	protected CommercePricingClassCPDefinitionRelFinder
		commercePricingClassCPDefinitionRelFinder;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}