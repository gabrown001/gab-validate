/*****************************************************************************************
 *
 * Copyright 2015 Gregory Brown. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 *****************************************************************************************
 */

package com.gabstudios.validate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A test class for the StringValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class URIValidatorTest
{
	private static final String HTTPS_LOCALHOST = "https://localhost";
	private static final String HTTP_LOCALHOST = "http://localhost";
	private static final String HTTPS_LOCALHOST_NON_STANDARD_PORT = "https://localhost:8443";

	@Before
	public void setUp()
	{
		//
	}

	@After
	public void tearDown()
	{
		//
	}

	@Test
	public void testAllowList()
	{
		System.out.println("test: testAllowList");
		String urlString = HTTPS_LOCALHOST;
		String valueString = HTTPS_LOCALHOST;
		try
		{
			Validate.defineURL(urlString).testMatchAllowDomain(valueString).throwValidationExceptionOnFail().validate();
			Assert.assertTrue(true);
		}
		catch (final ValidateException e)
		{
			Assert.fail(e.toString());
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		} 
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}

	}

	@Test
	public void testDenyList()
	{		
		System.out.println("test: testDenyList");
		String urlString = HTTPS_LOCALHOST;
		String valueString = HTTPS_LOCALHOST;
		try
		{
			Validate.defineURL(urlString).testMatchDenyDomain(valueString).throwValidationExceptionOnFail().validate();
			Assert.fail("Expected validation to fail when the URL matches the deny list.");
		}
		catch (final ValidateException e)
		{
			Assert.assertTrue(true);
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		} 
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}
	}

	@Test
	public void testDenyListOctal()
	{		
		System.out.println("test: testDenyList");
		String urlString = HTTPS_LOCALHOST;
		String valueString = "https%3A%2F%2Flocalhost";
		try
		{
			Validate.defineURL(urlString).testMatchDenyDomain(valueString).throwValidationExceptionOnFail().validate();
			Assert.fail("Expected validation to fail when the URL matches the deny list.");
		}
		catch (final ValidateException e)
		{
			Assert.assertTrue(true);
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		} 
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}
	}

	@Test
	public void testEquals()
	{
		System.out.println("test: testEquals");
		String urlString = HTTPS_LOCALHOST;
		try
		{
			boolean retVal = Validate.defineURL(urlString).testEquals(urlString).throwValidationExceptionOnFail()
			        .validate();
			Assert.assertTrue(retVal);
		}
		catch (final ValidateException e)
		{
			Assert.fail(e.toString());
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		} 
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}

	}

	@Test
	public void testMaxLength()
	{
		System.out.println("test: testMaxLength");
		String urlString = HTTPS_LOCALHOST;

		try
		{
			boolean retVal = Validate.defineURL(urlString).testMaxLength(urlString.length()).throwValidationExceptionOnFail()
			        .validate();

			Assert.assertTrue(retVal);
		}
		catch (final ValidateException e)
		{
			Assert.fail(e.toString());
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		} 
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}

	}

	@Test
	public void testMinLength()
	{

		System.out.println("test: testMinLength");
		String urlString = HTTPS_LOCALHOST;

		try
		{
			boolean retVal = Validate.defineURL(urlString).testMinLength(8).throwValidationExceptionOnFail().validate();

			Assert.assertTrue(retVal);
		}
		catch (final ValidateException e)
		{
			Assert.fail(e.toString());
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		}
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}

	}

	@Test
	public void testNotNullEmpty()
	{

		System.out.println("test: testNotNullEmpty");
		String urlString = HTTPS_LOCALHOST;

		try
		{
			boolean retVal = Validate.defineURL(urlString).testNotNullEmpty().throwValidationExceptionOnFail()
			        .validate();

			Assert.assertTrue(retVal);
		}
		catch (final ValidateException e)
		{
			Assert.fail(e.toString());
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		}
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}
	}

	@Test
	public void testNotNull()
	{

		System.out.println("test: testNotNull");
		String urlString = HTTPS_LOCALHOST;

		try
		{
			boolean retVal = Validate.defineURL(urlString).testNotNull().throwValidationExceptionOnFail()
			        .validate();

			Assert.assertTrue(retVal);
		}
		catch (final ValidateException e)
		{
			Assert.fail(e.toString());
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		}
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}
	}

	@Test
	public void testAllowedProtocols()
	{

		System.out.println("test: testAllowedProtocols");
		String urlString = HTTPS_LOCALHOST;

		try
		{
			boolean retVal = Validate.defineURL(urlString).allowProtocols("https").throwValidationExceptionOnFail().validate();

			Assert.assertTrue(retVal);
		}
		catch (final ValidateException e)
		{
			Assert.fail(e.toString());
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		}
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}
	}

	@Test
	public void testAllowedProtocolsFails()
	{

		System.out.println("test: testAllowedProtocolsFails");
		String urlString = HTTP_LOCALHOST;

		try
		{
			Validate.defineURL(urlString).allowProtocols("https").throwValidationExceptionOnFail().validate();
			Assert.fail("Expected protocol restriction to fail validation.");
		}
		catch (final ValidateException e)
		{
			Assert.assertTrue(true);
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		}
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}
	}

	@Test
	public void testAllowedPorts()
	{

		System.out.println("test: testAllowedPorts");
		String urlString = HTTPS_LOCALHOST;

		try
		{
			boolean retVal = Validate.defineURL(urlString).allowPorts(443).throwValidationExceptionOnFail().validate();

			Assert.assertTrue(retVal);
		}
		catch (final ValidateException e)
		{
			Assert.fail(e.toString());
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		}
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}
	}

	@Test
	public void testAllowedPortsFails()
	{

		System.out.println("test: testAllowedPortsFails");
		String urlString = HTTPS_LOCALHOST_NON_STANDARD_PORT;

		try
		{
			Validate.defineURL(urlString).allowPorts(443).throwValidationExceptionOnFail().validate();
			Assert.fail("Expected validation to fail for mismatched port.");
		}
		catch (final ValidateException e)
		{
			Assert.assertTrue(true);
		}
		catch (MalformedURLException e)
		{
			Assert.fail(e.toString());
		}
		catch (UnknownHostException e)
		{
			Assert.fail(e.toString());
		}
		catch (URISyntaxException e) {
			Assert.fail(e.toString());
		}
	}

}
