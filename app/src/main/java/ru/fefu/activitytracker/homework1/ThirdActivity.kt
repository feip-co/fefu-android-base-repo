package ru.fefu.activitytracker.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.button.MaterialButton
import ru.fefu.activitytracker.R

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val backButton = findViewById<ImageView>(R.id.toolbarBack)
        val continueButton = findViewById<MaterialButton>(R.id.ButtonLogin)

        backButton.setOnClickListener{
            finish()
        }

        continueButton.setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}