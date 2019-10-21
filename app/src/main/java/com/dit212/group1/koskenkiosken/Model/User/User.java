package com.dit212.group1.koskenkiosken.Model.User;

/**
 * @author Albin Otterhäll
 *
 * Immutable representation of a user.
 */
class User implements IAccount {

    final private String userName;
    final private int credits;

    /**
     * The user's password in plaintext
     */
    final private String password;

    /**
     * The user's e-mail address in plaintext
     */
    final private String eMailAddress;

    /**
     * constructor
     * @param userName the name to set of the constructed user.
     * @param credits the number of credits to give the contructed user.
     * @param password TODO
     * @param eMailAddress TODO
     */
    User(String userName, int credits, String password, String eMailAddress) {
        this.userName = userName;
        this.credits = credits;
        this.password = password;
        this.eMailAddress = eMailAddress;
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
        return new User(userName, credits - sumOfPrice, this.password, this.eMailAddress);
    }

    /**
     * checks if an account has enough credits to make a purchase
     * @param sum the sum of which to check
     * @return false if user has insufficient funds.
     */
    public boolean canMakePurchase(int sum) {
        return sum <= credits;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getEMailAddress() {
        return this.eMailAddress;
    }

    @Override
    public IAccount setPassword(String password) {
        return UserFactory.create(this.userName, this.credits, password, this.eMailAddress);
    }

    @Override
    public IAccount setEMailAddress(String eMailAddress) {
        return UserFactory.create(this.userName, this.credits, this.password, eMailAddress);
    }
}
