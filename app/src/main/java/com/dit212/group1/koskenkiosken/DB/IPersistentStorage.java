package com.dit212.group1.koskenkiosken.DB;

import java.io.Serializable;

/**
 * Created by morgan on 2019-10-07
 * <p>
 * TODO , add comment
 */
public interface IPersistentStorage {
    String getJsonData();
    void writeToDB(String json);
}
