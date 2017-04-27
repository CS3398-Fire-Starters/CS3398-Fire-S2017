package com.example.derek.workouttracker20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JogRecord extends AppCompatActivity {

    public Button recordWorkoutCardio;
    public void jogRecord_launcher()
    {
        recordWorkoutCardio = (Button)findViewById(R.id.recordWorkoutCardio);
        recordWorkoutCardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(JogRecord.this, Homescreen.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jog_record);
        jogRecord_launcher();
    }
}
