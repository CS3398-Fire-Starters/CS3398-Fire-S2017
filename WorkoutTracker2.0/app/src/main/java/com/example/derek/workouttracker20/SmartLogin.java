package com.example.derek.workouttracker20;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import studios.codelight.smartloginlibrary.SmartLoginActivity;
import studios.codelight.smartloginlibrary.SmartLoginBuilder;
import studios.codelight.smartloginlibrary.SmartLoginConfig;
import studios.codelight.smartloginlibrary.users.SmartFacebookUser;
import studios.codelight.smartloginlibrary.users.SmartGoogleUser;
import studios.codelight.smartloginlibrary.users.SmartUser;

//Created by JW1762 on 3/30/2017.
public class SmartLogin extends AppCompatActivity
{
    //This is supposed to build the LoginPage for the user.
    //startActivity however is broken.
    Context context;
    ArrayList<String> PERMISSIONS = new ArrayList<>();

    SmartLoginBuilder loginBuilder = new SmartLoginBuilder();
    Intent intent = loginBuilder.with(context)//(this)?
            .setAppLogo(1)//APP_LOGO true
            .isFacebookLoginEnabled(true).withFacebookAppId("APP_ID")//Need FB App_id
            .withFacebookPermissions(PERMISSIONS)
            .isGoogleLoginEnabled(true)
            .build();
    //startActivityForResult(intent, SmartLoginConfig.LOGIN_REQUEST);
    //This is disallowing compilation. Unknown how to fix.

    //I dont know if onClick or onCreate is actually needed...
    public void onClick(View v){
        //Intent intent = loginBuilder.with(context)//(this)?
        startActivityForResult(intent, SmartLoginConfig.LOGIN_REQUEST);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(studios.codelight.smartloginlibrary.R.layout.activity_smart_login);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Intent "data" contains the user object
        if(resultCode == SmartLoginConfig.FACEBOOK_LOGIN_REQUEST){
            SmartFacebookUser user;
            try {
                user = data.getParcelableExtra(SmartLoginConfig.USER);
                //use this user object as per your requirement
            }catch (Exception e){
                Log.e(getClass().getSimpleName(), e.getMessage());
            }
        }else if(resultCode == SmartLoginConfig.GOOGLE_LOGIN_REQUEST){
            SmartGoogleUser user;
            try {
                user = data.getParcelableExtra(SmartLoginConfig.USER);
                //use this user object as per your requirement
            }catch (Exception e){
                Log.e(getClass().getSimpleName(), e.getMessage());
            }
        }else if(resultCode == SmartLoginConfig.CUSTOM_LOGIN_REQUEST){
            SmartUser user = data.getParcelableExtra(SmartLoginConfig.USER);
            //use this user object as per your requirement
        }else if(resultCode == RESULT_CANCELED){
            //Login Failed
        }
    }
}
