package com.dit212.group1.koskenkiosken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // the scrollable field for products.
        rv = findViewById(R.id.recyclerView);

        LinearLayoutManager rvLayoutManager = new LinearLayoutManager(this);
        rvLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(rvLayoutManager);

        // setting adapter
        ProductFeedRecyclerAdapter adapter = new ProductFeedRecyclerAdapter(null);
        rv.setAdapter(adapter);
    }
}
