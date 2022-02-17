package kg.bakai.juice.domain.model

data class UiState(
    val isLoading: Boolean = false,
    val sum: Int = 0,
    val error: String = ""
)
