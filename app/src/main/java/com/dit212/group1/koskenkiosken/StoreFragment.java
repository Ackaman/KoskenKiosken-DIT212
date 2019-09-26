package com.dit212.group1.koskenkiosken;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Author: created by -, on -
 * Description: Store page "controller". feeds product-specific textfields and/or buttons of the
 * view to data and functions from a list of products.
 */
public class StoreFragment extends Fragment implements ProductFeedRecyclerAdapter.ProductClickListener, ProductFeedRecyclerAdapter.PurchaseClickListener {
    private ArrayList<IProduct> products;
    private ArrayList<IProduct> cart;
    private String test;

    public StoreFragment() {
        this.cart = new ArrayList<>();
        // Required empty public constructor
    }

    /**
     * constructor takes a list of products as argument.
     * As of now we only use one product hence we only take the first element in the list.
     * @param productsinstore list of products to be displayed in fragment
     */
    StoreFragment(ArrayList<IProduct> productsinstore, ArrayList<IProduct> cart){
        this.products = productsinstore;
        this.cart = cart;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //getParentFragment().setMenuVisibility(false);
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

        rv.setAdapter(new ProductFeedRecyclerAdapter(products, this,this ));

        rv.setLayoutManager(llm);


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_topbar, menu) ;
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
     * When a product is pressed this function will handle modle blabbla
     * Change second argument in intent to whatever, need a parser to parse object (produkt)
     * @param position Objects position in list
     */
    @Override
    public void onProductClick(int position) {
        String test = products.get(position).getName();
        Toast.makeText(this.getContext(), test, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ProductPressedView.class);
        String doubleTest = test + test;
        intent.putExtra("DataKey", doubleTest);
         //intent.putExtra(products.get(position).getName());
        startActivity(intent);
    }




    @Override
    public void onPurchaseClick(int position) {
        cart.add(products.get(position));
        test = "";

        for (IProduct p : cart){
            test = test + p.getName() + " ";
        }

        Toast.makeText(this.getContext(), test , Toast.LENGTH_LONG).show();
    }



    //@Override
    //public void onPurchaseclick(int position) {
    //    Toast.makeText(this.getContext(), "PRODUKTEN TRYCKTES PÅ", Toast.LENGTH_LONG).show();
    // }
}


