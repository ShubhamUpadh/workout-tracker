package com.GymProject.WorkoutTracker.service;

import com.GymProject.WorkoutTracker.dto.ExerciseRequest;
import com.GymProject.WorkoutTracker.model.exercises;
import com.GymProject.WorkoutTracker.model.muscle_targeted;
import com.GymProject.WorkoutTracker.repository.ExercisesRepository;
import com.GymProject.WorkoutTracker.repository.MuscleTargetedRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateExercisesService {
    @Autowired
    private ExercisesRepository exercisesRepository;
    @Autowired
    private MuscleTargetedRepository muscleTargetedRepository;

    public exercises createExercises(ExerciseRequest exerciseRequest){
        // Step 1: Create the Exercise entity
        exercises Exercise = new exercises(exerciseRequest.getExercise_name(), exerciseRequest.getType(), exerciseRequest.getDescription());

        // Step 2: Save the Exercise entity to the database (this will auto-generate the id)
        exercises savedExercise = exercisesRepository.save(Exercise);

        // Step 3: Split the muscles from the request
        String[] muscles = exerciseRequest.getMuscle_name().split(",");

        // Step 4: For each muscle, create a muscle_targeted entity and associate it with the saved exercise
        for (String muscle : muscles) {
            // Step 4.1: Create the muscle_targeted entity with the saved exercise
            muscle_targeted muscleTargeted = new muscle_targeted(savedExercise, muscle);

            // Step 4.2: Save the muscle_targeted entity, this will automatically generate the ID
            muscleTargetedRepository.save(muscleTargeted);
        }

        // Step 5: Return the saved exercise
        return savedExercise;
        }



    public List<exercises> createExercisesList(List<ExerciseRequest> exerciseRequests) {
        List<exercises> ExerciseList = new ArrayList<>();
        for (ExerciseRequest exerciseRequest : exerciseRequests){
            ExerciseList.add(createExercises(exerciseRequest));
        }
        return ExerciseList;
    }
}
