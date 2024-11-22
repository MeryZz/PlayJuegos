package com.example.playjuegos;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//Modelo de datos para un usuario
data class User(val name: String, val details: String, val imageResId: Int)

//Adaptador personalizado para RecyclerView
class UserAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    //ViewHolder que representa cada ítem
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewUser)
        val userName: TextView = view.findViewById(R.id.textViewUserName)
        val userDetails: TextView = view.findViewById(R.id.textViewUserDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //Inflar el layout para cada ítem del RecyclerView
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        //Obtener el usuario en la posición indicada
        val user = userList[position]

        //Establecer la imagen, nombre y detalles en los elementos del layout
        holder.imageView.setImageResource(user.imageResId)
        holder.userName.text = user.name
        holder.userDetails.text = user.details

        //Manejo de clics en el ítem
        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "${user.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    //Devolver el número total de ítems en la lista
    override fun getItemCount(): Int = userList.size
}

