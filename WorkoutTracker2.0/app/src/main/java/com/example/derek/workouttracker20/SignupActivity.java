package com.example.derek.workouttracker20;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity
{

    EditText firstName, lastName, email, password, passwordVerify, username;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        submitButton = (Button)findViewById(R.id.submit_button);
        password = (EditText)findViewById(R.id.password);
        passwordVerify = (EditText)findViewById(R.id.verify_password);
        email = (EditText)findViewById(R.id.email);
        firstName = (EditText)findViewById(R.id.firstName);
        lastName = (EditText)findViewById(R.id.lastName);
        username = (EditText)findViewById(R.id.username);

        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                boolean found = false;
                String fName = firstName.getText().toString(),
                        lName = lastName.getText().toString(),
                        emailStr = email.getText().toString(),
                        pass = password.getText().toString(),
                        verifyPass = passwordVerify.getText().toString(),
                        user = username.getText().toString();

                if (pass.equals("") && verifyPass.equals(""))
                {
                    Toast.makeText(SignupActivity.this, "Please Enter a Valid Password", Toast.LENGTH_LONG).show();
                }
                if (!pass.equals(verifyPass))
                {
                    Toast.makeText(SignupActivity.this, "Passwords Do Not Match, Please Enter Matching Passwords", Toast.LENGTH_LONG).show();
                    password.setText(null);
                    passwordVerify.setText(null);
                }

                if (!emailStr.contains("@") || !emailStr.contains(".com"))
                {
                    Toast.makeText(SignupActivity.this, "Please Enter a Valid Email", Toast.LENGTH_LONG).show();
                    email.setText(null);
                }

                if (fName.matches("[a-zA-Z]"))
                {
                    Toast.makeText(SignupActivity.this, "Please Enter a Valid First Name", Toast.LENGTH_LONG).show();
                }

                if (lName.matches("[a-zA-Z]"))
                {
                    Toast.makeText(SignupActivity.this, "Please Enter a Valid Last Name", Toast.LENGTH_LONG).show();
                }
                if(pass.equals(verifyPass)
                        && (emailStr.contains("@") || emailStr.contains(".com"))
                        && !fName.matches("[a-zA-Z]") && !lName.matches("[a-zA-Z]")
                        && !found)
                {
                Toast.makeText(SignupActivity.this, "User Successfully created", Toast.LENGTH_LONG).show();

                //Handle Saving User Data Here
                String sep = "|", str = sep+fName+sep+lName+sep+emailStr+sep;
                FileReaderWriter saveData = new FileReaderWriter(getApplicationContext());
                saveData.loginCreate("user/", user.toLowerCase(), pass, str);

                //Make and send user object to Homescreen page.
                User curUser = new User(user, pass, fName, lName, emailStr);
                final Intent sendUser = new Intent(SignupActivity.this, Homescreen.class);
                sendUser.putExtra("curUser", curUser);
                startActivity(sendUser);
            }
        }
    });
}
}