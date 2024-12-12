package com.GymProject.WorkoutTracker.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class workout_sets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private users user;

    @ManyToOne
    @JoinColumn(name = "exercise_id", referencedColumnName = "id", nullable = false)
    private exercises exercise;

    private Date date;

    public workout_sets() {
    }

    public workout_sets(users user, exercises exercise, Date date) {
        this.user = user;
        this.exercise = exercise;
        this.date = date;
    }

    public workout_sets(Long userId, Long exerciseId, Date date) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    public exercises getExercise() {
        return exercise;
    }

    public void setExercise(exercises exercise) {
        this.exercise = exercise;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "workout_sets{" +
                "id=" + id +
                ", user=" + user +
                ", exercise=" + exercise +
                ", date=" + date +
                '}';
    }
}
