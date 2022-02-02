package ru.fefu.activitytracker.welcomescreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.fefu.activitytracker.databinding.ActivityLoginBinding
import ru.fefu.activitytracker.mainmenu.MainPartActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
            this.finish()
        }
        binding.loginAceptButton.setOnClickListener{
            startActivity(Intent(this, MainPartActivity::class.java))
            this.finish()
        }
    }
}