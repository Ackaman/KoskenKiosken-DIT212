package com.dit212.group1.koskenkiosken.Model.Product;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Description: Immutable representation of a product.
 */

class Product implements IProduct, Parcelable, Serializable {

    final private String name;
    final private int price;
    final private String description;

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
     * simple to string.
     * @return to string.
     */
    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
