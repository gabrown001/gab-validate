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
 * A test class for the ObjectValidator
 *
 * @author Gregory Brown (sysdevone)
 */
public class ObjectValidatorNegativeTest {
    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testEquals() {

        Assertions.assertThrows(ValidateException.class, () -> Validate.defineObject("HelloWorld")
                .testEquals("HelloWorld1231").throwValidationExceptionOnFail().validate());

    }

    @Test
    public void testNotNull() {
        Assertions.assertThrows(ValidateException.class,
                () -> Validate.defineObject(null).testNotNull().throwValidationExceptionOnFail().validate());
    }

    @Test
    public void testEmptyThrowValidateExceptionMessage() {

        ObjectValidatorTester validator = new ObjectValidatorTester("");
        Assertions.assertThrows(AssertionError.class, () -> validator.validate());

    }

    @Test
    public void testNullThrowValidateExceptionMessage() {

        ObjectValidatorTester validator = new ObjectValidatorTester(null);
        Assertions.assertThrows(AssertionError.class, () -> validator.validate());

    }

}

class ObjectValidatorTester extends ObjectValidator<Object> {

    String _message;

    public ObjectValidatorTester(String message) {
        super(new Object());
        this._message = message;
    }

    /*
     * (non-Javadoc)
     * @see com.gabstudios.validate.Validator#validate()
     */
    @Override
    public boolean validate() {
        ObjectValidator.throwValidateException(this._message);

        return false;
    }

}
