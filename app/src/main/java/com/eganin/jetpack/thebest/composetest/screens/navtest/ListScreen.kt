package com.eganin.jetpack.thebest.composetest.screens.navtest

import android.os.Parcelable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import com.eganin.jetpack.thebest.composetest.ui.theme.Black
import kotlinx.parcelize.Parcelize

@Parcelize
data class Word(val value: String) : Parcelable

@Composable
fun ListScreen(
    navController: NavController,
) {
    val testArray = listOf(
        Word("Hello"),
        Word("Jorno"),
        Word("Jovana"),
        Word("JOJO"),
        Word("Requiem"),
        Word("telega"),
        Word("Hello"),
        Word("Jorno"),
        Word("Jovana"),
        Word("JOJO"),
        Word("Requiem"),
        Word("telega"),
        Word("Hello"),
        Word("Jorno"),
        Word("Jovana"),
        Word("JOJO"),
        Word("Requiem"),
        Word("telega"),
    )

    Scaffold {
        LazyColumn {
            testArray.map {
                item {
                    Text(
                        text = it.value,
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                            .clickable {
                                with(navController){
                                    currentBackStackEntry?.savedStateHandle?.set("WORD_KEY",value = it)
                                    navigate("details")
                                }
                            },
                        color = Black
                    )
                }
            }
        }
    }
}