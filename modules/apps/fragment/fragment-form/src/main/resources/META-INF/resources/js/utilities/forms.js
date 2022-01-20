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

import {State} from '@liferay/frontend-js-state-web';

import formsEvaluatorsAtom from "../atoms/formsEvaluatorsAtom";
import inputsLibraryAtom from "../atoms/inputsLibraryAtom";

export function evaluateForm(form) {
  const inputs = State.read(inputsLibraryAtom).get(form);
  const evaluate = State.read(formsEvaluatorsAtom).get(form);

  if (inputs && evaluate) {
    return evaluate(inputs);
  }

  return null;
};

export function getFormId(domNode, inputName) {
  const form = domNode.tagName === 'form'
    ? domNode
    : domNode.closest('form');

  if (!form && inputName) {
    throw new Error(`No wrapper form found for input '${inputName}'`);
  }

  if (!form && inputName) {
    throw new Error('No wrapper form found');
  }

  return form.id || 'default';
}

export function registerInputToForm(formId, name, value, setDisabled, setHidden) {
  const formsInputs = State.read(inputsLibraryAtom);

  const updatedFormsInputs = new Map(formsInputs);

  let formInputs = updatedFormsInputs.get(formId);

  if (!formInputs) {
    formInputs = new Map();

    updatedFormsInputs.set(formId, formInputs)
  }

  const inputDetails = {
    setDisabled,
    setHidden,
    value,
  };

  formInputs.set(name, inputDetails);

  State.write(inputsLibraryAtom, updatedFormsInputs);

  return {
    cleanup: () => formInputs.delete(name),
    update: (newValue) => {
      const formsInputs = State.read(inputsLibraryAtom);

      const updatedFormsInputs = new Map(formsInputs);
    
      const formInputs = updatedFormsInputs.get(formId);

      formInputs.set(name, {
        ...inputDetails,
        value: newValue,
      });

      State.write(inputsLibraryAtom, updatedFormsInputs);

      evaluateForm(formId);
    },
  };
}

const checkValidity = (data, operator, match) => {
  switch (operator) {
    case 'eq':
      return data === match;
    case 'contains':
      return data.includes(match);
    default:
      break;
  }

  return false;
};

const exceptionsSettersMap = {
  disabled: 'setDisabled',
  hidden: 'setHidden',
};

const updateInput = (exceptionType, targetInputDetails, checkPassed) => {
  const setter = targetInputDetails[exceptionsSettersMap[exceptionType]];

  setter(!checkPassed);
};

const evaluateRule = (rule, inputs) => {
  const listenerDetails = inputs.get(rule.listener);
  const actionTargetDetails = inputs.get(rule.actionTarget);

  if (!actionTargetDetails) {
    return false;
  }

  const result = listenerDetails
    ? checkValidity(
      listenerDetails.value,
      rule.operator,
      rule.match,
      listenerDetails.errors,
    )
    : false;

  return updateInput(rule.exceptionType, actionTargetDetails, result);
};

const createFormEvaluator = (rules) => (inputs) => {
  rules.forEach((rule) => {
    evaluateRule(rule, inputs);
  });
};

export function initializeLiferayForm(formId, rules) {
  const formsEvaluators = State.read(formsEvaluatorsAtom);

  const updatedFormsEvaluators = new Map(formsEvaluators);

  updatedFormsEvaluators.set(formId, createFormEvaluator(rules));

  State.write(formsEvaluatorsAtom, updatedFormsEvaluators);

  evaluateForm(formId);
}
