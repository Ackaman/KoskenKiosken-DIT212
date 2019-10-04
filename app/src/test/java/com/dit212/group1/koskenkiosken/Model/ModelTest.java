package com.dit212.group1.koskenkiosken.Model;

import android.os.Debug;
import android.util.Log;

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
    public void getLoggedInUser() {
    }

    @Test
    public void getCart() {
    }

    @Test
    public void addToCart() {
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