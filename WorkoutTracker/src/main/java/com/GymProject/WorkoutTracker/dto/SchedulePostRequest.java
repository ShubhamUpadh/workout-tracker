package com.GymProject.WorkoutTracker.dto;


import java.util.List;

//POJO
public class SchedulePostRequest {
    private int user_id;
    private String day_of_week;
    private List<Integer> exercise_id;
    private List<Integer> sets;
    private String schedule_name;

    public SchedulePostRequest() {
    }

    public SchedulePostRequest(int user_id, String day_of_week, List<Integer> exercise_id,
                               List<Integer> sets, String schedule_name) {
        this.user_id = user_id;
        this.day_of_week = day_of_week;
        this.exercise_id = exercise_id;
        this.sets = sets;
        this.schedule_name = schedule_name;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public List<Integer> getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(List<Integer> exercise_id) {
        this.exercise_id = exercise_id;
    }

    public List<Integer> getSets() {
        return sets;
    }

    public void setSets(List<Integer> sets) {
        this.sets = sets;
    }

    public String getSchedule_name() {
        return schedule_name;
    }

    public void setSchedule_name(String schedule_name) {
        this.schedule_name = schedule_name;
    }



    @Override
    public String toString() {
        return "SchedulePostRequest{" +
                "user_id=" + user_id +
                ", day_of_week=" + day_of_week +
                ", exercise_id=" + exercise_id +
                ", sets=" + sets +
                ", schedule_name='" + schedule_name + '\'' +
                '}';
    }

}
