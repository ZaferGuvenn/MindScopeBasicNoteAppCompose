package com.lafimsize.mindscope.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddEditNoteScreen(navController: NavController) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(text = "Add new note", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier= Modifier.height(8.dp))
        Button(
            onClick = {navController.popBackStack()}
        ) {
            Text("Go back")
        }

    }

}