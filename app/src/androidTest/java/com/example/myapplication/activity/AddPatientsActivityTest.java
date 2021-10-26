package com.example.myapplication.activity;


import android.widget.Button;
import android.widget.EditText;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AddPatientActivityTest {

    @Rule
    public ActivityTestRule<AddPatientActivity> testRule=new ActivityTestRule<>(AddPatientActivity.class);
    private  AddPatientActivity patientActivity;
    @Before
    public void setUp() throws Exception {
        patientActivity=testRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        patientActivity=null;
    }
    @Test
    public  void onCheckinput(){
        EditText firstName = patientActivity.findViewById(R.id.id_first_name);
        EditText lastName = patientActivity.findViewById(R.id.id_last_name);
        EditText dob = patientActivity.findViewById(R.id.id_dob);
        // checkBox.performClick();

        firstName.setText("firstname");
        lastName.setText("lastname");
        dob.setText("04-02-1997");
        Button submitBTn=patientActivity.findViewById(R.id.submitBtn);
//        submitBTn.performClick();
    }
}