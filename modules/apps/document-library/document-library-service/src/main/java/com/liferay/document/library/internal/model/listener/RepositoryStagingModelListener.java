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

package com.liferay.document.library.internal.model.listener;

import com.liferay.document.library.constants.DLPortletKeys;
import com.liferay.document.library.internal.util.DLExportableRepositoryPublisherHelper;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.repository.liferayrepository.LiferayRepositoryDefiner;
import com.liferay.portal.repository.temporaryrepository.TemporaryFileEntryRepositoryDefiner;
import com.liferay.staging.model.listener.StagingModelListener;

import java.util.Collection;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(service = ModelListener.class)
public class RepositoryStagingModelListener
	extends BaseModelListener<Repository> {

	@Override
	public void onAfterCreate(Repository repository)
		throws ModelListenerException {

		if (!_isRepositoryExportable(repository)) {
			return;
		}

		_stagingModelListener.onAfterCreate(repository);
	}

	@Override
	public void onAfterRemove(Repository repository)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(repository);
	}

	@Override
	public void onAfterUpdate(
			Repository originalRepository, Repository repository)
		throws ModelListenerException {

		if (!_isRepositoryExportable(repository)) {
			return;
		}

		_stagingModelListener.onAfterUpdate(repository);
	}

	private boolean _isRepositoryExportable(Repository repository) {
		long liferayRepositoryClassNameId = _portal.getClassNameId(
			LiferayRepositoryDefiner.CLASS_NAME);

		if (repository.getClassNameId() == liferayRepositoryClassNameId) {
			return false;
		}

		long tempFileRepositoryClassNameId = _portal.getClassNameId(
			TemporaryFileEntryRepositoryDefiner.CLASS_NAME);

		if (repository.getClassNameId() == tempFileRepositoryClassNameId) {
			return false;
		}

		Collection<Long> exportableRepositoryIds =
			_dlExportableRepositoryPublisherHelper.publish(
				repository.getGroupId());
		String portletId = repository.getPortletId();

		if (!Validator.isBlank(portletId) &&
			!Objects.equals(portletId, DLPortletKeys.DOCUMENT_LIBRARY_ADMIN) &&
			!StringUtil.startsWith(portletId, DLPortletKeys.DOCUMENT_LIBRARY) &&
			!exportableRepositoryIds.contains(repository.getRepositoryId())) {

			return false;
		}

		return true;
	}

	@Reference
	private DLExportableRepositoryPublisherHelper
		_dlExportableRepositoryPublisherHelper;

	@Reference
	private Portal _portal;

	@Reference
	private StagingModelListener<Repository> _stagingModelListener;

}