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
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    private IUser userID;
    private TextView credits;
    private TextView user;
    private View rootView;

    public AccountFragment() {
        // Required empty public constructor
    }


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
        String usernameLine = getResources().getString(R.string.username,getUserName());
        user.setText(usernameLine);
        user.append(getUserName());
        String creditsLine = getResources().getString(R.string.credits,getCredits());
        credits.setText(creditsLine);
        }

    }



    // Currently returning string
    private int getCredits(){
        return userID.getCredits();
    }
    private String getUserName(){return userID.getUserName();}
}
