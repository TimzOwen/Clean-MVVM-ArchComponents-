package com.k0d4black.theforce.di.modules.search

import com.k0d4black.theforce.data.api.StarWarsApiService
import com.k0d4black.theforce.data.repository.CharacterSearchRepository
import com.k0d4black.theforce.data.source.CharacterSearchDataSource
import com.k0d4black.theforce.domain.repository.ICharacterSearchRepository
import com.k0d4black.theforce.domain.usecases.CharacterSearchUseCase
import com.k0d4black.theforce.features.character_search.CharacterSearchViewModel
import com.k0d4black.theforce.features.character_search.SearchQueryListener
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class CharacterSearchModule {

    @Provides
    fun provideSearchQueryListener(characterSearchViewModel: CharacterSearchViewModel): SearchQueryListener {
        return SearchQueryListener(characterSearchViewModel)
    }

    @Provides
    fun provideCharacterSearchUseCase(
        characterSearchRepository: CharacterSearchRepository
    ): CharacterSearchUseCase = CharacterSearchUseCase(characterSearchRepository)

    @Provides
    fun provideCharacterSearchDataSource(apiService: StarWarsApiService): CharacterSearchDataSource =
        CharacterSearchDataSource(apiService)

}


