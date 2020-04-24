package com.mike.tennisnotes.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TennisNoteDao {
    @Insert
    suspend fun insertGardenPlanting(tennisNote: TennisNote): Long

    @Query("SELECT * FROM tennis_notes")
   suspend fun getAll(): List<TennisNote>
}