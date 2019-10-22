package com.dit212.group1.koskenkiosken;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dit212.group1.koskenkiosken.Model.User.IAccount;
import com.dit212.group1.koskenkiosken.Model.User.UserFactory;


/**
 * Author: created by -, on -
 * Description: Account page "controller". feeds user-specific textfields and/or buttons of the
 * view to data and functions from controller.
 */
public class AccountFragment extends Fragment {

    private IAccount userID;
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
    AccountFragment(IAccount currentUser){
        this.userID = currentUser;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (savedInstanceState != null){
            userID = UserFactory.createMockUser();
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
        String creditsLine = getResources().getString(R.string.credits,userID.getCredits());
        credits.setText(creditsLine);
        }
    }

    /**
     * updates user information source. (IAccount being immutable)
     * @param user the user of which to update.
     */

    public void updateUser(IAccount user){this.userID = user;}
}
