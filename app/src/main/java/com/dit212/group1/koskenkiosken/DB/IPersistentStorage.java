package com.dit212.group1.koskenkiosken.DB;

/**
 * Created by morgan on 2019-10-07
 *
 * Interface for abstracting implementation of persistent storage solutions.
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
}