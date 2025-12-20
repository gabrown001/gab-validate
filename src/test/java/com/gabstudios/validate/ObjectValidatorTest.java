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
 * A test class for the ObjectValidator
 *
 * @author Gregory Brown (sysdevone)
 */
public class ObjectValidatorTest {
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
            String desc = Validate.defineObject(x).toString();
            Assertions.assertTrue(desc != null && desc.length() != 0);
        } catch (final Exception e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testGetValue() {
        String x = "5";
        try {
            String retVal = (String) Validate.defineObject(x).getValue();
            Assertions.assertEquals(x, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNoTest() {
        String x = "5";
        try {
            boolean retVal = Validate.defineObject(x).throwValidationExceptionOnFail().validate();
            Assertions.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNoTest2() {
        String x = "5";
        try {
            boolean retVal = Validate.defineObject(x).validate();
            Assertions.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testEquals() {

        try {
            boolean retVal = Validate.defineObject("HelloWorld").testEquals("HelloWorld")
                    .throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNotNull() {

        try {
            boolean retVal = Validate.defineObject("HelloWorld").testNotNull().throwValidationExceptionOnFail()
                    .validate();

            Assertions.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assertions.fail(e.toString());
        }

    }

}
