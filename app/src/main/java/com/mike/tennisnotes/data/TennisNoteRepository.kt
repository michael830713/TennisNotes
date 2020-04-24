package com.mike.tennisnotes.data

import android.content.Context
import androidx.room.Room
import com.mike.tennisnotes.R
import timber.log.Timber

class TennisNoteRepository(context: Context) {

    private val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, context.getString(R.string.databaseName)
    ).build()

    suspend fun createTennisNote(title: String, content: String, imageUrl: String) {
        val tennisNote = TennisNote(title, imageUrl, content)
        db.tennisNoteDao().insertGardenPlanting(tennisNote)
        Timber.d("note ${tennisNote.noteId}")
    }

    suspend fun getTennisNote() {

        var notes = db.tennisNoteDao().getAll()
        var list: List<String> = notes.map { note -> note.noteId }.toList()

        Timber.d("note $list")
    }

}