package com.curso.android.app.practica.proyectof

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var compareButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        compareButton = findViewById(R.id.compareButton)
        resultTextView = findViewById(R.id.resultTextView)

        compareButton.setOnClickListener {

            comparTextos()
        }
    }

    private fun comparTextos() {
        val texto1 = editText1.text.toString()
        val texto2 = editText2.text.toString()

        val result = if (texto1 == texto2) {
            "Los textos son iguales."
        } else {
            "Los textos son diferentes."
        }

        resultTextView.text = result
    }
}
