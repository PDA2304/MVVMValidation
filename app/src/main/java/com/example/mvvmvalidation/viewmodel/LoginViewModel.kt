package com.example.mvvmvalidation.viewmodel

import android.app.Activity
import android.app.Application
import android.database.sqlite.SQLiteDatabase
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.mvvmvalidation.LoginResultCallBacks
import com.example.mvvmvalidation.MainActivity
import com.example.mvvmvalidation.model.DataBaseHelper
import com.example.mvvmvalidation.model.User
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(private val listener: LoginResultCallBacks) : ViewModel() {

    private val user: User
    private lateinit var auth: FirebaseAuth

    init {
        this.user = User("", "");
    }

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                user.setEmail(p0.toString())
            }
        }

    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                user.setPassword(p0.toString())
            }
        }
    public var DB: DataBaseHelper? = null
    fun onLoginClicked(v: View) {
        var main = MainActivity()
       main.add(user.getPassword(),user.getEmail())
        if (user.isDataValid) {
            auth = FirebaseAuth.getInstance()
            auth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(main) { task ->
                    if (task.isSuccessful) {
                        listener.onSuccess("Пользователь заргистрирован")
                    } else {
                        listener.onError("ошибка Авторизации")
                    }
                }// Добавление данных в базу данных firebase
        } else {
            listener.onError("Ошибка")
        }
    }

}