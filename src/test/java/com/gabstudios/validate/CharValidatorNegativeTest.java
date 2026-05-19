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
 * A negative test class for the CharValidator
 *
 * @author Gregory Brown (sysdevone)
 */
public class CharValidatorNegativeTest {
    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMaxValue() {

        char x = '5';
        char max = '4';
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineChar(x).testMaxValue(max).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testMinLength() {

        char x = '5';
        char min = '8';
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineChar(x).testMinValue(min).throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testEquals() {

        try {
            char x = 'A';
            char y = 'a';
            boolean retVal = Validate.defineChar(x).testEquals(y).throwValidationExceptionOnFail().validate();

            Assertions.assertEquals(false, retVal);
        } catch (final ValidateException e) {
            Assertions.assertTrue(true);
        }

    }

    @Test
    public void testIsDigit() {

        char x = '#';
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineChar(x).testIsDigit().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testIsLowerCase() {
        char x = 'A';
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineChar(x).testIsLowerCase().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testIsUpperCase() {

        char x = 'a';
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineChar(x).testIsUpperCase().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testIsWhitespace() {
        char x = 'A';
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineChar(x).testIsWhitespace().throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testNotEmpty() {
        char x = '\0';
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineChar(x).testNotEmpty().throwValidationExceptionOnFail().validate());

    }

}
