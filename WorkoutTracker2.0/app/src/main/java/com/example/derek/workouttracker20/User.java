package com.example.derek.workouttracker20;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

    String firstName, lastName, email, username;
    protected String password;
    ArrayList<JogRecord> jogs;
    ArrayList<WeightRecord> weights;
    float weight = 0; //in lbs
    float height = 0; //in inches
    float BMI = 0;

    //constructor
    public User(String username, String password)
    {
        weights = new ArrayList<WeightRecord>();
        jogs = new ArrayList<JogRecord>();
        this.username = username;
        this.password = password;
    }

    //Secondary Constructor for SignUp
    public User(String password, String username, String firstName, String lastName,
                String email)
    {
        weights = new ArrayList<WeightRecord>();
        jogs = new ArrayList<JogRecord>();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //Getters
    public String getUsername()
    {
        return this.username;
    }

    protected String getPassword()
    {
        return this.password;
    }

    public String getFirstName(){ return this.firstName;  }

    public String getLastName() { return this.lastName; }

    public String getEmail() { return this.email; }

    public User getCurrentUser(){
        return this;
    }

    public float getWeight() { return this.weight; }

    public float getHeight() { return this.height; }

    public float getBMI() { return this.BMI; }

    //Setters
    public void setWeight(float newWeight)
    {
        this.weight = newWeight;
    }

    public void setHeight(float newHeight)
    {
        this.weight = newHeight;
    }

    public void setJogs(JogRecord newJogs){
        this.jogs.add(newJogs);
    }
    public void setWeights(WeightRecord newWeights) {
        this.weights.add(newWeights);
    }
    public void setBMI(float bmi) {
        this.BMI = bmi;
    }
    public void setFirstName(String fName){
        this.firstName = fName;

    }
    public void setLastName(String lName){
        this.lastName = lName;
    }
}
