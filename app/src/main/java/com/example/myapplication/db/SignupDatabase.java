package com.example.myapplication.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.interfaces.DbConnection;
import com.example.myapplication.model.UserInputs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {UserInputs.class}, version = 1,exportSchema = true)
public abstract class SignupDatabase extends RoomDatabase {

    public abstract DbConnection loginDoa();
    private static SignupDatabase INSTANCE;

    public static SignupDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SignupDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, SignupDatabase.class, "SignupUsers")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

