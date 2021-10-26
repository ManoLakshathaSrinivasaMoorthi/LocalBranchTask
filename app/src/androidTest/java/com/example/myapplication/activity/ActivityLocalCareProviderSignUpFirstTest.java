package com.example.myapplication.activity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ActivityLocalCareProviderSignUpFirstTest {

    @Rule
    public ActivityTestRule<ActivityLocalCareProviderSignUpFirst> testRule= new ActivityTestRule<>(ActivityLocalCareProviderSignUpFirst.class);
    private ActivityLocalCareProviderSignUpFirst localCareProviderSignUpFirst;

    @Before
    public void setUp() throws Exception {
        localCareProviderSignUpFirst=testRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        localCareProviderSignUpFirst=null;
    }

    @Test
    public void checkFirstName() {
        //init input text with a string HELLO
        onView(withId(R.id.id_first_name)).perform(ViewActions.typeText("TestBp"), ViewActions.closeSoftKeyboard());

    }
}
