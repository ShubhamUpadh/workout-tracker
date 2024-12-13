package com.GymProject.WorkoutTracker.controller;

import com.GymProject.WorkoutTracker.dto.WorkoutSetRequest;
import com.GymProject.WorkoutTracker.model.workout_sets;
import com.GymProject.WorkoutTracker.service.CreateWorkoutSetService;
import com.GymProject.WorkoutTracker.service.GetWorkoutSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkoutSetController {

    @Autowired
    CreateWorkoutSetService createWorkoutSetService;

    @Autowired
    GetWorkoutSetService getWorkoutSetService;

    @PostMapping("/addWorkoutSet")
    public workout_sets addWorkoutSet(@RequestBody WorkoutSetRequest workoutSetRequest){
        return createWorkoutSetService.addWorkoutSet(workoutSetRequest);
    }

    @GetMapping("/getWorkoutSet")
    public List<WorkoutSetRequest> getWorkoutSet(){
        return getWorkoutSetService.getAllWorkouts();
    }

    @GetMapping("/getWorkoutSetByUser/{id}")
    public List<WorkoutSetRequest> getWorkoutSetByUserId(@PathVariable int id){
        return getWorkoutSetService.getAllWorkoutsByUserId(id);
    }

}
