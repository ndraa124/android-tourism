package com.dicoding.tourismapp.core.domain.usecase

import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.core.domain.model.Tourism
import com.dicoding.tourismapp.core.domain.repository.ITourismRepository
import kotlinx.coroutines.flow.Flow

class TourismInteractor(private val repo: ITourismRepository) : TourismUseCase {
    override fun getAllTourism(): Flow<com.dicoding.tourismapp.core.data.Resource<List<Tourism>>> = repo.getAllTourism()

    override fun getFavoriteTourism(): Flow<List<Tourism>> = repo.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) =
        repo.setFavoriteTourism(tourism, state)
}
