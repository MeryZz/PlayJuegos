package com.example.playjuegos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.ChipGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.chip.Chip

class ChipFilterActivity: AppCompatActivity() {

    private lateinit var chipGroup: ChipGroup
    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chip_filter) //Para inflar el chip

        chipGroup = findViewById(R.id.chip_group)
        bottomAppBar = findViewById(R.id.bottom_app_bar)
        textView = findViewById(R.id.textView1)



        //Para ver los cambios del ChipGroup
        chipGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId != -1) { //Para seleccionar un chip de los de dentro del gruop
                val checkedChip = group.findViewById<com.google.android.material.chip.Chip>(checkedId)
                textView.text = "${checkedChip.text}"
            }
        }

        //Para los chips externos al grupo
        val chipAccion = findViewById<Chip>(R.id.chip_accion)
        chipAccion.setOnClickListener {
            Toast.makeText(this, "${chipAccion.text}", Toast.LENGTH_SHORT).show()
        }

        val chipAventura = findViewById<Chip>(R.id.chip_aventura)
        chipAventura.setOnClickListener {
            Toast.makeText(this, "${chipAventura.text}", Toast.LENGTH_SHORT).show()
        }

        val chipDeportes = findViewById<Chip>(R.id.chip_deportes)
        chipDeportes.setOnClickListener {
            Toast.makeText(this, "${chipDeportes.text}", Toast.LENGTH_SHORT).show()
        }

        val chipDisparos = findViewById<Chip>(R.id.chip_disparos)
        chipDisparos.setOnClickListener {
            Toast.makeText(this, "${chipDisparos.text}", Toast.LENGTH_SHORT).show()
        }

        val chipEstrategia = findViewById<Chip>(R.id.chip_estrategia)
        chipEstrategia.setOnClickListener {
            Toast.makeText(this, "${chipEstrategia.text}", Toast.LENGTH_SHORT).show()
        }

        val chipLucha = findViewById<Chip>(R.id.chip_lucha)
        chipLucha.setOnClickListener {
            Toast.makeText(this, "${chipLucha.text}", Toast.LENGTH_SHORT).show()
        }

        val chipMusical = findViewById<Chip>(R.id.chip_musical)
        chipMusical.setOnClickListener {
            Toast.makeText(this, "${chipMusical.text}", Toast.LENGTH_SHORT).show()
        }

        val chipRol = findViewById<Chip>(R.id.chip_rol)
        chipRol.setOnClickListener {
            Toast.makeText(this, "${chipRol.text}", Toast.LENGTH_SHORT).show()
        }

        val chipSimulacion = findViewById<Chip>(R.id.chip_simulacion)
        chipSimulacion.setOnClickListener {
            Toast.makeText(this, "${chipSimulacion.text}", Toast.LENGTH_SHORT).show()
        }

        //Para configurar el FAB
        val fab = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            Toast.makeText(this, "El botón se desplaza hacia arriba", Toast.LENGTH_SHORT).show()
        }

    }

}