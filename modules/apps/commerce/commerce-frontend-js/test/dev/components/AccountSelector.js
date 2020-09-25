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

import launcher from '../../../src/main/resources/META-INF/resources/components/account_selector/entry';

import '../../../src/main/resources/META-INF/resources/styles/main.scss';

import '../../../../../frontend-taglib/frontend-taglib-clay/src/main/resources/META-INF/resources/data_set_display/styles/main.scss';

launcher('account_selector', 'account-selector-id', {
	accountsAPI: '/account-selector/',
	selectedAccount: {
		id: 23763872,
		name: "Giovanni",
		thumbnail: "http://lorempixel.com/75/75/abstract/",
	},
	setCurrentAccountAPIEndpoint: '/account-selector/setCurrentAccounts',
	selectedOrder: {
		id: 32402,
		status: {
			code: 3242,
			label: "completed",
			label_i18n: "Completed",
		},
	},
	spritemap: './assets/icons.svg',
	viewAllAccountsLink: 'okli',
	viewAllOrdersLink: '',
});
