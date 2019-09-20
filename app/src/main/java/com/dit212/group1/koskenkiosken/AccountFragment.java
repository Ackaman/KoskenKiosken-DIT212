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


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    private User userID;
    TextView credits;
    TextView user;
    View rootView;

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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rootView = view;
        credits = rootView.findViewById(R.id.current_credits);
        user  = view.findViewById(R.id.current_user);



    }

    @Override
    public void onStart(){
    super.onStart();
    View view = getView();
    if (view != null){
        user.setText("Username: ");
        user.append(getUserName());
        if(getCredtis().equals("0")) {
            credits.setText("All you money are belong to us");
        }
            else{
                credits.setText("Credits: ");
                credits.append(getCredtis());
            }
        }

        (view.findViewById(R.id.donate_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donate_pressed();
            }
        });

        (view.findViewById(R.id.purchase_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchase_pressed();
            }
        });

    }

    public void donate_pressed(){
        if(userID.getCredits()>1) {
            userID.setCredits(userID.getCredits() - 1);
            credits.setText("Credits: " + (getCredtis()));
        }
        else{
            credits.setText("All you money are belong to us");
        }
    }

    public void purchase_pressed(){
        if(userID.getCredits() <50){
            userID.setCredits(userID.getCredits() + 1);
            credits.setText("Credits: " + getCredtis());
        }
        else{
            Toast.makeText(rootView.getContext(), "Fulladdat med Monaden Cash", Toast.LENGTH_SHORT).show();
        }

    }

    private String getCredtis(){
        return Integer.toString(userID.getCredits());
    }
    private String getUserName(){return userID.getUserName();}
}
