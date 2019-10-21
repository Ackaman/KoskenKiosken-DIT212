package com.dit212.group1.koskenkiosken.DB;


/**
 * Created by morgan on 2019-10-07
 *
 * Mock-class for handling the implementation of a DB.
 */
public class JSONparser implements IPersistentStorage{
    private String json;
    private String recommendedProductJson;

    /**
     * constructor
     *
     * hardcoded values because we don't know how to use an API.
     */
    JSONparser(){
        json = "[{\"description\":\"description 1\",\"name\":\"Chokladboll\",\"price\":2}," +
                "{\"description\":\"description 2\",\"name\":\"Nocco\",\"price\":1}," +
                "{\"description\":\"description 3\",\"name\":\"HariboNallar\",\"price\":3}," +
                "{\"description\":\"description 4\",\"name\":\"Kaffepaket\",\"price\":4}," +
                "{\"description\":\"description 4\",\"name\":\"Carlsberg\",\"price\":15}," +
                "{\"description\":\"description 4\",\"name\":\"Kaffe\",\"price\":2}," +
                "{\"description\":\"description 4\",\"name\":\"Tuggummi\",\"price\":8}," +
                "{\"description\":\"description 4\",\"name\":\"Ballerina\",\"price\":15}," +
                "{\"description\":\"description 4\",\"name\":\"Singoalla\",\"price\":9}," +
                "{\"description\":\"description 4\",\"name\":\"Naja\",\"price\":15}," +
                "{\"description\":\"description 4\",\"name\":\"Cola\",\"price\":10}]";

        recommendedProductJson = "[{\"recommendedProduct\":\"Banan\",\"user\":\"John Smith}]";
    }

    /**
     * returns Json string
     * @return json string containing data.
     */
    @Override
    public String getJsonData() {
        return json;
    }

    /**
     * empty method since no API is used.
     * @param json json string of which to write.
     */
    @Override
    public void writeToDB(String json) {
    }

    /**
     * Empty method since no API is used
     * @param json data in json-format to write to persistent storage
     */
    @Override
    public void writeRecommendedProductToDb(String json) {
        System.out.println(json);

    }

}
