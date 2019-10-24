package com.dit212.group1.koskenkiosken.Model.User;

/**
 * @author Albin Otterhäll
 * Responsibility: User representation in the model. holds the name, password and credits.
 *                 At this stage, it also deals with the transaction. this is a temporary solution
 *                 before an actual paymenthandler is implemented.
 * Uses: IAccount
 * Description: Immutable representation of a user.
 */

class User implements IAccount {

    /**
     * The user's username.
     */
    final private String name;

    /**
     * The amount of credits the user have.
     */
    final private int credits;

    /**
     * The user's password in plaintext
     */
    final private String password;

    /**
     * The constructor for creating a user.
     *
     * @param name the name to set of the constructed user.
     * @param credits  the number of credits to give the contructed user.
     * @param password The new user's password
     */
    User(String name, int credits, String password) {
        this.name = name;
        this.credits = credits;
        this.password = password;
    }

    /**
     * get the name of a given user.
     *
     * @return the name of a given user.
     */
    public String getName() {
        return name;
    }

    /**
     * get the number of credits left for a given user.
     *
     * @return the number of credits left for a given user.
     */
    public int getCredits() {
        return credits;
    }

    /**
     * debits the user an amount of credits.
     *
     * @param sum the sum of which to debit.
     * @return a new object with drawn credits if purchase could be done.
     */
    @Override
    public IAccount purchase(int sum) {
        if (!canMakePurchase(sum)) return this;
        return new User(name, credits - sum, this.password);
    }

    /**
     * checks if an account has enough credits to make a purchase
     *
     * @param sum the sum of which to check
     * @return false if user has insufficient funds.
     */
    public boolean canMakePurchase(int sum) {
        return sum <= credits;
    }

    /**
     * Get the user's password in plaintext.
     *
     * @return A password in plaintext
     */
    @Override
    public String getPassword() {
        return this.password;
    }
}
