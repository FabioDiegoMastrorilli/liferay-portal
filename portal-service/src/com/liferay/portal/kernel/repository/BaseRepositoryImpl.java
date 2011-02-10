/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.kernel.repository;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * This class is used by third-party repository implementations. All classes
 * that extend <code>BaseRepositoryImpl</code> must specify two public static
 * fields: <code>SUPPORTED_CONFIGURATIONS</code> and
 * <code>SUPPORTED_PARAMETERS</code>.
 *
 * @author Alexander Chow
 * @see    com.liferay.portal.repository.cmis.CMISRepository#SUPPORTED_CONFIGURATIONS
 * @see    com.liferay.portal.repository.cmis.CMISRepository#SUPPORTED_PARAMETERS
 */
public abstract class BaseRepositoryImpl implements Repository {

	public void deleteFileEntry(long folderId, String title)
		throws PortalException, SystemException {

		FileEntry fileEntry = getFileEntry(folderId, title);

		deleteFileEntry(fileEntry.getFileEntryId());
	}

	public void deleteFolder(long parentFolderId, String title)
		throws PortalException, SystemException {

		Folder folder = getFolder(parentFolderId, title);

		deleteFolder(folder.getFolderId());
	}

	public LocalRepository getLocalRepository() {
		return _localRepository;
	}

	public long getRepositoryId() {
		return _repositoryId;
	}

	public UnicodeProperties getTypeSettingsProperties() {
		return _typeSettingsProperties;
	}

	public abstract void initRepository() throws RepositoryException;

	public void setRepositoryId(long repositoryId) {
		_repositoryId = repositoryId;
	}

	public void setTypeSettingsProperties(
		UnicodeProperties typeSettingsProperties) {

		_typeSettingsProperties = typeSettingsProperties;
	}

	public void unlockFolder(long parentFolderId, String title, String lockUuid)
		throws PortalException, SystemException {

		Folder folder = getFolder(parentFolderId, title);

		unlockFolder(folder.getFolderId(), lockUuid);
	}

	private LocalRepository _localRepository = new BaseLocalRepositoryImpl(
		this);
	private long _repositoryId;
	private UnicodeProperties _typeSettingsProperties;

}