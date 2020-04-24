package com.mike.tennisnotes.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mike.tennisnotes.data.TennisNoteRepository

class HomeViewModelFactory(
    private val tennisNoteRepository: TennisNoteRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(tennisNoteRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}