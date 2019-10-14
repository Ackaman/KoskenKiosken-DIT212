package com.dit212.group1.koskenkiosken;

import com.dit212.group1.koskenkiosken.Model.Product.IProduct;

import java.util.List;
/**
 * Listener interface that will handle notify all classes that implements this interface.
 */
public interface FragmentListener {
    void onInputStoreSent(List<IProduct> input);
}