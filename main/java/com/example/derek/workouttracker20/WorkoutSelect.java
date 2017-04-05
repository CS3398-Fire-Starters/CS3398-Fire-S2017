package com.example.derek.workouttracker20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class WorkoutSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btnWrkout = (Button) findViewById(R.id.WeightLiftbtn);
        btnWrkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutSelect.this,WeightRecord.class));
            }
        });

        Button btnjog = (Button) findViewById(R.id.jogWorkoutBtn);
        btnjog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkoutSelect.this,JogRecord.class));
            }
        });
    }

}
