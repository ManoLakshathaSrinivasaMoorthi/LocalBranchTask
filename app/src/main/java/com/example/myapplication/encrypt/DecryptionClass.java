package com.example.myapplication.encrypt;


import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.interfaces.CryptoMethods;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DecryptionClass implements Interceptor {
    private static final String TAG = DecryptionClass.class.getSimpleName();
    private final CryptoMethods mDecryptionStrategy;

    public DecryptionClass(CryptoMethods mDecryptionStrategy) {
        this.mDecryptionStrategy = mDecryptionStrategy;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (response.isSuccessful()) {
            Response.Builder newResponse = response.newBuilder();
            String contentType = response.header("Content-Type");
            if (TextUtils.isEmpty(contentType)) contentType = "application/json";
//            InputStream cryptedStream = response.body().byteStream();
            String responseStr = Objects.requireNonNull(response.body()).string();


            String decryptedString = null;
            if (mDecryptionStrategy != null) {
                try {
                    decryptedString = mDecryptionStrategy.decrypt(responseStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Log.i(TAG,"Response string "+ responseStr);
                Log.i(TAG,"Decrypted BODY=> %s"+ decryptedString);
            } else {
                throw new IllegalArgumentException("No decryption strategy!");
            }
            assert contentType != null;
            assert decryptedString != null;
            newResponse.body(ResponseBody.create(MediaType.parse(contentType), decryptedString));
            return newResponse.build();
        }
        return response;
    }
}