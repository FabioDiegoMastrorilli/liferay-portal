/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.commerce.machine.learning.forecast.alert.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CommerceMLForecastAlertEntry service. Represents a row in the &quot;CommerceMLForecastAlertEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.machine.learning.forecast.alert.model.impl.CommerceMLForecastAlertEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.machine.learning.forecast.alert.model.impl.CommerceMLForecastAlertEntryImpl</code>.
 * </p>
 *
 * @author Riccardo Ferrari
 * @see CommerceMLForecastAlertEntry
 * @generated
 */
@ProviderType
public interface CommerceMLForecastAlertEntryModel
	extends BaseModel<CommerceMLForecastAlertEntry>, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce ml forecast alert entry model instance should use the {@link CommerceMLForecastAlertEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce ml forecast alert entry.
	 *
	 * @return the primary key of this commerce ml forecast alert entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce ml forecast alert entry.
	 *
	 * @param primaryKey the primary key of this commerce ml forecast alert entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this commerce ml forecast alert entry.
	 *
	 * @return the uuid of this commerce ml forecast alert entry
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this commerce ml forecast alert entry.
	 *
	 * @param uuid the uuid of this commerce ml forecast alert entry
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the commerce ml forecast alert entry ID of this commerce ml forecast alert entry.
	 *
	 * @return the commerce ml forecast alert entry ID of this commerce ml forecast alert entry
	 */
	public long getCommerceMLForecastAlertEntryId();

	/**
	 * Sets the commerce ml forecast alert entry ID of this commerce ml forecast alert entry.
	 *
	 * @param commerceMLForecastAlertEntryId the commerce ml forecast alert entry ID of this commerce ml forecast alert entry
	 */
	public void setCommerceMLForecastAlertEntryId(
		long commerceMLForecastAlertEntryId);

	/**
	 * Returns the company ID of this commerce ml forecast alert entry.
	 *
	 * @return the company ID of this commerce ml forecast alert entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce ml forecast alert entry.
	 *
	 * @param companyId the company ID of this commerce ml forecast alert entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce ml forecast alert entry.
	 *
	 * @return the user ID of this commerce ml forecast alert entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce ml forecast alert entry.
	 *
	 * @param userId the user ID of this commerce ml forecast alert entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce ml forecast alert entry.
	 *
	 * @return the user uuid of this commerce ml forecast alert entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce ml forecast alert entry.
	 *
	 * @param userUuid the user uuid of this commerce ml forecast alert entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce ml forecast alert entry.
	 *
	 * @return the user name of this commerce ml forecast alert entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce ml forecast alert entry.
	 *
	 * @param userName the user name of this commerce ml forecast alert entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce ml forecast alert entry.
	 *
	 * @return the create date of this commerce ml forecast alert entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce ml forecast alert entry.
	 *
	 * @param createDate the create date of this commerce ml forecast alert entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce ml forecast alert entry.
	 *
	 * @return the modified date of this commerce ml forecast alert entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce ml forecast alert entry.
	 *
	 * @param modifiedDate the modified date of this commerce ml forecast alert entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the commerce account ID of this commerce ml forecast alert entry.
	 *
	 * @return the commerce account ID of this commerce ml forecast alert entry
	 */
	public long getCommerceAccountId();

	/**
	 * Sets the commerce account ID of this commerce ml forecast alert entry.
	 *
	 * @param commerceAccountId the commerce account ID of this commerce ml forecast alert entry
	 */
	public void setCommerceAccountId(long commerceAccountId);

	/**
	 * Returns the actual of this commerce ml forecast alert entry.
	 *
	 * @return the actual of this commerce ml forecast alert entry
	 */
	public double getActual();

	/**
	 * Sets the actual of this commerce ml forecast alert entry.
	 *
	 * @param actual the actual of this commerce ml forecast alert entry
	 */
	public void setActual(double actual);

	/**
	 * Returns the forecast of this commerce ml forecast alert entry.
	 *
	 * @return the forecast of this commerce ml forecast alert entry
	 */
	public double getForecast();

	/**
	 * Sets the forecast of this commerce ml forecast alert entry.
	 *
	 * @param forecast the forecast of this commerce ml forecast alert entry
	 */
	public void setForecast(double forecast);

	/**
	 * Returns the timestamp of this commerce ml forecast alert entry.
	 *
	 * @return the timestamp of this commerce ml forecast alert entry
	 */
	public Date getTimestamp();

	/**
	 * Sets the timestamp of this commerce ml forecast alert entry.
	 *
	 * @param timestamp the timestamp of this commerce ml forecast alert entry
	 */
	public void setTimestamp(Date timestamp);

	/**
	 * Returns the relative change of this commerce ml forecast alert entry.
	 *
	 * @return the relative change of this commerce ml forecast alert entry
	 */
	public double getRelativeChange();

	/**
	 * Sets the relative change of this commerce ml forecast alert entry.
	 *
	 * @param relativeChange the relative change of this commerce ml forecast alert entry
	 */
	public void setRelativeChange(double relativeChange);

	/**
	 * Returns the status of this commerce ml forecast alert entry.
	 *
	 * @return the status of this commerce ml forecast alert entry
	 */
	public int getStatus();

	/**
	 * Sets the status of this commerce ml forecast alert entry.
	 *
	 * @param status the status of this commerce ml forecast alert entry
	 */
	public void setStatus(int status);

}