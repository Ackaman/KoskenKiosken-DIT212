package com.dit212.group1.koskenkiosken.Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CartTest {

    ArrayList<Product> products;
    Cart cart;

    /**
     * creates a mock List of Product and an empty Cart. with mocks we can eliminate bugs from IProduct to affect
     * our tests.
     */

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

        cart = new Cart();
    }

    /**
     * Tests if one product can be added to Cart.
     */
    @Test
    public void addToCartAddOneProduct() {
        cart.addToCart(products.get(0));
        assertEquals(1, cart.viewCart().size());
    }

    /**
     * Tests if product added to cart is the same product that is in the cart.
     */
    @Test
    public void addToCartAdd() {
        cart.addToCart(products.get(0));
        assertTrue(products.get(0) == cart.viewCart().get(0));
    }

    /**
     * Tests if multiple products can be added to cart.
     */
    @Test
    public void addToCartAddMoreThanOneProduct() {
        cart.addToCart(products.get(0));
        cart.addToCart(products.get(1));
        assertEquals(2, cart.viewCart().size());
    }

    /**
     * Tests if null can be added to cart.
     */
    @Test
    public void addToCartAddNullToCart() {
        cart.addToCart(null);
        assertEquals(1, cart.viewCart().size());
    }

    /**
     * Tests if one a product can be removed from cart.
     * Tests if a product in the middle of the list can be removed.
     * Tests that size of cart still is 0 after we remove a product from an empty cart.
     * Tests if multiple products can be removed from cart.
     */
    @Test
    public void removeFromCart() {
        cart.addToCart(null);
        cart.removeFromCart(null);
        assertEquals(0,cart.viewCart().size());
        cart.addToCart(products.get(0));
        cart.removeFromCart(products.get(0));
        assertEquals(0, cart.viewCart().size());
        cart.addToCart(products.get(0));
        cart.addToCart(products.get(1));
        cart.addToCart(products.get(2));
        cart.addToCart(products.get(3));
        cart.removeFromCart(products.get(2));
        assertTrue(!cart.viewCart().contains(products.get(2)));
        assertEquals(3, cart.viewCart().size());
        cart.removeFromCart(products.get(0));
        cart.removeFromCart(products.get(1));
        cart.removeFromCart(products.get(3));
        assertEquals(0, cart.viewCart().size());
        cart.removeFromCart(products.get(0));
        assertEquals(0, cart.viewCart().size());
    }

    /**
     * Tests if null can be removed from cart
     */
    @Test
    public void removeFromCartNull() {
        cart.addToCart(null);
        cart.removeFromCart(null);
        assertEquals(0,cart.viewCart().size());
    }

    @Test
    public void removeFromCartOneProduct() {
        cart.addToCart(products.get(0));
        cart.removeFromCart(products.get(0));
        assertEquals(0, cart.viewCart().size());
    }

    /**
     *
     */
    @Test
    public void removeFromCartRemovedProductIsRemoved() {
        cart.addToCart(products.get(2));
        cart.removeFromCart(products.get(2));
        assertTrue(!cart.viewCart().contains(products.get(2)));
    }

    /**
     * Tests if you can remove more than one product from a cart with more than one item.
     */
    @Test
    public void removeFromCartRemoveMultipleProducts() {
        cart.addToCart(products.get(0));
        cart.addToCart(products.get(1));
        cart.addToCart(products.get(2));
        cart.addToCart(products.get(3));
        cart.removeFromCart(products.get(0));
        cart.removeFromCart(products.get(1));
        assertEquals(2, cart.viewCart().size());
    }

    /**
     * Tests if cart size is still 0 after removing from a empty cart.
     */
    @Test
    public void removeFromCartWhenCartIsEmpty() {
        cart.removeFromCart(products.get(0));
        assertEquals(0, cart.viewCart().size());
    }

    /**
     * Tests if a Cart filled with multiple products can be replaces with a empty Cart
     * Tests if a empty Cart can be replaced with a empty cart.
     */
    @Test
    public void emptyCartWriteOverCartWithMoreThanOneItem() {
        cart.addToCart(products.get(0));
        cart.addToCart(products.get(1));
        cart.addToCart(products.get(2));
        cart.addToCart(products.get(3));
        cart.emptyCart();
        assertEquals(0, cart.viewCart().size());
        cart.emptyCart();
        assertEquals(0, cart.viewCart().size());
    }

    @Test
    public void emptyCart() {
        cart.addToCart(products.get(0));
        cart.addToCart(products.get(1));
        cart.addToCart(products.get(2));
        cart.addToCart(products.get(3));
        cart.emptyCart();
        assertEquals(0, cart.viewCart().size());
        cart.emptyCart();
        assertEquals(0, cart.viewCart().size());
    }

    @Test
    public void getPrice() {
        cart.addToCart(products.get(0));
        assertEquals(5,cart.getPrice());

    }

    @Test
    public void viewCart() {
    }

    @Test
    public void setCart() {
    }
}