package com.GymProject.WorkoutTracker.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "exercise_schedules")
public class exercise_schedules {

//    @Autowired

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "exercise_id", referencedColumnName = "id", nullable = false)
    private exercises Exercises;

    @ManyToOne
    @JoinColumn(name="schedule_id", referencedColumnName = "id", nullable = false)
    private schedules Schedules;

    private int sets;

    public exercise_schedules(exercises exercises, schedules schedules, int sets) {
        this.Exercises = exercises;
        this.Schedules = schedules;
        this.sets = sets;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    @Override
    public String toString() {
        return "exercise_schedules{" +
                "id=" + id +
                ", Exercises=" + Exercises +
                ", Schedules=" + Schedules +
                ", sets=" + sets +
                '}';
    }

    public exercise_schedules() {
    }

    public exercises getExercises() {
        return Exercises;
    }

    public void setExercises(exercises exercises) {
        Exercises = exercises;
    }

    public schedules getSchedules() {
        return Schedules;
    }

    public void setSchedules(schedules schedules) {
        Schedules = schedules;
    }

}
