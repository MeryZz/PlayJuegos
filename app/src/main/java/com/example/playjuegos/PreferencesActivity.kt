package com.example.playjuegos

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PreferencesActivity : AppCompatActivity() {

    private lateinit var radioGroupGames: RadioGroup
    private lateinit var seekBar: SeekBar
    private lateinit var ratingBar: RatingBar
    private lateinit var FAB: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.preferences)

        //Inicializo los componentes
        radioGroupGames = findViewById(R.id.radioGroupGames)
        seekBar = findViewById(R.id.seekBar2)
        ratingBar = findViewById(R.id.ratingBar)
        FAB = findViewById(R.id.floatingActionButton3)


        //Cuando clico el botón flotante
        FAB.setOnClickListener {
            //Para seleccionar un juego
            val selectedId = radioGroupGames.checkedRadioButtonId
            if (selectedId == -1) {
                //Cuando no se selecciona
                Toast.makeText(applicationContext, "No has pulsado ninguna opción", Toast.LENGTH_LONG).show()
            } else {
                //Cuando sí
                val selectedRadioButton: RadioButton = findViewById(selectedId)
                val selectedGame = selectedRadioButton.text.toString()

                //Para obtener la puntuación
                val seekBarValue = seekBar.progress
                val ratingBarValue = ratingBar.rating

                //Mensaje del RatingBar con el Toast
                val mensaje1 = "$selectedGame" + ", puntuación del RatingBar: $ratingBarValue"
                Toast.makeText(applicationContext, mensaje1, Toast.LENGTH_LONG).show()

                //Mensaje del SeekBar con el Toast
                val mensaje2 = "$selectedGame" + ", puntuación del SeekBar: $seekBarValue"
                Toast.makeText(applicationContext, mensaje2, Toast.LENGTH_LONG).show()
            }
        }
        /* ME DICE LOS MENSAJES CON EL TOAST ANTES DE DARLE AL BOTÓN FLOTANTE
        //Listener para el RatingBar
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            val rb = "Puntuación del RatingBar: ${rating.toInt()}"
            Toast.makeText(applicationContext, rb, Toast.LENGTH_SHORT).show()
        }

        //Listener para el SeekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val sb = "Puntuación del SeekBar: $progress"
                Toast.makeText(applicationContext, sb, Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //Para controlar el evento al iniciar el seguimiento
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                //Para controlar el evento al detener el seguimiento
            }
        })
         */
    }
}