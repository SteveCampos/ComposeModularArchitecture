package com.stevecampos.domain.pokedex.usecase

import com.stevecampos.domain.pokedex.repository.PokedexRepository

class GetPokemonsUseCase(
    private val pokedexRepository: PokedexRepository
) {
    suspend fun getPokemons() =
        pokedexRepository.getPokemons()
}