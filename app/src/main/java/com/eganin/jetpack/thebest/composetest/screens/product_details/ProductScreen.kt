package com.eganin.jetpack.thebest.composetest.screens.product_details

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eganin.jetpack.thebest.composetest.ui.theme.ComposeTheme

@Preview
@Composable
fun ComposablePreview() {
    ComposeTheme {
        ProductScreen()
    }
}

@Composable
fun ProductScreen(productViewModel: ProductViewModel = viewModel()) {
    val name by productViewModel.name.observeAsState()

    LazyColumn(content = {
        item { Text(text = "Name is -> $name", color = Color.Black) }
        item {
            Button(onClick = {
                productViewModel.setNewName(newName = "New name")
            }, modifier = Modifier.padding(16.dp)) {
                Text(text = "Click to change name")
            }
        }
    })
}