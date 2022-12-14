package com.eganin.jetpack.thebest.composetest.screens.product_details

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eganin.jetpack.thebest.composetest.R
import com.eganin.jetpack.thebest.composetest.screens.product_details.views.*
import com.eganin.jetpack.thebest.composetest.ui.theme.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductScreen(
    productViewModel: ProductViewModel = viewModel(),

) {
    val sku by productViewModel.sku.observeAsState()
    val title by productViewModel.title.observeAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
            stickyHeader { Toolbar() }
            item { ImageHeader(productViewModel = productViewModel) }
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
            item { HeaderView(height = 68.dp, title = "?????????????? ??????????????????") }
            item { DeliveryPickupView(productViewModel = productViewModel) }
            item {
                Column {
                    RouteButton(
                        model = RouteButtonModel(
                            routeId = "InStoreAvailability",
                            title = "?????????????? ?? ??????????????????"
                        ), onClick = {
                        })

                    ActionButton(
                        model = ActionButtonModel(
                            title = "???????????????? ?? ????????????",
                            selectedTitle = "?????????????????? ?? ????????????",
                        ), onClick = { _, _ ->
                        })
                }
            }
            item { HeaderView(height = 68.dp, title = "????????????????????????????") }
            item { CharacteristicsView(productViewModel = productViewModel) }
            item {
                Column {
                    RouteButton(
                        model = RouteButtonModel(
                            routeId = "AllCharsScreen",
                            title = "?????? ????????????????????????????"
                        ), onClick = {

                        })

                    ActionButton(
                        model = ActionButtonModel(
                            title = "???????????????? ?? ??????????????????",
                            selectedTitle = "?????????????????? ?? ????????????",
                        ), onClick = { _, _ ->
                        })
                }
            }
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
            Subtitle5(text = "???????????????? ????????????, 25 ????????")
            Caption(text = "???? ???????????? 12 ????", modifier = Modifier.padding(top = 2.dp))

            if (pickupStoresCount > 0) {
                Subtitle5(text = "?????????????????? ??????????????", modifier = Modifier.padding(top = 16.dp))
                Caption(
                    text = "???????????????? ?? $pickupStoresCount ??????????????????",
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
            Text(text = "???????????????????? ??????-????", style = TextStyle(color = Black))
            Text(
                text = "?? ?????????????? $availableCount",
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
            text = "??/????", modifier = Modifier
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
                        text = "?? ??????????????",
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
fun ImageHeader(productViewModel: ProductViewModel) {
    val image by productViewModel.imageHeaderView.observeAsState("")
    ImageView(
        imageUrl = image, modifier = Modifier
            .height(260.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_keyboard_backspace_24),
            contentDescription = "Back Button",
            modifier = Modifier
                .clickable {

                }
                .size(56.dp)
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24),
            contentDescription = "More Button",
            modifier = Modifier
                .clickable {

                }
                .size(56.dp)
                .padding(16.dp)
        )
    }
}