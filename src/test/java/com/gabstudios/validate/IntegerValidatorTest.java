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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A test class for the IntegerValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class IntegerValidatorTest {
    @Before
    public void setUp() {
        //
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testToString() {
        int x = 5;
        try {
            String desc = Validate.defineInteger(x).toString();
            Assert.assertTrue(desc != null && desc.length() != 0);
        } catch (final Exception e) {
            Assert.fail(e.toString());
        }

    }

    @Test
    public void testGetValue() {
        int x = 5;
        try {
            int retVal = Validate.defineInteger(x).getValue();
            Assert.assertEquals(x, retVal);
        } catch (final ValidateException e) {
            Assert.fail(e.toString());
        }

    }

    @Test
    public void testNoTest() {
        int x = 5;
        try {
            boolean retVal = Validate.defineInteger(x).throwValidationExceptionOnFail().validate();
            Assert.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assert.fail(e.toString());
        }

    }

    @Test
    public void testNoTest2() {
        int x = 5;
        try {
            boolean retVal = Validate.defineInteger(x).validate();
            Assert.assertEquals(true, retVal);
        } catch (final ValidateException e) {
            Assert.fail(e.toString());
        }

    }

    @Test
    public void testMaxValue() {

        try {
            int x = 5;
            int max = 10;
            boolean retVal = Validate.defineInteger(x).testMaxValue(max).throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assert.fail(e.toString());
        }

    }

    @Test
    public void testMinLength() {

        try {
            int x = 5;
            int min = 4;
            boolean retVal = Validate.defineInteger(x).testMinValue(min).throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assert.fail(e.toString());
        }

    }

    @Test
    public void testEquals() {

        try {
            int x = 5;
            int y = 5;
            boolean retVal = Validate.defineInteger(x).testEquals(y).throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        } catch (final ValidateException e) {
            Assert.fail(e.toString());
        }

    }

    @Test
    public void testZeroValue() {

        try {
            int x = 0;
            boolean retVal = Validate.defineInteger(x).isZeroValue().throwValidationExceptionOnFail().validate();
            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }

    @Test
    public void testPositiveValue() {

        try {
            int x = 5;
            boolean retVal = Validate.defineInteger(x).isPositiveValue().throwValidationExceptionOnFail().validate();
            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }

    @Test
    public void testNegativeValue() {

        try {
            int x = -5;
            boolean retVal = Validate.defineInteger(x).isNegativeValue().throwValidationExceptionOnFail().validate();
            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }

}
