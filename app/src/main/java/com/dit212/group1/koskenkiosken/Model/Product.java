package com.dit212.group1.koskenkiosken.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Description: representation of a product.
 */

class Product implements IProduct, Parcelable {

    private String name;
    private int price;
    private String description;

    /**
     * constructor.
     * @param name the name of the product being constructed
     * @param price the price of the product being constructed
     * @param description the description of the product being constructed
     */

    Product(String name, int price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    protected Product(Parcel in) {
        name = in.readString();
        price = in.readInt();
        description = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * set the price of a given product
     * @param price the price to set of a given product
     */

    void setPrice(int price) {
        this.price = price;
    }


    public Product getObject() {
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeString(description);
    }
}
