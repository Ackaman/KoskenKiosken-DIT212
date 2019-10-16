package com.dit212.group1.koskenkiosken.Model;

import com.dit212.group1.koskenkiosken.Model.Product.IProduct;

import java.util.List;

/**
 * Author: created by thowsen, 2019-09-23
 * Description: simplified persistant storage solution. used for looser coupling between model and storage implementation.
 */
public interface IDatabase {
    /**
     * reads products from the persistent storage.
     * @return a list of products.
     */
    List<IProduct> readProducts();

    /**
     * writes products to persistent storage.
     */
    void writeProducts(List<IProduct> pr);
    void writeRecommendedProductToDatabase(String productToRecommend, String name);
}
