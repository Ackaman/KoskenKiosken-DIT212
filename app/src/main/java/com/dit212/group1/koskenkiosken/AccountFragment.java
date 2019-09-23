package com.dit212.group1.koskenkiosken;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dit212.group1.koskenkiosken.Model.User;
import com.google.android.material.snackbar.Snackbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    private User userID;
    private TextView credits;
    private TextView user;
    private View rootView;

    public AccountFragment() {
        // Required empty public constructor
    }


    public AccountFragment(User currentUser){
        this.userID = currentUser;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (savedInstanceState != null){
            userID = new User();
        }

        return inflater.inflate(R.layout.fragment_account, container, false);
    }


    /**
     * references to text fields
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView = view;
        credits = rootView.findViewById(R.id.current_credits);
        user  = rootView.findViewById(R.id.current_user);



    }

    /**
     *  Sets text fields to current user name and user's credits
     */
    @Override
    public void onStart(){
    super.onStart();
    View view = getView();
    if (view != null){
        user.setText("Username: ");
        user.append(getUserName());
        credits.setText("Credits: " + Integer.toString(getCredits()));
        }

    }



    // Currently returning string
    private int getCredits(){
        return userID.getCredits();
    }
    private String getUserName(){return userID.getUserName();}
}
