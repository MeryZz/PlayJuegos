package com.example.playjuegos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el Toolbar
       /* val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar) */

        //Para abrir el archivo NewPlayer.kt
        val jugador = findViewById(R.id.button1) as Button
        jugador.setOnClickListener { lanzarNewPlayer() }

        //Para abrir el archivo GamesActivity.kt
        val playGamesButton = findViewById<Button>(R.id.button)
        playGamesButton.setOnClickListener { lanzarGamesActivity() }

        //Para abrir el archivo PreferencesActivity.kt
        val preferencesButton = findViewById<Button>(R.id.button2)
        preferencesButton.setOnClickListener { lanzarPreferencesActivity() }

        //Para abrir el archivo AboutActivity.kt
        val aboutButton = findViewById<Button>(R.id.button3)
        aboutButton.setOnClickListener { lanzarAboutActivity() }

    }

    //Método para abrir la actividad NewPlayer.kt
    fun lanzarNewPlayer() {
        val i = Intent(this, NewPlayer::class.java)
        startActivity(i)
    }

    //Método para abrir la actividad GamesActivity.kt
    fun lanzarGamesActivity() {
        val intent = Intent(this, GamesActivity::class.java)
        startActivity(intent)
    }

    //Método para abrir la actividad PreferencesActivity.kt
    fun lanzarPreferencesActivity() {
        val intent = Intent(this, PreferencesActivity::class.java)
        startActivity(intent)
    }

    // Método para abrir la actividad AboutActivity.kt
    fun lanzarAboutActivity() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Búsqueda", Toast.LENGTH_LONG).show();
            return true
        }

        if (id == R.id.action_add) {
            Toast.makeText(this, "Añadir", Toast.LENGTH_LONG).show();
            return true
        }

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Configuración", Toast.LENGTH_LONG).show();
            return true
        }

        if (id == R.id.action_filter) {
            val intent = Intent(this, ChipFilterActivity::class.java)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}