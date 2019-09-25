package com.dit212.group1.koskenkiosken;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dit212.group1.koskenkiosken.Model.IUser;
import com.dit212.group1.koskenkiosken.Model.UserFactory;


/**
 * Author: created by -, on -
 * Description: Account page "controller". feeds user-specific textfields and/or buttons of the
 * view to data and functions from controller.
 */
public class AccountFragment extends Fragment {

    private IUser userID;
    private TextView credits;
    private TextView user;

    /**
     * empty constructor required by platform.
     */
    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * constructor for fragment
     * @param currentUser user to display information from.
     */
    AccountFragment(IUser currentUser){
        this.userID = currentUser;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (savedInstanceState != null){
            userID = UserFactory.createMock();
        }

        return inflater.inflate(R.layout.fragment_account, container, false);
    }


    /**
     * references to text fields
     * @param view view of which to attach fragment to.
     * @param savedInstanceState information and flags from previous activites/fragments.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        credits = view.findViewById(R.id.current_credits);
        user  = view.findViewById(R.id.current_user);



    }

    /**
     *  Sets text fields to current user name and user's credits
     */
    @Override
    public void onStart(){
    super.onStart();
    View v = getView();
    if (v != null){
        String usernameLine = getResources().getString(R.string.username,userID.getUserName());
        user.setText(usernameLine);
        user.append(userID.getUserName());
        String creditsLine = getResources().getString(R.string.credits,userID.getCredits());
        credits.setText(creditsLine);
        }

    }
}
