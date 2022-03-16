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

package com.liferay.commerce.shipping.engine.fixed.model.impl;

import com.liferay.commerce.shipping.engine.fixed.model.CommerceShippingFixedOption;
import com.liferay.commerce.shipping.engine.fixed.model.CommerceShippingFixedOptionModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.math.BigDecimal;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CommerceShippingFixedOption service. Represents a row in the &quot;CommerceShippingFixedOption&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommerceShippingFixedOptionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceShippingFixedOptionImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceShippingFixedOptionImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceShippingFixedOptionModelImpl
	extends BaseModelImpl<CommerceShippingFixedOption>
	implements CommerceShippingFixedOptionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce shipping fixed option model instance should use the <code>CommerceShippingFixedOption</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceShippingFixedOption";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT},
		{"commerceShippingFixedOptionId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"commerceShippingMethodId", Types.BIGINT}, {"amount", Types.DECIMAL},
		{"description", Types.VARCHAR}, {"key_", Types.VARCHAR},
		{"name", Types.VARCHAR}, {"priority", Types.DOUBLE}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceShippingFixedOptionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceShippingMethodId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("amount", Types.DECIMAL);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("key_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("priority", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceShippingFixedOption (mvccVersion LONG default 0 not null,commerceShippingFixedOptionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceShippingMethodId LONG,amount DECIMAL(30, 16) null,description STRING null,key_ VARCHAR(75) null,name STRING null,priority DOUBLE)";

	public static final String TABLE_SQL_DROP =
		"drop table CommerceShippingFixedOption";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceShippingFixedOption.priority ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceShippingFixedOption.priority ASC";

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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMMERCESHIPPINGMETHODID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long KEY_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PRIORITY_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.shipping.engine.fixed.service.util.ServiceProps.
			get(
				"lock.expiration.time.com.liferay.commerce.shipping.engine.fixed.model.CommerceShippingFixedOption"));

	public CommerceShippingFixedOptionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceShippingFixedOptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceShippingFixedOptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceShippingFixedOptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceShippingFixedOption.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceShippingFixedOption.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceShippingFixedOption, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceShippingFixedOption, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceShippingFixedOption, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(CommerceShippingFixedOption)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceShippingFixedOption, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceShippingFixedOption, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceShippingFixedOption)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceShippingFixedOption, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceShippingFixedOption, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceShippingFixedOption>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceShippingFixedOption.class.getClassLoader(),
			CommerceShippingFixedOption.class, ModelWrapper.class);

		try {
			Constructor<CommerceShippingFixedOption> constructor =
				(Constructor<CommerceShippingFixedOption>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map
		<String, Function<CommerceShippingFixedOption, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CommerceShippingFixedOption, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceShippingFixedOption, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommerceShippingFixedOption, Object>>();
		Map<String, BiConsumer<CommerceShippingFixedOption, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceShippingFixedOption, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", CommerceShippingFixedOption::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<CommerceShippingFixedOption, Long>)
				CommerceShippingFixedOption::setMvccVersion);
		attributeGetterFunctions.put(
			"commerceShippingFixedOptionId",
			CommerceShippingFixedOption::getCommerceShippingFixedOptionId);
		attributeSetterBiConsumers.put(
			"commerceShippingFixedOptionId",
			(BiConsumer<CommerceShippingFixedOption, Long>)
				CommerceShippingFixedOption::setCommerceShippingFixedOptionId);
		attributeGetterFunctions.put(
			"groupId", CommerceShippingFixedOption::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CommerceShippingFixedOption, Long>)
				CommerceShippingFixedOption::setGroupId);
		attributeGetterFunctions.put(
			"companyId", CommerceShippingFixedOption::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommerceShippingFixedOption, Long>)
				CommerceShippingFixedOption::setCompanyId);
		attributeGetterFunctions.put(
			"userId", CommerceShippingFixedOption::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommerceShippingFixedOption, Long>)
				CommerceShippingFixedOption::setUserId);
		attributeGetterFunctions.put(
			"userName", CommerceShippingFixedOption::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommerceShippingFixedOption, String>)
				CommerceShippingFixedOption::setUserName);
		attributeGetterFunctions.put(
			"createDate", CommerceShippingFixedOption::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommerceShippingFixedOption, Date>)
				CommerceShippingFixedOption::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CommerceShippingFixedOption::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommerceShippingFixedOption, Date>)
				CommerceShippingFixedOption::setModifiedDate);
		attributeGetterFunctions.put(
			"commerceShippingMethodId",
			CommerceShippingFixedOption::getCommerceShippingMethodId);
		attributeSetterBiConsumers.put(
			"commerceShippingMethodId",
			(BiConsumer<CommerceShippingFixedOption, Long>)
				CommerceShippingFixedOption::setCommerceShippingMethodId);
		attributeGetterFunctions.put(
			"amount", CommerceShippingFixedOption::getAmount);
		attributeSetterBiConsumers.put(
			"amount",
			(BiConsumer<CommerceShippingFixedOption, BigDecimal>)
				CommerceShippingFixedOption::setAmount);
		attributeGetterFunctions.put(
			"description", CommerceShippingFixedOption::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<CommerceShippingFixedOption, String>)
				CommerceShippingFixedOption::setDescription);
		attributeGetterFunctions.put(
			"key", CommerceShippingFixedOption::getKey);
		attributeSetterBiConsumers.put(
			"key",
			(BiConsumer<CommerceShippingFixedOption, String>)
				CommerceShippingFixedOption::setKey);
		attributeGetterFunctions.put(
			"name", CommerceShippingFixedOption::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<CommerceShippingFixedOption, String>)
				CommerceShippingFixedOption::setName);
		attributeGetterFunctions.put(
			"priority", CommerceShippingFixedOption::getPriority);
		attributeSetterBiConsumers.put(
			"priority",
			(BiConsumer<CommerceShippingFixedOption, Double>)
				CommerceShippingFixedOption::setPriority);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getCommerceShippingFixedOptionId() {
		return _commerceShippingFixedOptionId;
	}

	@Override
	public void setCommerceShippingFixedOptionId(
		long commerceShippingFixedOptionId) {

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commerceShippingFixedOptionId = commerceShippingFixedOptionId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCommerceShippingMethodId() {
		return _commerceShippingMethodId;
	}

	@Override
	public void setCommerceShippingMethodId(long commerceShippingMethodId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_commerceShippingMethodId = commerceShippingMethodId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCommerceShippingMethodId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("commerceShippingMethodId"));
	}

	@JSON
	@Override
	public BigDecimal getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(BigDecimal amount) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_amount = amount;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getDescription(), languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setDescription(
		String description, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(
				LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(
				LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale) {

		if (descriptionMap == null) {
			return;
		}

		setDescription(
			LocalizationUtil.updateLocalization(
				descriptionMap, getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getKey() {
		if (_key == null) {
			return "";
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_key = key;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalKey() {
		return getColumnOriginalValue("key_");
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
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getName(), languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(
				LocalizationUtil.updateLocalization(
					getName(), "Name", name, languageId, defaultLanguageId));
		}
		else {
			setName(
				LocalizationUtil.removeLocalization(
					getName(), "Name", languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(
			LocalizationUtil.updateLocalization(
				nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public double getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(double priority) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_priority = priority;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceShippingFixedOption.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getDescription();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			CommerceShippingFixedOption.class.getName(), getPrimaryKey(),
			defaultLocale, availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(
				getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(
				getDescription(defaultLocale), defaultLocale, defaultLocale);
		}

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public CommerceShippingFixedOption toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceShippingFixedOption>
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
		CommerceShippingFixedOptionImpl commerceShippingFixedOptionImpl =
			new CommerceShippingFixedOptionImpl();

		commerceShippingFixedOptionImpl.setMvccVersion(getMvccVersion());
		commerceShippingFixedOptionImpl.setCommerceShippingFixedOptionId(
			getCommerceShippingFixedOptionId());
		commerceShippingFixedOptionImpl.setGroupId(getGroupId());
		commerceShippingFixedOptionImpl.setCompanyId(getCompanyId());
		commerceShippingFixedOptionImpl.setUserId(getUserId());
		commerceShippingFixedOptionImpl.setUserName(getUserName());
		commerceShippingFixedOptionImpl.setCreateDate(getCreateDate());
		commerceShippingFixedOptionImpl.setModifiedDate(getModifiedDate());
		commerceShippingFixedOptionImpl.setCommerceShippingMethodId(
			getCommerceShippingMethodId());
		commerceShippingFixedOptionImpl.setAmount(getAmount());
		commerceShippingFixedOptionImpl.setDescription(getDescription());
		commerceShippingFixedOptionImpl.setKey(getKey());
		commerceShippingFixedOptionImpl.setName(getName());
		commerceShippingFixedOptionImpl.setPriority(getPriority());

		commerceShippingFixedOptionImpl.resetOriginalValues();

		return commerceShippingFixedOptionImpl;
	}

	@Override
	public CommerceShippingFixedOption cloneWithOriginalValues() {
		CommerceShippingFixedOptionImpl commerceShippingFixedOptionImpl =
			new CommerceShippingFixedOptionImpl();

		commerceShippingFixedOptionImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		commerceShippingFixedOptionImpl.setCommerceShippingFixedOptionId(
			this.<Long>getColumnOriginalValue("commerceShippingFixedOptionId"));
		commerceShippingFixedOptionImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		commerceShippingFixedOptionImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		commerceShippingFixedOptionImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		commerceShippingFixedOptionImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		commerceShippingFixedOptionImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		commerceShippingFixedOptionImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		commerceShippingFixedOptionImpl.setCommerceShippingMethodId(
			this.<Long>getColumnOriginalValue("commerceShippingMethodId"));
		commerceShippingFixedOptionImpl.setAmount(
			this.<BigDecimal>getColumnOriginalValue("amount"));
		commerceShippingFixedOptionImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		commerceShippingFixedOptionImpl.setKey(
			this.<String>getColumnOriginalValue("key_"));
		commerceShippingFixedOptionImpl.setName(
			this.<String>getColumnOriginalValue("name"));
		commerceShippingFixedOptionImpl.setPriority(
			this.<Double>getColumnOriginalValue("priority"));

		return commerceShippingFixedOptionImpl;
	}

	@Override
	public int compareTo(
		CommerceShippingFixedOption commerceShippingFixedOption) {

		int value = 0;

		if (getPriority() < commerceShippingFixedOption.getPriority()) {
			value = -1;
		}
		else if (getPriority() > commerceShippingFixedOption.getPriority()) {
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

		if (!(object instanceof CommerceShippingFixedOption)) {
			return false;
		}

		CommerceShippingFixedOption commerceShippingFixedOption =
			(CommerceShippingFixedOption)object;

		long primaryKey = commerceShippingFixedOption.getPrimaryKey();

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
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceShippingFixedOption> toCacheModel() {
		CommerceShippingFixedOptionCacheModel
			commerceShippingFixedOptionCacheModel =
				new CommerceShippingFixedOptionCacheModel();

		commerceShippingFixedOptionCacheModel.mvccVersion = getMvccVersion();

		commerceShippingFixedOptionCacheModel.commerceShippingFixedOptionId =
			getCommerceShippingFixedOptionId();

		commerceShippingFixedOptionCacheModel.groupId = getGroupId();

		commerceShippingFixedOptionCacheModel.companyId = getCompanyId();

		commerceShippingFixedOptionCacheModel.userId = getUserId();

		commerceShippingFixedOptionCacheModel.userName = getUserName();

		String userName = commerceShippingFixedOptionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceShippingFixedOptionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceShippingFixedOptionCacheModel.createDate =
				createDate.getTime();
		}
		else {
			commerceShippingFixedOptionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceShippingFixedOptionCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceShippingFixedOptionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceShippingFixedOptionCacheModel.commerceShippingMethodId =
			getCommerceShippingMethodId();

		commerceShippingFixedOptionCacheModel.amount = getAmount();

		commerceShippingFixedOptionCacheModel.description = getDescription();

		String description = commerceShippingFixedOptionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			commerceShippingFixedOptionCacheModel.description = null;
		}

		commerceShippingFixedOptionCacheModel.key = getKey();

		String key = commerceShippingFixedOptionCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			commerceShippingFixedOptionCacheModel.key = null;
		}

		commerceShippingFixedOptionCacheModel.name = getName();

		String name = commerceShippingFixedOptionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			commerceShippingFixedOptionCacheModel.name = null;
		}

		commerceShippingFixedOptionCacheModel.priority = getPriority();

		return commerceShippingFixedOptionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceShippingFixedOption, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceShippingFixedOption, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceShippingFixedOption, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(CommerceShippingFixedOption)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

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
		Map<String, Function<CommerceShippingFixedOption, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceShippingFixedOption, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceShippingFixedOption, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceShippingFixedOption)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CommerceShippingFixedOption>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _commerceShippingFixedOptionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceShippingMethodId;
	private BigDecimal _amount;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private String _key;
	private String _name;
	private String _nameCurrentLanguageId;
	private double _priority;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CommerceShippingFixedOption, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CommerceShippingFixedOption)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put(
			"commerceShippingFixedOptionId", _commerceShippingFixedOptionId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put(
			"commerceShippingMethodId", _commerceShippingMethodId);
		_columnOriginalValues.put("amount", _amount);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("key_", _key);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("priority", _priority);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("key_", "key");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("commerceShippingFixedOptionId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("commerceShippingMethodId", 256L);

		columnBitmasks.put("amount", 512L);

		columnBitmasks.put("description", 1024L);

		columnBitmasks.put("key_", 2048L);

		columnBitmasks.put("name", 4096L);

		columnBitmasks.put("priority", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CommerceShippingFixedOption _escapedModel;

}