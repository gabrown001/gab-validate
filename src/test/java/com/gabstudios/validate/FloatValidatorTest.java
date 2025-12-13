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
 * A test class for the FloatValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class FloatValidatorTest
{
    @Before
    public void setUp()
    {
        //
    }
    
    @After
    public void tearDown()
    {
        
    }
    
    @Test
    public void testToString()
    {
    	float x = 5.0f;
        try
        {
            String desc = Validate.defineFloat(x).toString();
            Assert.assertTrue(desc != null && desc.length() != 0);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }

    }
    
    @Test
    public void testGetValue()
    {
    	float x = 5.0f;
        try
        {
            float retVal = Validate.defineFloat(x).getValue();
            Assert.assertEquals(x, retVal, 0);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    
    @Test
    public void testNoTest()
    {
    	float x = 5.0f;
        try
        {
            boolean retVal = Validate.defineFloat(x).throwValidationExceptionOnFail().validate();
            Assert.assertEquals(true, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    @Test
    public void testNoTest2()
    {
    	float x = 5.0f;
        try
        {
            boolean retVal = Validate.defineFloat(x).validate();
            Assert.assertEquals(true, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }     
    
    @Test
    public void testMaxValue()
    {

        try
        {
        	float x = 5.0f;
            float max = 10.0f;
            boolean retVal = Validate.defineFloat(x).testMaxValue(max)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    @Test
    public void testMinLength()
    {
        
        try
        {
        	float x = 5.0f;
            float min = 4.0f;
            boolean retVal = Validate.defineFloat(x).testMinValue(min)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    
    @Test
    public void testEquals()
    {
        
        try
        {
        	float x = 5.0f;
        	float y = 5.0f;
            boolean retVal = Validate.defineFloat(x).testEquals(y)
                    .throwValidationExceptionOnFail().validate();

            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }
        
    }

    @Test
    public void testZeroValue() {

        try {
            float x = 0f;
            boolean retVal = Validate.defineFloat(x).isZeroValue().throwValidationExceptionOnFail().validate();
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
            float x = 5f;
            boolean retVal = Validate.defineFloat(x).isPositiveValue().throwValidationExceptionOnFail().validate();
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
            float x = -5f;
            boolean retVal = Validate.defineFloat(x).isNegativeValue().throwValidationExceptionOnFail().validate();
            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
}
