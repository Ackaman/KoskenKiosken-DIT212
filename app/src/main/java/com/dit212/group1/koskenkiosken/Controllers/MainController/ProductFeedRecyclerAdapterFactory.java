package com.dit212.group1.koskenkiosken.Controllers.MainController;

import com.dit212.group1.koskenkiosken.Model.Product.IProduct;

import java.util.List;

/**
 * @author Johan Almroth
 * Uses: IProduct, ProductFeedRecyclerAdapter (& Innerclasses)
 * Description: Construction for RecyclerAdapter.
 */
class ProductFeedRecyclerAdapterFactory {
    /**
     * Create a cart version of recyclerview.
     *
     * @param products             products to display
     * @param productClickListener listener for productclicks
     * @return returns constructed recyclerview
     */
    static ProductFeedRecyclerAdapter createCartFragment(List<IProduct> products, ProductFeedRecyclerAdapter.CartProductClickListener productClickListener) {
        return new ProductFeedRecyclerAdapter(products, productClickListener);
    }

    /**
     * Create a store version of recyclerview.
     *
     * @param products             products to display
     * @param productClickListener listener for productclicks
     * @return returns constructed recyclerview
     */
    static ProductFeedRecyclerAdapter createStoreFragment(List<IProduct> products, ProductFeedRecyclerAdapter.StoreProductClickListener productClickListener) {
        return new ProductFeedRecyclerAdapter(products, productClickListener);
    }
}



