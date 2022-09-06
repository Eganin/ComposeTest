package com.eganin.jetpack.thebest.composetest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eganin.jetpack.thebest.composetest.basicUI.NewMessageScreen
import com.eganin.jetpack.thebest.composetest.meditationUI.HomeScreen
import com.eganin.jetpack.thebest.composetest.screens.navtest.*
import com.eganin.jetpack.thebest.composetest.screens.product_details.ProductScreen
import com.eganin.jetpack.thebest.composetest.ui.theme.Black
import com.eganin.jetpack.thebest.composetest.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                CreateScaffold()
            }
        }
    }
}

@Composable
fun CreateScaffold() {
    Surface(color = MaterialTheme.colors.background) {
        val navController: NavHostController = rememberNavController()
        val bottomItems = listOf("list", "search", "push")

        Scaffold {
            HomeScreen()
            /*
            NavHost(navController = navController, startDestination = "list") {
                composable("list") {
                    ListScreen(navController = navController)
                }
                composable("search") {
                    NewMessageScreen()
                }
                composable("push") {
                    PushScreen()
                }
                composable("details") {
                    navController.previousBackStackEntry?.savedStateHandle?.get<Word>("WORD_KEY")?.let {
                        DetailsScreen(word = it)
                    }
                }
            }

             */
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        CreateScaffold()
    }
}