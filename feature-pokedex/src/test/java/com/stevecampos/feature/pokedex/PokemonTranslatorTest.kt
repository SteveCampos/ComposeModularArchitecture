package com.stevecampos.feature.pokedex

import com.stevecampos.domain.pokedex.entity.Pokemon
import com.stevecampos.domain.pokedex.entity.PokemonType
import com.stevecampos.feature.pokedex.entity.translator.PokemonTranslator
import org.junit.Assert
import org.junit.Test

class PokemonTranslatorTest {

    @Test
    fun `when bulbasaur pokemon translated should return bulbasaur drawable`() {
        //Arrange
        val bulbasaur = Pokemon(1, "Bulbasaur", listOf(PokemonType.Grass), "/bulbasaur")
        //Act
        val pokemonTranslator = PokemonTranslator()
        val pokemonUi = pokemonTranslator.domainToUi(bulbasaur)
        // Assert
        Assert.assertEquals(R.drawable.bulbasaur_3x, pokemonUi.pokemonDrawableResourceId)
    }
    @Test
    fun `when bulbasaur pokemon translated should return background color value`() {
        //Arrange
        val bulbasaur = Pokemon(1, "Bulbasaur", listOf(PokemonType.Grass), "/bulbasaur")
        //Act
        val pokemonTranslator = PokemonTranslator()
        val pokemonUi = pokemonTranslator.domainToUi(bulbasaur)
        // Assert
        Assert.assertEquals(0xFF48D0B0, pokemonUi.backgroundColorValue)
    }
}