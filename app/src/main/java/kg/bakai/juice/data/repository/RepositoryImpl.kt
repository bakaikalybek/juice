package kg.bakai.juice.data.repository

import kg.bakai.juice.data.network.ApiService
import kg.bakai.juice.domain.model.Coffee
import kg.bakai.juice.domain.repository.Repository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: ApiService
): Repository {
    override suspend fun calculatePrice(coffee: Coffee): Int {
        val list = mutableListOf<Deferred<Int>>()
        coroutineScope {
            if (coffee.isSoyMilkAdded) {
                list.add(async { api.getSoyMilkPrice() })
            }
            if (coffee.isAlmondAdded) {
                list.add(async { api.getAlmondPrice() })
            }
            if (coffee.isCaramelAdded) {
                list.add(async { api.getCaramelPrice() })
            }
            if (coffee.isColumbia) {
                list.add(async { api.getColumbiaPrice() })
            }
            if (coffee.isDrawAdded) {
                list.add(async { api.getDrawPrice() })
            }
            if (coffee.isHot) {
                list.add(async { api.getHotPrice() })
            }
            if (coffee.isMintAdded) {
                list.add(async { api.getMintPrice() })
            }
            if (coffee.isSugarAdded) {
                list.add(async { api.getSugarPrice() })
            }
        }
        list.awaitAll().forEach {
            coffee.price += it
        }
        return coffee.price
    }
}