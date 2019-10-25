package com.dit212.group1.koskenkiosken.Controllers.AuthenticationController;

import androidx.annotation.Nullable;

/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 * Uses: LoggedInUserView.
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private LoggedInUserView success;
    @Nullable
    private Integer error;

    LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    LoginResult(@Nullable LoggedInUserView success) {
        this.success = success;
    }

    @Nullable
    LoggedInUserView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}
