package com.example.playjuegos;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardsAdapter(var items: ArrayList<Tarjeta>) : RecyclerView.Adapter<CardsAdapter.TarjViewHolder>() {

    lateinit var onClick: (View, Int) -> Unit  //View,Int para que también pase la posición

    //ViewHolder para contener las vistas de cada ítem
    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var texto: TextView = itemView.findViewById(R.id.txt1)

        //Vincula los datos al ítem del RecyclerView
        fun bindTarjeta(t: Tarjeta, onClick: (View, Int) -> Unit) {
            texto.setText(t.cadena)  //Establece el texto en el TextView
            itemView.setOnClickListener {
                onClick(itemView, adapterPosition)  //Pasa la vista y la posición del ítem
            }
        }
    }

    //Infla el layout del ítem
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cards, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    //Actualiza los datos del ítem
    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items[pos]
        viewHolder.bindTarjeta(item, onClick)
    }

    //Retorna la cantidad de ítems en la lista
    override fun getItemCount(): Int {
        return items.size
    }
}
