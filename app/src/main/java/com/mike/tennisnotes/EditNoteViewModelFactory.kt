package com.mike.tennisnotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EditNoteViewModelFactory(private val url: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditNoteViewModel::class.java)) {
            return EditNoteViewModel(url) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}