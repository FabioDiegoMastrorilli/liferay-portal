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

package com.liferay.commerce.service.impl;

import com.liferay.commerce.model.CommerceAddressRestriction;
import com.liferay.commerce.model.CommerceShippingMethod;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.commerce.service.base.CommerceShippingMethodServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.File;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Andrea Di Giorgi
 * @author Alessio Antonio Rendina
 */
public class CommerceShippingMethodServiceImpl
	extends CommerceShippingMethodServiceBaseImpl {

	@Override
	public CommerceAddressRestriction addCommerceAddressRestriction(
			long userId, long groupId, long commerceShippingMethodId,
			long commerceCountryId)
		throws PortalException {

		_checkCommerceChannelPermissionByGroupId(groupId);

		return commerceShippingMethodLocalService.addCommerceAddressRestriction(
			userId, groupId, commerceShippingMethodId, commerceCountryId);
	}

	/**
	 * @deprecated As of Athanasius (7.3.x)
	 */
	@Deprecated
	@Override
	public CommerceAddressRestriction addCommerceAddressRestriction(
			long commerceShippingMethodId, long commerceCountryId,
			ServiceContext serviceContext)
		throws PortalException {

		return commerceShippingMethodService.addCommerceAddressRestriction(
			serviceContext.getUserId(), serviceContext.getScopeGroupId(),
			commerceShippingMethodId, commerceCountryId);
	}

	@Override
	public CommerceShippingMethod addCommerceShippingMethod(
			long userId, long groupId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, File imageFile,
			String engineKey, double priority, boolean active)
		throws PortalException {

		_checkCommerceChannelPermissionByGroupId(groupId);

		return commerceShippingMethodLocalService.addCommerceShippingMethod(
			userId, groupId, nameMap, descriptionMap, imageFile, engineKey,
			priority, active);
	}

	@Override
	public CommerceShippingMethod createCommerceShippingMethod(
			long commerceShippingMethodId)
		throws PortalException {

		CommerceShippingMethod commerceShippingMethod =
			commerceShippingMethodLocalService.fetchCommerceShippingMethod(
				commerceShippingMethodId);

		if (commerceShippingMethod != null) {
			_checkCommerceChannelPermissionByGroupId(
				commerceShippingMethod.getGroupId());
		}

		return commerceShippingMethodLocalService.createCommerceShippingMethod(
			commerceShippingMethodId);
	}

	@Override
	public void deleteCommerceAddressRestriction(
			long commerceAddressRestrictionId)
		throws PortalException {

		CommerceAddressRestriction commerceAddressRestriction =
			commerceAddressRestrictionLocalService.
				getCommerceAddressRestriction(commerceAddressRestrictionId);

		_checkCommerceChannelPermissionByGroupId(
			commerceAddressRestriction.getGroupId());

		commerceShippingMethodLocalService.deleteCommerceAddressRestriction(
			commerceAddressRestrictionId);
	}

	@Override
	public void deleteCommerceAddressRestrictions(long commerceShippingMethodId)
		throws PortalException {

		CommerceShippingMethod commerceShippingMethod =
			commerceShippingMethodLocalService.getCommerceShippingMethod(
				commerceShippingMethodId);

		_checkCommerceChannelPermissionByGroupId(
			commerceShippingMethod.getGroupId());

		commerceAddressRestrictionLocalService.
			deleteCommerceAddressRestrictions(
				CommerceShippingMethod.class.getName(),
				commerceShippingMethodId);
	}

	@Override
	public void deleteCommerceShippingMethod(long commerceShippingMethodId)
		throws PortalException {

		CommerceShippingMethod commerceShippingMethod =
			commerceShippingMethodLocalService.getCommerceShippingMethod(
				commerceShippingMethodId);

		_checkCommerceChannelPermissionByGroupId(
			commerceShippingMethod.getGroupId());

		commerceShippingMethodLocalService.deleteCommerceShippingMethod(
			commerceShippingMethod);
	}

	@Override
	public CommerceShippingMethod fetchCommerceShippingMethod(
			long groupId, String engineKey)
		throws PortalException {

		CommerceShippingMethod commerceShippingMethod =
			commerceShippingMethodLocalService.fetchCommerceShippingMethod(
				groupId, engineKey);

		if (commerceShippingMethod != null) {
			_checkCommerceChannelPermissionByGroupId(
				commerceShippingMethod.getGroupId());
		}

		return commerceShippingMethod;
	}

	@Override
	public List<CommerceAddressRestriction> getCommerceAddressRestrictions(
			long commerceShippingMethodId, int start, int end,
			OrderByComparator<CommerceAddressRestriction> orderByComparator)
		throws PortalException {

		CommerceShippingMethod commerceShippingMethod =
			commerceShippingMethodLocalService.getCommerceShippingMethod(
				commerceShippingMethodId);

		_checkCommerceChannelPermissionByGroupId(
			commerceShippingMethod.getGroupId());

		return commerceShippingMethodLocalService.
			getCommerceAddressRestrictions(
				commerceShippingMethodId, start, end, orderByComparator);
	}

	@Override
	public int getCommerceAddressRestrictionsCount(
			long commerceShippingMethodId)
		throws PortalException {

		CommerceShippingMethod commerceShippingMethod =
			commerceShippingMethodLocalService.getCommerceShippingMethod(
				commerceShippingMethodId);

		_checkCommerceChannelPermissionByGroupId(
			commerceShippingMethod.getGroupId());

		return commerceShippingMethodLocalService.
			getCommerceAddressRestrictionsCount(commerceShippingMethodId);
	}

	@Override
	public CommerceShippingMethod getCommerceShippingMethod(
			long commerceShippingMethodId)
		throws PortalException {

		CommerceShippingMethod commerceShippingMethod =
			commerceShippingMethodLocalService.getCommerceShippingMethod(
				commerceShippingMethodId);

		_checkCommerceChannelPermissionByGroupId(
			commerceShippingMethod.getGroupId());

		return commerceShippingMethod;
	}

	@Override
	public List<CommerceShippingMethod> getCommerceShippingMethods(long groupId)
		throws PortalException {

		_checkCommerceChannelPermissionByGroupId(groupId);

		return commerceShippingMethodLocalService.getCommerceShippingMethods(
			groupId);
	}

	@Override
	public List<CommerceShippingMethod> getCommerceShippingMethods(
			long groupId, boolean active)
		throws PortalException {

		_checkCommerceChannelPermissionByGroupId(groupId);

		return commerceShippingMethodLocalService.getCommerceShippingMethods(
			groupId, active);
	}

	@Override
	public List<CommerceShippingMethod> getCommerceShippingMethods(
			long groupId, long commerceCountryId, boolean active)
		throws PortalException {

		_checkCommerceChannelPermissionByGroupId(groupId);

		return commerceShippingMethodLocalService.getCommerceShippingMethods(
			groupId, commerceCountryId, active);
	}

	@Override
	public int getCommerceShippingMethodsCount(long groupId, boolean active)
		throws PortalException {

		_checkCommerceChannelPermissionByGroupId(groupId);

		return commerceShippingMethodLocalService.
			getCommerceShippingMethodsCount(groupId, active);
	}

	@Override
	public CommerceShippingMethod setActive(
			long commerceShippingMethodId, boolean active)
		throws PortalException {

		CommerceShippingMethod commerceShippingMethod =
			commerceShippingMethodLocalService.fetchCommerceShippingMethod(
				commerceShippingMethodId);

		if (commerceShippingMethod != null) {
			_checkCommerceChannelPermissionByGroupId(
				commerceShippingMethod.getGroupId());
		}

		return commerceShippingMethodLocalService.setActive(
			commerceShippingMethodId, active);
	}

	@Override
	public CommerceShippingMethod updateCommerceShippingMethod(
			long commerceShippingMethodId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, File imageFile, double priority,
			boolean active)
		throws PortalException {

		CommerceShippingMethod commerceShippingMethod =
			commerceShippingMethodLocalService.getCommerceShippingMethod(
				commerceShippingMethodId);

		_checkCommerceChannelPermissionByGroupId(
			commerceShippingMethod.getGroupId());

		return commerceShippingMethodLocalService.updateCommerceShippingMethod(
			commerceShippingMethod.getCommerceShippingMethodId(), nameMap,
			descriptionMap, imageFile, priority, active);
	}

	private void _checkCommerceChannelPermissionByGroupId(long groupId)
		throws PortalException {

		CommerceChannel commerceChannel =
			_commerceChannelLocalService.getCommerceChannelByGroupId(groupId);

		_commerceChannelModelResourcePermission.check(
			getPermissionChecker(), commerceChannel, ActionKeys.UPDATE);
	}

	private static volatile ModelResourcePermission<CommerceChannel>
		_commerceChannelModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				CommerceShippingMethodServiceImpl.class,
				"_commerceChannelModelResourcePermission",
				CommerceChannel.class);

	@ServiceReference(type = CommerceChannelLocalService.class)
	private CommerceChannelLocalService _commerceChannelLocalService;

}