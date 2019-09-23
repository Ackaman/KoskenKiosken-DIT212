package com.dit212.group1.koskenkiosken;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dit212.group1.koskenkiosken.Model.Product;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoreFragment extends Fragment {
    private ArrayList<Product> products;
    private TextView productName;
    private TextView productPrice;
    private View rootView;
    private Product singleProduct;

    public StoreFragment() {
        // Required empty public constructor
    }

    /**
     * constructor takes a list of products as argument.
     * As of now we only use one product hence we only take the first element in the list.
     * @param productsinstore
     */
    public StoreFragment(ArrayList<Product> productsinstore){
        this.products = productsinstore;
        this.singleProduct = products.get(0);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store, container, false);

    }

    /**
     * References for the Text in this view.
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView = view;
        productName  = rootView.findViewById(R.id.product_name);
        productPrice = rootView.findViewById(R.id.product_price);
    }


    /**
     * Changes the text placeholders to actualy product name and price.
     */
    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null){
            String price = "Price: " + Integer.toString(singleProduct.getPrice());
            productPrice.setText(price);
            String name = "Produkt" + singleProduct.getName();
            productName.setText(name);
            }
        }

    }


