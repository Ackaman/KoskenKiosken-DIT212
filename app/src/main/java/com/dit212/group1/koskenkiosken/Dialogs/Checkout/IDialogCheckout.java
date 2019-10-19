package com.dit212.group1.koskenkiosken.Dialogs.Checkout;

public interface IDialogCheckout {

    void setDataProvider(ICheckoutData data);
    void addResponseListener(ICheckoutResponseListener listener);
    void show();
}
