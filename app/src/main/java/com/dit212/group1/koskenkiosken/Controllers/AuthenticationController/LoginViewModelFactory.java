package com.dit212.group1.koskenkiosken.Controllers.AuthenticationController;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.dit212.group1.koskenkiosken.Model.Authentication.LoginDataSource;
import com.dit212.group1.koskenkiosken.Model.Authentication.LoginRepository;

/**
 * @author Albin Otterhäll <gusalbiot@student.gu.se>
 * Uses: LoginDataSource, LoginRepository, LoginViewModel, LoginViewModelFactory.
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
public class LoginViewModelFactory implements ViewModelProvider.Factory {

    /**
     * A factory method that create LoginViewModels.
     *
     * @param modelClass
     * @return A LoginViewModel or something based on it
     */
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(LoginRepository.getInstance(new LoginDataSource()));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
