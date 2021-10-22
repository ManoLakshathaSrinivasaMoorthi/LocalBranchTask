package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.DataModal;

import io.realm.Realm;

public class Realm_Db extends AppCompatActivity {
    // creating variables for our edit text
    private EditText courseNameEdt, courseDurationEdt, courseDescriptionEdt, courseTracksEdt;
    private Realm realm;

    // creating a strings for storing
    // our values from edittext fields.
    private String courseName, courseDuration, courseDescription, courseTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm__db);

        // initializing our edittext and buttons
        realm = Realm.getDefaultInstance();
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);

        // creating variable for button
        Button submitCourseBtn = findViewById(R.id.idBtnAddCourse);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        submitCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting data from edittext fields.
                courseName = courseNameEdt.getText().toString();
                courseDescription = courseDescriptionEdt.getText().toString();
                courseDuration = courseDurationEdt.getText().toString();
                courseTracks = courseTracksEdt.getText().toString();

                // validating the text fields if empty or not.
                if (TextUtils.isEmpty(courseName)) {
                    courseNameEdt.setError("Please enter Course Name");
                } else if (TextUtils.isEmpty(courseDescription)) {
                    courseDescriptionEdt.setError("Please enter Course Description");
                } else if (TextUtils.isEmpty(courseDuration)) {
                    courseDurationEdt.setError("Please enter Course Duration");
                } else if (TextUtils.isEmpty(courseTracks)) {
                    courseTracksEdt.setError("Please enter Course Tracks");
                } else {
                    // calling method to add data to Realm database..
                    addDataToDatabase(courseName, courseDescription, courseDuration, courseTracks);
                    Toast.makeText(Realm_Db.this, "Course added to database..", Toast.LENGTH_SHORT).show();
                    courseNameEdt.setText("");
                    courseDescriptionEdt.setText("");
                    courseDurationEdt.setText("");
                    courseTracksEdt.setText("");
                }
            }
        });
    }

    private void addDataToDatabase(String courseName, String courseDescription, String courseDuration, String courseTracks) {

        DataModal modal = new DataModal();

        //  getting id for the course which we are storing.
        Number id = realm.where(DataModal.class).max("id");

        long nextId;

        if (id == null) {
            nextId = 1;
        } else {

            nextId = id.intValue() + 1;
        }

        modal.setId(nextId);
        modal.setCourseDescription(courseDescription);
        modal.setCourseName(courseName);
        modal.setCourseDuration(courseDuration);
        modal.setCourseTracks(courseTracks);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realm.copyToRealm(modal);
            }
        });
    }
}
