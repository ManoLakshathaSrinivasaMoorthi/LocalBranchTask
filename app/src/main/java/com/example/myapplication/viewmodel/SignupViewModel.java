package com.example.myapplication.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.model.UserInputs;
import com.example.myapplication.repo.Signuprepo;

import java.util.List;

public class SignupViewModel extends AndroidViewModel {
    private final Signuprepo mRepository;
    private LiveData<List<UserInputs>> datas;
    @SuppressLint("StaticFieldLeak")
    Context context;

    public SignupViewModel (Application application) {
        super(application);
        mRepository = new Signuprepo(application, context);

    }

    public LiveData<List<UserInputs>> getDatas() {
        if (datas == null) {
            datas = mRepository.getAllDatas();
        }
        return datas;
    }
    public void insert(UserInputs data) { mRepository.insert(data); }

    public  void update (UserInputs data){
        mRepository.updateUser(data);
    }
    public  void  selectPhone(UserInputs data){
        mRepository.SelectPhone(data);
    }


}
