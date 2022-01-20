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

import PropTypes from 'prop-types';
import React from 'react';

import { getFormId } from '../utilities/forms';
import useForm from '../utilities/useForm';

function Input({
  name,
  reactDOMContainer,
  value: initialValue,
}) {
  const {
    disabled, hidden, setValue, value,
  } = useForm(
    getFormId(reactDOMContainer, name),
    name,
    initialValue,
  );

  return !hidden && (
    <div>
      {name}

      <input
        autoComplete="off"
        disabled={disabled}
        name={name}
        onChange={(event) => setValue(event.target.value)}
        type="text"
        value={value}
      />
    </div>
  );
}

Input.defaultProps = {
  value: ''
}

Input.propTypes = {
  name: PropTypes.string.isRequired,
  reactDOMContainer: PropTypes.instanceOf(Element).isRequired,
  value: PropTypes.string,
};

export default Input;
