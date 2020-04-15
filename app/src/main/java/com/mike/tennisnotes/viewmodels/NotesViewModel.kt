package com.mike.tennisnotes.viewmodels

import androidx.lifecycle.ViewModel

class NotesViewModel(noteTitle:String) : ViewModel() {
    val title = noteTitle
}