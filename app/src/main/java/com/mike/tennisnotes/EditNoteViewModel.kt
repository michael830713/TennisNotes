package com.mike.tennisnotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mike.tennisnotes.data.TennisNoteRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class EditNoteViewModel(private val tennisNoteRepository: TennisNoteRepository, val url: String) :
    ViewModel() {


    fun addNoteToDatabase(title: String,content: String ) {
        Timber.d(content)
        viewModelScope.launch { tennisNoteRepository.createTennisNote(title, content, url) }
    }


}