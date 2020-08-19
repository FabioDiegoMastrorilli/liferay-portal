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

package com.liferay.commerce.product.definitions.web.internal.frontend;

import com.liferay.commerce.frontend.clay.data.set.ClayDataSetFilter;
import com.liferay.commerce.frontend.clay.data.set.ClayRadioDataSetFilter;
import com.liferay.commerce.frontend.clay.data.set.ClayRadioDataSetFilterItem;
import com.liferay.commerce.product.type.CPType;
import com.liferay.commerce.product.type.CPTypeServicesTracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marco Leo
 */
@Component(
	immediate = true,
	property = "clay.data.set.display.name=" + CommerceProductDataSetConstants.COMMERCE_DATA_SET_KEY_PRODUCT_DEFINITIONS,
	service = ClayDataSetFilter.class
)
public class ProductTypeClayTableDataSetFilter extends ClayRadioDataSetFilter {

	@Override
	public List<ClayRadioDataSetFilterItem> getClayRadioDataSetFilterItems(
		Locale locale) {

		List<ClayRadioDataSetFilterItem> clayRadioDataSetFilterItems =
			new ArrayList<>();

		for (CPType cpType : _cpTypeServicesTracker.getCPTypes()) {
			clayRadioDataSetFilterItems.add(
				new ClayRadioDataSetFilterItem(
					cpType.getLabel(locale), cpType.getName()));
		}

		return clayRadioDataSetFilterItems;
	}

	@Override
	public String getId() {
		return "productType";
	}

	@Override
	public String getLabel() {
		return "product-type";
	}

	@Reference
	private CPTypeServicesTracker _cpTypeServicesTracker;

}