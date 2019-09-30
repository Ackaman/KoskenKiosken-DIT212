package com.dit212.group1.koskenkiosken.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Model {
    private final ArrayList<Product> productList;
    private Cart cart;
    private final User loggedInUser;

    /**
     * constructor
     * @param persistentStorage the persistent storage of which to read and write to.
     * @param loggedInUser the user which is logged in.
     */

    public Model(IDatabase persistentStorage, IAccount loggedInUser){
        productList = new ArrayList<>();
        readFromStorage(persistentStorage);
        cart = new Cart();

        this.loggedInUser = (User) loggedInUser;
    }

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
        List<IProduct> products = new ArrayList<IProduct>(productList);
        Collections.sort(products,comp);
        return products;
    }
}
