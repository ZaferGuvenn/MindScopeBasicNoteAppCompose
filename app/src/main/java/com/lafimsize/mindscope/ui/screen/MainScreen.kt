package com.lafimsize.mindscope.ui.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lafimsize.mindscope.ui.components.CustomFloatingActionButton

@Composable
fun MainScreen(navController: NavController) {

    Scaffold(
        floatingActionButton = { CustomFloatingActionButton(navController) }
    ) { innerPadding->

        Column(Modifier.padding(innerPadding)) {
            Text("My Notes", modifier=Modifier.padding(16.dp))
        }
    }
}