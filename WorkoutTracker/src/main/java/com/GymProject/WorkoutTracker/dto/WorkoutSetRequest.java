package com.GymProject.WorkoutTracker.dto;

import java.sql.Date;

public class WorkoutSetRequest {
    private Long user_id;
    private Long exercise_id;
    private Date date;
    private int set_no;
    private double weight;
    private int reps;

    public WorkoutSetRequest() {}

    public WorkoutSetRequest(Long user_id, Long exercise_id, Date date, int set_no, double weight, int reps) {
        this.user_id = user_id;
        this.exercise_id = exercise_id;
        this.date = date;
        this.set_no = set_no;
        this.weight = weight;
        this.reps = reps;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Long exercise_id) {
        this.exercise_id = exercise_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSet_no() {
        return set_no;
    }

    public void setSet_no(int set_no) {
        this.set_no = set_no;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
