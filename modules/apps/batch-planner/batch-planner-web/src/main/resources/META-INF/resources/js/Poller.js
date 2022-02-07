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

import {useIsMounted} from '@liferay/frontend-js-react-web';
import {fetch} from 'frontend-js-web';
import {useCallback, useEffect, useReducer} from 'react';

import {
	EXPORT_FILE_NAME,
	HEADERS,
	POLL_INTERVAL,
	PROCESS_COMPLETED,
	PROCESS_FAILED,
} from './constants';

const ERROR = 'ERROR';
const COMPLETED = 'COMPLETED';
const LOADING = 'LOADING';
const PROGRESS = 'PROGRESS';
const START_POLLING = 'START_POLLING';
const STOP_LOADING = 'DOWNLOADING';

const initialState = {
	contentType: null,
	errorMessage: null,
	loading: false,
	percentage: 0,
	pollingIntervalId: null,
	ready: false,
	taskId: null,
};

const setError = (error) => ({
	payload: error ?? Liferay.Language.get('unexpected-error'),
	type: ERROR,
});

const setTaskId = (contentType, taskId) => ({
	payload: {contentType, taskId},
	type: COMPLETED,
});

const setProgress = (contentType, percentage) => ({
	payload: {contentType, percentage},
	type: PROGRESS,
});

export async function startTask(formDataQuerySelector, formSubmitURL) {
	const mainFormData = document.querySelector(formDataQuerySelector);

	const formData = new FormData(mainFormData);

	const response = await fetch(formSubmitURL, {
		body: formData,
		headers: HEADERS,
		method: 'POST',
	});

	if (!response.ok) {
		throw new Error(response);
	}

	return await response.json();
}

export async function getTaskStatus({
	onFail,
	onProgress,
	onSuccess,
	requestTaskStatus,
	taskId,
}) {
	try {
		const {
			contentType,
			errorMessage,
			executeStatus,
			processedItemsCount,
			totalItemsCount,
		} = await requestTaskStatus(taskId);

		switch (executeStatus) {
			case PROCESS_FAILED:
				onFail(
					errorMessage || Liferay.Language.get('unexpected-error')
				);
				break;
			case PROCESS_COMPLETED:
				onSuccess(contentType);
				break;
			default:
				onProgress(
					contentType,
					totalItemsCount === 0
						? 0
						: Math.round(
								(processedItemsCount / totalItemsCount) * 100
						  )
				);
		}
	}
	catch (error) {
		onFail(Liferay.Language.get('unexpected-error'));
	}
}

const reducer = (state = initialState, {payload, type}) => {
	switch (type) {
		case STOP_LOADING:
			return {
				...state,
				loading: false,
			};
		case LOADING:
			return {
				...state,
				loading: true,
			};
		case ERROR:
			clearInterval(state.pollingIntervalId);

			return {
				...state,
				errorMessage: payload,
				loading: false,
				pollingIntervalId: null,
			};
		case COMPLETED:
			clearInterval(state.pollingIntervalId);

			return {
				...state,
				contentType: payload.contentType,
				loading: false,
				percentage: 100,
				pollingIntervalId: null,
				ready: true,
				taskId: payload.taskId,
			};
		case PROGRESS:
			return {
				...state,
				contentType: payload.contentType,
				percentage: payload.percentage,
			};
		case START_POLLING:
			return {
				...state,
				pollingIntervalId: payload,
			};
		default:
			return state;
	}
};

const Poller = (
	formDataQuerySelector,
	formSubmitURL,
	requestTaskStatus,
	requestTaskFile
) => {
	const isMounted = useIsMounted();
	const [state, dispatch] = useReducer(reducer, initialState);

	const dispatchIfMounted = useCallback(
		(action) => {
			if (isMounted()) {
				dispatch(action);
			}
		},
		[dispatch, isMounted]
	);

	const download = (url, filename) => {
		var a = document.createElement('a');
		document.body.appendChild(a);
		a.style.display = 'none';
		a.href = url;
		a.download = filename;
		a.click();
		window.URL.revokeObjectURL(url);
	};

	const downloadFile = useCallback(async () => {
		dispatchIfMounted({type: LOADING});
		try {
			const blobUrl = await requestTaskFile(state.taskId);

			download(blobUrl, EXPORT_FILE_NAME);

			dispatchIfMounted({type: STOP_LOADING});
		}
		catch (error) {
			console.error(error);
			dispatchIfMounted(setError());
		}
	}, [dispatchIfMounted, requestTaskFile, state.taskId]);

	useEffect(() => {
		let pollingIntervalId;

		async function callStartTask() {
			dispatchIfMounted({type: LOADING});

			try {
				const {error, exportTaskId, importTaskId} = await startTask(
					formDataQuerySelector,
					formSubmitURL
				);

				if (error) {
					dispatchIfMounted(setError(error));
				}

				pollingIntervalId = setInterval(
					() =>
						getTaskStatus({
							onFail: (error) =>
								dispatchIfMounted(setError(error)),
							onProgress: (contentType, percent) =>
								dispatchIfMounted(
									setProgress(contentType, percent)
								),
							onSuccess: (contentType) =>
								dispatchIfMounted(
									setTaskId(
										contentType,
										exportTaskId || importTaskId
									)
								),
							requestTaskStatus,
							taskId: exportTaskId || importTaskId,
						}),
					POLL_INTERVAL
				);

				dispatchIfMounted({
					payload: pollingIntervalId,
					type: START_POLLING,
				});
			}
			catch (error) {
				console.error(error);
				dispatchIfMounted(setError());
			}
		}

		callStartTask();

		return () => {
			if (pollingIntervalId) {
				clearInterval(pollingIntervalId);
			}
		};
	}, [
		dispatchIfMounted,
		formDataQuerySelector,
		formSubmitURL,
		isMounted,
		requestTaskStatus,
	]);

	return {
		contentType: state.contentType,
		downloadFile,
		errorMessage: state.errorMessage,
		loading: state.loading,
		percentage: state.percentage,
		ready: state.ready,
	};
};

export default Poller;
