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

package com.liferay.commerce.account.model.impl;

import com.liferay.commerce.account.model.CommerceAccountUserRel;
import com.liferay.commerce.account.model.CommerceAccountUserRelModel;
import com.liferay.commerce.account.model.CommerceAccountUserRelSoap;
import com.liferay.commerce.account.service.persistence.CommerceAccountUserRelPK;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

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
 * The base model implementation for the CommerceAccountUserRel service. Represents a row in the &quot;CommerceAccountUserRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommerceAccountUserRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceAccountUserRelImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CommerceAccountUserRelImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceAccountUserRelModelImpl
	extends BaseModelImpl<CommerceAccountUserRel>
	implements CommerceAccountUserRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce account user rel model instance should use the <code>CommerceAccountUserRel</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceAccountUserRel";

	public static final Object[][] TABLE_COLUMNS = {
		{"commerceAccountId", Types.BIGINT},
		{"commerceAccountUserId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceAccountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceAccountUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceAccountUserRel (commerceAccountId LONG not null,commerceAccountUserId LONG not null,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,primary key (commerceAccountId, commerceAccountUserId))";

	public static final String TABLE_SQL_DROP =
		"drop table CommerceAccountUserRel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceAccountUserRel.userId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceAccountUserRel.userId ASC";

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

	public static final long COMMERCEACCOUNTID_COLUMN_BITMASK = 1L;

	public static final long COMMERCEACCOUNTUSERID_COLUMN_BITMASK = 2L;

	public static final long USERID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CommerceAccountUserRel toModel(
		CommerceAccountUserRelSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceAccountUserRel model = new CommerceAccountUserRelImpl();

		model.setCommerceAccountId(soapModel.getCommerceAccountId());
		model.setCommerceAccountUserId(soapModel.getCommerceAccountUserId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

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
	public static List<CommerceAccountUserRel> toModels(
		CommerceAccountUserRelSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceAccountUserRel> models =
			new ArrayList<CommerceAccountUserRel>(soapModels.length);

		for (CommerceAccountUserRelSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.account.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.account.model.CommerceAccountUserRel"));

	public CommerceAccountUserRelModelImpl() {
	}

	@Override
	public CommerceAccountUserRelPK getPrimaryKey() {
		return new CommerceAccountUserRelPK(
			_commerceAccountId, _commerceAccountUserId);
	}

	@Override
	public void setPrimaryKey(CommerceAccountUserRelPK primaryKey) {
		setCommerceAccountId(primaryKey.commerceAccountId);
		setCommerceAccountUserId(primaryKey.commerceAccountUserId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new CommerceAccountUserRelPK(
			_commerceAccountId, _commerceAccountUserId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CommerceAccountUserRelPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceAccountUserRel.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceAccountUserRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceAccountUserRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceAccountUserRel, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceAccountUserRel, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommerceAccountUserRel)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceAccountUserRel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceAccountUserRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceAccountUserRel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceAccountUserRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceAccountUserRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceAccountUserRel>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceAccountUserRel.class.getClassLoader(),
			CommerceAccountUserRel.class, ModelWrapper.class);

		try {
			Constructor<CommerceAccountUserRel> constructor =
				(Constructor<CommerceAccountUserRel>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CommerceAccountUserRel, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CommerceAccountUserRel, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceAccountUserRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommerceAccountUserRel, Object>>();
		Map<String, BiConsumer<CommerceAccountUserRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceAccountUserRel, ?>>();

		attributeGetterFunctions.put(
			"commerceAccountId", CommerceAccountUserRel::getCommerceAccountId);
		attributeSetterBiConsumers.put(
			"commerceAccountId",
			(BiConsumer<CommerceAccountUserRel, Long>)
				CommerceAccountUserRel::setCommerceAccountId);
		attributeGetterFunctions.put(
			"commerceAccountUserId",
			CommerceAccountUserRel::getCommerceAccountUserId);
		attributeSetterBiConsumers.put(
			"commerceAccountUserId",
			(BiConsumer<CommerceAccountUserRel, Long>)
				CommerceAccountUserRel::setCommerceAccountUserId);
		attributeGetterFunctions.put(
			"companyId", CommerceAccountUserRel::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommerceAccountUserRel, Long>)
				CommerceAccountUserRel::setCompanyId);
		attributeGetterFunctions.put(
			"userId", CommerceAccountUserRel::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommerceAccountUserRel, Long>)
				CommerceAccountUserRel::setUserId);
		attributeGetterFunctions.put(
			"userName", CommerceAccountUserRel::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommerceAccountUserRel, String>)
				CommerceAccountUserRel::setUserName);
		attributeGetterFunctions.put(
			"createDate", CommerceAccountUserRel::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommerceAccountUserRel, Date>)
				CommerceAccountUserRel::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CommerceAccountUserRel::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommerceAccountUserRel, Date>)
				CommerceAccountUserRel::setModifiedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCommerceAccountId() {
		return _commerceAccountId;
	}

	@Override
	public void setCommerceAccountId(long commerceAccountId) {
		_columnBitmask |= COMMERCEACCOUNTID_COLUMN_BITMASK;

		if (!_setOriginalCommerceAccountId) {
			_setOriginalCommerceAccountId = true;

			_originalCommerceAccountId = _commerceAccountId;
		}

		_commerceAccountId = commerceAccountId;
	}

	public long getOriginalCommerceAccountId() {
		return _originalCommerceAccountId;
	}

	@JSON
	@Override
	public long getCommerceAccountUserId() {
		return _commerceAccountUserId;
	}

	@Override
	public void setCommerceAccountUserId(long commerceAccountUserId) {
		_columnBitmask |= COMMERCEACCOUNTUSERID_COLUMN_BITMASK;

		if (!_setOriginalCommerceAccountUserId) {
			_setOriginalCommerceAccountUserId = true;

			_originalCommerceAccountUserId = _commerceAccountUserId;
		}

		_commerceAccountUserId = commerceAccountUserId;
	}

	@Override
	public String getCommerceAccountUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(
				getCommerceAccountUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setCommerceAccountUserUuid(String commerceAccountUserUuid) {
	}

	public long getOriginalCommerceAccountUserId() {
		return _originalCommerceAccountUserId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public CommerceAccountUserRel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceAccountUserRel>
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
		CommerceAccountUserRelImpl commerceAccountUserRelImpl =
			new CommerceAccountUserRelImpl();

		commerceAccountUserRelImpl.setCommerceAccountId(getCommerceAccountId());
		commerceAccountUserRelImpl.setCommerceAccountUserId(
			getCommerceAccountUserId());
		commerceAccountUserRelImpl.setCompanyId(getCompanyId());
		commerceAccountUserRelImpl.setUserId(getUserId());
		commerceAccountUserRelImpl.setUserName(getUserName());
		commerceAccountUserRelImpl.setCreateDate(getCreateDate());
		commerceAccountUserRelImpl.setModifiedDate(getModifiedDate());

		commerceAccountUserRelImpl.resetOriginalValues();

		return commerceAccountUserRelImpl;
	}

	@Override
	public int compareTo(CommerceAccountUserRel commerceAccountUserRel) {
		int value = 0;

		if (getUserId() < commerceAccountUserRel.getUserId()) {
			value = -1;
		}
		else if (getUserId() > commerceAccountUserRel.getUserId()) {
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

		if (!(object instanceof CommerceAccountUserRel)) {
			return false;
		}

		CommerceAccountUserRel commerceAccountUserRel =
			(CommerceAccountUserRel)object;

		CommerceAccountUserRelPK primaryKey =
			commerceAccountUserRel.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
		_originalCommerceAccountId = _commerceAccountId;

		_setOriginalCommerceAccountId = false;

		_originalCommerceAccountUserId = _commerceAccountUserId;

		_setOriginalCommerceAccountUserId = false;

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceAccountUserRel> toCacheModel() {
		CommerceAccountUserRelCacheModel commerceAccountUserRelCacheModel =
			new CommerceAccountUserRelCacheModel();

		commerceAccountUserRelCacheModel.commerceAccountUserRelPK =
			getPrimaryKey();

		commerceAccountUserRelCacheModel.commerceAccountId =
			getCommerceAccountId();

		commerceAccountUserRelCacheModel.commerceAccountUserId =
			getCommerceAccountUserId();

		commerceAccountUserRelCacheModel.companyId = getCompanyId();

		commerceAccountUserRelCacheModel.userId = getUserId();

		commerceAccountUserRelCacheModel.userName = getUserName();

		String userName = commerceAccountUserRelCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceAccountUserRelCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceAccountUserRelCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceAccountUserRelCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceAccountUserRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceAccountUserRelCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return commerceAccountUserRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceAccountUserRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceAccountUserRel, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceAccountUserRel, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CommerceAccountUserRel)this));
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
		Map<String, Function<CommerceAccountUserRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceAccountUserRel, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceAccountUserRel, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CommerceAccountUserRel)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CommerceAccountUserRel>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _commerceAccountId;
	private long _originalCommerceAccountId;
	private boolean _setOriginalCommerceAccountId;
	private long _commerceAccountUserId;
	private long _originalCommerceAccountUserId;
	private boolean _setOriginalCommerceAccountUserId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private CommerceAccountUserRel _escapedModel;

}