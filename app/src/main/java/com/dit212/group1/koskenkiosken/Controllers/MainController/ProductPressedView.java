package com.dit212.group1.koskenkiosken.Controllers.MainController;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dit212.group1.koskenkiosken.R;

public class ProductPressedView extends AppCompatActivity {
    private static boolean isActive = false;


    /**
     * runs when activity is started.
     * checks for previous model before creating a new.
     *
     * @param savedInstanceState not used.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setIsActive(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_pressed_view);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String productName = bundle.getString("name");
            int productPrice = bundle.getInt("price");
            String productDescription = bundle.getString("description");

            String productPriceKr = productPrice + " Kr";

            TextView text1 = findViewById(R.id.productName2);
            text1.setText(productName);

            TextView text2 = findViewById(R.id.productPrice2);
            text2.setText(productPriceKr);

            TextView text3 = findViewById(R.id.productDescription);
            text3.setText(productDescription);

            ImageView imageview = findViewById(R.id.expandedProductImageView);
            int a = getApplicationContext().getResources().getIdentifier(productName.toLowerCase(),"drawable",getPackageName());
            imageview.setImageResource(a);
        }
        
    }

    @Override
    protected void onStop() {
        super.onStop();
        getDelegate().onStop();
        setIsActive(false);
        finish();
    }

    private void setIsActive(boolean liveState){
        isActive = liveState;

    }

    static boolean isActive(){
        return isActive;
    }
}
