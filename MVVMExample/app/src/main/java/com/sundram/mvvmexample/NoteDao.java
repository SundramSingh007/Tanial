package com.sundram.mvvmexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    /*
    * in some case
    * if we change the column of table
    * but did not perform changes in java object
    * then our app get compile time error
    * and app won't get start
    *
    * for handling this error
    *
    * we can use LiveData abstract class provided by room
    * So LiveData class is able to manage this error
    * but auto performing reflect the changes of table into
    * java object
    * */

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();
}
