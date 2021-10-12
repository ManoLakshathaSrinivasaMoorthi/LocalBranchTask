package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.work.Data;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityWorkManagerBinding;
import com.example.myapplication.helper.Constants;
import com.example.myapplication.helper.NotificationHandler;

import java.util.Calendar;
import java.util.UUID;

public class WorkManagerActivity extends AppCompatActivity {
    private static final String TAG = WorkManagerActivity.class.getSimpleName();
    private ActivityWorkManagerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding= DataBindingUtil.setContentView(this,R.layout.activity_work_manager);


      binding.setAlertButton.setOnClickListener(v -> {
          String inputValue = binding.alertTime.getText().toString();
          if(inputValue.equals("")){
              Toast.makeText(WorkManagerActivity.this, "Input value must not be empty", Toast.LENGTH_SHORT).show();
          }

          //Generate notification string tag
          String tag = generateKey();

          //Get time before alarm
          int minutesBeforeAlert = Integer.parseInt(inputValue);
          long alertTime = getAlertTime(minutesBeforeAlert) - System.currentTimeMillis();
          long current =  System.currentTimeMillis();

          Log.d(TAG, "Alert time - " + alertTime + "Current time " + current);

          int random = (int )(Math.random() * 50 + 1);

          //Data
          Data data = createWorkInputData(random);

          NotificationHandler.scheduleReminder(alertTime, data, tag);
      });
    }


    private Data createWorkInputData(int id){
        return new Data.Builder()
                .putString(Constants.EXTRA_TITLE, Constants.TITLE)
                .putString(Constants.EXTRA_TEXT, Constants.TEXT)
                .putInt(Constants.EXTRA_ID, id)
                .build();
    }


    private long getAlertTime(int userInput){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, userInput);
        return cal.getTimeInMillis();
    }


    private String generateKey(){
        return UUID.randomUUID().toString();
    }

}