package com.dit212.group1.koskenkiosken.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.dit212.group1.koskenkiosken.StoreFragment;

import java.util.ArrayList;
import java.util.List;

public class Model implements Parcelable {
    private final ArrayList<Product> productList;
    private ArrayList<Product> cart;
    private final User loggedInUser;

    /**
     * constructor
     * @param persistentStorage the persistent storage of which to read and write to.
     * @param loggedInUser the user which is logged in.
     */

    public Model(IDatabase persistentStorage, IAccount loggedInUser){
        productList = new ArrayList<>();
        readFromStorage(persistentStorage);
        cart = new ArrayList<>();

        this.loggedInUser = (User) loggedInUser;
    }

    protected Model(Parcel in) {
        productList = in.createTypedArrayList(Product.CREATOR);
        cart = in.createTypedArrayList(Product.CREATOR);
        loggedInUser = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    /**
     * parses a list provided by IDatabase to internal list and hard casts them to Product.
     * @param db the db providing list of IProduct
     */
    private void readFromStorage(IDatabase db){
        List<IProduct> listFromDB =  db.readProducts();
        for (IProduct p: listFromDB) {
            Product p2 = (Product) p;
            productList.add(p2);
        }
    }

    /**
     * converts Products to IProduct for incapsulation purposes and returns the full list.
     * @return a list of IProducts mirrored from internal productList
     */

    public List<IProduct> listOfProducts(){
        return new ArrayList<IProduct>(productList);
    }

    /**
     * returns the currently logged in User.
     * @return the logged in user.
     */
    public IAccount getLoggedInUser(){
        return loggedInUser;
    }

    /**
     * get the cart from the model
     * @return the shopping cart in the model.
     */
    public ArrayList<IProduct> getCart() {
        return new ArrayList<IProduct>(cart);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(productList);
        dest.writeTypedList(cart);
        dest.writeParcelable(loggedInUser, flags);
    }

    /*public void setCart(ArrayList<IProduct> newCart) {
        //cart = newCart;
    }*/


}
