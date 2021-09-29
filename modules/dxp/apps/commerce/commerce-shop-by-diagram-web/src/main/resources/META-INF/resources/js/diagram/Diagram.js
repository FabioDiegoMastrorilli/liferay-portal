/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import classNames from 'classnames';
import PropTypes from 'prop-types';
import React, {useEffect, useLayoutEffect, useRef, useState} from 'react';

import DiagramHandler from './DiagramHandler';
import DiagramFooter from './components/DiagramFooter';
import DiagramHeader from './components/DiagramHeader';
import Sequence from './components/Sequence';
import Tooltip from './components/Tooltip';
import { DEFAULT_PINS_RADIUS } from './utilities/constants';
import {loadPins} from './utilities/data';

import '../../css/diagram.scss';

function Diagram({imageURL, productId}) {
	const svgRef = useRef(null);
	const zoomHandlerRef = useRef(null);
	const wrapperRef = useRef(null);
	const chartInstance = useRef(null);
	const [pins, updatePins] = useState(null);
	const [pinsRadius, updatePinsRadius] = useState(DEFAULT_PINS_RADIUS);
	const [pinsNodes, updatePinsNodes] = useState([]);
	const [tooltipData, setTooltipData] = useState(false);
	const [currentZoom, updateCurrentZoom] = useState(1);
	const [expanded, updateExpanded] = useState(false);
	const [selectedText, updateSelectedText] = useState(null);
	const [highlightedText, updateHighlightedText] = useState(null);

	useEffect(() => {
		loadPins(productId).then(updatePins);
	}, [productId]);

	useEffect(() => {
		if(pins) {
			chartInstance.current?.updatePins(pins);
		}
	}, [pins]);

	useEffect(() => {
		chartInstance.current?.updatePinsRadius(pinsRadius);
	}, [pinsRadius])

	useEffect(() => {
		if (!tooltipData) {
			updateSelectedText(null);
		}
	}, [tooltipData]);

	useEffect(() => {
		function handleClickOnLabel(event) {
			const sequence = event.target.textContent;

			const selectedPin = pins.find((pin) => pin.sequence === sequence);

			setTooltipData({selectedPin, sequence, x: event.x, y: event.y});
			updateSelectedText(event.target);
		}

		function handleMouseEnterOnLabel(event) {
			updateHighlightedText(event.target);
		}

		function handleMouseLeaveOnLabel() {
			updateHighlightedText(null);
		}

		pinsNodes.forEach((label) => {
			label.addEventListener('click', handleClickOnLabel);
			label.addEventListener('mouseenter', handleMouseEnterOnLabel);
			label.addEventListener('mouseleave', handleMouseLeaveOnLabel);
		});

		return () => {
			pinsNodes.forEach((label) => {
				label.removeEventListener('click', handleClickOnLabel);
				label.removeEventListener(
					'mouseenter',
					handleMouseEnterOnLabel
				);
				label.removeEventListener(
					'mouseleave',
					handleMouseLeaveOnLabel
				);
			});
		};
	}, [pinsNodes]);

	useLayoutEffect(() => {
		chartInstance.current = new DiagramHandler(
			svgRef.current,
			zoomHandlerRef.current,
			imageURL,
			updatePinsNodes,
			(scale) => {
				setTooltipData(null);

				updateCurrentZoom(scale);
			},
			(x, y) => {
				setTooltipData({x, y});
			} 
		);
	}, [imageURL]);

	return (
		<div className={classNames('shop-by-diagram', {expanded})} ref={wrapperRef}>
			<DiagramHeader
				pinsRadius={pinsRadius}
				updatePinsRadius={updatePinsRadius}
			/>

			<div className="bg-white border-bottom border-top view-wrapper">
				<svg className="svg-wrapper" ref={svgRef}>
					<g className="zoom-handler" ref={zoomHandlerRef} />
				</svg>
			</div>

			<DiagramFooter
				chartInstance={chartInstance}
				currentZoom={currentZoom}
				expanded={expanded}
				updateCurrentZoom={updateCurrentZoom}
				updateExpanded={updateExpanded}
			/>

			{highlightedText && (
				<Sequence highlighted={true} source={highlightedText} />
			)}

			{selectedText && <Sequence source={selectedText} />}

			{tooltipData && (
				<Tooltip
					closeTooltip={() => setTooltipData(null)}
					containerRef={wrapperRef}
					expanded={expanded}
					productId={productId}
					updatePins={updatePins}
					{...tooltipData}
				/>
			)}
		</div>
	);
}

Diagram.propTypes = {
	diagramId: PropTypes.string.isRequired,
	imageURL: PropTypes.string.isRequired,
	isAdmin: PropTypes.bool.isRequired,
	productId: PropTypes.string.isRequired,
};

export default Diagram;
