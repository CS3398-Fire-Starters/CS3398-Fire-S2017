package com.example.derek.workouttracker20;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;

import studios.codelight.smartloginlibrary.SmartLoginBuilder;
import studios.codelight.smartloginlibrary.SmartLoginConfig;
import studios.codelight.smartloginlibrary.users.SmartFacebookUser;
import studios.codelight.smartloginlibrary.users.SmartGoogleUser;
import studios.codelight.smartloginlibrary.users.SmartUser;

import static android.app.Activity.RESULT_CANCELED;

// Created by JW1762 on 3/30/2017.

public class Client
{
    ArrayList<String> PERMISSIONS = new ArrayList<>();

    SmartLoginBuilder loginBuilder = new SmartLoginBuilder();
    Intent intent = loginBuilder.with(context)
            .setAppLogo(1)//APP_LOGO true
            .isFacebookLoginEnabled(true).withFacebookAppId("APP_ID")
            .withFacebookPermissions(PERMISSIONS)
            .isGoogleLoginEnabled(true)
            .build();

    startActivityForResult(intent, SmartLoginConfig.LOGIN_REQUEST);

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