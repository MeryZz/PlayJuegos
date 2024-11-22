package com.example.playjuegos

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner

class NewPlayer : AppCompatActivity() {
    private lateinit var editTextPhone: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_player)

        //Configura el manejo de ventanas
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Para que salga el texto seleccionado del spinner en el editText que quiero
        editTextPhone = findViewById(R.id.editTextPhone)


        //Para el spinner:
        //Defino los datos
        val nums = arrayOf("Teléfono 1", "Teléfono 2", "Teléfono 3", "Teléfono 4", "Teléfono 5")

        //Adaptador
        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, //Estilo del Spinner
            nums
        )
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) //Estilo desplegable

        //Para Vincular el adaptador al Spinner
        val listaNums = findViewById<Spinner>(R.id.spinner)
        listaNums.adapter = adaptador

        //Para mostrar en pantalla el ítem del Spinner seleccionado
        listaNums.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                //Para obtener el texto de la opción seleccionada
                val selectedOption = parent?.getItemAtPosition(position).toString()

                //Para mostrar el texto seleccionado en el EditTextPhone
                editTextPhone.setText(selectedOption)

                //Para mostrar el ítem seleccionado en un Toast
                Toast.makeText(
                    applicationContext,
                    "Seleccionaste: ${parent?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            //No hacemos nada si no hay ninguna selección
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

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

        return super.onOptionsItemSelected(item)
    }

}