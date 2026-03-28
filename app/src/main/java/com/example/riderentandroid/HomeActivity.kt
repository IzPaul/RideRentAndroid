package com.example.riderentandroid

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.riderentandroid.ui.auth.LoginActivity

class HomeActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        welcomeText.text = "Welcome to the Home Screen!"


        val logoutButton = findViewById<Button>(R.id.logoutButton)
        logoutButton.setOnClickListener {
            Toast.makeText(this, "Logout successful!", Toast.LENGTH_SHORT).show()
            val intent = android.content.Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}