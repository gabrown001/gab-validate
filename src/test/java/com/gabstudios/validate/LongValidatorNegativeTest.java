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
 * A test class for the LongValidator
 *
 * @author Gregory Brown (sysdevone)
 */
public class LongValidatorNegativeTest {
    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMaxValue() {
        long x = 5;
        long max = 4;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineLong(x).testMaxValue(max).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMinLength() {
        long x = 5;
        long min = 7;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineLong(x).testMinValue(min).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testEquals() {
        long x = 5;
        long y = 6;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineLong(x).testEquals(y).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testZeroValue() {

        long x = 5;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineLong(x).isZeroValue().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testPositiveValue() {

        long x = -5;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineLong(x).isPositiveValue().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testNegativeValue() {

        long x = 5;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineLong(x).isNegativeValue().throwValidationExceptionOnFail().validate());

    }

}
