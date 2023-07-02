package pt.ipt.dama.dama_project2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class Translation : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transfrag)


        radioGroup = findViewById(R.id.language_radio_group)
        saveButton = findViewById(R.id.button_save)

        saveButton.setOnClickListener {
            val selectedLanguage = when (radioGroup.checkedRadioButtonId) {
                R.id.radio_english -> "en"
                R.id.radio_portuguese -> "pt"
                else -> "en"
            }

            setAppLanguage(selectedLanguage)
            // necessary to change language in main_activity
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            recreate()
        }

        // back button

        val backButton = findViewById<ImageView>(R.id.backButton)

        backButton.setOnClickListener { finish() }


    }

    private fun setAppLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val resources = resources
        val config = resources.configuration
        config.setLocale(locale)
        @Suppress("DEPRECATION")
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}
