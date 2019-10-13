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
import com.dit212.group1.koskenkiosken.Model.Product.IProduct;

import java.util.List;


public class CartFragment extends Fragment implements ProductFeedRecyclerAdapter.ProductClickListener {

    private ICart cart;
    private ProductFeedRecyclerAdapter pAdapter;
    private FragmentStoreListener listener;
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

    @Override
    public void onProductClick(int position) {
        Toast.makeText(getContext(),"onProductClick", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAddToCartClick(int position) {
        Toast.makeText(getContext(),"onAddToCartClick", Toast.LENGTH_SHORT).show();

        pAdapter.updateList(cart.viewCart());

    }

    @Override
    public void onRemoveFromCartClick(int position) {
        Toast.makeText(getContext(),"onRemoveFromCartClick", Toast.LENGTH_SHORT).show();

        pAdapter.updateList(cart.viewCart());
    }

    @Override
    public void increment(int position) {
        cart.addToCart(cart.viewCart().get(position));
        Toast.makeText(getContext(),"increment", Toast.LENGTH_SHORT).show();
        pAdapter.updateList(cart.viewCart());
        listener.onInputStoreSent(m.getCart().viewCart());

    }

    @Override
    public void decrement(int position) {
        cart.removeFromCart(cart.viewCart().get(position));
        Toast.makeText(getContext(),"decrement", Toast.LENGTH_SHORT).show();
        pAdapter.updateList(cart.viewCart());
        listener.onInputStoreSent(m.getCart().viewCart());
    }

    public interface FragmentStoreListener {
        void onInputStoreSent(List<IProduct> input);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentStoreListener){
            listener = (FragmentStoreListener) context;
        } else {
            throw new RuntimeException(context.toString() +" must implement FragmentStoreListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
