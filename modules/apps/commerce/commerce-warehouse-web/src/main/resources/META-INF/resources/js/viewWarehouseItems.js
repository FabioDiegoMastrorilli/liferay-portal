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

export default function ({ADD, CMD, UPDATE, namespace}) {
	function handleSaveBtnClick(e) {
		const {
			commerceInventoryWarehouseId,
			commerceInventoryWarehouseItemId,
			index,
			mvccVersion,
		} = e.target.closest('tr').dataset;

		const form = document.getElementById(`${namespace}fm`);

		form[`${namespace}${CMD}`].value =
			commerceInventoryWarehouseItemId > 0 ? UPDATE : ADD;

		form[
			`${namespace}commerceInventoryWarehouseId`
		].value = commerceInventoryWarehouseId;
		form[
			`${namespace}commerceInventoryWarehouseItemId`
		].value = commerceInventoryWarehouseItemId;

		const quantityInputId = `#${namespace}commerceInventoryWarehouseItemQuantity${index}`;

		const quantityInput = document.querySelector(quantityInputId);

		form[`${namespace}quantity`].value = quantityInput.value;
		form[`${namespace}mvccVersion`].value = mvccVersion;

		submitForm(form);
	}

	document.querySelectorAll('.warehouse-save-btn').forEach((saveBtn) => {
		saveBtn.addEventListener('click', handleSaveBtnClick);
	});

	const quantityPrefix = `${namespace}commerceInventoryWarehouseItemQuantity`;
	const enterKeyCode = 13;
	const quantityInputElements = document.querySelectorAll(
		`input[id^=${quantityPrefix}]`
	);

	quantityInputElements.forEach((quantityInputElement) => {
		quantityInputElement.addEventListener('keypress', (event) => {
			if (event.keyCode == enterKeyCode) {
				event.preventDefault();

				quantityInputElement
					.closest('tr')
					.querySelector('.warehouse-save-btn')
					.click();
			}
		});
	});
}
