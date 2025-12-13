 /*****************************************************************************************
 *
 * Copyright 2022-2025 Gregory Brown. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 *****************************************************************************************
 */


package com.gabstudios.validate;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is a URI validator. After this class is created, call the testXXXX()
 * methods to perform tests when the validate() method is called.
 * 
 * Validate.defineURI(URI).testMatchAllowDomain('my.domain.com').validate();
 *
 * If the throwValidationExceptionOnFail() method has been called and if the
 * validate fails then a ValidateException will be thrown.
 * 
 * Validate.defineURI(URI).testMatchAllowDomain('my.domain.com')
 * .throwValidationExceptionOnFail().validate();
 *
 * If no test method is called, validate() returns a TRUE.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public final class URIValidator extends StringValidator {

	/*
	 * A flag indicating if an "Match Allow List" test will be performed when the
	 * validate() method is called.
	 */
	private boolean _isTestMatchAllowList = false;

	/*
	 * A flag indicating if an "Match Deny List" test will be performed when the
	 * validate() method is called.
	 */
	private boolean _isTestMatchDenyList = false;

	private Set<InetAddress> _allowList = new HashSet<>();
	private Set<InetAddress> _denyList = new HashSet<>();
	private Set<String> _allowedProtocols = new HashSet<>();
	private Set<Integer> _allowedPorts = new HashSet<>();

	private URI _uri;
	private InetAddress _address;


	protected URIValidator(final URI value) {
		super(value.toString());
		this._uri = value;
	}

	// allow list
	// List<String> URLs
	// List<URLs>
	public URIValidator testMatchAllowDomain(final String domain) throws MalformedURLException, UnknownHostException, URISyntaxException {
		final URI uri = new URI(domain);
		testMatchAllowDomain(uri);
		return (this);
	}

	public URIValidator testMatchAllowDomain(final URI uri) throws UnknownHostException {
		//fixme: need to convert to ipaddress for deny name
		if (this._isTestMatchDenyList) {
			throw (new IllegalStateException(
					"Attempting to set the allow list wnen the deny list has already been defined.  Only one list can be used at a time either allow or the deny list."));
		} else {
			final InetAddress address = InetAddress.getByName(uri.getHost());
			this._allowList.add(address);
			this._isTestMatchAllowList = true;
			return (this);
		}
	}

	// deny list
	// List<String> URLs
	// List<URLs>
	public URIValidator testMatchDenyDomain(final String domain) throws MalformedURLException, UnknownHostException, URISyntaxException {
		final URI uri = new URI(domain);
		testMatchDenyDomain(uri);
		return (this);
	}

	public URIValidator testMatchDenyDomain(final URI uri) throws UnknownHostException {
		if (this._isTestMatchAllowList) {
			throw (new IllegalStateException(
					"Attempting to set the deny list wnen the allow list has already been defined.  Only one list can be used at a time either allow or the deny list."));
		} else {
			final InetAddress address = InetAddress.getByName(uri.getHost());
			this._denyList.add(address);
			this._isTestMatchDenyList = true;
			return (this);
		}
	}

	/**
	 * Restricts validation to the provided protocols (case insensitive).
	 *
	 * @param protocols
	 *            Protocol names - e.g. "https".
	 * @return This validator for chaining.
	 */
	public URIValidator allowProtocols(final String... protocols) {
		validateVarargInput(protocols, "protocols");
		Arrays.stream(protocols).forEach(protocol -> {
			if (protocol == null || protocol.trim().isEmpty()) {
				throw new IllegalArgumentException("Each protocol entry must be non-null and non-empty.");
			}
			this._allowedProtocols.add(protocol.trim().toLowerCase());
		});
		return this;
	}

	/**
	 * Restricts validation to the provided ports.
	 *
	 * @param ports
	 *            Port numbers (0-65535).
	 * @return This validator for chaining.
	 */
	public URIValidator allowPorts(final Integer... ports) {
		validateVarargInput(ports, "ports");
		Arrays.stream(ports).forEach(port -> {
			if (port == null || port < 0 || port > 65535) {
				throw new IllegalArgumentException("Each port entry must be inside the valid TCP range (0-65535).");
			}
			this._allowedPorts.add(port);
		});
		return this;
	}

	private void validateVarargInput(final Object[] values, final String parameterName) {
		if (values == null || values.length == 0) {
			throw new IllegalArgumentException(
					"The parameter '" + parameterName + "' must not be null and must contain at least one entry.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gabstudios.gabvalidate.Validator#validate()
	 */
	@Override
	public boolean validate() {
		// validate allow list
		boolean isValid = super.validate();

		isValid = (!isValid ? false : validateAddress());
		if (isValid) {
			// System.out.println("start result: " + isValid + " : " + this._url + " : " +
			// this._address);
			if (this._isTestMatchAllowList) {
				isValid = validateAllowList();
				// System.out.println("allow result: " + isValid);
			}

			// allowed protocols
			isValid &= validateAllowedProtocols();
			// System.out.println("protocol result: " + isValid);

			// allowed ports
			isValid &= validateAllowedPorts();
			// System.out.println("protocol result: " + isValid);

			// validate deny list
			if (this._isTestMatchDenyList) {
				isValid &= validateDenyList();
				// System.out.println("deny result: " + isValid);
			}

		}

		// System.out.println("final result: " + isValid);
		return (isValid);
	}

	protected boolean validateAddress() {
		boolean isValid;
		try {
			this._address = InetAddress.getByName(this._uri.getHost());
			isValid = true;
		} catch (UnknownHostException ex) {
			isValid = false;
			if (this._isValidationExceptionThrownOnFail && !isValid) {
				ObjectValidator.throwValidateException(
						"The address (value = " + this._address + ") is an unknown host (value = '" + this._uri.getHost() + "').");
			}
		}
		return (isValid);
	}

	protected boolean validateAllowList() {
		boolean isValid = false;
		if( !this._allowList.isEmpty() )
		{
			for (final InetAddress address : this._allowList) {
				if (this._address.equals(address)) {
					isValid = true;
					break;
				}
			}

			if (this._isValidationExceptionThrownOnFail && !isValid) {
				ObjectValidator.throwValidateException(
						"The address does (value = " + this._address + "') not match the entries in the allow list (value = '" + this._allowList + "').");
			}
		}
		else
		{
			// if the allow list is empty, then we allow all protocols
			isValid = true;
		}

		return (isValid);
	}

	protected boolean validateDenyList() {

		boolean isValid = true;
		if( !this._denyList.isEmpty() )
		{
			for (final InetAddress address : this._denyList) {
				if (this._address.equals(address)) {
					isValid = false;
					break;
				}
			}

			if (this._isValidationExceptionThrownOnFail && !isValid) {
				ObjectValidator.throwValidateException(
						"The address (value = " + this._address + ") is present in the deny list (value = '" + this._denyList + "').");
			}
		}
		else
		{
			// if the allow list is empty, then we allow all protocols
			isValid = true;
		}
		return (isValid);
	}

	protected boolean validateAllowedProtocols() {
		boolean isValid = false;
		if( !this._allowedProtocols.isEmpty() )
		{
			final String scheme = (this._uri.getScheme() != null) ? this._uri.getScheme().toLowerCase() : "";
			for (final String allowedProtocol : this._allowedProtocols) {
				if (scheme.equals(allowedProtocol)) {
					isValid = true;
					break;
				}
			}
			if (this._isValidationExceptionThrownOnFail && !isValid) {
				ObjectValidator.throwValidateException(
						"The url protocol (value = '" + scheme + "') does not match the entries in the allow list (value = '" + this._allowedProtocols + "').");
			}
		}
		else
		{
			// if the allow list is empty, then we allow all protocols
			isValid = true;
		}

		// System.out.println("validate protocol result: " + isValid);
		return (isValid);
	}

	protected boolean validateAllowedPorts() {
		boolean isValid = false;
		if( !this._allowedPorts.isEmpty() )
		{
			final int port = resolvePort();
			for (final Integer allowedPort : this._allowedPorts) {
				if (port == allowedPort) {
					isValid = true;
					break;
				}
			}
			if (this._isValidationExceptionThrownOnFail && !isValid) {
				ObjectValidator.throwValidateException(
						"The url port (value = '" + port + "') does not match the entries in the allow list (value = '" + this._allowedPorts + "').");
			}
		}
		else
		{
			// if the allow list is empty, then we allow all protocols
			isValid = true;
		}
			// System.out.println("validate protocol result: " + isValid);
		return (isValid);
	}

	private int resolvePort() {
		int port = this._uri.getPort();
		if (port == -1) {
			try {
				port = this._uri.toURL().getDefaultPort();
			} catch (MalformedURLException e) {
				if (this._isValidationExceptionThrownOnFail) {
					ObjectValidator.throwValidateException("Unable to resolve the URI port (value = '" + this._uri + "').");
				}
			}
		}
		return port;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"URLValidator [_address=%s, _isTestMatchAllowList=%s, _isTestMatchDenyList=%s, _allowList=%s, _denyList=%s]",
				_address, _isTestMatchAllowList, _isTestMatchDenyList, _allowList, _denyList);
	}

}
