package ru.fefu.activitytracker.views.registration

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityRegistrationScreenBinding

class RegistrationActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setOnClickListener {
            finish()
        }
    }

}