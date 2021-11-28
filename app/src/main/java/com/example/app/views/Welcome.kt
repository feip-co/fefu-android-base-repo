package com.example.app.views
import android.app.Activity
import android.os.Bundle
import android.content.Intent
import com.example.app.R
import com.google.android.material.button.MaterialButton


class Welcome : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val button = findViewById<MaterialButton>(R.id.reg)
        val buttonDown = findViewById<MaterialButton>(R.id.btn_account)

        button.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
        buttonDown.setOnClickListener {
            val intent1 = Intent(this, Login::class.java)
            startActivity(intent1)
        }
    }
}