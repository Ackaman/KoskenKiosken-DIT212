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
    public void addToCartAddCheckIfSameProduct() {
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
     * Tests if null can be removed from cart
     */
    @Test
    public void removeFromCartNull() {
        cart.addToCart(null);
        cart.removeFromCart(null);
        assertEquals(0,cart.viewCart().size());
    }

    /**
     * Tests that one product is removed from cart.
     */
    @Test
    public void removeFromCartOneProduct() {
        cart.addToCart(products.get(0));
        cart.removeFromCart(products.get(0));
        assertEquals(0, cart.viewCart().size());
    }

    /**
     * Tests that the removed product is no longer in cart.
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
     */
    @Test
    public void emptyCartWriteOverCartWithMoreThanOneItem() {
        cart.addToCart(products.get(0));
        cart.addToCart(products.get(1));
        cart.addToCart(products.get(2));
        cart.addToCart(products.get(3));
        cart.emptyCart();
        assertEquals(0, cart.viewCart().size());
    }

    /**
     * Tests if a empty Cart can be replaced with a empty cart.
     */
    @Test
    public void emptyCartWriteOverEmptyCartWithEmptyCart() {
        cart.emptyCart();
        assertEquals(0, cart.viewCart().size());
    }

    /**
     * Tests that price is correct if one product is added to cart
     */
    @Test
    public void getPriceForOneProductInCart() {
        cart.addToCart(products.get(0));
        assertEquals(5,cart.getPrice());
    }

    /**
     * Tests that price is correct if one product is added to cart
     */
    @Test
    public void getPriceForMoreThanOneProductInCart() {
        cart.addToCart(products.get(0));
        cart.addToCart(products.get(1));
        assertEquals(13,cart.getPrice());
    }

    /**
     * Tests that price is 0 on a empty cart.
     */
    @Test
    public void getPriceOnEmptyCart() {
        assertEquals(0,cart.getPrice());
    }

    /**
     * Tests that viewCart returns what is in cart.
     */
    @Test
    public void viewCartHasOneProduct() {
        cart.addToCart(products.get(0));
        assertTrue(cart.viewCart() != null);
    }

    /**
     * Tests that viewCart returns an empty list when cart is empty
     */
    @Test
    public void viewCartHasMoreThanOneObject() {
        cart.addToCart(products.get(0));
        cart.addToCart(products.get(1));
        assertEquals(2,cart.viewCart().size());
    }

    /**
     * Tests that viewCart returns an empty list when cart is empty
     */
    @Test
    public void viewCartWhenCartIsEmptyReturnEmptyList() {
        assertTrue(cart.viewCart().isEmpty());
    }

    /**
     * Tests that a Cart with one item can be set to a cart with another item
     */
    @Test
    public void setCartWithOneProductToAnotherListWithAnotherProduct() {
        ArrayList<IProduct> testList = new ArrayList<>();
        testList.add(products.get(0));
        cart.addToCart(products.get(1));
        cart.setCart(testList);
        assertTrue(cart.viewCart().contains(products.get(0)));
    }

    /**
     * Tests if a empty cart can be set to another ArrayList with more than one product in it
     * and checks if the products are in the cart.
     */
    @Test
    public void setCartEmptyCartToAnotherListWithMoreThanOneProductInIt() {
        ArrayList<IProduct> testList = new ArrayList<>();
        testList.add(products.get(0));
        testList.add(products.get(1));
        cart.setCart(testList);
        assertTrue(cart.viewCart().contains(products.get(0)) && cart.viewCart().contains(products.get(1)));
    }

    /**
     * Tests if a empty cart can be set to another empty ArrayList
     */
    @Test
    public void setCartEmptyCartToAnotherEmptyList() {
        ArrayList<IProduct> testList = new ArrayList<>();
        cart.setCart(testList);
        assertTrue(cart.viewCart().isEmpty());
    }
}