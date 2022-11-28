package com.example.mvvmproject.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

// to make this class "Table"
@Entity(tableName = "actor", indices = @Index(value = {"id"}, unique = true))
// indices = @Index(value = {"id"}, unique = true) --- it is used to prevent duplicating
public class Actor {
    // to make primary key
    @PrimaryKey(autoGenerate = true)
    private int actorId;

    // @SerializedName --> used  for making same names with json data names. if names of variables are same, you don't need
    // this. but when variable names are different,  you can use this and pass word here that is same with json data

    // @ColumnInfo --> if we dont want to pass id but we want to pass name instead of id, we can use this and pass name of that
    // column in which you want to pass data
    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("image")
    @ColumnInfo(name = "image")
    private String image;

    @SerializedName("age")
    @ColumnInfo(name = "age")
    private int age;

    public Actor(int id, String name, String image, int age) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", age=" + age +
                '}';
    }
}
