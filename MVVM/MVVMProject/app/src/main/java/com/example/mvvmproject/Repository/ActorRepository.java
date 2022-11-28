package com.example.mvvmproject.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mvvmproject.ActorDatabase;
import com.example.mvvmproject.Dao.ActorDao;
import com.example.mvvmproject.Model.Actor;

import java.util.List;

public class ActorRepository {
    // creating instance of ActorDatabase class
    private ActorDatabase database;

    // making variable of livedata to get data about all actors in our database
    private LiveData<List<Actor>> getAllActors;

    // creating constructor
    public ActorRepository(Application application){
        database = ActorDatabase.getInstance(application);
        // we will access actorDao method in ActorDatabase class and then we will access methods in ActorDao interface
        getAllActors = database.actorDao().getAllActors();
    }

    public void insert(List<Actor> actorList){
        new InsertAsyncTask(database).execute(actorList);
    }

    public LiveData<List<Actor>> getAllActors(){
        return getAllActors;
    }

    // creating a class for insertion operations

    static class InsertAsyncTask extends AsyncTask<List<Actor>, Void, Void> {
        private ActorDao actorDao;

        // creating a constructor
        InsertAsyncTask(ActorDatabase actorDatabase){
            // to get access to daoInterface
            actorDao = actorDatabase.actorDao();
        }

        @Override
        protected Void doInBackground(List<Actor>... lists) {
            // here we will insert data through method which we accessed in above method
            actorDao.insert(lists[0]);
//            [0] ---> used because in || protected Void doInBackground(List<Actor>... lists) { || , there are three dots
            // which means there are many lists not only one list. therefore we are calling first list with 0 index
            return null;
        }
    }
}
