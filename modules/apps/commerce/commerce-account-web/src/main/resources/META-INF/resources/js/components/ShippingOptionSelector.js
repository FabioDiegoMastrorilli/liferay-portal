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

import ClayForm, {ClayRadio, ClayRadioGroup, ClaySelect} from '@clayui/form';
import ServiceProvider from 'commerce-frontend-js/ServiceProvider/index';
import PropTypes from 'prop-types';
import React, {useEffect, useState} from 'react';

const AdminChannelResource = ServiceProvider.AdminChannelAPI('v1');

function ShippingOptionSelector({
	editAccountEntryShippingOptionActionURL,
	portletNamespace,
	selectedChannelId: initialSelectedChannelId,
	selectedShippingOptionId: initialSelectedShippingOptionId,
}) {
	const [selectedChannelId, setSelectedChannelId] = useState(
		initialSelectedChannelId
	);
	const [selectedShippingOptionId, setSelectedShippingOptionId] = useState(
		initialSelectedShippingOptionId
	);
	const [fetchedChannels, setFetchedChannels] = useState([]);
	const [fetchedShippingOptions, setFetchedShippingOptions] = useState([]);

	useEffect(() => {
		AdminChannelResource.getChannels({pageSize: 200}).then((response) => {
			setFetchedChannels(response.items);
		});
	}, []);

	useEffect(() => {
		if (selectedChannelId) {
			AdminChannelResource.getShippingMethods(selectedChannelId, {
				pageSize: 200,
			}).then((response) => {
				setFetchedShippingOptions(response.items);
			});
		}
		else {
			setFetchedShippingOptions([]);
		}
	}, [selectedChannelId]);

	return (
		<ClayForm
			action={editAccountEntryShippingOptionActionURL}
			method="POST"
		>
			<ClayForm.Group>
				<label htmlFor="channelSelect">
					{Liferay.Language.get('channel')}
				</label>

				<ClaySelect
					id="channelSelect"
					name={`${portletNamespace}channelId`}
					onChange={({target}) => setSelectedChannelId(target.value)}
					value={selectedChannelId || ''}
				>
					<ClaySelect.Option label="" value="" />

					{fetchedChannels.map((channel) => (
						<ClaySelect.Option
							key={channel.id}
							label={channel.name}
							value={channel.id}
						/>
					))}
				</ClaySelect>
			</ClayForm.Group>

			{selectedChannelId && (
				<ClayForm.Group>
					<label>{Liferay.Language.get('shipping-option')}</label>

					<ClayRadioGroup
						onSelectedValueChange={(optionId) =>
							setSelectedShippingOptionId(optionId)
						}
						selectedValue={selectedShippingOptionId}
					>
						{fetchedShippingOptions.map((option) => (
							<ClayRadio
								key={option.id}
								label={
									option.name[themeDisplay.getLanguageId()]
								}
								name={`${portletNamespace}shippingOptionId`}
								value={option.id}
							/>
						))}
					</ClayRadioGroup>
				</ClayForm.Group>
			)}
		</ClayForm>
	);
}

ShippingOptionSelector.defaultProps = {
	selectedChannelId: null,
	selectedShippingOptionId: null,
};

ShippingOptionSelector.propTypes = {
	editAccountEntryShippingOptionActionURL: PropTypes.string.isRequired,
	portletNamespace: PropTypes.string.isRequired,
	selectedChannelId: PropTypes.number,
	selectedShippingOptionId: PropTypes.number,
};

export default ShippingOptionSelector;
