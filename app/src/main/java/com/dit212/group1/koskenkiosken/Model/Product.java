package com.dit212.group1.koskenkiosken.Model;

/**
 * Description: representation of a product.
 */

class Product implements IProduct {

    private String name;
    private int price;

    /**
     * constructor.
     * @param name the name of the product being constructed
     * @param price the price of the product being constructed
     */

    Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    /**
     * get the name of a given product.
     * @return the name of a given product
     */

    public String getName() {
        return name;
    }

    /**
     * set the name of a given product
     * @param name the name to set of a given product
     */

    void setName(String name) {
        this.name = name;
    }

    /**
     * get the price of a given product
     * @return the price of a given product
     */

    public int getPrice() {
        return price;
    }

    /**
     * set the price of a given product
     * @param price the price to set of a given product
     */

    void setPrice(int price) {
        this.price = price;
    }
}
