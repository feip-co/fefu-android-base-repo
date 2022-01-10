package ru.fefu.activitytracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    lateinit var registerButton: Button
    lateinit var alreadyHaveAccountButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        findViewsById()
        setButtonClickListeners()
    }

    private fun findViewsById() {
        registerButton = findViewById(R.id.registration_button)
        alreadyHaveAccountButton = findViewById(R.id.already_have_account_button)
    }

    private fun setButtonClickListeners() {
        registerButton.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
        alreadyHaveAccountButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
