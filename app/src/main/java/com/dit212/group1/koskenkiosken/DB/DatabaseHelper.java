package com.dit212.group1.koskenkiosken.DB;

import com.dit212.group1.koskenkiosken.Model.IDatabase;
import com.dit212.group1.koskenkiosken.Model.IProduct;
import com.dit212.group1.koskenkiosken.Model.ProductFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: created by thowsen, 2019-09-23
 * Description: singleton class that simulates a persistent storage for products.
 * could've been static but it's not permitted until API24. therefor, singleton.
 */
public class DatabaseHelper implements IDatabase {

    private static DatabaseHelper dh;

    /**
     * hidden constructor for
     */
    private DatabaseHelper(){}

    /**
     * mocked list of product from "data storage".
     * @return a list of products from storage.
     */
    @Override
    public List<IProduct> readProducts() {
        ArrayList<IProduct> productsList = new ArrayList<>();
        productsList.add(ProductFactory.create("Chokladboll", 2, "description 1"));
        productsList.add(ProductFactory.create("Nocco", 1,"description 2"));
        productsList.add(ProductFactory.create("HariboNallar", 3,"description 3"));
        productsList.add(ProductFactory.create("Kaffepaket", 4,"description 4"));
        return productsList;
    }

    /**
     * mocked method for serializing to database.
     */
    @Override
    public void writeProducts() {}

    /**
     * singleton "constructor"
     * @return an instance of DatabaseHelper.
     */
    public static DatabaseHelper getDatabaseHelper(){
        if (dh != null) return dh;
        return new DatabaseHelper();
    }
}
