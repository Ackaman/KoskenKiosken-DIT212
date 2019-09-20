package com.dit212.group1.koskenkiosken;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.dit212.group1.koskenkiosken.Model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private FrameLayout mMainFrame;
    private AccountFragment accountFragment;
    private StoreFragment storeFragment;
    private User currentUser;


    /**
     * test comment
     * @param savedInstanceState tjohej
     */

    /**
     *
     * @param savedInstanceState standard definition of onCreate.
     * Initiates a user that will act as logged in user until login is implemented.
     * Also creating the fragments for store and accout.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentUser = new User();
        mMainFrame = findViewById(R.id.main_frame);
        accountFragment = new AccountFragment(currentUser);
        storeFragment = new StoreFragment();




        /**
         * Initiates a listener for our bottom navigation bar.
         * account,store refers to account button in the toolbar.
         * There are currently Toasts to ensure the listener is working when running the emulator.
         */
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
                        Toast.makeText(MainActivity.this, "Store is empty - som vanligt", Toast.LENGTH_SHORT).show();
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

}