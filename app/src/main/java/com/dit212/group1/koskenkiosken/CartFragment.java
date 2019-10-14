package com.dit212.group1.koskenkiosken;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dit212.group1.koskenkiosken.Model.Cart.ICart;
import com.dit212.group1.koskenkiosken.Model.Model;


public class CartFragment extends Fragment implements ProductFeedRecyclerAdapter.CartProductClickListener {

    private ICart cart;
    private ProductFeedRecyclerAdapter pAdapter;
    private FragmentListener listener;
    private Model m;


    public CartFragment() {
    }

    /**
     * constructor takes a list of products as argument.
     */
    CartFragment(Model m){
        this.cart = m.getCart();
        this.m = m;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_store, container, false);
    }

    /**
     * References for the Text in this view.
     * @param view view to attach fragment to.
     * @param savedInstanceState settings from previous activites/fragments
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rv = view.findViewById(R.id.recyclerview);

        RecyclerView.LayoutManager llm = new LinearLayoutManager(getContext());
        pAdapter = (ProductFeedRecyclerAdapterFactory.createCartFragment(cart.viewCart(), this));
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(llm);
    }

    /**
     *
     * @param position Returns the index of the clicked view.
     */
    @Override
    public void onProductClick(int position) {
        Toast.makeText(getContext(),"onProductClick", Toast.LENGTH_SHORT).show();


    }

    /**
     *
     * Method is not yet used but logic goes here once implemented.
     */
    @Override
    public void onRemoveFromCartClick(int position) {
        Toast.makeText(getContext(),"onRemoveFromCartClick", Toast.LENGTH_SHORT).show();

        pAdapter.updateList(cart.viewCart());
    }

    /**
     * increases the amount of the clicked item by one.
     * @param position
     */
    @Override
    public void onIncrementClick(int position) {
        cart.addToCart(cart.viewCart().get(position));
        Toast.makeText(getContext(),"increment", Toast.LENGTH_SHORT).show();
        pAdapter.updateList(cart.viewCart());
        listener.onInputStoreSent(m.getCart().viewCart());

    }

    /**
     * decreases the amount of the clicked item by one.
     * @param position
     */
    @Override
    public void onDecrementClick(int position) {
        cart.removeFromCart(cart.viewCart().get(position));
        Toast.makeText(getContext(),"decrement", Toast.LENGTH_SHORT).show();
        pAdapter.updateList(cart.viewCart());
        listener.onInputStoreSent(m.getCart().viewCart());
    }


    /**
     * Used for FragmentListeners
     * @param context
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
}
