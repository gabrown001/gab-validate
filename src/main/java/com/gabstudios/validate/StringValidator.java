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

import java.util.regex.Pattern;

/**
 * This is a String validator. After this class is created, call the testXXXX()
 * methods to perform tests when the validate() method is called.
 * 
 * Validate.defineString(String).testNotNull().validate();
 *
 * If the throwValidationExceptionOnFail() method has been called and if the
 * validate fails then a ValidateException will be thrown.
 * 
 * Validate.defineString(String).testEquals(String)
 * .throwValidationExceptionOnFail().validate();
 *
 * If no test method is called, validate() returns a TRUE.
 *
 * @author Gregory Brown (sysdevone)
 *
 */
public class StringValidator extends ObjectValidator<String>
{
    
    /*
     * The value to use if the testMatch(String) method has been called.
     */
    private String       _matchValue;
    
    
    /*
     * A flag indicating if an "equals no case" test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestEqualsNoCase = false;
    
    /*
     * A flag indicating that a max length test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestMaxLength    = false;
    
    /*
     * A flag indicating that a min length test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestMinLength    = false;
    
    /*
     * A flag indicating if an "not empty" test will be performed when the
     * validate() method is called.
     */
    private boolean      _isTestNotEmpty     = false;
    
    /*
     * A flag indicating if a "match" will be performed using regrex expressions
     * when the validate() method is called.
     */
    private boolean      _isTestMatch        = false;
    
    /*
     * The max length to test for. Defaults to 0.
     */
    private int          _maxLength          = 0;
    
    /*
     * The min length to test for. Defaults to 0.
     */
    private int          _minLength          = 0;
    
    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated. This value can be null or
     *            empty.
     */
    protected StringValidator(final String value)
    {
        super( value );
    }
    
    
    /**
     * A method to mark that an "equals" test will be performed when the
     * validate() method is called.
     * 
     * @param equalsValue
     *            The value to perform the equate with.
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    @Override
    public StringValidator testEquals(final String equalsValue)
    {
        // have to test for null if empty is selected.
        this._isTestEqualsNoCase = false;
    		super.testEquals(equalsValue);
    		return( this );
    }
    
    /**
     * A method to mark that an "equals no case" test will be performed when the
     * validate() method is called.
     * 
     * @param equalsValue
     *            The value to perform the equate with.
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public StringValidator testEqualsNoCase(final String equalsValue)
    {
        // have to test for null if empty is selected.
        this._isTestNotNull = true;
        this._isTestEqualsNoCase = true;
        this._isTestEquals = false;
        this._equalsValue = equalsValue;
    	return( this );
    }
    
    /**
     * A method to mark that an "match" test using regex will be performed when
     * the validate() method is called.
     * 
     * @param value
     *            A regular expression that be used to see if the String value
     *            is a match.
     * 
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public StringValidator testMatch(String value)
    {
        // have to test for null if match is selected.
        this._isTestNotNull = true;
        this._isTestMatch = true;
        this._matchValue = value;
        return (this);
    }
    
    /**
     * A method to mark that an "max length" test will be performed when the
     * validate() method is called. Tests if the length is less than or equal to
     * the max value when the validate method is called.
     * 
     * @param maxLength
     *            The value to perform the test with.
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public StringValidator testMaxLength(final int maxLength)
    {
        if (maxLength < 0)
        {
            throw (new IllegalArgumentException(
                    "The parameter 'maxLength' must be greater than zero (0)."));
        }
        else if (maxLength < this._minLength) 
        {
            throw (new IllegalArgumentException(
                    "The parameter 'maxLength' must be greater than the min length value."));
        }
        else
        {
            // have to test for null if empty is selected.
            this._isTestNotNull = true;
            this._isTestMaxLength = true;
            this._maxLength = maxLength;
        }
        return (this);
    }
    
    /**
     * A method to mark that an "min length" test will be performed when the
     * validate() method is called. Tests if the value is greater than or equal
     * to the min value when the validate method is called.
     * 
     * @param minLength
     *            The value to perform the test with.
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public StringValidator testMinLength(final int minLength)
    {
        if (minLength < 0)
        {
            throw( new IllegalArgumentException("The parameter 'minLength' must be greater than zero (0)."));
        }
        else if ((minLength > this._maxLength) && (this._maxLength != 0))
        {
            throw( new IllegalArgumentException("The parameter 'minLength' must be less than the max length value."));
        }
        else
        {
            // have to test for null if empty is selected.
            this._isTestNotNull = true;
            this._isTestMinLength = true;
            this._minLength = minLength;
        }
        return (this);
    }
    
    /**
     * A method to mark that an "not null or empty" test will be performed when
     * the validate() method is called.
     * 
     * @return The same StringValidator instance. This allows for method
     *         chaining.
     */
    public StringValidator testNotNullEmpty()
    {
        // have to test for null if empty is selected.
        this._isTestNotNull = true;
        this._isTestNotEmpty = true;
        return (this);
    }
    
