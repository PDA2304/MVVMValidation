package com.example.mvvmvalidation.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmvalidation.LoginResultCallBacks
import com.example.mvvmvalidation.MainActivity

class LoginViewModelFactory(private val listener: LoginResultCallBacks) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener)as T
    }
}