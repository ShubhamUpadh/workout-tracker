package com.GymProject.WorkoutTracker.service;
import com.GymProject.WorkoutTracker.model.*;
import com.GymProject.WorkoutTracker.dto.SchedulePostRequest;
import com.GymProject.WorkoutTracker.model.schedules;
import com.GymProject.WorkoutTracker.repository.ExerciseSchedulesRepository;
import com.GymProject.WorkoutTracker.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddScheduleService {


    @Autowired
    UserService userService;

    @Autowired
    SchedulesRepository schedulesRepository;

    @Autowired
    ExercisesService exercisesService;
    @Autowired
    ExerciseSchedulesRepository exerciseSchedulesRepository;

    @Transactional
    public schedules AddSchedule(SchedulePostRequest request){
        //Our DTO will contain user_id, day_of_week,list_of_exercise_id, schedule_name, list_of_sets
        //Save the user_id, day_of_Week, schedule_name to schedules table, get the id
        //Use this id to populate the exercise_schedules table

        // 0. Check if the sets and exercise_id are equal
        if (request.getSets().size() != request.getExercise_id().size()){
            return new schedules(null,"The entered data doesn't have sets for ",
                    " all the included exercise");
        }

        // 1. Check if the exercise_id exists and if exists, create a list of exercise objects
        List<exercises> exercisesList = new ArrayList<>();

        for (int i = 0; i < request.getExercise_id().size(); i++){
            int currExID = request.getExercise_id().get(i);
            Optional<exercises> currEx = exercisesService.findExerciseById((long) currExID);

            if (currEx.isEmpty()){
                return new schedules(null,"Exercise ID doesn't exist for ",
                        currExID + " input");
            }

            exercisesList.add(currEx.get());
        }

        // 2. Fetch the user corresponding to user_id

        Optional<users> usersOptional = userService.findUserById(request.getUser_id());
        if (usersOptional.isEmpty()){
            return new schedules(null,"User Not Found",
                    "For this user id -" + request.getUser_id());
        }
        // 3. Ensure that the combination of user_id, day_of_Week and schedule_name is unique


        // 4. Using the user object, create an entry in schedules table
        schedules Schedules = new schedules();
        Schedules.setUsers(usersOptional.get());
        Schedules.setDay_of_week(request.getDay_of_week());
        Schedules.setSchedule_name(request.getSchedule_name());

        schedules savedSchedule = schedulesRepository.save(Schedules);

        // 5. Using the id of the savedSchedules, create entries in exercise_Schedule_table
        List<exercise_schedules> exerciseSchedulesList = new ArrayList<>();
        for (int i = 0; i < request.getSets().size(); i++){
            exercise_schedules exerciseSchedules = new exercise_schedules();
            exerciseSchedules.setSets(request.getSets().get(i));
            exerciseSchedules.setSchedules(savedSchedule);
            exerciseSchedules.setExercises(exercisesList.get(i));
            exerciseSchedulesRepository.save(exerciseSchedules);
        }

        return savedSchedule;
    }

}
