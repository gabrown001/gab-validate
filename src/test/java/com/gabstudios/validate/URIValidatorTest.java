/*****************************************************************************************
 *
 * Copyright 2015-2025 Gregory Brown. All Rights Reserved.
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

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A test class for the URIValidator. This class contains unit tests to validate the functionality of the URIValidator,
 * including tests for allow/deny lists, protocol restrictions, port validations, length checks, null/empty checks, and
 * equality tests.
 *
 * @author Gregory Brown (sysdevone)
 */
public class URIValidatorTest {
    private static final String HTTPS_LOCALHOST = "https://localhost";
    private static final String HTTP_LOCALHOST = "http://localhost";
    private static final String HTTPS_LOCALHOST_NON_STANDARD_PORT = "https://localhost:8443";

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAllowList() {
        String urlString = HTTPS_LOCALHOST;
        String valueString = HTTPS_LOCALHOST;
        try {
            URI uri = new URI(urlString);
            Validate.defineURI(uri).testMatchAllowDomain(valueString).throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(true);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        } catch (MalformedURLException e) {
            Assertions.fail(e.toString());
        } catch (UnknownHostException e) {
            Assertions.fail(e.toString());
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testDenyList() {
        String urlString = HTTPS_LOCALHOST;
        String valueString = HTTPS_LOCALHOST;
        try {
            URI uri = new URI(urlString);
            Validate.defineURI(uri).testMatchDenyDomain(valueString).throwValidationExceptionOnFail().validate();
            Assertions.fail("Expected validation to fail when the URL matches the deny list.");
        } catch (final ValidateException e) {
            Assertions.assertTrue(true);
        } catch (MalformedURLException e) {
            Assertions.fail(e.toString());
        } catch (UnknownHostException e) {
            Assertions.fail(e.toString());
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }
    }

    @Test
    public void testDenyListOctal() {
        String urlString = HTTPS_LOCALHOST;
        String valueString = "https%3A%2F%2Flocalhost";
        try {
            URI uri = new URI(urlString);
            Validate.defineURI(uri).testMatchDenyDomain(valueString).throwValidationExceptionOnFail().validate();
            Assertions.fail("Expected validation to fail when the URL matches the deny list.");
        } catch (final ValidateException e) {
            Assertions.assertTrue(true);
        } catch (MalformedURLException e) {
            Assertions.fail(e.toString());
        } catch (UnknownHostException e) {
            Assertions.fail(e.toString());
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }
    }

    @Test
    public void testEquals() {
        String urlString = HTTPS_LOCALHOST;
        try {
            URI uri = new URI(urlString);
            boolean retVal = Validate.defineURI(uri).testEquals(urlString).throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testMaxLength() {
        String urlString = HTTPS_LOCALHOST;

        try {
            URI uri = new URI(urlString);
            boolean retVal = Validate.defineURI(uri).testMaxLength(urlString.length()).throwValidationExceptionOnFail()
                    .validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testMinLength() {

        String urlString = HTTPS_LOCALHOST;

        try {
            URI uri = new URI(urlString);
            boolean retVal = Validate.defineURI(uri).testMinLength(8).throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNotNullEmpty() {

        String urlString = HTTPS_LOCALHOST;

        try {
            URI uri = new URI(urlString);
            boolean retVal = Validate.defineURI(uri).testNotNullEmpty().throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }
    }

    @Test
    public void testNotNull() {

        String urlString = HTTPS_LOCALHOST;

        try {
            URI uri = new URI(urlString);
            boolean retVal = Validate.defineURI(uri).testNotNull().throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }
    }

    @Test
    public void testAllowedProtocols() {

        String urlString = HTTPS_LOCALHOST;

        try {
            URI uri = new URI(urlString);
            boolean retVal = Validate.defineURI(uri).allowProtocols("https").throwValidationExceptionOnFail()
                    .validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }
    }

    @Test
    public void testAllowedProtocolsFails() {
        String urlString = HTTP_LOCALHOST;
        try {
            URI uri = new URI(urlString);
            Validate.defineURI(uri).allowProtocols("https").throwValidationExceptionOnFail()
                    .validate();
            // Corrected: boolean first, then message
            Assertions.fail("Expected protocol restriction to fail validation.");
        } catch (final ValidateException e) {
            Assertions.assertTrue(true);
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }
    }

    @Test
    public void testAllowedPorts() {

        String urlString = HTTPS_LOCALHOST;

        try {
            URI uri = new URI(urlString);
            boolean retVal = Validate.defineURI(uri).allowPorts(443).throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }
    }

    @Test
    public void testAllowedPortsFails() {

        String urlString = HTTPS_LOCALHOST_NON_STANDARD_PORT;

        try {
            URI uri = new URI(urlString);
            Validate.defineURI(uri).allowPorts(443).throwValidationExceptionOnFail().validate();
            Assertions.fail("Expected validation to fail for mismatched port.");
        } catch (final ValidateException e) {
            Assertions.assertTrue(true);
        } catch (URISyntaxException e) {
            Assertions.fail(e.toString());
        }
    }

}
