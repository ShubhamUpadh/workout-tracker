package com.GymProject.WorkoutTracker.repository;

import com.GymProject.WorkoutTracker.model.performances;
import com.GymProject.WorkoutTracker.model.workout_sets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerformanceRepository extends JpaRepository<performances, Integer> {
    @Query("SELECT p FROM performances p WHERE p.workout_Sets = :workoutSet AND p.set_no = :setNo")
    Optional<performances> findByWorkoutSetAndSetNo(workout_sets workoutSet, int setNo);

}
