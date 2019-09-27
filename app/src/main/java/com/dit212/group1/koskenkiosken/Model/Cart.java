package com.dit212.group1.koskenkiosken.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart implements ICart {
    private ArrayList<IProduct> products;

    Cart(){
        products = new ArrayList<>();
    }

    @Override
    public void addToCart(IProduct product) {
        products.add(product);
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
        return products;
    }

    public void setCart(List<IProduct> products) {
        this.products = new ArrayList<>(products);
    }
}
