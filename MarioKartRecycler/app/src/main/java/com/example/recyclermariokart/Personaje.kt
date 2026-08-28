package com.example.recyclermariokart

import androidx.annotation.DrawableRes

data class Personaje(
    val nombre: String,
    @DrawableRes val imagen: Int,
    val velocidad: Int,
    val vida: Int,
    val aceleracion: Int
) {
    companion object {
        fun listaDePersonajes(): List<Personaje> = listOf(
            Personaje("Mario", R.drawable.mario, 4, 4, 3),
            Personaje("Luigi", R.drawable.luigi, 4, 4, 3),
            Personaje("Peach", R.drawable.peach, 4, 3, 4),
            Personaje("Yoshi", R.drawable.yoshi, 4, 3, 4),
            Personaje("Toad", R.drawable.toad, 3, 2, 5),
            Personaje("Donkey Kong", R.drawable.donkey_kong, 5, 5, 2),
            Personaje("Bowser", R.drawable.bowser, 5, 6, 2)
        )
    }
}
