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

package com.liferay.portlet.documentlibrary.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.documentlibrary.model.DLContent;
import com.liferay.portlet.documentlibrary.model.DLContentDataBlobModel;
import com.liferay.portlet.documentlibrary.service.DLContentLocalService;
import com.liferay.portlet.documentlibrary.service.persistence.DLContentPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the document library content local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.documentlibrary.service.impl.DLContentLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.documentlibrary.service.impl.DLContentLocalServiceImpl
 * @see com.liferay.portlet.documentlibrary.service.DLContentLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class DLContentLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements DLContentLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.documentlibrary.service.DLContentLocalServiceUtil} to access the document library content local service.
	 */

	/**
	 * Adds the document library content to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlContent the document library content
	 * @return the document library content that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DLContent addDLContent(DLContent dlContent) {
		dlContent.setNew(true);

		return dlContentPersistence.update(dlContent);
	}

	/**
	 * Creates a new document library content with the primary key. Does not add the document library content to the database.
	 *
	 * @param contentId the primary key for the new document library content
	 * @return the new document library content
	 */
	@Override
	public DLContent createDLContent(long contentId) {
		return dlContentPersistence.create(contentId);
	}

	/**
	 * Deletes the document library content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contentId the primary key of the document library content
	 * @return the document library content that was removed
	 * @throws PortalException if a document library content with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DLContent deleteDLContent(long contentId) throws PortalException {
		return dlContentPersistence.remove(contentId);
	}

	/**
	 * Deletes the document library content from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlContent the document library content
	 * @return the document library content that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DLContent deleteDLContent(DLContent dlContent) {
		return dlContentPersistence.remove(dlContent);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(DLContent.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dlContentPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.documentlibrary.model.impl.DLContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return dlContentPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.documentlibrary.model.impl.DLContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return dlContentPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return dlContentPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return dlContentPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public DLContent fetchDLContent(long contentId) {
		return dlContentPersistence.fetchByPrimaryKey(contentId);
	}

	/**
	 * Returns the document library content with the primary key.
	 *
	 * @param contentId the primary key of the document library content
	 * @return the document library content
	 * @throws PortalException if a document library content with the primary key could not be found
	 */
	@Override
	public DLContent getDLContent(long contentId) throws PortalException {
		return dlContentPersistence.findByPrimaryKey(contentId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(com.liferay.portlet.documentlibrary.service.DLContentLocalServiceUtil.getService());
		actionableDynamicQuery.setClass(DLContent.class);
		actionableDynamicQuery.setClassLoader(getClassLoader());

		actionableDynamicQuery.setPrimaryKeyPropertyName("contentId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(com.liferay.portlet.documentlibrary.service.DLContentLocalServiceUtil.getService());
		indexableActionableDynamicQuery.setClass(DLContent.class);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("contentId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(com.liferay.portlet.documentlibrary.service.DLContentLocalServiceUtil.getService());
		actionableDynamicQuery.setClass(DLContent.class);
		actionableDynamicQuery.setClassLoader(getClassLoader());

		actionableDynamicQuery.setPrimaryKeyPropertyName("contentId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return dlContentLocalService.deleteDLContent((DLContent)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return dlContentPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the document library contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.documentlibrary.model.impl.DLContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document library contents
	 * @param end the upper bound of the range of document library contents (not inclusive)
	 * @return the range of document library contents
	 */
	@Override
	public List<DLContent> getDLContents(int start, int end) {
		return dlContentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of document library contents.
	 *
	 * @return the number of document library contents
	 */
	@Override
	public int getDLContentsCount() {
		return dlContentPersistence.countAll();
	}

	/**
	 * Updates the document library content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dlContent the document library content
	 * @return the document library content that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DLContent updateDLContent(DLContent dlContent) {
		return dlContentPersistence.update(dlContent);
	}

	@Override
	public DLContentDataBlobModel getDataBlobModel(Serializable primaryKey) {
		Session session = null;

		try {
			session = dlContentPersistence.openSession();

			return (DLContentDataBlobModel)session.get(DLContentDataBlobModel.class,
				primaryKey);
		}
		catch (Exception e) {
			throw dlContentPersistence.processException(e);
		}
		finally {
			dlContentPersistence.closeSession(session);
		}
	}

	/**
	 * Returns the document library content local service.
	 *
	 * @return the document library content local service
	 */
	public DLContentLocalService getDLContentLocalService() {
		return dlContentLocalService;
	}

	/**
	 * Sets the document library content local service.
	 *
	 * @param dlContentLocalService the document library content local service
	 */
	public void setDLContentLocalService(
		DLContentLocalService dlContentLocalService) {
		this.dlContentLocalService = dlContentLocalService;
	}

	/**
	 * Returns the document library content persistence.
	 *
	 * @return the document library content persistence
	 */
	public DLContentPersistence getDLContentPersistence() {
		return dlContentPersistence;
	}

	/**
	 * Sets the document library content persistence.
	 *
	 * @param dlContentPersistence the document library content persistence
	 */
	public void setDLContentPersistence(
		DLContentPersistence dlContentPersistence) {
		this.dlContentPersistence = dlContentPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.portlet.documentlibrary.model.DLContent",
			dlContentLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.portlet.documentlibrary.model.DLContent");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DLContentLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DLContent.class;
	}

	protected String getModelClassName() {
		return DLContent.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dlContentPersistence.getDataSource();

			DB db = DBFactoryUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.portlet.documentlibrary.service.DLContentLocalService.class)
	protected DLContentLocalService dlContentLocalService;
	@BeanReference(type = DLContentPersistence.class)
	protected DLContentPersistence dlContentPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}