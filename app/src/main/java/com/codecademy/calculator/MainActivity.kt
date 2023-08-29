package com.codecademy.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var one: Button = findViewById(R.id.one)
        var two: Button = findViewById(R.id.two)
        var add: Button = findViewById(R.id.add)
        var equals: Button = findViewById(R.id.equals)
        var input: TextView  = findViewById(R.id.input)

        one.setOnClickListener {
            var oneInp = one.text.toString().toInt()

            input.text = o

        }
    }


}