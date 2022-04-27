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

package com.liferay.batch.planner.rest.internal.resource.v1_0;

import com.liferay.batch.planner.rest.dto.v1_0.Field;
import com.liferay.batch.planner.rest.resource.v1_0.FieldResource;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.vulcan.batch.engine.VulcanBatchEngineTaskItemDelegate;
import com.liferay.portal.vulcan.batch.engine.VulcanBatchEngineTaskItemDelegateRegistry;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.resource.OpenAPIResource;
import com.liferay.portal.vulcan.util.OpenAPIUtil;
import com.liferay.portal.vulcan.yaml.YAMLUtil;
import com.liferay.portal.vulcan.yaml.openapi.OpenAPIYAML;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Matija Petanjek
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/field.properties",
	scope = ServiceScope.PROTOTYPE, service = FieldResource.class
)
public class FieldResourceImpl extends BaseFieldResourceImpl {

	@Override
	public Page<Field> getPlanInternalClassNameFieldsPage(
			String internalClassName, Boolean export)
		throws Exception {

		Collection<com.liferay.portal.vulcan.batch.engine.Field>
			dtoEntityFields = _getDTOEntityFields(internalClassName);

		if (GetterUtil.getBoolean(export)) {
			dtoEntityFields = _filterExportDTOEntityFields(
				dtoEntityFields.stream());
		}
		else {
			dtoEntityFields = _filterImportDTOEntityFields(
				dtoEntityFields.stream());
		}

		return Page.of(transform(dtoEntityFields, this::_toField));
	}

	private List<com.liferay.portal.vulcan.batch.engine.Field>
		_filterExportDTOEntityFields(
			Stream<com.liferay.portal.vulcan.batch.engine.Field>
				dtoEntityFieldsStream) {

		return dtoEntityFieldsStream.filter(
			field ->
				field.getAccessType() !=
					com.liferay.portal.vulcan.batch.engine.Field.AccessType.
						WRITE
		).collect(
			Collectors.toList()
		);
	}

	private List<com.liferay.portal.vulcan.batch.engine.Field>
		_filterImportDTOEntityFields(
			Stream<com.liferay.portal.vulcan.batch.engine.Field>
				dtoEntityFieldsStream) {

		return dtoEntityFieldsStream.filter(
			field ->
				field.getAccessType() !=
					com.liferay.portal.vulcan.batch.engine.Field.AccessType.READ
		).collect(
			Collectors.toList()
		);
	}

	private Collection<com.liferay.portal.vulcan.batch.engine.Field>
			_getDTOEntityFields(String internalClassName)
		throws Exception {

		VulcanBatchEngineTaskItemDelegate vulcanBatchEngineTaskItemDelegate =
			_vulcanBatchEngineTaskItemDelegateRegistry.
				getVulcanBatchEngineTaskItemDelegate(internalClassName);

		Response response = _openAPIResource.getOpenAPI(
			Collections.singleton(
				vulcanBatchEngineTaskItemDelegate.getResourceClass()),
			"yaml");

		OpenAPIYAML openAPIYAML = YAMLUtil.loadOpenAPIYAML(
			(String)response.getEntity());

		Map<String, com.liferay.portal.vulcan.batch.engine.Field>
			dtoEntityFields = OpenAPIUtil.getDTOEntityFields(
				internalClassName.substring(
					internalClassName.lastIndexOf(StringPool.PERIOD) + 1),
				openAPIYAML);

		return dtoEntityFields.values();
	}

	private Field _toField(com.liferay.portal.vulcan.batch.engine.Field field) {
		return new Field() {
			{
				description = field.getDescription();
				name = field.getName();
				required = field.isRequired();
				type = field.getType();
			}
		};
	}

	@Reference
	private OpenAPIResource _openAPIResource;

	@Reference
	private VulcanBatchEngineTaskItemDelegateRegistry
		_vulcanBatchEngineTaskItemDelegateRegistry;

}