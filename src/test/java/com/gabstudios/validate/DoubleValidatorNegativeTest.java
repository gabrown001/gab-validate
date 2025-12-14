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
 * A test class for the DoubleValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class DoubleValidatorNegativeTest {
    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMaxValue() {

        double x = 5;
        double max = 4;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineDouble(x).testMaxValue(max).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMaxValue2() {

        try {
            double x = 5;
            double max = 4;
            boolean retVal = Validate.defineDouble(x).testMaxValue(max).validate();

            Assertions.assertEquals(false, retVal);
        } catch (final ValidateException e) {
            Assertions.fail();
        }

    }

    @Test
    public void testMinLength() {

        double x = 5;
        double min = 7;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineDouble(x).testMinValue(min).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMinLength2() {

        try {
            double x = 5;
            double min = 7;
            boolean retVal = Validate.defineDouble(x).testMinValue(min).validate();

            Assertions.assertEquals(false, retVal);
        } catch (final ValidateException e) {
            Assertions.assertTrue(false);
        }

    }

    @Test
    public void testEquals() {
        double x = 5;
        double y = 6;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineDouble(x).testEquals(y).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testEquals2() {

        try {
            double x = 5;
            double y = 6;
            boolean retVal = Validate.defineDouble(x).testEquals(y).validate();

            Assertions.assertEquals(false, retVal);
        } catch (final ValidateException e) {
            Assertions.assertTrue(false);
        }

    }

    @Test
    public void testZeroValue() {

        double x = 5;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineDouble(x).isZeroValue().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testPositiveValue() {

        double x = -5;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineDouble(x).isPositiveValue().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testNegativeValue() {

        double x = 5;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineDouble(x).isNegativeValue().throwValidationExceptionOnFail().validate());

    }

}
