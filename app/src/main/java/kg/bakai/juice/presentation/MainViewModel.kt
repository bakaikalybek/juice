package kg.bakai.juice.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.bakai.juice.common.Resource
import kg.bakai.juice.domain.model.Coffee
import kg.bakai.juice.domain.model.UiState
import kg.bakai.juice.domain.use_case.CalculateTotalPriceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val calculateUseCase: CalculateTotalPriceUseCase
): ViewModel() {
    private val _state = MutableStateFlow(UiState(sum = 1))
    val state: StateFlow<UiState> = _state

    fun calculateSum(coffee: Coffee) {
        calculateUseCase.invoke(coffee).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UiState(sum = result.data!!)
                }
                is Resource.Error -> {
                    _state.value = UiState(error = result.message ?: "Error occurred")
                }
                is Resource.Loading -> {
                    _state.value = UiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}