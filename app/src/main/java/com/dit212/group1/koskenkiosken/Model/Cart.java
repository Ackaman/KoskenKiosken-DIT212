package com.dit212.group1.koskenkiosken.Model;

import java.util.List;

public class Cart implements ICart {
    private List<IProduct> products;


    @Override
    public void addToCart(IProduct product) {
        products.add(product);
    }

    @Override
    public void removeOneFromCart(IProduct product) {
    products.remove(product);
    }

    @Override
    public void removeFromCart(IProduct product) {

    }

    @Override
    public void emptyCart() {
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public List<IProduct> viewCart() {
        return null;
    }
}
