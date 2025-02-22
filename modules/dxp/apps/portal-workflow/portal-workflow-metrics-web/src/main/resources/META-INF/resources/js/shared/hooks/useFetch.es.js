/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import {fetch} from 'frontend-js-web';
import {useCallback, useState} from 'react';

import {adminBaseURL, headers, metricsBaseURL} from '../rest/fetch.es';

const useFetch = ({
	admin = false,
	callback = (data) => data,
	params = {},
	plainText = false,
	url,
}) => {
	const [data, setData] = useState();

	let fetchURL = admin ? `${adminBaseURL}${url}` : `${metricsBaseURL}${url}`;

	fetchURL = new URL(fetchURL, Liferay.ThemeDisplay.getPortalURL());

	Object.entries(params).map(([key, value]) => {
		if (value) {
			fetchURL.searchParams.append(key, value);
		}
	});

	const fetchData = useCallback(
		() =>
			fetch(fetchURL, {
				headers,
				method: 'GET',
			})
				.then((response) => {
					if (plainText) {
						return response.text();
					}
					else {
						return response.json();
					}
				})
				.then((data) => {
					setData(data);

					return callback(data);
				}),
		[callback, fetchURL, plainText]
	);

	return {
		data,
		fetchData,
	};
};

export {useFetch};
