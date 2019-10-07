package com.dit212.group1.koskenkiosken.DB;

import com.dit212.group1.koskenkiosken.Model.IProduct;
import com.dit212.group1.koskenkiosken.Model.ProductFactory;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * Created by morgan on 2019-10-07
 * <p>
 * TODO , add comment
 */
class IProductDeserializer {

    static IProduct deserialize(JsonElement jsonElement) throws JsonParseException {
        String name = jsonElement.getAsJsonObject().get("name").getAsString();
        int price = jsonElement.getAsJsonObject().get("price").getAsInt();
        String desc = jsonElement.getAsJsonObject().get("description").getAsString();

        if (name != null && desc != null) {
            return ProductFactory.create(name, price, desc);
        } else {
            throw new JsonParseException("could not create product");
        }
    }

}
