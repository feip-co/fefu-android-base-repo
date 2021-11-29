package ru.fefu.activitytracker

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Button
import android.content.Intent
import android.widget.TextView


class ActivityTracker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker)

        val button = findViewById<Button>(R.id.registry_button)
        button.setOnClickListener(){
            val intent = Intent(this, RegistryActivity::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<TextView>(R.id.login_button)
        button2.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}

