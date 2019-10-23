package com.dit212.group1.koskenkiosken.Controllers.Authentication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dit212.group1.koskenkiosken.Model.User.IAccount;
import com.dit212.group1.koskenkiosken.Model.User.UserFactory;
import com.dit212.group1.koskenkiosken.Model.Authentication.LoginRepository;
import com.dit212.group1.koskenkiosken.Model.Authentication.Result;
import com.dit212.group1.koskenkiosken.Model.Authentication.LoggedInUser;
import com.dit212.group1.koskenkiosken.R;

/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 *
 * The state storage for when logging in.
 */
public class LoginViewModel extends ViewModel {

    /**
     * A global mockup user. This solution isn't very nice.
     */
    public static IAccount mockUser = UserFactory.createMockUser();

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        Result result = loginRepository.login(username, password);

        if (result == Result.SUCCESS) {
            LoggedInUser data = loginRepository.getLoggedInUser();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
