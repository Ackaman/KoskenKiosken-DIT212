package com.dit212.group1.koskenkiosken.Model.Product;
import java.io.Serializable;


 /**
 * @author Morgan Thowsen 2019-09-24
 * Responsibility: simple product abstraction. Exposing a portion of internal structure of Product
 * Uses: None (Serializable).
 */
public interface IProduct extends Serializable {
    /**
     * get the name of the product
     * @return the name of the product
     */
    String getName();

    /**
     * returns the price of a given product
     * @return the price of a given product.
     */
    int getPrice();

    /**
     * the description of a given product.
     * @return the description of a given product.
     */
    String getDescription();
}
