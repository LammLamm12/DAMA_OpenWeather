package pt.ipt.dama.dama_project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class CityFinder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_finder)
        val editText = findViewById<EditText>(R.id.searchCity)
        val backButton = findViewById<ImageView>(R.id.backButton)

        backButton.setOnClickListener { finish() }

        editText.setOnEditorActionListener { _, _, _ ->
            val newCity = editText.text.toString()
            val intent = Intent(this@CityFinder, MainActivity::class.java)
            intent.putExtra("City", newCity)
            startActivity(intent)


            false
        }
    }
}