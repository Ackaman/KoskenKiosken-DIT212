package com.dit212.group1.koskenkiosken.Model;

import com.dit212.group1.koskenkiosken.Model.Product.IProduct;
import com.dit212.group1.koskenkiosken.Model.Product.ProductFactory;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ProductTest {
    private IProduct product;

    @Before
    public void setUp() {
        product = ProductFactory.create("Produkt 1", 20, "Placeholder");
    }

    @Test
    public void getName() {
        assertThat(product.getName(), equalTo("Produkt 1"));
    }


    @Test
    public void getPrice() {
        assertThat(product.getPrice(), equalTo(20));
    }

}