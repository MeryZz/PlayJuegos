package com.example.playjuegos

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GamesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.games)

        //Para identificar los CheckBox
        val checkBoxAngryBirds = findViewById<CheckBox>(R.id.checkBoxAB)
        val checkBoxDragonFly = findViewById<CheckBox>(R.id.checkBoxDF)
        val checkBoxHillClimbing = findViewById<CheckBox>(R.id.checkBoxHCR)
        val checkBoxRadiantDefense = findViewById<CheckBox>(R.id.checkBoxRD)
        val checkBoxPocketSoccer = findViewById<CheckBox>(R.id.checkBoxPS)
        val checkBoxNinjaJump = findViewById<CheckBox>(R.id.checkBoxNJ)
        val checkBoxAirControl = findViewById<CheckBox>(R.id.checkBoxAC)

        //Pra identificar el botón FAB
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        //Listener para el FAB y poder interactuar
        fab.setOnClickListener {
            //Para crear una lista y almacenar las opciones seleccionadas
            val selectedGames = ArrayList<String>()

            //Para mirar qué CheckBox están seleccionados y añadirlos a la lista
            if (checkBoxAngryBirds.isChecked) {
                selectedGames.add("Angry Birds")
            }
            if (checkBoxDragonFly.isChecked) {
                selectedGames.add("Dragon Fly")
            }
            if (checkBoxHillClimbing.isChecked) {
                selectedGames.add("Hill Climbing Racing")
            }
            if (checkBoxRadiantDefense.isChecked) {
                selectedGames.add("Radiant Defense")
            }
            if (checkBoxPocketSoccer.isChecked) {
                selectedGames.add("Pocket Soccer")
            }
            if (checkBoxNinjaJump.isChecked) {
                selectedGames.add("Ninja Jump")
            }
            if (checkBoxAirControl.isChecked) {
                selectedGames.add("Air Control")
            }

            //Toast con las opciones seleccionadas
            if (selectedGames.isNotEmpty()) {
                val mensaje1 = "Has elegido: " + selectedGames.joinToString(", ")
                Toast.makeText(this, mensaje1, Toast.LENGTH_LONG).show()
            } else {
                //Toast si no hay ninguna seleccionada
                Toast.makeText(this, "No has elegido ninguna opción", Toast.LENGTH_LONG).show()
            }
        }
    }
}
