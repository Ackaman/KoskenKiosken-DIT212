package com.dit212.group1.koskenkiosken.data;

import com.dit212.group1.koskenkiosken.Controllers.Authentication.LoginViewModel;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result login(String username, String password) {

        if (username.toLowerCase().equals(LoginViewModel.mockUser.getName().toLowerCase())
                && password.equals(LoginViewModel.mockUser.getPassword())) {
            return Result.SUCCESS;
        } else {
            return Result.ERROR;
        }
    }

}
