package com.example.myapplication.activity;

public class RemoteProviderSecondScreenActivityTest {


    @Rule
    public ActivityScenarioRule<RemoteProviderSignUpSecond> activityRule
            = new ActivityScenarioRule<>(RemoteProviderSignUpSecond.class);
    public RemoteProviderSignUpSecond remoteProviderSignUpSecond;


    @Test
    public void checkDisplayed() {
        onView(withId(R.id.id_create_profile_txt)).check(matches(isDisplayed()));
        onView(withId(R.id.id_remote_provider_spinner)).check(matches(isDisplayed()));
        onView(withId(R.id.id_npi_number)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_terms_and_condition)).check(matches(isDisplayed()));
        onView(withId(R.id.btnNext)).check(matches(isDisplayed()));
        onView(withId(R.id.checkbox)).check(matches(isDisplayed()));

    }

    @Test
    public void signUpRemote() {

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                CustomErrorEditText npiNumber = remoteProviderSignUpSecond.findViewById(R.id.id_npi_number);
                npiNumber.setText("1234567890");
                CheckBox checkBox = remoteProviderSignUpSecond.findViewById(R.id.checkbox);
                checkBox.isChecked();

                Button btnNext = remoteProviderSignUpSecond.findViewById(R.id.btnNext);
                btnNext.performClick();
                //assertTrue(loginActivity.loginapi());
            }
        });

    }


    @After
    public void tearDown() throws Exception {
        remoteProviderSignUpSecond = null;
    }

}