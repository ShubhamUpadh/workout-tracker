package com.GymProject.WorkoutTracker.model;

import jakarta.persistence.*;

@Entity
public class muscle_targeted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id", referencedColumnName = "id", nullable = false)
    private exercises exercise;
    private String muscle_name;

    public muscle_targeted() {
    }

    public muscle_targeted(exercises exercise, String muscle_name) {
        this.exercise = exercise;
        this.muscle_name = muscle_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public exercises getExercise() {
        return exercise;
    }

    public void setExercise(exercises exercise) {
        this.exercise = exercise;
    }

    public String getMuscle_name() {
        return muscle_name;
    }

    public void setMuscle_name(String muscle_name) {
        this.muscle_name = muscle_name;
    }
}
