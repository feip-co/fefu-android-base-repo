package ru.fefu.activitytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val regSubmitButton = findViewById<Button>(R.id.regSubmitBtn)
        regSubmitButton.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val toolbar: Toolbar = findViewById<View>(R.id.toolbarReg) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        if(item.itemId == android.R.id.home)finish()
        return true
    }
}