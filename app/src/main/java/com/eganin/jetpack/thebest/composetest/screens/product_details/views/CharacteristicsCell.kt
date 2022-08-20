package com.eganin.jetpack.thebest.composetest.screens.product_details.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.eganin.jetpack.thebest.composetest.ui.theme.Black
import com.eganin.jetpack.thebest.composetest.ui.theme.BrownGreyColor
import com.eganin.jetpack.thebest.composetest.ui.theme.VeryLightPink


data class CharacteristicModel(
    val title: String,
    val value: String,
)
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