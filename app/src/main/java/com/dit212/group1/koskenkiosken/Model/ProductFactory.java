package com.dit212.group1.koskenkiosken.Model;

/**
 * Author: created by thowsen, 2019-09-24
 * Description: Factory class for product.
 */
public class ProductFactory {

    public static IProduct create(String name, int price){
        return new Product(name, price);
    }
}
