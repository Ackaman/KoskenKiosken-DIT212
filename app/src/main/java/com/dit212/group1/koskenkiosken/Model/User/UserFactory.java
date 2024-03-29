package com.dit212.group1.koskenkiosken.Model.User;


/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 * Responsibility: creation of a User into IAccount public interface.
 * Uses: IAccount, User
 */

public class UserFactory {

    /**
     * Factory method for `User` objects
     *
     * @param name The account's username.
     * @param credits The amount of credits the `User` should have at creation.
     *
     * @return A `User` object
     */
    public static IAccount create(String name, int credits, String password){
        return new User(name, credits, password);
    }

    /**
     * Factory for a user account with predefined values.
     *
     * @return a `User` object with predefined values.
     */

    public static IAccount createMockUser(){
        return new User(
                "FirstUser",
                10,
                "password");
    }
}
