package com.dit212.group1.koskenkiosken;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.dit212.group1.koskenkiosken.Model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private FrameLayout mMainFrame;
    private AccountFragment accountFragment;
    private StoreFragment storeFragment;
    private User currentUser;


    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * test comment
     * @param savedInstanceState tjohej
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        currentUser = new User(); //Hard coded, will eventually we swapped for database with login.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = findViewById(R.id.main_frame);
        accountFragment = new AccountFragment();
        storeFragment = new StoreFragment();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.account:
                        Toast.makeText(MainActivity.this, "ACCOUNT", Toast.LENGTH_SHORT).show();
                        setFragment(accountFragment, currentUser);
                        break;
                    case R.id.store:
                        Toast.makeText(MainActivity.this, "STORE", Toast.LENGTH_SHORT).show();
                        setFragment(storeFragment);
                        break;
                }
                return true;
            }

            private void setFragment(StoreFragment fragment) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, fragment);
                fragmentTransaction.commit();
            }

            private void setFragment(AccountFragment fragment, User testuser){
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, fragment);
                // Pass Object
                fragmentTransaction.commit();
            }
        });
    }

}