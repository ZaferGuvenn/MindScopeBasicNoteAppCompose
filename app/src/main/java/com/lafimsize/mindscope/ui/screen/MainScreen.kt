package com.lafimsize.mindscope.ui.screen


import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.lafimsize.mindscope.data.model.Note
import com.lafimsize.mindscope.util.findActivity

@Composable
fun MainScreen(
    navController: NavController,
) {

    val context = LocalContext.current
    val activity = remember { context.findActivity()}
    val mainViewModel: MainViewModel = viewModel(activity as ComponentActivity)

    val notes by mainViewModel.notes.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate("add_edit")}
            ) {
                Icon(Icons.Default.Add, contentDescription = "New Note")
            }
        }
    ) { innerPadding->

        LazyColumn(Modifier.padding(innerPadding)) {
            items(notes) { note->
                NoteItem(note = note)
            }
        }
    }
}

@Composable
fun NoteItem(note: Note){

    Card(
        Modifier.padding(8.dp).fillMaxSize().clickable{}
    ) {

        Column(Modifier.padding(16.dp)) {

            Text(text = note.title, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(4.dp))
            Text(text = note.content, maxLines = 2, style = MaterialTheme.typography.bodyMedium)
        }
    }
}