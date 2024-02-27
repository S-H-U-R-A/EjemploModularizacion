package com.sergio.rodriguez.examplemodules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergio.rodriguez.domain.Location
import com.sergio.rodriguez.domain.usecases.GetLocationNetworkUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    //private var getLocationNetworkUseCase: GetLocationNetworkUseCase //Inyección de dependencias
): ViewModel() {

    private var _uiState: MutableStateFlow<UiStateMain> = MutableStateFlow(UiStateMain())
    val uistate: StateFlow<UiStateMain> = _uiState.asStateFlow()

    fun getLocationNetwork() = viewModelScope.launch {
        val location: Location =  GetLocationNetworkUseCase().invoke()

        _uiState.update { uiState: UiStateMain ->

            val newList = uiState.locations
            newList.add(location)

            uiState.copy(
                locations = newList
            )
        }
    }
}


data class UiStateMain(
    var locations : MutableList<Location> = mutableListOf()
)