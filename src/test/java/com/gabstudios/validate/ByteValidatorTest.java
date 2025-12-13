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
 * A test class for the ByteValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class ByteValidatorTest
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
        byte x = 5;
        try
        {
            String desc = Validate.defineByte(x).toString();
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
        byte x = 5;
        try
        {
            byte retVal = Validate.defineByte(x).getValue();
            Assert.assertEquals(x, retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
    @Test
    public void testNoTest()
    {

        try
        {
            byte x = 5;
            boolean retVal = Validate.defineByte(x).throwValidationExceptionOnFail().validate();
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

        try
        {
            byte x = 5;
            boolean retVal = Validate.defineByte(x).validate();
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
            byte x = 5;
            byte max = 8;
            boolean retVal = Validate.defineByte(x).testMaxValue(max)
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
            byte x = 5;
            byte min = 4;
            boolean retVal = Validate.defineByte(x).testMinValue(min)
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
            byte x = 5;
            byte y= 5;
            boolean retVal = Validate.defineByte(x).testEquals(y)
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
            byte x = 0;
            boolean retVal = Validate.defineByte(x).isZeroValue().throwValidationExceptionOnFail().validate();
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
            byte x = 5;
            boolean retVal = Validate.defineByte(x).isPositiveValue().throwValidationExceptionOnFail().validate();
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
            byte x = -5;
            boolean retVal = Validate.defineByte(x).isNegativeValue().throwValidationExceptionOnFail().validate();
            Assert.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assert.fail(e.toString());
        }

    }
    
}
