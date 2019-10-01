package com.dit212.group1.koskenkiosken.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

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

    private Product(Parcel in) {
        name = in.readString();
        price = in.readInt();
        description = in.readString();
    }

    /**
     * parcelable constructor
     */

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

    public IProduct setName(String name) {
        return ProductFactory.create(name, this.price, this.description);
    }

    /**
     * get the price of a given product
     * @return the price of a given product
     */

    public int getPrice() {
        return price;
    }

    /**
     * gets the description of the product. (ex. kolsyrad energidryck).
     * @return the description of the product.
     */
    public String getDescription() {
        return description;
    }

    /**
     * updated the description of a product.
     * @param description the description ot give the product (ex. kolsyrad dryck)
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * not used
     * @return not used.
     */
    @Override
    public IProduct setPrice(int price) {
        return ProductFactory.create(this.name, price, this.description);
    }

    public Product getObject() {
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * flattening a product to a serialized object.
     * @param dest the container of which to put the flattened product.
     * @param flags not used.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeString(description);
    }

    /**
     * updates the price of a product
     * @param price the price of which to give the product.
     */
    void setPrice(int price){ this.price = price;}

    /**
     * simple to string.
     * @return to string.
     */
    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
