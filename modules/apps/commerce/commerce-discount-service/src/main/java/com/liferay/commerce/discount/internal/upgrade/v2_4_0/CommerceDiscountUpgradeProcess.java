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

package com.liferay.commerce.discount.internal.upgrade.v2_4_0;

import com.liferay.commerce.discount.internal.upgrade.base.BaseCommerceDiscountUpgradeProcess;
import com.liferay.commerce.discount.internal.upgrade.v2_4_0.util.CommerceDiscountTable;

/**
 * @author Riccardo Alberti
 */
public class CommerceDiscountUpgradeProcess
	extends BaseCommerceDiscountUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		addColumn(
			CommerceDiscountTable.class, CommerceDiscountTable.TABLE_NAME,
			"limitationTimesPerAccount", "INTEGER");

		runSQL("update CommerceDiscount set limitationTimesPerAccount = 0");
	}

}