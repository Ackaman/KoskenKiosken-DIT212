package com.dit212.group1.koskenkiosken.DB;

/**
 * @author Morgan Thowsen
 * Uses: none.
 * Description: Interface for abstracting implementation of persistent storage solutions.
 */
public interface IPersistentStorage {

    /**
     * tell IPersistentStorage to fetch data from storage.
     * @return json-object with data.
     */

    String getJsonData();

    /**
     * writes data to persistent storage.
     * @param json data in json-format to write to persistent storage
     */
    void writeToDB(String json);

    /**
     * Writes data with the user and the recommended product to persistent storage
     * @param json data in json-format to write to persistent storage
     */
    void writeRecommendedProductToDb(String json);
}
