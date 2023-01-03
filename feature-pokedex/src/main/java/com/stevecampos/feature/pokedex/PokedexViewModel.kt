package com.stevecampos.feature.pokedex

import androidx.lifecycle.ViewModel
import com.stevecampos.core.common.ErrorEntity
import com.stevecampos.core.common.executeTask
import com.stevecampos.domain.entity.Pokemon
import com.stevecampos.domain.usecase.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val _pokedexScreenState =
        MutableStateFlow<PokedexScreenState>(PokedexScreenState.Loading)
    val pokedexScreenState: StateFlow<PokedexScreenState> get() = _pokedexScreenState

    init {
        getPokemons()
    }

    private fun getPokemons() {
        executeTask(
            onSuccess = ::onGetPokemonsSuccess,
            onFailure = ::onGetPokemonsFailure,
        ) {
            getPokemonsUseCase.getPokemons()
        }
    }

    private fun onGetPokemonsFailure(errorEntity: ErrorEntity) {
        _pokedexScreenState.value = PokedexScreenState.Error(::getPokemons)
    }

    private fun onGetPokemonsSuccess(pokemons: List<Pokemon>) {
        _pokedexScreenState.value = PokedexScreenState.Success(pokemons)
    }

}