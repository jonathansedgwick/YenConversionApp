package com.example.jonathan.conversionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultScreen : AppCompatActivity() {

    lateinit var backButton: Button
    lateinit var yenText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)

        backButton = findViewById(R.id.backButton)
        yenText = findViewById(R.id.yenText)

        var result = intent.getStringExtra("RESULT")

        yenText.text = result

        backButton.setOnClickListener{
            Intent(this@ResultScreen, MainActivity::class.java).also{
                startActivity(it)
            }

        }


    }
}