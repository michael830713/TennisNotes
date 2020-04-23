package com.mike.tennisnotes.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TennisNote::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tennisNoteDao(): TennisNoteDao
}