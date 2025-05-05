package ru.fefu.hw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity(R.layout.login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button1 = findViewById<Button>(R.id.login_btn)


        button1.setOnClickListener {
            val intent = Intent(this, NavigateActivity::class.java)
            startActivity(intent)

        }
        val backButton = findViewById<ImageView>(R.id.ArrowBack)
        backButton.setOnClickListener {
            finish()
        }
    }



}