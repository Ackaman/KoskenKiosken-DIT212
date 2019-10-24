package com.dit212.group1.koskenkiosken.Controllers.MainController;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.dit212.group1.koskenkiosken.DB.DatabaseHelper;
import com.dit212.group1.koskenkiosken.Model.Model;
import com.dit212.group1.koskenkiosken.Model.Product.IProduct;
import com.dit212.group1.koskenkiosken.Model.User.UserFactory;
import com.dit212.group1.koskenkiosken.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

/**
 * Author: created by -, on -
 * Description: main controller switching between fragments and binding non-fragment specific buttons.
 * also delegates pieces of the model to fragments.
 */

public class MainActivity extends AppCompatActivity implements FragmentListener {

    private AccountFragment accountFragment;
    private StoreFragment storeFragment;
    private CartFragment cartFragment;
    private ProductRecommendationsFragment recommendationFragment;
    private BottomNavigationView bnv;
    private Model m;
    private TextView cartBubble;


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
        disableHomeButton();

        setModel(savedInstanceState);
        initFragments(m);

        setFragment(storeFragment);
        setBottomNavigationBarListener();
        cartBubble = findViewById(R.id.cart_size);

    }

    private void initFragments(Model m){
        if (accountFragment == null) accountFragment = new AccountFragment(m.getLoggedInUser());
        if (storeFragment == null) storeFragment = new StoreFragment(m);
        if (cartFragment == null) cartFragment = new CartFragment(m);
        if (recommendationFragment == null) recommendationFragment = new ProductRecommendationsFragment(m);
    }

    /**
     * Updates the cart in Model.
     * @param input products in cart.
     */
    @Override
    public void onInputStoreSent(List<IProduct> input) {
        if (m.getSizeOfCart() <= 0) {
            cartBubble.setVisibility(View.INVISIBLE);
        }
        else {
            m.setCart(input);
            int x = m.getSizeOfCart();
            String s = Integer.toString(x);
            cartBubble.setText(s);
            cartBubble.setVisibility(View.VISIBLE);
        }

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
                        accountFragment.updateUser(m.getLoggedInUser());
                        setFragment(accountFragment);
                        break;
                    case R.id.store:
                        setFragment(storeFragment);
                        break;
                    case R.id.cart_bottom:
                        setFragment(cartFragment);
                        break;
                    case  R.id.recommendations:
                        setFragment(recommendationFragment);
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
        if (m == null){
            m = new Model();
            m.setLoggedInUser(UserFactory.createMockUser());
            m.parseFromIDatabase(DatabaseHelper.getDatabaseHelper());
        }
    }

    /**
     * disables the back button.
     */
    private void disableHomeButton(){
        androidx.appcompat.app.ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeButtonEnabled(false); // disable the button
            ab.setDisplayHomeAsUpEnabled(false); // remove the left caret
            ab.setDisplayShowHomeEnabled(false); // remove the icon
        }
    }
}
