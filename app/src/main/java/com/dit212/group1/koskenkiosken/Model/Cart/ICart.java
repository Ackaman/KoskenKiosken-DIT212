package com.dit212.group1.koskenkiosken.Model.Cart;

import java.util.List;

public interface ICart<T> {
    /**
     * adds a product to the cart
     * @param item the product to add to the cart.
     */
    void addToCart(T item);

    /**
     * removes a product in the cart.
     * @param item the product to remove.
     */
    void removeFromCart(T item);

    /**
     * empties the cart.
     */
    void emptyCart();

    /**
     * gives a list of all the products in the cart
     * @return a list of all the products in the cart.
     */
    List<T> viewCart();

    /**
     * sets the cart "inventory" to a new one.
     * @param list the list of products of which to replace the cart with.
     */
    void setCart(List<T> list);

    /**
     * gives the number of products in the cart
     * @return the number of elements in the cart
     */
    int getSizeofCart();
}