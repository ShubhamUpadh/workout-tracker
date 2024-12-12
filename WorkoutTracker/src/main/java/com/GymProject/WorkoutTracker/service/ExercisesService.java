package com.GymProject.WorkoutTracker.service;

import com.GymProject.WorkoutTracker.model.exercises;
import com.GymProject.WorkoutTracker.repository.ExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercisesService {

    @Autowired
    ExercisesRepository exercisesRepository;

    public Optional<exercises> findExerciseById(Long exerciseId) {
        return exercisesRepository.findById(exerciseId);
    }


    public List<exercises> getExercises() {
        List<exercises> exercises =  exercisesRepository.findAll();
        System.out.println(exercises);
        return exercises;
    }

    public exercises addExercises(exercises exercise) {
        System.out.println("@Service class");
        return exercisesRepository.save(exercise);
    }

    public void deleteAllExercise() {
        exercisesRepository.deleteAll();
    }
}
