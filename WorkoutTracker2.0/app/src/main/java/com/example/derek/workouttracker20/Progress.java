package com.example.derek.workouttracker20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Progress extends AppCompatActivity {

    ListView listViewProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        // Code to open any functions activity when a button is clicked
        listViewProgress = (ListView) findViewById(R.id.list);
        String[] values = new String[]{"Pull ups:           3-8", "Push ups:         5-15", "Bench Press:    6-8", "Butterflies:        4-10",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.activity_list_item, android.R.id.text1, values);

        listViewProgress.setAdapter(adapter);
    }
}
