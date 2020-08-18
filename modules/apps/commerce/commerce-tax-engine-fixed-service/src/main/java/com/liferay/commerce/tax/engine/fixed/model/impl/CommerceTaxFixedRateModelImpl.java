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

package com.liferay.commerce.tax.engine.fixed.model.impl;

import com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRate;
import com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateModel;
import com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRateSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
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
 * The base model implementation for the CommerceTaxFixedRate service. Represents a row in the &quot;CommerceTaxFixedRate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommerceTaxFixedRateModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceTaxFixedRateImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceTaxFixedRateImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceTaxFixedRateModelImpl
	extends BaseModelImpl<CommerceTaxFixedRate>
	implements CommerceTaxFixedRateModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce tax fixed rate model instance should use the <code>CommerceTaxFixedRate</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceTaxFixedRate";

	public static final Object[][] TABLE_COLUMNS = {
		{"commerceTaxFixedRateId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"CPTaxCategoryId", Types.BIGINT},
		{"commerceTaxMethodId", Types.BIGINT}, {"rate", Types.DOUBLE}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceTaxFixedRateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("CPTaxCategoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceTaxMethodId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rate", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceTaxFixedRate (commerceTaxFixedRateId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,CPTaxCategoryId LONG,commerceTaxMethodId LONG,rate DOUBLE)";

	public static final String TABLE_SQL_DROP =
		"drop table CommerceTaxFixedRate";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceTaxFixedRate.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceTaxFixedRate.createDate DESC";

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

	public static final long CPTAXCATEGORYID_COLUMN_BITMASK = 1L;

	public static final long COMMERCETAXMETHODID_COLUMN_BITMASK = 2L;

	public static final long CREATEDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CommerceTaxFixedRate toModel(
		CommerceTaxFixedRateSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceTaxFixedRate model = new CommerceTaxFixedRateImpl();

		model.setCommerceTaxFixedRateId(soapModel.getCommerceTaxFixedRateId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCPTaxCategoryId(soapModel.getCPTaxCategoryId());
		model.setCommerceTaxMethodId(soapModel.getCommerceTaxMethodId());
		model.setRate(soapModel.getRate());

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
	public static List<CommerceTaxFixedRate> toModels(
		CommerceTaxFixedRateSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceTaxFixedRate> models = new ArrayList<CommerceTaxFixedRate>(
			soapModels.length);

		for (CommerceTaxFixedRateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.tax.engine.fixed.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.tax.engine.fixed.model.CommerceTaxFixedRate"));

	public CommerceTaxFixedRateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceTaxFixedRateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceTaxFixedRateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceTaxFixedRateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceTaxFixedRate.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceTaxFixedRate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceTaxFixedRate, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceTaxFixedRate, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceTaxFixedRate, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommerceTaxFixedRate)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceTaxFixedRate, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceTaxFixedRate, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceTaxFixedRate)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceTaxFixedRate, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceTaxFixedRate, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceTaxFixedRate>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceTaxFixedRate.class.getClassLoader(),
			CommerceTaxFixedRate.class, ModelWrapper.class);

		try {
			Constructor<CommerceTaxFixedRate> constructor =
				(Constructor<CommerceTaxFixedRate>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CommerceTaxFixedRate, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CommerceTaxFixedRate, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceTaxFixedRate, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommerceTaxFixedRate, Object>>();
		Map<String, BiConsumer<CommerceTaxFixedRate, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceTaxFixedRate, ?>>();

		attributeGetterFunctions.put(
			"commerceTaxFixedRateId",
			CommerceTaxFixedRate::getCommerceTaxFixedRateId);
		attributeSetterBiConsumers.put(
			"commerceTaxFixedRateId",
			(BiConsumer<CommerceTaxFixedRate, Long>)
				CommerceTaxFixedRate::setCommerceTaxFixedRateId);
		attributeGetterFunctions.put(
			"groupId", CommerceTaxFixedRate::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CommerceTaxFixedRate, Long>)
				CommerceTaxFixedRate::setGroupId);
		attributeGetterFunctions.put(
			"companyId", CommerceTaxFixedRate::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommerceTaxFixedRate, Long>)
				CommerceTaxFixedRate::setCompanyId);
		attributeGetterFunctions.put("userId", CommerceTaxFixedRate::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommerceTaxFixedRate, Long>)
				CommerceTaxFixedRate::setUserId);
		attributeGetterFunctions.put(
			"userName", CommerceTaxFixedRate::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommerceTaxFixedRate, String>)
				CommerceTaxFixedRate::setUserName);
		attributeGetterFunctions.put(
			"createDate", CommerceTaxFixedRate::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommerceTaxFixedRate, Date>)
				CommerceTaxFixedRate::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CommerceTaxFixedRate::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommerceTaxFixedRate, Date>)
				CommerceTaxFixedRate::setModifiedDate);
		attributeGetterFunctions.put(
			"CPTaxCategoryId", CommerceTaxFixedRate::getCPTaxCategoryId);
		attributeSetterBiConsumers.put(
			"CPTaxCategoryId",
			(BiConsumer<CommerceTaxFixedRate, Long>)
				CommerceTaxFixedRate::setCPTaxCategoryId);
		attributeGetterFunctions.put(
			"commerceTaxMethodId",
			CommerceTaxFixedRate::getCommerceTaxMethodId);
		attributeSetterBiConsumers.put(
			"commerceTaxMethodId",
			(BiConsumer<CommerceTaxFixedRate, Long>)
				CommerceTaxFixedRate::setCommerceTaxMethodId);
		attributeGetterFunctions.put("rate", CommerceTaxFixedRate::getRate);
		attributeSetterBiConsumers.put(
			"rate",
			(BiConsumer<CommerceTaxFixedRate, Double>)
				CommerceTaxFixedRate::setRate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCommerceTaxFixedRateId() {
		return _commerceTaxFixedRateId;
	}

	@Override
	public void setCommerceTaxFixedRateId(long commerceTaxFixedRateId) {
		_commerceTaxFixedRateId = commerceTaxFixedRateId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	@JSON
	@Override
	public long getCPTaxCategoryId() {
		return _CPTaxCategoryId;
	}

	@Override
	public void setCPTaxCategoryId(long CPTaxCategoryId) {
		_columnBitmask |= CPTAXCATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCPTaxCategoryId) {
			_setOriginalCPTaxCategoryId = true;

			_originalCPTaxCategoryId = _CPTaxCategoryId;
		}

		_CPTaxCategoryId = CPTaxCategoryId;
	}

	public long getOriginalCPTaxCategoryId() {
		return _originalCPTaxCategoryId;
	}

	@JSON
	@Override
	public long getCommerceTaxMethodId() {
		return _commerceTaxMethodId;
	}

	@Override
	public void setCommerceTaxMethodId(long commerceTaxMethodId) {
		_columnBitmask |= COMMERCETAXMETHODID_COLUMN_BITMASK;

		if (!_setOriginalCommerceTaxMethodId) {
			_setOriginalCommerceTaxMethodId = true;

			_originalCommerceTaxMethodId = _commerceTaxMethodId;
		}

		_commerceTaxMethodId = commerceTaxMethodId;
	}

	public long getOriginalCommerceTaxMethodId() {
		return _originalCommerceTaxMethodId;
	}

	@JSON
	@Override
	public double getRate() {
		return _rate;
	}

	@Override
	public void setRate(double rate) {
		_rate = rate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceTaxFixedRate.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceTaxFixedRate toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceTaxFixedRate>
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
		CommerceTaxFixedRateImpl commerceTaxFixedRateImpl =
			new CommerceTaxFixedRateImpl();

		commerceTaxFixedRateImpl.setCommerceTaxFixedRateId(
			getCommerceTaxFixedRateId());
		commerceTaxFixedRateImpl.setGroupId(getGroupId());
		commerceTaxFixedRateImpl.setCompanyId(getCompanyId());
		commerceTaxFixedRateImpl.setUserId(getUserId());
		commerceTaxFixedRateImpl.setUserName(getUserName());
		commerceTaxFixedRateImpl.setCreateDate(getCreateDate());
		commerceTaxFixedRateImpl.setModifiedDate(getModifiedDate());
		commerceTaxFixedRateImpl.setCPTaxCategoryId(getCPTaxCategoryId());
		commerceTaxFixedRateImpl.setCommerceTaxMethodId(
			getCommerceTaxMethodId());
		commerceTaxFixedRateImpl.setRate(getRate());

		commerceTaxFixedRateImpl.resetOriginalValues();

		return commerceTaxFixedRateImpl;
	}

	@Override
	public int compareTo(CommerceTaxFixedRate commerceTaxFixedRate) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), commerceTaxFixedRate.getCreateDate());

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

		if (!(object instanceof CommerceTaxFixedRate)) {
			return false;
		}

		CommerceTaxFixedRate commerceTaxFixedRate =
			(CommerceTaxFixedRate)object;

		long primaryKey = commerceTaxFixedRate.getPrimaryKey();

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
		_setModifiedDate = false;
		_originalCPTaxCategoryId = _CPTaxCategoryId;

		_setOriginalCPTaxCategoryId = false;

		_originalCommerceTaxMethodId = _commerceTaxMethodId;

		_setOriginalCommerceTaxMethodId = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceTaxFixedRate> toCacheModel() {
		CommerceTaxFixedRateCacheModel commerceTaxFixedRateCacheModel =
			new CommerceTaxFixedRateCacheModel();

		commerceTaxFixedRateCacheModel.commerceTaxFixedRateId =
			getCommerceTaxFixedRateId();

		commerceTaxFixedRateCacheModel.groupId = getGroupId();

		commerceTaxFixedRateCacheModel.companyId = getCompanyId();

		commerceTaxFixedRateCacheModel.userId = getUserId();

		commerceTaxFixedRateCacheModel.userName = getUserName();

		String userName = commerceTaxFixedRateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceTaxFixedRateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceTaxFixedRateCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceTaxFixedRateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceTaxFixedRateCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceTaxFixedRateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceTaxFixedRateCacheModel.CPTaxCategoryId = getCPTaxCategoryId();

		commerceTaxFixedRateCacheModel.commerceTaxMethodId =
			getCommerceTaxMethodId();

		commerceTaxFixedRateCacheModel.rate = getRate();

		return commerceTaxFixedRateCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceTaxFixedRate, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceTaxFixedRate, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceTaxFixedRate, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CommerceTaxFixedRate)this));
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
		Map<String, Function<CommerceTaxFixedRate, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceTaxFixedRate, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceTaxFixedRate, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CommerceTaxFixedRate)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CommerceTaxFixedRate>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _commerceTaxFixedRateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _CPTaxCategoryId;
	private long _originalCPTaxCategoryId;
	private boolean _setOriginalCPTaxCategoryId;
	private long _commerceTaxMethodId;
	private long _originalCommerceTaxMethodId;
	private boolean _setOriginalCommerceTaxMethodId;
	private double _rate;
	private long _columnBitmask;
	private CommerceTaxFixedRate _escapedModel;

}