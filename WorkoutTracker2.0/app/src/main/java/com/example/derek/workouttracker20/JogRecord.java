package com.example.derek.workouttracker20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JogRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jog_record);
        final Intent getUser = getIntent();
        final User curUser = (User)getUser.getSerializableExtra("curUser");
    }
}
