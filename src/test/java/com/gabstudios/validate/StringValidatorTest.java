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

import org.junit.jupiter.api.*;

/**
 * A test class for the StringValidator
 *
 * @author Gregory Brown (sysdevone)
 */
public class StringValidatorTest {
    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testToString() {
        String x = "5";
        try {
            String desc = Validate.defineString(x).toString();
            Assertions.assertTrue(desc != null && desc.length() != 0);
        } catch (final Exception e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testGetValue() {
        String x = "5";
        try {
            String retVal = (String) Validate.defineString(x).getValue();
            Assertions.assertEquals(x, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNoTest() {
        String x = "5";
        try {
            boolean retVal = Validate.defineString(x).throwValidationExceptionOnFail().validate();
            Assertions.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNoTest2() {
        String x = "5";
        try {
            boolean retVal = Validate.defineString(x).validate();
            Assertions.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testMaxLength() {

        try {
            boolean retVal = Validate.defineString("HelloWorld").testMaxLength(10).throwValidationExceptionOnFail()
                    .validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testMinLength() {

        try {
            boolean retVal = Validate.defineString("HelloWorld").testMinLength(8).throwValidationExceptionOnFail()
                    .validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNotNullEmpty() {

        try {
            boolean retVal = Validate.defineString("HelloWorld").testNotNullEmpty().throwValidationExceptionOnFail()
                    .validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNotNull() {

        try {
            boolean retVal = Validate.defineString("HelloWorld").testNotNull().throwValidationExceptionOnFail()
                    .validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testEquals() {
        StringValidator stringValidator = Validate.defineString("HelloWorld");
        try {
            stringValidator.testEquals("HelloWorld").throwValidationExceptionOnFail();
            System.err.println(stringValidator.toString());
            boolean retVal = stringValidator.validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }
    }

    @Test
    public void testEqualsNoCase() {
        StringValidator stringValidator = Validate.defineString("HelloWorld");
        try {

            stringValidator.testEqualsNoCase("hELLOwORLD").throwValidationExceptionOnFail();
            System.err.println(stringValidator.toString());
            boolean retVal = stringValidator.validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testMatch() {

        try {
            boolean retVal = Validate.defineString("HelloWorld").testMatch("HelloWorld")
                    .throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testMatch2() {

        try {
            boolean retVal = Validate.defineString("HelloWorld").testMatch("[A-Za-z]*").throwValidationExceptionOnFail()
                    .validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

}
