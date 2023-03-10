package com.stevecampos.infrastructure.pokedex.repository

import com.stevecampos.core.common.ErrorEntity
import com.stevecampos.domain.pokedex.entity.Pokemon
import com.stevecampos.domain.pokedex.entity.PokemonType
import com.stevecampos.domain.pokedex.repository.PokedexRepository
import kotlin.random.Random
import com.stevecampos.core.common.Result
import kotlinx.coroutines.delay
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor() : PokedexRepository {
    override suspend fun getPokemons(): Result<List<Pokemon>> {
        delay(1500L)
        return if (Random.nextBoolean()) {
            //return if (true) {
            val pokemons = listOf<Pokemon>(
                Pokemon(
                    1,
                    "Bulbasaur",
                    listOf(PokemonType.Grass, PokemonType.Poison),
                    "/bulbasaur"
                ),
                Pokemon(2, "Ivysaur", listOf(PokemonType.Grass, PokemonType.Poison), "/ivysaur"),
                Pokemon(3, "Venusaur", listOf(PokemonType.Grass, PokemonType.Poison), "/venusaur"),
                Pokemon(4, "Charmander", listOf(PokemonType.Fire), "/charmander"),
                Pokemon(5, "Charmeleon", listOf(PokemonType.Fire), "/charmeleon"),
                Pokemon(6, "Charizard", listOf(PokemonType.Fire, PokemonType.Flying), "/charizard"),
                Pokemon(7, "Squirtle", listOf(PokemonType.Water), "/squirtle"),
                Pokemon(8, "Wartortle", listOf(PokemonType.Water), "/wartortle"),
                Pokemon(9, "Blastoise", listOf(PokemonType.Water), "/blastoise"),
                Pokemon(10, "Pikachu", listOf(PokemonType.Electric), "/pikachu"),
            )
            Result.Success(pokemons)
        } else {
            Result.Error(ErrorEntity.ApiError.ServiceUnavailable)
        }
    }
}