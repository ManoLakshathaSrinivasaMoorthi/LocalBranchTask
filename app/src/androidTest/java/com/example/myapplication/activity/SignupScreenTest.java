package com.example.myapplication.activity;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

import android.app.Activity;
import android.app.Instrumentation;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class SignupActivityTest {
    @Rule
    // public ActivityScenarioRule<SignupActivity> testRule= new ActivityScenarioRule<SignupActivity>(SignupActivity.class);
    public ActivityTestRule<SignupActivity> testRule=new ActivityTestRule<SignupActivity>(SignupActivity.class);
    private SignupActivity signupActivity;
    Instrumentation.ActivityMonitor monitor=getInstrumentation().addMonitor(ActivityLocalCareProviderSignUpFirst.class.getName(),null,false);
    @Before
    public void setUp() throws Exception {
        //  testRule.getScenario().moveToState(Lifecycle.State.STARTED);
        signupActivity=testRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        signupActivity=null;
    }

    @Test
    public  void oncheckIntent(){
        assertNotNull(signupActivity.findViewById(R.id.remoteProviderContainer));
        onView(withId(R.id.remoteProviderContainer)).perform(click());
        Activity lcp=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(lcp);
        lcp.finish();

    }
}