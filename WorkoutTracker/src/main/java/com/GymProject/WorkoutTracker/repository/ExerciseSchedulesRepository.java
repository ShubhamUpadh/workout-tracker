package com.GymProject.WorkoutTracker.repository;
import com.GymProject.WorkoutTracker.model.exercise_schedules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseSchedulesRepository extends
        JpaRepository<exercise_schedules, Integer> {
}
