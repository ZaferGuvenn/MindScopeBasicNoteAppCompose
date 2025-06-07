package com.lafimsize.mindscope.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun CustomFloatingActionButton(navController: NavController) {

    FloatingActionButton(
        onClick = {navController.navigate("add_edit")}
    ) {
        Icon(Icons.Default.Add, contentDescription = "New Note")
    }
}

