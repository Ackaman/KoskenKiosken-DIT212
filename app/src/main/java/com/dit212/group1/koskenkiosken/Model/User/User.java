package com.dit212.group1.koskenkiosken.Model.User;

/**
 * Immutable representation of a user.
 *
 */
class User implements IAccount {

    final private String userName;
    final private int credits;

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

    /**
     * debits the user an amount of credits.
     * @param sumOfPrice the sum of which to debit.
     * @return a new object with drawn credits if purchase could be done.
     */
    @Override
    public IAccount purchase(int sumOfPrice) {
        if (!canMakePurchase(sumOfPrice)) return this;
        return new User(userName, credits - sumOfPrice);
    }

    /**
     * checks if an account has enough credits to make a purchase
     * @param sum the sum of which to check
     * @return false if user has insufficient funds.
     */
    public boolean canMakePurchase(int sum){
        return sum <= credits;
    }
}
