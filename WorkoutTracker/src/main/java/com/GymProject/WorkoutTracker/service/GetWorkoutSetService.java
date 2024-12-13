package com.GymProject.WorkoutTracker.service;

import com.GymProject.WorkoutTracker.dto.WorkoutSetRequest;
import com.GymProject.WorkoutTracker.model.exercises;
import com.GymProject.WorkoutTracker.model.performances;
import com.GymProject.WorkoutTracker.model.workout_sets;
import com.GymProject.WorkoutTracker.repository.PerformanceRepository;
import com.GymProject.WorkoutTracker.repository.WorkoutSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GetWorkoutSetService {

    private WorkoutSetRepository workoutSetRepository;
    private PerformanceRepository performanceRepository;
//    private exercises exercise;
//    private workout_sets workout_set;

    @Autowired
    public GetWorkoutSetService(WorkoutSetRepository workoutSetRepository, PerformanceRepository performanceRepository)
     {
         //exercises exercise, workout_sets workout_set)
         this.workoutSetRepository = workoutSetRepository;
        this.performanceRepository = performanceRepository;
//        this.exercise =exercise;
//        this.workout_set = workout_set;

    }


    public List<WorkoutSetRequest> getAllWorkouts() {
        List<performances> performancesList = performanceRepository.findAll();
        List<workout_sets> workoutSetsList = workoutSetRepository.findAll();

        List<WorkoutSetRequest> workoutSetRequests = new ArrayList<>();

        for (performances performance : performancesList){
            Optional<workout_sets> matchingWorkoutSet = workoutSetsList.stream()
                    .filter(workoutSet -> workoutSet.getId() == performance.getWorkout_Sets().getId())
                    .findFirst();

            if (matchingWorkoutSet.isPresent()){
                workout_sets workoutSets = matchingWorkoutSet.get();
                WorkoutSetRequest currRequest = new WorkoutSetRequest();

                currRequest.setUser_id(workoutSets.getUser().getId());
                currRequest.setExercise_id(workoutSets.getExercise().getId());
                currRequest.setDate(workoutSets.getDate());
                currRequest.setSet_no(performance.getSet_no());
                currRequest.setWeight(performance.getWeight());
                currRequest.setWeight(performance.getWeight());

                workoutSetRequests.add(currRequest);
            }
        }
        return workoutSetRequests;

    }
}
