package com.stevecampos.domain.pokedex.usecase

import com.stevecampos.domain.pokedex.repository.PokedexRepository
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val pokedexRepository: PokedexRepository
) {
    suspend fun getPokemons() =
        pokedexRepository.getPokemons()
}