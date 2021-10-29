package com.example.myapplication.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.model.GameModel;
import com.example.myapplication.retrofit.ApiClient;
import com.example.myapplication.retrofit.ApiInstances;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EncryptionActivity extends AppCompatActivity {
    TextView responseText;
    ApiClient apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);
        Button saveButton = findViewById(R.id.button);
        responseText = (TextView) findViewById(R.id.textView12);
        apiInterface = ApiInstances.getClient().create(ApiClient.class);
        GameModel user = new GameModel();
        Call<List<GameModel>> call1 = apiInterface.createUser();

        saveButton.setOnClickListener(v -> call1.enqueue(new  Callback<List<GameModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<GameModel>> call, @NonNull Response<List<GameModel>> response) {
               // Example user1 = response.body();
                response.body();
                long tx = response.raw().receivedResponseAtMillis();
                long rx = response.raw().sentRequestAtMillis();
                Log.d("response time : ",(rx - tx)+" ms");
               //   responseText.setText(response.body().toString());
                // Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<GameModel>> call, Throwable t) {
                call.cancel();
            }
        }));

    }
}