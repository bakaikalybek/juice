package kg.bakai.juice.domain.repository

import kg.bakai.juice.domain.model.Coffee

interface Repository {
    suspend fun calculatePrice(coffee: Coffee): Int
}