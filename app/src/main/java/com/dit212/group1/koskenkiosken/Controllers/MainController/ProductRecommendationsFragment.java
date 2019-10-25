package com.dit212.group1.koskenkiosken.Controllers.MainController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dit212.group1.koskenkiosken.DB.DatabaseHelper;
import com.dit212.group1.koskenkiosken.Model.Model;
import com.dit212.group1.koskenkiosken.R;

/**
 * @author Gustav Pihlquist.
 * Uses: DatabaseHelper, Model.
 * Description: Sends a userrecomendation to the database.
 */

public class ProductRecommendationsFragment extends Fragment {

    private EditText productToRecommend;
    private Model m;

    /**
     * Required public constructor
     */
    public ProductRecommendationsFragment(){
    }

    /**
     * Passes the model to the fragment
     * @param m The reference to the model
     */
    ProductRecommendationsFragment(Model m){
        this.m = m;
    }

    /**
     * Attaches the correct layout to the fragment
     * @param inflater inflater that inflates the layout
     * @param container container
     * @param savedInstanceState settings from previous activites/fragments
     * @return finished View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.product_recommendations, container, false);

    }

    /**
     *  References for the buttons and textviews
     * @param view the view to attach the fragment to
     * @param savedInstanceState settings from previous activites/fragments
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnRecommendProducts = view.findViewById(R.id.btnRecommendProduct);
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
    private void insertDataToDb(){
        String recommendedProduct = productToRecommend.getText().toString();
        String nameOfUser = m.getLoggedInUser().getName();
        m.queryProductRecommendation(DatabaseHelper.getDatabaseHelper(), recommendedProduct, nameOfUser);
    }





}
