package com.dit212.group1.koskenkiosken.Model.Product;

/**
 * @author Morgan Thowsen 2019-09-24
 * Responsibility: creation of a product to public IProduct interface.
 * Uses: IProduct, Product
 * Description: Factory class for Product.
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
