package com.dit212.group1.koskenkiosken.Model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by morgan on 2019-09-30
 * <p>
 * TODO , add comment
 */
public class ComparatorIProductTest {

    @Test
    public void nameAscendingOrder() {
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
        assertTrue(ComparatorIProduct.stringIsAfterInOrder(str1,str2));
    }

    @Test
    public void emptyStringisBeforeHejInOrder() {
        String str1 = "hej";
        String str2 = "";
        assertTrue(ComparatorIProduct.stringIsAfterInOrder(str1,str2));
    }
}