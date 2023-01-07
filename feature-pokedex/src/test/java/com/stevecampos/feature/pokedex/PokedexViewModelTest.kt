@file:OptIn(ExperimentalCoroutinesApi::class)

package com.stevecampos.feature.pokedex

import com.stevecampos.core.common.ErrorEntity
import com.stevecampos.core.common.Result
import com.stevecampos.domain.pokedex.entity.Pokemon
import com.stevecampos.domain.pokedex.entity.PokemonType
import com.stevecampos.domain.pokedex.usecase.GetPokemonsUseCase
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class PokedexViewModelTest {

    private val getPokemonsUseCase = mock(GetPokemonsUseCase::class.java)
    private lateinit var pokedexViewModel: PokedexViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when instantiated, screen state should be loading`() = runBlocking {
        //Arrange
        //Act
        pokedexViewModel = PokedexViewModel(getPokemonsUseCase, Dispatchers.Unconfined)
        //Assert
        Assert.assertEquals(
            PokedexScreenState.Loading::class.java.simpleName,
            pokedexViewModel.pokedexScreenState.value.javaClass.simpleName
        )

    }

    @Test
    fun `when getPokemon returns ResultSuccess, then screen state should be Success`() =
        runBlocking {
            //Arrange

            whenever(getPokemonsUseCase.getPokemons()).thenReturn(
                Result.Success(
                    listOf(
                        Pokemon(
                            1,
                            "Bulbasaur",
                            listOf(PokemonType.Grass, PokemonType.Poison),
                            "/bulbasaur"
                        )
                    )
                )
            )
            //Act
            pokedexViewModel = PokedexViewModel(getPokemonsUseCase, Dispatchers.Unconfined)
            pokedexViewModel.getPokemons()
            Assert.assertEquals(
                PokedexScreenState.Success::class.java.simpleName,
                pokedexViewModel.pokedexScreenState.value.javaClass.simpleName

            )
        }

    @Test
    fun `when getPokemon returns ResultSuccess then screen state should be Loading`() =
        runBlocking {
            //Arrange

            whenever(getPokemonsUseCase.getPokemons()).thenReturn(
                Result.Error(
                    ErrorEntity.Unknown
                )
            )
            //Act
            pokedexViewModel = PokedexViewModel(getPokemonsUseCase, Dispatchers.Unconfined)
            pokedexViewModel.getPokemons()
            Assert.assertEquals(
                PokedexScreenState.Error::class.java.simpleName,
                pokedexViewModel.pokedexScreenState.value.javaClass.simpleName

            )
        }

}