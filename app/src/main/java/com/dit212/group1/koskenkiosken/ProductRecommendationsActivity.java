package com.dit212.group1.koskenkiosken;

import android.content.ContentValues;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dit212.group1.koskenkiosken.DB.DatabaseHelper;
import com.dit212.group1.koskenkiosken.Model.IDatabase;
import com.dit212.group1.koskenkiosken.Model.Model;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProductRecommendationsActivity extends AppCompatActivity {

    private Button btnRecommendProducts;
    private EditText productToRecommend;
    private EditText name;
    private Model m;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_recommendations);
        m = new Model();
        btnRecommendProducts = findViewById(R.id.btnRecommendProduct);
        productToRecommend = findViewById(R.id.productToRecommend);
        name = findViewById(R.id.whoRecommended);
        btnRecommendProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertDataToDb();
                Toast.makeText(ProductRecommendationsActivity.this, "Tack för din synpunkt!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void insertDataToDb(){
        String recommendedProduct = productToRecommend.getText().toString();
        String whoRecommended = name.getText().toString();
        m.queryRecommendedProductToDatabase(DatabaseHelper.getDatabaseHelper(), recommendedProduct, whoRecommended);
    }





}
