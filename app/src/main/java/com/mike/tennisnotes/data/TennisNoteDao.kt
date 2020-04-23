package com.mike.tennisnotes.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TennisNoteDao  {
    @Insert
    suspend fun insertGardenPlanting(tennisNote: TennisNote): Long
}