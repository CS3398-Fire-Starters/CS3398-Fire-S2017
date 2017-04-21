package com.example.derek.workouttracker20;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Login extends Activity implements View.OnClickListener{

    private EditText user, pass;
    public Button regB;
    public Button loginB;
    private ProgressDialog pDialog;

    JSONParser jsonParser = new JSONParser();

    private static final String LOGIN_URL = "app-1492722448.000webhostapp.com/index.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

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
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.login:
                new AttemptLogin().execute();
            case R.id.register:
                //new regUser().execute();
            default:
                break;
        }
    }
/*
    class regUser extends AsyncTask<String, String, String>{
        boolean failure = false;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(Login.this);
            pDialog.setMessage("Registering Account...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
    }
*/


    class AttemptLogin extends AsyncTask<String, String, String> {
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

        @Override
        protected String doInBackground(String... args){
            //Check for success tag.
            int success;
            String username = user.getText().toString();
            String password = pass.getText().toString();
            try{
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username", username));
                params.add(new BasicNameValuePair("password", password));
                Log.d("request!", "starting");

                JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", params);

                //Check for JSON Response.
                Log.d("Login attempt", json.toString());

                //Success tag for JSON.
                success = json.getInt(TAG_SUCCESS);
                if(success == 1)
                {
                    Log.d("Successfull login!", json.toString());
                    Intent ii = new Intent(Login.this, Homescreen.class);
                    finish();
                    startActivity(ii);
                    return json.getString(TAG_MESSAGE);
                }
                else
                {
                    return json.getString(TAG_MESSAGE);
                }
            } catch (JSONException e){
                e.printStackTrace();
            }
            return null;
        }

        //Now we dismiss Progress Dialog Box.
        protected void onPostExecute(String message){
            pDialog.dismiss();
            if (message != null){
                Toast.makeText(Login.this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}