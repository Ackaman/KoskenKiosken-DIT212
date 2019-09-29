package com.dit212.group1.koskenkiosken.Model;

/**
 * representation of a user.
 */
class User implements IAccount {

    private String userName;
    private int credits;

    /**
     * constructor
     * @param userName the name to set of the constructed user.
     * @param credits the number of credits to give the contructed user.
     */
    User(String userName, int credits) {
        this.userName = userName;
        this.credits = credits;
    }

    /**
     * get the name of a given user.
     * @return the name of a given user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * get the number of credits left for a given user.
     * @return the number of credits left for a given user.
     */

    public int getCredits() {
        return credits;
    }
}
