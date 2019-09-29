package com.dit212.group1.koskenkiosken.Model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ProductTest {
    Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product("Produkt 1", 20, "Placeholder");
    }

    @Test
    public void getName() {
        assertThat(product.getName(), equalTo("Produkt 1"));
    }

    @Test
    public void setName() {
        product.setName("New Product Name");
        assertThat(product.getName(), equalTo("New Product Name"));
    }

    @Test
    public void getPrice() {
        assertThat(product.getPrice(), equalTo(20));
    }

    @Test
    public void setPrice() {
        product.setPrice(15);
        assertThat(product.getPrice(), equalTo(15));
    }
}