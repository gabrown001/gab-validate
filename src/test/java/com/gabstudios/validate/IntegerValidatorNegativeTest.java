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
public class IntegerValidatorNegativeTest {
    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMaxValue() {

        int x = 5;
        int max = 4;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineInteger(x).testMaxValue(max).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMinLength() {

        int x = 5;
        int min = 7;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineInteger(x).testMinValue(min).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testEquals() {
        int x = 5;
        int y = 6;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineInteger(x).testEquals(y).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testZeroValue() {

        int x = 5;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineInteger(x).isZeroValue().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testPositiveValue() {

        int x = -5;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineInteger(x).isPositiveValue().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testNegativeValue() {

        int x = 5;
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineInteger(x).isNegativeValue().throwValidationExceptionOnFail().validate());

    }

}
