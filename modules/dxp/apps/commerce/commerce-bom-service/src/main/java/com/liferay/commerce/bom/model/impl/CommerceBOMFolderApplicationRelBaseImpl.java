/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.commerce.bom.model.impl;

import com.liferay.commerce.bom.model.CommerceBOMFolderApplicationRel;
import com.liferay.commerce.bom.service.CommerceBOMFolderApplicationRelLocalServiceUtil;

/**
 * The extended model base implementation for the CommerceBOMFolderApplicationRel service. Represents a row in the &quot;CBOMFolderApplicationRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceBOMFolderApplicationRelImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see CommerceBOMFolderApplicationRelImpl
 * @see CommerceBOMFolderApplicationRel
 * @generated
 */
public abstract class CommerceBOMFolderApplicationRelBaseImpl
	extends CommerceBOMFolderApplicationRelModelImpl
	implements CommerceBOMFolderApplicationRel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce bom folder application rel model instance should use the <code>CommerceBOMFolderApplicationRel</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CommerceBOMFolderApplicationRelLocalServiceUtil.
				addCommerceBOMFolderApplicationRel(this);
		}
		else {
			CommerceBOMFolderApplicationRelLocalServiceUtil.
				updateCommerceBOMFolderApplicationRel(this);
		}
	}

}