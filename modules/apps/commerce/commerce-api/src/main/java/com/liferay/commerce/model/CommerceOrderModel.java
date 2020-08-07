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

package com.liferay.commerce.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.math.BigDecimal;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CommerceOrder service. Represents a row in the &quot;CommerceOrder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.commerce.model.impl.CommerceOrderModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.commerce.model.impl.CommerceOrderImpl</code>.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceOrder
 * @generated
 */
@ProviderType
public interface CommerceOrderModel
	extends BaseModel<CommerceOrder>, GroupedModel, MVCCModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce order model instance should use the {@link CommerceOrder} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce order.
	 *
	 * @return the primary key of this commerce order
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce order.
	 *
	 * @param primaryKey the primary key of this commerce order
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this commerce order.
	 *
	 * @return the mvcc version of this commerce order
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this commerce order.
	 *
	 * @param mvccVersion the mvcc version of this commerce order
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this commerce order.
	 *
	 * @return the uuid of this commerce order
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this commerce order.
	 *
	 * @param uuid the uuid of this commerce order
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this commerce order.
	 *
	 * @return the external reference code of this commerce order
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this commerce order.
	 *
	 * @param externalReferenceCode the external reference code of this commerce order
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the commerce order ID of this commerce order.
	 *
	 * @return the commerce order ID of this commerce order
	 */
	public long getCommerceOrderId();

	/**
	 * Sets the commerce order ID of this commerce order.
	 *
	 * @param commerceOrderId the commerce order ID of this commerce order
	 */
	public void setCommerceOrderId(long commerceOrderId);

	/**
	 * Returns the group ID of this commerce order.
	 *
	 * @return the group ID of this commerce order
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this commerce order.
	 *
	 * @param groupId the group ID of this commerce order
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this commerce order.
	 *
	 * @return the company ID of this commerce order
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce order.
	 *
	 * @param companyId the company ID of this commerce order
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce order.
	 *
	 * @return the user ID of this commerce order
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce order.
	 *
	 * @param userId the user ID of this commerce order
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce order.
	 *
	 * @return the user uuid of this commerce order
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce order.
	 *
	 * @param userUuid the user uuid of this commerce order
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce order.
	 *
	 * @return the user name of this commerce order
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce order.
	 *
	 * @param userName the user name of this commerce order
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce order.
	 *
	 * @return the create date of this commerce order
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce order.
	 *
	 * @param createDate the create date of this commerce order
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce order.
	 *
	 * @return the modified date of this commerce order
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce order.
	 *
	 * @param modifiedDate the modified date of this commerce order
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the commerce account ID of this commerce order.
	 *
	 * @return the commerce account ID of this commerce order
	 */
	public long getCommerceAccountId();

	/**
	 * Sets the commerce account ID of this commerce order.
	 *
	 * @param commerceAccountId the commerce account ID of this commerce order
	 */
	public void setCommerceAccountId(long commerceAccountId);

	/**
	 * Returns the commerce currency ID of this commerce order.
	 *
	 * @return the commerce currency ID of this commerce order
	 */
	public long getCommerceCurrencyId();

	/**
	 * Sets the commerce currency ID of this commerce order.
	 *
	 * @param commerceCurrencyId the commerce currency ID of this commerce order
	 */
	public void setCommerceCurrencyId(long commerceCurrencyId);

	/**
	 * Returns the billing address ID of this commerce order.
	 *
	 * @return the billing address ID of this commerce order
	 */
	public long getBillingAddressId();

	/**
	 * Sets the billing address ID of this commerce order.
	 *
	 * @param billingAddressId the billing address ID of this commerce order
	 */
	public void setBillingAddressId(long billingAddressId);

	/**
	 * Returns the shipping address ID of this commerce order.
	 *
	 * @return the shipping address ID of this commerce order
	 */
	public long getShippingAddressId();

	/**
	 * Sets the shipping address ID of this commerce order.
	 *
	 * @param shippingAddressId the shipping address ID of this commerce order
	 */
	public void setShippingAddressId(long shippingAddressId);

	/**
	 * Returns the commerce payment method key of this commerce order.
	 *
	 * @return the commerce payment method key of this commerce order
	 */
	@AutoEscape
	public String getCommercePaymentMethodKey();

	/**
	 * Sets the commerce payment method key of this commerce order.
	 *
	 * @param commercePaymentMethodKey the commerce payment method key of this commerce order
	 */
	public void setCommercePaymentMethodKey(String commercePaymentMethodKey);

	/**
	 * Returns the transaction ID of this commerce order.
	 *
	 * @return the transaction ID of this commerce order
	 */
	@AutoEscape
	public String getTransactionId();

	/**
	 * Sets the transaction ID of this commerce order.
	 *
	 * @param transactionId the transaction ID of this commerce order
	 */
	public void setTransactionId(String transactionId);

	/**
	 * Returns the commerce shipping method ID of this commerce order.
	 *
	 * @return the commerce shipping method ID of this commerce order
	 */
	public long getCommerceShippingMethodId();

	/**
	 * Sets the commerce shipping method ID of this commerce order.
	 *
	 * @param commerceShippingMethodId the commerce shipping method ID of this commerce order
	 */
	public void setCommerceShippingMethodId(long commerceShippingMethodId);

	/**
	 * Returns the shipping option name of this commerce order.
	 *
	 * @return the shipping option name of this commerce order
	 */
	@AutoEscape
	public String getShippingOptionName();

	/**
	 * Sets the shipping option name of this commerce order.
	 *
	 * @param shippingOptionName the shipping option name of this commerce order
	 */
	public void setShippingOptionName(String shippingOptionName);

	/**
	 * Returns the purchase order number of this commerce order.
	 *
	 * @return the purchase order number of this commerce order
	 */
	@AutoEscape
	public String getPurchaseOrderNumber();

	/**
	 * Sets the purchase order number of this commerce order.
	 *
	 * @param purchaseOrderNumber the purchase order number of this commerce order
	 */
	public void setPurchaseOrderNumber(String purchaseOrderNumber);

	/**
	 * Returns the coupon code of this commerce order.
	 *
	 * @return the coupon code of this commerce order
	 */
	@AutoEscape
	public String getCouponCode();

	/**
	 * Sets the coupon code of this commerce order.
	 *
	 * @param couponCode the coupon code of this commerce order
	 */
	public void setCouponCode(String couponCode);

	/**
	 * Returns the last price update date of this commerce order.
	 *
	 * @return the last price update date of this commerce order
	 */
	public Date getLastPriceUpdateDate();

	/**
	 * Sets the last price update date of this commerce order.
	 *
	 * @param lastPriceUpdateDate the last price update date of this commerce order
	 */
	public void setLastPriceUpdateDate(Date lastPriceUpdateDate);

	/**
	 * Returns the subtotal of this commerce order.
	 *
	 * @return the subtotal of this commerce order
	 */
	public BigDecimal getSubtotal();

	/**
	 * Sets the subtotal of this commerce order.
	 *
	 * @param subtotal the subtotal of this commerce order
	 */
	public void setSubtotal(BigDecimal subtotal);

	/**
	 * Returns the subtotal discount amount of this commerce order.
	 *
	 * @return the subtotal discount amount of this commerce order
	 */
	public BigDecimal getSubtotalDiscountAmount();

	/**
	 * Sets the subtotal discount amount of this commerce order.
	 *
	 * @param subtotalDiscountAmount the subtotal discount amount of this commerce order
	 */
	public void setSubtotalDiscountAmount(BigDecimal subtotalDiscountAmount);

	/**
	 * Returns the subtotal discount percentage level1 of this commerce order.
	 *
	 * @return the subtotal discount percentage level1 of this commerce order
	 */
	public BigDecimal getSubtotalDiscountPercentageLevel1();

	/**
	 * Sets the subtotal discount percentage level1 of this commerce order.
	 *
	 * @param subtotalDiscountPercentageLevel1 the subtotal discount percentage level1 of this commerce order
	 */
	public void setSubtotalDiscountPercentageLevel1(
		BigDecimal subtotalDiscountPercentageLevel1);

	/**
	 * Returns the subtotal discount percentage level2 of this commerce order.
	 *
	 * @return the subtotal discount percentage level2 of this commerce order
	 */
	public BigDecimal getSubtotalDiscountPercentageLevel2();

	/**
	 * Sets the subtotal discount percentage level2 of this commerce order.
	 *
	 * @param subtotalDiscountPercentageLevel2 the subtotal discount percentage level2 of this commerce order
	 */
	public void setSubtotalDiscountPercentageLevel2(
		BigDecimal subtotalDiscountPercentageLevel2);

	/**
	 * Returns the subtotal discount percentage level3 of this commerce order.
	 *
	 * @return the subtotal discount percentage level3 of this commerce order
	 */
	public BigDecimal getSubtotalDiscountPercentageLevel3();

	/**
	 * Sets the subtotal discount percentage level3 of this commerce order.
	 *
	 * @param subtotalDiscountPercentageLevel3 the subtotal discount percentage level3 of this commerce order
	 */
	public void setSubtotalDiscountPercentageLevel3(
		BigDecimal subtotalDiscountPercentageLevel3);

	/**
	 * Returns the subtotal discount percentage level4 of this commerce order.
	 *
	 * @return the subtotal discount percentage level4 of this commerce order
	 */
	public BigDecimal getSubtotalDiscountPercentageLevel4();

	/**
	 * Sets the subtotal discount percentage level4 of this commerce order.
	 *
	 * @param subtotalDiscountPercentageLevel4 the subtotal discount percentage level4 of this commerce order
	 */
	public void setSubtotalDiscountPercentageLevel4(
		BigDecimal subtotalDiscountPercentageLevel4);

	/**
	 * Returns the shipping amount of this commerce order.
	 *
	 * @return the shipping amount of this commerce order
	 */
	public BigDecimal getShippingAmount();

	/**
	 * Sets the shipping amount of this commerce order.
	 *
	 * @param shippingAmount the shipping amount of this commerce order
	 */
	public void setShippingAmount(BigDecimal shippingAmount);

	/**
	 * Returns the shipping discount amount of this commerce order.
	 *
	 * @return the shipping discount amount of this commerce order
	 */
	public BigDecimal getShippingDiscountAmount();

	/**
	 * Sets the shipping discount amount of this commerce order.
	 *
	 * @param shippingDiscountAmount the shipping discount amount of this commerce order
	 */
	public void setShippingDiscountAmount(BigDecimal shippingDiscountAmount);

	/**
	 * Returns the shipping discount percentage level1 of this commerce order.
	 *
	 * @return the shipping discount percentage level1 of this commerce order
	 */
	public BigDecimal getShippingDiscountPercentageLevel1();

	/**
	 * Sets the shipping discount percentage level1 of this commerce order.
	 *
	 * @param shippingDiscountPercentageLevel1 the shipping discount percentage level1 of this commerce order
	 */
	public void setShippingDiscountPercentageLevel1(
		BigDecimal shippingDiscountPercentageLevel1);

	/**
	 * Returns the shipping discount percentage level2 of this commerce order.
	 *
	 * @return the shipping discount percentage level2 of this commerce order
	 */
	public BigDecimal getShippingDiscountPercentageLevel2();

	/**
	 * Sets the shipping discount percentage level2 of this commerce order.
	 *
	 * @param shippingDiscountPercentageLevel2 the shipping discount percentage level2 of this commerce order
	 */
	public void setShippingDiscountPercentageLevel2(
		BigDecimal shippingDiscountPercentageLevel2);

	/**
	 * Returns the shipping discount percentage level3 of this commerce order.
	 *
	 * @return the shipping discount percentage level3 of this commerce order
	 */
	public BigDecimal getShippingDiscountPercentageLevel3();

	/**
	 * Sets the shipping discount percentage level3 of this commerce order.
	 *
	 * @param shippingDiscountPercentageLevel3 the shipping discount percentage level3 of this commerce order
	 */
	public void setShippingDiscountPercentageLevel3(
		BigDecimal shippingDiscountPercentageLevel3);

	/**
	 * Returns the shipping discount percentage level4 of this commerce order.
	 *
	 * @return the shipping discount percentage level4 of this commerce order
	 */
	public BigDecimal getShippingDiscountPercentageLevel4();

	/**
	 * Sets the shipping discount percentage level4 of this commerce order.
	 *
	 * @param shippingDiscountPercentageLevel4 the shipping discount percentage level4 of this commerce order
	 */
	public void setShippingDiscountPercentageLevel4(
		BigDecimal shippingDiscountPercentageLevel4);

	/**
	 * Returns the tax amount of this commerce order.
	 *
	 * @return the tax amount of this commerce order
	 */
	public BigDecimal getTaxAmount();

	/**
	 * Sets the tax amount of this commerce order.
	 *
	 * @param taxAmount the tax amount of this commerce order
	 */
	public void setTaxAmount(BigDecimal taxAmount);

	/**
	 * Returns the total of this commerce order.
	 *
	 * @return the total of this commerce order
	 */
	public BigDecimal getTotal();

	/**
	 * Sets the total of this commerce order.
	 *
	 * @param total the total of this commerce order
	 */
	public void setTotal(BigDecimal total);

	/**
	 * Returns the total discount amount of this commerce order.
	 *
	 * @return the total discount amount of this commerce order
	 */
	public BigDecimal getTotalDiscountAmount();

	/**
	 * Sets the total discount amount of this commerce order.
	 *
	 * @param totalDiscountAmount the total discount amount of this commerce order
	 */
	public void setTotalDiscountAmount(BigDecimal totalDiscountAmount);

	/**
	 * Returns the total discount percentage level1 of this commerce order.
	 *
	 * @return the total discount percentage level1 of this commerce order
	 */
	public BigDecimal getTotalDiscountPercentageLevel1();

	/**
	 * Sets the total discount percentage level1 of this commerce order.
	 *
	 * @param totalDiscountPercentageLevel1 the total discount percentage level1 of this commerce order
	 */
	public void setTotalDiscountPercentageLevel1(
		BigDecimal totalDiscountPercentageLevel1);

	/**
	 * Returns the total discount percentage level2 of this commerce order.
	 *
	 * @return the total discount percentage level2 of this commerce order
	 */
	public BigDecimal getTotalDiscountPercentageLevel2();

	/**
	 * Sets the total discount percentage level2 of this commerce order.
	 *
	 * @param totalDiscountPercentageLevel2 the total discount percentage level2 of this commerce order
	 */
	public void setTotalDiscountPercentageLevel2(
		BigDecimal totalDiscountPercentageLevel2);

	/**
	 * Returns the total discount percentage level3 of this commerce order.
	 *
	 * @return the total discount percentage level3 of this commerce order
	 */
	public BigDecimal getTotalDiscountPercentageLevel3();

	/**
	 * Sets the total discount percentage level3 of this commerce order.
	 *
	 * @param totalDiscountPercentageLevel3 the total discount percentage level3 of this commerce order
	 */
	public void setTotalDiscountPercentageLevel3(
		BigDecimal totalDiscountPercentageLevel3);

	/**
	 * Returns the total discount percentage level4 of this commerce order.
	 *
	 * @return the total discount percentage level4 of this commerce order
	 */
	public BigDecimal getTotalDiscountPercentageLevel4();

	/**
	 * Sets the total discount percentage level4 of this commerce order.
	 *
	 * @param totalDiscountPercentageLevel4 the total discount percentage level4 of this commerce order
	 */
	public void setTotalDiscountPercentageLevel4(
		BigDecimal totalDiscountPercentageLevel4);

	/**
	 * Returns the subtotal with tax amount of this commerce order.
	 *
	 * @return the subtotal with tax amount of this commerce order
	 */
	public BigDecimal getSubtotalWithTaxAmount();

	/**
	 * Sets the subtotal with tax amount of this commerce order.
	 *
	 * @param subtotalWithTaxAmount the subtotal with tax amount of this commerce order
	 */
	public void setSubtotalWithTaxAmount(BigDecimal subtotalWithTaxAmount);

	/**
	 * Returns the subtotal discount with tax amount of this commerce order.
	 *
	 * @return the subtotal discount with tax amount of this commerce order
	 */
	public BigDecimal getSubtotalDiscountWithTaxAmount();

	/**
	 * Sets the subtotal discount with tax amount of this commerce order.
	 *
	 * @param subtotalDiscountWithTaxAmount the subtotal discount with tax amount of this commerce order
	 */
	public void setSubtotalDiscountWithTaxAmount(
		BigDecimal subtotalDiscountWithTaxAmount);

	/**
	 * Returns the subtotal discount percentage level1 with tax amount of this commerce order.
	 *
	 * @return the subtotal discount percentage level1 with tax amount of this commerce order
	 */
	public BigDecimal getSubtotalDiscountPercentageLevel1WithTaxAmount();

	/**
	 * Sets the subtotal discount percentage level1 with tax amount of this commerce order.
	 *
	 * @param subtotalDiscountPercentageLevel1WithTaxAmount the subtotal discount percentage level1 with tax amount of this commerce order
	 */
	public void setSubtotalDiscountPercentageLevel1WithTaxAmount(
		BigDecimal subtotalDiscountPercentageLevel1WithTaxAmount);

	/**
	 * Returns the subtotal discount percentage level2 with tax amount of this commerce order.
	 *
	 * @return the subtotal discount percentage level2 with tax amount of this commerce order
	 */
	public BigDecimal getSubtotalDiscountPercentageLevel2WithTaxAmount();

	/**
	 * Sets the subtotal discount percentage level2 with tax amount of this commerce order.
	 *
	 * @param subtotalDiscountPercentageLevel2WithTaxAmount the subtotal discount percentage level2 with tax amount of this commerce order
	 */
	public void setSubtotalDiscountPercentageLevel2WithTaxAmount(
		BigDecimal subtotalDiscountPercentageLevel2WithTaxAmount);

	/**
	 * Returns the subtotal discount percentage level3 with tax amount of this commerce order.
	 *
	 * @return the subtotal discount percentage level3 with tax amount of this commerce order
	 */
	public BigDecimal getSubtotalDiscountPercentageLevel3WithTaxAmount();

	/**
	 * Sets the subtotal discount percentage level3 with tax amount of this commerce order.
	 *
	 * @param subtotalDiscountPercentageLevel3WithTaxAmount the subtotal discount percentage level3 with tax amount of this commerce order
	 */
	public void setSubtotalDiscountPercentageLevel3WithTaxAmount(
		BigDecimal subtotalDiscountPercentageLevel3WithTaxAmount);

	/**
	 * Returns the subtotal discount percentage level4 with tax amount of this commerce order.
	 *
	 * @return the subtotal discount percentage level4 with tax amount of this commerce order
	 */
	public BigDecimal getSubtotalDiscountPercentageLevel4WithTaxAmount();

	/**
	 * Sets the subtotal discount percentage level4 with tax amount of this commerce order.
	 *
	 * @param subtotalDiscountPercentageLevel4WithTaxAmount the subtotal discount percentage level4 with tax amount of this commerce order
	 */
	public void setSubtotalDiscountPercentageLevel4WithTaxAmount(
		BigDecimal subtotalDiscountPercentageLevel4WithTaxAmount);

	/**
	 * Returns the shipping with tax amount of this commerce order.
	 *
	 * @return the shipping with tax amount of this commerce order
	 */
	public BigDecimal getShippingWithTaxAmount();

	/**
	 * Sets the shipping with tax amount of this commerce order.
	 *
	 * @param shippingWithTaxAmount the shipping with tax amount of this commerce order
	 */
	public void setShippingWithTaxAmount(BigDecimal shippingWithTaxAmount);

	/**
	 * Returns the shipping discount with tax amount of this commerce order.
	 *
	 * @return the shipping discount with tax amount of this commerce order
	 */
	public BigDecimal getShippingDiscountWithTaxAmount();

	/**
	 * Sets the shipping discount with tax amount of this commerce order.
	 *
	 * @param shippingDiscountWithTaxAmount the shipping discount with tax amount of this commerce order
	 */
	public void setShippingDiscountWithTaxAmount(
		BigDecimal shippingDiscountWithTaxAmount);

	/**
	 * Returns the shipping discount percentage level1 with tax amount of this commerce order.
	 *
	 * @return the shipping discount percentage level1 with tax amount of this commerce order
	 */
	public BigDecimal getShippingDiscountPercentageLevel1WithTaxAmount();

	/**
	 * Sets the shipping discount percentage level1 with tax amount of this commerce order.
	 *
	 * @param shippingDiscountPercentageLevel1WithTaxAmount the shipping discount percentage level1 with tax amount of this commerce order
	 */
	public void setShippingDiscountPercentageLevel1WithTaxAmount(
		BigDecimal shippingDiscountPercentageLevel1WithTaxAmount);

	/**
	 * Returns the shipping discount percentage level2 with tax amount of this commerce order.
	 *
	 * @return the shipping discount percentage level2 with tax amount of this commerce order
	 */
	public BigDecimal getShippingDiscountPercentageLevel2WithTaxAmount();

	/**
	 * Sets the shipping discount percentage level2 with tax amount of this commerce order.
	 *
	 * @param shippingDiscountPercentageLevel2WithTaxAmount the shipping discount percentage level2 with tax amount of this commerce order
	 */
	public void setShippingDiscountPercentageLevel2WithTaxAmount(
		BigDecimal shippingDiscountPercentageLevel2WithTaxAmount);

	/**
	 * Returns the shipping discount percentage level3 with tax amount of this commerce order.
	 *
	 * @return the shipping discount percentage level3 with tax amount of this commerce order
	 */
	public BigDecimal getShippingDiscountPercentageLevel3WithTaxAmount();

	/**
	 * Sets the shipping discount percentage level3 with tax amount of this commerce order.
	 *
	 * @param shippingDiscountPercentageLevel3WithTaxAmount the shipping discount percentage level3 with tax amount of this commerce order
	 */
	public void setShippingDiscountPercentageLevel3WithTaxAmount(
		BigDecimal shippingDiscountPercentageLevel3WithTaxAmount);

	/**
	 * Returns the shipping discount percentage level4 with tax amount of this commerce order.
	 *
	 * @return the shipping discount percentage level4 with tax amount of this commerce order
	 */
	public BigDecimal getShippingDiscountPercentageLevel4WithTaxAmount();

	/**
	 * Sets the shipping discount percentage level4 with tax amount of this commerce order.
	 *
	 * @param shippingDiscountPercentageLevel4WithTaxAmount the shipping discount percentage level4 with tax amount of this commerce order
	 */
	public void setShippingDiscountPercentageLevel4WithTaxAmount(
		BigDecimal shippingDiscountPercentageLevel4WithTaxAmount);

	/**
	 * Returns the total with tax amount of this commerce order.
	 *
	 * @return the total with tax amount of this commerce order
	 */
	public BigDecimal getTotalWithTaxAmount();

	/**
	 * Sets the total with tax amount of this commerce order.
	 *
	 * @param totalWithTaxAmount the total with tax amount of this commerce order
	 */
	public void setTotalWithTaxAmount(BigDecimal totalWithTaxAmount);

	/**
	 * Returns the total discount with tax amount of this commerce order.
	 *
	 * @return the total discount with tax amount of this commerce order
	 */
	public BigDecimal getTotalDiscountWithTaxAmount();

	/**
	 * Sets the total discount with tax amount of this commerce order.
	 *
	 * @param totalDiscountWithTaxAmount the total discount with tax amount of this commerce order
	 */
	public void setTotalDiscountWithTaxAmount(
		BigDecimal totalDiscountWithTaxAmount);

	/**
	 * Returns the total discount percentage level1 with tax amount of this commerce order.
	 *
	 * @return the total discount percentage level1 with tax amount of this commerce order
	 */
	public BigDecimal getTotalDiscountPercentageLevel1WithTaxAmount();

	/**
	 * Sets the total discount percentage level1 with tax amount of this commerce order.
	 *
	 * @param totalDiscountPercentageLevel1WithTaxAmount the total discount percentage level1 with tax amount of this commerce order
	 */
	public void setTotalDiscountPercentageLevel1WithTaxAmount(
		BigDecimal totalDiscountPercentageLevel1WithTaxAmount);

	/**
	 * Returns the total discount percentage level2 with tax amount of this commerce order.
	 *
	 * @return the total discount percentage level2 with tax amount of this commerce order
	 */
	public BigDecimal getTotalDiscountPercentageLevel2WithTaxAmount();

	/**
	 * Sets the total discount percentage level2 with tax amount of this commerce order.
	 *
	 * @param totalDiscountPercentageLevel2WithTaxAmount the total discount percentage level2 with tax amount of this commerce order
	 */
	public void setTotalDiscountPercentageLevel2WithTaxAmount(
		BigDecimal totalDiscountPercentageLevel2WithTaxAmount);

	/**
	 * Returns the total discount percentage level3 with tax amount of this commerce order.
	 *
	 * @return the total discount percentage level3 with tax amount of this commerce order
	 */
	public BigDecimal getTotalDiscountPercentageLevel3WithTaxAmount();

	/**
	 * Sets the total discount percentage level3 with tax amount of this commerce order.
	 *
	 * @param totalDiscountPercentageLevel3WithTaxAmount the total discount percentage level3 with tax amount of this commerce order
	 */
	public void setTotalDiscountPercentageLevel3WithTaxAmount(
		BigDecimal totalDiscountPercentageLevel3WithTaxAmount);

	/**
	 * Returns the total discount percentage level4 with tax amount of this commerce order.
	 *
	 * @return the total discount percentage level4 with tax amount of this commerce order
	 */
	public BigDecimal getTotalDiscountPercentageLevel4WithTaxAmount();

	/**
	 * Sets the total discount percentage level4 with tax amount of this commerce order.
	 *
	 * @param totalDiscountPercentageLevel4WithTaxAmount the total discount percentage level4 with tax amount of this commerce order
	 */
	public void setTotalDiscountPercentageLevel4WithTaxAmount(
		BigDecimal totalDiscountPercentageLevel4WithTaxAmount);

	/**
	 * Returns the advance status of this commerce order.
	 *
	 * @return the advance status of this commerce order
	 */
	@AutoEscape
	public String getAdvanceStatus();

	/**
	 * Sets the advance status of this commerce order.
	 *
	 * @param advanceStatus the advance status of this commerce order
	 */
	public void setAdvanceStatus(String advanceStatus);

	/**
	 * Returns the payment status of this commerce order.
	 *
	 * @return the payment status of this commerce order
	 */
	public int getPaymentStatus();

	/**
	 * Sets the payment status of this commerce order.
	 *
	 * @param paymentStatus the payment status of this commerce order
	 */
	public void setPaymentStatus(int paymentStatus);

	/**
	 * Returns the order date of this commerce order.
	 *
	 * @return the order date of this commerce order
	 */
	public Date getOrderDate();

	/**
	 * Sets the order date of this commerce order.
	 *
	 * @param orderDate the order date of this commerce order
	 */
	public void setOrderDate(Date orderDate);

	/**
	 * Returns the order status of this commerce order.
	 *
	 * @return the order status of this commerce order
	 */
	public int getOrderStatus();

	/**
	 * Sets the order status of this commerce order.
	 *
	 * @param orderStatus the order status of this commerce order
	 */
	public void setOrderStatus(int orderStatus);

	/**
	 * Returns the printed note of this commerce order.
	 *
	 * @return the printed note of this commerce order
	 */
	@AutoEscape
	public String getPrintedNote();

	/**
	 * Sets the printed note of this commerce order.
	 *
	 * @param printedNote the printed note of this commerce order
	 */
	public void setPrintedNote(String printedNote);

	/**
	 * Returns the requested delivery date of this commerce order.
	 *
	 * @return the requested delivery date of this commerce order
	 */
	public Date getRequestedDeliveryDate();

	/**
	 * Sets the requested delivery date of this commerce order.
	 *
	 * @param requestedDeliveryDate the requested delivery date of this commerce order
	 */
	public void setRequestedDeliveryDate(Date requestedDeliveryDate);

	/**
	 * Returns the manually adjusted of this commerce order.
	 *
	 * @return the manually adjusted of this commerce order
	 */
	public boolean getManuallyAdjusted();

	/**
	 * Returns <code>true</code> if this commerce order is manually adjusted.
	 *
	 * @return <code>true</code> if this commerce order is manually adjusted; <code>false</code> otherwise
	 */
	public boolean isManuallyAdjusted();

	/**
	 * Sets whether this commerce order is manually adjusted.
	 *
	 * @param manuallyAdjusted the manually adjusted of this commerce order
	 */
	public void setManuallyAdjusted(boolean manuallyAdjusted);

	/**
	 * Returns the status of this commerce order.
	 *
	 * @return the status of this commerce order
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this commerce order.
	 *
	 * @param status the status of this commerce order
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this commerce order.
	 *
	 * @return the status by user ID of this commerce order
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this commerce order.
	 *
	 * @param statusByUserId the status by user ID of this commerce order
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this commerce order.
	 *
	 * @return the status by user uuid of this commerce order
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this commerce order.
	 *
	 * @param statusByUserUuid the status by user uuid of this commerce order
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this commerce order.
	 *
	 * @return the status by user name of this commerce order
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this commerce order.
	 *
	 * @param statusByUserName the status by user name of this commerce order
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this commerce order.
	 *
	 * @return the status date of this commerce order
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this commerce order.
	 *
	 * @param statusDate the status date of this commerce order
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this commerce order is approved.
	 *
	 * @return <code>true</code> if this commerce order is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this commerce order is denied.
	 *
	 * @return <code>true</code> if this commerce order is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this commerce order is a draft.
	 *
	 * @return <code>true</code> if this commerce order is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this commerce order is expired.
	 *
	 * @return <code>true</code> if this commerce order is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this commerce order is inactive.
	 *
	 * @return <code>true</code> if this commerce order is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this commerce order is incomplete.
	 *
	 * @return <code>true</code> if this commerce order is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this commerce order is pending.
	 *
	 * @return <code>true</code> if this commerce order is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this commerce order is scheduled.
	 *
	 * @return <code>true</code> if this commerce order is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

}