package com.example.derek.workouttracker20;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

    String username;
    protected String password;
    ArrayList<JogRecord> jogs;
    ArrayList<WeightRecord> weights;

    public User(String password, String username)
    {
        weights = new ArrayList<WeightRecord>();
        jogs = new ArrayList<JogRecord>();
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    protected String getPassword()
    {
        return password;
    }

    public User getCurrentUser(){
        return this;
    }


}
