package com.example.recyclermariokart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class PersonajeAdapter(
    private val listaPersonajes: List<Personaje>
) : RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder>() {

    private val coloresAcento = intArrayOf(
        R.color.mk_pink,
        R.color.mk_yellow,
        R.color.mk_cyan,
        R.color.mk_pink_dark
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_personaje, parent, false)
        return PersonajeViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        holder.bind(listaPersonajes[position], position)
    }

    override fun getItemCount(): Int = listaPersonajes.size

    class PersonajeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgPersonaje: ShapeableImageView = itemView.findViewById(R.id.imgPersonaje)
        private val txtNombre: TextView = itemView.findViewById(R.id.txtNombre)
        private val txtVelocidad: TextView = itemView.findViewById(R.id.txtVelocidad)
        private val txtVida: TextView = itemView.findViewById(R.id.txtVida)
        private val txtAceleracion: TextView = itemView.findViewById(R.id.txtAceleracion)

        fun bind(personaje: Personaje, position: Int) {
            imgPersonaje.setImageResource(personaje.imagen)
            imgPersonaje.strokeColor = ContextCompat.getColor(
                itemView.context,
                adapterAcento(position)
            )
            txtNombre.text = personaje.nombre
            txtVelocidad.text = "Vel ${personaje.velocidad}/10"
            txtVida.text = "Vida ${personaje.vida}/10"
            txtAceleracion.text = "Ace ${personaje.aceleracion}/10"
        }

        private fun adapterAcento(position: Int): Int {
            return when (position % 4) {
                0 -> R.color.mk_pink
                1 -> R.color.mk_yellow
                2 -> R.color.mk_cyan
                else -> R.color.mk_pink_dark
            }
        }
    }
}
