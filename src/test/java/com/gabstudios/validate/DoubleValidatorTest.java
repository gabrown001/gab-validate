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
 * A test class for the DoubleValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class DoubleValidatorTest
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
    	double x = 5.0d;
        try
        {
            String desc = Validate.defineDouble(x).toString();
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
    	double x = 5.0d;
        try
        {
            double retVal = Validate.defineDouble(x).getValue();
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
    	double x = 5.0d;
        try
        {
            boolean retVal = Validate.defineDouble(x).throwValidationExceptionOnFail().validate();
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
    	double x = 5.0d;
        try
        {
            boolean retVal = Validate.defineDouble(x).validate();
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
        	double x = 5.0d;
            double max = 10.0d;
            boolean retVal = Validate.defineDouble(x).testMaxValue(max)
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
        	double x = 5.0d;
            double min = 4.0d;
            boolean retVal = Validate.defineDouble(x).testMinValue(min)
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
        	double x = 5.0d;
        	double y = 5.0d;
            boolean retVal = Validate.defineDouble(x).testEquals(y)
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
            double x = 0d;
            boolean retVal = Validate.defineDouble(x).isZeroValue().throwValidationExceptionOnFail().validate();
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
            double x = 5d;
            boolean retVal = Validate.defineDouble(x).isPositiveValue().throwValidationExceptionOnFail().validate();
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
            double x = -5d;
            boolean retVal = Validate.defineDouble(x).isNegativeValue().throwValidationExceptionOnFail().validate();
            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
}
