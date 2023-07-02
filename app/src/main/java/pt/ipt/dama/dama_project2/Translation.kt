package pt.ipt.dama.dama_project2

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class Translation : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transfrag)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        radioGroup = findViewById(R.id.language_radio_group)
        saveButton = findViewById(R.id.button_save)

        saveButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            val selectedLanguage = when (selectedRadioButtonId) {
                R.id.radio_english -> "en"
                R.id.radio_portuguese -> "pt"
                else -> "en"
            }

            setAppLanguage(selectedLanguage)
            recreate()
        }
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
