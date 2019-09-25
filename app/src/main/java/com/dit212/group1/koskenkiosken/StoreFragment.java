package com.dit212.group1.koskenkiosken;


import android.content.Intent;
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

import com.dit212.group1.koskenkiosken.Model.IProduct;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StoreFragment extends Fragment implements ProductFeedRecyclerAdapter.ProductClickListener {
    private ArrayList<IProduct> products;

    public StoreFragment() {
        // Required empty public constructor
    }

    /**
     * constructor takes a list of products as argument.
     * As of now we only use one product hence we only take the first element in the list.
     * @param productsinstore list of products to be displayed in fragment
     */
    StoreFragment(ArrayList<IProduct> productsinstore){
        this.products = productsinstore;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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

        rv.setAdapter(new ProductFeedRecyclerAdapter(products, this));

        rv.setLayoutManager(llm);
    }


    /**
     * Changes the text placeholders to actualy product name and price.
     */
    @Override
    public void onStart(){
        super.onStart();
    }


    /**
     * When a product is pressed this function will handle modle blabbla
     * Change second argument in intent to whatever, need a parser to parse object (produkt)
     * @param position Objects position in list
     */
    @Override
    public void onProductClick(int position) {
        Intent intent = new Intent(getActivity(), ProductPressedView.class);
        intent.putExtra("test", products.get(position));
        startActivity(intent);
    }
}


