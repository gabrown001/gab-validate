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
 * A test class for the ArrayValidator
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class ArrayValidatorTest
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
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            String desc = Validate.defineArray(strArray1).toString();
            Assertions.assertTrue(desc != null && desc.length() != 0);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }
    
    @Test
    public void testGetValue()
    {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            Object[] retArray = Validate.defineArray(strArray1).getValue();
            Assertions.assertArrayEquals(strArray1, retArray);
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
            String[] strArray1 = { "Hello", "World", "is", "awesome" };
            boolean retVal = Validate.defineArray(strArray1).throwValidationExceptionOnFail().validate();
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

        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            boolean retVal = Validate.defineArray(strArray1).validate();
            Assertions.assertEquals(true, retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }
    
    
    @Test
    public void testMaxLength()
    {
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            boolean retVal = Validate.defineArray(strArray1).testMaxLength(4)
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
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            boolean retVal = Validate.defineArray(strArray1).testMinLength(4)
                    .throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }

    @Test
    public void testNotNullEmpty()
    {

        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            boolean retVal = Validate.defineArray(strArray1).testNotNullEmpty()
                    .throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }
    

    @Test
    public void testNotNull()
    {

        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        try
        {
            boolean retVal = Validate.defineArray(strArray1).testNotNull()
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
        String[] strArray1 = { "Hello", "World", "is", "awesome" };
        String[] strArray2 = { "Hello", "World", "is", "awesome" };
        try
        {
            boolean retVal = Validate.defineArray(strArray1).testEquals(strArray2)
                    .throwValidationExceptionOnFail().validate();

            Assertions.assertTrue(retVal);
        }
        catch (final ValidateException e)
        {
            Assertions.fail(e.toString());
        }

    }
    
        
}
