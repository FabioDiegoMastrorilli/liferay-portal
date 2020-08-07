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

package com.liferay.commerce.discount.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CommerceDiscountUsageEntry service. Represents a row in the &quot;CommerceDiscountUsageEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.discount.model.impl.CommerceDiscountUsageEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.discount.model.impl.CommerceDiscountUsageEntryImpl</code>.
 * </p>
 *
 * @author Marco Leo
 * @see CommerceDiscountUsageEntry
 * @generated
 */
@ProviderType
public interface CommerceDiscountUsageEntryModel
	extends AuditedModel, BaseModel<CommerceDiscountUsageEntry>, MVCCModel,
			ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce discount usage entry model instance should use the {@link CommerceDiscountUsageEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce discount usage entry.
	 *
	 * @return the primary key of this commerce discount usage entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce discount usage entry.
	 *
	 * @param primaryKey the primary key of this commerce discount usage entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this commerce discount usage entry.
	 *
	 * @return the mvcc version of this commerce discount usage entry
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this commerce discount usage entry.
	 *
	 * @param mvccVersion the mvcc version of this commerce discount usage entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the commerce discount usage entry ID of this commerce discount usage entry.
	 *
	 * @return the commerce discount usage entry ID of this commerce discount usage entry
	 */
	public long getCommerceDiscountUsageEntryId();

	/**
	 * Sets the commerce discount usage entry ID of this commerce discount usage entry.
	 *
	 * @param commerceDiscountUsageEntryId the commerce discount usage entry ID of this commerce discount usage entry
	 */
	public void setCommerceDiscountUsageEntryId(
		long commerceDiscountUsageEntryId);

	/**
	 * Returns the company ID of this commerce discount usage entry.
	 *
	 * @return the company ID of this commerce discount usage entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce discount usage entry.
	 *
	 * @param companyId the company ID of this commerce discount usage entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce discount usage entry.
	 *
	 * @return the user ID of this commerce discount usage entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce discount usage entry.
	 *
	 * @param userId the user ID of this commerce discount usage entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce discount usage entry.
	 *
	 * @return the user uuid of this commerce discount usage entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce discount usage entry.
	 *
	 * @param userUuid the user uuid of this commerce discount usage entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce discount usage entry.
	 *
	 * @return the user name of this commerce discount usage entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce discount usage entry.
	 *
	 * @param userName the user name of this commerce discount usage entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce discount usage entry.
	 *
	 * @return the create date of this commerce discount usage entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce discount usage entry.
	 *
	 * @param createDate the create date of this commerce discount usage entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce discount usage entry.
	 *
	 * @return the modified date of this commerce discount usage entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce discount usage entry.
	 *
	 * @param modifiedDate the modified date of this commerce discount usage entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the commerce account ID of this commerce discount usage entry.
	 *
	 * @return the commerce account ID of this commerce discount usage entry
	 */
	public long getCommerceAccountId();

	/**
	 * Sets the commerce account ID of this commerce discount usage entry.
	 *
	 * @param commerceAccountId the commerce account ID of this commerce discount usage entry
	 */
	public void setCommerceAccountId(long commerceAccountId);

	/**
	 * Returns the commerce order ID of this commerce discount usage entry.
	 *
	 * @return the commerce order ID of this commerce discount usage entry
	 */
	public long getCommerceOrderId();

	/**
	 * Sets the commerce order ID of this commerce discount usage entry.
	 *
	 * @param commerceOrderId the commerce order ID of this commerce discount usage entry
	 */
	public void setCommerceOrderId(long commerceOrderId);

	/**
	 * Returns the commerce discount ID of this commerce discount usage entry.
	 *
	 * @return the commerce discount ID of this commerce discount usage entry
	 */
	public long getCommerceDiscountId();

	/**
	 * Sets the commerce discount ID of this commerce discount usage entry.
	 *
	 * @param commerceDiscountId the commerce discount ID of this commerce discount usage entry
	 */
	public void setCommerceDiscountId(long commerceDiscountId);

}