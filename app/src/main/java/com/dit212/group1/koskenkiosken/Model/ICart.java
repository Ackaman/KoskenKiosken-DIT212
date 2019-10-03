package com.dit212.group1.koskenkiosken.Model;

import java.util.List;

public interface ICart {
    /**
     * adds a product to the cart
     * @param product the product to add to the cart.
     */
    void addToCart(IProduct product);

    /**
     * removes a product in the cart.
     * @param product the product to remove.
     */
    void removeFromCart(IProduct product);

    /**
     * empties the cart.
     */
    void emptyCart();

    /**
     * the total price of products in the cart
     * @return the total price of products in the cart.
     */
    int  getPrice();

    /**
     * gives a list of all the products in the cart
     * @return a list of all the products in the cart.
     */
    List<IProduct> viewCart();

    /**
     * sets the cart "inventory" to a new one.
     * @param list the list of products of which to replace the cart with.
     */
    void setCart(List<IProduct> list);

    /**
     * gives the number of products in the cart
     * @return the number of elements in the cart
     */
    int getSizeofCart();
}