package com.GymProject.WorkoutTracker.service;

import com.GymProject.WorkoutTracker.dto.WorkoutSetRequest;
import com.GymProject.WorkoutTracker.model.exercises;
import com.GymProject.WorkoutTracker.model.performances;
import com.GymProject.WorkoutTracker.model.users;
import com.GymProject.WorkoutTracker.model.workout_sets;
import com.GymProject.WorkoutTracker.repository.PerformanceRepository;
import com.GymProject.WorkoutTracker.repository.WorkoutSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateWorkoutSetService {

    @Autowired
    UserService userService;

    @Autowired
    ExercisesService exercisesService;

    @Autowired
    WorkoutSetRepository workoutSetRepository;

    @Autowired
    PerformanceRepository performanceRepository;




    public workout_sets addWorkoutSet(WorkoutSetRequest workoutSetRequest) {
        Optional<users> user = userService.findUserById(workoutSetRequest.getUser_id());
        if (user.isEmpty()) throw new IllegalArgumentException("Invalid user id" + workoutSetRequest.getUser_id());

        Optional<exercises> exercise = exercisesService.findExerciseById(workoutSetRequest.getExercise_id());
        if (exercise.isEmpty()) throw new IllegalArgumentException("Invalid exercise id" + workoutSetRequest.getExercise_id());


        workout_sets workout_Sets = new workout_sets(user.get(),exercise.get(),workoutSetRequest.getDate());

        workout_sets saved_workout_Sets = workoutSetRepository.save(workout_Sets);


        performances Performance = new performances(saved_workout_Sets,workoutSetRequest.getSet_no(),workoutSetRequest.getWeight(),workoutSetRequest.getReps());

        performances saved_performance = performanceRepository.save(Performance);

        return saved_workout_Sets;


    }
}
