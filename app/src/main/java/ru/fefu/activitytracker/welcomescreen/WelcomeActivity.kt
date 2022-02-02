package ru.fefu.activitytracker.welcomescreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.fefu.activitytracker.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registrationButton.setOnClickListener{
            startActivity(Intent(this, RegistrationActivity::class.java))
            this.finish()
        }
        binding.loginButton.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            this.finish()
        }

    }
}
