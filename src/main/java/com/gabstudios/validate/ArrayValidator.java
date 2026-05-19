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

import java.util.Arrays;

/**
 * This is a Array validator. After this class is created, call the testXXXX() methods to perform tests when the
 * validate() method is called. Validate.defineString(String).testNotNull().validate(); If the
 * throwValidationExceptionOnFail() method has been called and if the validate fails then a ValidateException will be
 * thrown. Validate.defineString(String).testEquals(String) .throwValidationExceptionOnFail().validate(); If no test
 * method is called, validate() returns a TRUE.
 *
 * @author G Brown
 */
public final class ArrayValidator extends ObjectValidator<Object[]> {

    /*
     * A flag indicating that a max length test will be performed when the validate() method is called.
     */
    private boolean _isTestMaxLength = false;

    /*
     * A flag indicating that a min length test will be performed when the validate() method is called.
     */
    private boolean _isTestMinLength = false;

    /*
     * A flag indicating if an "not empty" test will be performed when the validate() method is called.
     */
    private boolean _isTestNotEmpty = false;

    /*
     * The max length to test for. Defaults to 0.
     */
    private int _maxLength = 0;

    /*
     * The min length to test for. Defaults to 0.
     */
    private int _minLength = 0;

    /**
     * Protected constructor. Use Validate static method to create validator.
     *
     * @param value
     *            The value that will be validated. This value can be null or empty.
     */
    protected ArrayValidator(final Object[] value) {
        super(value);
    }

    /**
     * Gets the value that was used to initialize this validator.
     *
     * @return A String value.
     */
    @Override
    public Object[] getValue() {
        Object[] retVal = null;
        if (this._value != null) {
            retVal = Arrays.copyOf(this._value, this._value.length);
        }

        return (retVal);
    }

    /**
     * A method to mark that an "equals" test will be performed when the validate() method is called.
     *
     * @param equalsValue
     *            The value to perform the equate with.
     *
     * @return The same ArrayValidator instance. This allows for method chaining.
     */
    @Override
    public ArrayValidator testEquals(final Object[] equalsValue) {
        // have to test for null if empty is selected.
        this._isTestNotNull = true;
        this._isTestEquals = true;

        if (equalsValue != null) {
            this._equalsValue = Arrays.copyOf(equalsValue, equalsValue.length);
        } else {
            this._equalsValue = null;
        }

        return (this);
    }

    /**
     * A method to mark that an "max length" test will be performed when the validate() method is called. Tests if the
     * length is less than or equal to the max value when the validate method is called.
     *
     * @param maxLength
     *            The value to perform the test with.
     *
     * @return The same ArrayValidator instance. This allows for method chaining.
     */
    public ArrayValidator testMaxLength(final int maxLength) {
        if (maxLength < 0) {
            throw (new IllegalArgumentException("The parameter 'maxLength' must be greater than zero (0)."));
        } else if (maxLength < this._minLength) {
            throw (new IllegalArgumentException(
                    "The parameter 'maxLength' must be greater than the min length value."));
        } else {
            // have to test for null if empty is selected.
            this._isTestNotNull = true;
            this._isTestMaxLength = true;
            this._maxLength = maxLength;
        }
        return (this);
    }

    /**
     * A method to mark that an "min length" test will be performed when the validate() method is called. Tests if the
     * value is greater than or equal to the min value when the validate method is called.
     *
     * @param minLength
     *            The value to perform the test with.
     *
     * @return The same ArrayValidator instance. This allows for method chaining.
     */
    public ArrayValidator testMinLength(final int minLength) {
        if (minLength < 0) {
            throw (new IllegalArgumentException("The parameter 'minLength' must be greater than zero (0)."));
        } else if ((minLength > this._maxLength) && (this._maxLength != 0)) {
            throw (new IllegalArgumentException("The parameter 'minLength' must be less than the max length value."));
        } else {
            // have to test for null if empty is selected.
            this._isTestNotNull = true;
            this._isTestMinLength = true;
            this._minLength = minLength;
        }
        return (this);
    }

