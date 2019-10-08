package com.dit212.group1.koskenkiosken.DB;

import com.dit212.group1.koskenkiosken.Model.IProduct;
import com.dit212.group1.koskenkiosken.Model.ProductFactory;
import com.google.gson.Gson;

import java.util.ArrayList;


/**
 * Created by morgan on 2019-10-07
 *
 * Mock-class for handling the implementation of a DB.
 */
public class JSONparser implements IPersistentStorage{
    private String json;

    /**
     * constructor
     *
     * hardcoded values because we don't know how to use an API.
     */
    JSONparser(){
        ArrayList<IProduct> productsList = new ArrayList<>();
        productsList.add(ProductFactory.create("Chokladboll", 2, "description 1"));
        productsList.add(ProductFactory.create("Nocco", 1,"description 2"));
        productsList.add(ProductFactory.create("HariboNallar", 3,"description 3"));
        productsList.add(ProductFactory.create("Kaffepaket", 4,"description 4"));

        Gson g = new Gson();
        json = g.toJson(productsList.toArray(), IProduct[].class);
    }

    /**
     * returns Json string
     * @return
     */
    @Override
    public String getJsonData() {
        return json;
    }

    /**
     * empty method since no API is used.
     * @param json json string of which to write.
     */
    @Override
    public void writeToDB(String json) {
    }


}
