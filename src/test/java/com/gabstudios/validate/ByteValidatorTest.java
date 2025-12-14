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
 * A test class for the ByteValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class ByteValidatorTest
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
        byte x = 5;
        try
        {
            String desc = Validate.defineByte(x).toString();
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
        byte x = 5;
        try
        {
            byte retVal = Validate.defineByte(x).getValue();
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

        try
        {
            byte x = 5;
            boolean retVal = Validate.defineByte(x).throwValidationExceptionOnFail().validate();
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

        try
        {
            byte x = 5;
            boolean retVal = Validate.defineByte(x).validate();
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
            byte x = 5;
            byte max = 8;
            boolean retVal = Validate.defineByte(x).testMaxValue(max)
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
            byte x = 5;
            byte min = 4;
            boolean retVal = Validate.defineByte(x).testMinValue(min)
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
            byte x = 5;
            byte y= 5;
            boolean retVal = Validate.defineByte(x).testEquals(y)
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
            byte x = 0;
            boolean retVal = Validate.defineByte(x).isZeroValue().throwValidationExceptionOnFail().validate();
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
            byte x = 5;
            boolean retVal = Validate.defineByte(x).isPositiveValue().throwValidationExceptionOnFail().validate();
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
            byte x = -5;
            boolean retVal = Validate.defineByte(x).isNegativeValue().throwValidationExceptionOnFail().validate();
            Assertions.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }
    
}
