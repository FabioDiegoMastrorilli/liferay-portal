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

package com.liferay.commerce.shipping.web.internal.model;

/**
 * @author Andrea Sbarra
 */
public class ShippingOption {

	public ShippingOption(
		String channelName, String shippingMethodName,
		String shippingOptionName) {

		_channelName = channelName;
		_shippingMethodName = shippingMethodName;
		_shippingOptionName = shippingOptionName;
	}

	public String getChannelName() {
		return _channelName;
	}

	public String getShippingMethodName() {
		return _shippingMethodName;
	}

	public String getShippingOptionName() {
		return _shippingOptionName;
	}

	private final String _channelName;
	private final String _shippingMethodName;
	private final String _shippingOptionName;

}