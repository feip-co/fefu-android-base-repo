package com.example.app
import android.app.Activity
import android.content.Intent
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton

class Registration : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        val nav = findViewById<Toolbar>(R.id.toolbar1)
        val button = findViewById<MaterialButton>(R.id.reg_button)

        nav.setOnClickListener {
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val intent1 = Intent(this, Login::class.java)
            startActivity(intent1)
        }
    }
}