package com.mike.tennisnotes.data

import android.content.Context
import androidx.room.Room
import timber.log.Timber

class TennisNoteRepository (context: Context) {

    private val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "tennis-notes"
    ).build()

    suspend fun createTennisNote(title: String, content: String, imageUrl: String) {
        val tennisNote = TennisNote(title, imageUrl, content)
        db.tennisNoteDao().insertGardenPlanting(tennisNote)
        Timber.d("note ${tennisNote.noteId}")
    }

}