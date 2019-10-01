package com.dit212.group1.koskenkiosken.Model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by morgan on 2019-09-30
 * <p>
 * TODO , add comment
 */
public class ComparatorIProductTest {

    private List<IProduct> products;

    @Before
    public void init(){
        products = new ArrayList<>();
        IProduct p1mock = Mockito.mock(IProduct.class);
        Mockito.when(p1mock.getName()).thenReturn("Äpple");
        Mockito.when(p1mock.getPrice()).thenReturn(5);


        IProduct p2mock = Mockito.mock(IProduct.class);
        Mockito.when(p1mock.getName()).thenReturn("Päron");
        Mockito.when(p1mock.getPrice()).thenReturn(8);


        IProduct p3mock = Mockito.mock(IProduct.class);
        Mockito.when(p1mock.getName()).thenReturn("Kitkat");
        Mockito.when(p1mock.getPrice()).thenReturn(15);


        IProduct p4mock = Mockito.mock(IProduct.class);
        Mockito.when(p1mock.getName()).thenReturn("Kaffe");
        Mockito.when(p1mock.getPrice()).thenReturn(2);

        products.add(p1mock);
        products.add(p2mock);
        products.add(p3mock);
        products.add(p4mock);
    }

    @Test
    public void nameAscendingOrder() {
        Comparator<IProduct> comp1 = ComparatorIProduct.nameAscendingOrder();
        assertTrue(comp1.compare(products.get(0), products.get(0)) == 0);
    }

    @Test
    public void nameDescendingOrder() {
    }

    @Test
    public void priceDescendingOrder() {
    }

    @Test
    public void priceAscendingOrder() {
    }

    @Test
    public void stringIsHejisAfterDaInOrder() {
        String str1 = "hej";
        String str2 = "då";
    }

    @Test
    public void emptyStringisBeforeHejInOrder() {
        String str1 = "hej";
        String str2 = "";
    }
}