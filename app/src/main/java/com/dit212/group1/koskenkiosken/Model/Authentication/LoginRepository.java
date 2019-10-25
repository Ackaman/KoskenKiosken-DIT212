package com.dit212.group1.koskenkiosken.Model.Authentication;

/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 * Uses: Result, LoggedInUser, LoginDataSource
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
    private LoggedInUser user = null;

    /**
     * Creates an instance of this class with an reference to the authentication class.
     *
     * @param dataSource The class that handles the authentication.
     */
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Creates an instance of this object if there is no one already, or returns a reference if
     * there is one already.
     *
     * @param dataSource The class that handles the authentication.
     * @return Reference to the singelton object of this class
     */
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

    /**
     * Returns an reference to the authenticated user, if there is one.
     *
     * @return Reference to a `User` object, or null.
     */
    public LoggedInUser getLoggedInUser() {
        return user;
    }

    /**
     * When a user successfully authenticated a reference to the user should be saved.
     *
     * @param user Reference to authenticated user
     */
    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    /**
     * Saves the state if the authentication is successful.
     *
     * @param username The account the user try to authenticate
     * @param password The password to the account to the user try to authenticate
     * @return
     */
    public Result login(String username, String password) {
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
