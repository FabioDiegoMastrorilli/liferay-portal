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

import com.liferay.commerce.model.CommerceCountry;
import com.liferay.commerce.model.CommerceCountryModel;
import com.liferay.commerce.model.CommerceCountrySoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
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
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

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
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CommerceCountry service. Represents a row in the &quot;CommerceCountry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommerceCountryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceCountryImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceCountryImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceCountryModelImpl
	extends BaseModelImpl<CommerceCountry> implements CommerceCountryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce country model instance should use the <code>CommerceCountry</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceCountry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"commerceCountryId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"billingAllowed", Types.BOOLEAN}, {"shippingAllowed", Types.BOOLEAN},
		{"twoLettersISOCode", Types.VARCHAR},
		{"threeLettersISOCode", Types.VARCHAR},
		{"numericISOCode", Types.INTEGER}, {"subjectToVAT", Types.BOOLEAN},
		{"priority", Types.DOUBLE}, {"active_", Types.BOOLEAN},
		{"lastPublishDate", Types.TIMESTAMP},
		{"channelFilterEnabled", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("commerceCountryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("billingAllowed", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("shippingAllowed", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("twoLettersISOCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("threeLettersISOCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("numericISOCode", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("subjectToVAT", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("priority", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("channelFilterEnabled", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceCountry (uuid_ VARCHAR(75) null,commerceCountryId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name STRING null,billingAllowed BOOLEAN,shippingAllowed BOOLEAN,twoLettersISOCode VARCHAR(75) null,threeLettersISOCode VARCHAR(75) null,numericISOCode INTEGER,subjectToVAT BOOLEAN,priority DOUBLE,active_ BOOLEAN,lastPublishDate DATE null,channelFilterEnabled BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table CommerceCountry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceCountry.priority ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceCountry.priority ASC";

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

	public static final long ACTIVE_COLUMN_BITMASK = 1L;

	public static final long BILLINGALLOWED_COLUMN_BITMASK = 2L;

	public static final long COMPANYID_COLUMN_BITMASK = 4L;

	public static final long NUMERICISOCODE_COLUMN_BITMASK = 8L;

	public static final long SHIPPINGALLOWED_COLUMN_BITMASK = 16L;

	public static final long TWOLETTERSISOCODE_COLUMN_BITMASK = 32L;

	public static final long UUID_COLUMN_BITMASK = 64L;

	public static final long PRIORITY_COLUMN_BITMASK = 128L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CommerceCountry toModel(CommerceCountrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommerceCountry model = new CommerceCountryImpl();

		model.setUuid(soapModel.getUuid());
		model.setCommerceCountryId(soapModel.getCommerceCountryId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setBillingAllowed(soapModel.isBillingAllowed());
		model.setShippingAllowed(soapModel.isShippingAllowed());
		model.setTwoLettersISOCode(soapModel.getTwoLettersISOCode());
		model.setThreeLettersISOCode(soapModel.getThreeLettersISOCode());
		model.setNumericISOCode(soapModel.getNumericISOCode());
		model.setSubjectToVAT(soapModel.isSubjectToVAT());
		model.setPriority(soapModel.getPriority());
		model.setActive(soapModel.isActive());
		model.setLastPublishDate(soapModel.getLastPublishDate());
		model.setChannelFilterEnabled(soapModel.isChannelFilterEnabled());

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
	public static List<CommerceCountry> toModels(
		CommerceCountrySoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceCountry> models = new ArrayList<CommerceCountry>(
			soapModels.length);

		for (CommerceCountrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.model.CommerceCountry"));

	public CommerceCountryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceCountryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceCountryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceCountryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceCountry.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceCountry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceCountry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceCountry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceCountry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommerceCountry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceCountry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceCountry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceCountry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceCountry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceCountry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceCountry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceCountry.class.getClassLoader(), CommerceCountry.class,
			ModelWrapper.class);

		try {
			Constructor<CommerceCountry> constructor =
				(Constructor<CommerceCountry>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CommerceCountry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CommerceCountry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceCountry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CommerceCountry, Object>>();
		Map<String, BiConsumer<CommerceCountry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CommerceCountry, ?>>();

		attributeGetterFunctions.put("uuid", CommerceCountry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CommerceCountry, String>)CommerceCountry::setUuid);
		attributeGetterFunctions.put(
			"commerceCountryId", CommerceCountry::getCommerceCountryId);
		attributeSetterBiConsumers.put(
			"commerceCountryId",
			(BiConsumer<CommerceCountry, Long>)
				CommerceCountry::setCommerceCountryId);
		attributeGetterFunctions.put(
			"companyId", CommerceCountry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommerceCountry, Long>)CommerceCountry::setCompanyId);
		attributeGetterFunctions.put("userId", CommerceCountry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommerceCountry, Long>)CommerceCountry::setUserId);
		attributeGetterFunctions.put("userName", CommerceCountry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommerceCountry, String>)CommerceCountry::setUserName);
		attributeGetterFunctions.put(
			"createDate", CommerceCountry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommerceCountry, Date>)CommerceCountry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CommerceCountry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommerceCountry, Date>)
				CommerceCountry::setModifiedDate);
		attributeGetterFunctions.put("name", CommerceCountry::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<CommerceCountry, String>)CommerceCountry::setName);
		attributeGetterFunctions.put(
			"billingAllowed", CommerceCountry::getBillingAllowed);
		attributeSetterBiConsumers.put(
			"billingAllowed",
			(BiConsumer<CommerceCountry, Boolean>)
				CommerceCountry::setBillingAllowed);
		attributeGetterFunctions.put(
			"shippingAllowed", CommerceCountry::getShippingAllowed);
		attributeSetterBiConsumers.put(
			"shippingAllowed",
			(BiConsumer<CommerceCountry, Boolean>)
				CommerceCountry::setShippingAllowed);
		attributeGetterFunctions.put(
			"twoLettersISOCode", CommerceCountry::getTwoLettersISOCode);
		attributeSetterBiConsumers.put(
			"twoLettersISOCode",
			(BiConsumer<CommerceCountry, String>)
				CommerceCountry::setTwoLettersISOCode);
		attributeGetterFunctions.put(
			"threeLettersISOCode", CommerceCountry::getThreeLettersISOCode);
		attributeSetterBiConsumers.put(
			"threeLettersISOCode",
			(BiConsumer<CommerceCountry, String>)
				CommerceCountry::setThreeLettersISOCode);
		attributeGetterFunctions.put(
			"numericISOCode", CommerceCountry::getNumericISOCode);
		attributeSetterBiConsumers.put(
			"numericISOCode",
			(BiConsumer<CommerceCountry, Integer>)
				CommerceCountry::setNumericISOCode);
		attributeGetterFunctions.put(
			"subjectToVAT", CommerceCountry::getSubjectToVAT);
		attributeSetterBiConsumers.put(
			"subjectToVAT",
			(BiConsumer<CommerceCountry, Boolean>)
				CommerceCountry::setSubjectToVAT);
		attributeGetterFunctions.put("priority", CommerceCountry::getPriority);
		attributeSetterBiConsumers.put(
			"priority",
			(BiConsumer<CommerceCountry, Double>)CommerceCountry::setPriority);
		attributeGetterFunctions.put("active", CommerceCountry::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<CommerceCountry, Boolean>)CommerceCountry::setActive);
		attributeGetterFunctions.put(
			"lastPublishDate", CommerceCountry::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<CommerceCountry, Date>)
				CommerceCountry::setLastPublishDate);
		attributeGetterFunctions.put(
			"channelFilterEnabled", CommerceCountry::getChannelFilterEnabled);
		attributeSetterBiConsumers.put(
			"channelFilterEnabled",
			(BiConsumer<CommerceCountry, Boolean>)
				CommerceCountry::setChannelFilterEnabled);

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
	public long getCommerceCountryId() {
		return _commerceCountryId;
	}

	@Override
	public void setCommerceCountryId(long commerceCountryId) {
		_commerceCountryId = commerceCountryId;
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
		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
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
		setNameMap(nameMap, LocaleUtil.getDefault());
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
	public boolean getBillingAllowed() {
		return _billingAllowed;
	}

	@JSON
	@Override
	public boolean isBillingAllowed() {
		return _billingAllowed;
	}

	@Override
	public void setBillingAllowed(boolean billingAllowed) {
		_columnBitmask |= BILLINGALLOWED_COLUMN_BITMASK;

		if (!_setOriginalBillingAllowed) {
			_setOriginalBillingAllowed = true;

			_originalBillingAllowed = _billingAllowed;
		}

		_billingAllowed = billingAllowed;
	}

	public boolean getOriginalBillingAllowed() {
		return _originalBillingAllowed;
	}

	@JSON
	@Override
	public boolean getShippingAllowed() {
		return _shippingAllowed;
	}

	@JSON
	@Override
	public boolean isShippingAllowed() {
		return _shippingAllowed;
	}

	@Override
	public void setShippingAllowed(boolean shippingAllowed) {
		_columnBitmask |= SHIPPINGALLOWED_COLUMN_BITMASK;

		if (!_setOriginalShippingAllowed) {
			_setOriginalShippingAllowed = true;

			_originalShippingAllowed = _shippingAllowed;
		}

		_shippingAllowed = shippingAllowed;
	}

	public boolean getOriginalShippingAllowed() {
		return _originalShippingAllowed;
	}

	@JSON
	@Override
	public String getTwoLettersISOCode() {
		if (_twoLettersISOCode == null) {
			return "";
		}
		else {
			return _twoLettersISOCode;
		}
	}

	@Override
	public void setTwoLettersISOCode(String twoLettersISOCode) {
		_columnBitmask |= TWOLETTERSISOCODE_COLUMN_BITMASK;

		if (_originalTwoLettersISOCode == null) {
			_originalTwoLettersISOCode = _twoLettersISOCode;
		}

		_twoLettersISOCode = twoLettersISOCode;
	}

	public String getOriginalTwoLettersISOCode() {
		return GetterUtil.getString(_originalTwoLettersISOCode);
	}

	@JSON
	@Override
	public String getThreeLettersISOCode() {
		if (_threeLettersISOCode == null) {
			return "";
		}
		else {
			return _threeLettersISOCode;
		}
	}

	@Override
	public void setThreeLettersISOCode(String threeLettersISOCode) {
		_threeLettersISOCode = threeLettersISOCode;
	}

	@JSON
	@Override
	public int getNumericISOCode() {
		return _numericISOCode;
	}

	@Override
	public void setNumericISOCode(int numericISOCode) {
		_columnBitmask |= NUMERICISOCODE_COLUMN_BITMASK;

		if (!_setOriginalNumericISOCode) {
			_setOriginalNumericISOCode = true;

			_originalNumericISOCode = _numericISOCode;
		}

		_numericISOCode = numericISOCode;
	}

	public int getOriginalNumericISOCode() {
		return _originalNumericISOCode;
	}

	@JSON
	@Override
	public boolean getSubjectToVAT() {
		return _subjectToVAT;
	}

	@JSON
	@Override
	public boolean isSubjectToVAT() {
		return _subjectToVAT;
	}

	@Override
	public void setSubjectToVAT(boolean subjectToVAT) {
		_subjectToVAT = subjectToVAT;
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
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_columnBitmask |= ACTIVE_COLUMN_BITMASK;

		if (!_setOriginalActive) {
			_setOriginalActive = true;

			_originalActive = _active;
		}

		_active = active;
	}

	public boolean getOriginalActive() {
		return _originalActive;
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
	public boolean getChannelFilterEnabled() {
		return _channelFilterEnabled;
	}

	@JSON
	@Override
	public boolean isChannelFilterEnabled() {
		return _channelFilterEnabled;
	}

	@Override
	public void setChannelFilterEnabled(boolean channelFilterEnabled) {
		_channelFilterEnabled = channelFilterEnabled;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CommerceCountry.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceCountry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

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
		String xml = getName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			CommerceCountry.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public CommerceCountry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceCountry>
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
		CommerceCountryImpl commerceCountryImpl = new CommerceCountryImpl();

		commerceCountryImpl.setUuid(getUuid());
		commerceCountryImpl.setCommerceCountryId(getCommerceCountryId());
		commerceCountryImpl.setCompanyId(getCompanyId());
		commerceCountryImpl.setUserId(getUserId());
		commerceCountryImpl.setUserName(getUserName());
		commerceCountryImpl.setCreateDate(getCreateDate());
		commerceCountryImpl.setModifiedDate(getModifiedDate());
		commerceCountryImpl.setName(getName());
		commerceCountryImpl.setBillingAllowed(isBillingAllowed());
		commerceCountryImpl.setShippingAllowed(isShippingAllowed());
		commerceCountryImpl.setTwoLettersISOCode(getTwoLettersISOCode());
		commerceCountryImpl.setThreeLettersISOCode(getThreeLettersISOCode());
		commerceCountryImpl.setNumericISOCode(getNumericISOCode());
		commerceCountryImpl.setSubjectToVAT(isSubjectToVAT());
		commerceCountryImpl.setPriority(getPriority());
		commerceCountryImpl.setActive(isActive());
		commerceCountryImpl.setLastPublishDate(getLastPublishDate());
		commerceCountryImpl.setChannelFilterEnabled(isChannelFilterEnabled());

		commerceCountryImpl.resetOriginalValues();

		return commerceCountryImpl;
	}

	@Override
	public int compareTo(CommerceCountry commerceCountry) {
		int value = 0;

		if (getPriority() < commerceCountry.getPriority()) {
			value = -1;
		}
		else if (getPriority() > commerceCountry.getPriority()) {
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

		if (!(object instanceof CommerceCountry)) {
			return false;
		}

		CommerceCountry commerceCountry = (CommerceCountry)object;

		long primaryKey = commerceCountry.getPrimaryKey();

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

		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_setModifiedDate = false;

		_originalBillingAllowed = _billingAllowed;

		_setOriginalBillingAllowed = false;

		_originalShippingAllowed = _shippingAllowed;

		_setOriginalShippingAllowed = false;

		_originalTwoLettersISOCode = _twoLettersISOCode;

		_originalNumericISOCode = _numericISOCode;

		_setOriginalNumericISOCode = false;

		_originalActive = _active;

		_setOriginalActive = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceCountry> toCacheModel() {
		CommerceCountryCacheModel commerceCountryCacheModel =
			new CommerceCountryCacheModel();

		commerceCountryCacheModel.uuid = getUuid();

		String uuid = commerceCountryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			commerceCountryCacheModel.uuid = null;
		}

		commerceCountryCacheModel.commerceCountryId = getCommerceCountryId();

		commerceCountryCacheModel.companyId = getCompanyId();

		commerceCountryCacheModel.userId = getUserId();

		commerceCountryCacheModel.userName = getUserName();

		String userName = commerceCountryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceCountryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceCountryCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceCountryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceCountryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commerceCountryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceCountryCacheModel.name = getName();

		String name = commerceCountryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			commerceCountryCacheModel.name = null;
		}

		commerceCountryCacheModel.billingAllowed = isBillingAllowed();

		commerceCountryCacheModel.shippingAllowed = isShippingAllowed();

		commerceCountryCacheModel.twoLettersISOCode = getTwoLettersISOCode();

		String twoLettersISOCode = commerceCountryCacheModel.twoLettersISOCode;

		if ((twoLettersISOCode != null) && (twoLettersISOCode.length() == 0)) {
			commerceCountryCacheModel.twoLettersISOCode = null;
		}

		commerceCountryCacheModel.threeLettersISOCode =
			getThreeLettersISOCode();

		String threeLettersISOCode =
			commerceCountryCacheModel.threeLettersISOCode;

		if ((threeLettersISOCode != null) &&
			(threeLettersISOCode.length() == 0)) {

			commerceCountryCacheModel.threeLettersISOCode = null;
		}

		commerceCountryCacheModel.numericISOCode = getNumericISOCode();

		commerceCountryCacheModel.subjectToVAT = isSubjectToVAT();

		commerceCountryCacheModel.priority = getPriority();

		commerceCountryCacheModel.active = isActive();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			commerceCountryCacheModel.lastPublishDate =
				lastPublishDate.getTime();
		}
		else {
			commerceCountryCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		commerceCountryCacheModel.channelFilterEnabled =
			isChannelFilterEnabled();

		return commerceCountryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceCountry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceCountry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceCountry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CommerceCountry)this));
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
		Map<String, Function<CommerceCountry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceCountry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceCountry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CommerceCountry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CommerceCountry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _commerceCountryId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _nameCurrentLanguageId;
	private boolean _billingAllowed;
	private boolean _originalBillingAllowed;
	private boolean _setOriginalBillingAllowed;
	private boolean _shippingAllowed;
	private boolean _originalShippingAllowed;
	private boolean _setOriginalShippingAllowed;
	private String _twoLettersISOCode;
	private String _originalTwoLettersISOCode;
	private String _threeLettersISOCode;
	private int _numericISOCode;
	private int _originalNumericISOCode;
	private boolean _setOriginalNumericISOCode;
	private boolean _subjectToVAT;
	private double _priority;
	private boolean _active;
	private boolean _originalActive;
	private boolean _setOriginalActive;
	private Date _lastPublishDate;
	private boolean _channelFilterEnabled;
	private long _columnBitmask;
	private CommerceCountry _escapedModel;

}