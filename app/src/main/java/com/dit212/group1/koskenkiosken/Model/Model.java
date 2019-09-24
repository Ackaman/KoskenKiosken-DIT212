package com.dit212.group1.koskenkiosken.Model;

import java.util.ArrayList;

public class Model {
    private final ArrayList<Product> productList;
    private final IDatabase db;

    public Model(IDatabase persistentStorage){
        db = persistentStorage;
        productList = new ArrayList<>();
    }




}
