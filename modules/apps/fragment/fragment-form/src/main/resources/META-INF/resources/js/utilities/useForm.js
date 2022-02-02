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

import { useCallback, useEffect, useState } from 'react';

import { registerInputToForm } from './forms';

export default function useForm(
  form,
  name,
  initialValue,
) {
  const [value, setValue] = useState(initialValue);
  const [disabled, setDisabled] = useState(false);
  const [hidden, setHidden] = useState(false);
  const [notifyForm, setNotifyForm] = useState(null);

  useEffect(() => {
    const {
      cleanup,
      update,
    } = registerInputToForm(form, name, initialValue, setDisabled, setHidden);

    setNotifyForm(() => update);

    update(initialValue);

    return cleanup;
  }, [form, name, initialValue]);

  const updater = useCallback((callbackOrValue) => {
    if (callbackOrValue instanceof Function) {
      return setValue((prevValue) => {
        const newValue = callbackOrValue(prevValue);

        notifyForm(newValue);

        return newValue;
      });
    }

    notifyForm(callbackOrValue);

    return setValue(callbackOrValue);
  }, [notifyForm]);

  return {
	disabled,
	hidden,
	setValue: updater,
    value,
  };
}
