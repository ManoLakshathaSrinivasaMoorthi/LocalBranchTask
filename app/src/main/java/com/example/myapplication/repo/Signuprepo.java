package com.example.myapplication.repo;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.myapplication.db.SignupDatabase;
import com.example.myapplication.interfaces.DbConnection;
import com.example.myapplication.model.UserInputs;

import java.util.List;

public class Signuprepo {

    private final LiveData<List<UserInputs>> mAllDatas;
    private final Context context;

    public Signuprepo(Application application, Context context) {
        this.context = context;
        SignupDatabase db =SignupDatabase.getDatabase(application);
        DbConnection mUsers = db.loginDoa();
        mAllDatas= mUsers.getAllDatas();
    }


    public void insert(UserInputs users) {
        SignupDatabase.getDatabase(context).loginDoa().insert(users);
    }
   public void SelectPhone(@NonNull UserInputs users) {
        SignupDatabase.getDatabase(context).loginDoa().isSelect(users.getPhone());
    }
    public LiveData<List<UserInputs>> getAllDatas() {
        return mAllDatas;
    }

    public  void updateUser(@NonNull UserInputs data){
        SignupDatabase.getDatabase(context).loginDoa().updatedata(data.getName(),data.getEmail(),data.getPhone(),data.getId());
    }

}
