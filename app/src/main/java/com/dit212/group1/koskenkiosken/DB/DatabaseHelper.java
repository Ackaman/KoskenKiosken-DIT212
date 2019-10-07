package com.dit212.group1.koskenkiosken.DB;

import android.os.Debug;
import android.util.Log;

import com.dit212.group1.koskenkiosken.Model.IDatabase;
import com.dit212.group1.koskenkiosken.Model.IProduct;
import com.dit212.group1.koskenkiosken.Model.ProductFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: created by thowsen, 2019-09-23
 * Description: singleton class that simulates a persistent storage for products.
 * could've been static but it's not permitted until API24. therefor, singleton.
 */
public class DatabaseHelper implements IDatabase {

    private static DatabaseHelper dh;
    private static IPersistentStorage database = new JSONparser<IProduct>();

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
        GsonBuilder builder = new GsonBuilder();
        List<IProduct> out = new ArrayList<>();
        String j = database.getJsonData();
        Gson g = new Gson();
        JsonElement je = g.fromJson(j, JsonElement.class);
        JsonArray jo = je.getAsJsonArray();
        for (int i = 0; i < jo.size(); i++)
            out.add(IProductDeserializer.deserialize(jo.get(i)));

        Log.i("HEEEEEEEEEEEEEEEEEEEEJ", out.toString());
        Log.i("HEEEEEEEEEEEEEEEEEEEEJ", out.toString());
        Log.i("HEEEEEEEEEEEEEEEEEEEEJ", out.toString());
        Log.i("HEEEEEEEEEEEEEEEEEEEEJ", out.toString());
        Log.i("HEEEEEEEEEEEEEEEEEEEEJ", out.toString());
        Log.i("HEEEEEEEEEEEEEEEEEEEEJ", out.toString());
        Log.i("HEEEEEEEEEEEEEEEEEEEEJ", out.toString());
        Log.i("HEEEEEEEEEEEEEEEEEEEEJ", out.toString());
        Log.i("HEEEEEEEEEEEEEEEEEEEEJ", out.toString());
        Log.i("HEEEEEEEEEEEEEEEEEEEEJ", out.toString());
        return out;
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
