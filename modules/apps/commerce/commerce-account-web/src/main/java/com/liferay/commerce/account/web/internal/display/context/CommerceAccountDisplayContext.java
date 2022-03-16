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

package com.liferay.commerce.account.web.internal.display.context;

import com.liferay.account.constants.AccountPortletKeys;
import com.liferay.account.model.AccountEntry;
import com.liferay.account.service.AccountEntryService;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Andrea Sbarra
 */
public class CommerceAccountDisplayContext {

	public CommerceAccountDisplayContext(ModelResourcePermission<AccountEntry>
												 accountEntryModelResourcePermission, AccountEntryService accountEntryService, HttpServletRequest httpServletRequest, Portal portal) throws PortalException {

		_accountEntryModelResourcePermission = accountEntryModelResourcePermission;
		_accountEntryService = accountEntryService;
		_httpServletRequest = httpServletRequest;
		_portal = portal;


		_accountEntry = _accountEntryService.fetchAccountEntry(ParamUtil.getLong(_httpServletRequest, "accountEntryId"));
	}

	public AccountEntry getAccountEntry() {
		return _accountEntry;
	}

	public long getAccountEntryId() {
		return _accountEntry.getAccountEntryId();
	}

	public CreationMenu getCreationMenu() throws Exception {
		CreationMenu creationMenu = new CreationMenu();

		if (hasUpdateAccountEntryPermission()) {
			creationMenu.addDropdownItem(
					dropdownItem -> {
						dropdownItem.setHref(getAddShippingOptionURL());
						dropdownItem.setLabel(
								LanguageUtil.get(_httpServletRequest, "add-shipping-option"));
						dropdownItem.setTarget("modal-lg");
					});
		}

		return creationMenu;
	}

	public String getAddShippingOptionURL() throws Exception {
		return PortletURLBuilder.create(
				_portal.getControlPanelPortletURL(
						_httpServletRequest, AccountPortletKeys.ACCOUNT_ENTRIES_ADMIN,
						PortletRequest.RENDER_PHASE)
		).setMVCRenderCommandName(
				"/account_entry/edit_account_entry_shipping_option"
		).setRedirect(
				getPortletURL()
		).setWindowState(
				LiferayWindowState.POP_UP
		).buildString();
	}

	public PortletURL getPortletURL() throws PortalException {

		LiferayPortletResponse liferayPortletResponse = getLiferayPortletResponse();

		PortletURL portletURL = liferayPortletResponse.createRenderURL();

		String redirect = ParamUtil.getString(_httpServletRequest, "redirect");

		if (Validator.isNotNull(redirect)) {
			portletURL.setParameter("redirect", redirect);
		}

		return portletURL;
	}

	public LiferayPortletResponse getLiferayPortletResponse() {

			PortletResponse portletResponse =
					(PortletResponse)_httpServletRequest.getAttribute(
							JavaConstants.JAVAX_PORTLET_RESPONSE);

		return _portal.getLiferayPortletResponse(portletResponse);

	}

	public boolean hasUpdateAccountEntryPermission() throws PortalException {
		ThemeDisplay themeDisplay =
				(ThemeDisplay)_httpServletRequest.getAttribute(
						WebKeys.THEME_DISPLAY);

		return _accountEntryModelResourcePermission.contains(
				themeDisplay.getPermissionChecker(), _accountEntry,
				ActionKeys.UPDATE);
	}



	public String getName() {
		return _accountEntry.getName();
	}

	private final AccountEntry _accountEntry;
	private final ModelResourcePermission<AccountEntry>
			_accountEntryModelResourcePermission;
	private final AccountEntryService _accountEntryService;
	private final HttpServletRequest _httpServletRequest;
	private final Portal _portal;

}