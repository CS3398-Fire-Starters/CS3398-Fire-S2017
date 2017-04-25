package com.example.derek.workouttracker20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class NewWorkout extends AppCompatActivity {

    public ImageButton liftingWorkout_button;
    public void weightRecord_launcher()
    {
        liftingWorkout_button = (ImageButton)findViewById(R.id.liftingWorkout);
        liftingWorkout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NewWorkout.this, WeightRecord.class);
                startActivity(myIntent);
            }
        });
    }

    public ImageButton cardioWorkout_button;
    public void jogRecord_launcher()
    {
        cardioWorkout_button = (ImageButton)findViewById(R.id.cardioWorkout);
        cardioWorkout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(NewWorkout.this, JogRecord.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);
        weightRecord_launcher();
        jogRecord_launcher();

    }
}
