package com.dit212.group1.koskenkiosken.Controllers.MainController.Dialogs.Checkout;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.dit212.group1.koskenkiosken.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: created by thowsen, 2019-10-19
 * Uses: ICheckoutResponseListener, IDialogCheckout.
 * Description: Dialog window for checkout  (buying products in cart).
 * package private! alterations are done from factory method in separate class. IDialogCheckout
 * is exposed.
 */

class DialogCheckout extends Dialog implements IDialogCheckout{
    private final Context c;
    private Button positiveButton;
    private TextView negativeButton;
    private TextView textMessage;
    private ICheckoutData data;
    private final List<ICheckoutResponseListener> listeners;


    /**
     * constructor
     * @param context context of which the dialog is loaded.
     */
    DialogCheckout(@NonNull Context context) {
        super(context);
        this.c = context;
        listeners = new LinkedList<>();
    }

    /**
     * sets a provider for information to the text fields within the dialog.
     * @param data the data provider.
     */

    public void setDataProvider(ICheckoutData data){ this.data = data;}

    /**
     * oncreate. binds buttons to buttons in xml and calls init and bind functions.
     * @param savedInstanceState not used.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_checkout);


        this.positiveButton = findViewById(R.id.positive_response_button);
        this.negativeButton = findViewById(R.id.negative_response_text_field);
        this.textMessage = findViewById(R.id.text_message_checkout);

        initTexts(data);
        bindButtons();
    }

    /**
     * sets all text fields in dialog, including header/title.
     */

    private void initTexts(@NonNull ICheckoutData data){
        this.setTitle("Checkout");
        String quantity = Integer.toString(data.getQuantity());
        String sumPrice = Integer.toString(data.getSum());
        String msg = c.getResources().getString(R.string.dialog_checkout_text_message, quantity,sumPrice);
        textMessage.setText(msg);
    }

    /**
     * binds buttons in dialog.
     */

    private void bindButtons(){

        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyListenersPositive();
                dismiss();
            }
        });
    }

    /**
     * adds a listener to button presses in dialog.
     * @param listener the listener which to react on notifications.
     */

    public void addResponseListener(ICheckoutResponseListener listener){
        listeners.add(listener);
    }

    /**
     * notifies potential listeners that positive button has been pressed.
     */

    private void notifyListenersPositive(){
        for (ICheckoutResponseListener l : listeners)
            l.actOnPositiveResponse();
    }

}
