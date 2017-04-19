package com.example.derek.workouttracker20;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageButton;

public class Homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        otherFunctions_launcher();

        SettingsLauncher();

    }

    public ImageButton otherFunctions_button;

    public void otherFunctions_launcher()
    {
        otherFunctions_button = (ImageButton)findViewById(R.id.imageButton_otherFunctions);
        otherFunctions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Homescreen.this, OtherFunctions.class);
                startActivity(myIntent);
            }
        });
    }



    public ImageButton Settings_Button;

    public void SettingsLauncher()
    {
        Settings_Button=(ImageButton)findViewById(R.id.SettingsButton);
        Settings_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LaunchSettings = new Intent(Homescreen.this, SettingsActivity.class);
                startActivity(LaunchSettings);
            }
        });

    }

}
