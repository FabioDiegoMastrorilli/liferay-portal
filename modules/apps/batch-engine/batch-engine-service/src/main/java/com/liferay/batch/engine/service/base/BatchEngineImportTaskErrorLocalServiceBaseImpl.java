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

package com.liferay.batch.engine.service.base;

import com.liferay.batch.engine.model.BatchEngineImportTaskError;
import com.liferay.batch.engine.service.BatchEngineImportTaskErrorLocalService;
import com.liferay.batch.engine.service.BatchEngineImportTaskErrorLocalServiceUtil;
import com.liferay.batch.engine.service.persistence.BatchEngineImportTaskErrorPersistence;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
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
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the batch engine import task error local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.batch.engine.service.impl.BatchEngineImportTaskErrorLocalServiceImpl}.
 * </p>
 *
 * @author Shuyang Zhou
 * @see com.liferay.batch.engine.service.impl.BatchEngineImportTaskErrorLocalServiceImpl
 * @generated
 */
public abstract class BatchEngineImportTaskErrorLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, BatchEngineImportTaskErrorLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>BatchEngineImportTaskErrorLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>BatchEngineImportTaskErrorLocalServiceUtil</code>.
	 */

	/**
	 * Adds the batch engine import task error to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BatchEngineImportTaskErrorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param batchEngineImportTaskError the batch engine import task error
	 * @return the batch engine import task error that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BatchEngineImportTaskError addBatchEngineImportTaskError(
		BatchEngineImportTaskError batchEngineImportTaskError) {

		batchEngineImportTaskError.setNew(true);

		return batchEngineImportTaskErrorPersistence.update(
			batchEngineImportTaskError);
	}

	/**
	 * Creates a new batch engine import task error with the primary key. Does not add the batch engine import task error to the database.
	 *
	 * @param batchEngineImportTaskErrorId the primary key for the new batch engine import task error
	 * @return the new batch engine import task error
	 */
	@Override
	@Transactional(enabled = false)
	public BatchEngineImportTaskError createBatchEngineImportTaskError(
		long batchEngineImportTaskErrorId) {

		return batchEngineImportTaskErrorPersistence.create(
			batchEngineImportTaskErrorId);
	}

	/**
	 * Deletes the batch engine import task error with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BatchEngineImportTaskErrorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param batchEngineImportTaskErrorId the primary key of the batch engine import task error
	 * @return the batch engine import task error that was removed
	 * @throws PortalException if a batch engine import task error with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BatchEngineImportTaskError deleteBatchEngineImportTaskError(
			long batchEngineImportTaskErrorId)
		throws PortalException {

		return batchEngineImportTaskErrorPersistence.remove(
			batchEngineImportTaskErrorId);
	}

	/**
	 * Deletes the batch engine import task error from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BatchEngineImportTaskErrorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param batchEngineImportTaskError the batch engine import task error
	 * @return the batch engine import task error that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BatchEngineImportTaskError deleteBatchEngineImportTaskError(
		BatchEngineImportTaskError batchEngineImportTaskError) {

		return batchEngineImportTaskErrorPersistence.remove(
			batchEngineImportTaskError);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return batchEngineImportTaskErrorPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			BatchEngineImportTaskError.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return batchEngineImportTaskErrorPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.batch.engine.model.impl.BatchEngineImportTaskErrorModelImpl</code>.
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

		return batchEngineImportTaskErrorPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.batch.engine.model.impl.BatchEngineImportTaskErrorModelImpl</code>.
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

		return batchEngineImportTaskErrorPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return batchEngineImportTaskErrorPersistence.countWithDynamicQuery(
			dynamicQuery);
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

		return batchEngineImportTaskErrorPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public BatchEngineImportTaskError fetchBatchEngineImportTaskError(
		long batchEngineImportTaskErrorId) {

		return batchEngineImportTaskErrorPersistence.fetchByPrimaryKey(
			batchEngineImportTaskErrorId);
	}

	/**
	 * Returns the batch engine import task error with the primary key.
	 *
	 * @param batchEngineImportTaskErrorId the primary key of the batch engine import task error
	 * @return the batch engine import task error
	 * @throws PortalException if a batch engine import task error with the primary key could not be found
	 */
	@Override
	public BatchEngineImportTaskError getBatchEngineImportTaskError(
			long batchEngineImportTaskErrorId)
		throws PortalException {

		return batchEngineImportTaskErrorPersistence.findByPrimaryKey(
			batchEngineImportTaskErrorId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			batchEngineImportTaskErrorLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(BatchEngineImportTaskError.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"batchEngineImportTaskErrorId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			batchEngineImportTaskErrorLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			BatchEngineImportTaskError.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"batchEngineImportTaskErrorId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			batchEngineImportTaskErrorLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(BatchEngineImportTaskError.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"batchEngineImportTaskErrorId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return batchEngineImportTaskErrorPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return batchEngineImportTaskErrorLocalService.
			deleteBatchEngineImportTaskError(
				(BatchEngineImportTaskError)persistedModel);
	}

	@Override
	public BasePersistence<BatchEngineImportTaskError> getBasePersistence() {
		return batchEngineImportTaskErrorPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return batchEngineImportTaskErrorPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the batch engine import task errors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.batch.engine.model.impl.BatchEngineImportTaskErrorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of batch engine import task errors
	 * @param end the upper bound of the range of batch engine import task errors (not inclusive)
	 * @return the range of batch engine import task errors
	 */
	@Override
	public List<BatchEngineImportTaskError> getBatchEngineImportTaskErrors(
		int start, int end) {

		return batchEngineImportTaskErrorPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of batch engine import task errors.
	 *
	 * @return the number of batch engine import task errors
	 */
	@Override
	public int getBatchEngineImportTaskErrorsCount() {
		return batchEngineImportTaskErrorPersistence.countAll();
	}

	/**
	 * Updates the batch engine import task error in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BatchEngineImportTaskErrorLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param batchEngineImportTaskError the batch engine import task error
	 * @return the batch engine import task error that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BatchEngineImportTaskError updateBatchEngineImportTaskError(
		BatchEngineImportTaskError batchEngineImportTaskError) {

		return batchEngineImportTaskErrorPersistence.update(
			batchEngineImportTaskError);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			BatchEngineImportTaskErrorLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		batchEngineImportTaskErrorLocalService =
			(BatchEngineImportTaskErrorLocalService)aopProxy;

		_setLocalServiceUtilService(batchEngineImportTaskErrorLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return BatchEngineImportTaskErrorLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return BatchEngineImportTaskError.class;
	}

	protected String getModelClassName() {
		return BatchEngineImportTaskError.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				batchEngineImportTaskErrorPersistence.getDataSource();

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

	private void _setLocalServiceUtilService(
		BatchEngineImportTaskErrorLocalService
			batchEngineImportTaskErrorLocalService) {

		try {
			Field field =
				BatchEngineImportTaskErrorLocalServiceUtil.class.
					getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, batchEngineImportTaskErrorLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected BatchEngineImportTaskErrorLocalService
		batchEngineImportTaskErrorLocalService;

	@Reference
	protected BatchEngineImportTaskErrorPersistence
		batchEngineImportTaskErrorPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

}