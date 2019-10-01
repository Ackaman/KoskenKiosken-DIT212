package com.dit212.group1.koskenkiosken.Model;

import java.util.Comparator;

/**
 * Created by morgan on 2019-09-30
 *
 * Description: class provides predefined product comparators.
 */
public class ComparatorIProduct {

    private static Comparator<IProduct> nameAscendingOrder;
    private static Comparator<IProduct> nameDescendingOrder;
    private static Comparator<IProduct> priceAscendingOrder;
    private static Comparator<IProduct> priceDescendingOrder;

    /**
     * static class, private constructor.
     */
    private ComparatorIProduct() {
    }

    public static Comparator<IProduct> nameAscendingOrder() {
        if (nameAscendingOrder != null) return nameAscendingOrder;
        nameAscendingOrder = new Comparator<IProduct>() {
            @Override
            public int compare(IProduct p1, IProduct p2) {
                {
                    return p2.getName().compareTo(p1.getName());
                }
            }
        };
        return nameAscendingOrder;
    }

    public static Comparator<IProduct> nameDescendingOrder() {
        if (nameDescendingOrder != null) return nameDescendingOrder;
        nameDescendingOrder = new Comparator<IProduct>() {
            @Override
            public int compare(IProduct p1, IProduct p2) {
                return p1.getName().compareTo(p2.getName());
            }
        };
        return nameDescendingOrder;
    }

    public static Comparator<IProduct> priceDescendingOrder() {
        if (priceDescendingOrder != null) return priceDescendingOrder;
        priceDescendingOrder = new Comparator<IProduct>() {
            @Override
            public int compare(IProduct p1, IProduct p2) {
                return Integer.valueOf(p1.getPrice()).compareTo(p2.getPrice());
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
                    return Integer.valueOf(p2.getPrice()).compareTo(p1.getPrice());
                }
            }
        };
        return nameAscendingOrder;
    }
}




