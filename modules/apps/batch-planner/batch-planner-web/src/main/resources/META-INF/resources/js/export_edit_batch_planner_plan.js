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

import {fetch} from 'frontend-js-web';

const HEADERS = new Headers({
	'content-type': 'application/json',
	'x-csrf-token': window.Liferay.authToken,
});

export default function ({namespace}) {
	const headlessEnpointSelect = document.querySelector(
		`#${namespace}headlessEndpoint`
	);
	const internalClassNameSelect = document.querySelector(
		`#${namespace}internalClassName`
	);

	headlessEnpointSelect.addEventListener('change', (event) => {
		event.target.disabled = true;

		const headlessEnpoint = event.target.value;

		fetch(headlessEnpoint, {
			credentials: 'include',
			headers: HEADERS,
		})
			.then((response) => {
				if (!response.ok) {
					throw new Error(
						`Failed to fetch: '${headlessEnpointSelect}'`
					);
				}

				return response.json();
			})
			.then(({components}) => {
				internalClassNameSelect.innerHTML = '';

				const keys = Object.keys(components.schemas).sort();

				keys.forEach((key, index) => {
					const properties = components.schemas[key].properties;

					if (!properties || !properties['x-class-name']) {
						return;
					}

					const optionElement = document.createElement('option');

					const path = properties['x-class-name'].default;

					const value = path.substr(path.lastIndexOf('.') + 1);

					optionElement.value = value;
					optionElement.innerHTML = key;

					internalClassNameSelect.appendChild(optionElement);

					if (!index) {
						const schemaEntry = components.schemas[value];

						Liferay.fire('schema-selected', {
							schema: schemaEntry.properties,
						});
					}
				});

				internalClassNameSelect.disabled = false;
			})
			.catch((response) => {
				alert('Failed to fetch ' + response);
			})
			.then(() => {
				event.target.disabled = false;
			});
	});

	internalClassNameSelect.addEventListener(
		'change',
		handleClassNameSelectChange
	);

	function handleClassNameSelectChange() {
		const headlessEnpoint = headlessEnpointSelect.value;
		const internalClassName = internalClassNameSelect.value;

		fetch(headlessEnpoint, {
			credentials: 'include',
			headers: HEADERS,
		})
			.then((response) => {
				if (!response.ok) {
					throw new Error(`Failed to fetch: '${headlessEnpoint}'`);
				}

				return response.json();
			})
			.then(({components}) => {
				const schemaEntry = components.schemas[internalClassName];

				Liferay.fire('schema-selected', {
					schema: schemaEntry.properties,
				});
			})
			.catch((response) => {
				alert(`Failed to fetch ${response}`);
			});
	}
}
