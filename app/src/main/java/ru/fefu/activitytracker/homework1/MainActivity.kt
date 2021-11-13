package ru.fefu.activitytracker.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.fefu.activitytracker.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val login_button : Button =  findViewById(R.id.ButtonLog);
        val registration : Button =  findViewById(R.id.ButtonReg);
        registration.setOnClickListener{
            startActivity(Intent(this,SecondActivity::class.java))
        }
        login_button.setOnClickListener{
            startActivity(Intent(this,ThirdActivity::class.java))
        }
    }
}