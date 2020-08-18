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

import com.liferay.commerce.price.list.model.CommerceTierPriceEntry;
import com.liferay.commerce.price.list.model.CommerceTierPriceEntryModel;
import com.liferay.commerce.price.list.model.CommerceTierPriceEntrySoap;
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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.math.BigDecimal;

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
 * The base model implementation for the CommerceTierPriceEntry service. Represents a row in the &quot;CommerceTierPriceEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommerceTierPriceEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceTierPriceEntryImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceTierPriceEntryImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceTierPriceEntryModelImpl
	extends BaseModelImpl<CommerceTierPriceEntry>
	implements CommerceTierPriceEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce tier price entry model instance should use the <code>CommerceTierPriceEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceTierPriceEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"commerceTierPriceEntryId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"commercePriceEntryId", Types.BIGINT}, {"price", Types.DECIMAL},
		{"promoPrice", Types.DECIMAL}, {"discountDiscovery", Types.BOOLEAN},
		{"discountLevel1", Types.DECIMAL}, {"discountLevel2", Types.DECIMAL},
		{"discountLevel3", Types.DECIMAL}, {"discountLevel4", Types.DECIMAL},
		{"minQuantity", Types.INTEGER}, {"displayDate", Types.TIMESTAMP},
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
		TABLE_COLUMNS_MAP.put("commerceTierPriceEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commercePriceEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("price", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("promoPrice", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("discountDiscovery", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("discountLevel1", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("discountLevel2", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("discountLevel3", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("discountLevel4", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("minQuantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("displayDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("expirationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceTierPriceEntry (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,commerceTierPriceEntryId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commercePriceEntryId LONG,price DECIMAL(30, 16) null,promoPrice DECIMAL(30, 16) null,discountDiscovery BOOLEAN,discountLevel1 DECIMAL(30, 16) null,discountLevel2 DECIMAL(30, 16) null,discountLevel3 DECIMAL(30, 16) null,discountLevel4 DECIMAL(30, 16) null,minQuantity INTEGER,displayDate DATE null,expirationDate DATE null,lastPublishDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table CommerceTierPriceEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceTierPriceEntry.minQuantity ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceTierPriceEntry.minQuantity ASC";

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

	public static final long COMMERCEPRICEENTRYID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 4L;

	public static final long MINQUANTITY_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CommerceTierPriceEntry toModel(
		CommerceTierPriceEntrySoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceTierPriceEntry model = new CommerceTierPriceEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setExternalReferenceCode(soapModel.getExternalReferenceCode());
		model.setCommerceTierPriceEntryId(
			soapModel.getCommerceTierPriceEntryId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommercePriceEntryId(soapModel.getCommercePriceEntryId());
		model.setPrice(soapModel.getPrice());
		model.setPromoPrice(soapModel.getPromoPrice());
		model.setDiscountDiscovery(soapModel.isDiscountDiscovery());
		model.setDiscountLevel1(soapModel.getDiscountLevel1());
		model.setDiscountLevel2(soapModel.getDiscountLevel2());
		model.setDiscountLevel3(soapModel.getDiscountLevel3());
		model.setDiscountLevel4(soapModel.getDiscountLevel4());
		model.setMinQuantity(soapModel.getMinQuantity());
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
	public static List<CommerceTierPriceEntry> toModels(
		CommerceTierPriceEntrySoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceTierPriceEntry> models =
			new ArrayList<CommerceTierPriceEntry>(soapModels.length);

		for (CommerceTierPriceEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.price.list.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.price.list.model.CommerceTierPriceEntry"));

	public CommerceTierPriceEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceTierPriceEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceTierPriceEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceTierPriceEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceTierPriceEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceTierPriceEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceTierPriceEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceTierPriceEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceTierPriceEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommerceTierPriceEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceTierPriceEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceTierPriceEntry, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceTierPriceEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceTierPriceEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceTierPriceEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceTierPriceEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceTierPriceEntry.class.getClassLoader(),
			CommerceTierPriceEntry.class, ModelWrapper.class);

		try {
			Constructor<CommerceTierPriceEntry> constructor =
				(Constructor<CommerceTierPriceEntry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CommerceTierPriceEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CommerceTierPriceEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceTierPriceEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommerceTierPriceEntry, Object>>();
		Map<String, BiConsumer<CommerceTierPriceEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceTierPriceEntry, ?>>();

		attributeGetterFunctions.put("uuid", CommerceTierPriceEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CommerceTierPriceEntry, String>)
				CommerceTierPriceEntry::setUuid);
		attributeGetterFunctions.put(
			"externalReferenceCode",
			CommerceTierPriceEntry::getExternalReferenceCode);
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			(BiConsumer<CommerceTierPriceEntry, String>)
				CommerceTierPriceEntry::setExternalReferenceCode);
		attributeGetterFunctions.put(
			"commerceTierPriceEntryId",
			CommerceTierPriceEntry::getCommerceTierPriceEntryId);
		attributeSetterBiConsumers.put(
			"commerceTierPriceEntryId",
			(BiConsumer<CommerceTierPriceEntry, Long>)
				CommerceTierPriceEntry::setCommerceTierPriceEntryId);
		attributeGetterFunctions.put(
			"companyId", CommerceTierPriceEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommerceTierPriceEntry, Long>)
				CommerceTierPriceEntry::setCompanyId);
		attributeGetterFunctions.put(
			"userId", CommerceTierPriceEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommerceTierPriceEntry, Long>)
				CommerceTierPriceEntry::setUserId);
		attributeGetterFunctions.put(
			"userName", CommerceTierPriceEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommerceTierPriceEntry, String>)
				CommerceTierPriceEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", CommerceTierPriceEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommerceTierPriceEntry, Date>)
				CommerceTierPriceEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CommerceTierPriceEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommerceTierPriceEntry, Date>)
				CommerceTierPriceEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"commercePriceEntryId",
			CommerceTierPriceEntry::getCommercePriceEntryId);
		attributeSetterBiConsumers.put(
			"commercePriceEntryId",
			(BiConsumer<CommerceTierPriceEntry, Long>)
				CommerceTierPriceEntry::setCommercePriceEntryId);
		attributeGetterFunctions.put("price", CommerceTierPriceEntry::getPrice);
		attributeSetterBiConsumers.put(
			"price",
			(BiConsumer<CommerceTierPriceEntry, BigDecimal>)
				CommerceTierPriceEntry::setPrice);
		attributeGetterFunctions.put(
			"promoPrice", CommerceTierPriceEntry::getPromoPrice);
		attributeSetterBiConsumers.put(
			"promoPrice",
			(BiConsumer<CommerceTierPriceEntry, BigDecimal>)
				CommerceTierPriceEntry::setPromoPrice);
		attributeGetterFunctions.put(
			"discountDiscovery", CommerceTierPriceEntry::getDiscountDiscovery);
		attributeSetterBiConsumers.put(
			"discountDiscovery",
			(BiConsumer<CommerceTierPriceEntry, Boolean>)
				CommerceTierPriceEntry::setDiscountDiscovery);
		attributeGetterFunctions.put(
			"discountLevel1", CommerceTierPriceEntry::getDiscountLevel1);
		attributeSetterBiConsumers.put(
			"discountLevel1",
			(BiConsumer<CommerceTierPriceEntry, BigDecimal>)
				CommerceTierPriceEntry::setDiscountLevel1);
		attributeGetterFunctions.put(
			"discountLevel2", CommerceTierPriceEntry::getDiscountLevel2);
		attributeSetterBiConsumers.put(
			"discountLevel2",
			(BiConsumer<CommerceTierPriceEntry, BigDecimal>)
				CommerceTierPriceEntry::setDiscountLevel2);
		attributeGetterFunctions.put(
			"discountLevel3", CommerceTierPriceEntry::getDiscountLevel3);
		attributeSetterBiConsumers.put(
			"discountLevel3",
			(BiConsumer<CommerceTierPriceEntry, BigDecimal>)
				CommerceTierPriceEntry::setDiscountLevel3);
		attributeGetterFunctions.put(
			"discountLevel4", CommerceTierPriceEntry::getDiscountLevel4);
		attributeSetterBiConsumers.put(
			"discountLevel4",
			(BiConsumer<CommerceTierPriceEntry, BigDecimal>)
				CommerceTierPriceEntry::setDiscountLevel4);
		attributeGetterFunctions.put(
			"minQuantity", CommerceTierPriceEntry::getMinQuantity);
		attributeSetterBiConsumers.put(
			"minQuantity",
			(BiConsumer<CommerceTierPriceEntry, Integer>)
				CommerceTierPriceEntry::setMinQuantity);
		attributeGetterFunctions.put(
			"displayDate", CommerceTierPriceEntry::getDisplayDate);
		attributeSetterBiConsumers.put(
			"displayDate",
			(BiConsumer<CommerceTierPriceEntry, Date>)
				CommerceTierPriceEntry::setDisplayDate);
		attributeGetterFunctions.put(
			"expirationDate", CommerceTierPriceEntry::getExpirationDate);
		attributeSetterBiConsumers.put(
			"expirationDate",
			(BiConsumer<CommerceTierPriceEntry, Date>)
				CommerceTierPriceEntry::setExpirationDate);
		attributeGetterFunctions.put(
			"lastPublishDate", CommerceTierPriceEntry::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<CommerceTierPriceEntry, Date>)
				CommerceTierPriceEntry::setLastPublishDate);
		attributeGetterFunctions.put(
			"status", CommerceTierPriceEntry::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<CommerceTierPriceEntry, Integer>)
				CommerceTierPriceEntry::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", CommerceTierPriceEntry::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<CommerceTierPriceEntry, Long>)
				CommerceTierPriceEntry::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", CommerceTierPriceEntry::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<CommerceTierPriceEntry, String>)
				CommerceTierPriceEntry::setStatusByUserName);
		attributeGetterFunctions.put(
			"statusDate", CommerceTierPriceEntry::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<CommerceTierPriceEntry, Date>)
				CommerceTierPriceEntry::setStatusDate);

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
	public long getCommerceTierPriceEntryId() {
		return _commerceTierPriceEntryId;
	}

	@Override
	public void setCommerceTierPriceEntryId(long commerceTierPriceEntryId) {
		_commerceTierPriceEntryId = commerceTierPriceEntryId;
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
	public long getCommercePriceEntryId() {
		return _commercePriceEntryId;
	}

	@Override
	public void setCommercePriceEntryId(long commercePriceEntryId) {
		_columnBitmask |= COMMERCEPRICEENTRYID_COLUMN_BITMASK;

		if (!_setOriginalCommercePriceEntryId) {
			_setOriginalCommercePriceEntryId = true;

			_originalCommercePriceEntryId = _commercePriceEntryId;
		}

		_commercePriceEntryId = commercePriceEntryId;
	}

	public long getOriginalCommercePriceEntryId() {
		return _originalCommercePriceEntryId;
	}

	@JSON
	@Override
	public BigDecimal getPrice() {
		return _price;
	}

	@Override
	public void setPrice(BigDecimal price) {
		_price = price;
	}

	@JSON
	@Override
	public BigDecimal getPromoPrice() {
		return _promoPrice;
	}

	@Override
	public void setPromoPrice(BigDecimal promoPrice) {
		_promoPrice = promoPrice;
	}

	@JSON
	@Override
	public boolean getDiscountDiscovery() {
		return _discountDiscovery;
	}

	@JSON
	@Override
	public boolean isDiscountDiscovery() {
		return _discountDiscovery;
	}

	@Override
	public void setDiscountDiscovery(boolean discountDiscovery) {
		_discountDiscovery = discountDiscovery;
	}

	@JSON
	@Override
	public BigDecimal getDiscountLevel1() {
		return _discountLevel1;
	}

	@Override
	public void setDiscountLevel1(BigDecimal discountLevel1) {
		_discountLevel1 = discountLevel1;
	}

	@JSON
	@Override
	public BigDecimal getDiscountLevel2() {
		return _discountLevel2;
	}

	@Override
	public void setDiscountLevel2(BigDecimal discountLevel2) {
		_discountLevel2 = discountLevel2;
	}

	@JSON
	@Override
	public BigDecimal getDiscountLevel3() {
		return _discountLevel3;
	}

	@Override
	public void setDiscountLevel3(BigDecimal discountLevel3) {
		_discountLevel3 = discountLevel3;
	}

	@JSON
	@Override
	public BigDecimal getDiscountLevel4() {
		return _discountLevel4;
	}

	@Override
	public void setDiscountLevel4(BigDecimal discountLevel4) {
		_discountLevel4 = discountLevel4;
	}

	@JSON
	@Override
	public int getMinQuantity() {
		return _minQuantity;
	}

	@Override
	public void setMinQuantity(int minQuantity) {
		_columnBitmask |= MINQUANTITY_COLUMN_BITMASK;

		if (!_setOriginalMinQuantity) {
			_setOriginalMinQuantity = true;

			_originalMinQuantity = _minQuantity;
		}

		_minQuantity = minQuantity;
	}

	public int getOriginalMinQuantity() {
		return _originalMinQuantity;
	}

	@JSON
	@Override
	public Date getDisplayDate() {
		return _displayDate;
	}

	@Override
	public void setDisplayDate(Date displayDate) {
		_displayDate = displayDate;
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
		_status = status;
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
			PortalUtil.getClassNameId(CommerceTierPriceEntry.class.getName()));
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
			getCompanyId(), CommerceTierPriceEntry.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceTierPriceEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceTierPriceEntry>
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
		CommerceTierPriceEntryImpl commerceTierPriceEntryImpl =
			new CommerceTierPriceEntryImpl();

		commerceTierPriceEntryImpl.setUuid(getUuid());
		commerceTierPriceEntryImpl.setExternalReferenceCode(
			getExternalReferenceCode());
		commerceTierPriceEntryImpl.setCommerceTierPriceEntryId(
			getCommerceTierPriceEntryId());
		commerceTierPriceEntryImpl.setCompanyId(getCompanyId());
		commerceTierPriceEntryImpl.setUserId(getUserId());
		commerceTierPriceEntryImpl.setUserName(getUserName());
		commerceTierPriceEntryImpl.setCreateDate(getCreateDate());
		commerceTierPriceEntryImpl.setModifiedDate(getModifiedDate());
		commerceTierPriceEntryImpl.setCommercePriceEntryId(
			getCommercePriceEntryId());
		commerceTierPriceEntryImpl.setPrice(getPrice());
		commerceTierPriceEntryImpl.setPromoPrice(getPromoPrice());
		commerceTierPriceEntryImpl.setDiscountDiscovery(isDiscountDiscovery());
		commerceTierPriceEntryImpl.setDiscountLevel1(getDiscountLevel1());
		commerceTierPriceEntryImpl.setDiscountLevel2(getDiscountLevel2());
		commerceTierPriceEntryImpl.setDiscountLevel3(getDiscountLevel3());
		commerceTierPriceEntryImpl.setDiscountLevel4(getDiscountLevel4());
		commerceTierPriceEntryImpl.setMinQuantity(getMinQuantity());
		commerceTierPriceEntryImpl.setDisplayDate(getDisplayDate());
		commerceTierPriceEntryImpl.setExpirationDate(getExpirationDate());
		commerceTierPriceEntryImpl.setLastPublishDate(getLastPublishDate());
		commerceTierPriceEntryImpl.setStatus(getStatus());
		commerceTierPriceEntryImpl.setStatusByUserId(getStatusByUserId());
		commerceTierPriceEntryImpl.setStatusByUserName(getStatusByUserName());
		commerceTierPriceEntryImpl.setStatusDate(getStatusDate());

		commerceTierPriceEntryImpl.resetOriginalValues();

		return commerceTierPriceEntryImpl;
	}

	@Override
	public int compareTo(CommerceTierPriceEntry commerceTierPriceEntry) {
		int value = 0;

		if (getMinQuantity() < commerceTierPriceEntry.getMinQuantity()) {
			value = -1;
		}
		else if (getMinQuantity() > commerceTierPriceEntry.getMinQuantity()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(object instanceof CommerceTierPriceEntry)) {
			return false;
		}

		CommerceTierPriceEntry commerceTierPriceEntry =
			(CommerceTierPriceEntry)object;

		long primaryKey = commerceTierPriceEntry.getPrimaryKey();

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

		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_setModifiedDate = false;
		_originalCommercePriceEntryId = _commercePriceEntryId;

		_setOriginalCommercePriceEntryId = false;

		_originalMinQuantity = _minQuantity;

		_setOriginalMinQuantity = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceTierPriceEntry> toCacheModel() {
		CommerceTierPriceEntryCacheModel commerceTierPriceEntryCacheModel =
			new CommerceTierPriceEntryCacheModel();

		commerceTierPriceEntryCacheModel.uuid = getUuid();

		String uuid = commerceTierPriceEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			commerceTierPriceEntryCacheModel.uuid = null;
		}

		commerceTierPriceEntryCacheModel.externalReferenceCode =
			getExternalReferenceCode();

		String externalReferenceCode =
			commerceTierPriceEntryCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			commerceTierPriceEntryCacheModel.externalReferenceCode = null;
		}

		commerceTierPriceEntryCacheModel.commerceTierPriceEntryId =
			getCommerceTierPriceEntryId();

		commerceTierPriceEntryCacheModel.companyId = getCompanyId();

		commerceTierPriceEntryCacheModel.userId = getUserId();

		commerceTierPriceEntryCacheModel.userName = getUserName();

		String userName = commerceTierPriceEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceTierPriceEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceTierPriceEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceTierPriceEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceTierPriceEntryCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceTierPriceEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceTierPriceEntryCacheModel.commercePriceEntryId =
			getCommercePriceEntryId();

		commerceTierPriceEntryCacheModel.price = getPrice();

		commerceTierPriceEntryCacheModel.promoPrice = getPromoPrice();

		commerceTierPriceEntryCacheModel.discountDiscovery =
			isDiscountDiscovery();

		commerceTierPriceEntryCacheModel.discountLevel1 = getDiscountLevel1();

		commerceTierPriceEntryCacheModel.discountLevel2 = getDiscountLevel2();

		commerceTierPriceEntryCacheModel.discountLevel3 = getDiscountLevel3();

		commerceTierPriceEntryCacheModel.discountLevel4 = getDiscountLevel4();

		commerceTierPriceEntryCacheModel.minQuantity = getMinQuantity();

		Date displayDate = getDisplayDate();

		if (displayDate != null) {
			commerceTierPriceEntryCacheModel.displayDate =
				displayDate.getTime();
		}
		else {
			commerceTierPriceEntryCacheModel.displayDate = Long.MIN_VALUE;
		}

		Date expirationDate = getExpirationDate();

		if (expirationDate != null) {
			commerceTierPriceEntryCacheModel.expirationDate =
				expirationDate.getTime();
		}
		else {
			commerceTierPriceEntryCacheModel.expirationDate = Long.MIN_VALUE;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			commerceTierPriceEntryCacheModel.lastPublishDate =
				lastPublishDate.getTime();
		}
		else {
			commerceTierPriceEntryCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		commerceTierPriceEntryCacheModel.status = getStatus();

		commerceTierPriceEntryCacheModel.statusByUserId = getStatusByUserId();

		commerceTierPriceEntryCacheModel.statusByUserName =
			getStatusByUserName();

		String statusByUserName =
			commerceTierPriceEntryCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			commerceTierPriceEntryCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			commerceTierPriceEntryCacheModel.statusDate = statusDate.getTime();
		}
		else {
			commerceTierPriceEntryCacheModel.statusDate = Long.MIN_VALUE;
		}

		return commerceTierPriceEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceTierPriceEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceTierPriceEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceTierPriceEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CommerceTierPriceEntry)this));
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
		Map<String, Function<CommerceTierPriceEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceTierPriceEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceTierPriceEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CommerceTierPriceEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CommerceTierPriceEntry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private String _externalReferenceCode;
	private String _originalExternalReferenceCode;
	private long _commerceTierPriceEntryId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commercePriceEntryId;
	private long _originalCommercePriceEntryId;
	private boolean _setOriginalCommercePriceEntryId;
	private BigDecimal _price;
	private BigDecimal _promoPrice;
	private boolean _discountDiscovery;
	private BigDecimal _discountLevel1;
	private BigDecimal _discountLevel2;
	private BigDecimal _discountLevel3;
	private BigDecimal _discountLevel4;
	private int _minQuantity;
	private int _originalMinQuantity;
	private boolean _setOriginalMinQuantity;
	private Date _displayDate;
	private Date _expirationDate;
	private Date _lastPublishDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private CommerceTierPriceEntry _escapedModel;

}