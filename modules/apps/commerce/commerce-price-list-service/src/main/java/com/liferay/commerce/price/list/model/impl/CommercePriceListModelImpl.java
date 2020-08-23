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

package com.liferay.commerce.price.list.model.impl;

import com.liferay.commerce.price.list.model.CommercePriceList;
import com.liferay.commerce.price.list.model.CommercePriceListModel;
import com.liferay.commerce.price.list.model.CommercePriceListSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CommercePriceList service. Represents a row in the &quot;CommercePriceList&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommercePriceListModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommercePriceListImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListImpl
 * @generated
 */
@JSON(strict = true)
public class CommercePriceListModelImpl
	extends BaseModelImpl<CommercePriceList> implements CommercePriceListModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce price list model instance should use the <code>CommercePriceList</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommercePriceList";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"commercePriceListId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"commerceCurrencyId", Types.BIGINT},
		{"parentCommercePriceListId", Types.BIGINT},
		{"catalogBasePriceList", Types.BOOLEAN}, {"netPrice", Types.BOOLEAN},
		{"type_", Types.VARCHAR}, {"name", Types.VARCHAR},
		{"priority", Types.DOUBLE}, {"displayDate", Types.TIMESTAMP},
		{"expirationDate", Types.TIMESTAMP},
		{"lastPublishDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"statusByUserId", Types.BIGINT}, {"statusByUserName", Types.VARCHAR},
		{"statusDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("commercePriceListId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceCurrencyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("parentCommercePriceListId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("catalogBasePriceList", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("netPrice", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("priority", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("displayDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("expirationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommercePriceList (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,commercePriceListId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceCurrencyId LONG,parentCommercePriceListId LONG,catalogBasePriceList BOOLEAN,netPrice BOOLEAN,type_ VARCHAR(75) null,name VARCHAR(75) null,priority DOUBLE,displayDate DATE null,expirationDate DATE null,lastPublishDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table CommercePriceList";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commercePriceList.displayDate DESC, commercePriceList.createDate DESC, commercePriceList.priority DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommercePriceList.displayDate DESC, CommercePriceList.createDate DESC, CommercePriceList.priority DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	public static final long CATALOGBASEPRICELIST_COLUMN_BITMASK = 1L;

	public static final long COMMERCECURRENCYID_COLUMN_BITMASK = 2L;

	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	public static final long DISPLAYDATE_COLUMN_BITMASK = 8L;

	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 16L;

	public static final long GROUPID_COLUMN_BITMASK = 32L;

	public static final long PARENTCOMMERCEPRICELISTID_COLUMN_BITMASK = 64L;

	public static final long STATUS_COLUMN_BITMASK = 128L;

	public static final long TYPE_COLUMN_BITMASK = 256L;

	public static final long UUID_COLUMN_BITMASK = 512L;

	public static final long CREATEDATE_COLUMN_BITMASK = 1024L;

	public static final long PRIORITY_COLUMN_BITMASK = 2048L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CommercePriceList toModel(CommercePriceListSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommercePriceList model = new CommercePriceListImpl();

		model.setUuid(soapModel.getUuid());
		model.setExternalReferenceCode(soapModel.getExternalReferenceCode());
		model.setCommercePriceListId(soapModel.getCommercePriceListId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceCurrencyId(soapModel.getCommerceCurrencyId());
		model.setParentCommercePriceListId(
			soapModel.getParentCommercePriceListId());
		model.setCatalogBasePriceList(soapModel.isCatalogBasePriceList());
		model.setNetPrice(soapModel.isNetPrice());
		model.setType(soapModel.getType());
		model.setName(soapModel.getName());
		model.setPriority(soapModel.getPriority());
		model.setDisplayDate(soapModel.getDisplayDate());
		model.setExpirationDate(soapModel.getExpirationDate());
		model.setLastPublishDate(soapModel.getLastPublishDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<CommercePriceList> toModels(
		CommercePriceListSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommercePriceList> models = new ArrayList<CommercePriceList>(
			soapModels.length);

		for (CommercePriceListSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.price.list.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.price.list.model.CommercePriceList"));

	public CommercePriceListModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commercePriceListId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommercePriceListId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commercePriceListId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommercePriceList.class;
	}

	@Override
	public String getModelClassName() {
		return CommercePriceList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommercePriceList, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommercePriceList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommercePriceList, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommercePriceList)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommercePriceList, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommercePriceList, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommercePriceList)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommercePriceList, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommercePriceList, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommercePriceList>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommercePriceList.class.getClassLoader(), CommercePriceList.class,
			ModelWrapper.class);

		try {
			Constructor<CommercePriceList> constructor =
				(Constructor<CommercePriceList>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CommercePriceList, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CommercePriceList, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommercePriceList, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommercePriceList, Object>>();
		Map<String, BiConsumer<CommercePriceList, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CommercePriceList, ?>>();

		attributeGetterFunctions.put("uuid", CommercePriceList::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CommercePriceList, String>)CommercePriceList::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode",
			CommercePriceList::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<CommercePriceList, String>)
				CommercePriceList::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"commercePriceListId", CommercePriceList::getCommercePriceListId);
		attributeSetterBiConsumers.put(
			"commercePriceListId",
			(BiConsumer<CommercePriceList, Long>)
				CommercePriceList::setCommercePriceListId);
		attributeGetterFunctions.put("groupId", CommercePriceList::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CommercePriceList, Long>)CommercePriceList::setGroupId);
		attributeGetterFunctions.put(
			"companyId", CommercePriceList::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommercePriceList, Long>)
				CommercePriceList::setCompanyId);
		attributeGetterFunctions.put("userId", CommercePriceList::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommercePriceList, Long>)CommercePriceList::setUserId);
		attributeGetterFunctions.put(
			"userName", CommercePriceList::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommercePriceList, String>)
				CommercePriceList::setUserName);
		attributeGetterFunctions.put(
			"createDate", CommercePriceList::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommercePriceList, Date>)
				CommercePriceList::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CommercePriceList::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommercePriceList, Date>)
				CommercePriceList::setModifiedDate);
		attributeGetterFunctions.put(
			"commerceCurrencyId", CommercePriceList::getCommerceCurrencyId);
		attributeSetterBiConsumers.put(
			"commerceCurrencyId",
			(BiConsumer<CommercePriceList, Long>)
				CommercePriceList::setCommerceCurrencyId);
		attributeGetterFunctions.put(
			"parentCommercePriceListId",
			CommercePriceList::getParentCommercePriceListId);
		attributeSetterBiConsumers.put(
			"parentCommercePriceListId",
			(BiConsumer<CommercePriceList, Long>)
				CommercePriceList::setParentCommercePriceListId);
		attributeGetterFunctions.put(
			"catalogBasePriceList", CommercePriceList::getCatalogBasePriceList);
		attributeSetterBiConsumers.put(
			"catalogBasePriceList",
			(BiConsumer<CommercePriceList, Boolean>)
				CommercePriceList::setCatalogBasePriceList);
		attributeGetterFunctions.put(
			"netPrice", CommercePriceList::getNetPrice);
		attributeSetterBiConsumers.put(
			"netPrice",
			(BiConsumer<CommercePriceList, Boolean>)
				CommercePriceList::setNetPrice);
		attributeGetterFunctions.put("type", CommercePriceList::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<CommercePriceList, String>)CommercePriceList::setType);
		attributeGetterFunctions.put("name", CommercePriceList::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<CommercePriceList, String>)CommercePriceList::setName);
		attributeGetterFunctions.put(
			"priority", CommercePriceList::getPriority);
		attributeSetterBiConsumers.put(
			"priority",
			(BiConsumer<CommercePriceList, Double>)
				CommercePriceList::setPriority);
		attributeGetterFunctions.put(
			"displayDate", CommercePriceList::getDisplayDate);
		attributeSetterBiConsumers.put(
			"displayDate",
			(BiConsumer<CommercePriceList, Date>)
				CommercePriceList::setDisplayDate);
		attributeGetterFunctions.put(
			"expirationDate", CommercePriceList::getExpirationDate);
		attributeSetterBiConsumers.put(
			"expirationDate",
			(BiConsumer<CommercePriceList, Date>)
				CommercePriceList::setExpirationDate);
		attributeGetterFunctions.put(
			"lastPublishDate", CommercePriceList::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<CommercePriceList, Date>)
				CommercePriceList::setLastPublishDate);
		attributeGetterFunctions.put("status", CommercePriceList::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<CommercePriceList, Integer>)
				CommercePriceList::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", CommercePriceList::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<CommercePriceList, Long>)
				CommercePriceList::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", CommercePriceList::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<CommercePriceList, String>)
				CommercePriceList::setStatusByUserName);
		attributeGetterFunctions.put(
			"statusDate", CommercePriceList::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<CommercePriceList, Date>)
				CommercePriceList::setStatusDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public String getExternalReferenceCode() {
		if (_externalReferenceCode == null) {
			return "";
		}
		else {
			return _externalReferenceCode;
		}
	}

	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		_columnBitmask |= EXTERNALREFERENCECODE_COLUMN_BITMASK;

		if (_originalExternalReferenceCode == null) {
			_originalExternalReferenceCode = _externalReferenceCode;
		}

		_externalReferenceCode = externalReferenceCode;
	}

	public String getOriginalExternalReferenceCode() {
		return GetterUtil.getString(_originalExternalReferenceCode);
	}

	@JSON
	@Override
	public long getCommercePriceListId() {
		return _commercePriceListId;
	}

	@Override
	public void setCommercePriceListId(long commercePriceListId) {
		_commercePriceListId = commercePriceListId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
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

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCommerceCurrencyId() {
		return _commerceCurrencyId;
	}

	@Override
	public void setCommerceCurrencyId(long commerceCurrencyId) {
		_columnBitmask |= COMMERCECURRENCYID_COLUMN_BITMASK;

		if (!_setOriginalCommerceCurrencyId) {
			_setOriginalCommerceCurrencyId = true;

			_originalCommerceCurrencyId = _commerceCurrencyId;
		}

		_commerceCurrencyId = commerceCurrencyId;
	}

	public long getOriginalCommerceCurrencyId() {
		return _originalCommerceCurrencyId;
	}

	@JSON
	@Override
	public long getParentCommercePriceListId() {
		return _parentCommercePriceListId;
	}

	@Override
	public void setParentCommercePriceListId(long parentCommercePriceListId) {
		_columnBitmask |= PARENTCOMMERCEPRICELISTID_COLUMN_BITMASK;

		if (!_setOriginalParentCommercePriceListId) {
			_setOriginalParentCommercePriceListId = true;

			_originalParentCommercePriceListId = _parentCommercePriceListId;
		}

		_parentCommercePriceListId = parentCommercePriceListId;
	}

	public long getOriginalParentCommercePriceListId() {
		return _originalParentCommercePriceListId;
	}

	@JSON
	@Override
	public boolean getCatalogBasePriceList() {
		return _catalogBasePriceList;
	}

	@JSON
	@Override
	public boolean isCatalogBasePriceList() {
		return _catalogBasePriceList;
	}

	@Override
	public void setCatalogBasePriceList(boolean catalogBasePriceList) {
		_columnBitmask |= CATALOGBASEPRICELIST_COLUMN_BITMASK;

		if (!_setOriginalCatalogBasePriceList) {
			_setOriginalCatalogBasePriceList = true;

			_originalCatalogBasePriceList = _catalogBasePriceList;
		}

		_catalogBasePriceList = catalogBasePriceList;
	}

	public boolean getOriginalCatalogBasePriceList() {
		return _originalCatalogBasePriceList;
	}

	@JSON
	@Override
	public boolean getNetPrice() {
		return _netPrice;
	}

	@JSON
	@Override
	public boolean isNetPrice() {
		return _netPrice;
	}

	@Override
	public void setNetPrice(boolean netPrice) {
		_netPrice = netPrice;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (_originalType == null) {
			_originalType = _type;
		}

		_type = type;
	}

	public String getOriginalType() {
		return GetterUtil.getString(_originalType);
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public double getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(double priority) {
		_priority = priority;
	}

	@JSON
	@Override
	public Date getDisplayDate() {
		return _displayDate;
	}

	@Override
	public void setDisplayDate(Date displayDate) {
		_columnBitmask |= DISPLAYDATE_COLUMN_BITMASK;

		if (_originalDisplayDate == null) {
			_originalDisplayDate = _displayDate;
		}

		_displayDate = displayDate;
	}

	public Date getOriginalDisplayDate() {
		return _originalDisplayDate;
	}

	@JSON
	@Override
	public Date getExpirationDate() {
		return _expirationDate;
	}

	@Override
	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CommercePriceList.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommercePriceList.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommercePriceList toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommercePriceList>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommercePriceListImpl commercePriceListImpl =
			new CommercePriceListImpl();

		commercePriceListImpl.setUuid(getUuid());
		commercePriceListImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		commercePriceListImpl.setCommercePriceListId(getCommercePriceListId());
		commercePriceListImpl.setGroupId(getGroupId());
		commercePriceListImpl.setCompanyId(getCompanyId());
		commercePriceListImpl.setUserId(getUserId());
		commercePriceListImpl.setUserName(getUserName());
		commercePriceListImpl.setCreateDate(getCreateDate());
		commercePriceListImpl.setModifiedDate(getModifiedDate());
		commercePriceListImpl.setCommerceCurrencyId(getCommerceCurrencyId());
		commercePriceListImpl.setParentCommercePriceListId(
			getParentCommercePriceListId());
		commercePriceListImpl.setCatalogBasePriceList(isCatalogBasePriceList());
		commercePriceListImpl.setNetPrice(isNetPrice());
		commercePriceListImpl.setType(getType());
		commercePriceListImpl.setName(getName());
		commercePriceListImpl.setPriority(getPriority());
		commercePriceListImpl.setDisplayDate(getDisplayDate());
		commercePriceListImpl.setExpirationDate(getExpirationDate());
		commercePriceListImpl.setLastPublishDate(getLastPublishDate());
		commercePriceListImpl.setStatus(getStatus());
		commercePriceListImpl.setStatusByUserId(getStatusByUserId());
		commercePriceListImpl.setStatusByUserName(getStatusByUserName());
		commercePriceListImpl.setStatusDate(getStatusDate());

		commercePriceListImpl.resetOriginalValues();

		return commercePriceListImpl;
	}

	@Override
	public int compareTo(CommercePriceList commercePriceList) {
		int value = 0;

		value = DateUtil.compareTo(
			getDisplayDate(), commercePriceList.getDisplayDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(
			getCreateDate(), commercePriceList.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getPriority() < commercePriceList.getPriority()) {
			value = -1;
		}
		else if (getPriority() > commercePriceList.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CommercePriceList)) {
			return false;
		}

		CommercePriceList commercePriceList = (CommercePriceList)object;

		long primaryKey = commercePriceList.getPrimaryKey();

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

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_originalUuid = _uuid;

		_originalExternalReferenceCode = _externalReferenceCode;

		_originalGroupId = _groupId;

		_setOriginalGroupId = false;

		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_setModifiedDate = false;
		_originalCommerceCurrencyId = _commerceCurrencyId;

		_setOriginalCommerceCurrencyId = false;

		_originalParentCommercePriceListId = _parentCommercePriceListId;

		_setOriginalParentCommercePriceListId = false;

		_originalCatalogBasePriceList = _catalogBasePriceList;

		_setOriginalCatalogBasePriceList = false;

		_originalType = _type;

		_originalDisplayDate = _displayDate;

		_originalStatus = _status;

		_setOriginalStatus = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CommercePriceList> toCacheModel() {
		CommercePriceListCacheModel commercePriceListCacheModel =
			new CommercePriceListCacheModel();

		commercePriceListCacheModel.uuid = getUuid();

		String uuid = commercePriceListCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			commercePriceListCacheModel.uuid = null;
		}

		commercePriceListCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			commercePriceListCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			commercePriceListCacheModel.externalReferenceCode = null;
		}

		commercePriceListCacheModel.commercePriceListId =
			getCommercePriceListId();

		commercePriceListCacheModel.groupId = getGroupId();

		commercePriceListCacheModel.companyId = getCompanyId();

		commercePriceListCacheModel.userId = getUserId();

		commercePriceListCacheModel.userName = getUserName();

		String userName = commercePriceListCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commercePriceListCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commercePriceListCacheModel.createDate = createDate.getTime();
		}
		else {
			commercePriceListCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commercePriceListCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commercePriceListCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commercePriceListCacheModel.commerceCurrencyId =
			getCommerceCurrencyId();

		commercePriceListCacheModel.parentCommercePriceListId =
			getParentCommercePriceListId();

		commercePriceListCacheModel.catalogBasePriceList =
			isCatalogBasePriceList();

		commercePriceListCacheModel.netPrice = isNetPrice();

		commercePriceListCacheModel.type = getType();

		String type = commercePriceListCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			commercePriceListCacheModel.type = null;
		}

		commercePriceListCacheModel.name = getName();

		String name = commercePriceListCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			commercePriceListCacheModel.name = null;
		}

		commercePriceListCacheModel.priority = getPriority();

		Date displayDate = getDisplayDate();

		if (displayDate != null) {
			commercePriceListCacheModel.displayDate = displayDate.getTime();
		}
		else {
			commercePriceListCacheModel.displayDate = Long.MIN_VALUE;
		}

		Date expirationDate = getExpirationDate();

		if (expirationDate != null) {
			commercePriceListCacheModel.expirationDate =
				expirationDate.getTime();
		}
		else {
			commercePriceListCacheModel.expirationDate = Long.MIN_VALUE;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			commercePriceListCacheModel.lastPublishDate =
				lastPublishDate.getTime();
		}
		else {
			commercePriceListCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		commercePriceListCacheModel.status = getStatus();

		commercePriceListCacheModel.statusByUserId = getStatusByUserId();

		commercePriceListCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = commercePriceListCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			commercePriceListCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			commercePriceListCacheModel.statusDate = statusDate.getTime();
		}
		else {
			commercePriceListCacheModel.statusDate = Long.MIN_VALUE;
		}

		return commercePriceListCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommercePriceList, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommercePriceList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommercePriceList, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CommercePriceList)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CommercePriceList, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommercePriceList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommercePriceList, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CommercePriceList)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CommercePriceList>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private String _externalReferenceCode;
	private String _originalExternalReferenceCode;
	private long _commercePriceListId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceCurrencyId;
	private long _originalCommerceCurrencyId;
	private boolean _setOriginalCommerceCurrencyId;
	private long _parentCommercePriceListId;
	private long _originalParentCommercePriceListId;
	private boolean _setOriginalParentCommercePriceListId;
	private boolean _catalogBasePriceList;
	private boolean _originalCatalogBasePriceList;
	private boolean _setOriginalCatalogBasePriceList;
	private boolean _netPrice;
	private String _type;
	private String _originalType;
	private String _name;
	private double _priority;
	private Date _displayDate;
	private Date _originalDisplayDate;
	private Date _expirationDate;
	private Date _lastPublishDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private CommercePriceList _escapedModel;

}