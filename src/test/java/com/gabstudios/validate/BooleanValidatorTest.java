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
 * @author Gregory Brown (sysdevone)
 */
public class BooleanValidatorTest {
    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testToString() {
        try {
            String desc = Validate.defineBoolean(true).toString();
            Assertions.assertTrue(desc != null && desc.length() != 0);
        } catch (final Exception e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testGetValue() {
        try {
            boolean retValue = Validate.defineBoolean(true).getValue();
            Assertions.assertEquals(true, retValue);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNoTest() {

        try {
            boolean retVal = Validate.defineBoolean(true).throwValidationExceptionOnFail().validate();
            Assertions.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNoTest2() {

        try {
            boolean retVal = Validate.defineBoolean(true).validate();
            Assertions.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testTrue() {

        try {
            boolean retVal = Validate.defineBoolean(true).testTrue().throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final IllegalArgumentException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testFalse() {

        try {
            boolean retVal = Validate.defineBoolean(false).testFalse().throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final IllegalArgumentException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testEquals() {

        try {
            boolean retVal = Validate.defineBoolean(true).testEquals(true).throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final IllegalArgumentException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testEquals2() {

        try {
            boolean retVal = Validate.defineBoolean(false).testEquals(false).throwValidationExceptionOnFail()
                    .validate();

            Assertions.assertTrue(retVal);
        } catch (final IllegalArgumentException e) {
            Assertions.fail(e.toString());
        }

    }

}
