package com.mike.tennisnotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mike.tennisnotes.data.TennisNoteRepository

class EditNoteViewModelFactory(
    private val tennisNoteRepository: TennisNoteRepository,
    private val url: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditNoteViewModel::class.java)) {
            return EditNoteViewModel(tennisNoteRepository, url) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}