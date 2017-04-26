package com.example.derek.workouttracker20;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class Homescreen extends AppCompatActivity {

    ListView listViewHome;

    public ImageButton otherFunctions_button;
    public void otherFunctions_launcher()
    {
        otherFunctions_button = (ImageButton)findViewById(R.id.imageButton_otherFunctions);
        otherFunctions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Homescreen.this, OtherFunctions.class);
                startActivity(myIntent);
            }
        });
    }

    public ImageButton Settings_Button;
    public void SettingsLauncher()
    {
        Settings_Button=(ImageButton)findViewById(R.id.SettingsButton);
        Settings_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LaunchSettings = new Intent(Homescreen.this, SettingsActivity.class);
                startActivity(LaunchSettings);
            }
        });
    }

    public ImageButton addWorkout_button;
    public void addWorkout_launcher()
    {
        addWorkout_button = (ImageButton)findViewById(R.id.imageButton_addWorkout);
        addWorkout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Homescreen.this, NewWorkout.class);
                startActivity(myIntent);
            }
        });
    }

    public ImageButton progress_button;
    public void progress_launcher()
    {
        progress_button = (ImageButton)findViewById(R.id.imageButton_progress);
        progress_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Homescreen.this, Progress.class);
                startActivity(myIntent);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        //Receives the user object from Signup or Login.
        Intent getUser = getIntent();
        User curUser = (User)getUser.getSerializableExtra("curUser");

        otherFunctions_launcher();
        SettingsLauncher();
        addWorkout_launcher();
        progress_launcher();

        // Code to open any functions activity when a button is clicked
        listViewHome = (ListView) findViewById(R.id.listView);
        String[] values = new String[]{"Pull ups:           3-8", "Push ups:         5-15", "Bench Press:    6-8", "Butterflies:        4-10",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.activity_list_item, android.R.id.text1, values);

        listViewHome.setAdapter(adapter);
    }

}