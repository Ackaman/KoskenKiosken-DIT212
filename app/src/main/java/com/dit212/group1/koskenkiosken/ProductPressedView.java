package com.dit212.group1.koskenkiosken;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProductPressedView extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String dataTransmitted = intent.getStringExtra("DataKey");
        Toast.makeText(this, dataTransmitted, Toast.LENGTH_SHORT).show();


    }
}
