package com.dit212.group1.koskenkiosken.Model.User;

/**
 * Author: created by thowsen, 2019-09-24
 * Description: simple user abstraction. Outside actors should not have access to methods they don't use.
 */
public interface IAccount {

    /**
     * the name of the user
     * @return the name of the user.
     */
    String getUserName();

    /**
     * the number of credits the user has
     * @return the number of credits the user has
     */
    int getCredits();

    /**
     * Debits the user an amount of credits for a purchase
     * @param sumOfPrice the sum of which to debit.
     */
    IAccount purchase(int sumOfPrice);

    /**
     * checks if an account has enough credits to make a purchase
     * @param sum the sum of which to check
     * @return false if user has insufficient funds.
     */
    boolean canMakePurchase(int sum);
}
