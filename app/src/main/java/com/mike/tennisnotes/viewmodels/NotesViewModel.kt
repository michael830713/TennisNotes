package com.mike.tennisnotes.viewmodels

import androidx.lifecycle.ViewModel
import com.mike.tennisnotes.data.TennisNote

class NotesViewModel(noteTitle: TennisNote) : ViewModel() {
    val title :String = noteTitle.title
    val imageUrl :String = noteTitle.url
}