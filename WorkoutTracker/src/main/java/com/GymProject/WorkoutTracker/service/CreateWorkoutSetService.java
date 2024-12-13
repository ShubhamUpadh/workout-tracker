package com.GymProject.WorkoutTracker.service;

import com.GymProject.WorkoutTracker.dto.WorkoutSetRequest;
import com.GymProject.WorkoutTracker.model.exercises;
import com.GymProject.WorkoutTracker.model.performances;
import com.GymProject.WorkoutTracker.model.users;
import com.GymProject.WorkoutTracker.model.workout_sets;
import com.GymProject.WorkoutTracker.repository.PerformanceRepository;
import com.GymProject.WorkoutTracker.repository.WorkoutSetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
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

        //Check if the workoutSetRequest already exists
        //Check if the corresponding entry exists in workout_sets
        //If it does, then search for corresponding entries in performance -> workout_set_id, set_no
        //If found @ performance, edit the entry in performance
        //If it doesn't exist in workout_set, then simply add to both tables
        // If it exists in workout_set, then simply add to performance

        Optional<workout_sets> existingWorkoutSet = workoutSetRepository.
                findByUserAndExerciseAndDate(user.get(),exercise.get(),workoutSetRequest.getDate());

        if (existingWorkoutSet.isPresent()){
            workout_sets existingSet = existingWorkoutSet.get();

            Optional<performances> existingPerformances = performanceRepository.
                    findByWorkoutSetAndSetNo(existingSet, workoutSetRequest.getSet_no());

            if (existingPerformances.isPresent()){

                performances oldPerformances = existingPerformances.get();
                oldPerformances.setWeight(workoutSetRequest.getWeight());
                oldPerformances.setReps(workoutSetRequest.getReps());

                performances editedPerformance =  performanceRepository.save(oldPerformances);
                return existingSet;
            }

            else{
                performances newPerformance = new performances(existingSet, workoutSetRequest.getSet_no()
                        , workoutSetRequest.getWeight(), workoutSetRequest.getReps());
                performances saved_performances = performanceRepository.save(newPerformance);
                return existingSet;
            }
        }
        else {

            workout_sets workout_Sets = new workout_sets(user.get(),exercise.get(),workoutSetRequest.getDate());


            workout_sets saved_workout_Sets = workoutSetRepository.save(workout_Sets);


            performances Performance = new performances(saved_workout_Sets,workoutSetRequest.getSet_no(),workoutSetRequest.getWeight(),workoutSetRequest.getReps());

            performances saved_performance = performanceRepository.save(Performance);

            return saved_workout_Sets;
        }


    }
}
