package com.dit212.group1.koskenkiosken.Model.User.AuthenticationStrategies;

/**
 * @author Albin Otterhäll
 *
 * Factory for making `AuthenticationStrategy` objects.
 */

public class UsernamePasswordStrategyFactory implements AuthenticationStrategyFactory {

    /**
     * A factory for creating authentication strategies using username and password.
     *
     * @param password The user's password
     * @param eMailAddress The user's email address
     * @return A authentication strategy
     */
    public static AuthenticationStrategy create(String password, String eMailAddress) {
        return new UsernamePasswordStrategy(password, eMailAddress);
    }

}
