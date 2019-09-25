package com.dit212.group1.koskenkiosken;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.dit212.group1.koskenkiosken.DB.DatabaseHelper;
import com.dit212.group1.koskenkiosken.Model.Model;
import com.dit212.group1.koskenkiosken.Model.UserFactory;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Author: created by -, on -
 * Description: main controller switching between fragments and binding non-fragment specific buttons.
 * also delegates pieces of the model to fragments.
 */

public class MainActivity extends AppCompatActivity {

    private AccountFragment accountFragment;
    private StoreFragment storeFragment;
    private BottomNavigationView bnv;
    private Model m;


    /**
     * runs when activity is started.
     * checks for previous model before creating a new.
     *
     * @param savedInstanceState saved objects and flags from previous activities. not used.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bottom_navigation);

        setModel(savedInstanceState);
        initFragments(m);

        setFragment(storeFragment);
        setBottomNavigationBarListener();
    }

    private void initFragments(Model m){
        if (accountFragment == null) accountFragment = new AccountFragment(m.getLoggedInUser());
        if (storeFragment == null) storeFragment = new StoreFragment(m.listOfProducts());
    }

    /**
     * switches the fragment in activity view.
     * @param fragment the fragment to switch to.
     */
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    /**
     * binds buttons for bottom navigation bar
     */

    private void setBottomNavigationBarListener(){
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.account:
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

    /**
     * sets the model. creates a new if a previous model isnt stored in saved instance state.
     * @param savedInstanceState the bundle of which to look for a prior model.
     */

    private void setModel(Bundle savedInstanceState){
        if (m != null) return;
        if (savedInstanceState != null) m = savedInstanceState.getParcelable("Model");
        if (m == null) m = new Model(DatabaseHelper.getDatabaseHelper(), UserFactory.createMock());
    }

}