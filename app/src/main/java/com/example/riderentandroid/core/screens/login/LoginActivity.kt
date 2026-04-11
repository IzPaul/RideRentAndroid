package com.example.riderentandroid.core.screens.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.riderentandroid.R
import com.example.riderentandroid.core.models.LoginRequest
import com.example.riderentandroid.core.network.RetrofitClient

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val api = RetrofitClient.instance
        presenter = LoginPresenter(this, api, LoginRequest())

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

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

}