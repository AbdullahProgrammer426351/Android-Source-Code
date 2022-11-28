package com.example.mvvmproject.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mvvmproject.Dao.ActorDao;
import com.example.mvvmproject.Model.Actor;

@Database(entities = {Actor.class}, version = 1)
public abstract class ActorDatabase extends RoomDatabase {
    // giving name to database
    private static final String DATABASE_NAME = "ActorDatabase";

    // making method for calling Dao interface methods
    public abstract ActorDao actorDao();

    // making an instance for database
    private static volatile ActorDatabase INSTANCE;
    // volatile is used because we want that when application is closed, instance should be removed from memory

    // making a method where I can create instance declared above and create database
    public static ActorDatabase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (ActorDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, ActorDatabase.class, DATABASE_NAME)
                            .addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsyncTask(INSTANCE);
        }
    };

    static class PopulateAsyncTask extends AsyncTask<Void, Void, Void>{
//        AsyncTask is used to handle background tasks without disturbing the main thread

        private ActorDao actorDao;
        // creating constructor
        PopulateAsyncTask(ActorDatabase actorDatabase){
            actorDao = actorDatabase.actorDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            actorDao.deleteAll();
            return null;
        }
    }

}
