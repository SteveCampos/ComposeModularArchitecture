package com.stevecampos.feature.pokedex.entity

import androidx.annotation.DrawableRes
import com.stevecampos.domain.pokedex.entity.PokemonType

data class PokemonUi(
    private val number: Int,
    val name: String,
    val pokemonTypes: List<PokemonType>,
    @DrawableRes val pokemonDrawableResourceId: Int,
    val backgroundColorValue: Long
) {
    fun getNumberFormatted(): String =
        "#${number.toString().padStart(length = 3, padChar = '0')}"

    private fun getTypesNames(): String = pokemonTypes.joinToString { it.javaClass.simpleName }

    fun getContentDescription() = "${getNumberFormatted()}, $name, ${getTypesNames()}"

}