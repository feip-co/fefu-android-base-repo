package ru.fefu.activitytracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class LoginActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var tryLoginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewsById()

        setupToolbar()
        setListeners()
    }

    private fun setupToolbar() {
        with(toolbar) {
            title = resources.getString(R.string.enter)
            setNavigationOnClickListener { finish() }
        }
    }

    private fun findViewsById() {
        toolbar = findViewById(R.id.registration_toolbar)
        loginEditText = findViewById(R.id.login_screen_login_edit_text)
        passwordEditText = findViewById(R.id.login_screen_password_edit_text)
        tryLoginButton = findViewById(R.id.try_login_button)
    }

    private fun setListeners() {
        tryLoginButton.setOnClickListener {
            if (formsIsValid()) {
                showToast("А на этом всё!")
            } else {
                showToast("Введены некоректные данные")
            }
        }
    }

    private fun formsIsValid() = (
            loginEditText.text.toString().isNotEmpty() &&
                    passwordEditText.text.toString().isNotEmpty())
}