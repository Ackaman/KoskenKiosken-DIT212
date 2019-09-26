package com.dit212.group1.koskenkiosken.Model;

import java.util.List;

public interface ICart {
    void addToCart(IProduct product);
    void removeOneFromCart(IProduct product);
    void removeFromCart(IProduct product);
    void emptyCart();
    int  getPrice();
    List<IProduct> viewCart();
}