package com.dit212.group1.koskenkiosken.Controllers.MainController.Dialogs.Checkout;

/**
 * Author: created by thowsen, 2019-10-19
 * Uses: none.
 * heavily restricted public interface for an instance of a DialogCheckout.
 */
public interface IDialogCheckout {
    /**
     * inflates/starts the dialog. rest of Dialog attributes is fulfilled in the factory create method.
     */
    void show();
}
