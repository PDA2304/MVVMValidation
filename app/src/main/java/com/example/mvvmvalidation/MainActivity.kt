package com.example.mvvmvalidation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmvalidation.databinding.ActivityMainBinding
import com.example.mvvmvalidation.model.DataBaseHelper
import com.example.mvvmvalidation.viewmodel.LoginViewModel
import com.example.mvvmvalidation.viewmodel.LoginViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity(), LoginResultCallBacks {
     var DB: DataBaseHelper? = DataBaseHelper(this@MainActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel =
            ViewModelProviders.of(this, LoginViewModelFactory(this)).get(LoginViewModel::class.java)
        add("as","ad")
    }

    fun add(string: String,string1: String)
    {
        DB!!.addData(string,string1)
    }

    override fun onSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}