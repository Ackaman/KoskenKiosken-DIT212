package com.dit212.group1.koskenkiosken.DB;

import com.dit212.group1.koskenkiosken.Model.IDatabase;
import com.dit212.group1.koskenkiosken.Model.Product.IProduct;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.List;

/**
 * @author Morgan Thowsen
 *
 * Description: singleton class that simulates a persistent storage for products.
 * could've been static but it's not permitted until API24. therefor, singleton.
 * Uses: IDatabase, IProduct, JSONparser, IProductDeserializer, IPersistentStorage.
 * delegates deserialization to IProductDeserializer because of Factory Pattern and
 * hidden constructor.
 */
public class DatabaseHelper implements IDatabase {
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
        String j = database.getJsonData();
        JsonElement je = g.fromJson(j, JsonElement.class);
        JsonArray jo = je.getAsJsonArray();
        return IProductDeserializer.deserialize(jo);
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
     * Writes the recommended product to the Database
     * @param productToRecommend    The product which the user recommends
     * @param name      The name of the user who recommended the product
     */
    @Override
    public void writeProductRecommendation(String productToRecommend, String name) {
        String[] s = {productToRecommend, name};
        String json = g.toJson(s);
        database.writeRecommendedProductToDb(json);
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
