package com.sundram.mvvmexample;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/*
*we can pass multiple classes inside of @Database annotation
* like
* @Database(entities={NOteOne.class,NoteTwo.class},version=1)
*
* whenever we change the database we need to change the version number
*
* after production don't need to change the version number
 */

@Database(entities = Note.class,version = 1)
public abstract class NoteDataBase extends RoomDatabase {
    private static NoteDataBase instance;

    public abstract NoteDao noteDao();

    /*
    * synchronized is use So that one thread can access one object at a time
    * */
    public static synchronized NoteDataBase getInstance(Context context){
        if (instance == null) {
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    NoteDataBase.class,
                    "note_database")
                    //this is use for remove the current database and create new instance
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{

        private NoteDao noteDao;

        public PopulateDbAsyncTask(NoteDataBase noteDataBase) {
            this.noteDao = noteDataBase.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("Title One","Desc One",1));
            noteDao.insert(new Note("Title 2","Desc 2",1));
            noteDao.insert(new Note("Title 3","Desc 3",1));
            noteDao.insert(new Note("Title 4","Desc 4",1));
            return null;
        }
    }
}
