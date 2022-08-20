package com.eganin.jetpack.thebest.composetest.screens.product_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eganin.jetpack.thebest.composetest.screens.product_details.views.CharacteristicModel

class ProductViewModel : ViewModel() {

    private val _sku: MutableLiveData<String> = MutableLiveData("Артикул 90809890")
    val sku: LiveData<String> = _sku

    private val _title: MutableLiveData<String> = MutableLiveData("Дрель Dexter, 100, Li-on, 2 Ач")
    val title: LiveData<String> = _title

    private val _itemsInCart: MutableLiveData<Int> = MutableLiveData(0)
    val itemsInCart: LiveData<Int> = _itemsInCart

    private val _availableCount: MutableLiveData<Int> = MutableLiveData(9999)
    val availableCount: LiveData<Int> = _availableCount

    private val _pickupStoresCount: MutableLiveData<Int> = MutableLiveData(10)
    val pickupStoresCount: LiveData<Int> = _pickupStoresCount

    private val _imageHeaderView: MutableLiveData<String> =
        MutableLiveData("https://cdnmedia.220-volt.ru/content/products/13/13321/images/original/n1200x800_q80/1.jpeg")

    val imageHeaderView : LiveData<String> = _imageHeaderView

    private val _characteristics: MutableLiveData<List<CharacteristicModel>> =
        MutableLiveData(
            listOf(
                CharacteristicModel(title = "Толщина (мм)", value = "12.5"),
                CharacteristicModel(title = "Вес, кг", value = "8,8"),
                CharacteristicModel(title = "Марка", value = "KNAUF"),
                CharacteristicModel(title = "Страна производитель", value = "Россия"),
            )
        )

    val characteristics: LiveData<List<CharacteristicModel>> = _characteristics

    fun addToCart() = _itemsInCart.postValue(1)

}