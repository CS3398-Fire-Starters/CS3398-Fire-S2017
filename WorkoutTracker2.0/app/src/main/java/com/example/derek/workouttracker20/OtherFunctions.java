package com.example.derek.workouttracker20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OtherFunctions  extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_functions);
        final Intent getUser = getIntent();
        final User curUser = (User)getUser.getSerializableExtra("curUser");

        // Code to open any functions activity when a button is clicked
        listView = (ListView) findViewById(R.id.list);
        String[] values = new String[]{"BMI Calculator", "Stopwatch",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.activity_list_item, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), BMICalculator.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Stopwatch.class);
                    startActivityForResult(myIntent, 0);
                }

            }
        });
    }
}

