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

public class ProductFactoryTest {

    IProduct product;

    @Before
    public void setUp() throws Exception {
        product = ProductFactory.create("Product 1", 50, "Placeholder");
    }

    @Test
    public void getName() {
        assertThat(product.getName(), equalTo("Product 1"));
    }

    @Test
    public void getPrice() {
        assertThat(product.getPrice(), equalTo(50));
    }
}