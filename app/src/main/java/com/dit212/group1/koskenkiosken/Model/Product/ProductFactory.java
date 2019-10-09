package com.dit212.group1.koskenkiosken.Model.Product;

/**
 * Author: created by thowsen, 2019-09-24
 * Description: Factory class for product.
 */
public class ProductFactory {

    /**
     * creates a product incapsulated in IProduct
     * @param name the name of which to give the product
     * @param price the price of which to give the product
     * @param description the description  of which to give the product
     * @return the constructed product.
     */
    public static IProduct create(String name, int price, String description){
        return new Product(name, price, description);
    }
}
