package com.dit212.group1.koskenkiosken.Model;

import android.os.Parcelable;

/**
 * Author: created by thowsen, 2019-09-24
 * Description: simple product abstraction. Outside actors should not have access to methods they don't use.
 */
public interface IProduct extends Parcelable {
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
    IProduct setName(String name);
}
