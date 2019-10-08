package com.dit212.group1.koskenkiosken.DB;

import com.dit212.group1.koskenkiosken.Model.IDatabase;
import com.dit212.group1.koskenkiosken.Model.IProduct;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: created by thowsen, 2019-09-23
 *
 * Description: singleton class that simulates a persistent storage for products.
 * could've been static but it's not permitted until API24. therefor, singleton.
 *
 * delegates deserialization to IProductDeserializer because of Factory Pattern and
 * hidden constructor.
 */
public class DatabaseHelper implements IDatabase {
    private static String TAG = "DatabaseHelper"; // used for debugging
    private static DatabaseHelper dh;
    private static IPersistentStorage database = new JSONparser();
    private static Gson g = new Gson();

    /**
     * hidden constructor for singleton pattern.
     */
    private DatabaseHelper(){}

    /**
     * mocked list of product from "data storage".
     * @return a list of products from storage.
     */
    @Override
    public List<IProduct> readProducts() {
        List<IProduct> out = new ArrayList<>();
        String j = database.getJsonData();
        JsonElement je = g.fromJson(j, JsonElement.class);
        JsonArray jo = je.getAsJsonArray();
        for (int i = 0; i < jo.size(); i++)
            out.add(IProductDeserializer.deserialize(jo.get(i)));
        return out;
    }

    /**
     * mocked method for writing to database.
     */
    @Override
    public void writeProducts(List<IProduct> pr) {
        IProduct[] arr = (IProduct[]) pr.toArray();
        String json = g.toJson(arr);
        database.writeToDB(json);
    }

    /**
     * singleton "constructor"
     * @return an instance of DatabaseHelper.
     */
    public static DatabaseHelper getDatabaseHelper(){
        if (dh != null) return dh;
        dh = new DatabaseHelper();
        return dh;
    }
}
