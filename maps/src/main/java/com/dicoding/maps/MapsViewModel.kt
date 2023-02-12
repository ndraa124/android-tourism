package com.dicoding.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase

class MapsViewModel(useCase: TourismUseCase) : ViewModel() {
    val tourism = useCase.getAllTourism().asLiveData()
}
