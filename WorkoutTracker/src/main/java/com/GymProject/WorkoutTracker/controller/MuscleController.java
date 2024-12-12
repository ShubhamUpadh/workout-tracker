package com.GymProject.WorkoutTracker.controller;

import com.GymProject.WorkoutTracker.service.MuscleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MuscleController {

    @Autowired
    MuscleService muscleService;

    @DeleteMapping("/musclesAll")
    public void deleteAllMuscle(){
        muscleService.deleteAll();
    }
}
