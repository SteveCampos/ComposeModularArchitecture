package com.stevecampos.domain.usecase

import com.stevecampos.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {
    suspend fun getPokemons() = pokemonRepository.getPokemons()
}