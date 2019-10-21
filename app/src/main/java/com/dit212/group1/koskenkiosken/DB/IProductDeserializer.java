package com.dit212.group1.koskenkiosken.DB;

import com.dit212.group1.koskenkiosken.Model.Product.IProduct;
import com.dit212.group1.koskenkiosken.Model.Product.ProductFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by morgan on 2019-10-07
 *
 * class for delegating creation of IProduct with Factory.
 */
class IProductDeserializer {

    /**
     * method for deserializing Json-IProducts via ProductFactory.
     *
     * @param jsonElement a Json-object representation of an IProduct.
     * @return deserialized IProduct
     * @throws JsonParseException throw exception if JSON-file was invalid.
     */
    private static IProduct deserialize(JsonElement jsonElement) throws JsonParseException {
        String name = jsonElement.getAsJsonObject().get("name").getAsString();
        int price = jsonElement.getAsJsonObject().get("price").getAsInt();
        String desc = jsonElement.getAsJsonObject().get("description").getAsString();

        if (name != null && desc != null) {
            return ProductFactory.create(name, price, desc);
        } else {
            throw new JsonParseException("could not create product");
        }
    }

    /**
     * mass deserialization of a JsonArray to list of IProduct
     * @param jsonArray the array of flattened IProducts.
     * @return a list of the constructed IProducts.
     */

    static List<IProduct> deserialize(JsonArray jsonArray){
        List<IProduct> out = new LinkedList<>();
        for (JsonElement j : jsonArray){
            out.add(deserialize(j));
        }
        return out;
    }

}
