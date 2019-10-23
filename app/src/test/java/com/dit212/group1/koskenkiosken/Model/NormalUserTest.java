package com.dit212.group1.koskenkiosken.Model;

import com.dit212.group1.koskenkiosken.Model.User.IAccount;
import com.dit212.group1.koskenkiosken.Model.User.UserFactory;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Primary author: Albin Otterhäll <gusalbiot@student.gu.se>
 */

public class NormalUserTest {
    private IAccount user;

    @Before
    public void setUp(){
        user = UserFactory.create("John Smith", 100);
    }

    @Test
    public void nameIsCorrect() {
        assertThat(user.getName(), equalTo("John Smith"));
    }

    @Test
    public void getCredits() {
        assertThat(user.getCredits(), equalTo(100));
    }

    /**
     * Tests whether the balance is correct after the transaction.
     */
    @Test
    public void purchaseWhenUserHasSufficientCreditsAndCheckThatTheNewBalanceIsCorrect(){
        int newBalance = user.purchase(70).getCredits();
        assertEquals(30, newBalance);
    }

    /**
     * Tests that the credits is unchanged if the transaction fails.
     */
    @Test
    public void purchaseWhenUserDoesNotHaveSufficientCreditsAndCheckThatTheCreditsIsStillAt100(){
        int newBalance = user.purchase(150).getCredits();
        assertEquals(100, newBalance);
    }

    /**
     * Test that the credits is unchanged when the price is 0
     */
    @Test
    public void purchaseWhenPriceIsZeroAndCheckThatTheBalanceIsNotChanged(){
        int newBalance = user.purchase(0).getCredits();
        assertEquals(100, newBalance);
    }



    /**
     * Tests if the user can make a purchase when having sufficient credits
     */
    @Test
    public void canMakePurchaseUserHasSufficientCredits(){
        assertTrue(user.canMakePurchase(50));
    }

    /**
     * Tests whether the user can make a purchase when credits is lower than the checkout-price
     */
    @Test
    public void canMakePurchaseUserHasNotSufficientCredits(){
        assertFalse(user.canMakePurchase(101));
    }

    /**
     * Tests whether the user can make a purchase when having exactly the same credits as the
     * checkout-price
     */
    @Test
    public void canMakePurchaseUserHasExactlyTheSufficientCredits() {
        assertTrue(user.canMakePurchase(100));
    }
}