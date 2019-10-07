package com.dit212.group1.koskenkiosken.DB;

import com.dit212.group1.koskenkiosken.Model.IProduct;
import com.dit212.group1.koskenkiosken.Model.ProductFactory;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by morgan on 2019-10-07
 * <p>
 * TODO , add comment
 */
public class JSONparser<T extends Serializable>  implements IPersistentStorage{

    private String json;

    JSONparser(){
        ArrayList<IProduct> productsList = new ArrayList<>();
        productsList.add(ProductFactory.create("Chokladboll", 2, "description 1"));
        productsList.add(ProductFactory.create("Nocco", 1,"description 2"));
        productsList.add(ProductFactory.create("HariboNallar", 3,"description 3"));
        productsList.add(ProductFactory.create("Kaffepaket", 4,"description 4"));

        Gson g = new Gson();
        json = g.toJson(productsList.toArray(), IProduct[].class);
    }

    @Override
    public String getJsonData() {
        return json;
    }

    @Override
    public void writeToDB(String json) {

    }
}
