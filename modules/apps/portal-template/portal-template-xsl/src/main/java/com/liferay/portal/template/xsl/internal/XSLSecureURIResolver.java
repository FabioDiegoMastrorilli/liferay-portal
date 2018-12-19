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

package com.liferay.portal.template.xsl.internal;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.InetAddressUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.xsl.XSLURIResolver;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;

/**
 * @author Marta Medio
 */
public class XSLSecureURIResolver implements XSLURIResolver {

	public XSLSecureURIResolver(XSLURIResolver xsluriResolver) {
		_xsluriResolver = xsluriResolver;
	}

	@Override
	public String getLanguageId() {
		return _xsluriResolver.getLanguageId();
	}

	@Override
	public Source resolve(String href, String base)
		throws TransformerException {

		try {
			URL url = new URL(href);

			if (InetAddressUtil.isLocalInetAddress(
					InetAddress.getByName(url.getHost()))) {

				_log.error(
					StringBundler.concat(
						"Denied access to resource: ", href,
						". Access to local network is disabled by the secure ",
						"processing feature."));

				return null;
			}

			return _xsluriResolver.resolve(href, base);
		}
		catch (MalformedURLException | UnknownHostException e) {
			throw new TransformerException("Error resolving URL reference", e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		XSLSecureURIResolver.class);

	private final XSLURIResolver _xsluriResolver;

}