package com.example.derek.workouttracker20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Homescreen extends AppCompatActivity {
/*
    public ImageButton Walk_Button;
    public void WalkingLauncher()
    {
        Walk_Button = (ImageButton)findViewById(R.id.WalkButton);
        Walk_Button.setOnClickListener()
        {
            Intent LaunchWalking = new Intent(Homescreen.this, WalkingActivity.class);
            startActivity(LaunchWalking);
        };
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
       // WalkingLauncher();//For implementation of butotn logic.
    }
}
