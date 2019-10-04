package com.dit212.group1.koskenkiosken.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Model {
    private final ArrayList<Product> productList;
    private Cart cart;
    private User loggedInUser;

    /**
     * constructor
     */

    public Model(){
        productList = new ArrayList<>();
        cart = new Cart();
    }

    /**
     * sets a logged in user.
     * @param user the user to be logged in
     */

    public void setLoggedInUser(IAccount user){
        this.loggedInUser = (User) user;
    }

    /**
     * parses IProducts from a persistent storage.
     * @param db the persistent storage of which to parse data from.
     */

    public void parseFromIDatabase(IDatabase db){
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
    public ICart getCart() {
        return cart;
    }

    /**
     * add product to cart.
     * @param product product to add to cart.
     */
    public void addToCart(IProduct product){
        cart.addToCart(product);
    }

    public int getSizeOfCart(){
        return cart.getSizeofCart();
    }

    /**
     * returns a filtered version of the inventory.
     * @param filter the string filter of which to filter.
     * @return the filtered list.
     */

    public List<IProduct> filterListByString(String filter){
        ArrayList<IProduct> sortedProduct = new ArrayList<>();
        for (IProduct product : productList) {
            if (product.getName().toLowerCase().contains(filter.toLowerCase())) {
                sortedProduct.add(product);
            }
        }
        return sortedProduct;
    }

    /**
     * returns a sorted product list.
     * @param comp the comparator of which to use to sort.
     * @return a sorted list.
     */
    public List<IProduct> sortProducts(Comparator<IProduct> comp){
        List<IProduct> products = new ArrayList<>(listOfProducts());
        Collections.sort(products,comp);
        Log.i("MODEL",products.toString());
        return products;
    }
}
