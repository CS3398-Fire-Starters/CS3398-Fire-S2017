package com.example.universal.working;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class Record extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jog_record);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // To be populated when workouts are decided later
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "To be replaced when feature added", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // To be added when workouts are decided later
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jog_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //function to be changed once connected to profile
    //simple place holder for xml code
    public float getWeight(float weight){
        return weight;
    }

    //function to be changed once connected to profile
    //simple place holder for xml code
    public float getRep(float rep){
        return rep;
    }
}
