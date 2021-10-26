package com.example.myapplication.activity;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.widget.Button;
import android.widget.EditText;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.myapplication.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)

public class ContactAdminActivityTest {

    @Rule
    public ActivityTestRule<ContactAdminActivity> activityTestRule = new ActivityTestRule<>(ContactAdminActivity.class);
    ContactAdminActivity adminActivity;

    @Test
    public void checkDisplayed() {
        onView(withId(R.id.textAdmin)).check(matches(isDisplayed()));
        onView(withId(R.id.btnSubmit)).check(matches(isDisplayed()));


    }
    @Test
    public void contactAdmin()
    {

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                EditText textAdmin = adminActivity.findViewById(R.id.textAdmin);

                textAdmin.setText("Contact admin");


                Button loginBtn = adminActivity.findViewById(R.id.btnSubmit);
                loginBtn.performClick();
                //assertTrue(loginActivity.loginapi());
            }
        });
    }
