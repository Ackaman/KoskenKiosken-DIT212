package com.dit212.group1.koskenkiosken.Controllers.MainController;

import com.dit212.group1.koskenkiosken.Model.Product.IProduct;

import java.util.List;
/**
 * @author David Persson.
 * Listener interface that will handle notify all classes that implements this interface.
 * Uses: IProduct.
 */
public interface FragmentListener {
    void onInputStoreSent(List<IProduct> input);
}