package com.lafimsize.mindscope.ui.screen

import androidx.lifecycle.ViewModel
import com.lafimsize.mindscope.data.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel:ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(generateDummyNotes())
    val notes: StateFlow<List<Note>> = _notes

    private fun generateDummyNotes():List<Note>{

        val exmNotes=arrayListOf<Note>()
        repeat(10) {
            val note= Note(
                id = it,
                title = "My note $it",
                content = "My content $it",
                timestamp = System.currentTimeMillis(),
                isFavorite = it%4==0// exm 4th and 8th
            )
            exmNotes.add(note)
        }



        return exmNotes
    }
}