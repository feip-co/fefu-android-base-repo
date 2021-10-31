package com.example.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton

class Login : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val nav = findViewById<Toolbar>(R.id.toolbar2)
        val log = findViewById<MaterialButton>(R.id.log_button)

        nav.setOnClickListener {
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
        }

        log.setOnClickListener {
            val intent1 = Intent(this, Main::class.java)
            startActivity(intent1)
        }
    }
}