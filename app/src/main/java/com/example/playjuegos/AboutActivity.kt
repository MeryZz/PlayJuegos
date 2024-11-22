package com.example.playjuegos;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


public class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)

        //Datos de ejemplo
        val userList = listOf(
            User("María Mata", "2014", R.drawable.image1),
            User("Antonio Sanz", "1890", R.drawable.image2),
            User("Carlos", "967", R.drawable.image3),
            User("Berta", "945", R.drawable.image4),
            User("Héctor Campos", "879", R.drawable.image5),
            User("Ismael", "678", R.drawable.image6),
            User("Marcos", "555", R.drawable.image7),
            User("Iván Hostin", "1109", R.drawable.image8),

        )

        //Configuración del RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewAbout)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(userList)
    }

}
