package com.stevecampos.infrastructure.pokedex.dependencyinjection

import com.stevecampos.domain.pokedex.repository.PokedexRepository
import com.stevecampos.domain.pokedex.usecase.GetPokemonsUseCase
import com.stevecampos.infrastructure.pokedex.mapper.PokemonMapper
import com.stevecampos.infrastructure.pokedex.repository.remote.PokedexApiService
import com.stevecampos.infrastructure.pokedex.repository.remote.PokedexRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokedexModule {


    @Provides
    @Singleton
    fun providePokemonMapper(): PokemonMapper = PokemonMapper()

    @Provides
    @Singleton
    fun providePokemonApiService(retrofit: Retrofit): PokedexApiService =
        retrofit.create(PokedexApiService::class.java)

    @Provides
    @Singleton
    fun providePokedexRemoteDataSource(
        apiService: PokedexApiService,
        pokemonMapper: PokemonMapper
    ): PokedexRepository =
        PokedexRemote(apiService, pokemonMapper)

    /*

    @Provides
    @Singleton
    fun providePokedexRepository(): PokedexRepository = PokedexRepositoryImpl()*/

    @Provides
    @Singleton
    fun provideGetPokemonUseCase(pokedexRepository: PokedexRepository): GetPokemonsUseCase =
        GetPokemonsUseCase(pokedexRepository)
}