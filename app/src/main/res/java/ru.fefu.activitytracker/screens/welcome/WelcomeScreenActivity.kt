package java.ru.fefu.activitytracker.screens.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.fefu.activitytracker.R
import java.ru.fefu.activitytracker.screens.login.LoginScreenActivity
import java.ru.fefu.activitytracker.screens.registration.RegistrationScreenActivity

class WelcomeScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_screen);

        val registration : Button = findViewById(R.id.registration_button)
        registration.setOnClickListener {
            val intent = Intent(this, RegistrationScreenActivity::class.java)
            startActivity(intent)
        }
        val login : Button = findViewById(R.id.to_login_button)
        login.setOnClickListener {
            val intent = Intent(this, LoginScreenActivity::class.java)
            startActivity(intent)
        }
    }
}