package com.dit212.group1.koskenkiosken.Controllers.MainController;

import com.dit212.group1.koskenkiosken.Model.Product.IProduct;

import java.util.List;


    class ProductFeedRecyclerAdapterFactory {

        static ProductFeedRecyclerAdapter createCartFragment(List<IProduct> products, ProductFeedRecyclerAdapter.CartProductClickListener productClickListener) {
            return new ProductFeedRecyclerAdapter(products, productClickListener);
        }

        static ProductFeedRecyclerAdapter createStoreFragment(List<IProduct> products, ProductFeedRecyclerAdapter.StoreProductClickListener productClickListener) {
            return new ProductFeedRecyclerAdapter(products, productClickListener);
        }
    }



