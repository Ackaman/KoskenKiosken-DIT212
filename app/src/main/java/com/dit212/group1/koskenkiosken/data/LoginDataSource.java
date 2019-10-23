package com.dit212.group1.koskenkiosken.data;

import com.dit212.group1.koskenkiosken.Model.User.IAccount;
import com.dit212.group1.koskenkiosken.Model.User.UserFactory;
import com.dit212.group1.koskenkiosken.data.model.LoggedInUser;
import com.dit212.group1.koskenkiosken.ui.login.LoginViewModel;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result login(String username, String password) {

        if (username.toLowerCase().equals(LoginViewModel.mockUser.getUserName().toLowerCase())
                && password.equals(LoginViewModel.mockUser.getPassword())) {
            return Result.SUCCESS;
        } else {
            return Result.ERROR;
        }
    }

}
