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

<%
ResultRow resultRow = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

BatchPlannerLogDisplay batchPlannerLogDisplay = (BatchPlannerLogDisplay)resultRow.getObject();
%>

<liferay-ui:icon-menu
	direction="right-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= batchPlannerLogDisplay.getFailedItemsCount() > 0 %>">
		<liferay-ui:icon
			message="download-error-report"
			onClick='<%= liferayPortletResponse.getNamespace() + "downloadErrorReport(" + batchPlannerLogDisplay.getBatchEngineImportTaskERC() + ")" %>'
			url="javascript:;"
		/>

		<aui:script>
			function <portlet:namespace />downloadErrorReport(batchEngineImportTaskId) {
				Liferay.Util.fetch(
					'/o/headless-batch-engine/v1.0/import-task/' +
						batchEngineImportTaskId +
						'/failed-items/report'
				)
					.then((response) => {
						return response.blob();
					})
					.then((blob) => {
						var url = URL.createObjectURL(blob);

						var a = document.createElement('a');
						a.href = url;

						a.download = 'filename.csv';

						document.body.appendChild(a);
						a.click();
						a.remove();
					});
			}
		</aui:script>
	</c:if>
</liferay-ui:icon-menu>