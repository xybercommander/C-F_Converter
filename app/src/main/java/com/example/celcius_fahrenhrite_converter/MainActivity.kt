package com.example.celcius_fahrenhrite_converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userInput: EditText = findViewById<EditText>(R.id.userinput)
        var radioGroup: RadioGroup = findViewById<RadioGroup>(R.id.radioGroupfortemp)
        var ans: TextView = findViewById<TextView>(R.id.textView2)
        var calc: Button = findViewById<Button>(R.id.calc_button)
        var res: Button = findViewById<Button>(R.id.res_button)

        ans.text =""

        userInput.setOnClickListener {
            userInput.text.clear()
        }

        //Main function of the app
        calc.setOnClickListener {
            var value = radioGroup.checkedRadioButtonId
            var rb = findViewById<RadioButton>(value)
            var a = userInput.text.toString()
            var temp = a.toFloat()

            if(rb.text == "°C to °F") { // For converting c to f
                var result = (1.80 * temp) + 32
                var output: String = result.toString()

                ans.text = "${output}°F"

            } else { // For converting f to c
                var result = (temp - 32) / 1.80
                var output: String = result.toString()

                ans.text = "${output}°C"
            }

        }

        //To reset the app
        res.setOnClickListener {
            userInput.text.clear()

            ans.text = ""

            if(c2f.isChecked() == true) {
                c2f.isChecked = false 
            }else{
                f2c.isChecked = false
            }

        }

    }
}
