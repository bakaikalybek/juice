package kg.bakai.juice.data.network

import kotlinx.coroutines.delay

class ApiServiceImpl: ApiService {
    override suspend fun getSoyMilkPrice(): Int {
        //имитируем запрос на сервер
        delay(1000)
        return 3
    }

    override suspend fun getColumbiaPrice(): Int {
        //имитируем запрос на сервер
        delay(1000)
        return 2
    }

    override suspend fun getHotPrice(): Int {
        //имитируем запрос на сервер
        delay(1000)
        return 1
    }

    override suspend fun getCaramelPrice(): Int {
        //имитируем запрос на сервер
        delay(1000)
        return 2
    }

    override suspend fun getAlmondPrice(): Int {
        //имитируем запрос на сервер
        delay(1000)
        return 1
    }

    override suspend fun getMintPrice(): Int {
        //имитируем запрос на сервер
        delay(1000)
        return 1
    }

    override suspend fun getSugarPrice(): Int {
        //имитируем запрос на сервер
        delay(1000)
        return 1
    }

    override suspend fun getDrawPrice(): Int {
        //имитируем запрос на сервер
        delay(1000)
        return 1
    }
}