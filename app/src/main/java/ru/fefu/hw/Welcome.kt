package ru.fefu.hw

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Welcome : AppCompatActivity(R.layout.welcome) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button1 = findViewById<Button>(R.id.btn_1)
        val button2 = findViewById<Button>(R.id.btn_2)

        button1.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }

}