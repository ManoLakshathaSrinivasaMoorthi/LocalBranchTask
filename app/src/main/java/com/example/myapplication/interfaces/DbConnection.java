package com.example.myapplication.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.model.UserInputs;

import java.util.List;

@Dao
public interface DbConnection {
    //insert new data query
    @Insert
    void insert(UserInputs userInputs);

    @Delete
    void delete(UserInputs userInputs);
    // already exist email query
    @Query("SELECT * FROM SignupDb WHERE Email = :email")
   int isDataExist(String email);

   @Query("SELECT * FROM signupdb WHERE PHONE =:phone")
    int  isSelect( String phone);

    @Query("SELECT * FROM SignupDb")
    LiveData<List<UserInputs>> getAllDatas();

    @Query("UPDATE SignupDb SET UserName=:name ,Phone=:phone,Email=:email WHERE id=:ids ")
    void updatedata(String name,String phone,String email,int ids);
}
