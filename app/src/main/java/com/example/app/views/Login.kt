package com.example.app.views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.app.R
import com.example.app.views.viewholders.Nav_handler
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
            val intent1 = Intent(this, Nav_handler::class.java)
            startActivity(intent1)
        }
    }
}