package kg.bakai.juice.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kg.bakai.juice.data.network.ApiService
import kg.bakai.juice.data.network.ApiServiceImpl
import kg.bakai.juice.data.repository.RepositoryImpl
import kg.bakai.juice.domain.repository.Repository
import kg.bakai.juice.domain.use_case.CalculateTotalPriceUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ApiServiceImpl()
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService): Repository {
        return RepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: Repository): CalculateTotalPriceUseCase {
        return CalculateTotalPriceUseCase(repository)
    }
}