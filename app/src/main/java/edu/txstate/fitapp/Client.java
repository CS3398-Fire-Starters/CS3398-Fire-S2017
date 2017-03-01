package edu.txstate.FitApp;

import android.content.Intent;
import android.util.Log;

import studios.codelight.smartloginlibrary.SmartCustomLoginListener;
import studios.codelight.smartloginlibrary.SmartLoginBuilder;
import studios.codelight.smartloginlibrary.SmartLoginConfig;
import studios.codelight.smartloginlibrary.users.SmartUser;

public class Client {

    SmartLoginBuilder loginBuilder = new SmartLoginBuilder();
    Intent intent = loginBuilder.with(context)
            .setAppLogo(APP_LOGO)
            .isFacebookLoginEnabled(true).withFacebookAppId("APP_ID")
            .withFacebookPermissions(PERMISSIONS)
            .isGoogleLoginEnabled(true)
            .build();
    startActivityForResult(intent, SmartLoginConfig.LOGIN_REQUEST);

    SmartCustomLoginListener loginListener = new SmartCustomLoginListener() {
        @Override
        public boolean customSignin(SmartUser smartUser) {
            //do something with smartUser
            if(SUCCESS){
                return true;
            } else {
                return false;
            }
        }
        @Override
        public boolean customSignup(SmartUser smartUser) {
            //do something with smartUser
            if(SUCCESS){
                return true;
            } else {
                return false;
            }
        }
        @Override
        public boolean customUserSignout(SmartUser smartUser) {
            //do something with smartUser
            if(SUCCESS){
                return true;
            } else {
                return false;
            }
        }
    };

    Intent intent = loginBuilder.with(context)
            .isCustomLoginEnabled(true).setSmartCustomLoginHelper(loginListener)
            .build();
    startActivityForResult(intent, SmartLoginConfig.LOGIN_REQUEST);
}