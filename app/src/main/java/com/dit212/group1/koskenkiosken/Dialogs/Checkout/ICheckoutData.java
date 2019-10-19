package com.dit212.group1.koskenkiosken.Dialogs.Checkout;

/**
 * Author: created by thowsen, 2019-10-19
 * Description: data provider for text fields in checkout-dialog
 */

public interface ICheckoutData {
    /**
     * retrieves the quantity of which to display in checkout dialog.
     * @return the quantity of which to display in checkout dialog.
     */
    int getQuantity();

    /**
     * retrieves the sum of which to display in checkout dialog.
     * @return the sum of which to display in checkout dialog.
     */
    int getSum();
}
