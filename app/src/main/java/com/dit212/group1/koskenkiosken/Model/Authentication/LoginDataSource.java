package com.dit212.group1.koskenkiosken.Model.Authentication;

import com.dit212.group1.koskenkiosken.Model.User.IAccount;
import com.dit212.group1.koskenkiosken.Model.User.UserFactory;

/**
 * @author Albin Otterhäll
 * Uses: IAccount, UserFactory, Result.
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    /**
     * A global mockup user. This solution isn't very nice.
     */
    public IAccount mockUser = UserFactory.createMockUser();

    /**
     * This method compare the username and password to the mock user.
     *
     * @param username The name on the account the user try to authenticate
     * @param password The password to the account that the user try to login to
     * @return Either a success or an error
     */
    public Result login(String username, String password) {

        if (username.toLowerCase().equals(mockUser.getName().toLowerCase())
                && password.equals(mockUser.getPassword())) {
            return Result.SUCCESS;
        } else {
            return Result.ERROR;
        }
    }

}
