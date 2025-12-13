/*****************************************************************************************
 *
 * Copyright 2014 Gregory Brown. All Rights Reserved.
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

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

/**
 * The purpose of this class is to help validate arguments. 
 * 
 * Use the appropriate defineXXXXX(xxx) method to get a validator instance. Then
 * call methods on that validator to enable the tests that will be performed
 * when the validate() method is called.
 * 
 * The default return from a validate() - if no tests are selected is TRUE.
 *
 * @author Gregory Brown (sysdevone)
 */
public class Validate
{
    
    /**
     * Prevent a new instance.
     */
    private Validate()
    {
        // void - ignore this.
    }
    
    /**
     * This method defines a boolean validator. Each call creates a new
     * validator.
     *
     * @param value
     *            The boolean value to validate.
     * @return A <code>BooleanValidator</code> instance.
     */
    public static final BooleanValidator defineBoolean(final boolean value)
    {
        return (new BooleanValidator(value));
    }
    
    /**
     * This method defines a byte validator. Each call creates a new validator.
     *
     * @param value
     *            The byte value to validate.
     * @return A <code>ByteValidator</code> instance.
     */
    public static final ByteValidator defineByte(final byte value)
    {
        return (new ByteValidator(value));
    }
    
    /**
     * This method defines a char validator. Each call creates a new validator.
     *
     * @param value
     *            The char value to validate.
     * @return A <code>CharValidator</code> instance.
     */
    public static final CharValidator defineChar(final char value)
    {
        return (new CharValidator(value));
    }
    
    /**
     * This method defines a double validator. Each call creates a new
     * validator.
     *
     * @param value
     *            The double value to validate.
     * @return A <code>DoubleValidator</code> instance.
     */
    public static final DoubleValidator defineDouble(final double value)
    {
        return (new DoubleValidator(value));
    }
    
    /**
     * This method defines a float validator. Each call creates a new validator.
     *
     * @param value
     *            The float value to validate.
     * @return A <code>FloatValidator</code> instance.
     */
    public static final FloatValidator defineFloat(final float value)
    {
        return (new FloatValidator(value));
    }
    
    /**
     * This method defines a integer validator. Each call creates a new
     * validator.
     *
     * @param value
     *            The integer value to validate.
     * @return A <code>IntegerValidator</code> instance.
     */
    public static final IntegerValidator defineInteger(final int value)
    {
        return (new IntegerValidator(value));
    }
    
    /**
     * This method defines a long validator. Each call creates a new validator.
     *
     * @param value
     *            The long value to validate.
     * @return A <code>LongValidator</code> instance.
     */
    public static final LongValidator defineLong(final long value)
    {
        return (new LongValidator(value));
    }
    
    /**
     * This method defines a short validator. Each call creates a new validator.
     *
     * @param value
     *            The short value to validate.
     * @return A <code>ShortValidator</code> instance.
     */
    public static final ShortValidator defineShort(final short value)
    {
        return (new ShortValidator(value));
    }
    
    /**
     * This method defines a String validator. Each call creates a new
     * validator.
     *
     * @param value
     *            The string value to validate.
     * @return A <code>StringValidator</code> instance.
     */
    public static final StringValidator defineString(final String value)
    {
        return (new StringValidator(value));
    }
    
    // /**
    //  * This method defines a String validator. Each call creates a new
    //  * validator.
    //  *
    //  * @param value
    //  *            The Object value to validate.
    //  * @return A <code>ObjectValidator</code> instance.
    //  */
    // public static final ObjectValidator<Object> defineObject(final Object value)
    // {
    //     return (new ObjectValidator<Object>(value));
    // }
    
    /**
     * This method defines a Array validator. Each call creates a new validator.
     *
     * @param value
     *            The Object[] value to validate.
     * @return A <code>ObjectValidator</code> instance.
     */
    public static final ArrayValidator defineArray(final Object[] value)
    {
        return (new ArrayValidator(value));
    }


    /**
     * This method defines a URL validator. Each call creates a new validator.
     *
     * @param value
     *            The String value to validate.
     * @return A <code>URLValidator</code> instance.
     * @throws UnknownHostException
     * @throws MalformedURLException
     * @throws URISyntaxException 
     */
    public static final URIValidator defineURL(final String value) throws MalformedURLException, UnknownHostException, URISyntaxException
    {
        return (new URIValidator(value));
    }
}
