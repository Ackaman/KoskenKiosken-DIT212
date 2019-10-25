package com.dit212.group1.koskenkiosken.Model.Product;

import java.io.Serializable;

/**
 * @author Morgan Thowsen 2019-09-24
 * Responsibility: simple product abstraction. Exposing a portion of internal structure of Product
 * Uses: None (Serializable)
 * Description: Immutable
 */

class Product implements IProduct, Serializable {

    final private String name;
    final private int price;
    final private String description;

    /**
     * constructor.
     * @param name the name of the product being constructed
     * @param price the price of the product being constructed
     * @param description the description of the product being constructed
     */

    Product(String name, int price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * get the name of a given product.
     * @return the name of a given product
     */

    public String getName() {
        return name;
    }

    /**
     * get the price of a given product
     * @return the price of a given product
     */

    public int getPrice() {
        return price;
    }

    /**
     * gets the description of the product. (ex. kolsyrad energidryck).
     * @return the description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns the name of the product.
     * @return the name of the product.
     */
    @Override
    public String toString() {
        return getName();
    }
}
