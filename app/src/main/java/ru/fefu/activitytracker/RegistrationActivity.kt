package ru.fefu.activitytracker

import android.content.Intent
import android.os.Bundle
import android.text.*
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ru.fefu.activitytracker.Utils.makeLinks

class RegistrationActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var completeRegistrationButton: Button
    private lateinit var loginEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var repeatPasswordEditText: EditText
    private lateinit var rulesTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        findViewsById()

        setupToolbar()
        setListeners()

        setSpannableToRules()
    }

    private fun setupToolbar() {
        with(toolbar) {
            title = resources.getString(R.string.enter)
            setNavigationOnClickListener { finish() }
        }
    }

    private fun findViewsById() {
        toolbar = findViewById(R.id.registration_toolbar)
        completeRegistrationButton = findViewById(R.id.complete_registration_button)
        loginEditText = findViewById(R.id.login_text_input_edit_text)
        nameEditText = findViewById(R.id.name_text_input_edit_text)
        passwordEditText = findViewById(R.id.password_text_input_edit_text)
        repeatPasswordEditText = findViewById(R.id.repeat_password_text_input_edit_text)
        rulesTextView = findViewById(R.id.rules_text_view)
    }

    private fun setListeners() {
        completeRegistrationButton.setOnClickListener {
            if (formsIsValid()) {
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                showToast("Все поля должны быть заполнены, а пароли совпадать")
            }
        }
    }

    private fun formsIsValid() = (loginEditText.text.toString().isNotEmpty() &&
            nameEditText.text.toString().isNotEmpty() &&
            passwordEditText.text.toString().isNotEmpty() &&
            repeatPasswordEditText.text.toString().isNotEmpty() &&
            passwordEditText.text.toString() == repeatPasswordEditText.text.toString())

    private fun setSpannableToRules() {
        makeLinks(
            rulesTextView,
            "политикой конфиденциальности" to View.OnClickListener {
                showToast("Вы первый человек в истории, кто нажал на эту кнопку")
            },
            "пользовательское соглашение" to View.OnClickListener {
                showToast("И на эту")
            }
        )
    }
}
