package com.curso.android.app.practica.proyectof

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @Test
    fun testTextComparison() {
        // Ingresa textos en los campos de texto
        Espresso.onView(ViewMatchers.withId(R.id.editText1)).perform(ViewActions.typeText("Texto de prueba"))
        Espresso.onView(ViewMatchers.withId(R.id.editText2)).perform(ViewActions.typeText("Texto de prueba"))

        // Oculta el teclado virtual
        Espresso.closeSoftKeyboard()

        // Realiza clic en el botón "Comparar"
        Espresso.onView(ViewMatchers.withId(R.id.compareButton)).perform(ViewActions.click())

        // Verifica que el resultado en el TextView sea "Los textos son iguales."
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Los textos son iguales.")))
    }

}
