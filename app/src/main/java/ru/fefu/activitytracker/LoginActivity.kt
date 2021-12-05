package ru.fefu.activitytracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.view.View
import androidx.appcompat.widget.Toolbar


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginSubmitButton = findViewById<Button>(R.id.loginSubmitBtn)
        loginSubmitButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val toolbar: Toolbar = findViewById<View>(R.id.toolbarLogin) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        if(item.itemId == android.R.id.home)finish()
        return true
    }
}