package java.ru.fefu.activitytracker.screens.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import ru.fefu.activitytracker.R
import java.ru.fefu.activitytracker.screens.welcome.WelcomeScreenActivity

class LoginScreenActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen);

        val backButton: ImageView = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            val intent = Intent(this, WelcomeScreenActivity::class.java)
            startActivity(intent)
        }
    }
}