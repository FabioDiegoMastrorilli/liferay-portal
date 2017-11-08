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

package com.liferay.commerce.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.model.CommerceShipmentItem;
import com.liferay.commerce.model.CommerceShipmentItemModel;
import com.liferay.commerce.model.CommerceShipmentItemSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CommerceShipmentItem service. Represents a row in the &quot;CommerceShipmentItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CommerceShipmentItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceShipmentItemImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceShipmentItemImpl
 * @see CommerceShipmentItem
 * @see CommerceShipmentItemModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommerceShipmentItemModelImpl extends BaseModelImpl<CommerceShipmentItem>
	implements CommerceShipmentItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce shipment item model instance should use the {@link CommerceShipmentItem} interface instead.
	 */
	public static final String TABLE_NAME = "CommerceShipmentItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "commerceShipmentItemId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "commerceShipmentId", Types.BIGINT },
			{ "commerceOrderItemId", Types.BIGINT },
			{ "quantity", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceShipmentItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceShipmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceOrderItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("quantity", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table CommerceShipmentItem (commerceShipmentItemId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceShipmentId LONG,commerceOrderItemId LONG,quantity INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table CommerceShipmentItem";
	public static final String ORDER_BY_JPQL = " ORDER BY commerceShipmentItem.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CommerceShipmentItem.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.model.CommerceShipmentItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.model.CommerceShipmentItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.model.CommerceShipmentItem"),
			true);
	public static final long COMMERCESHIPMENTID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long CREATEDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceShipmentItem toModel(
		CommerceShipmentItemSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommerceShipmentItem model = new CommerceShipmentItemImpl();

		model.setCommerceShipmentItemId(soapModel.getCommerceShipmentItemId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceShipmentId(soapModel.getCommerceShipmentId());
		model.setCommerceOrderItemId(soapModel.getCommerceOrderItemId());
		model.setQuantity(soapModel.getQuantity());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceShipmentItem> toModels(
		CommerceShipmentItemSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommerceShipmentItem> models = new ArrayList<CommerceShipmentItem>(soapModels.length);

		for (CommerceShipmentItemSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.model.CommerceShipmentItem"));

	public CommerceShipmentItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceShipmentItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceShipmentItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceShipmentItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceShipmentItem.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceShipmentItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commerceShipmentItemId", getCommerceShipmentItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("commerceShipmentId", getCommerceShipmentId());
		attributes.put("commerceOrderItemId", getCommerceOrderItemId());
		attributes.put("quantity", getQuantity());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commerceShipmentItemId = (Long)attributes.get(
				"commerceShipmentItemId");

		if (commerceShipmentItemId != null) {
			setCommerceShipmentItemId(commerceShipmentItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long commerceShipmentId = (Long)attributes.get("commerceShipmentId");

		if (commerceShipmentId != null) {
			setCommerceShipmentId(commerceShipmentId);
		}

		Long commerceOrderItemId = (Long)attributes.get("commerceOrderItemId");

		if (commerceOrderItemId != null) {
			setCommerceOrderItemId(commerceOrderItemId);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}
	}

	@JSON
	@Override
	public long getCommerceShipmentItemId() {
		return _commerceShipmentItemId;
	}

	@Override
	public void setCommerceShipmentItemId(long commerceShipmentItemId) {
		_commerceShipmentItemId = commerceShipmentItemId;
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
		_companyId = companyId;
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
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
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
		_columnBitmask = -1L;

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
	public long getCommerceShipmentId() {
		return _commerceShipmentId;
	}

	@Override
	public void setCommerceShipmentId(long commerceShipmentId) {
		_columnBitmask |= COMMERCESHIPMENTID_COLUMN_BITMASK;

		if (!_setOriginalCommerceShipmentId) {
			_setOriginalCommerceShipmentId = true;

			_originalCommerceShipmentId = _commerceShipmentId;
		}

		_commerceShipmentId = commerceShipmentId;
	}

	public long getOriginalCommerceShipmentId() {
		return _originalCommerceShipmentId;
	}

	@JSON
	@Override
	public long getCommerceOrderItemId() {
		return _commerceOrderItemId;
	}

	@Override
	public void setCommerceOrderItemId(long commerceOrderItemId) {
		_commerceOrderItemId = commerceOrderItemId;
	}

	@JSON
	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CommerceShipmentItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceShipmentItem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommerceShipmentItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommerceShipmentItemImpl commerceShipmentItemImpl = new CommerceShipmentItemImpl();

		commerceShipmentItemImpl.setCommerceShipmentItemId(getCommerceShipmentItemId());
		commerceShipmentItemImpl.setGroupId(getGroupId());
		commerceShipmentItemImpl.setCompanyId(getCompanyId());
		commerceShipmentItemImpl.setUserId(getUserId());
		commerceShipmentItemImpl.setUserName(getUserName());
		commerceShipmentItemImpl.setCreateDate(getCreateDate());
		commerceShipmentItemImpl.setModifiedDate(getModifiedDate());
		commerceShipmentItemImpl.setCommerceShipmentId(getCommerceShipmentId());
		commerceShipmentItemImpl.setCommerceOrderItemId(getCommerceOrderItemId());
		commerceShipmentItemImpl.setQuantity(getQuantity());

		commerceShipmentItemImpl.resetOriginalValues();

		return commerceShipmentItemImpl;
	}

	@Override
	public int compareTo(CommerceShipmentItem commerceShipmentItem) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				commerceShipmentItem.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceShipmentItem)) {
			return false;
		}

		CommerceShipmentItem commerceShipmentItem = (CommerceShipmentItem)obj;

		long primaryKey = commerceShipmentItem.getPrimaryKey();

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

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CommerceShipmentItemModelImpl commerceShipmentItemModelImpl = this;

		commerceShipmentItemModelImpl._originalGroupId = commerceShipmentItemModelImpl._groupId;

		commerceShipmentItemModelImpl._setOriginalGroupId = false;

		commerceShipmentItemModelImpl._setModifiedDate = false;

		commerceShipmentItemModelImpl._originalCommerceShipmentId = commerceShipmentItemModelImpl._commerceShipmentId;

		commerceShipmentItemModelImpl._setOriginalCommerceShipmentId = false;

		commerceShipmentItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceShipmentItem> toCacheModel() {
		CommerceShipmentItemCacheModel commerceShipmentItemCacheModel = new CommerceShipmentItemCacheModel();

		commerceShipmentItemCacheModel.commerceShipmentItemId = getCommerceShipmentItemId();

		commerceShipmentItemCacheModel.groupId = getGroupId();

		commerceShipmentItemCacheModel.companyId = getCompanyId();

		commerceShipmentItemCacheModel.userId = getUserId();

		commerceShipmentItemCacheModel.userName = getUserName();

		String userName = commerceShipmentItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceShipmentItemCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceShipmentItemCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceShipmentItemCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceShipmentItemCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commerceShipmentItemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceShipmentItemCacheModel.commerceShipmentId = getCommerceShipmentId();

		commerceShipmentItemCacheModel.commerceOrderItemId = getCommerceOrderItemId();

		commerceShipmentItemCacheModel.quantity = getQuantity();

		return commerceShipmentItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{commerceShipmentItemId=");
		sb.append(getCommerceShipmentItemId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", commerceShipmentId=");
		sb.append(getCommerceShipmentId());
		sb.append(", commerceOrderItemId=");
		sb.append(getCommerceOrderItemId());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.commerce.model.CommerceShipmentItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commerceShipmentItemId</column-name><column-value><![CDATA[");
		sb.append(getCommerceShipmentItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commerceShipmentId</column-name><column-value><![CDATA[");
		sb.append(getCommerceShipmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commerceOrderItemId</column-name><column-value><![CDATA[");
		sb.append(getCommerceOrderItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CommerceShipmentItem.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CommerceShipmentItem.class
		};
	private long _commerceShipmentItemId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceShipmentId;
	private long _originalCommerceShipmentId;
	private boolean _setOriginalCommerceShipmentId;
	private long _commerceOrderItemId;
	private int _quantity;
	private long _columnBitmask;
	private CommerceShipmentItem _escapedModel;
}