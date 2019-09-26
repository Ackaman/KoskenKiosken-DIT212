package com.dit212.group1.koskenkiosken;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.dit212.group1.koskenkiosken.Model.IProduct;
import com.dit212.group1.koskenkiosken.Model.IAccount;
import com.dit212.group1.koskenkiosken.Model.ProductFactory;
import com.dit212.group1.koskenkiosken.Model.UserFactory;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private AccountFragment accountFragment;
    private StoreFragment storeFragment;
    private IAccount currentUser;
    private ArrayList<IProduct> productsList;



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

        productsList.add(ProductFactory.create("Chokladboll", 2));
        productsList.add(ProductFactory.create("Nocco", 1));
        productsList.add(ProductFactory.create("HariboNallar", 3));
        productsList.add(ProductFactory.create("Kaffepaket", 4));
    }

    /**
     * Generate mock user until database is implemented that will be passed to User fragment
     * */
    private void generateUser(){
        this.currentUser = UserFactory.createMockUser();
    }

    /**
     * Helper method to set start fragment in MainActivity.
     * Change this to desired fragment, it is called by onCreate
     */
    private void setStartFragment(){
        setFragment(storeFragment);
    }


}