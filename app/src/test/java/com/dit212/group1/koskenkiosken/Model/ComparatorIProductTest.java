package com.dit212.group1.koskenkiosken.Model;

import com.dit212.group1.koskenkiosken.Model.Product.ComparatorIProduct;
import com.dit212.group1.koskenkiosken.Model.Product.IProduct;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by morgan on 2019-09-30
 *
 * Description: tests comparatorIProduct in model. uses Mockito-lib to pinpoint comparator-class. so that no
 * bugs in IProduct affects these tests.
 */
public class ComparatorIProductTest {

    private List<IProduct> products;

    /**
     * creates a mock List of IProduct. with mocks we can eliminate bugs from IProduct to affect
     * our tests.
     */
    @Before
    public void init(){
        products = new ArrayList<>();
        IProduct p1mock = Mockito.mock(IProduct.class);
        Mockito.when(p1mock.getName()).thenReturn("Äpple");
        Mockito.when(p1mock.getPrice()).thenReturn(5);


        IProduct p2mock = Mockito.mock(IProduct.class);
        Mockito.when(p2mock.getName()).thenReturn("Päron");
        Mockito.when(p2mock.getPrice()).thenReturn(8);


        IProduct p3mock = Mockito.mock(IProduct.class);
        Mockito.when(p3mock.getName()).thenReturn("Kitkat");
        Mockito.when(p3mock.getPrice()).thenReturn(15);


        IProduct p4mock = Mockito.mock(IProduct.class);
        Mockito.when(p4mock.getName()).thenReturn("Kaffe");
        Mockito.when(p4mock.getPrice()).thenReturn(2);

        products.add(p1mock);
        products.add(p2mock);
        products.add(p3mock);
        products.add(p4mock);
    }

    /**
     * tests that same product comparing produces a zero.
     */
    @Test
    public void nameAscendingOrderSameProductProducesAZero() {
        Comparator<IProduct> comp = ComparatorIProduct.nameAscendingOrder();
        assertEquals(0, comp.compare(products.get(0), products.get(0)));
    }

    /**
     * test that Swedish characters are ordered correctly in ascending order (starting with a)
     */

    @Test
    public void nameAscendingOrderSwedishCharactersReadCorrectly() {
        Comparator<IProduct> comp = ComparatorIProduct.nameAscendingOrder();
        assertTrue(comp.compare(products.get(1), products.get(0)) > 0);
    }

    /**
     * tests that Kaffe comes before Kitkat in ascending order.
     */

    @Test
    public void nameAscendingOrderKAisBeforeKI() {
        Comparator<IProduct> comp = ComparatorIProduct.nameAscendingOrder();
        assertTrue(comp.compare(products.get(3), products.get(2)) > 0);
    }

    /**
     * tests that same product comparing produces a zero.
     */

    @Test
    public void nameDescendingOrderSameProductProducesAZero() {
        Comparator<IProduct> comp = ComparatorIProduct.nameDescendingOrder();
        assertTrue(comp.compare(products.get(3), products.get(1)) < 0);
    }

    /**
     * test that Swedish characters are ordered correctly in descending order (starting with ö)
     */

    @Test
    public void nameDescendingOrderSwedishCharactersReadCorrectly() {
        Comparator<IProduct> comp = ComparatorIProduct.nameDescendingOrder();
        assertTrue(comp.compare(products.get(1), products.get(0)) < 0);
    }

    /**
     * tests that Kaffe comes after Kitkat in ascending order.
     */

    @Test
    public void nameDescendingOrderKAisAfterKI() {
        Comparator<IProduct> comp = ComparatorIProduct.nameDescendingOrder();
        assertTrue(comp.compare(products.get(3), products.get(2)) < 0);
    }

    /**
     * tests that same product comparing produces a zero.
     */

    @Test
    public void priceDescendingOrderSameProductProducesAZero() {
        Comparator<IProduct> comp = ComparatorIProduct.priceDescendingOrder();
        assertEquals(0, comp.compare(products.get(0),products.get(0)));
    }

    /**
     * tests that 15 is before 2 in descending order.
     */

    @Test
    public void priceDescendingOrder15isBefore2() {
        Comparator<IProduct> comp = ComparatorIProduct.priceDescendingOrder();
        assertTrue(comp.compare(products.get(2),products.get(3)) > 0);
    }

    /**
     * tests that 2 is after 5 in descending order.
     */

    @Test
    public void priceDescendingOrder2isAfter5() {
        Comparator<IProduct> comp = ComparatorIProduct.priceDescendingOrder();
        assertTrue(comp.compare(products.get(3),products.get(0)) < 0);
    }

    /**
     * tests that same product comparing produces a zero.
     */

    @Test
    public void priceAscendingOrderSameProductProducesAZero() {
        Comparator<IProduct> comp = ComparatorIProduct.priceDescendingOrder();
        assertEquals(0, comp.compare(products.get(0),products.get(0)));
    }

    /**
     * tests that 15 is after 2 in ascending order.
     */

    @Test
    public void priceAscendingOrderOrder15isAfter2() {
        Comparator<IProduct> comp = ComparatorIProduct.priceDescendingOrder();
        assertTrue(comp.compare(products.get(3),products.get(2)) < 0);
    }

    /**
     * tests that 2 is before 5 in ascending order.
     */

    @Test
    public void priceAscendingOrder2isBefore5() {
        Comparator<IProduct> comp = ComparatorIProduct.priceDescendingOrder();
        assertTrue(comp.compare(products.get(3),products.get(0)) < 0);
    }


}