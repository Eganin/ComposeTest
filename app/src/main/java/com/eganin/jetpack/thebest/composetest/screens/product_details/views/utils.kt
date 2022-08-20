package com.eganin.jetpack.thebest.composetest.screens.product_details.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun IconStub(backgroundColor: Color = Color.LightGray) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .background(backgroundColor)
    ) {

    }
}