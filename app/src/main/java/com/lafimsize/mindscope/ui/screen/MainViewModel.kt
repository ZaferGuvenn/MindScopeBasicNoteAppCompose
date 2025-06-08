package com.lafimsize.mindscope.ui.screen

import androidx.lifecycle.ViewModel
import com.lafimsize.mindscope.data.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel:ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes


    fun addNote(note:Note){
        _notes.value = _notes.value + note
    }

}