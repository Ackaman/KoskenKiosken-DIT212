package com.dit212.group1.koskenkiosken;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.dit212.group1.koskenkiosken.Model.IProduct;
import java.util.ArrayList;


/**
 * Author: created by -, on -
 * Description: Store page "controller". feeds product-specific textfields and/or buttons of the
 * view to data and functions from a list of products.
 */
public class StoreFragment extends Fragment implements ProductFeedRecyclerAdapter.ProductClickListener, ProductFeedRecyclerAdapter.PurchaseClickListener {
    private ArrayList<IProduct> products;
    private ArrayList<IProduct> cart;
    private String test;
    private FragmentStoreLitsener listener;
    private ProductFeedRecyclerAdapter pAdapter;
    private ArrayList<IProduct> originalProductList;

    public StoreFragment() {
    }

    /**
     * constructor takes a list of products as argument.
     * As of now we only use one product hence we only take the first element in the list.
     *
     * @param productsinstore list of products to be displayed in fragment
     */
    StoreFragment(ArrayList<IProduct> productsinstore, ArrayList<IProduct> cart){
        this.products = productsinstore;
        this.cart = cart;
        originalProductList = products;
    }

    /**
     * Listener interface that will handle notify all classes that implements this interface.
     */
    public interface FragmentStoreLitsener {
        void onInputStoreSent(ArrayList<IProduct> input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
        pAdapter = new ProductFeedRecyclerAdapter(products, this, this);
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(llm);

    }

    /**
     * Adds all the products that is a substring of the search string in a new list.
     * @param search        The input string from the ActionBar in StoreFragment
     */
    private ArrayList<IProduct> sortString(String search) {
        ArrayList<IProduct> sortedProduct = new ArrayList<>();

        for (IProduct product : products) {
            if (product.getName().toLowerCase().contains(search.toLowerCase())) {
                sortedProduct.add(product);

            }
        }
        pAdapter.sortString(sortedProduct);
        return sortedProduct;

    }

    /**
     * Creates the "actionbar" menu on the top of the screen in StoreFragment
     * @param menu      menu
     * @param inflater      inflater
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_topbar_store, menu);
        SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                products = originalProductList;
                products = sortString(newText);
                return false;
            }
        });
    }


    /**
     * Changes the text placeholders to actualy product name and price.
     */
    @Override
    public void onStart(){
        super.onStart();
        this.test = "";

    }


    /**
     * When a product is pressed this function will start a new activity and pass the product.
     * @param position Objects position in list
     */
    @Override
    public void onProductClick(int position) {
        Intent intent = new Intent(getActivity(), ProductPressedView.class);
        intent.putExtra("product",products.get(position));
        System.out.println("onClick: " + products.toString());
        startActivity(intent);
    }


    /**
     * Purchaseclick = "+" nect to each product.
     * This method handles what we do when a user press "+"
     * position is the position in recycleview-list and will correspond to a product in our productlist.
     * @param position
     */
    @Override
    public void onPurchaseClick(int position) {
        cart.add(products.get(position));
        test = "";
        for (IProduct p : cart){
            test = test + p.getName() + " ";
        }
        listener.onInputStoreSent(cart);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentStoreLitsener){
            listener = (FragmentStoreLitsener) context;
        } else {
            throw new RuntimeException(context.toString() +" must implement FragmentStoreLitsener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}


