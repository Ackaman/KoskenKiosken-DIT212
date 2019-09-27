package com.dit212.group1.koskenkiosken;



import android.os.Bundle;


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
 * A simple {@link Fragment} subclass.
 */
public class StoreFragment extends Fragment {
    private ArrayList<IProduct> products;
    private ProductFeedRecyclerAdapter pAdapter;
    //private EditText search;

    public StoreFragment() {
        // Required empty public constructor
    }

    /**
     * constructor takes a list of products as argument.
     * As of now we only use one product hence we only take the first element in the list.
     *
     * @param productsinstore list of products to be displayed in fragment
     */
    StoreFragment(ArrayList<IProduct> productsinstore) {
        this.products = productsinstore;
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
     *
     * @param view               view to attach fragment to.
     * @param savedInstanceState settings from previous activites/fragments
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rv = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getContext());
        pAdapter = new ProductFeedRecyclerAdapter(products);
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(llm);

    }

    /**
     * Adds all the products that is a substring of the search string in a new list.
     * @param search        The input string from the ActionBar in StoreFragment
     */
    private void sortString(String search) {
        ArrayList<IProduct> sortedProduct = new ArrayList<>();

        for (IProduct product : products) {
            if (product.getName().toLowerCase().contains(search.toLowerCase())) {
                sortedProduct.add(product);

            }
        }
        pAdapter.sortString(sortedProduct);
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
                sortString(newText);
                return false;
            }
        });
    }


    /**
     * Changes the text placeholders to actualy product name and price.
     */
    @Override
    public void onStart() {
        super.onStart();

    }


}


