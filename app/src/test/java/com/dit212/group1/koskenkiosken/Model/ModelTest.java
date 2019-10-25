package com.dit212.group1.koskenkiosken.Model;

import com.dit212.group1.koskenkiosken.Model.Cart.ICart;
import com.dit212.group1.koskenkiosken.Model.Product.ComparatorIProduct;
import com.dit212.group1.koskenkiosken.Model.Product.IProduct;
import com.dit212.group1.koskenkiosken.Model.User.IAccount;
import com.dit212.group1.koskenkiosken.Model.User.UserFactory;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author David Persson, Morgan Thowsen, Gustav Pihlquist.
 * Uses: ComparatorIProduct, IProduct, IAccount, UserFactory.
 * <p>
 */
public class ModelTest {

    private List<IProduct> products;
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

        IProduct p5mock = Mockito.mock(IProduct.class);
        Mockito.when(p5mock.getName()).thenReturn("Öl");
        Mockito.when(p5mock.getPrice()).thenReturn(10);

        products.add(p1mock);
        products.add(p2mock);
        products.add(p3mock);
        products.add(p4mock);
        products.add(p5mock);
    }

    /**
     * Tests that the listOfProduct reads properly from the database
     */
    @Test
    public void listOfProducts() {
        Model m = new Model();
        IDatabase db = Mockito.mock(IDatabase.class);
        Mockito.when(db.readProducts()).thenReturn(products);
        m.parseFromIDatabase(db);
        assertEquals(products, m.listOfProducts());

    }

    /**
     * Tests that when getting user that user is not null.
     */
    @Test
    public void getLoggedInUserNotNull() {
        Model m = new Model();
        IAccount u = Mockito.mock(IAccount.class);
        m.setLoggedInUser(u);
        assertTrue(m.getLoggedInUser() != null);
    }

    /**
     * Tests that getLoggedInUser returns the actual user that has been set.
     */
    @Test
    public void getLoggedInUserIsUser() {
        Model m = new Model();
        IAccount u = Mockito.mock(IAccount.class);
        m.setLoggedInUser(u);
        assertEquals(u,m.getLoggedInUser());
    }

    /**
     * Tests that a cart with one item has one item in it when getting cart.
     */
    @Test
    public void getCartWithOneItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(1, m.getCart().viewCart().size());
    }

    /**
     * Tests that when getting cart with one item has the correct item in it.
     */
    @Test
    public void getCartWithOneItemAndCheckThatItReturnsCorrectItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(products.get(0), m.getCart().viewCart().get(0));
    }

    /**
     * Tests that a cart with more than one item returns the correct items in the cart in the correct order.
     */
    @Test
    public void getCartWithMoreThanOneItemAndCheckThatItReturnsAllItemsInTheRightOrder() {
        Model m = new Model();
        m.addToCart(products.get(0));
        m.addToCart(products.get(1));
        assertTrue(products.get(0) == m.getCart().viewCart().get(0)
                && products.get(1) == m.getCart().viewCart().get(1));
    }

    /**
     * Tests that a cart with more than one item has the correct number ofo items in it.
     */
    @Test
    public void getCartWithMoreThanOneItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        m.addToCart(products.get(1));
        assertEquals(2, m.getCart().viewCart().size());
    }

    /**
     * Tests that adding one item adds just one item to the cart.
     */
    @Test
    public void addToCartAddOneItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(1, m.getCart().viewCart().size());
    }

    /**
     * Tests that the one item added to cart is the correct (same) item that was added to cart.
     */
    @Test
    public void addToCartAddCheckThatItemAddedIsTheSameItemInCart() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(products.get(0), m.getCart().viewCart().get(0));
    }

    /**
     * Tests that adding more than one item to cart adds the correct amount of items.
     */
    @Test
    public void addToCartAddMoreThanOneItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        m.addToCart(products.get(1));
        assertEquals(2, m.getCart().viewCart().size());
    }

    /**
     * Tests that adding more than one item adds the correct items in the correct order in the cart.
     */
    @Test
    public void addToCartAddMoreThanOneItemAndCheckThatItemsAddedIsInCartInCorrectOrder() {
        Model m = new Model();
        m.addToCart(products.get(2));
        m.addToCart(products.get(3));
        assertTrue(products.get(2) == m.getCart().viewCart().get(0) &&
                products.get(3) == m.getCart().viewCart().get(1));
    }

    /**
     * Tests that the empty string in the search field always has the same size as the inventory
     */
    @Test
    public void filterListByStringEmptyStringShouldAlwaysHaveTheSameSizeAsTheOriginalProductList() {
        Model m = new Model();
        IDatabase db = Mockito.mock(IDatabase.class);
        Mockito.when(db.readProducts()).thenReturn(products);
        m.parseFromIDatabase(db);
        assertEquals(products.size(), m.filterListByString("").size());
    }

    /**
     * Tests that the empty string in the search field always has the same products as the inventory
     */
    @Test
    public void filterListByStringEmptyStringShouldAlwaysReturnOriginalProductList() {
        Model m = new Model();
        IDatabase db = Mockito.mock(IDatabase.class);
        Mockito.when(db.readProducts()).thenReturn(products);
        m.parseFromIDatabase(db);
        assertEquals(products, m.filterListByString(""));
    }

    /**
     * Tests that "ö" and "o" doesn't return the same list
     */
    @Test
    public void filterListByStringSwedishAlphabetLastCharacterOShouldNotBeARegularO() {
        Model m = new Model();
        IDatabase db = Mockito.mock(IDatabase.class);
        Mockito.when(db.readProducts()).thenReturn(products);
        m.parseFromIDatabase(db);
        assertNotEquals(m.filterListByString("o"), m.filterListByString("ö"));

    }

    /**
     * Tests that the filter method isn't case sensitive
     */
    @Test
    public void filterListByStringMethodShouldNotBeCaseSensitive() {
        Model m = new Model();
        IDatabase db = Mockito.mock(IDatabase.class);
        Mockito.when(db.readProducts()).thenReturn(products);
        m.parseFromIDatabase(db);
        assertEquals(m.filterListByString("kitkat"), m.filterListByString("KITKAT"));

    }

    /**
     * Tests that the filter method returns all products with substrings of the search string
     */
    @Test
    public void filterListByStringEverySubstringShouldBeReturned() {
        Model m = new Model();
        IDatabase db = Mockito.mock(IDatabase.class);
        Mockito.when(db.readProducts()).thenReturn(products);
        m.parseFromIDatabase(db);
        List<IProduct> expectedResult = new ArrayList<>();
        //"ka" should return KAffe and kitKAt
        String s = "ka";
        for(IProduct p : products){
            if(p.getName().toLowerCase().contains(s.toLowerCase())){
                expectedResult.add(p);
            }
        }
        assertEquals(expectedResult, m.filterListByString(s));


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

    /**
     * Tests that the price is 0 when the cart is empty
     */
    @Test
    public void getPriceWhenCartIsEmpty() {
        Model m = new Model();
        m.getCart().emptyCart();
        assertEquals(0, m.getPrice());
    }

    /**
     * Tests that adding an apple to the cart makes the price of the cart equal to 5
     */
    @Test
    public void getPriceWhenCartHasOneItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(5, m.getPrice());
    }

    /**
     * Tests that the total price is correct when adding 5 products to the cart
     */
    @Test
    public void getPriceWhenCartIsFull() {
        Model m = new Model();
        int expectedPrice = 0;
        for (IProduct p : products){
            m.addToCart(p);
            expectedPrice += p.getPrice();
        }
        assertEquals(expectedPrice, m.getPrice());
    }

    /**
     * Tests that the size of the cart is 0 when the cart is empty
     */
    @Test
    public void getSizeOfCartWhenCartIsEmpty() {
        Model m = new Model();
        m.getCart().emptyCart();
        assertEquals(0, m.getSizeOfCart());
    }

    /**
     * Tests that the size of the cart is 1 when the cart has one item in it
     */
    @Test
    public void getSizeOfCartWhenCartHasOneItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(1, m.getSizeOfCart());
    }

    /**
     * Tests that the size of the cart is 3 after adding 3 items to it
     */
    @Test
    public void getSizeOfCartWhenCartHasMoreThenOneItem(){
        Model m = new Model();
        m.addToCart(products.get(0));
        m.addToCart(products.get(1));
        m.addToCart(products.get(2));
        assertEquals(3, m.getSizeOfCart());
    }

    /**
     * Tests that price is correct if one product is added to cart
     */
    @Test
    public void getPriceForOneProductInCart() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(5,m.getPrice());
    }

    /**
     * Tests that price is correct if one product is added to cart
     */
    @Test
    public void getPriceForMoreThanOneProductInCart() {
        Model m = new Model();
        m.addToCart(products.get(0));
        m.addToCart(products.get(1));
        assertEquals(13,m.getPrice());
    }

    /**
     * Tests that price is 0 on a empty cart.
     */
    @Test
    public void getPriceOnEmptyCart() {
        Model m = new Model();
        assertEquals(0,m.getPrice());
    }

    /**
     * Tests that viewCart returns one product.
     */
    @Test
    public void viewCartWithOneProduct() {
        Model m = new Model();
        m.addToCart(products.get(0));
        assertEquals(m.viewCart().size(),1);
    }

    /**
     * Tests that viewCart returns more than one product.
     */
    @Test
    public void viewCartWithMoreThanOneProduct() {
        Model m = new Model();
        m.addToCart(products.get(0));
        m.addToCart(products.get(0));
        assertEquals(m.viewCart().size(),2);
    }

    /**
     * Tests that viewCart returns empty when cart is empty.
     */
    @Test
    public void viewCartWithNoItemsReturnsTheEmptyList() {
        Model m = new Model();
        assertTrue(m.viewCart().isEmpty());
    }

    /**
     * Tests that setCart can set a cart with one item to an empty list.
     */
    @Test
    public void setCartWithOneProductToAnEmptyList() {
        Model m = new Model();
        m.addToCart(products.get(0));
        ArrayList productsEmpty = new ArrayList<>();
        m.setCart(productsEmpty);
        assertTrue(m.viewCart().isEmpty());
    }

    /**
     * Tests that setCart can set a cart with more than one item to an empty list.
     */
    @Test
    public void setCartWithMoreThanOneProductToAnEmptyList() {
        Model m = new Model();
        m.addToCart(products.get(0));
        m.addToCart(products.get(1));
        m.addToCart(products.get(2));
        ArrayList productsEmpty = new ArrayList<>();
        m.setCart(productsEmpty);
        assertTrue(m.viewCart().isEmpty());
    }

    /**
     * Tests that setCart can set a empty cart to a cart with more than one item.
     */
    @Test
    public void setCartEmptyCartToEmptyCart() {
        Model m = new Model();
        ArrayList productsEmpty = new ArrayList<>();
        m.setCart(productsEmpty);
        m.setCart(products);
        assertEquals(m.viewCart(), products);
    }

    /**
     * Tests that cart with one item can remove the item.
     */
    @Test
    public void removeFromCartOneItem() {
        Model m = new Model();
        m.addToCart(products.get(0));
        m.removeFromCart(m.viewCart().get(0));
        assertTrue(m.viewCart().isEmpty());
    }

    /**
     * Tests that cart with more than one item can remove the items.
     */
    @Test
    public void removeFromCartMoreThanOneItem() {
        Model m = new Model();
        m.addToCart(products.get(3));
        m.addToCart(products.get(2));
        m.removeFromCart(m.viewCart().get(0));
        m.removeFromCart(m.viewCart().get(0));
        assertTrue(m.viewCart().isEmpty());
    }

    /**
     * Tests that the purchase is successful when the cart is empty
     */
    @Test
    public void purchaseWhenCartIsEmpty(){
        IAccount user = UserFactory.createMockUser();
        Model m = new Model();
        m.setLoggedInUser(user);
        assertTrue(m.purchase());

    }

    /**
     * Tests that the purchase is successful when the user has sufficient credits
     */
    @Test
    public void purchaseWhenUserCanAffordTheProduct(){
        IAccount user = UserFactory.createMockUser();
        Model m = new Model();
        m.setLoggedInUser(user);
        m.addToCart(products.get(3));
        assertTrue(m.purchase());
    }

    /**
     * Tests that the purchase fails if the user does not have sufficient credits
     */
    @Test
    public void purchaseWhenUserCanNotAffordTheProduct(){
        IAccount user = UserFactory.createMockUser();
        Model m = new Model();
        m.setLoggedInUser(user);
        m.addToCart(products.get(2));
        assertFalse(m.purchase());
    }

    /**
     * Tests that the carts is emptied after a successful purchase
     */
    @Test
    public void purchaseAndCheckThatCartIsEmptiedAfterPurchase(){
        IAccount user = UserFactory.createMockUser();
        Model m = new Model();
        m.setLoggedInUser(user);
        m.addToCart(products.get(3));
        m.purchase();
        assertEquals(0, m.getSizeOfCart());
    }

    /**
     * Tests that the cart is not emptied after a failed purchase
     */
    @Test
    public void purchaseAndCheckThatCartIsNotEmptiedWhenPurchaseFails(){
        IAccount user = UserFactory.createMockUser();
        Model m = new Model();
        m.setLoggedInUser(user);
        m.addToCart(products.get(0));
        m.addToCart(products.get(1));
        m.addToCart(products.get(2));
        m.purchase();
        assertEquals(3, m.getSizeOfCart());
    }

    /**
     * Tests that purchase is successful with several products in the cart
     * when the user have sufficient credits
     */
    @Test
    public void purchaseWithTwoProductsInTheCartAndUserCanAfford(){
        IAccount user = UserFactory.createMockUser();
        Model m = new Model();
        m.setLoggedInUser(user);
        m.addToCart(products.get(3));
        m.addToCart(products.get(0));
        assertTrue(m.purchase());
    }

    /**
     * Tests that the cart is emptied when purchasing several products
     */
    @Test
    public void purchaseWithTwoProductsInTheCartAndCheckThatTheCartIsEmptied(){
        IAccount user = UserFactory.createMockUser();
        Model m = new Model();
        m.setLoggedInUser(user);
        m.addToCart(products.get(3));
        m.addToCart(products.get(0));
        m.purchase();
        assertEquals(0, m.getSizeOfCart());

    }
}