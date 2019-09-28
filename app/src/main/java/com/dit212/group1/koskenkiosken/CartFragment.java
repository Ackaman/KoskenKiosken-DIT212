package com.dit212.group1.koskenkiosken;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dit212.group1.koskenkiosken.Model.IProduct;
import java.util.ArrayList;


public class CartFragment extends Fragment implements ProductFeedRecyclerAdapter.ProductClickListener {

    private ArrayList<IProduct> cart;

    public CartFragment() {
    }

    /**
     * constructor takes a list of products as argument.
     */
    CartFragment(ArrayList<IProduct> cart){
        this.cart = cart;
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

        rv.setAdapter(new ProductFeedRecyclerAdapter(cart,this));

        rv.setLayoutManager(llm);
    }

    /**
     * updates the local cart value if anything is added to it.
     * @param newCart
     */
    public void updateCart (ArrayList<IProduct> newCart){
        cart = newCart;
    }

    @Override
    public void onProductClick(int position) {

    }

    @Override
    public void onAddToCartClick(int position) {

    }

    @Override
    public void onRemoveFromCartClick(int position) {
            cart.remove(cart.get(position));
    }
}
