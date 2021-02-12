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

import classNames from 'classnames';
import {throttle} from 'frontend-js-web';
import PropTypes from 'prop-types';
import React, {useContext, useEffect, useMemo, useRef} from 'react';

import Context from './TableContext';

function Cell({children, className, columnName, expand, heading, resizable}) {
	const cellRef = useRef();
	const clientX = useRef({current: null});

	const {
		columnsDefinitions,
		draggingAllowed,
		draggingColumnName,
		isFixed,
		registerColumn,
		resizeColumn,
		updateDraggingAllowed,
		updateDraggingColumnName,
	} = useContext(Context);

	useEffect(() => {
		if (columnName && heading && !isFixed) {
			const {width} = cellRef.current.getClientRects()[0];

			registerColumn(columnName, width, resizable);
		}
	}, [columnName, isFixed, registerColumn, heading, resizable]);

	const resizeCol = useMemo(() => {
		return throttle((event) => {
			if (event.clientX === clientX.current || !cellRef.current) {
				return;
			}

			updateDraggingColumnName(columnName);

			clientX.current = event.clientX;

			const {x: headerCellX} = cellRef.current.getClientRects()[0];
			const newWidth = event.clientX - headerCellX;

			resizeColumn(columnName, newWidth, resizable);
		}, 20);
	}, [columnName, resizable, resizeColumn, updateDraggingColumnName]);

	function initializeDrag() {
		window.addEventListener('mousemove', resizeCol);
		window.addEventListener(
			'mouseup',
			() => {
				updateDraggingAllowed(true);
				updateDraggingColumnName(null);
				window.removeEventListener('mousemove', resizeCol);
			},
			{once: true}
		);
	}

	const width = useMemo(() => {
		const columnDetails = columnsDefinitions.get(columnName);

		return columnDetails && isFixed && columnDetails.width;
	}, [isFixed, columnsDefinitions, columnName]);

	return (
		<div
			className={classNames(
				heading ? 'dnd-th' : 'dnd-td',
				expand && 'expand',
				className
			)}
			ref={cellRef}
			style={{
				width,
			}}
		>
			{children}

			{resizable && (
				<span
					className={classNames('dnd-th-resizer', {
						'is-active': columnName === draggingColumnName,
						'is-allowed': draggingAllowed,
					})}
					onMouseDown={initializeDrag}
				/>
			)}
		</div>
	);
}

Cell.defaultProps = {
	expand: false,
	heading: false,
	resizable: false,
};

Cell.propTypes = {
	className: PropTypes.string,
	columnName: PropTypes.string,
	expand: PropTypes.bool,
	heading: PropTypes.bool,
	resizable: PropTypes.bool,
};

export default Cell;
