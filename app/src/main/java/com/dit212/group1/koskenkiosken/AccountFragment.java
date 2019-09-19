package com.dit212.group1.koskenkiosken;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dit212.group1.koskenkiosken.Model.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    private User thisUser;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (thisUser == null){ thisUser = ((MainActivity)getActivity()).getCurrentUser();}

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

}
