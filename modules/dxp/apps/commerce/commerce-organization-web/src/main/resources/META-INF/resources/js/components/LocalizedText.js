import React, { Fragment } from 'react'
import { getLocalizedText } from "../utils/utils";

export default function LocalizedText(props) {
	return(
		<Fragment>
			{ getLocalizedText(props.children) }
		</Fragment>
	)
}
