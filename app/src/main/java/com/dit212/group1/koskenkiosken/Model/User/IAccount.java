package com.dit212.group1.koskenkiosken.Model.User;

/**
 * Author: created by thowsen, 2019-09-24
 * Description: simple user abstraction. Outside actors should not have access to methods they don't use.
 */
public interface IAccount {

    /**
     * the name of the user
     *
     * @return the name of the user.
     */
    String getUserName();

    /**
     * the number of credits the user has
     *
     * @return the number of credits the user has
     */
    int getCredits();

    /**
     * Debits the user an amount of credits for a purchase
     *
     * @param sumOfPrice the sum of which to debit.
     */
    IAccount purchase(int sumOfPrice);

    /**
     * checks if an account has enough credits to make a purchase
     *
     * @param sum the sum of which to check
     * @return false if user has insufficient funds.
     */
    boolean canMakePurchase(int sum);

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
    IAccount setPassword(String password);

    /**
     * Gives you a new user object with the new e-mail address.
     *
     * @param eMailAddress The new e-mail address
     * @return A new user object
     */
    IAccount setEMailAddress(String eMailAddress);
}
