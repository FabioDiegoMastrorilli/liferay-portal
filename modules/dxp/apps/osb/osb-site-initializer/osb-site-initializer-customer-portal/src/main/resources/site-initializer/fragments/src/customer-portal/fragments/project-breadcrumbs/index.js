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

import Button from '@clayui/button';
import ClayDropDown from '@clayui/drop-down';
import {ClayInput} from '@clayui/form';
import ClayIcon from '@clayui/icon';
import React, {memo, useCallback, useEffect, useState} from 'react';

const spritemap =
	Liferay.ThemeDisplay.getCDNBaseURL() +
	'/o/admin-theme/images/clay/icons.svg';

const KORONEIKI_ACCOUNTS_EVENT_NAME =
	'customer-portal-koroneiki-accounts-available';

const SELECTED_KORONEIKI_ACCOUNT_EVENT_NAME = 'customer-portal-project-loading';

const eventFetchMoreData = Liferay.publish(
	'customer-portal-fetch-more-koroneiki-accounts'
);

const eventSearchData = Liferay.publish(
	'customer-portal-search-koroneiki-accounts'
);

const useIntersectionObserver = () => {
	const [trackedRefCurrent, setTrackedRefCurrent] = useState();
	const [isIntersecting, setIsIntersecting] = useState(false);

	const memoizedSetIntersecting = useCallback((entities) => {
		const target = entities[0];

		setIsIntersecting(target.isIntersecting);
	}, []);

	useEffect(() => {
		const observer = new IntersectionObserver(memoizedSetIntersecting, {
			root: null,
			threshold: 1.0,
		});

		if (trackedRefCurrent) {
			observer.observe(trackedRefCurrent);
		}

		return () => {
			if (trackedRefCurrent) {
				observer.unobserve(trackedRefCurrent);
			}
		};
	}, [memoizedSetIntersecting, trackedRefCurrent]);

	return [setTrackedRefCurrent, isIntersecting];
};

const useDebounce = (value, delay) => {
	const [debouncedValue, setDebouncedValue] = useState(value);

	useEffect(() => {
		const handler = setTimeout(() => {
			setDebouncedValue(value);
		}, delay);

		return () => {
			clearTimeout(handler);
		};
	}, [value, delay]);

	return debouncedValue;
};

const Search = memo(({setSearchTerm}) => {
	const [value, setValue] = useState('');
	const [isClear, setIsClear] = useState(false);

	useEffect(() => setIsClear(!!value), [value]);
	useEffect(() => setSearchTerm(value), [setSearchTerm, value]);

	return (
		<ClayInput.Group className="m-0" small>
			<ClayInput.GroupItem>
				<ClayInput
					className="border-brand-primary-lighten-5 font-weight-semi-bold text-neutral-10 text-paragraph-sm"
					insetAfter
					onChange={(event) => setValue(event.target.value)}
					placeholder="Search"
					type="text"
					value={value}
				/>

				<ClayInput.GroupInsetItem
					after
					className="border-brand-primary-lighten-5"
					tag="span"
				>
					<Button
						displayType="unstyled"
						onClick={() =>
							setValue((previousValue) =>
								isClear ? '' : previousValue
							)
						}
					>
						<ClayIcon
							spritemap={spritemap}
							symbol={isClear ? 'times' : 'search'}
						/>
					</Button>
				</ClayInput.GroupInsetItem>
			</ClayInput.GroupItem>
		</ClayInput.Group>
	);
});

export default function () {
	const [active, setActive] = useState(false);
	const [searchTerm, setSearchTerm] = useState('');
	const debouncedSearchTerm = useDebounce(searchTerm, 500);

	const [trackedRef, isIntersecting] = useIntersectionObserver();

	const [koroneikiAccounts, setKoroneikiAccounts] = useState();
	const [totalCount, setTotalCount] = useState();
	const [initialTotalCount, setInitialTotalCount] = useState();
	const [selectedKoroneikiAccount, setSelectKoroneikiAccount] = useState();

	useEffect(() => {
		Liferay.once(SELECTED_KORONEIKI_ACCOUNT_EVENT_NAME, ({detail}) => {
			setSelectKoroneikiAccount(detail);
		});

		return () => Liferay.detach(SELECTED_KORONEIKI_ACCOUNT_EVENT_NAME);
	}, []);

	useEffect(() => {
		Liferay.on(KORONEIKI_ACCOUNTS_EVENT_NAME, ({detail}) => {
			if (detail?.koroneikiAccounts) {
				setKoroneikiAccounts(detail.koroneikiAccounts);
			}

			if (detail?.totalCount) {
				setTotalCount(detail.totalCount);
			}

			if (detail?.initialTotalCount) {
				setInitialTotalCount(detail.initialTotalCount);
			}
		});

		return () => Liferay.detach(KORONEIKI_ACCOUNTS_EVENT_NAME);
	}, []);

	useEffect(() => {
		if (isIntersecting) {
			eventFetchMoreData.fire();
		}
	}, [isIntersecting]);

	useEffect(() => {
		eventSearchData.fire({
			detail: debouncedSearchTerm,
		});
	}, [debouncedSearchTerm]);

	const getHref = useCallback((accountKey) => {
		const hashLocation = window.location.hash.replace(
			/[A-Z]+-\d+/g,
			accountKey
		);

		return `${Liferay.ThemeDisplay.getCanonicalURL()}/${hashLocation}`;
	}, []);

	const getDropDownItems = useCallback(
		() =>
			koroneikiAccounts?.map((koroneikiAccount, index) => {
				const isSelected =
					koroneikiAccount.accountKey ===
					selectedKoroneikiAccount?.accountKey;

				return (
					<ClayDropDown.Item
						active={isSelected}
						className="font-weight-semi-bold px-3 text-paragraph-sm"
						href={
							!isSelected && getHref(koroneikiAccount.accountKey)
						}
						key={`${koroneikiAccount.code}-${index}`}
						spritemap={spritemap}
						symbolRight={isSelected ? 'check' : ''}
					>
						{koroneikiAccount.name || koroneikiAccount.code}
					</ClayDropDown.Item>
				);
			}),
		[getHref, koroneikiAccounts, selectedKoroneikiAccount?.accountKey]
	);

	if (!koroneikiAccounts || !selectedKoroneikiAccount) {
		return <div>Loading</div>;
	}

	return (
		<ClayDropDown
			active={active}
			closeOnClickOutside
			hasRightSymbols
			menuElementAttrs={{
				className: 'cp-project-breadcrumbs-menu p-0',
			}}
			onActiveChange={setActive}
			trigger={<button className="btn btn-primary">Click here!</button>}
		>
			{initialTotalCount > 20 && (
				<div className="dropdown-section px-3">
					<Search setSearchTerm={setSearchTerm} />
				</div>
			)}

			<ClayDropDown.ItemList className="overflow-auto">
				{getDropDownItems()}

				{!koroneikiAccounts.length && (
					<ClayDropDown.Section>
						<div>No projects match that name.</div>
					</ClayDropDown.Section>
				)}

				{!!koroneikiAccounts.length &&
					koroneikiAccounts.length < totalCount && (
						<ClayDropDown.Section>
							<div ref={trackedRef}>Loading more...</div>
						</ClayDropDown.Section>
					)}
			</ClayDropDown.ItemList>

			<a
				className="dropdown-item font-weight-semi-bold px-3 text-decoration-none text-paragraph-sm"
				href={Liferay.ThemeDisplay.getCanonicalURL().replace(
					'/project',
					''
				)}
				onClick={() => setActive(false)}
			>
				All Projects
			</a>
		</ClayDropDown>
	);
}
