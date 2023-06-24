<<<<<<< HEAD
package com.example.androiddemo.dao
=======
package com.example.androiddemo.Dao
>>>>>>> bffdb80ef3f495591b81abeabae79cb55390cb4a

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androiddemo.entities.Note

<<<<<<< HEAD
=======
TODO：package名字用小写字母，不要用大写

>>>>>>> bffdb80ef3f495591b81abeabae79cb55390cb4a
@Dao
interface NoteDao {
   @Insert
   fun insertNote(note: Note):Long

   @Query("select * from Note")
   fun loadAllNote():List<Note>

   @Query("select * from Note where tag=:tag")
   fun queryNotes(tag:String):List<Note>
<<<<<<< HEAD
}
=======
}
>>>>>>> bffdb80ef3f495591b81abeabae79cb55390cb4a
