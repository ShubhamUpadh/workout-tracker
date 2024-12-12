package com.GymProject.WorkoutTracker.controller;

import com.GymProject.WorkoutTracker.dto.ExerciseRequest;
import com.GymProject.WorkoutTracker.model.exercises;
import com.GymProject.WorkoutTracker.service.CreateExercisesService;
import com.GymProject.WorkoutTracker.service.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseController {

    @Autowired
    ExercisesService exercisesService;

    @GetMapping("/exercises")
    public List<exercises> getExercises(){

        return exercisesService.getExercises();
    }

//    @PostMapping("/exercises")
//    public exercises addExercises(@RequestBody exercises exercise){
//        System.out.println("Recieved  - " + exercise);
//        return exercisesService.addExercises(exercise);
//    }

    @Autowired
    CreateExercisesService createExercisesService;

    @PostMapping("/exercises")
    public exercises addExercises(@RequestBody ExerciseRequest exerciseRequest){
        System.out.println("Received" + exerciseRequest.toString());
        return createExercisesService.createExercises(exerciseRequest);
    }

    @PostMapping("/exercisesList")
    public List<exercises> addMultipleExercises(@RequestBody List<ExerciseRequest> exerciseRequests){
        return createExercisesService.createExercisesList(exerciseRequests);
    }

    @DeleteMapping("/exercisesAll")
    public void deleteAllExercises(){
        exercisesService.deleteAllExercise();
    }

}
