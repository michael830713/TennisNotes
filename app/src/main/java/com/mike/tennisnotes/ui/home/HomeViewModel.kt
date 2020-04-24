package com.mike.tennisnotes.ui.home

import androidx.lifecycle.*
import com.mike.tennisnotes.data.TennisNote
import com.mike.tennisnotes.data.TennisNoteRepository
import kotlinx.coroutines.launch

class HomeViewModel(tennisNoteRepository: TennisNoteRepository) : ViewModel() {


    val notes: LiveData<List<TennisNote>> =
        Transformations.map(tennisNoteRepository.getTennisNote()) { it.reversed() }


}