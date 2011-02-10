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

package com.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the RepositoryEntry service. Represents a row in the &quot;RepositoryEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.RepositoryEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.RepositoryEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RepositoryEntry
 * @see com.liferay.portal.model.impl.RepositoryEntryImpl
 * @see com.liferay.portal.model.impl.RepositoryEntryModelImpl
 * @generated
 */
public interface RepositoryEntryModel extends BaseModel<RepositoryEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a repository entry model instance should use the {@link RepositoryEntry} interface instead.
	 */

	/**
	 * Gets the primary key of this repository entry.
	 *
	 * @return the primary key of this repository entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this repository entry
	 *
	 * @param pk the primary key of this repository entry
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the repository entry ID of this repository entry.
	 *
	 * @return the repository entry ID of this repository entry
	 */
	public long getRepositoryEntryId();

	/**
	 * Sets the repository entry ID of this repository entry.
	 *
	 * @param repositoryEntryId the repository entry ID of this repository entry
	 */
	public void setRepositoryEntryId(long repositoryEntryId);

	/**
	 * Gets the repository ID of this repository entry.
	 *
	 * @return the repository ID of this repository entry
	 */
	public long getRepositoryId();

	/**
	 * Sets the repository ID of this repository entry.
	 *
	 * @param repositoryId the repository ID of this repository entry
	 */
	public void setRepositoryId(long repositoryId);

	/**
	 * Gets the mapped ID of this repository entry.
	 *
	 * @return the mapped ID of this repository entry
	 */
	@AutoEscape
	public String getMappedId();

	/**
	 * Sets the mapped ID of this repository entry.
	 *
	 * @param mappedId the mapped ID of this repository entry
	 */
	public void setMappedId(String mappedId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(RepositoryEntry repositoryEntry);

	public int hashCode();

	public RepositoryEntry toEscapedModel();

	public String toString();

	public String toXmlString();
}