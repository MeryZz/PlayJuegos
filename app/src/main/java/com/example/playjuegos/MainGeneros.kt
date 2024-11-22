package com.example.playjuegos;

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainGeneros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generos)

        //Para crear la lista de géneros
        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta(R.string.accion))
        items.add(Tarjeta(R.string.aventura))
        items.add(Tarjeta(R.string.deportes))
        items.add(Tarjeta(R.string.disparos))
        items.add(Tarjeta(R.string.estrategia))
        items.add(Tarjeta(R.string.lucha))
        items.add(Tarjeta(R.string.musical))
        items.add(Tarjeta(R.string.rol))
        items.add(Tarjeta(R.string.simulacion))

        //Configuración del RecyclerView
        val recView = findViewById<RecyclerView>(R.id.recyclerView)
        recView.setHasFixedSize(true)
        recView.layoutManager = LinearLayoutManager(this)

        //Para crear el adaptador y configurarlo en RecyclerView
        val adaptador = CardsAdapter(items)
        recView.adapter = adaptador

        //Configurar el comportamiento del clic
        adaptador.onClick = { view, position ->
            val genreName = resources.getString(items[position].cadena)  //Obtener el nombre del género
            Toast.makeText(this@MainGeneros, genreName, Toast.LENGTH_SHORT).show()  //Mostrar el Toast
        }
    }
}
