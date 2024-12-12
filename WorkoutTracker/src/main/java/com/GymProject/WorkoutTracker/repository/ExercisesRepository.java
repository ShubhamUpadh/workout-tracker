package com.GymProject.WorkoutTracker.repository;

import com.GymProject.WorkoutTracker.model.exercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ExercisesRepository extends JpaRepository<exercises,Long> {
}
