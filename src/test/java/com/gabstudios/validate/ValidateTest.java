/*****************************************************************************************
 *
 * Copyright 2015 Gregory Brown. All Rights Reserved.
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
 * Basic tests for the Validator class.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class ValidateTest
{
    
    /*
     * Tests the defineString method.
     */
    @Test
    public void defineString()
    {
        
        try
        {
            StringValidator stringValidator = Validate
                    .defineString("HelloWorld");
            Assert.assertNotNull(stringValidator);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineBoolean method.
     */
    @Test
    public void defineBoolean()
    {
        
        try
        {
            BooleanValidator booleanValidator = Validate.defineBoolean(true);
            Assert.assertNotNull(booleanValidator);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineByte method.
     */
    @Test
    public void defineByte()
    {
        
        try
        {
            ByteValidator byteValidator = Validate.defineByte((byte) 0xa);
            Assert.assertNotNull(byteValidator);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineChar method.
     */
    @Test
    public void defineChar()
    {
        
        try
        {
            CharValidator charValidator = Validate.defineChar('C');
            Assert.assertNotNull(charValidator);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineDouble method.
     */
    @Test
    public void defineDouble()
    {
        
        try
        {
            DoubleValidator doubleValidator = Validate.defineDouble(1.5);
            Assert.assertNotNull(doubleValidator);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineFloat method.
     */
    @Test
    public void defineFloat()
    {
        
        try
        {
            FloatValidator floatValidator = Validate.defineFloat(1.0F);
            Assert.assertNotNull(floatValidator);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineInteger method.
     */
    @Test
    public void defineInteger()
    {
        
        try
        {
            IntegerValidator intValidator = Validate.defineInteger(55);
            Assert.assertNotNull(intValidator);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineShort method.
     */
    @Test
    public void defineShort()
    {
        
        try
        {
            ShortValidator shortValidator = Validate.defineShort((short) 100);
            Assert.assertNotNull(shortValidator);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    /*
     * Tests the defineLong method.
     */
    @Test
    public void defineLong()
    {
        
        try
        {
            LongValidator longValidator = Validate.defineLong(100L);
            Assert.assertNotNull(longValidator);
        }
        catch (final Exception e)
        {
            Assert.fail(e.toString());
        }
        
    }
    
    // /*
    //  * Tests the defineLong method.
    //  */
    // @Test
    // public void defineObject1()
    // {
        
    //     try
    //     {
    //         ObjectValidator<?> objectValidator = Validate.defineObject(100L);
    //         Assert.assertTrue(objectValidator != null);
    //     }
    //     catch (final Exception e)
    //     {
    //         Assert.fail(e.toString());
    //     }
        
    // }
    
    // /*
    //  * Tests the defineLong method.
    //  */
    // @Test
    // public void defineObject2()
    // {
    //     Object object = new Object();
    //     try
    //     {
    //         ObjectValidator<?> objectValidator = Validate.defineObject(object);
    //         Assert.assertTrue(objectValidator != null);
    //     }
    //     catch (final Exception e)
    //     {
    //         Assert.fail(e.toString());
    //     }
        
    // }
    
    @Before
    public void setUp()
    {
        //
    }
    
    @After
    public void tearDown()
    {
        
    }
    
}
