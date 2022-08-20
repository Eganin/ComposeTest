package com.eganin.jetpack.thebest.composetest.screens.product_details

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eganin.jetpack.thebest.composetest.screens.product_details.views.Caption
import com.eganin.jetpack.thebest.composetest.screens.product_details.views.Subtitle5
import com.eganin.jetpack.thebest.composetest.ui.theme.*

@Preview
@Composable
fun ComposablePreview() {
    ComposeTheme {
        ProductScreen()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductScreen(productViewModel: ProductViewModel = viewModel()) {
    val sku by productViewModel.sku.observeAsState()
    val title by productViewModel.title.observeAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            stickyHeader { Toolbar() }
            item { ImageHeader() }
            item {
                Text(
                    text = sku.orEmpty(),
                    modifier = Modifier.padding(top = 24.dp, start = 16.dp),
                    style = TextStyle(color = BrownGreyColor),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
            item {
                Text(
                    text = title.orEmpty(),
                    modifier = Modifier.padding(top = 4.dp, start = 16.dp, end = 24.dp),
                    style = TextStyle(
                        color = Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                    )
                )
            }
            item { RatingRow() }
            item { PriceView(productViewModel = productViewModel) }
            item { CountView(productViewModel = productViewModel) }
            item { HeaderView(height = 68.dp, title = "Способы получения") }
            item { DeliveryPickupView(productViewModel = productViewModel) }
            item { HeaderView(height = 68.dp, title = "Характеристики") }
            item { CharacteristicsView(productViewModel = productViewModel) }
        })
}

@Composable
fun DeliveryPickupView(productViewModel: ProductViewModel) {

    val pickupStoresCount by productViewModel.pickupStoresCount.observeAsState(initial = 0)

    Row(Modifier.padding(start = 16.dp, end = 24.dp, top = 22.dp, bottom = 22.dp)) {
        Box(
            Modifier
                .background(color = BrownGreyColor)
                .size(24.dp)
        )
        Column(modifier = Modifier.padding(start = 24.dp)) {
            Subtitle5(text = "Доставка Завтра, 25 июля")
            Caption(text = "На складе 12 шт", modifier = Modifier.padding(top = 2.dp))

            if (pickupStoresCount > 0) {
                Subtitle5(text = "Самовызов Сегодня", modifier = Modifier.padding(top = 16.dp))
                Caption(
                    text = "Доступно в $pickupStoresCount магазинах",
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }
    }
}

@Composable
fun CharacteristicsView(productViewModel: ProductViewModel) {

    val characteristics by productViewModel.characteristics.observeAsState(emptyList())

    Column(modifier = Modifier.fillMaxWidth()) {
        characteristics.map { CharacteristicCell(model = it) }
    }
}

@Composable
fun CharacteristicCell(model: CharacteristicModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 24.dp)
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = model.title,
            modifier = Modifier.weight(0.6f),
            style = TextStyle(color = BrownGreyColor)
        )
        Text(
            text = model.value, modifier = Modifier
                .weight(0.6f)
                .padding(8.dp),
            style = TextStyle(color = Black)
        )
    }
    Divider(color = VeryLightPink)
}

@Composable
fun CountView(productViewModel: ProductViewModel) {

    val availableCount by productViewModel.availableCount.observeAsState()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(78.dp)
            .padding(start = 16.dp, end = 24.dp)
    ) {
        Box(
            Modifier
                .background(color = BrownGreyColor)
                .size(24.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 24.dp, end = 24.dp)
        ) {
            Text(text = "Рассчитать кол-во", style = TextStyle(color = Black))
            Text(
                text = "В наличии $availableCount",
                style = TextStyle(color = BrownGreyColor, fontSize = 12.sp)
            )
        }

        Box(
            Modifier
                .background(color = BrownGreyColor)
                .size(24.dp)
        )
    }
}

@Composable
fun HeaderView(height: Dp, title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = height)
            .background(color = WhiteTwo)
            .padding(start = 16.dp, bottom = 16.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Text(
            text = title,
            style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 16.sp, color = Black)
        )
    }
}

@Composable
fun PriceView(productViewModel: ProductViewModel) {

    val itemsInCart by productViewModel.itemsInCart.observeAsState()

    Row(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "13 686,00",
            modifier = Modifier.padding(start = 16.dp),
            style = TextStyle(color = Black, fontSize = 20.sp, fontWeight = FontWeight.Medium)
        )
        Text(
            text = "Р/шт", modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp),
            style = TextStyle(color = BrownGreyColor, fontSize = 12.sp)
        )

        if (itemsInCart == 0) {
            Button(
                onClick = { productViewModel.addToCart() },
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.background,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .height(48.dp)
                    .width(160.dp)
                    .padding(end = 24.dp)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "В корзину",
                        style = TextStyle(
                            color = White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        } else {
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .height(48.dp)
                    .width(160.dp)
                    .padding(end = 24.dp)
            ) {
                Text(
                    text = itemsInCart.toString(),
                    color = Black
                )
            }
        }
    }
}

@Composable
fun RatingRow() {
    Box(
        modifier = Modifier
            .background(color = White)
            .height(52.dp)
            .fillMaxWidth()
    )
}

@Composable
fun ImageHeader() {
    Box(
        modifier = Modifier
            .background(color = White)
            .height(300.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .height(44.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
    ) {
        Text(text = "Back", color = Black, modifier = Modifier.weight(1f))
        Text(text = "Menu", color = Black)
    }
}