package com.example.derek.workouttracker20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculator extends AppCompatActivity {

    private EditText weight;
    private EditText feet;
    private EditText inches;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);
        final Intent getUser = getIntent();
        final User curUser = (User)getUser.getSerializableExtra("curUser");
        feet = (EditText) findViewById(R.id.feet);
        inches = (EditText) findViewById(R.id.inches);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
    }

    public void calculateBMI(View v) {
        String weightStr = weight.getText().toString();
        String feetStr = feet.getText().toString();
        String inchesStr = inches.getText().toString();

        float feetValue = Float.parseFloat(feetStr);
        float inchesValue = Float.parseFloat(inchesStr);
        float weightValue = Float.parseFloat(weightStr);
        float heightValue = ((feetValue * 12)+ inchesValue);
        float bmi = (weightValue * 703) / (heightValue * heightValue);

        displayBMI(bmi);
    }

    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 18.5f) < 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) >= 0  &&  Float.compare(bmi, 24.9f) <= 0) {
            bmiLabel = getString(R.string.normal_weight);
        } else if (Float.compare(bmi, 25f) >= 0  &&  Float.compare(bmi, 29.9f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else {
            bmiLabel = getString(R.string.obese);
        }

        bmiLabel = "BMI: " + bmi + "\n" + bmiLabel;
        result.setText(bmiLabel);
    }
}