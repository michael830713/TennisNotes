package com.mike.tennisnotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mike.tennisnotes.data.TennisNoteRepository
import kotlinx.coroutines.launch

class EditNoteViewModel(private val tennisNoteRepository: TennisNoteRepository, val url: String) :
    ViewModel() {

    private var title: String = ""
    private var content: String = ""

    fun addNoteToDatabase() {
        viewModelScope.launch {
            tennisNoteRepository.createTennisNote(title, content, url)
        }
    }

    fun getNotesFromDatabase() {
        viewModelScope.launch {
            tennisNoteRepository.getTennisNote()

        }
    }

}