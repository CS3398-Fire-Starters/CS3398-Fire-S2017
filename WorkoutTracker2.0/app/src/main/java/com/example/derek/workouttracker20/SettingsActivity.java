package com.example.derek.workouttracker20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SettingsActivity extends AppCompatActivity {

    private EditText weight;
    private EditText feet;
    private EditText newPassword;
    private EditText inches;
    private TextView ShowUser;
    private TextView ShowPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        feet = (EditText) findViewById(R.id.Edit_Feet);
        inches = (EditText) findViewById(R.id.Edit_inches);
        weight = (EditText) findViewById(R.id.weight);
        ShowUser = (TextView) findViewById(R.id.Show_User);
        ShowPassword = (TextView) findViewById(R.id.Show_Password);




    }

    public void UpdateSettings(View v) {
        Intent getUser = getIntent();
        User curUser = (User)getUser.getSerializableExtra("curUser");
        /*
        ShowUser.setText(curUser.getUsername().toString());
        ShowPassword.setText(curUser.getPassword.().toString());

        String weightStr = weight.getText().toString();
        String feetStr = feet.getText().toString();
        String inchesStr = inches.getText().toString();
        String newPasswordstr = newPassword.getText().toString();


        float feetValue = Float.parseFloat(feetStr);
        float inchesValue = Float.parseFloat(inchesStr);
        float weightValue = Float.parseFloat(weightStr);
        */
    }
}
