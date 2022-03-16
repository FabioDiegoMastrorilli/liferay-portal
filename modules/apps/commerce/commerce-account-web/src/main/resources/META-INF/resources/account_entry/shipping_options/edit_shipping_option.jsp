<%--
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
--%>

<%@ include file="/init.jsp" %>

<commerce-ui:modal-content
	submitButtonLabel='<%= LanguageUtil.get(request, "add") %>'
	title='<%= LanguageUtil.get(request, "add-shipping-option") %>'
>
	<portlet:actionURL name="/account_entry/edit_account_entry_shipping_option" var="editAccountEntryShippingOptionActionURL" />

	<react:component
		module="js/components/ShippingOptionSelector"
		props='<%=
			HashMapBuilder.<String, Object>put(
				"editAccountEntryShippingOptionActionURL", editAccountEntryShippingOptionActionURL
			).build()
		%>'
	/>
</commerce-ui:modal-content>