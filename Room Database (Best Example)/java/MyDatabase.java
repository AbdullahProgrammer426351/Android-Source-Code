package com.example.databaselistview;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MyDetailInfo.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract DetailInfoDao detailInfoDao();
}
