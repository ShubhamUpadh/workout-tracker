package com.GymProject.WorkoutTracker.controller;

import com.GymProject.WorkoutTracker.dto.ExerciseRequest;
import com.GymProject.WorkoutTracker.model.exercises;
import com.GymProject.WorkoutTracker.service.CreateExercisesService;
import com.GymProject.WorkoutTracker.service.ExercisesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseController {

    @Autowired
    ExercisesService exercisesService;


    @Operation(summary = "Get all workouts", description = "Retrieve all workout details")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved workouts")
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

    @Operation(summary = "Add an exercise ", description = "Inserts data into exercises and muscle_targeted tables")
    @ApiResponse(responseCode = "200", description = "Successfully Added Exercises")
    @PostMapping("/exercises")
    public exercises addExercises(@RequestBody ExerciseRequest exerciseRequest){
        System.out.println("Received" + exerciseRequest.toString());
        return createExercisesService.createExercises(exerciseRequest);
    }
    @Operation(summary = "Add multiple exercises", description = "Inserts multiple entries into exercises and muscle_targeted table")
    @ApiResponse(responseCode = "200", description = "Successfully added data to the tables")
    @PostMapping("/exercisesList")
    public List<exercises> addMultipleExercises(@RequestBody List<ExerciseRequest> exerciseRequests){
        return createExercisesService.createExercisesList(exerciseRequests);
    }

    @DeleteMapping("/exercisesAll")
    public void deleteAllExercises(){
        exercisesService.deleteAllExercise();
    }

}
