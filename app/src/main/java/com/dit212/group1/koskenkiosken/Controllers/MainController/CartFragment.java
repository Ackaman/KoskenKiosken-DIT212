package com.dit212.group1.koskenkiosken.Controllers.MainController;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dit212.group1.koskenkiosken.Controllers.MainController.Dialogs.Checkout.DialogCheckoutFactory;
import com.dit212.group1.koskenkiosken.Controllers.MainController.Dialogs.Checkout.ICheckoutData;
import com.dit212.group1.koskenkiosken.Controllers.MainController.Dialogs.Checkout.ICheckoutResponseListener;
import com.dit212.group1.koskenkiosken.Controllers.MainController.Dialogs.Checkout.IDialogCheckout;
import com.dit212.group1.koskenkiosken.Model.Model;
import com.dit212.group1.koskenkiosken.Model.Product.IProduct;
import com.dit212.group1.koskenkiosken.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * Author: created by Johan Almroth, Morgan Thowsen, David Persson.
 * Uses: DialogCheckoutFactory, ICheckoutData, ICheckoutResponseListener, IDialogCheckout,
 * Model, IProduct, ProductFeedRecyclerAdapterFactory, ProductFeedRecyclerAdapter, ProductPressedView
 * FragmentListener.
 * Description: Cart page "controller". feeds product-specific textfields and/or buttons of the
 * view to data and functions from a list of products. Also handles purchase delegation to the model.
 */

public class CartFragment extends Fragment implements ProductFeedRecyclerAdapter.CartProductClickListener {

    private ProductFeedRecyclerAdapter pAdapter;
    private FloatingActionButton fab;
    private FragmentListener listener;
    private Model m;
    private final String TAG = getClass().getName();


    public CartFragment() {
    }

    /**
     * constructor takes a list of products as argument.
     */
    CartFragment(Model m){
        this.m = m;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    /**
     * References for the Text in this view.
     * @param view view to attach fragment to.
     * @param savedInstanceState settings from previous activites/fragments
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab = view.findViewById(R.id.cart_fab_checkout);
        bindFab();

        RecyclerView rv = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getContext());
        pAdapter = (ProductFeedRecyclerAdapterFactory.createCartFragment(m.viewCart(), this));
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(llm);
    }

    /**
     *
     * @param position Returns the index of the clicked view.
     */
    @Override
    public void onProductClick(int position) {
        if (!ProductPressedView.isActive()) {
            Intent intent = new Intent(getActivity(), ProductPressedView.class);
            List<IProduct> products = m.viewCart();
            intent.putExtra("name", products.get(position).getName());
            intent.putExtra("price", products.get(position).getPrice());
            intent.putExtra("description", products.get(position).getDescription());
            startActivity(intent);
        }
    }

    /**
     * increases the amount of the clicked item by one.
     * @param position the index of the product to increment.
     */
    @Override
    public void onIncrementClick(int position) {
        try {
            m.addToCart(m.viewCart().get(position));
            pAdapter.updateList(m.viewCart());
            listener.onInputStoreSent(m.viewCart());
        }
        catch (Exception e){
            Log.e(TAG, "IndexOutOfBounds");
        }

    }

    /**
     * decreases the amount of the clicked item by one.
     * @param position the index of the product to decrement.
     */
    @Override
    public void onDecrementClick(int position) {
        try {
            m.removeFromCart(m.viewCart().get(position));
            pAdapter.updateList(m.viewCart());
            listener.onInputStoreSent(m.viewCart());
        }
        catch (Exception e){
            Log.e(TAG, "IndexOutOfBounds");
        }
    }



    /**
     * Used for FragmentListeners
     * @param context the context of which the attach occurs.
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            listener = (FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() +" must implement FragmentListener");
        }
    }

    /**
     * Used for FragmentListeners
     */
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    /**
     * binds the floating action button to the creation fo a dialog.
     */
    private void bindFab(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // buy button listener.
                ICheckoutResponseListener listener = new ICheckoutResponseListener() {
                    @Override
                    public void actOnPositiveResponse() {
                        Purchase();
                    }
                };

                // dataprovider for textfields.
                ICheckoutData data = new ICheckoutData() {
                    @Override
                    public int getQuantity() {
                        return m.getSizeOfCart();
                    }

                    @Override
                    public int getSum() {
                        return m.getPrice();
                    }
                };

                // create via factory
                IDialogCheckout dc = DialogCheckoutFactory.create(v.getContext(), listener,data);

                // create and inflate.
                dc.show();
            }
        });
    }

    /**
     * tries to make a single purchase. will have to be redone in future with an external transaction handler.
     */
    private void Purchase(){
        boolean transactionCompleted = m.purchase();
        if (transactionCompleted) {
            pAdapter.updateList(m.viewCart());
            listener.onInputStoreSent(m.viewCart());
            // for feedback.
            Toast.makeText(getContext(), "Tack för ditt köp", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Inte nog med credits", Toast.LENGTH_SHORT).show();
        }
    }
}
