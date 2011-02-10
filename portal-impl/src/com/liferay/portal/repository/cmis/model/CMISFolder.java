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

package com.liferay.portal.repository.cmis.model;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.repository.cmis.CMISRepository;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.CmisObject;

/**
 * @author Alexander Chow
 */
public class CMISFolder extends CMISModel implements Folder {

	public CMISFolder(
		CMISRepository cmisRepository, long repositoryId, long folderId,
		org.apache.chemistry.opencmis.client.api.Folder cmisFolder) {

		_cmisRepository = cmisRepository;
		_repositoryId = repositoryId;
		_folderId = folderId;
		_cmisFolder = cmisFolder;
	}

	public List<Folder> getAncestors() {
		return null;
	}

	public Map<String, Serializable> getAttributes() {
		return null;
	}

	public long getCompanyId() {
		return 0;
	}

	public Date getCreateDate() {
		return _cmisFolder.getCreationDate().getTime();
	}

	public String getDescription() {
		return getDescription((CmisObject)getModel());
	}

	public long getFolderId() {
		return _folderId;
	}

	public long getGroupId() {
		return 0;
	}

	public Date getLastPostDate() {
		return _cmisFolder.getLastModificationDate().getTime();
	}

	public Object getModel() {
		return _cmisFolder;
	}

	public Date getModifiedDate() {
		return _cmisFolder.getLastModificationDate().getTime();
	}

	public String getName() {
		return _cmisFolder.getName();
	}

	public Folder getParentFolder() throws PortalException, SystemException {
		return _cmisRepository.toFolder(_cmisFolder.getParents().get(0));
	}

	public long getParentFolderId() {
		return DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	}

	public String getPath() {
		return null;
	}

	public String[] getPathArray() {
		return null;
	}

	public long getPrimaryKey() {
		return _folderId;
	}

	public long getRepositoryId() {
		return _repositoryId;
	}

	public long getUserId() {
		return 0;
	}

	public String getUserName() {
		return _cmisFolder.getCreatedBy();
	}

	public String getUserUuid() {
		return null;
	}

	public String getUuid() {
		return _cmisFolder.getId();
	}

	public boolean hasInheritableLock() {
		return false;
	}

	public boolean hasLock() {
		return false;
	}

	public boolean isDefaultRepository() {
		return false;
	}

	public boolean isEscapedModel() {
		return false;
	}

	public boolean isLocked() {
		return false;
	}

	public boolean isMountPoint() {
		return false;
	}

	public boolean isRoot() {
		return false;
	}

	public void prepare() {
	}

	public Folder toEscapedModel() {
		return this;
	}

	private org.apache.chemistry.opencmis.client.api.Folder _cmisFolder;
	private CMISRepository _cmisRepository;
	private long _folderId;
	private long _repositoryId;

}