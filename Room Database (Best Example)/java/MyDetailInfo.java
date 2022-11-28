package com.example.databaselistview;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserDetail")
public class MyDetailInfo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Name;
    private String FatherName;
    private String PhoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
