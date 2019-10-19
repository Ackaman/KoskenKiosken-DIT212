package com.dit212.group1.koskenkiosken;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.dit212.group1.koskenkiosken.Model.Product.IProduct;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProductPressedView extends AppCompatActivity {

    /**
     * runs when activity is started.
     * checks for previous model before creating a new.
     * @param savedInstanceState not used.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_pressed_view);
        Intent intent = getIntent();
        IProduct product = intent.getParcelableExtra("product");

        if (product != null) {
            String productName = product.getName();
            int productPrice = product.getPrice();
            String productDescription = product.getDescription();
            String productPriceKr = productPrice + " Kr";

            TextView text1 = findViewById(R.id.productName2);
            text1.setText(productName);

            EditText text2 = findViewById(R.id.productPrice2);
            text2.setText(productPriceKr);

            TextView text3 = findViewById(R.id.productDescription);
            text3.setText(productDescription);
        }
    }
}