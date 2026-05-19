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
 * The Validator interface defines the methods that are used to perform validation tests on a value.
 *
 * @author G Brown
 */
public abstract interface Validator {
    /**
     * Performs a validation test based on the methods that were called. If the method throwValidationExceptionOnFail
     * has been called, then an ValidateException will be thrown. If no test method is called, this method returns a
     * TRUE.
     *
     * @return A boolean value that is true if the value is valid. Otherwise false is return.
     *
     * @see throwValidationExceptionOnFail
     */
    public abstract boolean validate();

    /**
     * A method to mark that an ValidateException should be thrown if the validate method returns false.
     *
     * @param <T>
     *            The Validator class to return.
     *
     * @return The same BooleanValidator instance. This allows for method chaining.
     */
    @SuppressWarnings("hiding")
    public <T extends Validator> T throwValidationExceptionOnFail();
}
