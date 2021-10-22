package com.example.myapplication.db;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class RealmeDb extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // initializing our realm database.
        Realm.init(this);

        // on below line we are setting realm configuration
        RealmConfiguration config = new RealmConfiguration.Builder()
                        .allowWritesOnUiThread(true)
                        .deleteRealmIfMigrationNeeded()
                        .build();

        Realm.setDefaultConfiguration(config);
    }
}
