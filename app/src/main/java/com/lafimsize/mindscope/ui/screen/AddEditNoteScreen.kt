package com.lafimsize.mindscope.ui.screen

import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.lafimsize.mindscope.data.model.Note
import com.lafimsize.mindscope.util.findActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNoteScreen(navController: NavController,
                      viewModel: AddEditNoteViewModel = viewModel()
) {

    val context = LocalContext.current
    val activity = remember { context.findActivity()}//ext fun for finding real activity from ContextWrapper
    val mainViewModel : MainViewModel = viewModel(activity as ComponentActivity)

    val title by viewModel.title.collectAsState()
    val content by viewModel.content.collectAsState()


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("New Note") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {

                val note = Note(
                    id = System.currentTimeMillis(),//will be primary key with room
                    title = title,
                    content = content,
                    timestamp = System.currentTimeMillis()
                )

                mainViewModel.addNote(note)
                navController.popBackStack()

            }) {
                Text("Save")
            }
        }
    ) { innerPadding->

        Column(Modifier
            .padding(innerPadding)
            .padding(16.dp)) {

            OutlinedTextField(
                value = title,
                onValueChange = viewModel::onTitleChange,
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(12.dp))

            OutlinedTextField(
                value = content,
                onValueChange = {viewModel.onContentChange(it)},//same as like top code
                label = { Text("Content") },
                modifier = Modifier.fillMaxWidth().height(150.dp)
            )

        }
    }




}