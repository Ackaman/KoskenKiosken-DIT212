package com.dit212.group1.koskenkiosken.Model;

import android.os.Debug;
import android.util.Log;
import android.view.Display;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by morgan on 2019-10-01
 * <p>
 * TODO , add comment
 */
public class ModelTest {

    private List<IProduct> products;
    @Before
    public void init(){
        products = new ArrayList<>();

        Product p1mock = Mockito.mock(Product.class);
        Mockito.when(p1mock.getName()).thenReturn("Äpple");
        Mockito.when(p1mock.getPrice()).thenReturn(5);


        Product p2mock = Mockito.mock(Product.class);
        Mockito.when(p2mock.getName()).thenReturn("Päron");
        Mockito.when(p2mock.getPrice()).thenReturn(8);


        Product p3mock = Mockito.mock(Product.class);
        Mockito.when(p3mock.getName()).thenReturn("Kitkat");
        Mockito.when(p3mock.getPrice()).thenReturn(15);


        Product p4mock = Mockito.mock(Product.class);
        Mockito.when(p4mock.getName()).thenReturn("Kaffe");
        Mockito.when(p4mock.getPrice()).thenReturn(2);

        products.add(p1mock);
        products.add(p2mock);
        products.add(p3mock);
        products.add(p4mock);
    }

    @Test
    public void listOfProducts() {
    }

    @Test
    public void getLoggedInUserNotNull() {
        Model m = new Model();
        User u = Mockito.mock(User.class);
        m.setLoggedInUser(u);
        assertTrue(m.getLoggedInUser() != null);
    }

    @Test
    public void getLoggedInUserIsUser() {
        Model m = new Model();
        User u = Mockito.mock(User.class);
        m.setLoggedInUser(u);
        assertEquals(u,m.getLoggedInUser());
    }

    @Test
    public void getCartWithOneItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(1, m.getCart().viewCart().size());
    }

    @Test
    public void getCartWithOneItemAndCheckThatItReturnsCorrectItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(products.get(0), m.getCart().viewCart().get(0));
    }

    @Test
    public void getCartWithMoreThanOneItemAndCheckThatItReturnsAllItemsInTheRightOrder() {
        Model m = new Model();
        m.addToCart(products.get(0));
        m.addToCart(products.get(1));
        assertTrue(products.get(0) == m.getCart().viewCart().get(0)
                && products.get(1) == m.getCart().viewCart().get(1));
    }

    @Test
    public void getCartWithMoreThanOneItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        m.addToCart(products.get(1));
        assertEquals(2, m.getCart().viewCart().size());
    }

    @Test
    public void addToCartAddOneItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(1, m.getCart().viewCart().size());
    }

    @Test
    public void addToCartAddCheckThatItemAddedIsTheSameItemInCart() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(products.get(0), m.getCart().viewCart().get(0));
    }

    @Test
    public void addToCartAddMoreThanOneItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        m.addToCart(products.get(1));
        assertEquals(2, m.getCart().viewCart().size());
    }

    @Test
    public void addToCartAddMoreThanOneItemAndCheckThatItemsAddedIsInCartInCorrectOrder() {
        Model m = new Model();
        m.addToCart(products.get(2));
        m.addToCart(products.get(3));
        assertTrue(products.get(2) == m.getCart().viewCart().get(0) &&
                products.get(3) == m.getCart().viewCart().get(1));
    }

    @Test
    public void filterListByString() {
    }

    @Test
    public void sortProductsPriceAscendingOrder() {
        Model m = Mockito.mock(Model.class);
        Mockito.when(m.listOfProducts()).thenReturn(products);
        List<IProduct> productsSorted = m.sortProducts(ComparatorIProduct.priceAscendingOrder());
        for (int i = 1; i < productsSorted.size(); i++){
            assertTrue(productsSorted.get(i-1).getPrice() <= productsSorted.get(i).getPrice());
        }
    }

    @Test
    public void sortProductsPriceDescendingOrder() {
        Model m = Mockito.mock(Model.class);
        Mockito.when(m.listOfProducts()).thenReturn(products);
        List<IProduct> productsSorted = m.sortProducts(ComparatorIProduct.priceDescendingOrder());
        for (int i = 1; i < productsSorted.size(); i++){
            assertTrue(productsSorted.get(i-1).getPrice() >= productsSorted.get(i).getPrice());
        }
    }

    @Test
    public void sortProductsNameAscendingOrder() {
        Model m = Mockito.mock(Model.class);
        Mockito.when(m.listOfProducts()).thenReturn(products);
        List<IProduct> productsSorted = m.sortProducts(ComparatorIProduct.nameAscendingOrder());
        for (int i = 1; i < productsSorted.size(); i++){
            assertTrue(productsSorted.get(i-1).getName().compareTo(productsSorted.get(i).getName()) <= 0);
        }
    }

    @Test
    public void sortProductsNameDescendingOrder() {
        Model m = Mockito.mock(Model.class);
        Mockito.when(m.listOfProducts()).thenReturn(products);
        List<IProduct> productsSorted = m.sortProducts(ComparatorIProduct.nameDescendingOrder());
        for (int i = 1; i < productsSorted.size(); i++){
            assertTrue(productsSorted.get(i-1).getName().compareTo(productsSorted.get(i).getName()) >= 0);
        }
    }
}