package kg.bakai.juice.data.network

interface ApiService {
    suspend fun getSoyMilkPrice(): Int
    suspend fun getColumbiaPrice(): Int
    suspend fun getHotPrice(): Int
    suspend fun getCaramelPrice(): Int
    suspend fun getAlmondPrice(): Int
    suspend fun getMintPrice(): Int
    suspend fun getSugarPrice(): Int
    suspend fun getDrawPrice(): Int
}