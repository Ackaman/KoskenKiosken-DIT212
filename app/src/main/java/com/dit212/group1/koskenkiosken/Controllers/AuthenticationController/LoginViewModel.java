package com.dit212.group1.koskenkiosken.Controllers.AuthenticationController;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dit212.group1.koskenkiosken.Model.Authentication.LoginRepository;
import com.dit212.group1.koskenkiosken.Model.Authentication.Result;
import com.dit212.group1.koskenkiosken.Model.Authentication.LoggedInUser;
import com.dit212.group1.koskenkiosken.R;

/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 * Uses: LoginRepository, Result, LoggedInUser, LoginFormState, LoginResult.
 * The state storage for when logging in.
 */
public class LoginViewModel extends ViewModel {

    /**
     * The login form state
     */
    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();

    /**
     * The result from the latest login result.
     */
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();

    /**
     * The object that store user information if a user authenticates successfully.
     */
    private LoginRepository loginRepository;

    /**
     * Create an object of this class with a reference to a repository for authentication state.
     *
     * @param loginRepository The repository holding authentication state
     */
    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    /**
     * Gives you the current state of the login form.
     *
     * @return The state of the login state
     */
    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    /**
     * Gives you the result from the latest authentication attempt.
     *
     * @return Result from authentication
     */
    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    /**
     * The method try to authenticate the account with the username with the password.
     *
     * @param username The name of the account that the user try to authenticate
     * @param password The passsword the user try to authenticate the account with
     */
    public void login(String username, String password) {
        Result result = loginRepository.login(username, password);

        if (result == Result.SUCCESS) {
            LoggedInUser data = loginRepository.getLoggedInUser();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    /**
     * Shows messages informing the user if there is any errors in the login form.
     *
     * @param username The current inputted text in the username field in the login form
     * @param password The current inputted text in the password field in the login form
     */
    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    /**
     * Checks if there is any inputted field for the username.
     *
     * @param username The current inputted text in the username field in the login form
     * @return If there is any inputted text
     */
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        } else {
            return !username.trim().isEmpty();
        }
    }

    /**
     * Check if the inputted password is longer than the minimum.
     *
     * @param password The current inputted password in the login form
     * @return The current state of the inputted password
     */
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
