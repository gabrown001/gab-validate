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

/**
 * This is a boolean validator. After this class is created, call the testXXXX()
 * methods to perform tests when the validate() method is called.
 *
 *      Validate.defineBoolean(myObject==null).testTrue().validate();
 *
 * If the throwValidationExceptionOnFail() method has been called and if the
 * validate fails then a ValidateException will be thrown.
 * 
 *      Validate.defineBoolean(myObject==null).testEquals(otherObject != null)
 *          .throwValidationExceptionOnFail().validate();
 *
 * If no test method is called, validate() returns a TRUE.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public final class BooleanValidator extends ObjectValidator<Boolean>
{
    
    /*
     * A flag indicating if a "false" test will be performed when the validate()
     * method is called.
     */
    private boolean       _isTestFalse  = false;
    
    /*
     * A flag indicating if a "true" test will be performed when the validate()
     * method is called.
     */
    private boolean       _isTestTrue   = false;
    
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated.
     */
    protected BooleanValidator(final boolean value)
    {
        super( value );
    }
    
    /**
     * A method to mark that a "false" test will be performed when the
     * validate() method is called.
     *
     * @return The same BooleanValidator instance. This allows for method
     *         chaining.
     */
    public BooleanValidator testFalse()
    {
        this._isTestFalse = true;
        return (this);
    }
    
    /**
     * A method to mark that a "true" test will be performed when the validate()
     * method is called.
     *
     * @return The same BooleanValidator instance. This allows for method
     *         chaining.
     */
    public BooleanValidator testTrue()
    {
        this._isTestTrue = true;
        return (this);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.gabstudios.gabvalidate.Validator#validate()
     */
    @Override
    public boolean validate()
    {
		// call ObjectValidator validate method.
        boolean isValid = super.validate();
        isValid &= validateFalse();
        isValid &= validateTrue();

        return ( isValid );
    }

    /*
     * Used as part of the validation process to test if a boolean is FALSE.
     * @return A <code>boolean</code> value of true it is valid or false the validate failed.
     */
    protected boolean validateFalse()
    {
        boolean isValid = true;
        if (this._isTestFalse)
        {
			isValid = this._value.equals(Boolean.FALSE);
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The value is not false. (value = '"
                                + this._value + "').");
            }
        }
        return(isValid);
    }

    /*
     * Used as part of the validation process to test if a boolean is TRUE.
     * @return A <code>boolean</code> value of true it is valid or false the validate failed.
     */
    protected boolean validateTrue()
    {
        boolean isValid = true;
        if (this._isTestTrue)
        {
		    isValid = this._value.equals(Boolean.TRUE);
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The value is not true. (value = '"
                                + this._value + "').");
            }
        }
        return(isValid);
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"BooleanValidator [_isTestFalse=%s, _isTestTrue=%s, _isValidationExceptionThrownOnFail=%s, _equalsValue=%s, _isTestEquals=%s, _isTestNotNull=%s, _value=%s]",
				_isTestFalse, _isTestTrue, _isValidationExceptionThrownOnFail, _equalsValue, _isTestEquals,
				_isTestNotNull, _value);
	}
    
    
}
