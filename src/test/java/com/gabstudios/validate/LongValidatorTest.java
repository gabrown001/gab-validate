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
 *
 */
public class LongValidatorTest
{
    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testToString()
    {
    	long x = 5L;
        try
        {
            String desc = Validate.defineLong(x).toString();
            Assertions.assertTrue(desc != null && desc.length() != 0);
        }
        catch (final Exception e)
        {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testGetValue()
    {
    	long x = 5L;
        try
        {
            long retVal = Validate.defineLong(x).getValue();
            Assertions.assertEquals(x, retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }
    
    
    @Test
    public void testNoTest()
    {
    	long x = 5L;
        try
        {
            boolean retVal = Validate.defineLong(x).throwValidationExceptionOnFail().validate();
            Assertions.assertEquals(true, retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }
    
    @Test
    public void testNoTest2()
    {
    	long x = 5L;
        try
        {
            boolean retVal = Validate.defineLong(x).validate();
            Assertions.assertEquals(true, retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    } 
    
    @Test
    public void testMaxValue()
    {

        try
        {
        	long x = 5L;
            long max = 10L;
            boolean retVal = Validate.defineLong(x).testMaxValue(max)
                    .throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }
    
    @Test
    public void testMinLength()
    {
        
        try
        {
        	long x = 5L;
            long min = 4L;
            boolean retVal = Validate.defineLong(x).testMinValue(min)
                    .throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }
        
    }
    
    
    @Test
    public void testEquals()
    {
        
        try
        {
        	long x = 5L;
        	long y = 5L;
            boolean retVal = Validate.defineLong(x).testEquals(y)
                    .throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }
        
    }

    @Test
    public void testZeroValue() {

        try {
            long x = 0L;
            boolean retVal = Validate.defineLong(x).isZeroValue().throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testPositiveValue() {

        try {
            long x = 5L;
            boolean retVal = Validate.defineLong(x).isPositiveValue().throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNegativeValue() {

        try {
            long x = -5L;
            boolean retVal = Validate.defineLong(x).isNegativeValue().throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }
    
}
