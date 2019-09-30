package com.dit212.group1.koskenkiosken.Model;

import android.util.Log;

import java.util.Comparator;

/**
 * Created by morgan on 2019-09-30
 * <p>
 * TODO , add comment
 */
public class ComparatorIProduct {
    private static String LOG_COMPARATORIPRODUCT = "COMP-IPRODUCT";

    private static Comparator<IProduct> nameAscendingOrder;
    private static Comparator<IProduct> nameDescendingOrder;
    private static Comparator<IProduct> priceAscendingOrder;
    private static Comparator<IProduct> priceDescendingOrder;

    /**
     * static class, private constructor.
     */
    private ComparatorIProduct() {
    }

    /**
     * returns a IProduct comparator comparing names in ascending order.
     * @return returns a IProduct comparator comparing names.
     */

    public static Comparator<IProduct> nameAscendingOrder() {
        if (nameAscendingOrder != null) return nameAscendingOrder;
        nameAscendingOrder = new Comparator<IProduct>() {
            @Override
            public int compare(IProduct p1, IProduct p2) {
                {
                    if (p1.getName().equals(p2.getName())) {
                        Log.i(LOG_COMPARATORIPRODUCT, p1.toString() + " is equal to " + p2.toString());
                        return 0;
                    }
                    if (stringIsAfterInOrder(p1.toString(), p2.toString())) {
                        Log.i(LOG_COMPARATORIPRODUCT, p1.toString() + " is after " + p2.toString());
                        return 1;
                    } else {
                        Log.i(LOG_COMPARATORIPRODUCT, p1.toString() + " is before " + p2.toString());
                        return -1;
                    }
                }
            }
        };
        return nameAscendingOrder;
    }

    /**
     * returns a IProduct comparator comparing names in decending order.
     * @return returns a IProduct comparator comparing names.
     */

    public static Comparator<IProduct> nameDescendingOrder() {
        if (nameDescendingOrder != null) return nameDescendingOrder;
        nameDescendingOrder = new Comparator<IProduct>() {
            @Override
            public int compare(IProduct p1, IProduct p2) {
                {
                    if (p1.getName().equals(p2.getName())) {
                        return 0;
                    }
                    if (stringIsAfterInOrder(p1.toString(), p2.toString())) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        };
        return nameDescendingOrder;
    }

    public static Comparator<IProduct> priceDescendingOrder() {
        if (priceDescendingOrder != null) return priceDescendingOrder;
        priceDescendingOrder = new Comparator<IProduct>() {
            @Override
            public int compare(IProduct p1, IProduct p2) {
                {
                    if (p1.getPrice() == p2.getPrice()) {
                        return 0;
                    }
                    if (p1.getPrice() < p2.getPrice()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        };
        return nameDescendingOrder;
    }

    public static Comparator<IProduct> priceAscendingOrder() {
        if (priceAscendingOrder != null) return priceAscendingOrder;
        priceAscendingOrder = new Comparator<IProduct>() {
            @Override
            public int compare(IProduct p1, IProduct p2) {
                {
                    if (p1.getPrice() == p2.getPrice()) {
                        return 0;
                    }
                    if (p1.getPrice() < p2.getPrice()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        };
        return nameAscendingOrder;
    }

    /**
     * checks if string1 is after string2 in alphabetical order.
     * stringIsAfterInOrder(Horsepower, Horse) would be true.
     *
     * obs. we dont have access to Comparator static methods due to API level.
     *
     * @param s1 the first string
     * @param s2 the second string.
     * @return true if first string comes after second string in alphabetical order.
     */
    public static boolean stringIsAfterInOrder(String s1, String s2) {
        char[] string1 = s1.toCharArray();
        char[] string2 = s2.toCharArray();
        int size = s1.length() < s2.length() ? s1.length() : s2.length();
        for (int i = 0; i < size; i++) {
            if (string1[i] != string2[i]) {
                return string1[i] > string2[i];
            }
        }
        return s1.length() > s2.length();
    }


}
