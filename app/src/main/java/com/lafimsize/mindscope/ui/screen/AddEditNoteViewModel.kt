package com.lafimsize.mindscope.ui.screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddEditNoteViewModel():ViewModel() {

    private val _title = MutableStateFlow("")
    val title : StateFlow<String> = _title

    private val _content = MutableStateFlow("")
    val content : StateFlow<String> = _content

    fun onTitleChange(newTitle:String){
        _title.value = newTitle
    }

    fun onContentChange(newContent:String){
        _content.value = newContent
    }

    fun saveNote(onSaved:()->Unit){
        //later
        onSaved()
    }

}