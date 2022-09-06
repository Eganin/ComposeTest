package com.eganin.jetpack.thebest.composetest.basicUI

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.eganin.jetpack.thebest.composetest.R
import com.eganin.jetpack.thebest.composetest.ui.theme.Black

@Composable
fun NewMessageScreen() {
    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = stringResource(id = R.string.message))
            }
        }
    ) {
        Column {
            Text(
                text = "Write message",
                color= Black,
                modifier = Modifier
                    .clickable { Log.d("TAG", "CLICKED") }
                    .padding(16.dp)
            )
        }
    }
}