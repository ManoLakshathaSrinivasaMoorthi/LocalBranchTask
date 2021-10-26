package com.example.myapplication.activity;

public class ActivityHospitalListTest {

    @Rule
    public ActivityTestRule<ActivityHospitalList> mActivityTestRule = new ActivityTestRule<ActivityHospitalList>(ActivityHospitalList.class);

    public ActivityHospitalList hospitalList;

    @Before
    public void setUp() throws Exception {
        hospitalList= mActivityTestRule.getActivity();
    }

    @Test
    public void setHospitalList(){
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                SearchView searchView = hospitalList.findViewById(R.id.searchHospital);
                //searchView.setActivated(true);
                //  searchView.setQueryHint(getResources().getString(R.string.search_hospital));
              /* searchView.onActionViewExpanded();
               searchView.setIconified(false);
             searchView.clearFocus();

          searchView.setMaxWidth(Integer.MAX_VALUE);*/
                //searchView.setInputType(1);

                // EditText gender = patientAppointmentActivity.findViewById(R.id.id_last_name);



                //assertTrue(loginActivity.loginapi());
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        hospitalList = null;
    }
}
