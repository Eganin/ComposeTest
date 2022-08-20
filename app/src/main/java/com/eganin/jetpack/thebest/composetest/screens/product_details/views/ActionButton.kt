package com.eganin.jetpack.thebest.composetest.screens.product_details.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eganin.jetpack.thebest.composetest.ui.theme.Black
import com.eganin.jetpack.thebest.composetest.ui.theme.White

data class ActionButtonModel(
    val title: String,
    val selectedTitle: String,
    val icon: String? = null,
    val selectedIcon: String? = null,
    val isSelected: Boolean=false,
)

@Composable
fun ActionButton(
    model: ActionButtonModel,
    onClick: (ActionButtonModel, Boolean) -> Unit
) {

    var isSelected by rememberSaveable{ mutableStateOf(model.isSelected) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(16.dp)
        .background(White)
        .clickable {
            isSelected = !isSelected
            onClick(model, isSelected)
        }) {
        Card(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = if (isSelected) White else Color.LightGray,
            shape = RoundedCornerShape(4.dp),
            border = if (isSelected) BorderStroke(1.dp, color = Black) else null,
            elevation = 0.dp,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Subtitle4(text = if (isSelected) model.selectedTitle else model.title,
                modifier = Modifier.weight(1f))
                if (isSelected) {
                    IconStub()
                } else {
                    IconStub(backgroundColor =White)
                }
            }
        }
    }
}