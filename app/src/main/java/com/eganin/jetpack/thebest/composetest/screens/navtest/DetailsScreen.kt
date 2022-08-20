package com.eganin.jetpack.thebest.composetest.screens.navtest

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eganin.jetpack.thebest.composetest.ui.theme.Black

@Composable
fun DetailsScreen(word: Word) {
    Scaffold {
        Text(
            text = "List Screen -> ${word.value}",
            modifier = Modifier.padding(24.dp),
            color = Black
        )
    }
}