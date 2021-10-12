package com.example.myapplication.receiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.example.myapplication.db.SignupDatabase;
import com.example.myapplication.model.UserInputs;
import com.example.myapplication.viewmodel.SignupViewModel;

import java.util.List;

public class IncomingCall extends BroadcastReceiver {
    private static final String TAG = "PhoneStatReceiver";

    private static boolean incomingFlag = false;

    private static String incoming_number = null;
    private List<UserInputs> dataList = null;
    SignupViewModel viewModel;
    int position=dataList.size();
    public IncomingCall(List<UserInputs> dataList) {
        this.dataList = dataList;
    }

    @Override

    public void onReceive(Context context, Intent intent) {
        UserInputs data = dataList.get(position);
        SignupDatabase database = SignupDatabase.getDatabase(context);

        if(intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)){

            incomingFlag = false;

            String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

            Log.i(TAG, "call OUT:"+phoneNumber);

        }else{


            TelephonyManager tm = (TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);



            switch (tm.getCallState()) {

                case TelephonyManager.CALL_STATE_RINGING:

                    incomingFlag = true;
                   // viewModel = ViewModelProviders.of(this).get(BirthDateViewModel.class);
                    viewModel.selectPhone(data);

                   // int number=db.loginDoa().isSelect(data.getPhone());
                    Log.i(TAG, "RINGING :"+String.valueOf(data));

                    break;

                case TelephonyManager.CALL_STATE_OFFHOOK:

                    if(incomingFlag){

                        Log.i(TAG, "incoming ACCEPT :"+ incoming_number);

                    }

                    break;



                case TelephonyManager.CALL_STATE_IDLE:

                    if(incomingFlag){

                        Log.i(TAG, "incoming IDLE");

                    }

                    break;

            }

        }

    }

}
