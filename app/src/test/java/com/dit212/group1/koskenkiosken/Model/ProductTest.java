package com.dit212.group1.koskenkiosken.Model;

import com.dit212.group1.koskenkiosken.Model.Product.IProduct;
import com.dit212.group1.koskenkiosken.Model.Product.ProductFactory;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 * Uses: IProduct, ProductFactory.
 */

public class ProductTest {
    private IProduct product;

    /**
     * Sets up a mock-product for the tests
     */
    @Before
    public void setUp() {
        product = ProductFactory.create("Produkt 1", 20, "Placeholder");
    }

    /**
     * Tests that the getName method returns the correct product name
     */
    @Test
    public void getName() {
        assertThat(product.getName(), equalTo("Produkt 1"));
    }

    /**
     * Tests that the getPrice method returns the correct price of the product
     */
    @Test
    public void getPrice() {
        assertThat(product.getPrice(), equalTo(20));
    }

    /**
     * Tests that the toString method returns the name of the product
     */
    @Test
    public void toStringTest(){
        assertEquals("Produkt 1", product.toString());
    }

    /**
     * Tests that the getDescription method returns the description of the product
     */
    @Test
    public void getDescriptionTest(){
        assertEquals("Placeholder", product.getDescription());

    }
}