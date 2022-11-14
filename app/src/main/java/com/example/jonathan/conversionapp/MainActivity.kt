package com.example.jonathan.conversionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    
    lateinit var convertButton: Button
    lateinit var num2Convert: EditText
    lateinit var dollarsToYen: RadioButton
    lateinit var resultText: TextView
    lateinit var yenToDollars: RadioButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        convertButton = findViewById(R.id.convert_button)
        num2Convert = findViewById(R.id.number_input)

        dollarsToYen = findViewById(R.id.dollars_to_yen)
        yenToDollars = findViewById(R.id.yen_to_dollars)
        var result: String = ""
        
        
        convertButton.setOnClickListener {
            if (checkData()) {
            val yen = DecimalFormat("¥###,###.00")
                val dollar = DecimalFormat("$###,###.00")
            val num = num2Convert.text.toString().toDouble()
            val conversionRate = 140.49
            val convertedNumber: Double?
            
            if(dollarsToYen.isChecked) {
                convertedNumber = num * conversionRate
                result = yen.format(convertedNumber)
            } else if (yenToDollars.isChecked) {
                convertedNumber = num / conversionRate
                result = dollar.format(convertedNumber)
            }
            if (num > 10000)
            Toast.makeText(this@MainActivity, "Your amount is over $10,000", Toast.LENGTH_SHORT).show()
            Intent(this@MainActivity, ResultScreen::class.java).also {
                it.putExtra("RESULT", result)
                startActivity(it)

            }

        }


        }
        
        
    }

    private fun checkData(): Boolean {
        if (num2Convert.text.toString().isEmpty()) {
            num2Convert.error = "Please enter an amount"
            num2Convert.requestFocus()
            return false
        }
        else
            return true
    }
}