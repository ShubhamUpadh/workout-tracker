package com.GymProject.WorkoutTracker.model;

import jakarta.persistence.*;

@Entity
public class performances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "workout_set_id", referencedColumnName = "id", nullable = false)
    private workout_sets workout_Sets;

    private int set_no;
    private double weight;
    private int reps;

    public performances(workout_sets workout_Sets, int set_no, double weight, int reps) {

        this.workout_Sets = workout_Sets;
        this.set_no = set_no;
        this.weight = weight;
        this.reps = reps;
    }

    public performances() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public workout_sets getWorkout_Sets() {
        return workout_Sets;
    }

    public void setWorkout_Sets(workout_sets workout_Sets) {
        this.workout_Sets = workout_Sets;
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

    @Override
    public String toString() {
        return "performances{" +
                "workout_Sets=" + workout_Sets +
                ", set_no=" + set_no +
                ", weight=" + weight +
                ", reps=" + reps +
                '}';
    }
}
