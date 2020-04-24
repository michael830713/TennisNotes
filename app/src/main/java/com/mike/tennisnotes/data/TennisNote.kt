package com.mike.tennisnotes.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tennis_notes")
data class TennisNote(
    val title: String,
    val imageUrl: String,
    val content: String,
    @PrimaryKey val noteId: String = java.util.UUID.randomUUID().toString()
)