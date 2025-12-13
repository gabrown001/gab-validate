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

/**
 * This is a long validator. After this class is created, call the testXXXX()
 * methods to perform tests when the validate() method is called.
 * 
 *      Validate.defineLong(long).testNotNull().validate();
 *
 * If the throwValidationExceptionOnFail() method has been called and if the validate fails
 * then a ValidateException will be thrown.
 * 
 *      Validate.defineLong(long).testEquals(long)
 *          .throwValidationExceptionOnFail().validate();
 *
 * If no test method is called, validate() returns a TRUE.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public final class LongValidator  extends NumberValidator<Long>
{
   
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated.
     */
    protected LongValidator(final long value)
    {
        super( value, Long.MIN_VALUE, Long.MAX_VALUE, Long.valueOf(0) );
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"LongValidator [_isTestMaxValue=%s, _isTestMinValue=%s, _maxValue=%s, _minValue=%s, _isValidationExceptionThrownOnFail=%s, _equalsValue=%s, _isTestEquals=%s, _isTestNotNull=%s, _value=%s]",
				_isTestMaxValue, _isTestMinValue, _maxValue, _minValue, _isValidationExceptionThrownOnFail,
				_equalsValue, _isTestEquals, _isTestNotNull, _value);
	}
    
    
}
