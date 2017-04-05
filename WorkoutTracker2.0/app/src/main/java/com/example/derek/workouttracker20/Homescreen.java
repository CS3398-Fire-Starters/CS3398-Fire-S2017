package com.example.derek.workouttracker20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Homescreen extends AppCompatActivity {

    public ImageButton otherFunctions_button;

    public void otherFunctions_launcher(){
        otherFunctions_button = (ImageButton)findViewById(R.id.imageButton_otherFunctions);
                otherFunctions_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(Homescreen.this, OtherFunctions.class);
                                startActivity(myIntent);
                    }
                });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        otherFunctions_launcher();
    }




}
