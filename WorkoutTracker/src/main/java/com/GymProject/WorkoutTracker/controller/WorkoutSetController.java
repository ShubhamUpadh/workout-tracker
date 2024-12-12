package com.GymProject.WorkoutTracker.controller;

import com.GymProject.WorkoutTracker.dto.WorkoutSetRequest;
import com.GymProject.WorkoutTracker.model.workout_sets;
import com.GymProject.WorkoutTracker.service.CreateWorkoutSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutSetController {

    @Autowired
    CreateWorkoutSetService createWorkoutSetService;

    @PostMapping("/addWorkoutSet")
    public workout_sets addWorkoutSet(@RequestBody WorkoutSetRequest workoutSetRequest){
        return createWorkoutSetService.addWorkoutSet(workoutSetRequest);
    }
}
