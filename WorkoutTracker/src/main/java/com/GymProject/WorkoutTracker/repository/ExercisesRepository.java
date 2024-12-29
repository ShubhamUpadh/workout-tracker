package com.GymProject.WorkoutTracker.repository;

import com.GymProject.WorkoutTracker.model.exercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface ExercisesRepository extends JpaRepository<exercises,Long> {
}
