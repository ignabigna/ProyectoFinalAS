package com.curso.android.app.practica.proyectof

import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var compareButton: Button
    private lateinit var resultTextView: TextView

    @Before
    fun setUp() {
        // Inicializa la actividad bajo prueba
        scenario = ActivityScenario.launch(MainActivity::class.java)

        // Obtiene las referencias a los elementos de la interfaz de usuario
        scenario.onActivity { activity ->
            editText1 = activity.findViewById(R.id.editText1)
            editText2 = activity.findViewById(R.id.editText2)
            compareButton = activity.findViewById(R.id.compareButton)
            resultTextView = activity.findViewById(R.id.resultTextView)
        }
    }

    @Test
    fun testTextComparison() {
        // Ingresa textos en los campos de texto
        editText1.text = "Texto de prueba".toEditable()
        editText2.text = "Texto de prueba".toEditable()

        // Realiza clic en el botón "Comparar"
        compareButton.performClick()

        // Verifica que el resultado en el TextView sea "Los textos son iguales."
        assertEquals("Los textos son iguales.", resultTextView.text.toString())
    }

    @Test
    fun testTextComparisonDifferent() {
        // Ingresa textos diferentes en los campos de texto
        editText1.text = "Texto 1".toEditable()
        editText2.text = "Texto 2".toEditable()

        // Realiza clic en el botón "Comparar"
        compareButton.performClick()

        // Verifica que el resultado en el TextView sea "Los textos son diferentes."
        assertEquals("Los textos son diferentes.", resultTextView.text.toString())
    }

    // Agrega más pruebas según sea necesario

    @Test
    fun testEmptyFields() {
        // Deja los campos de texto vacíos
        editText1.text = "".toEditable()
        editText2.text = "".toEditable()

        // Realiza clic en el botón "Comparar"
        compareButton.performClick()

        // Verifica que el resultado en el TextView esté vacío
        assertEquals("", resultTextView.text.toString())
    }

    @Test
    fun testOneEmptyField() {
        // Deja uno de los campos de texto vacío
        editText1.text = "Texto 1".toEditable()
        editText2.text = "".toEditable()

        // Realiza clic en el botón "Comparar"
        compareButton.performClick()

        // Verifica que el resultado en el TextView esté vacío
        assertEquals("", resultTextView.text.toString())
    }

    // Editable a String
    private fun String.toEditable(): Editable {
        return Editable.Factory.getInstance().newEditable(this)
    }
}
