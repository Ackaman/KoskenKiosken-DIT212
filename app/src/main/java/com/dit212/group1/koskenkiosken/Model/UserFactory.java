package com.dit212.group1.koskenkiosken.Model;

/**
 * Author: created by thowsen, 2019-09-24
 * Description:
 */
public class UserFactory {

    /**
     * factory method to create IUser
     * @param name the name to give the constructed user.
     * @param credits the number of credits to give the constructed user.
     * @return the constructed user.
     */
    public static IUser create(String name, int credits){
        return new User(name, credits);
    }

    /**
     * factory method to create mock IUser
     * @return a constructed mockUser.
     */

    public static IUser createMock(){
        return new User();
    }
}
