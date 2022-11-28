package com.example.mvvmproject.Dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvvmproject.Model.Actor;

import java.util.List;

@Dao
public interface ActorDao {
    // making insert method
    @Insert(onConflict = OnConflictStrategy.REPLACE)// it will replace all duplicate data to new data
    void insert(List<Actor> actorList);

    @Query("SELECT * FROM actor")// query for selecting all data because in Room,  there is not annotation for getting data
    LiveData<List<Actor>> getAllActors();// live data helps us to update data in recycler view without refreshing it

    @Query("DELETE FROM actor")// for deleting all data because in Room,  there is not built-in annotation for getting data
    void deleteAll();
}
