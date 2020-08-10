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

import ClayButton from '@clayui/button';
import classnames from 'classnames';
import PropTypes from 'prop-types';
import React, {useContext, useState} from 'react';

import {PRODUCT_REMOVED} from '../../utilities/eventsDefinitions';
import {liferayNavigate} from '../../utilities/index';
import MiniCartContext from './MiniCartContext';

function getCN(isAsking, className) {
	return classnames(className, !isAsking && 'hide');
}

function CartItemsListActions({numberOfItems}) {
	const {
			AJAX,
			actionURLs,
			cartState,
			setIsUpdating,
			updateCartModel
		} = useContext(MiniCartContext),
		{id: orderId} = cartState,
		{orderDetailURL} = actionURLs;

	const [isAsking, setIsAsking] = useState(false);

	const askConfirmation = () => setIsAsking(true),
		cancel = () => {
			setIsAsking(false);
		},
		flushCart = () => {
			setIsUpdating(true);

			AJAX.updateCartById(orderId, {...cartState, cartItems: []})
				.then(() => updateCartModel({orderId}))
				.then(() => {
					setIsAsking(false);
					setIsUpdating(false);

					Liferay.fire(PRODUCT_REMOVED, {
						skuId: 'all'
					});
				});
		};

	return (
		<div className={'mini-cart-header'}>
			<div className={'mini-cart-header-block'}>
				<div className={'mini-cart-header-resume'}>
					{numberOfItems > 0 && (
						<>
							<span className={'items'}>{numberOfItems}</span>
							{` ${
								numberOfItems > 1
									? Liferay.Language.get('products')
									: Liferay.Language.get('product')
							}`}
						</>
					)}
				</div>

				<div className={'mini-cart-header-actions'}>
					<span className={getCN(!isAsking, 'actions')}>
						<ClayButton
							className={'action'}
							disabled={!numberOfItems}
							displayType={'link'}
							onClick={() => {
								liferayNavigate(orderDetailURL);
							}}
							small
						>
							{Liferay.Language.get('view-details')}
						</ClayButton>

						<ClayButton
							className={'action'}
							disabled={!numberOfItems}
							displayType={'link'}
							onClick={askConfirmation}
							small
						>
							{Liferay.Language.get('remove-all-items')}
						</ClayButton>
					</span>

					<div className={getCN(isAsking, 'confirmation-prompt')}>
						<span>{Liferay.Language.get('are-you-sure')}</span>

						<span>
							<button
								className={'btn btn-sm btn-outline-success'}
								onClick={flushCart}
								type={'button'}
							>
								{Liferay.Language.get('yes')}
							</button>
							<button
								className={'btn btn-sm btn-outline-danger'}
								onClick={cancel}
								type={'button'}
							>
								{Liferay.Language.get('no')}
							</button>
						</span>
					</div>
				</div>
			</div>
		</div>
	);
}

CartItemsListActions.propTypes = {
	numberOfItems: PropTypes.number
};

export default CartItemsListActions;
