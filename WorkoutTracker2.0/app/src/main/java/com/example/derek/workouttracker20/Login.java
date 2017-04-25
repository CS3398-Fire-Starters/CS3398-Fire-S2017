package com.example.derek.workouttracker20;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Login extends Activity implements View.OnClickListener
{
    private EditText user, pass;
    public Button regB;
    public Button loginB;
    private ProgressDialog pDialog;
    private ArrayList userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = (EditText)findViewById(R.id.userText);
        pass = (EditText)findViewById(R.id.passwordText);

        loginB = (Button)findViewById(R.id.login);
        loginB.setOnClickListener(this);

        regB = (Button)findViewById(R.id.register);
        regB.setOnClickListener(this);
        //Requesting Permissions
        ActivityCompat.requestPermissions(Login.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                1);
        ActivityCompat.requestPermissions(Login.this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                2);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.login:
                new AttemptLogin().execute();
            case R.id.register:
                Intent startReg = new Intent(Login.this, SignupActivity.class);
                startActivity(startReg);
            default:
                break;
        }
    }

    private void saveData(ArrayList<User> userList)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("savedUsers.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
            fos.close();
            System.out.println("savedUsers.txt written to disk.");
        }
        catch(Exception err)
        {
            System.out.println(err);
        }
    }

    private ArrayList<User> loadData()
    {
        ArrayList<User> loadData = null;
        try
        {
            FileInputStream fis = new FileInputStream("savedUsers.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            loadData = (ArrayList<User>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch(Exception err)
        {
            System.out.println(err);
        }
        return loadData;
    }

    class AttemptLogin extends AsyncTask<String, String, String>
    {
        //Before Starting Background Thread, begin progress dialog.
        boolean failure = false;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(Login.this);
            pDialog.setMessage("Attempting login...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        protected void onPostExecute(String message)
        {
            pDialog.dismiss();
        }

        @Override
        protected String doInBackground(String... args)
        {
            ArrayList<User> savedUsers = new ArrayList<User>();
            //Check for success tag.
            boolean success = false;
            String username = user.getText().toString();
            String password = pass.getText().toString();
            User newUser = new User(username, password);

            userList.add(newUser);

            //Cant get it to save as file on phone. I really don't like Android.
           // savedUsers = loadData();

            if(userList.contains(newUser))
            {
              success = true;
            }

            if(success == true)
            {
                Intent startHome = new Intent(Login.this, Homescreen.class);
                finish();
                startActivity(startHome);
                Toast.makeText(Login.this, "Successful Login!",
                        Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(Login.this, "LOGIN FAILURE",
                        Toast.LENGTH_LONG).show();
            }
            return "Done!";
        }

    }

    //Requesting Permission Method
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                           int[] grantResults)
    {
        switch (requestCode)
        {
            case 1:
            {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {                }
                else
                {                }
                return;
            }
            case 2:
            {
                if(grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {                }
                else
                {                }
                return;
            }
        }
    }
}