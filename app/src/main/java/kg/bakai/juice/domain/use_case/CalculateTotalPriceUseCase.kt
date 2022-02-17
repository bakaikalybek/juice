package kg.bakai.juice.domain.use_case

import kg.bakai.juice.common.Resource
import kg.bakai.juice.domain.model.Coffee
import kg.bakai.juice.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class CalculateTotalPriceUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(coffee: Coffee): Flow<Resource<Int>> = flow {
        try {
            emit(Resource.Loading())
            val sum = repository.calculatePrice(coffee)
            emit(Resource.Success(sum))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error occurred"))
        }
    }
}