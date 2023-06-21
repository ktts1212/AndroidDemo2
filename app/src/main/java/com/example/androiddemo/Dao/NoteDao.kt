package com.example.androiddemo.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androiddemo.entities.Note

TODO：package名字用小写字母，不要用大写

@Dao
interface NoteDao {
   @Insert
   fun insertNote(note: Note):Long

   @Query("select * from Note")
   fun loadAllNote():List<Note>

   @Query("select * from Note where tag=:tag")
   fun queryNotes(tag:String):List<Note>
}
