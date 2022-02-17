package kg.bakai.juice.domain.model

data class Coffee(
    val isSoyMilkAdded: Boolean = false,
    val isColumbia: Boolean = false,
    val isHot: Boolean = false,
    val isCaramelAdded: Boolean = false,
    val isAlmondAdded: Boolean = false,
    val isMintAdded: Boolean = false,
    val isSugarAdded: Boolean = false,
    val isDrawAdded: Boolean = false,
    //Цена кофе без добавок
    var price: Int = 1
)
