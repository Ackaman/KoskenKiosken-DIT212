package com.dit212.group1.koskenkiosken.Controllers.AuthenticationController;

import androidx.annotation.Nullable;

/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 * Uses: none.
 * Data validation state of the login form.
 */
class LoginFormState {

    /**
     * Integer indicating if there is an error with the username.
     */
    @Nullable
    private Integer usernameError;

    /**
     * Integer indicating if there is an error with the password.
     */
    @Nullable
    private Integer passwordError;

    /**
     * An boolean indicating if the data is valid or not.
     */
    private boolean isDataValid;

    /**
     * Data validation of the inputed values in the login form.
     *
     * @param usernameError Integer indicating if there is an error with the username.
     * @param passwordError Integer indicating if there is an error with the password.
     */
    LoginFormState(@Nullable Integer usernameError, @Nullable Integer passwordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    /**
     * Data validation of the inputed values in the login form.
     *
     * @param isDataValid
     */
    LoginFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.isDataValid = isDataValid;
    }

    /**
     * Gives you the validation of the inputted username.
     *
     * @return Whether if there is an error or not
     */
    @Nullable
    Integer getUsernameError() {
        return usernameError;
    }

    /**
     * Gives you the validation of the inputted password.
     *
     * @return Whether if there is an error or not
     */
    @Nullable
    Integer getPasswordError() {
        return passwordError;
    }

    /**
     * Gives you the value of the isDataValid field.
     *
     * @return Boolean indicating if data is valid
     */
    boolean isDataValid() {
        return isDataValid;
    }
}
