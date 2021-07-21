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

import classnames from 'classnames';
import PropTypes from 'prop-types';
import React, {useEffect, useState} from 'react';

import {CP_INSTANCE_CHANGED} from '../../utilities/eventsDefinitions';
import QuantitySelector from '../quantity_selector/QuantitySelector';
import AddToCartButton from './AddToCartButton';

function AddToCart(props) {
	const {cpInstance, settings} = props;

	const [quantityDefinitions, updateQuantityDefinitions] = useState(
		settings.quantityDefinitions
	);
	const [currentQuantity, setCurrentQuantity] = useState();
	const [disabled, setDisabled] = useState(
		settings.disabled || !cpInstance.accountId
	);
	const onCPInstanceChange = ({cpInstance}) => {
		const isPurchasable =
			cpInstance.purchasable &&
			(cpInstance.backOrderAllowed || cpInstance.stockQuantity > 0);

		setDisabled(!isPurchasable);
		debugger;
		updateQuantityDefinitions(true)
	};

	useEffect(() => {
		if (settings.namespace) {
			Liferay.on(
				`${settings.namespace}${CP_INSTANCE_CHANGED}`,
				onCPInstanceChange
			);
		}

		return () => {
			if (settings.namespace) {
				Liferay.detach(
					`${settings.namespace}${CP_INSTANCE_CHANGED}`,
					onCPInstanceChange
				);
			}
		};
	}, [settings.namespace]);

	const addToCart = <AddToCartButton {...props} quantity={currentQuantity} />

	return quantityDefinitions ? (
		<div
			className={classnames({
				'add-to-cart-wrapper': true,
				'align-items-center': true,
				'd-flex': true,
				'flex-column': props.settings.block,
			})}
		>
			<QuantitySelector
				{...quantityDefinitions}
				disabled={disabled}
				large={!props.settings.block}
				onUpdate={setCurrentQuantity}
			/>

			{addToCart}
		</div>
	) : addToCart;
}

AddToCart.defaultProps = {
	settings: {
		quantityDefinitions: null,
	},
};

AddToCart.propTypes = {
	AddToCartButton: PropTypes.func.isRequired,
	cpInstance: PropTypes.shape({
		accountId: PropTypes.number,
	}),
	quantity: PropTypes.number,
	settings: PropTypes.shape({
		block: PropTypes.bool,
		disabled: PropTypes.bool,
		namespace: PropTypes.bool,
		quantityDefinitions: PropTypes.shape({
			allowedQuantities: PropTypes.arrayOf(PropTypes.number),
			disabled: PropTypes.bool,
			large: PropTypes.bool,
			maxQuantity: PropTypes.number,
			minQuantity: PropTypes.number,
			multipleQuantity: PropTypes.number,
			name: PropTypes.string,
			onUpdate: PropTypes.func,
			quantity: PropTypes.number,
		}),
	}),
};

export default AddToCart;
