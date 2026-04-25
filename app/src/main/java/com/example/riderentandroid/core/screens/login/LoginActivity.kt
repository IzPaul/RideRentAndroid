package com.example.riderentandroid.core.screens.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.riderentandroid.R
import com.example.riderentandroid.core.models.LoginRequest
import com.example.riderentandroid.core.network.RetrofitClient
import com.example.riderentandroid.core.screens.profile.ProfileActivity
import com.example.riderentandroid.core.screens.login.LoginModel

class LoginActivity : Activity(), LoginContract.LoginView {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val api = RetrofitClient.instance
        presenter = LoginPresenter(this, api, LoginModel())

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val email = usernameEditText.text.toString().trim()
            val pass = passwordEditText.text.toString().trim()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                presenter.login(email, pass)
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onLoginSuccessMessage() {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
    }

    override fun onLoginErrorMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToHomeScreen() {
        startActivity(Intent(this,ProfileActivity::class.java))
        finish()
    }
}