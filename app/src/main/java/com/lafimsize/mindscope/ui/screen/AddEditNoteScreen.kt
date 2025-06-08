package com.lafimsize.mindscope.ui.screen

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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditNoteScreen(navController: NavController,
                      viewModel: AddEditNoteViewModel = viewModel()) {

    val title by viewModel.title.collectAsState()
    val content by viewModel.content.collectAsState()


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Yeni Not") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.saveNote {
                    navController.popBackStack()
                }
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