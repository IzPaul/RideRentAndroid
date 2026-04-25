package com.example.riderentandroid.core.screens.profile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.riderentandroid.R
import com.example.riderentandroid.core.data.UserInfo
import com.example.riderentandroid.core.screens.login.LoginActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ensure these property names (firstname vs firstName) match your Data Class!
        val user = UserInfo("jp.arradaza@email.com", "Smith", "JP")
        displayUserInfo(user)

        val logoutButton = findViewById<Button>(R.id.logoutButton)
        logoutButton.setOnClickListener {
            Toast.makeText(this, "Logout successful!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val nav = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottomNavigation)
        nav.selectedItemId = R.id.nav_profile
    }

    private fun displayUserInfo(user: UserInfo) {
        val tvFullName = findViewById<TextView>(R.id.tvFullName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)

        // Triple-check these property names!
        tvFullName.text = "${user.firstName} ${user.lastName}"
        tvEmail.text = user.email
    }
}