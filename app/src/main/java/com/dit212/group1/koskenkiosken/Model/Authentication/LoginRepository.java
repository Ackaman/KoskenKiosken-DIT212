package com.dit212.group1.koskenkiosken.Model.Authentication;

/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 *
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository {

    /**
     * The repository holding the state whether the user is authenticated or not.
     */
    private static volatile LoginRepository instance;

    /**
     * The methods that does the actual authentication based on username and password
     */
    private LoginDataSource dataSource;

    /**
     * A reference to the logged in user.
     */
    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private LoggedInUser user = null;

    // private constructor : singleton access
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    /**
     * Check if there is a user logged in.
     *
     * @return Whether a user is logged in or not
     */
    public boolean isLoggedIn() {
        return user != null;
    }

    public LoggedInUser getLoggedInUser() {
        return user;
    }

    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Result login(String username, String password) {
        // handle login
        Result result = dataSource.login(username, password);

        if (result == Result.SUCCESS) {
            LoggedInUser loggedInMockUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            dataSource.mockUser.getName());
            setLoggedInUser(loggedInMockUser);
        }

        return result;
    }
}
