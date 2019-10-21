package com.dit212.group1.koskenkiosken.Model.User.AuthenticationStrategies;

/**
 * @author Albin Otterhäll
 *
 * A common interface for the different authentication strategies.
 */

public interface AuthenticationStrategy {

    /**
     * Gives you the user's password in plaintext.
     *
     * @return The user's password
     */
    String getPassword();

    /**
     * Gives you the user's e-mail address in plaintext.
     *
     * @return The user's e-mail address
     */
    String getEMailAddress();

    /**
     * Gives you a new user object with the new password.
     *
     * @param password The new password
     * @return A new user object
     */
    AuthenticationStrategy setPassword(String password);

    /**
     * Gives you a new user object with the new e-mail address.
     *
     * @param eMailAddress The new e-mail address
     * @return A new user object
     */
    AuthenticationStrategy setEMailAddress(String eMailAddress);
}
