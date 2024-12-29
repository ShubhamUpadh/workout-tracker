package com.GymProject.WorkoutTracker.repository;
import com.GymProject.WorkoutTracker.model.exercise_schedules;
import com.GymProject.WorkoutTracker.model.exercises;
import com.GymProject.WorkoutTracker.model.users;
import com.GymProject.WorkoutTracker.model.workout_sets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.Optional;

public interface ExerciseSchedulesRepository extends
        JpaRepository<exercise_schedules, Integer> {

//    @Query("SELECT ws FROM workout_sets ws WHERE ws.user = :user AND ws.exercise = :exercise AND ws.date = :date")
//    Optional<workout_sets> findByUserAndExerciseAndDate(users user, exercises exercise, Date date);
}
