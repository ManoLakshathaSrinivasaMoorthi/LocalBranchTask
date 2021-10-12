package com.example.myapplication.retrofit;

import com.example.myapplication.encrypt.DecryptionClass;
import com.example.myapplication.encrypt.DecryptionImplement;
import com.example.myapplication.encrypt.EncryptionClass;
import com.example.myapplication.encrypt.EncryptionImpl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiInstances {

  //  private static final String BASE_URL = "https://api-mobilespecs.azharimm.site/";
  //  private static final String BASE_URL = "https://age-of-empires-2-api.herokuapp.com/";
    private static final String BASE_URL = "https://www.scorebat.com/";

    public static Retrofit getClient() {
        EncryptionClass encryptionInterceptor = new EncryptionClass(new EncryptionImpl());
        DecryptionClass decryptionInterceptor = new DecryptionClass(new DecryptionImplement());

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
               .addInterceptor(encryptionInterceptor)
                .addInterceptor(decryptionInterceptor)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}