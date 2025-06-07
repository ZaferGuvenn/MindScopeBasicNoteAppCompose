package com.lafimsize.mindscope.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lafimsize.mindscope.ui.screen.AddEditNoteScreen
import com.lafimsize.mindscope.ui.screen.MainScreen

@Composable
fun MindScopeApp() {

    val navController = rememberNavController()

    NavHost(navController=navController, startDestination = "main"){

        composable("main"){
            MainScreen(navController)
        }
        composable("add_edit") {
            AddEditNoteScreen(navController)
        }
    }
}