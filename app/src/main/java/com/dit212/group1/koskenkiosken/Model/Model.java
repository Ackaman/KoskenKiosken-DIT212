package com.dit212.group1.koskenkiosken.Model;

import android.util.Log;

import com.dit212.group1.koskenkiosken.Model.Cart.Cart;
import com.dit212.group1.koskenkiosken.Model.Cart.ICart;
import com.dit212.group1.koskenkiosken.Model.Product.IProduct;
import com.dit212.group1.koskenkiosken.Model.User.IAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Model {
    private final ArrayList<IProduct> productList;
    private Cart<IProduct> cart;
    private IAccount loggedInUser;

    /**
     * constructor
     */

    public Model(){
        productList = new ArrayList<>();
        cart = new Cart<>();
    }

    /**
     * sets a logged in user.
     * @param user the user to be logged in
     */

    public void setLoggedInUser(IAccount user){
        this.loggedInUser = user;
    }

    /**
     * parses IProducts from a persistent storage.
     * @param db the persistent storage of which to parse data from.
     */

    public void parseFromIDatabase(IDatabase db){
        List<IProduct> listFromDB =  db.readProducts();
        for (IProduct p: listFromDB) {
            productList.add(p);
        }
    }

    /**
     * Sends data containing the product that was recommended, and the name of the logged in user
     * who recommended the product to the persistent storage
     * @param db the persistent storage where we send the data
     * @param productToRecommend The product that was recommended
     * @param whoRecommended The logged in user who recommended the product
     */
    public void queryRecommendedProductToDatabase(IDatabase db, String productToRecommend, String whoRecommended){
        db.writeRecommendedProductToDatabase(productToRecommend, whoRecommended);
    }

    /**
     * converts Products to IProduct for encapsulation purposes and returns the full list.
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
        for (IProduct product : listOfProducts()) {
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


    /**
     * sums the price of all items in cart.
     * @return the sum of all item prices in cart.
     */
    public int getPrice() {
        int sum = 0;
        List<IProduct> products = cart.viewCart();
        for (IProduct p : products)
            sum = sum + p.getPrice();
        return sum;
    }

}
