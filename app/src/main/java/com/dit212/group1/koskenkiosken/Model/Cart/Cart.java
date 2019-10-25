package com.dit212.group1.koskenkiosken.Model.Cart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Morgan Thowsen
 * Responsibility: representation of a cart. A small interface of the internal structure.
 * Uses: none
 */

public class Cart<T> implements ICart<T> {
    private ArrayList<T> items;

    /**
     * constructor
     */
    public Cart(){
        items = new ArrayList<>();
    }

    /**
     * adds an item to the cart.
     * @param item the product to add to the cart.
     */
    @Override
    public void addToCart(T item) {
        items.add(item);
    }

    /**
     * removes a product from the cart.
     * @param item the product to remove
     */
    @Override
    public void removeFromCart(T item) {
        items.remove(item);
    }

    /**
     * replaces the old cart list with a new one.
     */
    @Override
    public void emptyCart() {
        items = new ArrayList<>();
    }


    /**
     * returns the list of all IProducts (interface for incapsulation)
     * @return the list of all products in cart.
     */
    @Override
    public List<T> viewCart() {
        return items;
    }

    /**
     * replaces the list of products in the cart with a new list.
     * @param products the products in cart.
     */
    public void setCart(List<T> products) {
        this.items = new ArrayList<>(products);
    }

    /**
     * Gives the total size of the cart.
     * @return the number of elements in the cart
     */
    @Override
    public int getSizeofCart() {
        return items.size();
    }


}
