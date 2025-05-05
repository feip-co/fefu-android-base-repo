package ru.fefu.hw

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Register : AppCompatActivity(R.layout.register){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bar = findViewById<Toolbar>(R.id.toolbar_register)
        val button = findViewById<Button>(R.id.regis_btn)

        bar.setOnClickListener {

            finish()

        }
        button.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

}