package com.dundyne.androidworkout.exercises;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RepetitiveExercise {
        String name;
        ArrayList<Integer> repetitions = new ArrayList<>();

    public RepetitiveExercise(){

    }

    public RepetitiveExercise(String name, ArrayList repetitions){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(ArrayList<Integer> repetitions) {
        this.repetitions = repetitions;
    }
}
