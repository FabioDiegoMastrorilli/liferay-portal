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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/commerce-ui" prefix="commerce-ui" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.commerce.constants.CommerceDefinitionTermConstants" %><%@
page import="com.liferay.commerce.notification.exception.CommerceNotificationTemplateFromException" %><%@
page import="com.liferay.commerce.notification.exception.CommerceNotificationTemplateNameException" %><%@
page import="com.liferay.commerce.notification.exception.CommerceNotificationTemplateTypeException" %><%@
page import="com.liferay.commerce.notification.model.CommerceNotificationTemplate" %><%@
page import="com.liferay.commerce.notification.type.CommerceNotificationType" %><%@
page import="com.liferay.commerce.notification.web.internal.display.context.CommerceNotificationQueueEntriesDisplayContext" %><%@
page import="com.liferay.commerce.notification.web.internal.display.context.CommerceNotificationTemplatesDisplayContext" %><%@
page import="com.liferay.commerce.notification.web.internal.frontend.CommerceNotificationEntryClayTable" %><%@
page import="com.liferay.commerce.notification.web.internal.frontend.CommerceNotificationTemplateClayTable" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.bean.BeanParamUtil" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.HashMapBuilder" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PropsUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@ page import="java.util.List" %><%@
page import="java.util.Map" %>

<%@ page import="javax.portlet.PortletURL" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />