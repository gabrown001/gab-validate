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
 * A test class for the IntegerValidator
 *
 * @author Gregory Brown (sysdevone)
 */
public class IntegerValidatorTest {
    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testToString() {
        int x = 5;
        try {
            String desc = Validate.defineInteger(x).toString();
            Assertions.assertTrue(desc != null && desc.length() != 0);
        } catch (final Exception e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testGetValue() {
        int x = 5;
        try {
            int retVal = Validate.defineInteger(x).getValue();
            Assertions.assertEquals(x, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNoTest() {
        int x = 5;
        try {
            boolean retVal = Validate.defineInteger(x).throwValidationExceptionOnFail().validate();
            Assertions.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNoTest2() {
        int x = 5;
        try {
            boolean retVal = Validate.defineInteger(x).validate();
            Assertions.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testMaxValue() {

        try {
            int x = 5;
            int max = 10;
            boolean retVal = Validate.defineInteger(x).testMaxValue(max).throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testMinLength() {

        try {
            int x = 5;
            int min = 4;
            boolean retVal = Validate.defineInteger(x).testMinValue(min).throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testEquals() {

        try {
            int x = 5;
            int y = 5;
            boolean retVal = Validate.defineInteger(x).testEquals(y).throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testZeroValue() {

        try {
            int x = 0;
            boolean retVal = Validate.defineInteger(x).isZeroValue().throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testPositiveValue() {

        try {
            int x = 5;
            boolean retVal = Validate.defineInteger(x).isPositiveValue().throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNegativeValue() {

        try {
            int x = -5;
            boolean retVal = Validate.defineInteger(x).isNegativeValue().throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

}
