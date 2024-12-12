package com.GymProject.WorkoutTracker.repository;

import com.GymProject.WorkoutTracker.model.workout_sets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutSetRepository extends JpaRepository<workout_sets, Long> {
}
