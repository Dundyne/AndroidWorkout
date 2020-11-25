package com.dundyne.androidworkout.exercises;

import java.util.ArrayList;

public class StaticExercise {
    String name;
    ArrayList<Integer> timeInSeconds = new ArrayList<>();

    public StaticExercise(){

    }

    public StaticExercise(String name, ArrayList timeInSeconds){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(ArrayList<Integer> timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }
}
