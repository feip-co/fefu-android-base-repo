package java.ru.fefu.activitytracker.screens.registration

import android.content.Intent
import android.os.Bundle
import android.app.Activity
import android.text.method.LinkMovementMethod
import android.widget.ImageView
import android.widget.TextView
import ru.fefu.activitytracker.R
import java.ru.fefu.activitytracker.screens.welcome.WelcomeScreenActivity

class RegistrationScreenActivity :Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_screen);

        val backButton : ImageView = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            val intent = Intent(this, WelcomeScreenActivity::class.java)
            startActivity(intent)
        }

        val textLink : TextView = findViewById(R.id.confirm)
        textLink.setMovementMethod(LinkMovementMethod.getInstance())
    }
}