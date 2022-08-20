package com.eganin.jetpack.thebest.composetest.screens.product_details.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.eganin.jetpack.thebest.composetest.ui.theme.Black
import com.eganin.jetpack.thebest.composetest.ui.theme.BrownGreyColor

@Composable
fun Subtitle5(text: String, modifier: Modifier = Modifier) = Text(
    modifier = modifier,
    text = text,
    style = TextStyle(color = Black, fontSize = 14.sp, fontWeight = FontWeight.Normal)
)

@Composable
fun Subtitle4(text: String, modifier: Modifier = Modifier) = Text(
    modifier = modifier,
    text = text,
    style = TextStyle(color = Black, fontSize = 14.sp, fontWeight = FontWeight.Medium)
)

@Composable
fun Caption(text: String, modifier: Modifier = Modifier) =
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(color = BrownGreyColor, fontSize = 12.sp, fontWeight = FontWeight.Normal)
    )