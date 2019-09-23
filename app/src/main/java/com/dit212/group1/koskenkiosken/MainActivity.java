package com.dit212.group1.koskenkiosken;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.dit212.group1.koskenkiosken.Model.Product;
import com.dit212.group1.koskenkiosken.Model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private AccountFragment accountFragment;
    private StoreFragment storeFragment;
    private User currentUser;
    private ArrayList<Product> productsList;



    /**
     *
     * @param savedInstanceState standard definition of onCreate.
     * Initiates a user that will act as logged in user until login is implemented.
     * Also creating the fragments for store and account.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateProducts();
        generateUser();

        accountFragment = new AccountFragment(currentUser);
        storeFragment = new StoreFragment(productsList);
        setStartFragment();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.account:
                        Toast.makeText(MainActivity.this, "Logged in as: " + currentUser.getUserName(), Toast.LENGTH_SHORT).show();
                        setFragment(accountFragment);
                        break;
                    case R.id.store:
                        setFragment(storeFragment);
                        break;
                }
                return true;
            }



        });
        }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Method to generate a list of products that will be passed to Store fragment
     */
    private void generateProducts(){
        this.productsList = new ArrayList<>();

        productsList.add(new Product("Chokladboll", 2, 5, 10));
        productsList.add(new Product("Nocco", 1, 15, 10));
        productsList.add(new Product("HariboNallar", 3, 2, 10));
        productsList.add(new Product("Kaffepaket", 4, 20, 10));
    }

    /**
     * Generate mock user until database is implemented that will be passed to User fragment
     * */
    private void generateUser(){
        this.currentUser = new User();
    }

    /**
     * Helper method to set start fragment in MainActivity.
     * Change this to desired fragment, it is called by onCreate
     */
    private void setStartFragment(){
        setFragment(storeFragment);
    }


}