	protected boolean notNullValue()
	{
		return( this._value != null && this._value.length() > 0 );
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
        isValid &= validateNotEmpty();
        isValid &= validateEqualsNoCase();
        isValid &= validateMinLength();
        isValid &= validateMaxLength();
        isValid &= validateMatch();

        return ( isValid );

   }

   protected boolean validateNotEmpty()
   {
       boolean isValid = true;
       if (this._isTestNotEmpty)
       {
           
           isValid = (this._value != null && this._value.length() > 0);
           if (this._isValidationExceptionThrownOnFail && !isValid)
           {
               ObjectValidator
                       .throwValidateException("The value must not be empty.");
           }
       }
       return(isValid);
   }

   protected boolean validateEqualsNoCase()
   {
        boolean isValid = true;
        if (this._isTestEqualsNoCase)
        {
            isValid &= this._value != null && this._value.equalsIgnoreCase(this._equalsValue);
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
                ObjectValidator
                        .throwValidateException("The value does not equal the expected value (string value = '"
                                + this._value
                                + "' expected value = '"
                                + this._equalsValue + "').");
            }
        }
        return(isValid);
    }

    protected boolean validateMinLength()
    {
        boolean isValid = true;
        if (this._isTestMinLength)
        {
            isValid &= (this._value != null && this._value.length() >= this._minLength);
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The value must be greater than or equal to the min value (value = '"
                                + this._value
                                + "' length = '"
                                + ((this._value != null) ? this._value.length() : "null" )
                                + "' min value = '"
                                + this._minLength + "').");
            }
            
        }
        return(isValid);
    }

    protected boolean validateMaxLength()
    {
        boolean isValid = true;
        if (this._isTestMaxLength)
        {
            isValid &= (this._value != null && this._value.length() <= this._maxLength);
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The value must be less than or equal to the max value (value = '"
                                + this._value
                                + "' length = '"
                                + ((this._value != null) ? this._value.length() : "null" )
                                + "' max value = '"
                                + this._maxLength + "').");
            }
        }
        return(isValid);
    }

    protected boolean validateMatch()
    {
        boolean isValid = true;
        if (this._isTestMatch)
        {
            isValid &= this._value != null && (Pattern.matches(this._matchValue, this._value));
            if (this._isValidationExceptionThrownOnFail && !isValid)
            {
            	ObjectValidator
                        .throwValidateException("The value does not match the reqular expression (value = '"
                                + this._value
                                + "' regex = '"
                                + this._matchValue + "').");
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
				"StringValidator [_matchValue=%s, _isTestEqualsNoCase=%s, _isTestMaxLength=%s, _isTestMinLength=%s, _isTestNotEmpty=%s, _isTestMatch=%s, _maxLength=%s, _minLength=%s, _isValidationExceptionThrownOnFail=%s, _equalsValue=%s, _isTestEquals=%s, _isTestNotNull=%s, _value=%s]",
				_matchValue, _isTestEqualsNoCase, _isTestMaxLength, _isTestMinLength, _isTestNotEmpty, _isTestMatch,
				_maxLength, _minLength, _isValidationExceptionThrownOnFail, _equalsValue, _isTestEquals, _isTestNotNull,
				_value);
	}


    
    
}
