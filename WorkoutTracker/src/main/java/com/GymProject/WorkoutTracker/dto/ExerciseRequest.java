package com.GymProject.WorkoutTracker.dto;

import jakarta.persistence.Entity;
//POJO
public class ExerciseRequest {
    private String exercise_name;
    private String type;
    private String description;
    private String muscle_name;

    public ExerciseRequest() {}

    public ExerciseRequest(String exercise_name, String type, String description, String muscle_name) {
        this.exercise_name = exercise_name;
        this.type = type;
        this.description = description;
        this.muscle_name = muscle_name;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMuscle_name() {
        return muscle_name;
    }

    public void setMuscle_name(String muscle_name) {
        this.muscle_name = muscle_name;
    }

    @Override
    public String toString() {
        return this.exercise_name + " " + this.muscle_name + " " + this.type + " " + this.description;
    }
}
