package com.example.derek.workouttracker20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WeightRecord extends AppCompatActivity {

    public Button recordWorkoutLifting;
    public void weightRecord_launcher()
    {
        recordWorkoutLifting = (Button)findViewById(R.id.recordWorkoutLifting);
        recordWorkoutLifting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(WeightRecord.this, Homescreen.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_record);
        weightRecord_launcher();
    }
}
