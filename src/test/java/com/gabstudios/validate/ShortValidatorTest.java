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
 * A test class for the ShortValidator
 *
 * @author Gregory Brown (sysdevone)
 */
public class ShortValidatorTest {
    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testToString() {
        short x = 5;
        try {
            String desc = Validate.defineShort(x).toString();
            Assertions.assertTrue(desc != null && desc.length() != 0);
        } catch (final Exception e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testGetValue() {
        short x = 5;
        try {
            short retVal = Validate.defineShort(x).getValue();
            Assertions.assertEquals(x, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNoTest() {
        short x = '5';
        try {
            boolean retVal = Validate.defineShort(x).throwValidationExceptionOnFail().validate();
            Assertions.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNoTest2() {
        short x = '5';
        try {
            boolean retVal = Validate.defineShort(x).validate();
            Assertions.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testMaxValue() {

        try {
            short x = 5;
            short max = 10;
            boolean retVal = Validate.defineShort(x).testMaxValue(max).throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testMinLength() {

        try {
            short x = 5;
            short min = 4;
            boolean retVal = Validate.defineShort(x).testMinValue(min).throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testEquals() {

        try {
            short x = 5;
            short y = 5;
            boolean retVal = Validate.defineShort(x).testEquals(y).throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testZeroValue() {

        try {
            short x = 0;
            boolean retVal = Validate.defineShort(x).isZeroValue().throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testPositiveValue() {

        try {
            short x = 5;
            boolean retVal = Validate.defineShort(x).isPositiveValue().throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNegativeValue() {

        try {
            short x = -5;
            boolean retVal = Validate.defineShort(x).isNegativeValue().throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

}
