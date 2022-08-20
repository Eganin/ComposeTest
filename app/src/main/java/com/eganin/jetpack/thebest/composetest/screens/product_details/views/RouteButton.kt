package com.eganin.jetpack.thebest.composetest.screens.product_details.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eganin.jetpack.thebest.composetest.R

data class RouteButtonModel(val routeId: String, val title: String, val icon: Int? = null)

@Composable
fun RouteButton(
    model: RouteButtonModel,
    onClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .clickable { onClick(model.routeId) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconStub()

        Subtitle5(
            text = model.title,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp, end = 16.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
            contentDescription = "Back Button",
            modifier = Modifier.clickable {

            }
        )
    }
}