    /**
     * A method to mark that an "not null" test will be performed when the validate() method is called.
     *
     * @return The same ArrayValidator instance. This allows for method chaining.
     */
    @Override
    public ArrayValidator testNotNull() {
        this._isTestNotNull = true;
        return (this);
    }

    /**
     * A method to mark that an "not null or empty" test will be performed when the validate() method is called.
     *
     * @return The same ArrayValidator instance. This allows for method chaining.
     */
    public ArrayValidator testNotNullEmpty() {
        // have to test for null if empty is selected.
        this._isTestNotNull = true;
        this._isTestNotEmpty = true;
        return (this);
    }

    /*
     * (non-Javadoc)
     * @see com.gabstudios.gabvalidate.Validator#validate()
     */
    @Override
    public boolean validate() {
        // call ObjectValidator validate method.
        boolean isValid = super.validate();
        isValid &= validateNotEmpty();
        isValid &= validateMinLength();
        isValid &= validateMaxLength();

        return (isValid);

    }

    /*
     * Used as part of the validation process to test that an array is not empty.
     * @return A <code>boolean</code> value of true it is valid or false the validate failed.
     */
    protected boolean validateNotEmpty() {
        boolean isValid = true;
        if (this._isTestNotEmpty) {

            isValid = (this._value != null && this._value.length > 0);
            if (this._isValidationExceptionThrownOnFail && !isValid) {
                ObjectValidator.throwValidateException("The value must not be empty.");
            }
        }
        return (isValid);
    }

    /*
     * Used as part of the validation process to test min length
     * @return A <code>boolean</code> value of true it is valid or false the validate failed.
     */
    protected boolean validateMinLength() {
        boolean isValid = true;
        if (this._isTestMinLength) {
            isValid = (this._value != null && this._value.length >= this._minLength);
            if (this._isValidationExceptionThrownOnFail && !isValid) {
                ObjectValidator
                        .throwValidateException("The value must be greater than or equal to the min value (value = '"
                                + Arrays.toString(this._value) + "' min value = '" + this._minLength + "').");
            }
        }
        return (isValid);
    }

    /*
     * Used as part of the validation process to test max length.
     * @return A <code>boolean</code> value of true it is valid or false the validate failed.
     */
    protected boolean validateMaxLength() {
        boolean isValid = true;
        if (this._isTestMaxLength) {
            isValid = (this._value != null && this._value.length <= this._maxLength);
            if (this._isValidationExceptionThrownOnFail && !isValid) {
                ObjectValidator
                        .throwValidateException("The value must be less than or equal to the max value (value = '"
                                + Arrays.toString(this._value) + "' min value = '" + this._minLength + "').");
            }
        }
        return (isValid);
    }

    /*
     * Used as part of the validation process to test to not empty.
     * @return A <code>boolean</code> value of true it is valid or false the validate failed.
     */
    @Override
    protected boolean validateEquals() {
        boolean isValid = true;
        if (this._isTestEquals) {
            isValid = Arrays.equals(this._value, this._equalsValue);
            if (this._isValidationExceptionThrownOnFail && !isValid) {
                ObjectValidator.throwValidateException(
                        "The value does not equal the expected value (value = '" + Arrays.toString(this._value)
                                + "' expected value = '" + Arrays.toString(this._equalsValue) + "').");
            }
        }
        return (isValid);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format(
                "ArrayValidator [_isTestMaxLength=%s, _isTestMinLength=%s, _isTestNotEmpty=%s, _maxLength=%s, _minLength=%s, _isValidationExceptionThrownOnFail=%s, _equalsValue=%s, _isTestEquals=%s, _isTestNotNull=%s, _value=%s]",
                _isTestMaxLength, _isTestMinLength, _isTestNotEmpty, _maxLength, _minLength,
                _isValidationExceptionThrownOnFail, Arrays.toString(_equalsValue), _isTestEquals, _isTestNotNull,
                Arrays.toString(_value));
    }

}
