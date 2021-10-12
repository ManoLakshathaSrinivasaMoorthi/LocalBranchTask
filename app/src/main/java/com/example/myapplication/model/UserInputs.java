package com.example.myapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "SignupDb")
public class UserInputs extends Throwable implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private  int id;
    @ColumnInfo(name = "UserName")
    private String Name;
    @ColumnInfo(name = "Email")
    private String Email;
    @ColumnInfo(name = "Phone")
    private String Phone;
    @ColumnInfo(name = "Password")
    private  String Password;



    public UserInputs() {
    }

    public UserInputs(String name, String email, String phone) {
        Name = name;
        Email = email;
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
