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

package com.liferay.object.web.internal.object.entries.frontend.taglib.clay.data.set;

import com.liferay.frontend.taglib.clay.data.set.ClayDataSetActionProvider;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.object.web.internal.object.entries.constants.ObjectEntriesClayDataSetDisplayNames;
import com.liferay.object.web.internal.object.entries.frontend.taglib.clay.data.set.data.provider.RelatedModel;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marco Leo
 */
@Component(
	property = "clay.data.provider.key=" + ObjectEntriesClayDataSetDisplayNames.RELATED_MODELS,
	service = ClayDataSetActionProvider.class
)
public class RelatedModelDataSetActionProvider
	implements ClayDataSetActionProvider {

	@Override
	public List<DropdownItem> getDropdownItems(
			HttpServletRequest httpServletRequest, long groupId, Object model)
		throws PortalException {

		RelatedModel relatedModel = (RelatedModel)model;

		return DropdownItemListBuilder.add(
			dropdownItem -> {
				dropdownItem.setHref(
					_getDeleteURL(relatedModel.getId(), httpServletRequest));
				dropdownItem.setLabel(
					LanguageUtil.get(httpServletRequest, Constants.DELETE));
			}
		).build();
	}

	private PortletURL _getDeleteURL(
			long id, HttpServletRequest httpServletRequest)
		throws PortalException {

		long objectEntryId = ParamUtil.getLong(
			httpServletRequest, "objectEntryId");

		ObjectEntry objectEntry = _objectEntryLocalService.getObjectEntry(
			objectEntryId);

		ObjectDefinition objectDefinition =
			_objectDefinitionLocalService.getObjectDefinition(
				objectEntry.getObjectDefinitionId());

		return PortletURLBuilder.create(
			_portal.getControlPanelPortletURL(
				httpServletRequest, objectDefinition.getPortletId(),
				PortletRequest.ACTION_PHASE)
		).setActionName(
			"/object_entries/edit_object_entry"
		).setCMD(
			"disassociateRelatedModels"
		).setRedirect(
			ParamUtil.getString(
				httpServletRequest, "currentUrl",
				_portal.getCurrentURL(httpServletRequest))
		).setParameter(
			"objectEntryId", objectEntryId
		).setParameter(
			"objectRelationshipId",
			ParamUtil.getLong(httpServletRequest, "objectRelationshipId")
		).setParameter(
			"relatedModelId", id
		).buildPortletURL();
	}

	@Reference
	private ObjectDefinitionLocalService _objectDefinitionLocalService;

	@Reference
	private ObjectEntryLocalService _objectEntryLocalService;

	@Reference
	private Portal _portal;

}