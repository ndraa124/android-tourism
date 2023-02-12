package com.dicoding.tourismapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.domain.usecase.TourismUseCase

class HomeViewModel(useCase: TourismUseCase) : ViewModel() {

    val tourism = useCase.getAllTourism().asLiveData()
}
