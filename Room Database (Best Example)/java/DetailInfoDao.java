package com.example.databaselistview;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DetailInfoDao {
    @Insert
    void insertUserDetail(MyDetailInfo myDetailInfo);
    @Query("SELECT * from UserDetail")
    List<MyDetailInfo> fetchAllData();

}
