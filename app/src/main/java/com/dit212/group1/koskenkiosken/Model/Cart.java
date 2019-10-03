package com.dit212.group1.koskenkiosken.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart implements ICart {
    private ArrayList<IProduct> products;

    /**
     * constructor
     */
    Cart(){
        products = new ArrayList<>();
    }

    /**
     * adds an item to the cart.
     * @param product the product to add to the cart.
     */
    @Override
    public void addToCart(IProduct product) {
        products.add(product);
    }

    /**
     * removes a product from the cart.
     * @param product the product to remove
     */
    @Override
    public void removeFromCart(IProduct product) {
        products.remove(product);
    }

    /**
     * replaces the old cart list with a new one.
     */
    @Override
    public void emptyCart() {
        products = new ArrayList<>();
    }

    /**
     * sums the price of all items in cart.
     * @return the sum of all item prices in cart.
     */
    @Override
    public int getPrice() {
        int sum = 0;
        for (IProduct p : products)
            sum = sum + p.getPrice();
        return sum;
    }

    /**
     * returns the list of all IProducts (interface for incapsulation)
     * @return the list of all products in cart.
     */
    @Override
    public List<IProduct> viewCart() {
        return products;
    }

    /**
     * replaces the list of products in the cart with a new list.
     * @param products the products in cart.
     */
    public void setCart(List<IProduct> products) {
        this.products = new ArrayList<>(products);
    }

    /**
     * Gives the total size of the cart.
     * @return the number of elements in the cart
     */
    @Override
    public int getSizeofCart() {
        return products.size();
    }


}
