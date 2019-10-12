package com.dit212.group1.koskenkiosken.Model.User;


/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 *
 * A factory class that create objects of the `User` class.
 */
public class UserFactory implements IAccountFactory {

    /**
     * factory method to create IAccount
     * @param name the name to give the constructed user.
     * @param credits the number of credits to give the constructed user.
     * @return the constructed user.
     */
    public static IAccount create(String name, int credits){
        return new User(name, credits);
    }

    /**
     * factory method to create mock IAccount
     * @return a constructed mockUser.
     */

    public static IAccount createMockUser(){
        return new User("FirstUser", 10);
    }
}
