package com.example.derek.workouttracker20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SettingsActivity extends AppCompatActivity {

    private EditText weight;
    private EditText feet;
    private EditText inches;
    private TextView ShowUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        feet = (EditText) findViewById(R.id.Edit_Feet);
        inches = (EditText) findViewById(R.id.Edit_inches);
        weight = (EditText) findViewById(R.id.weight);
        ShowUser = (TextView) findViewById(R.id.Show_User);
        //ShowUser = User.getUsername();
    }

    public void UpdateSettings(View v) {
        String weightStr = weight.getText().toString();
        String feetStr = feet.getText().toString();
        String inchesStr = inches.getText().toString();

        //String ShowUser = getCurrentUser();
        //this should be possible with Serializable but I'm having
        //trouble figuring out how

        float feetValue = Float.parseFloat(feetStr);
        float inchesValue = Float.parseFloat(inchesStr);
        float weightValue = Float.parseFloat(weightStr);
    }
}
