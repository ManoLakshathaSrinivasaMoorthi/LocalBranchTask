package com.example.myapplication.encrypt;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.interfaces.CryptoMethods;
import java.io.IOException;
import java.util.Objects;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.myapplication.cryptomodel.Utils.requestBodyToString;

public class EncryptionClass implements Interceptor {
    private static final String TAG = EncryptionClass.class.getSimpleName();
    private final CryptoMethods mEncryptionStrategy;
    public EncryptionClass(CryptoMethods mEncryptionStrategy) {
        this.mEncryptionStrategy = mEncryptionStrategy;
    }

    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        RequestBody rawBody = request.body();
        String encryptedBody = "";


        MediaType mediaType = MediaType.parse("text/plain; charset=utf-8");
        if (mEncryptionStrategy != null) {
            try {
                assert rawBody != null;
                String rawBodyStr = requestBodyToString(rawBody);
                encryptedBody = mEncryptionStrategy.encrypt(rawBodyStr);
                Log.i(TAG,"Raw body"+rawBodyStr);
                Log.i(TAG,"Encrypted BODY" + encryptedBody);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("No encryption strategy!");
        }
        RequestBody body = RequestBody.create(mediaType, encryptedBody);
        request = request.newBuilder().header("Content-Type", Objects.requireNonNull(body.contentType()).toString())
                .header("Content-Length", String.valueOf(body.contentLength()))
                .method(request.method(), body)
                .build();

        return chain.proceed(request);
    }


}