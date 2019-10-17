package com.dit212.group1.koskenkiosken;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dit212.group1.koskenkiosken.DB.DatabaseHelper;
import com.dit212.group1.koskenkiosken.Model.Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProductRecommendationsFragment extends Fragment {

    private Button btnRecommendProducts;
    private EditText productToRecommend;
    private Model m;

    /**
     * Required public constructor
     */
    public ProductRecommendationsFragment(){
    }

    /**
     * Passes the model to the fragment
     * @param m     The reference to the model
     */
    ProductRecommendationsFragment(Model m){
        this.m = m;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.product_recommendations, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnRecommendProducts = view.findViewById(R.id.btnRecommendProduct);
        productToRecommend = view.findViewById(R.id.productToRecommend);
        btnRecommendProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertDataToDb();
                Toast.makeText(getContext(), "Tack för din synpunkt!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Sends data of the product that got recommended and the logged in user who
     * recommended it to the model
     */
    public void insertDataToDb(){
        String recommendedProduct = productToRecommend.getText().toString();
        String nameOfUser = m.getLoggedInUser().getUserName();
        m.queryRecommendedProductToDatabase(DatabaseHelper.getDatabaseHelper(), recommendedProduct, nameOfUser);
    }





}
