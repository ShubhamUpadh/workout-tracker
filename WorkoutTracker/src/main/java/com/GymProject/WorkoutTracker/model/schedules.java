package com.GymProject.WorkoutTracker.model;
import com.GymProject.WorkoutTracker.model.exercise_schedules;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private users Users;

    private String day_of_week;

    @OneToMany(mappedBy = "Schedules", cascade = CascadeType.ALL)
    private List<exercise_schedules> exercise_schedules;

    private String schedule_name;

    public schedules() {
    }

    public schedules(int id, users users, String day_of_week,
                     List<exercise_schedules> exercise_schedules, String schedule_name) {
        this.id = id;
        Users = users;
        this.day_of_week = day_of_week;
        this.exercise_schedules = exercise_schedules;
        this.schedule_name = schedule_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public users getUsers() {
        return Users;
    }

    public void setUsers(users users) {
        Users = users;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public List<exercise_schedules> getExercise_schedules() {
        return exercise_schedules;
    }

    public void setExercise_schedules(List<exercise_schedules> exercise_schedules) {
        this.exercise_schedules = exercise_schedules;
    }

    public String getSchedule_name() {
        return schedule_name;
    }

    public void setSchedule_name(String schedule_name) {
        this.schedule_name = schedule_name;
    }

    @Override
    public String toString() {
        return "schedules{" +
                "id=" + id +
                ", Users=" + Users +
                ", day_of_week='" + day_of_week + '\'' +
                ", exercise_schedules=" + exercise_schedules +
                ", schedule_name='" + schedule_name + '\'' +
                '}';
    }
}