package com.dit212.group1.koskenkiosken.Controllers.MainController.Dialogs.Checkout;

import android.content.Context;

import androidx.annotation.NonNull;

/**
 * Author: created by thowsen, 2019-10-19
 * Uses: ICheckoutResponseListener, ICheckoutData, DialogCheckout, IDialogCheckout.
 * factory pattern for Dialog Checkout.
 */
public class DialogCheckoutFactory {

    /**
     * hidden constructor. all calls should be static.
     */
    private DialogCheckoutFactory(){}

    /**
     * factory method for an IDialogCheckout instance with all attributes satisfied.
     * @param context context of which to load the dialog.
     * @param listener a listener for buttons presses within the dialog.
     * @param data data provider for text fields within the dialog.
     * @return an instance of IDialogCheckout provided with all attributes.
     */

    public static IDialogCheckout create(@NonNull Context context,
                                         ICheckoutResponseListener listener,
                                         ICheckoutData data){
        DialogCheckout dc = new DialogCheckout(context);
        dc.addResponseListener(listener);
        dc.setDataProvider(data);
        return dc;
    }

    /**
     * factory method for an IDialogCheckout instance with all attributes satisfied but no listener.
     * @param context context of which to load the dialog.
     * @param data data provider for text fields within the dialog.
     * @return an instance of IDialogCheckout provided with all attributes.
     */

    public static IDialogCheckout create(@NonNull Context context,
                                         ICheckoutData data){
        DialogCheckout dc = new DialogCheckout(context);
        dc.setDataProvider(data);
        return dc;
    }


}
