package com.dit212.group1.koskenkiosken.Model.AuthenticationStrategies;

/**
 * @author Albin Otterhäll
 *
 * Strategy for authenticating the user using username and password
 */

public class UsernamePasswordStrategy implements AuthenticationStrategy {
    /**
     * The user's password in plaintext
     */
    final private String password;

    /**
     * The user's e-mail address in plaintext
     */
    final private String eMailAddress;

    /**
     * 
     * @param password
     * @param eMailAddress
     */
    UsernamePasswordStrategy(String password, String eMailAddress) {
        this.password = password;
        this.eMailAddress = eMailAddress;
    }

    /**
     * Gives you the user's password in plaintext
     *
     * @return The user's password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Gives you the user's e-mail address in plaintext
     *
     * @return The user's e-mail address
     */
    @Override
    public String getEMailAddress() {
        return eMailAddress;
    }

    /**
     * Creates a new authentication strategy with the new password.
     *
     * @param password The user's new password
     * @return A new object
     */
    @Override
    public AuthenticationStrategy setPassword(String password) {
        return UsernamePasswordStrategyFactory.create(password, this.eMailAddress);
    }

    /**
     * Creates a new authentication strategy with the new e-mail address.
     * 
     * @param eMailAddress The user's new e-mail address
     * @return A new object
     */
    @Override
    public AuthenticationStrategy setEMailAddress(String eMailAddress) {
        return UsernamePasswordStrategyFactory.create(this.password, eMailAddress);
    }
}
