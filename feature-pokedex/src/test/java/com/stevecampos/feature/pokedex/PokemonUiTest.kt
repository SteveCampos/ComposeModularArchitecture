package com.stevecampos.feature.pokedex

import com.stevecampos.domain.pokedex.entity.PokemonType
import com.stevecampos.feature.pokedex.entity.PokemonUi
import org.junit.Assert
import org.junit.Test

class PokemonUiTest {

    @Test
    fun `bulbasaur number, should be formatted`() {

        //Arrange
        //Act
        val bulbasaur = PokemonUi(1, "Bulbasaur", listOf(PokemonType.Grass), 0, 0L)
        //Assert
        Assert.assertEquals("#001", bulbasaur.getNumberFormatted())
    }

    @Test
    fun `bulbasaur content description, should print number formatted, name, pokemon types`() {

        //Arrange
        //Act
        val bulbasaur =
            PokemonUi(1, "Bulbasaur", listOf(PokemonType.Grass, PokemonType.Poison), 0, 0L)
        //Assert
        Assert.assertEquals("#001, Bulbasaur, Grass, Poison", bulbasaur.getContentDescription())
    }

    @Test
    fun `bulbasaur content description, should print pokemon types joined`() {

        //Arrange
        //Act
        val bulbasaur =
            PokemonUi(1, "Bulbasaur", listOf(PokemonType.Grass, PokemonType.Poison), 0, 0L)
        //Assert
        Assert.assertEquals("Grass, Poison", bulbasaur.getTypesNames())
    }
}